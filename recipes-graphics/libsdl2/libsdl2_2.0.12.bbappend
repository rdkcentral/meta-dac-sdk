FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://0001-add-possibility-to-preload-egl-functions.patch"
SRC_URI += "https://git.sailfishos.org/mer-core/libsdl/raw/7752273b154ffb11fc65a31deca1bd75d1b213ee/rpm/sdl2-wayland-input-fix.patch;apply=yes;name=wayland_patch"
SRC_URI[wayland_patch.md5sum] = "981af182db41b5432503ed1a6161ff36"
SRC_URI[wayland_patch.sha256sum] = "171480b7b6587a08acfa92499aafeacd0d8409e4f2146d43d19568c035e71a94"

