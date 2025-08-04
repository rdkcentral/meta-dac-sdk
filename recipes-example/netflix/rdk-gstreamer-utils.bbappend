LIC_FILES_CHKSUM = "file://LICENSE;md5=175792518e4ac015ab6696d16c4f607e"
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_remove = "${CMF_GITHUB_ROOT}/gstreamer-netflix-platform;${CMF_GITHUB_SRC_URI_SUFFIX}"
SRC_URI += "${CMF_GIT_ROOT}/rdk/components/opensource/gstreamer-direct-platform;protocol=${CMF_GIT_PROTOCOL};branch=${CMF_GIT_BRANCH}"
SRCREV ?= "${AUTOREV}"

RDEPENDS_${PN} += "rialto-gstreamer"
DEPENDS:remove= " virtual/vendor-audio-service "

SRC_URI += "file://0012-add-rialto.patch;patchdir=${WORKDIR}/git"
EXTRA_OEMAKE+= "PLATFORM_SOC=RIALTO"
EXTRA_OEMAKE+= "RIALTO_AUDIODECODER=rialtowebaudiosink"
EXTRA_OEMAKE+= "RIALTO_BUFFERUNDERFLOW_SIGNAL=buffer-underflow-callback"
EXTRA_OEMAKE+= "RIALTO_VIRTUALDISPLAY_HEIGHT=1080"
EXTRA_OEMAKE+= "RIALTO_VIRTUALDISPLAY_WIDTH=1920"
