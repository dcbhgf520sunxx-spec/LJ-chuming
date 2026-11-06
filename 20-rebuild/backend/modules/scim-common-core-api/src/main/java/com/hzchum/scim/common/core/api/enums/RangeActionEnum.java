package com.hzchum.scim.common.core.api.enums;

public enum RangeActionEnum {
   MONOMER(2, "单体"),
   AREA(4, "区域");

   private final Integer type;
   private final String name;

   RangeActionEnum(final Integer type, final String name) {
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
