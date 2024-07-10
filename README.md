# meta-dac-sdk
  # One time SDK Build environment setup on HOST 
 	# make sure that your Linux host has required packages needed for Yocto. 
  	# These are defined in https://docs.yoctoproject.org/3.1.33/ref-manual/ref-system-requirements.html#required-packages-for-the-build-host
	# On CentOS-7 switch default gcc to 7.x from https://www.softwarecollections.org/en/scls/rhscl/devtoolset-7/
	#[ -f /opt/rh/devtoolset-7/enable ] && source /opt/rh/devtoolset-7/enable

	# Create build directory
	mkdir build; cd build

	# Install 'repo' tool from: https://android.googlesource.com/tools/repo
 	# following repo commands will download Yocto poky environment and other required meta-layers see manifest of https://github.com/rdkcentral/meta-dac-sdk/blob/master/manifests/dac-dunfell-manifest.xml
	repo init -u https://github.com/rdkcentral/meta-dac-sdk/ -m manifests/dac-dunfell-manifest.xml
	repo sync --no-clone-bundle -v -j$(getconf _NPROCESSORS_ONLN)

	. ./oe-init-build-env
	cp ../.repo/manifests/manifests/bblayers.conf conf/

  	# Need to decide whether you compile Application binaries against ARM 32bit or x86 64bit, Select one of them
 	# At this stage we do not support Multi CPU Arch container images yet, defaulting to ARM 32bit  
	# for ARMv7
	echo 'MACHINE = "raspberrypi4"' >> conf/local.conf
	# for x86_64
	#echo 'MACHINE = "qemux86-64"' >> conf/local.conf
 

	# By default, gfx libraries are removed from DAC rootfs
	# Also libglvnd is used to provide egl/gles/mesa
	# To use mesa provider instead and not remove the gfx libraries:
	#echo 'DISTRO_FEATURES_remove = "cleanup_gfx"' >> conf/local.conf
 	# end of [One time SDK Build environment setup on HOST] 
# Building your DAC application container image
	#Above steps you only need to do the first time you setup the SDK. For subsequent uses, you only need to run the following command to configure the build environment:
 	# cd build
	# . ./oe-init-build-env

	# Now you can build the "DAC application container image" of your choice. 
 	# Note that you need to have associated yocto image recipe defined in meta-layer and use that as <your yocto image target>
 	# as per example image recipes in https://github.com/rdkcentral/meta-dac-sdk/tree/master/recipes-example/images
  	# use bitbake <your yocto image target> to build the associated dac application container.
   	# below commands build dac application container examples coming with SDK
    	bitbake dac-image-wayland-egl-test
	bitbake dac-image-wayland-egl-test-input
	bitbake dac-image-essos-sample
	bitbake dac-image-essos-egl
	bitbake dac-image-qt-test
	bitbake dac-image-shell
	bitbake dac-image-flutter-slide-puzzle
	bitbake dac-image-chocolate-doom
	bitbake dac-image-cobalt
	bitbake dac-image-glmark2

	# Or build them all at once
	bitbake dac-image-wayland-egl-test dac-image-wayland-egl-test-input dac-image-essos-sample dac-image-essos-egl dac-image-qt-test dac-image-shell dac-image-flutter-slide-puzzle dac-image-glmark2

# Building Cobalt DAC app

Use build target **dac-image-cobalt**.  By default cobalt evergreen is **not** enabled and libcobalt will be built and linked with cobalt-launcher. To enable cobalt evergreen lite make sure **cobalt_enable_evergreen_lite** DISTRO_FEATURE is set. See conf/layer.conf. In that case libloader-app will be built and linked to cobalt-launcher.

However, currently this does not work on RPI target hosts: cobalt DAC app built with evergreen enabled, crashes on RPI. See comments in libcobalt_23.lts.stable.bbappend.

## Building Cobalt 2024 DAC app

By default version 23 is built. Edit conf/layer.conf and uncomment this line to build version 24 instead:
```
DISTRO_FEATURES_append = " cobalt-24 gstreamer1_18 dunfell"
```

# Building Netflix DAC app

Netflix DAC app needs several things in order to build:
* netflix source tarball
* meta-rdk-netflix repo
* playready headers recipe can be copied from here:
  https://github.com/stagingrdkm/meta-dac-sdk/blob/master/recipes-core/playready-headers/playready-headers_4.2.bb
* playready headers from officially licensed playeady SDK. Howto get the playready-sdk.zip?
  * install your licensed playready SDK on your PC
  * zip the installed Device_PK_xxxx dir. Update/check the values for PV and ZIP_SUBDIR in meta-dac-sdk/recipes-core/playready-headers/playready-headers_4.2.bb

To actually run the netflix DAC app, it also requires a correct netflix vault file on the host under /opt/netflix-binfile.bin.

Extra setup steps:
>
	git clone "https://code.rdkcentral.com/r/apps/netflix/rdk-oe/meta-rdk-netflix"
	mkdir -p build/downloads
	cp ~/from_somewhere/nrd-5.3.1-27d5e9003f.tar.gz build/downloads/nrd-5.3.1-27d5e9003f.tar.gz
	touch build/downloads/nrd-5.3.1-27d5e9003f.tar.gz.done
	cp ~/from_somewhere/playready-sdk.zip build/downloads/
	echo 'BBLAYERS += " ${TOPDIR}/../meta-rdk-netflix"' >> build/conf/bblayers.conf

Build:
>
	bitbake dac-image-netflix

# Building AmazonPrime5 DAC app

AmazonPrime DAC app needs several things in order to build:
* AmazonPrime5 source tarball
* meta-rdk-amazon repo

Extra setup steps:
>
        git clone "https://code.rdkcentral.com/r/apps/amazon/rdk-oe/meta-rdk-amazon"
        mkdir -p build/downloads
        cp ~/from_somewhere/avpk-v5.tgz build/downloads/avpk-v5.tgz
        touch build/downloads/avpk-v5.tgz.done
        echo 'BBLAYERS += " ${TOPDIR}/../meta-rdk-amazon"' >> build/conf/bblayers.conf
        sed -i '/BBMASK.*amazon-prime-src_5.0.bb/d' meta-rdk-amazon/conf/layer.conf

Build:
>
        bitbake dac-image-amazonprime5

# Generating DAC bundles

Optionally, you can enable DAC bundle generation for a specific target platform. It will use BundleGen, skopeo and umoci to do this.
More info on BundleGen can be found here: https://github.com/rdkcentral/BundleGen . These tools don't need to be installed separately. They are built within the Yocto environment.

You can enable bundle generation by adding BUNDLE_GENERATE = "1" to conf/local.conf. By default it will generate a tarball bundle for RPI3 reference image. The bundles are output in the ./bundles/ directory together with a test script to easily upload and run it on the target.

Other options are these:
* BUNDLE_PLATFORM: use a different target platform. Defaults to "rpi3_reference_vc4_dunfell"
* BUNDLE_OPTIONS: extra commandline options for BundleGen. Defaults to "-m normal --createmountpoints"
* BUNDLE_TEMPLATE_PATH: path where to find the template files for your target. You could set it to "${TOPDIR}/templates" and put your templates in there. Example templates: https://github.com/rdkcentral/BundleGen/tree/master/templates
