SUMMARY = "slide_puzzle (flutter based application) in OCI Container"

IMAGE_FSTYPES = "container oci"

inherit dac-image-base

IMAGE_CONTAINER_NO_DUMMY = "1"

IMAGE_LINGUAS = " "
LICENSE = "MIT"

IMAGE_INSTALL_append = " flutter-examples-slide-puzzle"
# Let's use 'wayland-launcher' as there is no automatic runtime
# dependency from slide_puzzle to any flutter launcher.
IMAGE_INSTALL_append = " flutter-launcher-wayland"

OCI_IMAGE_AUTHOR = "Damian Wrobel"
OCI_IMAGE_AUTHOR_EMAIL = "dwrobel@ertelnet.rybnik.pl"

# config:Entrypoint
OCI_IMAGE_ENTRYPOINT = "/usr/bin/flutter-launcher-wayland"
OCI_IMAGE_ENTRYPOINT_ARGS = "/usr/share/flutter/apps/slide_puzzle/data/flutter_assets"
APP_METADATA_PATH = "metadatas/flutter-slide-puzzle-appmetadata.json"

# config:Env
#OCI_IMAGE_ENV_VARS = '"PATH=/usr/local/bin:/usr/local/sbin:/usr/bin:/usr/sbin:/bin"'
