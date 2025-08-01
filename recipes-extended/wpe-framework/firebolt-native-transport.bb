HOMEPAGE = "https://github.com/rdkcentral/Thunder"
SUMMARY = "Firebolt native transport"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b1e01b26bacfc2232046c90a330332b3"

inherit cmake pkgconfig

S = "${WORKDIR}/git"
PR = "r0"

SRC_URI = "git://github.com/rdkcentral/firebolt-native-transport.git;protocol=git;branch=main;name=firebolt-native-transport"
SRCREV_firebolt-native-transport = "616eaac6bb138526ca5e1118abd66adb7dcaa138"

# ----------------------------------------------------------------------------

DEPENDS = " \
    wpeframework \
"

RDEPENDS_${PN} = " wpeframework"
RDEPENDS_${PN}_remove_rpi = "userland"

PACKAGECONFIG ?= " \
    release \
    "

PACKAGECONFIG ??= ""
PACKAGECONFIG[debug]            = "-DCMAKE_BUILD_TYPE=Debug,-DCMAKE_BUILD_TYPE=Release,"

# ----------------------------------------------------------------------------

TOOLCHAIN = "gcc"
EXTRA_OECMAKE += " \
    -DCMAKE_SYSROOT=${STAGING_DIR_HOST} \
    -DBUILD_SHARED_LIBS=ON \
    -DBUILD_REFERENCE=${SRCREV} \
"

# ----------------------------------------------------------------------------

FILES_SOLIBSDEV = ""
FILES_${PN} += "${libdir}/*.so ${datadir}/WPEFramework/* ${PKG_CONFIG_DIR}/*.pc"
FILES_${PN}-dev += "${libdir}/cmake/*"

INSANE_SKIP_${PN} += "dev-so"
INSANE_SKIP_${PN}-dbg += "dev-so"

