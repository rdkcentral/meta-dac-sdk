SUMMARY = "Script for calculating glmark2 score"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${THISDIR}/../../LICENSE;md5=285ec74de8dda33b7e8de1937e972f4f"
RDEPENDS_${PN} += "bash coreutils gawk grep glmark2"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

S = "${WORKDIR}"
SRC_URI += "file://glmark2.sh"

do_compile[noexec] = "1"

do_install() {
  install -p -m 0755 -D ${S}/glmark2.sh ${D}${bindir}/glmark2.sh
}

FILES_${PN} += "${bindir}/*"
