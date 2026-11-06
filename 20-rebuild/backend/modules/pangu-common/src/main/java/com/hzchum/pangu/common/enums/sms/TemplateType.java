package com.hzchum.pangu.common.enums.sms;

public enum TemplateType {
   VERIFICATION_CODE("0"),
   SMS_NOTIFICATION("1"),
   PROMOTE_SMS("2"),
   INTERNATIONAL_NEWS("3");

   private final String type;

   TemplateType(String type) {
      this.type = type;
   }

   public String getType() {
      return this.type;
   }
}
