HOMEPAGE = "https://github.com/containers/skopeo"
SUMMARY = "Work with remote images registries - retrieving information, images, signing content"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://src/import/LICENSE;md5=7e611105d3e369954840a6668c438584"

DEPENDS="libdevmapper-native gpgme-native"

inherit go native

RDEPENDS_${PN} = " \
     gpgme \
     libgpg-error \
     libassuan \
"

SRC_URI = " \
    git://github.com/containers/skopeo.git;branch=release-1.2;protocol=git \
"

SRCREV ="e72dd9c5c834f3cd7fb8b1aab4021d9d4412f305"
PV = "v1.2.2-dev+git${SRCPV}"

DEPENDS="libdevmapper-native btrfs-tools-native gpgme-native"

GO_IMPORT = "import"

S = "${WORKDIR}/git"

inherit goarch
inherit pkgconfig

# This disables seccomp and apparmor, which are on by default in the
# go package. 
EXTRA_OEMAKE="BUILDTAGS=''"

do_compile() {
	export GOARCH="${TARGET_GOARCH}"

	# Setup vendor directory so that it can be used in GOPATH.
	#
	# Go looks in a src directory under any directory in GOPATH but riddler
	# uses 'vendor' instead of 'vendor/src'. We can fix this with a symlink.
	#
	# We also need to link in the ipallocator directory as that is not under
	# a src directory.
	ln -sfn . "${S}/src/import/vendor/src"
	mkdir -p "${S}/src/import/vendor/src/github.com/projectatomic/skopeo"
	ln -sfn "${S}/src/import/skopeo" "${S}/src/import/vendor/src/github.com/projectatomic/skopeo"
	ln -sfn "${S}/src/import/version" "${S}/src/import/vendor/src/github.com/projectatomic/skopeo/version"
	export GOPATH="${S}/src/import/vendor"

	# Pass the needed cflags/ldflags so that cgo
	# can find the needed headers files and libraries
	export CGO_ENABLED="1"
	export CFLAGS=""
	export LDFLAGS=""
	export CGO_CFLAGS="${BUILD_CFLAGS} --sysroot=${STAGING_DIR_TARGET}"
	export CGO_LDFLAGS="${BUILD_LDFLAGS} --sysroot=${STAGING_DIR_TARGET}"
	cd ${S}/src/import

	oe_runmake bin/skopeo
}

do_install() {
	install -d ${D}/${sbindir}
	install -d ${D}/${sysconfdir}/containers

	install ${S}/src/import/bin/skopeo ${D}/${sbindir}/
	install ${S}/src/import/default-policy.json ${D}/${sysconfdir}/containers/policy.json

#	install ${WORKDIR}/storage.conf ${D}/${sysconfdir}/containers/storage.conf
#	install ${WORKDIR}/registries.conf ${D}/${sysconfdir}/containers/registries.conf
}

INSANE_SKIP_${PN} += "ldflags"
