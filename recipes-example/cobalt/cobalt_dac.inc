PACKAGECONFIG += "opencdm"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://0003_skip_codec_checks.patch;patchdir=${@'../larboard' if d.getVar('RDK_FLAVOR') == 'rdke' else '../starboard'}"
SRC_URI += "file://0004-enable-vp9.patch;patchdir=${@'../larboard' if d.getVar('RDK_FLAVOR') == 'rdke' else '../starboard'}"

### to remove all wpeframework deps
#DEPENDS_remove = "wpeframework-clientlibraries"
#PACKAGECONFIG_remove = "cryptography"
#PACKAGECONFIG_remove = "securityagent"
#SRC_URI += "file://0006_Remove_Thunder.patch;patchdir=${WORKDIR}/starboard"
###
