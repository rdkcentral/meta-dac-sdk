SUMMARY="bundlegen generator"
SECTION="devtools"
LICENSE= "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2b42edef8fa55315f34f2370b4715ca9"
SRC_URI = " \
   git://github.com/rdkcentral/BundleGen.git;protocol=http;branch=master;name=bundlegen-1.0;rev=51c917e64e17abca8fa61fd819d727e0317d1f27"

FILESEXTRAPATHS_prepend := "${THISDIR}:"
SRC_URI+= "file://test.sh"

S = "${WORKDIR}/git"
PV= "1.0"
DEPENDS = "python3-native skopeo-native umoci-native python3-humanfriendly-native python3-click-native python3-loguru-native"

inherit setuptools3 native

BBCLASSSEXTEND = "native nativesdk"

FILES_${PN}_append_class-nativesdk = " ${SDKPATHNATIVE}"
FILES_${PN} = "${D}${prefix}/* ${D}{prefix}/templates/generic/rpi3*.json"
FILES_${PN} = "${D}{prefix}/test/testapp.sh"
FILES_${PN} = "${D}{prefix}/test.sh"

do_install_append() { 
 install -d ${D}${datadir}/${BPN}/templates
 install -m755 ${S}/templates/generic/rpi*.json ${D}${datadir}/${BPN}/templates/
 install -m755 ${S}/test/testapp.sh ${D}${datadir}/${BPN}/
 install -m755 ${WORKDIR}/test.sh ${D}${datadir}/${BPN}/
}
