package com.hzchum.scim.mes.building.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum ProductProcessIdEnum {
   MACHINE_PART(1, "零件"),
   ENCLOSURE(4, "构件");

   private int type;
   private String name;

   ProductProcessIdEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(Integer type) {
      Optional<ProductProcessIdEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public static String getNameByType(Integer type) {
      for (ProductProcessIdEnum value : values()) {
         if (value.getType() == type) {
            return value.getName();
         }
      }

      return "";
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
