package com.hzchum.scim.contract.core.api.enums;

public enum SourceEnum {
   CURRENT_SYSTEM(1, "本系统"),
   DING_DING(2, "钉钉");

   private final Integer type;
   private final String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   SourceEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
