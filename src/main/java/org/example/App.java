package org.example;



import java.sql.*;
import java.util.Enumeration;


class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/payroll_service"; //Database URL
        String user = "root";
        String password = "root";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Load MYsql JDBC driver
            Connection connection = DriverManager.getConnection(url, user, password); //Establish the connection
            Statement stmt = connection.createStatement();// create a statement object to execute the queries. //create a table
            System.out.println("Connection Establish successfully");

            String query = "select * from employee_payroll";
           ResultSet rs = stmt.executeQuery(query);
           while (rs.next()){
               System.out.println("ID : " +rs.getInt("id") + " " + "Name : "+ rs.getString("name") + " " + "Salary = " + rs.getDouble("salary") );
           }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        listDrivers();
    }
        private static void listDrivers()
    {
            Enumeration<Driver> driverList = DriverManager.getDrivers();
           while( driverList.hasMoreElements()){
               Driver driverClass = (Driver)driverList.nextElement();
               System.out.println(driverClass.getClass().getName());
           }

        }

    }


