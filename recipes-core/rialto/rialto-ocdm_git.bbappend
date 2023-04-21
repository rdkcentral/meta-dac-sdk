DEPENDS_remove = "wpeframework-clientlibraries"
DEPENDS += "wpeframework-ocdm-headers"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://0001-remove-wpe.patch"
SRC_URI += "file://0002-remove-ocdm-find.patch"

# 4 Apr 2023
SRCREV = "4e9fb3955e9b50fa5969f1ada394ed3e1bb439f0"
