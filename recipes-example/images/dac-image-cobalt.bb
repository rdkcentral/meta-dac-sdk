SUMMARY = "DAC Container with Cobalt"

inherit  dac-image-essos

IMAGE_INSTALL = "libcobalt"

# needed
OCI_IMAGE_ENTRYPOINT = "/usr/bin/cobalt_bin"
APP_METADATA_PATH = "metadatas/cobalt-appmetadata.json"

# optional
OCI_IMAGE_AUTHOR = "LGi"
OCI_IMAGE_AUTHOR_EMAIL = "info@lgi.com"
OCI_IMAGE_ENTRYPOINT_ARGS = ""
OCI_IMAGE_WORKINGDIR = "/"
OCI_IMAGE_ENV_VARS = "HOME=/home/root/"
