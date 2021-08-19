SUMMARY = "DAC Container image with shell"

inherit  dac-image-base

IMAGE_INSTALL_append = " libgcc"

# needed
OCI_IMAGE_ENTRYPOINT = "/bin/sh"
APP_METADATA_PATH = "metadatas/shell-appmetadata.json"


# optional
OCI_IMAGE_AUTHOR = "LGi"
OCI_IMAGE_AUTHOR_EMAIL = "info@lgi.com"
OCI_IMAGE_ENTRYPOINT_ARGS = ""
OCI_IMAGE_WORKINGDIR = "/"

