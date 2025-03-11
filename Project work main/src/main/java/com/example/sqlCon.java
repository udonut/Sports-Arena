package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** Add your own PostgreSQL or MySQL connection information here **/

public class sqlCon {

    public static Connection sqlCon() throws SQLException {   
        try {
            Class.forName("org.postgresql.Driver"); // Postgre JDBC driver (change to MySQL if needed)
        } catch (ClassNotFoundException e) {
            System.out.println("error, postgre JDBC driver not found"); 
            e.printStackTrace();
            return null;
        }
    
        return DriverManager.getConnection(
            " ", // add your own database
            " ", // add your own username
            " ");  // add your own password
    }
    
}
