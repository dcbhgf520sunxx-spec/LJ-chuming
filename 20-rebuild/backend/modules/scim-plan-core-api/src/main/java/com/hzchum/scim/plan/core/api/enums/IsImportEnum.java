package com.hzchum.scim.plan.core.api.enums;

public enum IsImportEnum {
   IS_IMPORT(1, "已导入"),
   NO_IMPORT(0, "未导入");

   private final Integer type;
   private final String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   IsImportEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
