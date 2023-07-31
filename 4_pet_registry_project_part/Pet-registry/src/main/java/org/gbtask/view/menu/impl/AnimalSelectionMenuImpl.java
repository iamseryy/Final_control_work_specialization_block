package org.gbtask.view.menu.impl;

import org.gbtask.view.menu.AnimalSelectionMenu;
import org.gbtask.view.menu.Menu;


public class AnimalSelectionMenuImpl  extends Menu implements AnimalSelectionMenu {
    public void processing() {
        super.processing(header, menuItems);
    }
}
