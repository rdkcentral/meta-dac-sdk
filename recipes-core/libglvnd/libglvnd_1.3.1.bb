# Note: This can be used together with other packages e.g. broadcom-refsw
# to produce portable executables. Those which, as per Khronos guidelines
# (https://www.khronos.org/registry/implementers_guide.html#libnames),
# will depends on the following libraries:
#   - libGLESv2.so.2
#   - libEGL.so.1
#
# Example:
# $ readelf -d wayland-egl  | grep NEEDED
# 0x0000000000000001 (NEEDED)             Shared library: [libwayland-egl.so.1]
# 0x0000000000000001 (NEEDED)             Shared library: [libwayland-client.so.0]
# 0x0000000000000001 (NEEDED)             Shared library: [libGLESv2.so.2]
# 0x0000000000000001 (NEEDED)             Shared library: [libEGL.so.1]
# 0x0000000000000001 (NEEDED)             Shared library: [libc.so.6]
#

SUMMARY          = "The GL Vendor-Neutral Dispatch library"

DESCRIPTION      = "libglvnd is a vendor-neutral dispatch layer for arbitrating OpenGL API calls \
between multiple vendors. It allows multiple drivers from different vendors to \
coexist on the same filesystem, and determines which vendor to dispatch each \
API call to at runtime. \
Both GLX and EGL are supported, in any combination with OpenGL and OpenGL ES. \
\
libglvnd was originally described in Andy Ritger's OpenGL ABI proposal [1] \
\
[1] https://github.com/aritger/linux-opengl-abi-proposal/blob/master/linux-opengl-abi-proposal.txt \
"

HOMEPAGE         = "https://gitlab.freedesktop.org/glvnd/libglvnd"
BUGTRACKER       = "https://bugs.freedesktop.org"
SECTION          = "x11"

SRC_URI          = "https://gitlab.freedesktop.org/glvnd/libglvnd/-/archive/v${PV}/libglvnd-v${PV}.tar.bz2"
SRC_URI[md5sum]  = "e2b50d2b428a9f164ef68b6aeee9205f"
# Patch to disable X11 headers lookup
SRC_URI         += "${@bb.utils.contains('DISTRO_FEATURES', 'x11', \
                   '', 'file://0001-Do-not-use-X11-headers-by-default.patch', d)}"

PR               = "r1"

LICENSE          = "MIT"
LIC_FILES_CHKSUM = "file://README.md"
# libglvnd main license (excluding components listed below)
LIC_FILES_CHKSUM_append = ";beginline=327;endline=352;md5=ee3db672533fd807fc44edf5c6932553"
# libglvnd contains list.h, a linked list implementation from the X.Org project.
LIC_FILES_CHKSUM_append = ";beginline=363;endline=383;md5=518e703e224ecbcc49ffadc95e3a9d83"
# libglvnd contains code from the Mesa project
LIC_FILES_CHKSUM_append = ";beginline=394;endline=411;md5=188f08faf892572f4a313521b96ac3ae"
# libglvnd uses the hash table implementation 'uthash'
LIC_FILES_CHKSUM_append = ";beginline=421;endline=441;md5=e997639cdaac5cd71693cbadbc3e1256"
# libglvnd uses the buildconf autotools bootstrapping script 'autogen.sh'
LIC_FILES_CHKSUM_append = ";beginline=451;endline=480;md5=f01159d8d3b3053aa8461511a789a1a4"
# libglvnd uses the `AX_PTHREAD` autoconf macro for detecting pthreads.
LIC_FILES_CHKSUM_append = ";beginline=487;endline=514;md5=e2c3384f49302f6d2aa88705b4e96b41"
# libglvnd uses the cJSON library for reading JSON files
LIC_FILES_CHKSUM_append = ";beginline=512;endline=540;md5=5da5d1decd5e8df09d57c7f9d50d5231"

MAINTAINER       = "Damian Wrobel <dwrobel@ertelnet.rybnik.pl>"

S                = "${WORKDIR}/${PN}-v${PV}"

DEPENDS          = "python3-native"

PROVIDES         = "${@bb.utils.contains('DISTRO_FEATURES', 'libglvnd-as-stubs-provider', '', \
                       'virtual/mesa virtual/egl virtual/libgl virtual/libgles1 virtual/libgles2', d)}"
RPROVIDES_${PN}  = "${@bb.utils.contains('DISTRO_FEATURES', 'libglvnd-as-stubs-provider', '', \
                       'mesa egl libgl libgles1 libgles2', d)}"

BBCLASSEXTEND    = "native"

inherit autotools pkgconfig 

# If enabled, it will install only stubs (for the linking process)
# In practise, it will only generate development (-dev) sub-package.
PACKAGECONFIG[stubs_only] = ",,"
PACKAGECONFIG[asm]        = ",--disable-asm,"
PACKAGECONFIG[glx]        = ",--disable-glx,glproto"
# PACKAGECONFIG[headers]    = ",--disable-headers,"
PACKAGECONFIG[tls]        = ",--disable-tls,"
# Disabling X11 support also implies --disable-glx
PACKAGECONFIG[x11]        = ",--disable-x11,X11"
# If disabled then everything related to GL is not installed.
# It is useful for EGL/GLES only platforms.
PACKAGECONFIG[opengl]     = ",,"

#PACKAGECONFIG ??= "${@bb.utils.contains('DISTRO_FEATURES', 'libglvnd-as-stubs-provider', 'stubs_only', '', d)} \
#                   asm tls ${@bb.utils.filter('DISTRO_FEATURES', 'x11', d)}"

do_install_append() {
    # If enabled, it will install only stubs (for the linking process)
    # In practise, it will only generate development (-dev) sub-package.
    if ${@bb.utils.contains('PACKAGECONFIG', 'stubs_only', 'true', 'false', d)}; then
        # Remove all static libraries
	rm -f ${D}${libdir}/*.la

	# Remove all pkgconfig files
	rm -rf "${D}${libdir}/pkgconfig"

        # Remove all symlinks
        find "${D}${libdir}/" -path "${D}${libdir}/*.so*" -type l -exec rm -f {} \;

	# Strip versioning from the shared libraries
        # so they become development libraries (those used for linking process).
	for so_path in $(find "${D}${libdir}/" -path "${D}${libdir}/*.so.*"); do
	    so_devel_path="${so_path/%\.so.*/.so}"
	    mv "${so_path}" "${so_devel_path}"
	done
    fi

    # If disabled then everything related to GL is not installed.
    if ${@bb.utils.contains('PACKAGECONFIG', 'opengl', 'false', 'true', d)}; then
	rm -rf ${D}${includedir}/GL
	rm -f  ${D}${libdir}/libOpenGL*
	rm -f  ${D}${libdir}/pkgconfig/opengl.pc
    fi
}

# On stubs_only mode we do not install any files
FILES_${PN}            = "${@bb.utils.contains('DISTRO_FEATURES', 'libglvnd-as-stubs-provider', \
                         '', '${libdir}/*.so.*', d)}"
FILES_${PN}-dev        = "${@bb.utils.contains('DISTRO_FEATURES', 'libglvnd-as-stubs-provider', \
                         '', '${includedir} ${libdir}/pkgconfig ${libdir}/*.so', d)}"

INSANE_SKIP_${PN}     += "${@bb.utils.contains('DISTRO_FEATURES', 'libglvnd-as-stubs-provider', \
                         'installed-vs-shipped', '', d)}"
