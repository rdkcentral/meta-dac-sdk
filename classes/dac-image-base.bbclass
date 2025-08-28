SUMMARY = "Base class for DAC Images"

IMAGE_FSTYPES = "container oci"

inherit image
inherit image-oci
inherit ${@bb.utils.contains("BUNDLE_GENERATE", "1", "dac-bundle", "", d)}

PREFERRED_PROVIDER_virtual/kernel = "linux-dummy"

IMAGE_INSTALL = " "
IMAGE_INSTALL:append = " glibc"
IMAGE_INSTALL:append = " ldconfig"
IMAGE_INSTALL:append = " dash"

# fix for update_gio_module_cache and update_font_cache error on do_rootfs
DEPENDS += "${@bb.utils.contains('BUNDLE_GENERATE', '1', 'qemuwrapper-cross', '', d)}"

IMAGE_LINGUAS = " "
LICENSE = "MIT"

APP_METADATA_PATH = " "

OCI_IMAGE_TAR_OUTPUT=""

IMAGE_CMD:oci:append() {

    if [ -n "$image_name" ]; then
        file_name="$image_name.tar"
    else
        image_name="${IMAGE_NAME}${IMAGE_NAME_SUFFIX}-oci"
        file_name="${IMAGE_NAME}${IMAGE_NAME_SUFFIX}-oci-${OCI_IMAGE_TAG}-${OCI_IMAGE_ARCH}${OCI_IMAGE_SUBARCH:+"-$OCI_IMAGE_SUBARCH"}-linux.oci-image.tar"
    fi

    if [ -z "${OCI_IMAGE_TAR_OUTPUT}" ]; then
        tar --sort=name --format=posix --numeric-owner -cf ${file_name} -C ${image_name} .
    fi

    ln -fs ${file_name} ${IMAGE_BASENAME}.tar
}

do_rootfs:append() {
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

