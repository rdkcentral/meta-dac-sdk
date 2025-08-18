SRC_URI:remove = "git://github.com/rdkcentral/Thunder.git;protocol=git;branch=R4;name=thunder"
SRC_URI += "git://github.com/rdkcentral/Thunder.git;protocol=https;branch=R4;name=thunder"

RDEPENDS:${PN}:remove:rpi = "${@bb.utils.contains('DISTRO_FEATURES', 'vc4graphics', '', 'userland', d)}"
RDEPENDS:${PN}:remove:rpi = "userland"

DEPENDS:remove = "breakpad-wrapper"
DEPENDS:remove = "rfc"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI += "file://0001-remove-deps-4.2.patch"
