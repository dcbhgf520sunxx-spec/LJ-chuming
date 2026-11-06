package com.hzchum.scim.system.core.api.enums;

public enum SysMatchRangeEnum {
   AREA(1, "区域"),
   MONOMER(2, "单体");

   private final Integer type;
   private final String name;

   SysMatchRangeEnum(final Integer type, final String name) {
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
