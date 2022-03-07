SUMMARY = "cog in OCI Container"

IMAGE_FSTYPES = "container oci"

inherit image
inherit image-oci

IMAGE_CONTAINER_NO_DUMMY = "1"

IMAGE_LINGUAS = " "
LICENSE = "MIT"

TOOLCHAIN_pn-wpewebkit = "clang"
RUNTIME_pn-wpewebkit = "llvm"
TOOLCHAIN_pn-wpewebkit-rdk = "clang"
RUNTIME_pn-wpewebkit-rdk = "llvm"
TOOLCHAIN_pn-cog = "clang"
RUNTIME_pn-cog = "llvm"

PACKAGECONFIG_pn-weston-cog = "weston-direct-display"

IMAGE_INSTALL_append = " cog"
# dw: TODO: Missing RDEPENDS
IMAGE_INSTALL_append = "${@bb.utils.contains('DISTRO_FEATURES', 'cleanup_gfx', '', ' libgles2-mesa', d)}"

OCI_IMAGE_AUTHOR = "Damian Wrobel"
OCI_IMAGE_AUTHOR_EMAIL = "dwrobel@ertelnet.rybnik.pl"

# config:Entrypoint
#OCI_IMAGE_ENTRYPOINT = ""

# config:Env
#OCI_IMAGE_ENV_VARS = '"PATH=/usr/local/bin:/usr/local/sbin:/usr/bin:/usr/sbin:/bin"'

# config:Cmd
#OCI_IMAGE_ENTRYPOINT_ARGS = "sh"
