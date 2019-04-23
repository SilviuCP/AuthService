package com.certsign.auth.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.certsign.auth.communication.JsonUtils;
import com.certsign.auth.communication.LoginResponse;
import com.certsign.auth.handler.AuthenticationHandler;


@Controller
public class LoginController {
  
  private AuthenticationHandler _authenticationHandler;
  private Map<String, String> _token;

  
  public LoginController(AuthenticationHandler authenticationHandler) {
    _authenticationHandler = authenticationHandler;
  }
  
  @ResponseBody
  @RequestMapping(value = "/login", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
  public String loginRequest(String username, String password) {
    _token = _authenticationHandler.login(username, password);
    LoginResponse response = new LoginResponse();
    if(_token.get("loginResponse") == "SUCCESSFUL") {
      response.setSuccessful(true);
      response.setToken(_token.get("token"));
      response.setBalance(Double.parseDouble(_token.get("balance")));
    }else if(_token.get("loginResponse") == "FAILED") {
      response.setSuccessful(false);
      response.setMessage("Invalid Token");
    }
    return JsonUtils.createJsonResponse(response);
  }
  
}
