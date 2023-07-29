package org.gbtask.view.menu.impl;

import org.gbtask.view.menu.GeneralMenu;
import org.gbtask.view.menu.Menu;

public class GeneralMenuImpl extends Menu implements GeneralMenu {
    public void processing() {
        super.processing(header, generalMenuItems);
    }
}