package com.mvc.util;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class DBConnection {
 public static Connection createConnection()
 {
     Connection con = null;
     String url = "jdbc:mysql://localhost:3306/login"; //MySQL URL and followed by the database name
     String username = "root"; //MySQL username
     String password = "Mounika.1025"; //MySQL password   
     try 
     {
         try 
         {
            Class.forName("com.mysql.jdbc.Driver"); //loading mysql driver 
         } 
         catch (ClassNotFoundException e)
         {
            e.printStackTrace();
         } 
         con = DriverManager.getConnection(url, username, password); //attempting to connect to MySQL database
         System.out.println("Printing connection object "+con);
     } 
     catch (SQLException e)
     {
        System.out.println("An error occurred. Maybe user/password is invalid");
      e.printStackTrace();
    }
 return con;
 }
}