SUMMARY = "ocdmRialto"
LICENSE = "CLOSED"

CMF_GIT_PROTOCOL ?= "https"
CMF_GIT_ROOT ?= "git://code.rdkcentral.com/r"

SRC_URI += "\
  ${CMF_GIT_ROOT}/components/generic/avbus-poc;protocol=${CMF_GIT_PROTOCOL};branch=master \
  file://0001-Remove-Wpe.patch \
  file://0002-Add-OCDM-Headers.patch \
  file://0003-CMake-PackageConfig.patch \
"
# 2022-02-09
SRCREV = "eb9f7244cde3f1d3e9de34807e948350d7e340aa"
DEPENDS = "librialtoclient"
S = "${WORKDIR}/git/ocdmRialto"
inherit cmake

RPROVIDES_${PN} += "libocdmRialto.so"
