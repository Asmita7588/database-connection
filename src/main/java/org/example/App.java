package org.example;



import java.sql.*;


 class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/company"; //Database URL
        String user = "root";
        String password = "root";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Load MYsql JDBC driver
            Connection connection = DriverManager.getConnection(url, user, password); //Establish the connection
            Statement stmt = connection.createStatement();// create a statement object to execute the queries. //create a table
            System.out.println("Connection Establish successfully");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
