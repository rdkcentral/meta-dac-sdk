FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_remove = "${RDK_GENERIC_ROOT_GIT}/gstreamer-netflix-platform/generic;protocol=${RDK_GIT_PROTOCOL};branch=${RDK_GIT_BRANCH}"
SRC_URI += "${CMF_GIT_ROOT}/rdk/components/opensource/gstreamer-direct-platform;protocol=${CMF_GIT_PROTOCOL};branch=${CMF_GIT_BRANCH}"

RDEPENDS_${PN} += "rialto-gstreamer"

SRC_URI += "file://0012-add-rialto.patch;patchdir=${WORKDIR}/git"
EXTRA_OEMAKE+= "PLATFORM_SOC=RIALTO"
EXTRA_OEMAKE+= "RIALTO_AUDIODECODER=rialtowebaudiosink"
EXTRA_OEMAKE+= "RIALTO_BUFFERUNDERFLOW_SIGNAL=buffer-underflow-callback"
EXTRA_OEMAKE+= "RIALTO_VIRTUALDISPLAY_HEIGHT=1080"
EXTRA_OEMAKE+= "RIALTO_VIRTUALDISPLAY_WIDTH=1920"
