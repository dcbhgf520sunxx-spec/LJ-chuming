package com.hzchum.scim.system.core.api.common.enums;

public enum DeptAndJobTypeEnum {
   ESTABLISHMENT_INSIDE(1, "编制内"),
   ESTABLISHMENT_OUTER(2, "编制外");

   private final Integer type;
   private final String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   DeptAndJobTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
