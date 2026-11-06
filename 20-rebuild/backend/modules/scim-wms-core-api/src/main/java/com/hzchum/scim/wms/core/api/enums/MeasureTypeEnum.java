package com.hzchum.scim.wms.core.api.enums;

public enum MeasureTypeEnum {
   MEASURE(1, "计量"),
   ACCOUNTING(2, "核算");

   private final Integer type;
   private final String name;

   MeasureTypeEnum(Integer type, String name) {
      this.type = type;
      this.name = name;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
