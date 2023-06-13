SUMMARY = "DAC Container with Netflix"

inherit  dac-image-essos

IMAGE_INSTALL = "netflix"

# needed
OCI_IMAGE_ENTRYPOINT = "/usr/share/netflix/bin/netflix"
APP_METADATA_PATH = "metadatas/netflix-appmetadata.json"

# optional
OCI_IMAGE_AUTHOR = "LGi"
OCI_IMAGE_AUTHOR_EMAIL = "info@lgi.com"
OCI_IMAGE_ENTRYPOINT_ARGS = ""
OCI_IMAGE_WORKINGDIR = "/"
OCI_IMAGE_ENV_VARS += "HOME=/home/root/"
OCI_IMAGE_ENV_VARS += "NF_DATA_DIR=/usr/share/netflix/bin/data"
OCI_IMAGE_ENV_VARS += "NF_WRITE_DATA_PATH=/opt/netflix"
OCI_IMAGE_ENV_VARS += "NETFLIX_VAULT=/opt/netflix-binfile.bin"
OCI_IMAGE_LABELS += "public.requires.rialto=1"
OCI_IMAGE_LABELS += "public.requires.ocdm=1"
