DEPENDS += "rialto-ocdm-link"

RDEPENDS:${PN} += "rialto-gstreamer"
RDEPENDS:${PN} += "gstreamer1.0-plugins-base-audioresample"
RDEPENDS:${PN} += "gstreamer1.0-plugins-base-audioconvert"
RDEPENDS:${PN} += "gstreamer1.0-plugins-base-typefindfunctions"
RDEPENDS:${PN} += "gstreamer1.0-plugins-good-autodetect"

DEPENDS:remove = "virtual/vendor-secapi2-adapter"
DEPENDS:remove = "virtual/vendor-gst-drm-plugins"

CXXFLAGS:append = " -Wno-format-truncation"
CXXFLAGS:append = " -Wno-unused-result"
CXXFLAGS:append = " -Wno-stringop-truncation"
