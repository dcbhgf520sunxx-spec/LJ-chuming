package com.hzchum.scim.plan.core.api.enums;

public enum TechChangeTypeEnum {
   PAUSE(1, "暂停"),
   CANCEL_PAUSE(2, "取消暂停"),
   DELETE(4, "删除"),
   ADD_QUANTITY(8, "增加数量"),
   REDUCE_QUANTITY(16, "减少数量"),
   MODIFY(32, "修改其他");

   private final Integer type;
   private final String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   TechChangeTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
