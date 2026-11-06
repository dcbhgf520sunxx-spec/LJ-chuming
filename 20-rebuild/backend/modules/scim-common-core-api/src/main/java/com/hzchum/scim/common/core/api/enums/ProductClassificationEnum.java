package com.hzchum.scim.common.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum ProductClassificationEnum {
   PRIMARY_MEMBER(1, "主构件"),
   SECONDARY_MEMBER(2, "次构件"),
   SECTION_PRODUCT(4, "成品型材(截面)"),
   STEEL_PLATE_PRODUCT(8, "钢板制品(截面)"),
   ASSEMBLE(16, "焊接部件"),
   AUXILIARY_MATERIAL(32, "标准件(配套件)");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      for (ProductClassificationEnum value : values()) {
         if (value.getType().equals(type)) {
            return value.getName();
         }
      }

      return "";
   }

   public static boolean isExist(int type) {
      Optional<ProductClassificationEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   ProductClassificationEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
