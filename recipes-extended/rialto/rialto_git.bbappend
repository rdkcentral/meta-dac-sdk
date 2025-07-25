DEPENDS:remove = "wpeframework-clientlibraries"
DEPENDS:remove = "virtual/vendor-rdk-gstreamer-utils-platform"
DEPENDS += "wpeframework-ocdm-headers"

# disable server parts
PACKAGECONFIG:remove = "server"
PACKAGECONFIG:remove = "servermanager"

RDEPENDS:${PN}:remove = "mongoose"
RDEPENDS:${PN}-server:remove= "virtual/vendor-rdk-gstreamer-utils-platform"
RDEPENDS:${PN}-servermanager-lib:remove= "virtual/vendor-rdk-gstreamer-utils-platform"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI += "file://0001-Remove-wrappers-from-compilation.patch"
