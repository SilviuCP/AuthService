package com.certsign.auth.communication;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonUtils {
  
  private static ObjectMapper mapper = new ObjectMapper();
  
  public static String createJsonResponse(Response r) {
    
    try {
      return mapper.writeValueAsString(r);
    } catch (JsonProcessingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return "Failed to convert response to Json";
    
  }
  
}
