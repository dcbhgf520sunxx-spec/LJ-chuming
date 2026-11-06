package com.hzchum.scim.wms.core.api.enums;

public enum MaterialOutboundModeEnum {
   WHOLE(1, "整料整出"),
   HALF(2, "整料半出");

   private final Integer type;
   private final String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   MaterialOutboundModeEnum(Integer type, String name) {
      this.type = type;
      this.name = name;
   }
}
