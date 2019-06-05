package com.simpleWeb.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHelper {
    private static Connection connection;
    private static String DB_NAME = "student-manager";
    private static String DB_USER = "root";
    private static String DB_PASSWORD = "";

    public static Connection getConnection() throws Exception {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DB_NAME + "?user=" + DB_USER + "&password=" + DB_PASSWORD + "");
        }
        return connection;
    }
}
