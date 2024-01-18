# work-around for flutter not being able to load application provided fonts
# Fontconfig error: Cannot load default config file
RDEPENDS_${PN} += "liberation-fonts"
