package com.hzchum.scim.wms.core.api.enums;

public enum SteelWeightCalculationTypeEnum {
   SINGLE_WEIGHT(1, "单重"),
   TOTAL_WEIGHT(2, "总重");

   private final Integer type;
   private final String name;

   SteelWeightCalculationTypeEnum(Integer type, String name) {
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
