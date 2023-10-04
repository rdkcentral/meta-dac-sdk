SUMMARY = "DAC Container with Amazon Prime 5.1"

inherit dac-image-essos

IMAGE_INSTALL = "amazon-prime-src strace gstreamer1.0-plugins-base gstreamer1.0"

# needed
OCI_IMAGE_ENTRYPOINT = "/usr/bin/ignition"
APP_METADATA_PATH = "metadatas/amazonprime5-appmetadata.json"

# optional
OCI_IMAGE_AUTHOR = "LGi"
OCI_IMAGE_AUTHOR_EMAIL = "info@lgi.com"
#OCI_IMAGE_ENTRYPOINT_ARGS = "--log-level=ALL:DEBUG"
OCI_IMAGE_ENTRYPOINT_ARGS = "--log-level=ALL:INFO"
OCI_IMAGE_WORKINGDIR = "/usr/persist/"
#OCI_IMAGE_WORKINGDIR = "/usr/bin/"
#OCI_IMAGE_ENV_VARS += "GST_DEBUG_DUMP_DOT_DIR=/tmp/gst"
OCI_IMAGE_ENV_VARS += "GST_ENABLE_SVP=1"
#OCI_IMAGE_ENV_VARS += "GST_DEBUG="GST_CAPS:7,*:3,brcmvideosink:5,rialto*:5""
OCI_IMAGE_ENV_VARS += "GST_DEBUG="*:3""
