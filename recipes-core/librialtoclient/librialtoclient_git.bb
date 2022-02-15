SUMMARY = "LibRialtoClient"
LICENSE = "CLOSED"

CMF_GIT_PROTOCOL ?= "https"
CMF_GIT_ROOT ?= "git://code.rdkcentral.com/r"

SRC_URI += "\
  ${CMF_GIT_ROOT}/components/generic/avbus-poc;protocol=${CMF_GIT_PROTOCOL};branch=master \
  file://0001_openssl_api_change.patch \
  file://0002_CMakeList_versioning.patch \
"
# 2022-02-09
SRCREV = "eb9f7244cde3f1d3e9de34807e948350d7e340aa"
DEPENDS = "glib-2.0 openssl jsoncpp"
S = "${WORKDIR}/git/rialtoClient"
inherit cmake

EXTRA_OECMAKE += " -DPLATFORM=rdk-llama"
