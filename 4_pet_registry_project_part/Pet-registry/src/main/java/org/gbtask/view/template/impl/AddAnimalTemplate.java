package org.gbtask.view.template.impl;


import org.gbtask.view.menu.impl.AnimalSelectionMenuImpl;
import org.gbtask.view.template.Template;

public class AddAnimalTemplate implements Template {
    @Override
    public void output() {
        ui.output("\nAdd animal");
        new AnimalSelectionMenuImpl().processing();
    }
}