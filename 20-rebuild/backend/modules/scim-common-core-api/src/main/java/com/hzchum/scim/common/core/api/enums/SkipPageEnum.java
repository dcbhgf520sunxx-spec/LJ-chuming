package com.hzchum.scim.common.core.api.enums;

public enum SkipPageEnum {
   CHECK(1, "审核页面"),
   DETAILS(2, "详情页面"),
   REWRITE(3, "重写页面");

   private Integer type;
   private String name;

   SkipPageEnum(int type, String name) {
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
