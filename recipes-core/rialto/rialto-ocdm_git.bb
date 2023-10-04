SUMMARY = "Rialto-ocdm"
LICENSE  = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1fa88b316b1ce25ab7d95ae4d854ec8f"

SRC_URI = "${CMF_GITHUB_ROOT}/rialto-ocdm;protocol=${CMF_GIT_PROTOCOL};branch=${CMF_GITHUB_MASTER_BRANCH}"
SRCREV = "${AUTOREV}"

DEPENDS = "glib-2.0 gstreamer1.0 gstreamer1.0-plugins-base wpeframework-clientlibraries protobuf protobuf-native rialto"

S = "${WORKDIR}/git"

inherit cmake coverity

