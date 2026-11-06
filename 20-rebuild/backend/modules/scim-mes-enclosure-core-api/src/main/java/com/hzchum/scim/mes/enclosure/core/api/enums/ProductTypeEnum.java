package com.hzchum.scim.mes.enclosure.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum ProductTypeEnum {
   MACHINE_PART(1, "零件"),
   ARTIFACT(2, "构件"),
   ENCLOSURE(4, "围护"),
   AUXILIARY_MATERIAL(8, "配套件"),
   ASSEMBLE(16, "组立"),
   ASSEMBLE_TYPESETTING(32, "型材套料工单");

   private Integer type;
   private String name;

   ProductTypeEnum(Integer type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(Integer type) {
      Optional<ProductTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.isPresent();
   }

   public static String getNameByType(Integer type) {
      for (ProductTypeEnum value : values()) {
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
