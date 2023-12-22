SUMMARY = "Script for calculating glmark2 score"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://MIT;md5=5d2ae1e6e0899a54636a0ded167bdd17"

RDEPENDS_${PN} += "bash coreutils gawk grep glmark2"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

S = "${WORKDIR}"
SRC_URI += "file://MIT"
SRC_URI += "file://glmark2.sh"

do_compile[noexec] = "1"

do_install() {
  install -p -m 0755 -D ${S}/glmark2.sh ${D}${bindir}/glmark2.sh
}

FILES_${PN} += "${bindir}/*"
