SUMMARY = "Example wayland egl test application"

LICENSE = "Unlicense"
LIC_FILES_CHKSUM = "file://UNLICENSE;md5=7246f848faa4e9c9fc0ea91122d6e680"

DEPENDS =  "virtual/egl virtual/libgles2 libepoxy libxkbcommon"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

S = "${WORKDIR}/git/wayland-egl-test"

SRC_URI = " \
    git://github.com/stagingrdkm/dac-examples-src.git;protocol=http;branch=master;rev=02037873b38f540f6a4b683026791db0f021872c \
"

inherit pkgconfig

TEST_NAME         = "wayland-egl-test"
TEST_NAME_EPOXY   = "wayland-egl-test-epoxy"

INPUT_NAME         = "wayland-egl-test-input"
INPUT_NAME_EPOXY   = "wayland-egl-test-input-epoxy"

TARGET_CFLAGS     += " -O3 -ggdb3"

TARGET_CC_ARCH    += "${LDFLAGS}"

do_compile () {
  cd ${S}
  ${CC} ${TARGET_CFLAGS}              -o ${TEST_NAME}       wayland-egl.c    $(pkg-config --cflags --libs       wayland-client wayland-egl glesv2 egl)
  ${CC} ${TARGET_CFLAGS} -DHAVE_EPOXY -o ${TEST_NAME_EPOXY} wayland-egl.c    $(pkg-config --cflags --libs epoxy wayland-client wayland-egl)

  ${CC} ${TARGET_CFLAGS}              -o ${INPUT_NAME}       wayland-input.c $(pkg-config --cflags --libs       wayland-client wayland-egl glesv2 egl xkbcommon)
  ${CC} ${TARGET_CFLAGS} -DHAVE_EPOXY -o ${INPUT_NAME_EPOXY} wayland-input.c $(pkg-config --cflags --libs epoxy wayland-client wayland-egl            xkbcommon)
}

do_install() {
  install -p -m 0755 -D ${S}/${TEST_NAME}         ${D}${bindir}/${TEST_NAME}
  install -p -m 0755 -D ${S}/${TEST_NAME_EPOXY}   ${D}${bindir}/${TEST_NAME_EPOXY}
  install -p -m 0755 -D ${S}/${INPUT_NAME}        ${D}${bindir}/${INPUT_NAME}
  install -p -m 0755 -D ${S}/${INPUT_NAME_EPOXY}  ${D}${bindir}/${INPUT_NAME_EPOXY}
}

FILES_${PN} += "${bindir}/*"

