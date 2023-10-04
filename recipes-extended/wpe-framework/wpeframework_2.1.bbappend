SRC_URI_remove = "git://github.com/rdkcentral/Thunder.git;protocol=git;branch=R2;name=thunder"
SRC_URI += "git://github.com/rdkcentral/Thunder.git;protocol=https;branch=R2;name=thunder"

RDEPENDS_${PN}_remove_rpi = "${@bb.utils.contains('DISTRO_FEATURES', 'vc4graphics', '', 'userland', d)}"
RDEPENDS_${PN}_remove_rpi = "userland"

DEPENDS_remove = "breakpad-wrapper"
DEPENDS_remove = "rfc"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://0001-remove-deps.patch"
