SUMMARY = "OpenGL 2.0 and ES 2.0 benchmark in OCI Container"

IMAGE_FSTYPES = "container oci"

#inherit image
#inherit image-oci
inherit dac-image-wayland

IMAGE_CONTAINER_NO_DUMMY = "1"

IMAGE_LINGUAS = " "
LICENSE = "MIT"

IMAGE_INSTALL_append = " glmark2"

OCI_IMAGE_AUTHOR = "Damian Wrobel"
OCI_IMAGE_AUTHOR_EMAIL = "dwrobel@ertelnet.rybnik.pl"

# config:Entrypoint
OCI_IMAGE_ENTRYPOINT = "/usr/bin/glmark2-es2-wayland"

# config:Env
OCI_IMAGE_ENV_VARS = '"PATH=/usr/local/bin:/usr/local/sbin:/usr/bin:/usr/sbin:/bin"'

# config:Cmd
OCI_IMAGE_ENTRYPOINT_ARGS = "--size\@\1920x1080\@\--annotate\@\--show-all-options"

APP_METADATA_PATH = "metadatas/glmark2-appmetadata.json"
