SUMMARY = "Base class for DAC Images with essos egl support"

inherit dac-image-base

cleanup_hw_dependent_libs () {
    rm -rf ${IMAGE_ROOTFS}/usr/lib/libEGL*
    rm -rf ${IMAGE_ROOTFS}/usr/lib/libGLES*
    rm -rf ${IMAGE_ROOTFS}/usr/lib/libGLdispatch*
    rm -rf ${IMAGE_ROOTFS}/usr/lib/libessos*
}

ROOTFS_POSTPROCESS_COMMAND += "${@bb.utils.contains('DISTRO_FEATURES', 'cleanup_gfx', 'cleanup_hw_dependent_libs;', '', d)}"
