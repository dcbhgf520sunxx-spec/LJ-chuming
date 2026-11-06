package com.hzchum.scim.business.core.api.enums;

public enum monthTypeEnum {
   THIS_MONTH(1, "本月"),
   LAST_MONTH(2, "上月");

   private final Integer type;
   private final String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   monthTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
