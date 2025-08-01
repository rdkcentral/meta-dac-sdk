FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI:append = " file://0002-cog-lifecycle.patch"

DEPENDS:append = " dbus"
DEPENDS:remove = "systemd"

EXTRA_OEMESON = "-Dplatforms= -Dcog_dbus_control=system"

FILES_${PN} += "${datadir}/dbus-1"
