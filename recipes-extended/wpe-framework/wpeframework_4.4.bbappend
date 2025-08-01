RDEPENDS_${PN}_remove_rpi = "userland"

DEPENDS += "curl"
DEPENDS_remove = "breakpad-wrapper"
DEPENDS_remove = "rfc"
DEPENDS_remove = "thunderhangrecovery"

PACKAGECONFIG_remove = " sdnotify"

EXTRA_OECMAKE_remove = "-DMESSAGING=ON"
EXTRA_OECMAKE += " \
	-DCORE=ON \
	-DCRYPTALGO=ON \
	-DWEBSOCKET=ON \
	-DMESSAGING=OFF \
	-DCOM=OFF \
	-DPROCESS=OFF \
	-DPLUGINS=OFF \
	-DEXECUTABLE=OFF \
"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://0001-remove-deps-4.2.patch"
