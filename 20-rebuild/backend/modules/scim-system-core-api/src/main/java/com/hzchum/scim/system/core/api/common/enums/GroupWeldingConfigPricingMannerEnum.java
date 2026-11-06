package com.hzchum.scim.system.core.api.common.enums;

public enum GroupWeldingConfigPricingMannerEnum {
   SECTION(1, "截面"),
   WEB_PLATE_THICKNESS(2, "腹板厚度(mm)");

   private final Integer type;
   private final String name;

   public static GroupWeldingConfigPricingMannerEnum getEnumByType(Integer type) {
      for (GroupWeldingConfigPricingMannerEnum e : values()) {
         if (e.getType().equals(type)) {
            return e;
         }
      }

      return null;
   }

   public static String getNameByType(Integer type) {
      for (GroupWeldingConfigPricingMannerEnum e : values()) {
         if (e.getType().equals(type)) {
            return e.getName();
         }
      }

      return null;
   }

   public static Boolean isExist(Integer type) {
      for (GroupWeldingConfigPricingMannerEnum e : values()) {
         if (e.getType().equals(type)) {
            return Boolean.TRUE;
         }
      }

      return Boolean.FALSE;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   GroupWeldingConfigPricingMannerEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
