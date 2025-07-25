DEPENDS:remove = "wpeframework-clientlibraries"
DEPENDS += "wpeframework-ocdm-headers"

# disable server parts
PACKAGECONFIG:remove = "server"
PACKAGECONFIG:remove = "servermanager"

RDEPENDS:${PN}:remove = "mongoose"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI += "file://0001-Remove-wrappers-from-compilation.patch"
