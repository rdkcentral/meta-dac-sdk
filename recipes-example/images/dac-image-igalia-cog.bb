SUMMARY = "cog in DAC Container"
LICENSE = "MIT"

# TODO: inherit also gstreamer class when it will be ready
inherit dac-image-wayland

TOOLCHAIN_pn-wpewebkit = "clang"
RUNTIME_pn-wpewebkit = "llvm"
TOOLCHAIN_pn-wpewebkit-rdk = "clang"
RUNTIME_pn-wpewebkit-rdk = "llvm"
TOOLCHAIN_pn-cog = "clang"
RUNTIME_pn-cog = "llvm"

PACKAGECONFIG_pn-weston-cog = "weston-direct-display"

IMAGE_INSTALL = "cog"

# needed
# needed
OCI_IMAGE_ENTRYPOINT = "/usr/bin/cog"
OCI_IMAGE_ENTRYPOINT_ARGS = "https://html5test.com/"
APP_METADATA_PATH = "metadatas/igalia-cog-appmetadata.json"

OCI_IMAGE_AUTHOR = "Damian Wrobel"
OCI_IMAGE_AUTHOR_EMAIL = "dwrobel@ertelnet.rybnik.pl"

