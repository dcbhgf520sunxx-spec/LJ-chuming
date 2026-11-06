package com.hzchum.scim.contract.core.api.enums;

public enum ChangeEnum {
   ADD(1, "新增"),
   DELETE(2, "删除"),
   MODIFY(3, "修改"),
   PAUSE(4, "暂停"),
   CONTINUE(5, "继续");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      if (type == null) {
         return null;
      }

      ChangeEnum[] values = values();

      for (ChangeEnum changeEnum : values) {
         if (type.equals(changeEnum.getType())) {
            return changeEnum.getName();
         }
      }

      return null;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   ChangeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
