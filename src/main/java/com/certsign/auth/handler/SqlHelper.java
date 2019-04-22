package com.certsign.auth.handler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

@Component
public class SqlHelper {
  
  private DatabaseConnector _databaseHandlers;
  
  public boolean checkCredentials(String username, String password) throws SQLException {
    System.out.println("Checking credetials");
      String sql = "SELECT id FROM users WHERE username = '" + username + "' AND password = '" + password + "';";
      ResultSet st = null;
      try (PreparedStatement ps = _databaseHandlers.getConnection().prepareStatement(sql)) {
        st = ps.executeQuery();
        if (st.next() == false) {
          return false;
        } else {
          return true;
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    return false;
  }
  
  public void writeTokenToDB(String token, String username) throws SQLException {
    System.out.println("Writing token to DB");
      String sql = "UPDATE users SET token = '" + token + "' WHERE username = '" + username + "';";
      int st = 0;
      try (PreparedStatement ps = _databaseHandlers.getConnection().prepareStatement(sql)) {
        st = ps.executeUpdate();
      } catch (Exception e) {
        e.printStackTrace();
      }
  }
}
