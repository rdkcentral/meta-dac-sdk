SUMMARY = "Playready headers"
LICENSE = "CLOSED"

# howto get playready-sdk.zip?
# 1. install your licensed playready SDK on your PC
# 2. zip the installed Device_PK_xxxx dir
#    (update values for PV and ZIP_SUBDIR below, if needed)
# 3. copy this zip file to downloads/playready-sdk.zip
SRC_URI = "file://playready-sdk.zip"
S = "${WORKDIR}"
PV = "4.2.5545.0"
ZIP_SUBDIR = "Device_PK_${PV}"

do_compile[noexec] = "1"

do_install() {
  install -d ${D}${includedir}
  install -d ${D}${includedir}/playready
  install -m 0644 ${S}/${ZIP_SUBDIR}/source/inc/*.h ${D}${includedir}/playready
  install -m 0644 ${S}/${ZIP_SUBDIR}/source/oem/common/inc/*.h ${D}${includedir}/playready
  install -m 0644 ${S}/${ZIP_SUBDIR}/source/oem/ansi/inc/oemplatform.h ${D}${includedir}/playready
  install -m 0644 ${S}/${ZIP_SUBDIR}/source/results/drmresults.h ${D}${includedir}/playready
  install -m 0644 ${S}/${ZIP_SUBDIR}/source/inc/drmbuild_oem.h ${D}${includedir}/playready/drmbuild_linux.h
}

ALLOW_EMPTY_${PN} = "1"
