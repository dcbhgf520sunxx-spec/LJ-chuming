package com.hzchum.scim.system.core.api.common.enums;

public enum ProductionLineTypeEnum {
   TRADITIONAL_LINE(1, "传统线"),
   SMART_LINE(2, "智能线");

   private final Integer type;
   private final String name;

   public static Boolean exist(Integer type) {
      for (ProductionLineTypeEnum productionLineTypeEnum : values()) {
         if (productionLineTypeEnum.getType().equals(type)) {
            return true;
         }
      }

      return false;
   }

   public static String getNameByType(Integer type) {
      for (ProductionLineTypeEnum value : values()) {
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

   ProductionLineTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
