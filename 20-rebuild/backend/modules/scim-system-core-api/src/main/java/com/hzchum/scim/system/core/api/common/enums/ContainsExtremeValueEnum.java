package com.hzchum.scim.system.core.api.common.enums;

public enum ContainsExtremeValueEnum {
   CONTAINS(true, "包含"),
   NOT_CONTAINS(false, "不包含");

   private final boolean type;
   private final String name;

   public boolean isType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   ContainsExtremeValueEnum(final boolean type, final String name) {
      this.type = type;
      this.name = name;
   }
}
