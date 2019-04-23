package com.certsign.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.certsign.auth.communication.JsonUtils;
import com.certsign.auth.communication.ResponseImpl;
import com.certsign.auth.communication.TransactionResponse;
import com.certsign.auth.handler.TokenHandler;
import com.certsign.auth.handler.TransactionHandler;


@Controller
public class TransactionController {
  
  private TransactionHandler transactionHandler;
  private TokenHandler tokenHandler;
  
  public TransactionController(TransactionHandler transactionHandler, TokenHandler tokenHandler) {
    this.transactionHandler = transactionHandler;
    this.tokenHandler = tokenHandler;
  }
  
  @ResponseBody
  @RequestMapping(value = "/transaction", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
  public String checkToken(String token, double transferredAmount) {
    double newBalance = transactionHandler.doTransaction(token, transferredAmount);
    TransactionResponse response = new TransactionResponse();
    if (newBalance > 0) {
      response.setBalance(newBalance);
      response.setSuccessful(true);
    }
    return JsonUtils.createJsonResponse(response);
  }
  
}
