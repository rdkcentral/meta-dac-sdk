
SUMMARY = "Chocolate Doom game"
DESCRIPTION = "Chocolate Doom game which is port of DOS game Doom"
LICENSE = "GPL-2.0+"
LIC_FILES_CHKSUM = "file://COPYING.md;md5=60d644347832d2dd9534761f6919e2a6"

DEPENDS = "virtual/libsdl2 libsdl2-mixer libsdl2-net pkgconfig"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

TARGET_CFLAGS     += " -fomit-frame-pointer "

S = "${WORKDIR}/git/"

SRC_URI = " \
    git://github.com/chocolate-doom/chocolate-doom.git;protocol=http;branch=master;rev=a378d0288a77ef8efff439c5e250e82b03e2c502 \
    file://sdl_gl_setattribute.patch \
    file://0001-dont-generate-fonts.patch \
    http://distro.ibiblio.org/pub/linux/distributions/slitaz/sources/packages/d/doom1.wad;sha256sum=1d7d43be501e67d927e415e0b8f3e29c3bf33075e859721816f652a526cac771 \
    "

inherit autotools pkgconfig

do_install_append() {
    install -m 0644 ${WORKDIR}/doom1.wad ${D}${datadir}
}

FILES_${PN} += "${datadir}/*"
