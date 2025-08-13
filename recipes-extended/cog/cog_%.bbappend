DEPENDS:remove = "systemd"

EXTRA_OEMESON += "-Dcog_dbus_control=system"

PACKAGES += "${PN}-dbus"
FILES_${PN}-dbus += "${datadir}/dbus-1"
