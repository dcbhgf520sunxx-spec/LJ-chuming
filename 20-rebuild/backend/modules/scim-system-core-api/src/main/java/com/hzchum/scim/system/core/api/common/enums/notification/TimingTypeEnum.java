package com.hzchum.scim.system.core.api.common.enums.notification;

public enum TimingTypeEnum {
   BEFORE(0, "前置定时"),
   LATER(1, "后置定时");

   private int type;
   private String name;

   TimingTypeEnum(int type, String name) {
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
