package com.hzchum.scim.mes.enclosure.core.api.enums.record;

public enum PrintTypeEnum {
   TASK(0),
   AUXILIARY_MATERIALS(1),
   PACKAGE(2);

   private Integer type;

   PrintTypeEnum(Integer type) {
      this.type = type;
   }

   public Integer getType() {
      return this.type;
   }
}
