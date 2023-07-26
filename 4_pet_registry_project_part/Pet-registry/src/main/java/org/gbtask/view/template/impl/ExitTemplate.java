package org.gbtask.view.template.impl;

import org.gbtask.config.AppConfig;
import org.gbtask.view.template.Template;

import java.util.logging.Level;

public class ExitTemplate implements Template {
    @Override
    public void output() {
        AppConfig.LOGGER.log(Level.INFO, "Application closed");
    }
}