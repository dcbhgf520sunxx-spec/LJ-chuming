package com.hzchum.scim.system.core.api.utils;

import com.google.common.base.Preconditions;
import com.hzchum.scim.system.core.api.pojo.dto.config.SysPasswordPolicyDTO;
import java.util.regex.Pattern;

public class PasswordPolicyUtil {
   public static void checkPolicy(String password, SysPasswordPolicyDTO param, Boolean isAdminPassword) {
      if (param != null) {
         if (Boolean.TRUE.equals(isAdminPassword)) {
            param.setMinLength(8);
            param.setContainNumbers(true);
            param.setContainLetter(true);
            param.setContainSpecialCharacters(true);
         }

         if (Boolean.TRUE.equals(param.getContainNumbers())) {
            Preconditions.checkArgument(Pattern.matches(".*\\d.*", password), "密码中必须包含数字！");
         }

         if (Boolean.TRUE.equals(param.getContainSpecialCharacters())) {
            Preconditions.checkArgument(Pattern.matches(".*[!@#$%^&*()_+\\-=\\[\\]{}|;:,.<>?].*", password), "密码中必须包含特殊字符！");
         }

         if (Boolean.TRUE.equals(param.getContainLetter())) {
            Preconditions.checkArgument(Pattern.matches(".*[a-zA-Z].*", password), "密码中必须包含字母！");
         }

         if (param.getMinLength() != null) {
            Preconditions.checkArgument(password.length() >= param.getMinLength(), "密码长度至少为" + param.getMinLength() + "位！");
         }
      }
   }

   public static Boolean getConformPolicy(String password, SysPasswordPolicyDTO param, Boolean isAdminPassword) {
      if (param == null) {
         return Boolean.TRUE;
      }

      if (Boolean.TRUE.equals(isAdminPassword)) {
         param.setMinLength(8);
         param.setContainNumbers(true);
         param.setContainLetter(true);
         param.setContainSpecialCharacters(true);
      }

      if (Boolean.FALSE.equals(param.getLoginVerification())) {
         return true;
      } else if (Boolean.TRUE.equals(param.getContainNumbers()) && !Pattern.matches(".*\\d.*", password)) {
         return false;
      } else if (Boolean.TRUE.equals(param.getContainSpecialCharacters()) && !Pattern.matches(".*[!@#$%^&*()_+\\-=\\[\\]{}|;:,.<>?].*", password)) {
         return false;
      } else if (Boolean.TRUE.equals(param.getContainLetter()) && !Pattern.matches(".*[a-zA-Z].*", password)) {
         return false;
      } else {
         return param.getMinLength() != null && password.length() < param.getMinLength() ? false : true;
      }
   }
}
