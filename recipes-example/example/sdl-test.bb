SUMMARY = "Example SDL test application"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

DEPENDS = "virtual/libgles2 virtual/libsdl2"

S = "${WORKDIR}/git/sdl-test"

SRC_URI = " \
    git://github.com/stagingrdkm/dac-examples-src.git;protocol=http;branch=master;rev=3680c2868ad7d26a14c9cc2ea60fc5f8dd9d7de1 \
"


inherit autotools pkgconfig

TEST_NAME         = "sdl-test"

TARGET_CC_ARCH    += "${LDFLAGS}"

do_compile () {
  cd ${S}
  ${CXX} ${TARGET_CXXFLAGS}              -o ${TEST_NAME}       main.cpp    $(pkg-config --cflags --libs       glesv2 sdl2)
}

do_install() {
  install -p -m 0755 -D ${S}/${TEST_NAME}         ${D}${bindir}/${TEST_NAME}
}

FILES_${PN} += "${bindir}/*"

