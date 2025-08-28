include rdk.inc

DISTRO_FEATURES:append = " dunfell"
DISTRO_FEATURES:append = " netflix_1080p_graphics"
DISTRO_FEATURES:append = " cobalt_rialto"

require ${@'rialto_revision_rdk7.inc' if d.getVar('RDK_COMPATIBILITY') == 'rdk7' else 'rialto_revision_latest.inc'}

WPEFRAMEWORK_VERSION = "${@bb.utils.contains('DISTRO_FEATURES', 'wpe_r4_4', '4.4%' , bb.utils.contains('DISTRO_FEATURES', 'wpe_r4', '4.2%', '2.1%', d), d)}"
PREFERRED_VERSION_wpeframework = "${WPEFRAMEWORK_VERSION}"
PREFERRED_VERSION_wpeframework-clientlibraries = "${WPEFRAMEWORK_VERSION}"
PREFERRED_VERSION_wpeframework-interfaces = "${WPEFRAMEWORK_VERSION}"
PREFERRED_VERSION_wpeframework-tools-native = "${WPEFRAMEWORK_VERSION}"
EXTRA_VERSIONS_PATH ?= "${TMPDIR}/versions"

BBMASK += "/meta-rdk/"
BBMASK += "/meta-cmf/(?!recipes-extended|recipes-devtools)"
BBMASK += "/meta-cmf/recipes-extended/(?!rpcserver)"
BBMASK += "/meta-cmf/recipes-devtools/(?!protobuf)"

# Netflix dependencies from rdk
# mask all unnecessary recipes from meta-rdk-video and meta-rdk-ext
BBMASK += "/meta-rdk-video/(?!recipes-extended|recipes-devtools)"
BBMASK += "${@bb.utils.contains('DISTRO_FEATURES', 'enable_rialto', '/meta-rdk-video/recipes-extended/(?!gstreamer-netflix-platform|wpe-framework|rialto|cobalt)', '/meta-rdk-video/recipes-extended/(?!gstreamer-netflix-platform|wpe-framework|cobalt)', d)}"
BBMASK += "${@bb.utils.contains('DISTRO_FEATURES', 'enable_rialto', 'recipes-core/rialto/', 'recipes-extended/rialto/', d)}"
BBMASK += "/meta-rdk-video/recipes-devtools/(?!gn)"


BBMASK += "/meta-rdk-ext/(?!recipes-devtools|recipes-extended|recipes-multimedia|recipes-graphics)"

BBMASK += "/meta-rdk-ext/recipes-devtools/(?!dwarfutils)"

ENABLED_EXTENDED_RECIPES = "graphite2|curl-netflix"
ENABLED_EXTENDED_RECIPES .= "${@bb.utils.contains('DISTRO_FEATURES', 'igalia-wpe', '', '|wpe-webkit|wpe-backend-rdk|cog|libwpe', d)}"
BBMASK += "/meta-rdk-ext/recipes-extended/(?!${ENABLED_EXTENDED_RECIPES})"

BBMASK += "${@bb.utils.contains('DISTRO_FEATURES', 'gstreamer1_18', '/meta-rdk-ext/recipes-multimedia/(?!gstreamer|webm)', '/meta-rdk-ext/recipes-multimedia/', d)}"

BBMASK += "/meta-rdk-ext/recipes-graphics/(?!woff2|cairo)"


BBMASK += "/meta-rdk-netflix/recipes-extended/netflix-thunder-plugin"

# workaround for missing LICENSE entry in the recipe
BBMASK += "/meta-rdk-video/recipes-extended/wpe-framework/thunderhangrecovery.bb"

BBMASK += "${@bb.utils.contains('DISTRO_FEATURES', 'igalia-wpe', '/meta-dac-sdk/recipes-extended/cog/', '/meta-webkit/', d)}"
