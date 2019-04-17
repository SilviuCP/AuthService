package com.certsign.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.certsign.auth.handler.AuthenticationHandler;


@Controller
public class LoginController {
  
  private AuthenticationHandler _authenticationHandler;
  private String _token = "";
  
  public LoginController(AuthenticationHandler authenticationHandler) {
    _authenticationHandler = authenticationHandler;
  }
  
  @ResponseBody
  @RequestMapping(value = "/login", method = RequestMethod.GET, produces = "text/plain")
  public String loginRequest(String username, String password) {
    _token = _authenticationHandler.login(username, password);
    return _token;
  }
  
}
