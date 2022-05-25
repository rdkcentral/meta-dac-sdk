CMF_GIT_PROTOCOL ?= "https"
CMF_GIT_ROOT ?= "git://code.rdkcentral.com/r"

# disable server parts
PACKAGECONFIG_remove = "rialtoserver"
PACKAGECONFIG_remove = "rialtoservermanager"
# overwrite packageconfig for rialtoocdm to DEP on our recipe for the ocdm headers
PACKAGECONFIG[rialtoocdm]   = "-DRIALTOOCDM=ON, -DRIALTOOCDM=OFF,wpeframework-ocdm-headers,"

RDEPENDS_${PN}-servermanager_remove = "mongoose"

# fixes needed because we version libRialtoClient.so and libocdmRialto.so to 0.1.0
FILES_${PN}-dev += "${libdir}/libRialtoClient.so ${libdir}/libocdmRialto.so"
FILES_${PN}-client = "${libdir}/libRialtoClient.so.* ${libdir}/gstreamer-1.0/libgstrialtosinks.so"
FILES_${PN}-ocdm = "${libdir}/libocdmRialto.so.*"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://0001-build-options.patch"
SRC_URI += "file://0001_openssl_api_change.patch"
SRC_URI += "file://0008-fix-gst-plugin-name.patch"

SRC_URI += "file://0002_CMakeList_versioning.patch"
SRC_URI += "file://0001-Remove-Wpe.patch"

SRCREV = "30031e61a4ee97ebf247c3381bd3e5715ebdfccb"
SRC_URI += "file://0002-fix-crash2.patch"
SRC_URI += "file://0003-CMake-PackageConfig2.patch"
