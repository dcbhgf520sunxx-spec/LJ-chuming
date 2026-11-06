package com.hzchum.scim.common.core.api.enums;

public enum ResultEnum {
   AGREE("agree"),
   REFUSE("refuse");

   private String name;

   ResultEnum(String name) {
      this.name = name;
   }

   public String getName() {
      return this.name;
   }
}
