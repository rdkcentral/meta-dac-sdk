# meta-dac

	# On CentOS-7 switch default gcc to 7.x from https://www.softwarecollections.org/en/scls/rhscl/devtoolset-7/
	[ -f /opt/rh/devtoolset-7/enable ] && source /opt/rh/devtoolset-7/enable

	# Create build directory
	mkdir build; cd build

	# Install 'repo' tool from: https://android.googlesource.com/tools/repo
	repo init -u https://github.com/stagingrdkm/lgpub/ -m manifests/dac-dunfell-3.1.6-manifest.xml
	repo sync -v

	# OPTIONAL: for building the cobalt (rialto) DAC image
	#git clone --branch master "https://code.rdkcentral.com/r/components/generic/avbus-poc"
	#cp avbus-poc/cobalt/libcobalt-21.lts.stable-6.patch meta-dac-sdk/recipes-example/cobalt/files/

	. ./oe-init-build-env
	cp ../.repo/manifests/manifests/bblayers.conf conf/

	# Select one of the target platform
	# for ARMv7
	echo 'MACHINE = "raspberrypi4"' >> conf/local.conf
	# for x86_64
	#echo 'MACHINE = "qemux86-64"' >> conf/local.conf

	# By default, gfx libraries are removed from DAC rootfs
	# Also libglvnd is used to provide egl/gles/mesa
	# To use mesa provider instead and not remove the gfx libraries:
	#echo 'DISTRO_FEATURES_remove = "cleanup_gfx"' >> conf/local.conf

	# Test OCI images
	bitbake dac-image-wayland-egl-test
	bitbake dac-image-wayland-egl-test-input
	bitbake dac-image-essos-sample
	bitbake dac-image-essos-egl
	bitbake dac-image-qt-test
	bitbake dac-image-shell

	# if avbus-poc is available
	bitbake dac-image-cobalt

	# Or build them all at once
	bitbake dac-image-wayland-egl-test dac-image-wayland-egl-test-input dac-image-essos-sample dac-image-essos-egl dac-image-qt-test dac-image-shell

# Generating DAC bundles

Optionally, you can enable DAC bundle generation for a specific target platform. It will use BundleGen, skopeo and umoci to do this.
More info on BundleGen can be found here: https://github.com/rdkcentral/BundleGen . These tools don't need to be installed separately. They are built within the Yocto environment.

You can enable bundle generation by adding BUNDLE_GENERATE = "1" to conf/local.conf. By default it will generate a tarball bundle for RPI3 reference image. The bundles are output in the ./bundles/ directory together with a test script to easily upload and run it on the target.

Other options are these:
* BUNDLE_PLATFORM: use a different target platform. Defaults to "rpi3_reference"
* BUNDLE_OPTIONS: extra commandline options for BundleGen. Defaults to "-m normal"
* BUNDLE_TEMPLATE_PATH: path where to find the template files for your target. You could set it to "${TOPDIR}/templates" and put your templates in there. Example templates: https://github.com/rdkcentral/BundleGen/tree/master/templates
