package com.hzchum.scim.contract.core.api.enums;

public enum ProjectAttributeEnum {
   SELF_SUPPORT(1, "自营项目"),
   JOINT_VENTURE(2, "合营项目"),
   LUMP_SUM_SYSTEM(3, "包干制项目");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      for (ProjectAttributeEnum projectAttributeEnum : values()) {
         if (projectAttributeEnum.getType().equals(type)) {
            return projectAttributeEnum.getName();
         }
      }

      return null;
   }

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
