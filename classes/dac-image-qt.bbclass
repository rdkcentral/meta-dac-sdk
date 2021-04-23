SUMMARY = "Base class for DAC Images with QT support"

inherit  dac-image-wayland

OCI_IMAGE_ENV_VARS += "\
  QT_QPA_PLATFORM=wayland-egl \
"


