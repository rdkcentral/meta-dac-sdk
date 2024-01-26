require cobalt_dac.inc
SRC_URI += "file://0002-remove-rfc-api-24.patch;patchdir=${WORKDIR}/starboard"

# DAC sdk uses DISTRO poky which uses meta/conf/distro/include/security_flags.inc and not the
# security flags from RDK: meta-rdk/conf/distro/include/rdk_security_flags.inc
# This means that DAC sdk has this extra flag set inside SECURITY_LDFLAGS
# which RDK has not: -z,now
# Any missing symbols not found on app start will cause the app start to fail.
# In the patch below we avoid the missing symbols. As an alternative to this patch
# you could switch to lazy loading of deps by skipping the -z,now flag. To do this,
# uncomment the next line:
# SECURITY_LDFLAGS = "-fstack-protector -Wl,-z,relro"
# You can verify if libcobalt.so was built with the "now" flag as such:
# readelf -d libcobalt.so | grep NOW
SRC_URI += "file://0007-avoid-missing-symbols.patch"
