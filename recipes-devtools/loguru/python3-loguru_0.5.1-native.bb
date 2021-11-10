SUMMARY = "loguru recipe."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=17a1d3575545a1e1c7c7f835388beafe"

SRC_URI_remove="https://files.pythonhosted.org/packages/source/l/loguru/loguru-0.5.1-native.tar.gz"

SRC_URI+= "https://github.com/Delgan/loguru/archive/0.5.1.tar.gz;name=loguru-0.5.1"
#SRC_URI[sha256sum] = "e2bef322f8396f20949620b7d8f103cf6ad9a3b5c57f8c8023fb23aff01b0f8e"
SRC_URI[loguru-0.5.1.sha256sum] = "e2bef322f8396f20949620b7d8f103cf6ad9a3b5c57f8c8023fb23aff01b0f8e"


S="${WORKDIR}/loguru-0.5.1"

PYPI_PACKAGE = "loguru"
inherit setuptools3

UPSTREAM_CHECK_REGEX = "loguru/(?P<pver>\d+(\.\d+)+)/"

BBCLASSEXTEND = "native nativesdk"
