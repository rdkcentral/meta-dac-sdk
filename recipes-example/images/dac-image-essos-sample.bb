SUMMARY = "DAC Container with essos egl test application"

inherit  dac-image-essos

IMAGE_INSTALL = "essos-test"

# needed
OCI_IMAGE_ENTRYPOINT = "/usr/bin/essos-sample"
APP_METADATA_PATH = "metadatas/essos-appmetadata.json"

# optional
OCI_IMAGE_AUTHOR = "LGi"
OCI_IMAGE_AUTHOR_EMAIL = "info@lgi.com"
OCI_IMAGE_ENTRYPOINT_ARGS = ""
OCI_IMAGE_WORKINGDIR = "/"
