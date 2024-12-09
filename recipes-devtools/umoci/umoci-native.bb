HOMEPAGE = "https://github.com/openSUSE/umoci"
SUMMARY = "umoci modifies Open Container images"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=3b83ef96387f14655fc854ddc3c6bd57"

DEPENDS = "skopeo"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRCREV_umoci = "758044fc26ad65eb900143e90d1e22c2d6e4484d"
SRC_URI = "git://github.com/opencontainers/umoci.git;branch=main;name=umoci;destsuffix=github.com/opencontainers/umoci \
          "
SRC_URI += "file://0001-resolv-conf-avoid-priv-flags.patch;striplevel=0"

PV = "v0.4.7-dev+git${SRCPV}"
S = "${WORKDIR}/github.com/opencontainers/umoci"
GO_IMPORT = "github.com/opencontainers/umoci"

inherit goarch go native

# This disables seccomp and apparmor, which are on by default in the
# go package. 
EXTRA_OEMAKE="BUILDTAGS=''"

do_compile() {
    export GOARCH="${TARGET_GOARCH}"
    export GOPATH="${WORKDIR}/git/"

    # Pass the needed cflags/ldflags so that cgo
    # can find the needed headers files and libraries
    export CGO_ENABLED="1"
    export CFLAGS=""
    export LDFLAGS=""
    export GO111MODULE=off
    cd ${S}
    oe_runmake umoci
}

do_install() {
    install -d ${D}/${sbindir}
    install ${S}/umoci ${D}/${sbindir}
}

INSANE_SKIP_${PN} += "ldflags already-stripped"
BBCLASSEXTEND = "native nativesdk"

FILES_${PN} += "${datadir}/umoci*"
