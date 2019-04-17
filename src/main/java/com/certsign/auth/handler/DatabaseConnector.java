package com.certsign.auth.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;

@Component
public class DatabaseConnector {
  
  private static Connection connection = null;// DatabaseHandlers.connectToDB();
  
  private static Connection connectToDB() {
    Connection connection;
    try {
      Class.forName("org.hsqldb.jdbc.JDBCDriver");
      connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/auth_db", "SA", "");
      System.out.println("Connection to DB was successfully");
      return connection;
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
      System.out.println("Connection to DB failed");
      return null;
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("Connection to DB failed");
      return null;
    }
  }
  
  public static Connection getConnection() {
    try {
      if (connection == null || connection.isClosed()) {
        connection = connectToDB();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return connection;
  }
  
}
