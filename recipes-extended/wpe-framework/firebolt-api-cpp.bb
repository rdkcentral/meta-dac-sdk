HOMEPAGE = "https://github.com/rdkcentral/Thunder"
SUMMARY = "Firebolt APIs CPP"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://../../LICENSE;md5=30cab9754e930d044e6bbb4d621e5c03"

inherit cmake pkgconfig

S = "${WORKDIR}/git/src/cpp/"
PR = "r0"

SRC_URI = "git://github.com/rdkcentral/firebolt-apis.git;protocol=git;branch=next;name=firebolt-apis"
SRCREV_firebolt-apis = "198b790499dcc594cde6149e27e1b9d0353c0584"

# ----------------------------------------------------------------------------

DEPENDS = " \
    wpeframework \
    firebolt-native-transport \
"

RDEPENDS_${PN} = " wpeframework firebolt-native-transport"
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

