package com.hzchum.scim.bim.core.api.enums;

public enum BimStatusCommonEnum {
   PROCESSING("processing"),
   SUCCESS("success"),
   UNCHARGED("uncharged"),
   PREPARE("prepare"),
   FAILED("failed"),
   UPLOAD_PROCESSING("uploadProcessing"),
   UPLOAD_FAILED("uploadFailed"),
   UNEXIST("unexist");

   private String name;

   BimStatusCommonEnum(String name) {
      this.name = name;
   }

   public String getName() {
      return this.name;
   }
}
