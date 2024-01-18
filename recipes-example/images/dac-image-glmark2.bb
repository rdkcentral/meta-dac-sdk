SUMMARY = "cog in OCI Container"

IMAGE_FSTYPES = "container oci"

#inherit image
#inherit image-oci
inherit dac-image-base

IMAGE_CONTAINER_NO_DUMMY = "1"

IMAGE_LINGUAS = " "
LICENSE = "MIT"

IMAGE_INSTALL_append = " glmark2-script"

OCI_IMAGE_AUTHOR = "Damian Wrobel"
OCI_IMAGE_AUTHOR_EMAIL = "dwrobel@ertelnet.rybnik.pl"

# config:Entrypoint
OCI_IMAGE_ENTRYPOINT = "/usr/bin/glmark2.sh"

# config:Env
OCI_IMAGE_ENV_VARS = '"PATH=/usr/local/bin:/usr/local/sbin:/usr/bin:/usr/sbin:/bin"'

# config:Cmd
#OCI_IMAGE_ENTRYPOINT_ARGS = "sh"

APP_METADATA_PATH = "metadatas/glmark2-appmetadata.json"
