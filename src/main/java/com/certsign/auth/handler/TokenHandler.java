package com.certsign.auth.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TokenHandler {

  private SqlHelper _sqlHelper;
  
  @Autowired
  private TokenHandler(SqlHelper sqlHelper) {
    _sqlHelper = sqlHelper;
  }
  
  public boolean checkToken(String token) {
    try {
      if(_sqlHelper.checkTokenWithDB(token)) {
        return true;
      }else {
        return false;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }
}
