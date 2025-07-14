SUMMARY = "WPE DAC Container"
LICENSE = "MIT"

inherit dac-image-wayland

IMAGE_INSTALL = "cog"
IMAGE_INSTALL += "liberation-fonts"

OCI_IMAGE_ENTRYPOINT = "/usr/bin/cog"
OCI_IMAGE_ENTRYPOINT_ARGS = "http://keycode.info"

APP_METADATA_PATH = "metadatas/wpe-appmetadata.json"

OCI_IMAGE_AUTHOR = "Adam Stolcenburg"
OCI_IMAGE_AUTHOR_EMAIL = "adam_stolcenburg@comcast.com"
