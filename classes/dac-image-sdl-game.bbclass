SUMMARY = "Base class for DAC Images with SDL support"

inherit  dac-image-wayland

DISTRO_FEATURES:append = " wayland"

IMAGE_INSTALL:append = " libsdl2"
IMAGE_INSTALL:append = " libsdl2-image"
IMAGE_INSTALL:append = " libsdl2-ttf"
IMAGE_INSTALL:append = " ttf-abyssinica"

