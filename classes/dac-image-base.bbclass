SUMMARY = "Base class for DAC Images"

IMAGE_FSTYPES = "container oci"

inherit image
inherit image-oci
inherit ${@bb.utils.contains("BUNDLE_GENERATE", "1", "dac-bundle", "", d)}

PREFERRED_PROVIDER_virtual/kernel = "linux-dummy"

IMAGE_INSTALL = " "
IMAGE_INSTALL_append = " glibc"
IMAGE_INSTALL_append = " ldconfig"
IMAGE_INSTALL_append = " dash"

# fix for update_gio_module_cache and update_font_cache error on do_rootfs
DEPENDS += "${@bb.utils.contains('BUNDLE_GENERATE', '1', 'qemuwrapper-cross', '', d)}"

IMAGE_LINGUAS = " "
LICENSE = "MIT"

APP_METADATA_PATH = " "

IMAGE_CMD_oci_append() {
    file_name="${IMAGE_NAME}${IMAGE_NAME_SUFFIX}-oci-${OCI_IMAGE_TAG}-${OCI_IMAGE_ARCH}${OCI_IMAGE_SUBARCH:+"-$OCI_IMAGE_SUBARCH"}-linux.oci-image.tar"
    ln -fs ${file_name} ${IMAGE_BASENAME}.tar
}

do_rootfs_append() {
    from os import path, system

    images_path = str(d.getVar('THISDIR'))
    appmetadata_path = path.join(images_path, str(d.getVar('APP_METADATA_PATH')))

    if not path.isfile(appmetadata_path):
        bb.error(f"Cannot open metadata file at location '{appmetadata_path}', please make sure that 'APP_METADATA_PATH' variable is properly set")
        sys.exit(1)
    else:
        desired_path = path.abspath(path.join(str(d.getVar('D')), "..", "rootfs", "appmetadata.json"))
        system(f"cp -f {appmetadata_path} {desired_path}")
}

