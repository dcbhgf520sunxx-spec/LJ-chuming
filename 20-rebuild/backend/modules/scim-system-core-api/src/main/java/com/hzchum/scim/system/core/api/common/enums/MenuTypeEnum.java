package com.hzchum.scim.system.core.api.common.enums;

public enum MenuTypeEnum {
   SYSTEM(3, "系统"),
   MODULE(0, "模块"),
   MENU(1, "菜单"),
   BUTTON(2, "按钮");

   private Integer value;
   private String name;

   MenuTypeEnum(int value, String name) {
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
