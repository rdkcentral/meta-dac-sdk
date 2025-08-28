# Enable the distro to generate Cobalt-25 OCI image for devices that do not support pixel buffer surfaces
#DISTRO_FEATURES:append = " no_pixel_buffer_surfaces"

# Enable YouTube 2025 support in Evergreen model
DISTRO_FEATURES:append = " cobalt_enable_evergreen_lite"

DISTRO_FEATURES:append = " cobalt-25"
DISTRO_FEATURES:append = " enable_icrypto_openssl"
DISTRO_FEATURES:append = " enable_rialto"
DISTRO_FEATURES:append = " gstreamer1_18"
DISTRO_FEATURES:append = " wpe_r4_4"
