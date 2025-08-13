require cobalt_dac.inc
require cobalt_rialto.inc

SRC_URI += "file://0006-backspace-to-esc.patch;patchdir=../larboard"
SRC_URI += "file://0001-Fix-to-resolve-build-failures.patch;patchdir=../larboard"
DEPENDS:remove = " virtual/vendor-secapi2-adapter virtual/vendor-gst-drm-plugins wpeframework-interfaces"

do_create_larboard_symlink() {
    srcdir="${WORKDIR}/git"
    if [ -d "${srcdir}/starboard" ] && [ ! -e "${srcdir}/larboard" ]; then
        ln -s starboard "${srcdir}/larboard"
        echo "Created symlink: larboard -> starboard"
    else
        echo "No starboard directory found or larboard already exists."
    fi
}
addtask do_create_larboard_symlink after do_fetch before do_patch

