SUMMARY = "QT sample application"
DESCRIPTION = "Simple QT application / wayland EGL subsystem" 
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

inherit pkgconfig

DEPENDS          = " qtbase"
DEPENDS         += " virtual/egl"
DEPENDS         += " virtual/libgles2"
DEPENDS         += " libxkbcommon"
DEPENDS         += " libepoxy"

RDEPENDS_${PN}  += " qtwayland"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

S = "${WORKDIR}/git/qt-egl-test"

SRC_URI = " \
    git://github.com/stagingrdkm/dac-examples-src.git;protocol=http;branch=master;rev=927725b156d7be6ceb98301422a2cb5650ae8cd6 \
"

inherit qmake5

FILES_${PN} += "${bindir}/*"
