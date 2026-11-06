package com.hzchum.scim.bim.core.api.enums;

public enum BimStatusIntegrationEnum {
   PROCESSING_NO("processing_no"),
   PROCESSING("processing"),
   SUCCESS("success"),
   FAILED("failed");

   private String name;

   BimStatusIntegrationEnum(String name) {
      this.name = name;
   }

   public String getName() {
      return this.name;
   }
}
