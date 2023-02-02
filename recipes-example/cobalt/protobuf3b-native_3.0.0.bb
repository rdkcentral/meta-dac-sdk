SUMMARY = "Protocol Buffers - structured data serialisation mechanism"
DESCRIPTION = "Protocol Buffers are a way of encoding structured data in an \
efficient yet extensible format. Google uses Protocol Buffers for almost \
all of its internal RPC protocols and file formats."
HOMEPAGE = "https://github.com/google/protobuf"
SECTION = "console/tools"
LICENSE = "BSD-3-Clause"

PACKAGE_BEFORE_PN = "${PN}-compiler"

DEPENDS = "zlib"
RDEPENDS_${PN}-compiler = "${PN}"
RDEPENDS_${PN}-dev += "${PN}-compiler"

LIC_FILES_CHKSUM = "file://LICENSE;md5=35953c752efc9299b184f91bef540095"

# dw: Please do not update this version as this is an exact
# match to what cobalt version 23.lts.stable-2 sticks to.
# See libcobalt/23.lts.stable-2/git/third_party/protobuf/CHANGES.txt
# for more details.
# As we need only -native counterpart, it shouldn't clash
# with any other version installed for target platform.
# (tag: v3.0.0-beta-3)
SRCREV = "3470b6895aa659b7559ed678e029a5338e535f14"

# dw: Mark it clearly as not parallel installable with any regular version.
RCONFLICTS_${PN} = "protobuf protobuf-compiler protobuf-dev protobuf-lite"

PV = "3.0.0-beta-3+git${SRCPV}"

SRC_URI = "git://github.com/google/protobuf.git"

EXTRA_OECONF += " --with-protoc=echo"

inherit autotools native

S = "${WORKDIR}/git"

FILES_${PN}-compiler = "${bindir} ${libdir}/libprotoc${SOLIBS}"

MIPS_INSTRUCTION_SET = "mips"
