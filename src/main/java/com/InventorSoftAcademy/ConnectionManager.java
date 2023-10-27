package com.InventorSoftAcademy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@Data
@AllArgsConstructor
public class ConnectionManager {
    private static Connection connection;
    private static String url = "jdbc:postgresql://localhost:5432/University";
    private static String username = "postgres";
    private static String password = "01082022";
    public Connection getConnection() throws SQLException {

        try{
           connection = DriverManager.getConnection(url, username, password);

        } catch (SQLException ex){
            System.out.println("Failed to create the database connection.");
        }
        return connection;
    }
}
