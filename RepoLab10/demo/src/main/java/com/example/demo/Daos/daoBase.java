package com.example.demo.Daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class daoBase {

    public Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String user = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/lab7";

        return DriverManager.getConnection(url, user, password);
    }
}
