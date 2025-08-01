FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI:append = " file://0002-cog-lifecycle.patch"
SRC_URI:append = " file://0003-firebolt-platform.patch"

DEPENDS:append = " firebolt-api-cpp dbus"
DEPENDS:remove = "systemd"

EXTRA_OEMESON = "-Dplatforms=firebolt -Dcog_dbus_control=system"

FILES_${PN} += "${datadir}/dbus-1"
