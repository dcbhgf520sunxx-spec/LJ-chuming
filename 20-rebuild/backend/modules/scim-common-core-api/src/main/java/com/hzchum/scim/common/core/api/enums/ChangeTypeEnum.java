package com.hzchum.scim.common.core.api.enums;

public enum ChangeTypeEnum {
   CREATE(1, "新增"),
   DELETE(2, "删除"),
   UPDATE(4, "修改"),
   UN_CHANGE(8, "未修改");

   private final Integer type;
   private final String text;

   public Integer getType() {
      return this.type;
   }

   public String getText() {
      return this.text;
   }

   ChangeTypeEnum(final Integer type, final String text) {
      this.type = type;
      this.text = text;
   }
}
