package com.hzchum.scim.system.core.api.common.enums.notification;

public enum AppTypeEnum {
   DINGDING(1, "钉钉"),
   QIWEI(2, "企微");

   private int type;
   private String name;

   AppTypeEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
