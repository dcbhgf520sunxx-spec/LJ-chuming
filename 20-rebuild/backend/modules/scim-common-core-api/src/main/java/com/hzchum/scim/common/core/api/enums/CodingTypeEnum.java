package com.hzchum.scim.common.core.api.enums;

public enum CodingTypeEnum {
   SINGLE(1, "一物一码"),
   BATCH(2, "批量");

   private final Integer type;
   private final String name;

   public static Boolean exist(Integer type) {
      for (CodingTypeEnum productionLineTypeEnum : values()) {
         if (productionLineTypeEnum.getType().equals(type)) {
            return true;
         }
      }

      return false;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   CodingTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
