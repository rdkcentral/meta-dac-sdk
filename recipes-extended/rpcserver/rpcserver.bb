##############################################################################
## If not stated otherwise in this file or this component's LICENSE file the
## following copyright and licenses apply:
##
## Copyright 2021 Liberty Global Service BV
##
## Licensed under the Apache License, Version 2.0 (the "License");
## you may not use this file except in compliance with the License.
## You may obtain a copy of the License at
##
## http://www.apache.org/licenses/LICENSE-2.0
##
## Unless required by applicable law or agreed to in writing, software
## distributed under the License is distributed on an "AS IS" BASIS,
## WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
## See the License for the specific language governing permissions and
## limitations under the License.
###############################################################################
SUMMARY = "JSON RPC server library with Websocket transport support. The work is done in scope of sessionmgr JSON RPC 2.0/WS API but library is implemented in a generic way to be used by other applications."
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=175792518e4ac015ab6696d16c4f607e"

DEPENDS = "boost websocketpp jsoncpp jsonrpc"
RDEPENDS_${PN} += "jsoncpp jsonrpc"

SRCREV = "${AUTOREV}"

SRC_URI ="${CMF_GIT_ROOT}/components/opensource/rpcserver;name=rpcserver;protocol=${RDK_GIT_PROTOCOL};branch=${CMF_GIT_MASTER_BRANCH}"

S = "${WORKDIR}/git/"

inherit pkgconfig cmake coverity
