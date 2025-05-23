RDEPENDS:${PN}:remove_rpi = "${@bb.utils.contains('MACHINE_FEATURES', 'vc4graphics', '', 'userland', d)}"
EXTRA_OECMAKE += "-DCRYPTOGRAPHY=ON -DCRYPTOGRAPHY_IMPLEMENTATION=OpenSSL -DSECURITYUTILITY=ON"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI += "file://0010-fix-module-h-cryptography.patch"

# fix for missing mkdir inside meta-rdk-netflix/recipes-extended/wpeframework-clientlibraries/wpeframework-clientlibraries_git.bbappend
do_install:prepend() {
    install -d ${D}/usr/include/opencdm
}

RDEPENDS:${PN}:remove = "rdkperf"
