package com.hzchum.scim.system.core.api.common.enums;

public enum DrillHoleConfigPricingMannerEnum {
   PLATE_THICKNESS(1, "板厚(mm)"),
   APERTURE(2, "孔径(mm)");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      for (DrillHoleConfigPricingMannerEnum e : values()) {
         if (e.getType().equals(type)) {
            return e.getName();
         }
      }

      return null;
   }

   public static Boolean isExist(Integer type) {
      for (DrillHoleConfigPricingMannerEnum e : values()) {
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

   DrillHoleConfigPricingMannerEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
