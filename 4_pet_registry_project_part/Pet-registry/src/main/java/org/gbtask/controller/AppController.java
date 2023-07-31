package org.gbtask.controller;

import org.gbtask.view.menu.impl.GeneralMenuImpl;

import java.io.IOException;
import java.sql.*;

public class AppController {
    public static void start(){
        new GeneralMenuImpl().processing();
//        try {
//            testSql();
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }


    }


    static void testSql() throws ClassNotFoundException {
        System.out.println("Registering JDBC driver...");
        //Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/pet_registry", "root", "1001");){
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM cat";
            ResultSet resultSet = statement.executeQuery(sql);


            System.out.println("Retrieving data from database...");
            System.out.println("\nCats:");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int height = resultSet.getInt("height");
                int weight = resultSet.getInt("weight");
                String name = resultSet.getString("name");


                System.out.println("\n================\n");
                System.out.println("id: " + id);
                System.out.println("height: " + height);
                System.out.println("weight " + weight);
                System.out.println("Name: " + name);

            }

            System.out.println("Closing connection and releasing resources...");
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}