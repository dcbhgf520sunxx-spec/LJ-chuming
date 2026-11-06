package com.hzchum.scim.system.core.api.common.enums;

public enum ArtifactTypeEnum {
   COMMON(1, "普通构件"),
   SMALL(2, "次构件");

   private final Integer type;
   private final String name;

   public static Boolean exist(Integer type) {
      for (ArtifactTypeEnum productionLineTypeEnum : values()) {
         if (productionLineTypeEnum.getType().equals(type)) {
            return true;
         }
      }

      return false;
   }

   public static String getName(Integer type) {
      for (ArtifactTypeEnum productionLineTypeEnum : values()) {
         if (productionLineTypeEnum.getType().equals(type)) {
            return productionLineTypeEnum.getName();
         }
      }

      return null;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   ArtifactTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
