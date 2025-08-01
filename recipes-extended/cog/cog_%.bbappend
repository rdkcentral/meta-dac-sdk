FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI:append = " file://0002-cog-lifecycle.patch"

DEPENDS:remove = "systemd"
