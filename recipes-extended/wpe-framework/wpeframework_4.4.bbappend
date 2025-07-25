RDEPENDS:${PN}:remove_rpi = "userland"

DEPENDS:remove = "breakpad-wrapper"
DEPENDS:remove = "rfc"

DEPENDS += "curl"
PACKAGECONFIG:remove = " sdnotify"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI += "file://0001-remove-deps-4.2.patch"
