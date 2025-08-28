include rdk.inc

DISTRO_FEATURES:append = " kirkstone"
DISTRO_FEATURES:append = " opencdm"
DISTRO_FEATURES:remove = "ptest"

RDKROOT := "${@os.path.abspath(os.path.dirname(d.getVar('FILE', True)) + '/../..')}"
RDK_ARTIFACTS_BASE_URL ??= "file://${HOME}/ipk/"
OSS_LAYER_ARCH ??= "${TUNE_PKGARCH}"

require ${TOPDIR}/../rdke/common/meta-rdk-oss-reference/conf/include/oss-config.inc

BBMASK += "/rdke/middleware/generic/meta-middleware-generic-support/recipes-core/images/"
BBMASK += "/rdke/middleware/generic/meta-rdk/recipes-core/images/"
BBMASK += "/rdke/common/meta-rdk-oss-reference/recipes-graphics/westeros/"
BBMASK += "/rdke/common/meta-rdk-oss-reference/recipes-graphics/wayland/"

BBMASK += "/meta-dac-sdk/recipes-core/rialto/"
BBMASK += "/meta-dac-sdk/recipes-example/netflix/rdk-gstreamer-utils.bbappend"
BBMASK += "/meta-dac-sdk/recipes-extended/wpe-webkit/"
