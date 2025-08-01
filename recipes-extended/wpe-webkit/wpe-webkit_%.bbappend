FILESEXTRAPATHS_prepend := "${THISDIR}/files/:"

WPE_BACKEND = ""

SRC_URI += "file://3035cf746fbbc8ce60d19158806a8d1006bed95e.patch"

PACKAGECONFIG_remove = "2dcanvas"
PACKAGECONFIG_remove = "gamepad"
PACKAGECONFIG_remove = "accessibility"
PACKAGECONFIG_remove = "speechsynthesis"

require ${@bb.utils.contains('DISTRO_FEATURES', 'enable_rialto', 'rialto.inc', '', d)}
