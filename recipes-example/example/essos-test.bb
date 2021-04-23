LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

DEPENDS = "essos virtual/egl"

SRC_URI = " \
    git://github.com/stagingrdkm/dac-examples-src.git;protocol=http;branch=master;rev=3680c2868ad7d26a14c9cc2ea60fc5f8dd9d7de1 \
"

inherit autotools pkgconfig

S = "${WORKDIR}/git/essos-test/"

