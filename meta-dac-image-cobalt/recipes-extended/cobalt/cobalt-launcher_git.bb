SUMMARY = "Cobalt launcher"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=256a42cf309d3ab8e25f221ae777f5cb"

inherit cmake pkgconfig

SRC_URI = "git://code.rdkcentral.com/r/rdk/components/generic/cobalt-launcher;protocol=https;branch=master"
# Sep 10, 2025
SRCREV = "0c64e455a42ad8b51cb4c09e945c434f04eb8bc8"

S = "${WORKDIR}/git"

DEPENDS = "jsoncpp rpcserver jansson"

PACKAGECONFIG ??= ""
PACKAGECONFIG:append = " ${@bb.utils.contains('DISTRO_FEATURES', 'cobalt_enable_evergreen_lite', 'evergreenlite', 'evergreenfull', d)}"

PACKAGECONFIG[evergreenlite]  = \
    "-DWSRPC_COBALT_EVERGREEN_LITE=ON, \
     -DWSRPC_COBALT_EVERGREEN_LITE=OFF, \
     libloader-app,virtual/cobalt-evergreen"

PACKAGECONFIG[evergreenfull] = ",,libloader-app,virtual/cobalt-evergreen"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 cobalt-launcher ${D}${bindir}/
}

FILES:${PN} = "${bindir}/*"
