package com.hzchum.scim.system.core.api.common.enums.notification;

public enum NotificationTimeTypeEnum {
   DAY(1, "天"),
   HOUR(2, "小时"),
   MINUTE(4, "分钟");

   private int type;
   private String name;

   NotificationTimeTypeEnum(int type, String name) {
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
