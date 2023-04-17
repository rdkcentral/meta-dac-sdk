SUMMARY = "Rialto"
LICENSE  = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=327e572d11c37963726ba0b02d30cf2c"

SRC_URI = "${CMF_GITHUB_ROOT}/rialto;protocol=${CMF_GIT_PROTOCOL};branch=${CMF_GITHUB_MASTER_BRANCH}"
SRCREV = "${AUTOREV}"

DEPENDS = "protobuf protobuf-native"

S = "${WORKDIR}/git"
inherit cmake coverity

PACKAGES =+ "${PN}-client ${PN}-server ${PN}-servermanager-lib ${PN}-servermanager"

PACKAGECONFIG[server] = "-DENABLE_SERVER=ON,-DENABLE_SERVER=OFF,wpeframework-clientlibraries gstreamer1.0 gstreamer1.0-plugins-base glib-2.0"
PACKAGECONFIG[servermanager] = "-DENABLE_SERVER_MANAGER=ON,-DENABLE_SERVER_MANAGER=OFF,mongoose,"

# The 'servermanager' package config has a runtime
# dependency on the 'RialtoServer' executable and as such
# requires the 'server' package config to be enabled as well.
PACKAGECONFIG ??= "server servermanager"

FILES_${PN}-client += "${libdir}/libRialtoClient.so.*"

FILES_${PN}-server += "${bindir}/RialtoServer"

FILES_${PN}-servermanager += "${bindir}/RialtoServerManagerSim"
RDEPENDS_${PN}-servermanager += "${PN}-server"

FILES_${PN}-servermanager-lib += "${libdir}/libRialtoServerManager.so.*"
