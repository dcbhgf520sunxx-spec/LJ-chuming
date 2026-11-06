package com.hzchum.scim.plan.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum InventoryTypeEnum {
   MES(1, "建钢"),
   BRIDGE(2, "桥梁"),
   ENCLOSURE(4, "围护"),
   GRID(8, "网架"),
   ANCILLARY_PRODUCTS(16, "配套制品");

   private Integer type;
   private String name;

   InventoryTypeEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(int type) {
      Optional<InventoryTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public static String getNameByType(Integer type) {
      Optional<InventoryTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.isPresent() ? optional.get().getName() : null;
   }

   public static Integer getTypeBySpecPrefix(String specPrefix) {
      int type = 0;
      if ("PL".equals(specPrefix)) {
         type = BRIDGE.getType();
      } else {
         InventoryTypeEnum[] values = values();

         for (InventoryTypeEnum value : values) {
            type |= value.getType();
         }
      }

      return type;
   }

   public static Integer getAllType() {
      int type = 0;
      InventoryTypeEnum[] values = values();

      for (InventoryTypeEnum value : values) {
         type |= value.getType();
      }

      return type;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
