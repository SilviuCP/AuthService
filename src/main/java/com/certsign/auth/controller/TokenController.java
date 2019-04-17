package com.certsign.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class TokenController {
  
  @ResponseBody
  @RequestMapping(value = "/token", method = RequestMethod.GET, produces = "text/plain")
  public boolean checkToken(String token) {
    // check token with DB
    return true;
  }
}
