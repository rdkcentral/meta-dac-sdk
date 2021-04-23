LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"
SUMMARY = "Create essos library containing stub implementation for essos-app interface"

DEPENDS = "wayland virtual/egl"

inherit autotools pkgconfig

SRC_URI += " \
    file://essos.cpp \
    file://essos-app.h \
    file://configure.ac \
    file://Makefile.am \
    file://LICENSE"

S = "${WORKDIR}"
