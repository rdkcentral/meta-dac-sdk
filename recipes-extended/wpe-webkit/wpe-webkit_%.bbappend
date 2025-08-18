WPE_BACKEND = ""

PACKAGECONFIG:remove = "accessibility"
PACKAGECONFIG:remove = "speechsynthesis"

require ${@bb.utils.contains('DISTRO_FEATURES', 'enable_rialto', 'rialto.inc', '', d)}
