RDEPENDS_${PN}_remove_rpi = "userland"
RDEPENDS_${PN} = "thunderhangrecovery"

DEPENDS_remove = "breakpad-wrapper"
DEPENDS_remove = "rfc thunderhangrecovery"

DEPENDS += "curl"
PACKAGECONFIG_remove = " sdnotify"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://0001-remove-deps-4.2.patch"
