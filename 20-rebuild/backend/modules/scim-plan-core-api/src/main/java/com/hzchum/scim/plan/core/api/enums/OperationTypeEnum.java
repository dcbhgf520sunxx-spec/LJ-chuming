package com.hzchum.scim.plan.core.api.enums;

public enum OperationTypeEnum {
   ADD_IMPORT(1, "1清单导入"),
   COVER_IMPORT(2, "2清单变更");

   private final Integer type;
   private final String name;

   OperationTypeEnum(final Integer type, final String name) {
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
