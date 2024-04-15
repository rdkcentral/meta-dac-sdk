RDEPENDS_${PN}_remove_rpi = "${@bb.utils.contains('MACHINE_FEATURES', 'vc4graphics', '', 'userland', d)}"
EXTRA_OECMAKE += "-DCRYPTOGRAPHY=ON -DCRYPTOGRAPHY_IMPLEMENTATION=OpenSSL -DSECURITYUTILITY=ON"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://0010-fix-module-h-cryptography.patch"

# fix for missing mkdir inside meta-rdk-netflix/recipes-extended/wpeframework-clientlibraries/wpeframework-clientlibraries_git.bbappend
do_install_prepend() {
    install -d ${D}/usr/include/opencdm
}

RDEPENDS_${PN}_remove = "rdkperf"
