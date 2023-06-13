DEPENDS_remove = "wpeframework-clientlibraries"
DEPENDS += "wpeframework-ocdm-headers"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://0001-remove-wpe.patch"
SRC_URI += "file://0002-remove-ocdm-find.patch"

# 30 May 2023
SRCREV = "7505cca1dcfc6bb1402aafd94bbeb7fc6b766313"
