DEPENDS += "rialto-ocdm"
RDEPENDS_${PN} += "rialto-gstreamer"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://0001-ocdmrialto.patch;patchdir=../starboard"
