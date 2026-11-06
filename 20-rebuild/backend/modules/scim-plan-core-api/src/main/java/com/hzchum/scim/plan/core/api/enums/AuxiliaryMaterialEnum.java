package com.hzchum.scim.plan.core.api.enums;

import org.apache.commons.lang3.StringUtils;

public enum AuxiliaryMaterialEnum {
   STUD(1, "栓钉"),
   sleeve(2, "套筒"),
   COATING(4, "螺栓");

   private final Integer type;
   private final String name;

   public static Boolean isExistByName(String name) {
      if (StringUtils.isBlank(name)) {
         return Boolean.FALSE;
      }

      for (AuxiliaryMaterialEnum auxiliaryMaterialEnum : values()) {
         if (auxiliaryMaterialEnum.getName().equalsIgnoreCase(name)) {
            return Boolean.TRUE;
         }
      }

      return Boolean.FALSE;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   AuxiliaryMaterialEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
