package com.hzchum.scim.bim.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum BimImportModeEnum {
   MONOMER_MODE(1, "单体模式"),
   INTEGRATION_MODE(2, "集成模式");

   private Integer type;
   private String name;

   BimImportModeEnum(Integer type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(Integer type) {
      Optional<BimImportModeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.isPresent();
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
