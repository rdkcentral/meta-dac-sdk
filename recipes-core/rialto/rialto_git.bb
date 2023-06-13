SUMMARY = "Rialto"
LICENSE  = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=327e572d11c37963726ba0b02d30cf2c"

SRC_URI = "${CMF_GITHUB_ROOT}/rialto;protocol=${CMF_GIT_PROTOCOL};branch=${CMF_GITHUB_MASTER_BRANCH}"
SRCREV = "${AUTOREV}"

DEPENDS = "protobuf protobuf-native"

S = "${WORKDIR}/git"
inherit cmake coverity

PACKAGES =+ "${PN}-client ${PN}-server ${PN}-servermanager-lib ${PN}-servermanager-sim"
PROVIDES += "${PN}-client ${PN}-server ${PN}-servermanager-lib ${PN}-servermanager-sim"

PACKAGECONFIG[server] = "-DENABLE_SERVER=ON,-DENABLE_SERVER=OFF,wpeframework-clientlibraries gstreamer1.0 gstreamer1.0-plugins-base glib-2.0 rdk-gstreamer-utils,"
PACKAGECONFIG[servermanager-sim] = "-DENABLE_SERVER_MANAGER=ON,-DENABLE_SERVER_MANAGER=OFF,mongoose,"

PACKAGECONFIG ??= "server servermanager-sim"

FILES_${PN}-client += "${libdir}/libRialtoClient.so.*"
FILES_${PN}-server += "${bindir}/RialtoServer"
RDEPENDS_${PN}-server += "rdk-gstreamer-utils"
FILES_${PN}-servermanager-sim += "${bindir}/RialtoServerManagerSim"
FILES_${PN}-servermanager-lib += "${libdir}/libRialtoServerManager.so.*"
RDEPENDS_${PN}-servermanager-lib += "${PN}-server"

# Enable the correct logging compile flag for the image build
# Debug will include all logging, Release includes only fatal, error, warning and milestones
EXTRA_OECMAKE += "${@bb.utils.contains("IMAGE_FEATURES", "prod", "-DRIALTO_BUILD_TYPE=Release", "-DRIALTO_BUILD_TYPE=Debug", d)}"
