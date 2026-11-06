package com.hzchum.scim.system.core.api.common.enums;

public enum DDUserIdCheckResultEnum {
   ZERO(0, "不存在对应用户"),
   ONE(1, "一个用户"),
   MORE(2, "存在多个用户");

   private Integer value;
   private String name;

   DDUserIdCheckResultEnum(int value, String name) {
      this.value = value;
      this.name = name;
   }

   public Integer getValue() {
      return this.value;
   }

   public String getName() {
      return this.name;
   }
}
