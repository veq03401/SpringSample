package com.sample.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class HelloService {

  @WebMethod
  public String hello(String name) {
      return "Hello " + name + "!";
  }

}
