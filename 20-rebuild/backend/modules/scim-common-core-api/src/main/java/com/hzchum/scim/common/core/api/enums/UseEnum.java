package com.hzchum.scim.common.core.api.enums;

public enum UseEnum {
   USE(1, "当前使用"),
   UNUSED(0, "当前未使用");

   private Integer type;
   private String name;

   UseEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
