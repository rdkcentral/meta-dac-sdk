RDEPENDS:${PN}:remove:rpi = "userland"
RDEPENDS:${PN}:remove = "thunderhangrecovery"

DEPENDS:remove = "breakpad-wrapper"
DEPENDS:remove = "rfc thunderhangrecovery"

DEPENDS += "curl"
PACKAGECONFIG:remove = " sdnotify"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI += "file://0001-remove-deps-4.2.patch"
