package com.certsign.auth.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionHandler {
  
  private SqlHelper _sqlHelper;
  private static double balance;
  private static double newBalance;
  
  @Autowired
  private TransactionHandler(SqlHelper sqlHelper) {
    _sqlHelper = sqlHelper;
  }
  
  private double transferMoney(String token, double transferredAmount) {
    try {
      if (_sqlHelper.checkTokenWithDB(token)) {
        balance = _sqlHelper.getBalance(token);
        return balance;
      }
    } catch (Exception e) {
      e.printStackTrace();
      return balance;
    }
    return balance;
  }
  
  public double doTransaction(String token, double transferredAmount) {
    try {
      double balance = transferMoney(token,transferredAmount);
      if(balance < transferredAmount) {
        newBalance = balance - transferredAmount;
        //_sqlHelper.updateBalanceToDb(balance, token);
        return newBalance;
      }else {
        return newBalance;
      }
    } catch (Exception e) {
      e.printStackTrace();
      return newBalance;
    }
  }
  
}
