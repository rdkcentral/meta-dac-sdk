WPE_BACKEND = ""

PACKAGECONFIG_remove = "accessibility"
PACKAGECONFIG_remove = "speechsynthesis"

require ${@bb.utils.contains('DISTRO_FEATURES', 'enable_rialto', 'rialto.inc', '', d)}
