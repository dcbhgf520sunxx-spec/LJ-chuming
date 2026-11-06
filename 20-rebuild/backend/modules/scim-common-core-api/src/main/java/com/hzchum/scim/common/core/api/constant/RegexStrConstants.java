package com.hzchum.scim.common.core.api.constant;

public final class RegexStrConstants {
   public static final String USERNAME_REGEX = "[A-Za-z0-9]{4,16}";
   public static final String PHONE_REGEX = "((13[0-9])|(14[0-9])|(15[0-9])|(16[0-9])|(17[0-9])|(18[0-9])|(19[0-9]))\\d{8}$";
   public static final String EMAIL_REGEX = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
   public static final String PATH_VARIABLE_REGEX = "\\{([^{}]+)\\}";
   public static final String ID_NUM_REGEX = "[1-9][0-9]*";
   public static final String POSITIVE_INTEGER = "^[1-9]\\d*$";
   public static final String NUMBERS = ".*\\d.*";
   public static final String SPECIAL_CHARACTERS = ".*[!@#$%^&*()_+\\-=\\[\\]{}|;:,.<>?].*";
   public static final String LETTER = ".*[a-zA-Z].*";

   private RegexStrConstants() {
   }
}
