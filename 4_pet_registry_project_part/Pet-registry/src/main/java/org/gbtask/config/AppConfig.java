package org.gbtask.config;

import org.gbtask.controller.AppController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppConfig {
    public static final Logger LOGGER = Logger.getLogger(AppController.class.getName());
    private static final String PATH_TO_PROPERTIES = "src/main/resources/config.properties";

    public static String getProperty(String key) {
        var property = new Properties();
        try(var inputStream = new FileInputStream(PATH_TO_PROPERTIES);){
            property.load(inputStream);

        } catch (IOException e){
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }

        return property.getProperty(key);
    }
}