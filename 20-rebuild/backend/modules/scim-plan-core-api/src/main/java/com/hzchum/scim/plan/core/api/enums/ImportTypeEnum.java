package com.hzchum.scim.plan.core.api.enums;

public enum ImportTypeEnum {
   ADD_IMPORT(1, "增量导入"),
   COVER_IMPORT(2, "覆盖导入"),
   REUTILIZATION(4, "二次利用(变更)");

   private final Integer type;
   private final String name;

   ImportTypeEnum(final Integer type, final String name) {
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
