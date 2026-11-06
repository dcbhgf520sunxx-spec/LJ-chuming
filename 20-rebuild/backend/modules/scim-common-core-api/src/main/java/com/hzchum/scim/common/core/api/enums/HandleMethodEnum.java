package com.hzchum.scim.common.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum HandleMethodEnum {
   REPAIR(1, "回厂返修"),
   RECYCLE(2, "制品回收"),
   SCRAP(3, "制品报废");

   private Integer type;
   private String name;

   HandleMethodEnum(Integer type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(Integer type) {
      Optional<HandleMethodEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.isPresent();
   }

   public static String getNameByType(Integer type) {
      for (HandleMethodEnum value : values()) {
         if (value.getType().equals(type)) {
            return value.getName();
         }
      }

      return "";
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
