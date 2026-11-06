package com.hzchum.pangu.common.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class UserInfoUtil {
   public static UserDetails getCurrentUser() {
      return (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
   }

   public static String getName() {
      return SecurityContextHolder.getContext().getAuthentication().getName();
   }
}
