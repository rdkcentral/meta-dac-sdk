DEPENDS = "bundlegen-native"

BUNDLE_PLATFORM ?= "rpi3_reference_vc4_dunfell"
BUNDLE_OPTIONS  ?= "-m normal --createmountpoints"

PSEUDO_IGNORE_PATHS .= ",${TOPDIR}/bundles"

make_bundle() {
  BUNDLE_SUFFIX="${IMAGE_VERSION_SUFFIX}"
  BUNDLEGEN_SYSROOTPATH=$(which bundlegen)
  BUNDLEGEN_SYSROOTPATH=$(dirname $BUNDLEGEN_SYSROOTPATH)/../share/bundlegen/
  BUNDLEGEN_WORKINGDIR=$(dirname $BUNDLEGEN_SYSROOTPATH)/../share/
  if [ -z "${BUNDLE_TEMPLATE_PATH+x}" ]; then
    BUNDLE_TEMPLATE_PATH=${BUNDLEGEN_SYSROOTPATH}/templates
  fi

  mkdir -p ${IMGDEPLOYDIR}/bundle
  mkdir -p ${TOPDIR}/bundles/${BUNDLE_PLATFORM}
  tar -xf ${IMGDEPLOYDIR}/${IMAGE_BASENAME}.tar -C ${IMGDEPLOYDIR}/bundle

  cd $BUNDLEGEN_WORKINGDIR
  bundlegen -vvv generate --searchpath ${BUNDLE_TEMPLATE_PATH} ${BUNDLE_OPTIONS} --platform ${BUNDLE_PLATFORM} oci:${IMGDEPLOYDIR}/bundle:latest ${TOPDIR}/bundles/${BUNDLE_PLATFORM}/${IMAGE_BASENAME}_bundle${BUNDLE_SUFFIX}
  ln -sf ${TOPDIR}/bundles/${BUNDLE_PLATFORM}/${IMAGE_BASENAME}_bundle${BUNDLE_SUFFIX}.tar.gz ${TOPDIR}/bundles/${BUNDLE_PLATFORM}/${IMAGE_BASENAME}_bundle.tgz
  rm -rf ${IMGDEPLOYDIR}/bundle
  rm -rf ${TOPDIR}/bundles/${BUNDLE_PLATFORM}/${IMAGE_BASENAME}_bundle${BUNDLE_SUFFIX}
  
  cp -f ${BUNDLEGEN_SYSROOTPATH}/testapp.sh ${TOPDIR}/bundles
  cp -f ${BUNDLEGEN_SYSROOTPATH}/test.sh ${TOPDIR}/bundles/${BUNDLE_PLATFORM}
  sed -i 's/BUNDLE-TGZ-NAME/${IMAGE_BASENAME}_bundle.tgz/' ${TOPDIR}/bundles/${BUNDLE_PLATFORM}/test.sh
}

IMAGE_POSTPROCESS_COMMAND += "make_bundle ;"
