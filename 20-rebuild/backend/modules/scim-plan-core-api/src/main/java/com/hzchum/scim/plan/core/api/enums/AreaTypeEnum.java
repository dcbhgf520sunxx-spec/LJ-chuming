package com.hzchum.scim.plan.core.api.enums;

public enum AreaTypeEnum {
   PROCESS(0, "自制"),
   EPIBOLY(1, "外协");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      AreaTypeEnum[] values = values();

      for (AreaTypeEnum value : values) {
         if (value.getType().equals(type)) {
            return value.getName();
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

   AreaTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
