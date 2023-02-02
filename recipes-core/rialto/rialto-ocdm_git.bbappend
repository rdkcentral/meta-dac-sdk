DEPENDS_remove = "wpeframework-clientlibraries"
DEPENDS += "wpeframework-ocdm-headers"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://0001-remove-wpe.patch"
SRC_URI += "file://0002-remove-ocdm-find.patch"

# 29 Dec 2022
SRCREV = "03e55e52f82841bd9ff3b9b87ef7b0c15436f8c8"
