package com.hzchum.scim.system.core.api.common.enums.notification;

public enum NotificationModeTypeEnum {
   IN_TIME(1, "及时"),
   TIMING(2, "定时"),
   DEFINITE_NUMBER(3, "定数");

   private int type;
   private String name;

   NotificationModeTypeEnum(int type, String name) {
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
