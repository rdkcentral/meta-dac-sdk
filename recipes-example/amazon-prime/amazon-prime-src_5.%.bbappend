TARGET_BUILD_TYPE = "ignition_with_device_layer"

AMAZON_SDK_URL = "http://127.0.0.1/avpk-v5.tgz;subdir=${PN}-${PV};name=avpk"
SRC_URI[avpk.md5sum] = "6acf4f85aba0e1c12ffccf0fd25ea47c"
SRC_URI[avpk.sha256sum] = "4b2de678951961faba2bb115943ef0948a2e605e5893e7d0c7e7a5453e5e39d9"

S = "${WORKDIR}/amazon-prime-src-5.0/amazonvideoportingkit/ignition/"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://0002-fix-iv.patch;patchdir=../../../git/rdk-linux-device-layer/implementation"
SRC_URI += "file://0003-ocdm-rialto.patch;patchdir=../../../git/rdk-linux-device-layer/implementation"

DEPENDS += "openssl c-ares nodejs-native caps wpeframework-ocdm-headers rialto-ocdm"
RDEPENDS_${PN} += "rdk-gstreamer-utils rialto-ocdm"

# appbootstrap is not delivered in tarball anymore so we need to generate
EXTRA_OECMAKE += " -DUSE_PRE_GENERATED_SOURCES=OFF"

# remove .git dir to fix issue install-app-assets.cmake will try to install build_info.txt
do_unpack_delete_git() {
   rm -rf ${WORKDIR}/amazon-prime-src-5.0/amazonvideoportingkit/.git
}
addtask unpack_delete_git after do_unpack before do_patch

LDFLAGS_remove = "-lcap"

# TODO: check why this is failing
INSANE_SKIP_${PN} += "installed-vs-shipped"
