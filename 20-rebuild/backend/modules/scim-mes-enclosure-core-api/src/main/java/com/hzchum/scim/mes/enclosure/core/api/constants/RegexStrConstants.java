package com.hzchum.scim.mes.enclosure.core.api.constants;

public final class RegexStrConstants {
   public static final String USERNAME_REGEX = "[A-Za-z0-9]{4,16}";
   public static final String PHONE_REGEX = "((13[0-9])|(14[0-9])|(15[0-9])|(16[0-9])|(17[0-9])|(18[0-9])|(19[0-9]))\\d{8}$";
   public static final String EMAIL_REGEX = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
   public static final String PATH_VARIABLE_REGEX = "\\{([^{}]+)\\}";
   public static final String ID_NUM_REGEX = "[1-9][0-9]*";

   private RegexStrConstants() {
   }
}
