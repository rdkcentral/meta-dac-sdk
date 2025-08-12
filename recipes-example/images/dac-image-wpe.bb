SUMMARY = "WPE DAC Container"
LICENSE = "MIT"

inherit dac-image-wayland

IMAGE_INSTALL = "cog"
IMAGE_INSTALL += "liberation-fonts"

OCI_IMAGE_ENTRYPOINT = "/usr/bin/cog"
OCI_IMAGE_ENTRYPOINT_ARGS = "https://ytlr-cert.appspot.com/2021/main.html"
OCI_IMAGE_ENTRYPOINT_ARGS .= "\\@\\--enable-encrypted-media=1\\@\\--set-permissions=all"

OCI_IMAGE_ENV_VARS += "WEBKIT_GST_QUIRKS=rialto"
OCI_IMAGE_ENV_VARS += "WEBKIT_GST_HOLE_PUNCH_QUIRK=rialto"
OCI_IMAGE_ENV_VARS += "WEBKIT_GST_ENABLE_AUDIO_MIXER=1"

APP_METADATA_PATH = "metadatas/wpe-appmetadata.json"

OCI_IMAGE_AUTHOR = "Adam Stolcenburg"
OCI_IMAGE_AUTHOR_EMAIL = "adam_stolcenburg@comcast.com"
