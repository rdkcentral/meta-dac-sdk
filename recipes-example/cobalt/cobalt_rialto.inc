DEPENDS += "rialto-ocdm"
RDEPENDS_${PN} += "rialto-gstreamer"
RDEPENDS_${PN} += "gstreamer1.0-plugins-base-audioresample"
RDEPENDS_${PN} += "gstreamer1.0-plugins-base-audioconvert"
RDEPENDS_${PN} += "gstreamer1.0-plugins-base-typefindfunctions"
RDEPENDS_${PN} += "gstreamer1.0-plugins-good-autodetect"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://0001-ocdmrialto.patch;patchdir=../starboard"
