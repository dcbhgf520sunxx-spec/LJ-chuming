package com.hzchum.scim.system.core.api.common.enums.notification;

public enum OverdueTimeDurationOrTimeTypeEnum {
   DURATION(0, "时长"),
   TIME(1, "时间");

   private int type;
   private String name;

   OverdueTimeDurationOrTimeTypeEnum(int type, String name) {
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
