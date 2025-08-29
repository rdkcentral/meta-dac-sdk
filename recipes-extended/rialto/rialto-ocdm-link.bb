SUMMARY = "Package that switches libocdm references to libocdmRialto"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = "file://ocdm.pc"

DEPENDS += "rialto-ocdm"
DEPENDS += "wpeframework-ocdm-headers"

do_compile[noexec] = "1"
do_configure[noexec] = "1"
do_patch[noexec] = "1"

do_install() {
    install -d ${D}${libdir}
    ln -s -r ${D}${libdir}/libocdmRialto.so.1 ${D}${libdir}/libocdm.so
    install -D -m 0644 ${WORKDIR}/ocdm.pc ${D}${libdir}/pkgconfig/ocdm.pc
}
