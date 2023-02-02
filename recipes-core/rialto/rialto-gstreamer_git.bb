SUMMARY = "Rialto-gstreamer"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING.LGPL;md5=23c2a5e0106b99d75238986559bb5fc6"

SRC_URI = "${CMF_GITHUB_ROOT}/rialto-gstreamer;protocol=${CMF_GIT_PROTOCOL};branch=${CMF_GITHUB_MASTER_BRANCH}"
SRCREV = "${AUTOREV}"

DEPENDS = "glib-2.0 gstreamer1.0 gstreamer1.0-plugins-base wpeframework-clientlibraries protobuf protobuf-native rialto rialto-ocdm"

S = "${WORKDIR}/git"
inherit cmake coverity

FILES_${PN} += "${libdir}/gstreamer-1.0/libgstrialtosinks.so"
