package com.hzchum.scim.bim.core.api.enums;

public enum BimModelTypeEnum {
   FILETYPE("file"),
   INTEGRATIONTYPE("integration");

   private String name;

   BimModelTypeEnum(String name) {
      this.name = name;
   }

   public String getName() {
      return this.name;
   }
}
