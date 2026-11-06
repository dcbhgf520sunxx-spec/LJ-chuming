package com.hzchum.scim.system.core.api.common.enums;

public enum DingDingMessageTypeEnum {
   MARKDOWN("markdown");

   private final String name;

   public String getName() {
      return this.name;
   }

   DingDingMessageTypeEnum(String name) {
      this.name = name;
   }
}
