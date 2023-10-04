DEPENDS_remove = "wpeframework-clientlibraries"
DEPENDS += "wpeframework-ocdm-headers"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://0002-remove-ocdm-find.patch"

# 26 Jul 2023
SRCREV = "5823925b0b1f1348284a9b49c36ba518889a929c"
