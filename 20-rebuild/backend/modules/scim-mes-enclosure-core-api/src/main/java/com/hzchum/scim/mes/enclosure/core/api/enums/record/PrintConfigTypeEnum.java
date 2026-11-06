package com.hzchum.scim.mes.enclosure.core.api.enums.record;

public enum PrintConfigTypeEnum {
   COMMON(1),
   SIMPLE(2),
   CUSTOM(4);

   private Integer type;

   PrintConfigTypeEnum(Integer type) {
      this.type = type;
   }

   public Integer getType() {
      return this.type;
   }
}
