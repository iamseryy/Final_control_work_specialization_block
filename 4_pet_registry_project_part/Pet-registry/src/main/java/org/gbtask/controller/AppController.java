package org.gbtask.controller;

import org.gbtask.config.AppConfig;
import org.gbtask.view.menu.impl.GeneralMenuImpl;

import java.util.logging.Level;

public class AppController {
    public static void start(){
        AppConfig.LOGGER.log(Level.INFO, "Application started");

        new GeneralMenuImpl().processing();
    }
}