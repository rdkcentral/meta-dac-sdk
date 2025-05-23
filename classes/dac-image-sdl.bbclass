SUMMARY = "Base class for DAC Images with SDL support"

inherit  dac-image-wayland

IMAGE_INSTALL:append = " libsdl2"

