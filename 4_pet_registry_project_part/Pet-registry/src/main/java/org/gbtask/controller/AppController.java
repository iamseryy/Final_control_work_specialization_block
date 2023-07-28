package org.gbtask.controller;

import org.gbtask.view.menu.impl.GeneralMenuImpl;

public class AppController {
    public static void start(){
        new GeneralMenuImpl().processing();
    }
}