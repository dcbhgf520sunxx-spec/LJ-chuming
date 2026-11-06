package com.hzchum.scim.wms.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum PrintMaterialTypeEnum {
   PUBLIC_COMPLETE(0, "公共整料"),
   PUBLIC_SURPLUS(1, "公共余料"),
   PROJECT_COMPLETE(2, "项目整料"),
   PROJECT_SURPLUS(3, "项目余料"),
   A_COMPLETE(4, "甲供整料"),
   A_SURPLUS(5, "甲供余料");

   private final Integer type;
   private final String name;

   PrintMaterialTypeEnum(Integer type, String name) {
      this.type = type;
      this.name = name;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   public static boolean isExist(int type) {
      Optional<InvoiceTypeEnum> optional = Arrays.stream(InvoiceTypeEnum.values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }
}
