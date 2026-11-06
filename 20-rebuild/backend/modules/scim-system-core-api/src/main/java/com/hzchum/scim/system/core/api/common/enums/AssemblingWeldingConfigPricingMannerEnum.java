package com.hzchum.scim.system.core.api.common.enums;

public enum AssemblingWeldingConfigPricingMannerEnum {
   BEEF_LEGS_NUMBER(1, "牛腿数"),
   ARTIFACT_MACHINE_PART_RATIO(2, "构件零件比"),
   ARTIFACT_SECTION(3, "构件截面");

   private final Integer type;
   private final String name;

   public static AssemblingWeldingConfigPricingMannerEnum getEnumByType(Integer type) {
      for (AssemblingWeldingConfigPricingMannerEnum pricingMannerEnum : values()) {
         if (pricingMannerEnum.getType().equals(type)) {
            return pricingMannerEnum;
         }
      }

      return null;
   }

   public static String getNameByType(Integer type) {
      for (AssemblingWeldingConfigPricingMannerEnum pricingMannerEnum : values()) {
         if (pricingMannerEnum.getType().equals(type)) {
            return pricingMannerEnum.getName();
         }
      }

      return null;
   }

   public static Boolean isExist(Integer type) {
      for (AssemblingWeldingConfigPricingMannerEnum pricingMannerEnum : values()) {
         if (pricingMannerEnum.getType().equals(type)) {
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

   AssemblingWeldingConfigPricingMannerEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
