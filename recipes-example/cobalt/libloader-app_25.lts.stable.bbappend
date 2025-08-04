require cobalt_dac.inc
require cobalt_rialto.inc

SRC_URI += "file://0006-backspace-to-esc.patch;patchdir=../larboard/"
SRC_URI += "file://0001-Fix-to-resolve-build-failures.patch;patchdir=../larboard/"
DEPENDS:remove = " virtual/vendor-secapi2-adapter virtual/vendor-gst-drm-plugins "
DEPENDS:remove = "${@bb.utils.contains('DISTRO_FEATURES', 'switch_rdke_cobalt', '', 'wpeframework-interfaces', d)}"
