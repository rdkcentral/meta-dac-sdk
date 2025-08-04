SUMMARY = "Generate a information to build logrotate data configuration for the recipe"

python do_write_metadata_logrotate() {

    import os
    log_path = "/opt/logs"
    metadata_dir = d.expand('${D}${sysconfdir}')  + "/logrotate/"
    if not os.path.exists(metadata_dir):
        os.makedirs(metadata_dir)
    if d.getVar('LOGROTATE_NAME', True) != None:
        name_list = d.getVar('LOGROTATE_NAME', True).split()
        for fname in name_list:
            config_file = metadata_dir + d.getVar('PN', True) + fname + "_orig.metadata"
            mem_config_file = metadata_dir + d.getVar('PN', True) + fname + "_mem.metadata"
            with open(config_file, 'w') as conf:
                with open(mem_config_file, 'w') as memconf:
                    logname_tag = 'LOGROTATE_LOGNAME_' + fname
                    if d.getVar(logname_tag, True) != None:
                        name = d.getVar(logname_tag, True)
                        conf.write("%s/%s {\n" % (log_path,name))
                        memconf.write("%s/%s {\n" % (log_path,name))
                        size_tag = 'LOGROTATE_SIZE_' + fname
                        if d.getVar(size_tag, True) != None:
                            size = d.getVar(size_tag, True)
                            conf.write("size %s\n" % (size))
                        rotate_tag =  'LOGROTATE_ROTATION_' + fname
                        if d.getVar(rotate_tag, True) != None:
                            rotate = d.getVar(rotate_tag, True)
                            conf.write("rotate %s\n" % (rotate))
                        mem_size_tag = 'LOGROTATE_SIZE_MEM_' + fname
                        if d.getVar(mem_size_tag, True) != None:
                            mem_size = d.getVar(mem_size_tag, True)
                            memconf.write("size %s\n" % (mem_size))
                        mem_rotate_tag =  'LOGROTATE_ROTATION_MEM_' + fname
                        if d.getVar(mem_rotate_tag, True) != None:
                            mem_rotate = d.getVar(mem_rotate_tag, True)
                            memconf.write("rotate %s\n" % (mem_rotate))
                    conf.write("copytruncate\n")
                    conf.write("missingok\n")
                    conf.write("ignoreduplicates\n")
                    conf.write("}\n")
                    memconf.write("copytruncate\n")
                    memconf.write("missingok\n")
                    memconf.write("ignoreduplicates\n")
                    memconf.write("}\n")
                    conf.close()
                    memconf.close()
}

python() {
    if bb.utils.contains('DISTRO_FEATURES', 'systemd', True, False, d):
        bb.build.addtask("write_metadata_logrotate", "do_package", "do_install", d)
}

FILES:${PN} += "${@bb.utils.contains('DISTRO_FEATURES','systemd',' ${sysconfdir}/* ','',d)}"
