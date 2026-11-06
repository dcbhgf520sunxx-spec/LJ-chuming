package com.hzchum.scim.system.core.api.common.enums.notification;

public enum DurationTypeEnum {
   DAY(0, "天"),
   HOUR(1, "小时"),
   MINUTES(3, "分钟");

   private int type;
   private String name;

   DurationTypeEnum(int type, String name) {
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
