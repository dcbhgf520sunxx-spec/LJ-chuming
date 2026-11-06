package com.hzchum.scim.wms.core.api.enums;

public enum HalfModeEnum {
   LENGTH(1, "取长"),
   WIDTH(2, "取宽");

   private final Integer type;
   private final String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   HalfModeEnum(Integer type, String name) {
      this.type = type;
      this.name = name;
   }
}
