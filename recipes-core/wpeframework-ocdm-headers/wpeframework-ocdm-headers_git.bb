SUMMARY = "WPEFramework OCDM headers"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f1dffbfd5c2eb52e0302eb6296cc3711"

SRC_URI = "git://github.com/rdkcentral/ThunderClientLibraries.git;protocol=https;branch=R2;name=wpeframework-clientlibraries"

# Aug 31, 2021
SRCREV = "f69e573984e9f46300eef90dafe81663beb6b8f6"

S = "${WORKDIR}/git"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://0001-add-decrypt-ex.patch"

do_compile[noexec] = "1"

do_install() {
  install -d ${D}${includedir}
  install -d ${D}${includedir}/opencdm
  install -m 0644 ${S}/Source/ocdm/open_cdm.h ${D}${includedir}/opencdm
  install -m 0644 ${S}/Source/ocdm/open_cdm_ext.h ${D}${includedir}/opencdm
  install -m 0644 ${S}/Source/ocdm/adapter/open_cdm_adapter.h ${D}${includedir}/opencdm
}

ALLOW_EMPTY_${PN} = "1"
