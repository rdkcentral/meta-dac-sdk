SUMMARY="bundlegen generator"
SECTION="devtools"
LICENSE= "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=32a3c2c37f9b6d1a2b8d9a636844d6cd"
SRC_URI = " \
   git://github.com/rdkcentral/BundleGen.git;protocol=http;branch=master;name=bundlegen-1.0;rev=7bc62b2e698f7dac5b874757eb01b4584bcbcc12"

FILESEXTRAPATHS_prepend := "${THISDIR}:"
SRC_URI+= "file://test.sh"

S = "${WORKDIR}/git"
PV= "1.0"
DEPENDS = "python3-native skopeo-native umoci-native python3-humanfriendly-native python3-click-native python3-loguru-native python3-jsonschema-native"

inherit setuptools3 native

BBCLASSSEXTEND = "native nativesdk"

FILES_${PN}_append_class-nativesdk = " ${SDKPATHNATIVE}"
FILES_${PN} = "${D}${prefix}/* ${D}{prefix}/templates/*/*.json"
FILES_${PN} = "${D}{prefix}/schema/*.json"
FILES_${PN} = "${D}{prefix}/test/testapp.sh"
FILES_${PN} = "${D}{prefix}/test.sh"

do_install_append() { 
 install -d ${D}${datadir}/${BPN}/templates
 cp -rf ${S}/templates/* ${D}${datadir}/${BPN}/templates/
 install -d ${D}${datadir}/${BPN}/schema
 cp -rf ${S}/bundlegen/schema/* ${D}${datadir}/${BPN}/schema/
 install -m755 ${S}/test/testapp_lisa.sh ${D}${datadir}/${BPN}/testapp.sh
 install -m755 ${WORKDIR}/test.sh ${D}${datadir}/${BPN}/
}
