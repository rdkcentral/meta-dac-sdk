DEPENDS:remove = "wpewebkit"
DEPENDS:append = " wpe-webkit"
DEPENDS:append = " libwpe"

RDEPENDS:${PN}:remove = "wpewebkit (>= 2.36)"
RDEPENDS:${PN}:append = " wpe-webkit"
RDEPENDS:${PN}:remove = "virtual/wpebackend"

PACKAGECONFIG:append = "${@bb.utils.contains('DISTRO_FEATURES', 'enable_libsoup3', '', ' soup2', d)}"
DEPENDS:remove = "${@bb.utils.contains('DISTRO_FEATURES', 'enable_libsoup3', '', 'libsoup', d)}"

PACKAGECONFIG:append = " dbus"
EXTRA_OEMESON:append = " -Dplatforms="
