FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://glmark2-Add-support-for-LD_PRELOAD-aliasing.patch"
PACKAGECONFIG = "wayland-gles2"
