SUMMARY = "cog in DAC Container"
LICENSE = "MIT"

inherit features_check
REQUIRED_DISTRO_FEATURES += "igalia-wpe"

# TODO: inherit also gstreamer class when it will be ready
inherit dac-image-wayland

TOOLCHAIN:pn-wpewebkit = "clang"
RUNTIME:pn-wpewebkit = "llvm"
TOOLCHAIN:pn-wpewebkit-rdk = "clang"
RUNTIME:pn-wpewebkit-rdk = "llvm"
TOOLCHAIN:pn-cog = "clang"
RUNTIME:pn-cog = "llvm"

PACKAGECONFIG:pn-weston-cog = "weston-direct-display"

IMAGE_INSTALL = "cog"

# needed
# needed
OCI_IMAGE_ENTRYPOINT = "/usr/bin/cog"
OCI_IMAGE_ENTRYPOINT_ARGS = "https://html5test.com/"
APP_METADATA_PATH = "metadatas/igalia-cog-appmetadata.json"

OCI_IMAGE_AUTHOR = "Damian Wrobel"
OCI_IMAGE_AUTHOR_EMAIL = "dwrobel@ertelnet.rybnik.pl"

