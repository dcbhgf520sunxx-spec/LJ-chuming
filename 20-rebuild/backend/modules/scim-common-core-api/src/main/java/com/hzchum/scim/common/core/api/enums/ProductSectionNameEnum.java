package com.hzchum.scim.common.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum ProductSectionNameEnum {
   PRODUCT_NAME(1, "产品名称"),
   PRODUCT_TYPE_ENUM(2, "产品类型名称"),
   SECTION_TYPE_ENUM(4, "截面类型名称"),
   NUMBERING_PREFIX(8, "产品编号前缀");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      for (ProductSectionNameEnum value : values()) {
         if (value.getType().equals(type)) {
            return value.getName();
         }
      }

      return "";
   }

   public static boolean isExist(int type) {
      Optional<ProductSectionNameEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   ProductSectionNameEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
