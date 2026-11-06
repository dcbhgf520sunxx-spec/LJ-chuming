package com.hzchum.scim.contract.core.api.enums.visa;

public enum ProjectAttributeEnum {
   SELF_SUPPORT(1, "自营项目"),
   JOINT_VENTURE(2, "合营项目"),
   LUMP_SUM_SYSTEM(3, "内包制");

   private final Integer type;
   private final String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   ProjectAttributeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
