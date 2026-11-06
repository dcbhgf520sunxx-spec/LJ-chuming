package com.hzchum.scim.plan.core.api.enums;

public enum ChangeScopeEnum {
   AREA(1, "区域"),
   MONOMER(2, "单体"),
   AREA_BATCH(4, "批次");

   private final Integer type;
   private final String name;

   ChangeScopeEnum(final Integer type, final String name) {
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
