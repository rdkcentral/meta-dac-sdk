DEPENDS_remove = "wpeframework-clientlibraries"
DEPENDS += "wpeframework-ocdm-headers"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://0001-remove-wpe.patch"
SRC_URI += "file://0002-remove-ocdm-find.patch"

# 1 Feb 2023
SRCREV = "29dd8901dca49cb97522a79d2ba97700bfa8678e"
