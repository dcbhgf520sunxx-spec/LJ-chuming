package com.hzchum.scim.contract.core.api.enums;

public enum CarrierTypeEnum {
   PERSONAGE(1, "个人"),
   UNIT(2, "单位");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      if (type == null) {
         return null;
      }

      CarrierTypeEnum[] values = values();

      for (CarrierTypeEnum changeEnum : values) {
         if (type.equals(changeEnum.getType())) {
            return changeEnum.getName();
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

   CarrierTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
