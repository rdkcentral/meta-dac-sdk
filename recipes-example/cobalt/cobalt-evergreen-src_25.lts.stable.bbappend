# RPi specific change
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

# Workaround for REFPLTV-2693
SRC_URI += "${@bb.utils.contains('DISTRO_FEATURES', 'no_pixel_buffer_surfaces', 'file://0001-wayland-changes-cobalt24.patch', '', d)}"
