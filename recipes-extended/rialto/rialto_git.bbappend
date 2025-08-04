DEPENDS_remove = "wpeframework-clientlibraries virtual/vendor-rdk-gstreamer-utils-platform"
DEPENDS += "wpeframework-ocdm-headers"

require rialto_revision.inc

# disable server parts
PACKAGECONFIG_remove = "server"
PACKAGECONFIG_remove = "servermanager"

RDEPENDS_${PN}_remove = "mongoose"
RDEPENDS:${PN}-server:remove= " virtual/vendor-rdk-gstreamer-utils-platform"
RDEPENDS:${PN}-servermanager-lib:remove= " virtual/vendor-rdk-gstreamer-utils-platform"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://0001-Remove-wrappers-from-compilation.patch"
