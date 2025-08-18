SRC_URI:remove = "https://artifactory.rdkcentral.com/artifactory/rdk-netflix-sdk-local/nrd-5.3.1-27d5e9003f.tar.gz;name=netflix"
SRC_URI += "file://nrd-5.3.1-27d5e9003f.tar.gz;name=netflix"
SRCREV:pn-netflix = "5deeb28505583606adb509360b32486dca940edb"

DEPENDS += "rialto-ocdm"
RDEPENDS:${PN} += "rialto-gstreamer"
DEPENDS:remove = "iarmmgrs"
DEPENDS:remove = "systemd"
#DEPENDS_remove = "wpeframework"
#DEPENDS_remove = "wpeframework-clientlibraries"
RDEPENDS:${PN}:remove = "devicesettings"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://0004-set-noverify.patch"
SRC_URI += "file://0010-stat-reserved-s32-build-fix.patch"
SRC_URI += "file://0011-add-rialto.patch;patchdir=${WORKDIR}/git"
SRC_URI += "file://0020-remove-rdk-parts.patch;patchdir=${WORKDIR}/git"
SRC_URI += "file://0015-netflix-ui-in-1080p.patch;patchdir=${WORKDIR}/git"

### Remove part of rdk porting layer
EXTRA_OECMAKE:remove = "-DGIBBON_PLATFORM=${S}/../../git/partner/platform/thunder-manager"
###

APPBOOTKEY = ""
DEVICEMODEL = "reference-image"
MINAUDIOPTSGAP = "0"

do_configure:append(){
    echo "#define APPBOOTKEY \"${APPBOOTKEY}\"" > ${S}/../../git/partner/dpi/gstreamer/Appbootkey.h
    echo "#define DEVICEMODEL \"${DEVICEMODEL}\"" > ${S}/../../git/partner/dpi/gstreamer/DeviceModel.h
    echo "#define MINAUDIOPTSGAP ${MINAUDIOPTSGAP}" > ${S}/../../git/partner/dpi/gstreamer/PlatformSpecificValues.h
}

SRC_URI:remove = "file://0001-Playready-cmake-changes_new.patch"

RDEPENDS:${PN} += "gstreamer1.0-plugins-base-app gstreamer1.0-plugins-base-playback"

do_install:append() {
  ## also needed for 1080p resolution
  sed -i -e '/<config_data>/ a \        <font_glyph_cache_width>1536</font_glyph_cache_width>' ${D}/${NRD_INSTALL_PREFIX}/bin/data/etc/conf/oem.xml
  sed -i -e '/<config_data>/ a \        <font_glyph_cache_height>1536</font_glyph_cache_height>' ${D}/${NRD_INSTALL_PREFIX}/bin/data/etc/conf/oem.xml
}

### playready headers
DEPENDS += "playready-headers"
CXXFLAGS:remove = "-I${STAGING_INCDIR}/refsw"
CXXFLAGS += "-I${STAGING_INCDIR}/playready"
###

### Netflix as executable ###
SRC_URI += "file://0012-exe-fixes.patch;patchdir=${WORKDIR}/git"
EXTRA_OECMAKE:remove = "-DGIBBON_MODE=shared"
EXTRA_OECMAKE:append = " -DGIBBON_MODE=executable"
do_install:prepend() {
    ## main bb assumes netflix was built as shared library, fake it here
    touch ${B}/src/platform/gibbon/libnetflix.so
}

do_install:append() {
    install -m 755 ${B}/src/platform/gibbon/netflix ${D}${NRD_INSTALL_PREFIX}/bin
}
###
