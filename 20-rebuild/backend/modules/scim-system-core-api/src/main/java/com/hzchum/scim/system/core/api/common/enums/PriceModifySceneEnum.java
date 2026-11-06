package com.hzchum.scim.system.core.api.common.enums;

public enum PriceModifySceneEnum {
   AFFECTS_PRICE_AFTER_MODIFICATION(1, "影响修改后的价格"),
   SYNC_PRICE_BEFORE_MODIFICATION(2, "同步修改前的价格");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      for (PriceModifySceneEnum priceModifySceneEnum : values()) {
         if (priceModifySceneEnum.getType().equals(type)) {
            return priceModifySceneEnum.getName();
         }
      }

      return null;
   }

   public static Boolean isExist(Integer type) {
      for (PriceModifySceneEnum priceModifySceneEnum : values()) {
         if (priceModifySceneEnum.getType().equals(type)) {
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

   PriceModifySceneEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
