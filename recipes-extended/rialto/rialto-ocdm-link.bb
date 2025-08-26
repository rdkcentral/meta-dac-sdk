SUMMARY = "Recipe that provides libocdm link pointing to libocdmRialto"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

DEPENDS += "rialto-ocdm"

do_compile[noexec] = "1"
do_configure[noexec] = "1"
do_patch[noexec] = "1"

do_install() {
    install -d ${D}${libdir}
    ln -s -r ${D}${libdir}/libocdmRialto.so.1 ${D}${libdir}/libocdm.so
}
