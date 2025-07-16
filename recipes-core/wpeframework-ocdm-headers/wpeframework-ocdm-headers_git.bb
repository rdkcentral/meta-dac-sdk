SUMMARY = "WPEFramework OCDM headers"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=847677038847363222ffb66cfa6406c2"

SRC_URI = "git://github.com/rdkcentral/ThunderClientLibraries.git;protocol=https;branch=R4;name=wpeframework-clientlibraries"

# Jul 20, 2022; R2-v1.11 HASH; https://github.com/rdkcentral/ThunderClientLibraries/commit/d3e3d6c2be6516dd6b4ccfc04b129f8725b59baa
SRCREV = "R4.4.1"

S = "${WORKDIR}/git"

do_compile[noexec] = "1"

do_install() {
  install -d ${D}${includedir}
  install -d ${D}${includedir}/opencdm
  install -m 0644 ${S}/Source/ocdm/open_cdm.h ${D}${includedir}/opencdm
  install -m 0644 ${S}/Source/ocdm/open_cdm_ext.h ${D}${includedir}/opencdm
  install -m 0644 ${S}/Source/ocdm/adapter/open_cdm_adapter.h ${D}${includedir}/opencdm

  install -d ${D}${includedir}/WPEFramework/ocdm
  install -m 0644 ${S}/Source/ocdm/open_cdm.h ${D}${includedir}/WPEFramework/ocdm
  install -m 0644 ${S}/Source/ocdm/open_cdm_ext.h ${D}${includedir}/WPEFramework/ocdm
  install -m 0644 ${S}/Source/ocdm/adapter/open_cdm_adapter.h ${D}${includedir}/WPEFramework/ocdm
}

ALLOW_EMPTY_${PN} = "1"
