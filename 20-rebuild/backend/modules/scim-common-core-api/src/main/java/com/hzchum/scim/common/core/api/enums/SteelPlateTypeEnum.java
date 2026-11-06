package com.hzchum.scim.common.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum SteelPlateTypeEnum {
   PRIMARY_MEMBER(1, "零件板"),
   SECONDARY_MEMBER(2, "翼腹板"),
   SECTIONSTEEL(4, "成品型材");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      for (SteelPlateTypeEnum value : values()) {
         if (value.getType().equals(type)) {
            return value.getName();
         }
      }

      return "";
   }

   public static boolean isExist(int type) {
      Optional<SteelPlateTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   SteelPlateTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
