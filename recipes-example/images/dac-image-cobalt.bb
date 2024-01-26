SUMMARY = "DAC Container with Cobalt"

inherit  dac-image-essos

IMAGE_INSTALL = "cobalt-launcher"

# needed
OCI_IMAGE_ENTRYPOINT = "/usr/bin/cobalt-launcher"
APP_METADATA_PATH = "metadatas/cobalt-appmetadata.json"

# optional
OCI_IMAGE_AUTHOR = "LGi"
OCI_IMAGE_AUTHOR_EMAIL = "info@lgi.com"
OCI_IMAGE_ENTRYPOINT_ARGS = ""
OCI_IMAGE_WORKINGDIR = "/"
OCI_IMAGE_ENV_VARS = "HOME=/home/root/"
OCI_IMAGE_ENV_VARS += "COBALT_WS_PORT=0"
OCI_IMAGE_LABELS += "public.requires.rialto=1"
OCI_IMAGE_LABELS += "public.requires.ocdm=1"
