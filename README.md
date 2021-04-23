# meta-dac

		# On CentOS-7 switch default gcc to 7.x from https://www.softwarecollections.org/en/scls/rhscl/devtoolset-7/
		[ -f /opt/rh/devtoolset-7/enable ] && source /opt/rh/devtoolset-7/enable

		# Create build directory
		mkdir build; cd build

		# Install 'repo' tool from: https://android.googlesource.com/tools/repo
		repo init -u https://github.com/stagingrdkm/lgpub/ -m manifests/dac-dunfell-3.1.6-manifest.xml
		repo sync -v
		. ./oe-init-build-env
		cp ../.repo/manifests/manifests/bblayers.conf conf/

		# Select one of the target platform
		# for ARMv7
		echo 'MACHINE = "raspberrypi4"' >> conf/local.conf
		# for x86_64
		echo 'MACHINE = "qemux86-64""' >> conf/local.conf

		echo 'PREFERRED_PROVIDER_virtual/wpebackend = "wpebackend-rdk"' >> conf/local.conf

		# Test OCI images
		bitbake dac-image-wayland-egl-test
		bitbake dac-image-wayland-egl-test-input
		bitbake dac-image-essos-sample
		bitbake dac-image-essos-egl
		bitbake dac-image-qt-test
		bitbake dac-image-shell
		
		# Or build them all at once
		bitbake dac-image-wayland-egl-test dac-image-wayland-egl-test-input dac-image-essos-sample dac-image-essos-egl dac-image-qt-test dac-image-shell
