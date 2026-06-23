package config;

import java.sql.*;

public class DatabaseConnection {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:ORCL";

    private static final String USERNAME = "bankuser";

    private static final String PASSWORD = "bank123";

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(
                    URL,
                    USERNAME,
                    PASSWORD
            );
        } catch (Exception e) {
            System.out.println(
                    "Database Connection Failed"
            );
            e.printStackTrace();
            return null;
        }
    }
}
