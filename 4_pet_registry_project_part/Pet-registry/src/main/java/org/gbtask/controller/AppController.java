package org.gbtask.controller;

import org.gbtask.view.menu.impl.GeneralMenuImpl;

import java.io.IOException;
import java.sql.*;

public class AppController {
    public static void start(){
        new GeneralMenuImpl().processing();
    }
}