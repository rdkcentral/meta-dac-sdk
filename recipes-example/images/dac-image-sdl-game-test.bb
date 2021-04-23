SUMMARY = "DAC Container with SDL test application"

inherit  dac-image-sdl-game

IMAGE_INSTALL = "sdl-game-test"

# needed
OCI_IMAGE_ENTRYPOINT = "/usr/bin/sdl-game-test"
APP_METADATA_PATH = "metadatas/sdl-game-test-appmetadata.json"

# optional
OCI_IMAGE_AUTHOR = "LGi"
OCI_IMAGE_AUTHOR_EMAIL = "info@lgi.com"
OCI_IMAGE_ENTRYPOINT_ARGS = ""
OCI_IMAGE_WORKINGDIR = "/"
