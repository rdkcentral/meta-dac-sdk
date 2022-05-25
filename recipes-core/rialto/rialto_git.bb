SUMMARY = "Rialto"
LICENSE = "CLOSED"

SRC_URI += "\
  ${CMF_GIT_ROOT}/components/generic/avbus-poc;protocol=${CMF_GIT_PROTOCOL};branch=master \
"

SRCREV = "${AUTOREV}"

PACKAGES =+ "${PN}-client ${PN}-server ${PN}-servermanager ${PN}-ocdm"

DEPENDS = "openssl jsoncpp glib-2.0 gstreamer1.0 gstreamer1.0-plugins-base"
RDEPENDS_${PN}-servermanager = "mongoose"

PACKAGECONFIG[rialtoserver] = "-DRIALTOSERVER=ON, -DRIALTOSERVER=OFF, wpeframework-clientlibraries,"
PACKAGECONFIG[rialtoservermanager] = "-DRIALTOSERVERMANAGER=ON, -DRIALTOSERVERMANAGER=OFF,mongoose"
PACKAGECONFIG[rialtoclient] = "-DRIALTOCLIENT=ON, -DRIALTOCLIENT=OFF,,"
PACKAGECONFIG[rialtoocdm]   = "-DRIALTOOCDM=ON, -DRIALTOOCDM=OFF,wpeframework-clientlibraries,"
PACKAGECONFIG[rialtoipc]    = "-DUSE_RIALTO_IPC=ON, -DUSE_RIALTO_IPC=OFF,protobuf protobuf-native,protobuf"
PACKAGECONFIG += "rialtoserver rialtoservermanager rialtoclient rialtoocdm rialtoipc"

S = "${WORKDIR}/git"
inherit cmake

FILES_SOLIBSDEV = ""
FILES_${PN}-server += "${bindir}/RialtoServerTest"
FILES_${PN}-server += "${libdir}/libRialtoServer.so"
FILES_${PN}-servermanager += "${bindir}/RialtoServerManagerTest"
FILES_${PN}-servermanager += "${libdir}/libRialtoServerManager.so"
FILES_${PN}-client += "${libdir}/libRialtoClient.so"
FILES_${PN}-client += "${libdir}/gstreamer-1.0/libgstrialtosinks.so"
FILES_${PN}-ocdm += "${libdir}/libocdmRialto.so"
FILES_${PN}-ocdm += "${PKG_CONFIG_DIR}/*.pc"
