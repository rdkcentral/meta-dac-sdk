require cobalt_dac.inc
require cobalt_rialto.inc

SRC_URI += "file://0006-backspace-to-esc.patch;patchdir=${@'../larboard' if d.getVar('RDK_FLAVOR') == 'rdke' else '../starboard'}"
SRC_URI += "file://0001-Fix-to-resolve-build-failures.patch;patchdir=${@'../larboard' if d.getVar('RDK_FLAVOR') == 'rdke' else '../starboard'}"
DEPENDS:remove = " virtual/vendor-secapi2-adapter virtual/vendor-gst-drm-plugins "
DEPENDS:remove = "${@'wpeframework-interfaces' if d.getVar('RDK_FLAVOR') == 'rdkv' else ''}"
