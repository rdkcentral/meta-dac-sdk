PACKAGECONFIG += "opencdm"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://0003_skip_codec_checks.patch;patchdir=../larboard"
SRC_URI += "file://0004-enable-vp9.patch;patchdir=../larboard"

### to remove all wpeframework deps
#DEPENDS_remove = "wpeframework-clientlibraries"
#PACKAGECONFIG_remove = "cryptography"
#PACKAGECONFIG_remove = "securityagent"
#SRC_URI += "file://0006_Remove_Thunder.patch;patchdir=${WORKDIR}/starboard"
###
