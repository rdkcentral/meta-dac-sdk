DEPENDS:remove = "wpewebkit"
DEPENDS += "${@bb.utils.contains('PACKAGECONFIG', 'webkitgtk', '', 'wpe-webkit', d)}"

RDEPENDS_${PN}:remove = "wpewebkit (>= 2.28)"
RDEPENDS_${PN} += "wpe-webkit"

RDEPENDS_${PN}:remove = "virtual/wpebackend"
RDEPENDS_${PN} += "wpe-backend-rdk"
