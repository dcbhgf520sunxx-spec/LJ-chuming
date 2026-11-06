package com.hzchum.scim.common.core.api.enums;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public enum ProductTypeEnum {
   MACHINE_PART(1, "零件"),
   ARTIFACT(2, "构件"),
   ENCLOSURE(4, "围护"),
   AUXILIARY_MATERIAL(8, "配套件"),
   ASSEMBLE(16, "部件(组立)"),
   ALL_PRODUCT(19, "全部类型");

   private final Integer type;
   private final String name;

   public static ProductTypeEnum getEnumByType(Integer type) {
      return Stream.of(values()).filter(e -> Objects.equals(e.getType(), type)).findFirst().orElseThrow(() -> new IllegalArgumentException("产品类型错误"));
   }

   public static String getNameByType(Integer type) {
      for (ProductTypeEnum value : values()) {
         if (value.getType().equals(type)) {
            return value.getName();
         }
      }

      return "";
   }

   public static boolean isExist(int type) {
      Optional<ProductTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   ProductTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
