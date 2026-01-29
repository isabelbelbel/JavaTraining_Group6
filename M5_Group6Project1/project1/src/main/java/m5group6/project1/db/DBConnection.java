package m5group6.project1.db;

import java.sql.*;

public class DBConnection {
	
	//Database connection
    public static Connection getConnection() {
        try {
            String url = "jdbc:postgresql://localhost:5432/training_db"; //
            String user = "jiasanchez"; //Change to local User 
            String pass = "postgres"; //Change to local Password
            return DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
