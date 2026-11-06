package com.hzchum.scim.contract.core.api.enums.finance;

public enum StatusEnum {
   ENABLED(1, "启用"),
   DISABLED(0, "禁用");

   private final Integer type;
   private final String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   StatusEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
