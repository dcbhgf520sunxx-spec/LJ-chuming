package com.hzchum.scim.plan.core.api.enums;

public enum ChangeInstructionEnum {
   NEW("新增"),
   REMOVE("删除"),
   EDIT_QUANTITY("编辑数量");

   private final String name;

   ChangeInstructionEnum(final String name) {
      this.name = name;
   }

   public String getName() {
      return this.name;
   }
}
