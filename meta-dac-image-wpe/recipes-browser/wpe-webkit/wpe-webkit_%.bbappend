DEPENDS:remove = "westeros"
DEPENDS:remove = "wpeframework-clientlibraries"
DEPENDS:remove = "virtual/vendor-secapi2-adapter"
DEPENDS:remove = "virtual/vendor-westeros-sink"
DEPENDS:remove = "virtual/vendor-gst-drm-plugins"

DEPENDS += "rialto-ocdm-link"
RDEPENDS:${PN} += "rialto-gstreamer"
