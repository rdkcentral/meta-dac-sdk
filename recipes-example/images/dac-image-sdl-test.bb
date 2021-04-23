SUMMARY = "DAC Container with SDL test application"

inherit  dac-image-sdl

IMAGE_INSTALL = "sdl-test"

# needed
OCI_IMAGE_ENTRYPOINT = "/usr/bin/sdl-test"
APP_METADATA_PATH = "metadatas/sdl-test-appmetadata.json"

# optional
OCI_IMAGE_AUTHOR = "LGi"
OCI_IMAGE_AUTHOR_EMAIL = "info@lgi.com"
OCI_IMAGE_ENTRYPOINT_ARGS = ""
OCI_IMAGE_WORKINGDIR = "/"
