package com.hzchum.scim.mes.building.core.api.enums.record;

public enum PrintTypeEnum {
   TASK(0),
   AUXILIARY_MATERIALS(1),
   PACKAGE(2),
   WAREHOUSE(4),
   RETURN_REPAIR(8);

   private Integer type;

   PrintTypeEnum(Integer type) {
      this.type = type;
   }

   public Integer getType() {
      return this.type;
   }
}
