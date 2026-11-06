package com.hzchum.scim.plan.core.api.enums;

public enum RangeTypeEnum {
   MANUAL(1, "手动选择"),
   PROJECT(2, "整个项目"),
   MONOMER(4, "整个单体");

   private final Integer type;
   private final String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   RangeTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
