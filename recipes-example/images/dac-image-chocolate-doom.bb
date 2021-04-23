SUMMARY = "DAC chocolate-doom port"

inherit  dac-image-sdl

IMAGE_INSTALL = "chocolate-doom"

IMAGE_INSTALL_append = " alsa-lib"

# needed
OCI_IMAGE_ENTRYPOINT = "/usr/bin/chocolate-doom"

APP_METADATA_PATH = "metadatas/chocolate-doom-appmetadata.json"

# optional
OCI_IMAGE_AUTHOR = "LGi"
OCI_IMAGE_AUTHOR_EMAIL = "info@lgi.com"
OCI_IMAGE_WORKINGDIR = "/"

# sloci splits strings into arrays on "\@\", which we need to escape in Bitbake to "\\@\\"
OCI_IMAGE_ENTRYPOINT_ARGS = "-iwad\\@\\/usr/share/doom1.wad"

# Without a HOME envvar, doom will segfault on startup. 
# Back this dir with persistant storage via Dobby storage plugin so we can actually have working saves!
OCI_IMAGE_ENV_VARS = "HOME=/home/root/"
