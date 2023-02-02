DEPENDS += "rialto-ocdm"
RDEPENDS_${PN}  += "rialto-gstreamer"
DEPENDS += "protobuf3b-native"

PACKAGECONFIG += "opencdm"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://0001-ocdmrialto.patch;patchdir=${WORKDIR}/starboard"
SRC_URI += "file://0002-remove-rfc-api.patch;patchdir=${WORKDIR}/starboard"
SRC_URI += "file://0003_skip_codec_checks.patch;patchdir=${WORKDIR}/starboard"
SRC_URI += "file://0004-enable-vp9.patch;patchdir=${WORKDIR}/starboard"
#SRC_URI += "file://0005-changes-for-wayland.patch"

### to remove all wpeframework deps
#DEPENDS_remove = "wpeframework-clientlibraries"
#PACKAGECONFIG_remove = "cryptography"
#PACKAGECONFIG_remove = "securityagent"
#SRC_URI += "file://0006_Remove_Thunder.patch;patchdir=${WORKDIR}/starboard"
###

do_configure_prepend() {
    # Avoid using precompiled protoc binary blob
    rm -f ${S}/tools/protoc
    ln -s ${STAGING_BINDIR_NATIVE}/protoc ${S}/tools/protoc
}
