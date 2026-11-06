package com.hzchum.scim.common.core.api.enums;

public enum BranchAttributeEnum {
   INSTALLATION(1, "安装"),
   MANUFACTURING(2, "加工"),
   OTHER(4, "其他");

   private final Integer type;
   private final String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   BranchAttributeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
