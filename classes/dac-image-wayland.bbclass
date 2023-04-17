SUMMARY = "Base class for DAC Images with wayland egl support"

inherit  dac-image-base

IMAGE_INSTALL_append = " wayland"

cleanup_hw_dependent_libs () {
    rm -rf ${IMAGE_ROOTFS}/usr/lib/libEGL*
    rm -rf ${IMAGE_ROOTFS}/usr/lib/libGLES*
    rm -rf ${IMAGE_ROOTFS}/usr/lib/libGLdispatch*
    rm -rf ${IMAGE_ROOTFS}/usr/lib/libwayland-egl*
    rm -rf ${IMAGE_ROOTFS}/usr/lib/libwayland-server*
}

ROOTFS_POSTPROCESS_COMMAND += "${@bb.utils.contains('DISTRO_FEATURES', 'cleanup_gfx', 'cleanup_hw_dependent_libs;', '', d)}"
