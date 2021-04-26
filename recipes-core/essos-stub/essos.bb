LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://essos-app.h;endline=18;md5=771c2af5dc200fc631e6b90a0488fd4d"
SUMMARY = "Create essos library containing stub implementation for essos-app interface"

DEPENDS = "wayland virtual/egl"

inherit autotools pkgconfig

SRC_URI += " \
    file://essos.cpp \
    file://essos-app.h \
    file://configure.ac \
    file://Makefile.am"

S = "${WORKDIR}"
