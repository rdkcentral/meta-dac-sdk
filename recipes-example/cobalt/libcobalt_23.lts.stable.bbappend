require cobalt_dac.inc

# cobalt crashes on RPI when this patch is not applied
# this is a patch to cobalt core and can only be applied
# to libcobalt, not libloader-app
# this also means that cobalt evergreen, which uses 
# libloader-app is not supported on RPI
SRC_URI += "file://0005-changes-for-wayland.patch"
