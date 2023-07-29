package org.gbtask.view.template.impl;

import org.gbtask.view.template.Template;


public class PrintRegistryTemplate implements Template {
    @Override
    public void output() {
        var all = registryService.findAll();
        System.out.println(all.toString());
    }
}
