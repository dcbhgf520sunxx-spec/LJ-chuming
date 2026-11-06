package com.hzchum.scim.rest.runner;

import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order
@Component
public class UserLoginRunner implements CommandLineRunner {
   @Autowired
   private ServletContext servletContext;

   @Override
   public void run(String... args) throws Exception {
      this.servletContext.setAttribute("boolAllowLogin", true);
   }
}
