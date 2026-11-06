package com.hzchum.scim.common.core.api.enums;

public enum ApproveSourceEnum {
   SYSTEM(1, "系统"),
   OA(2, "泛微OA");

   private Integer type;
   private String name;

   ApproveSourceEnum(int type, String name) {
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
