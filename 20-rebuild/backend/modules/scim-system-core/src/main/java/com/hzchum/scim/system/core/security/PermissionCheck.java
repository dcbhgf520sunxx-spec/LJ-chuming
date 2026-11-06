package com.hzchum.scim.system.core.security;

import com.hzchum.pangu.common.config.JwtProperties;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("permission")
public class PermissionCheck {
   private static final Logger log = LoggerFactory.getLogger(PermissionCheck.class);
   @Resource
   private HttpServletRequest httpServletRequest;
   @Resource
   private JwtProperties jwtProperties;
   @Value("${spring.profiles.active}")
   private String env;
   private static final String ENVIRONMENT_COMPANY = "company";

   public Boolean check(String... permissions) {
      return Boolean.TRUE;
   }
}
