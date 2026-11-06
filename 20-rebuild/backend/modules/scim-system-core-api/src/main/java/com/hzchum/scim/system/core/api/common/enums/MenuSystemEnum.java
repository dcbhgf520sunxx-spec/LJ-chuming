package com.hzchum.scim.system.core.api.common.enums;

public enum MenuSystemEnum {
   CONTAINS(1, "钢结构管理系统(PLM)"),
   NOT_CONTAINS(2, "物联系统");

   private final Integer type;
   private final String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   MenuSystemEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
