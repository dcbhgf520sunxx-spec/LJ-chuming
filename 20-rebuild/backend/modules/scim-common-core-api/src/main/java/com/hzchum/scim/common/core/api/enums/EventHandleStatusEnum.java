package com.hzchum.scim.common.core.api.enums;

public enum EventHandleStatusEnum {
   START("start"),
   FINISH("finish");

   private String name;

   EventHandleStatusEnum(String name) {
      this.name = name;
   }

   public String getName() {
      return this.name;
   }
}
