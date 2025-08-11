python () {
    if 'meta-cmf' in d.getVar('BBLAYERS', True):
        d.setVar('RDK_FLAVOR', 'rdkv')
    else:
        d.setVar('RDK_FLAVOR', 'rdke')
}
