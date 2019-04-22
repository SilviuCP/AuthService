package com.certsign.auth.handler;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationHandler {
  
  private SqlHelper _sqlHelper;
  
  @Autowired
  private AuthenticationHandler(SqlHelper sqlHelper) {
    _sqlHelper = sqlHelper;
  }
  
  public Map login(String username, String password) {
    Map<String, String> loginRequestResponse = new HashMap<>();
    String token = "";
    try {
      if(_sqlHelper.checkCredentials(username, password)) {
        token = generateToken();
        loginRequestResponse.put("loginResponse", "SUCCESSFUL");
        loginRequestResponse.put("token", token);
        _sqlHelper.writeTokenToDB(token, username);
        return loginRequestResponse;
      }
    } catch (Exception e) {
      e.printStackTrace();
      loginRequestResponse.put("loginResponse", "FAILED");
      return loginRequestResponse;
    }
    loginRequestResponse.put("loginResponse", "FAILED");
    return loginRequestResponse;
  }
  
  private String generateToken() {
    UUID tokenUUID = UUID.randomUUID();
    return tokenUUID.toString();
  }
  
}
