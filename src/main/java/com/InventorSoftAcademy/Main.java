package com.InventorSoftAcademy;

import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@AllArgsConstructor
public class Main {

    public static void main(String[] args) throws SQLException {
        Connection connection = new ConnectionManager().getConnection();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("Select * from students");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("firstname") + "|"
                + resultSet.getString("lastname") +  "|" + resultSet.getInt("age"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}