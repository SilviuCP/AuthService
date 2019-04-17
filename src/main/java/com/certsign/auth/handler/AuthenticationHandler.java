package com.certsign.auth.handler;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationHandler {
  
  private SqlHelper _sqlHelper;
  private String token = "";
  
  @Autowired
  private AuthenticationHandler(SqlHelper sqlHelper) {
    _sqlHelper = sqlHelper;
  }
  
  public String login(String username, String password) {
    try {
      if(_sqlHelper.checkCredentials(username, password)) {
        token = generateToken();
        _sqlHelper.writeTokenToDB(token, username);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return token;
  }
  
  private String generateToken() {
    UUID tokenUUID = UUID.randomUUID();
    return tokenUUID.toString();
  }
  
}
