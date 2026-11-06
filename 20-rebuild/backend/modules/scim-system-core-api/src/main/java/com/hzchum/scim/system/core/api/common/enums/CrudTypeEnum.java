package com.hzchum.scim.system.core.api.common.enums;

public enum CrudTypeEnum {
   SAVE(1, "新增"),
   UPDATE(2, "修改"),
   DALETE(3, "删除"),
   TRUE(4, "启用"),
   FALSE(5, "禁用");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      for (CrudTypeEnum value : values()) {
         if (value.getType().equals(type)) {
            return value.getName();
         }
      }

      return "";
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   CrudTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
