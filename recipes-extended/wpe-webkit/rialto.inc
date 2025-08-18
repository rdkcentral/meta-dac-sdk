DEPENDS += "rialto-ocdm"
DEPENDS += "rialto-ocdm-link"
DEPENDS:remove = "wpeframework-clientlibraries"
DEPENDS:remove = "westeros"
DEPENDS:remove = "westeros-sink"

RDEPENDS:${PN} += "rialto-gstreamer"

PACKAGECONFIG += "wpeframework_opencdm"
PACKAGECONFIG += "westeros"
