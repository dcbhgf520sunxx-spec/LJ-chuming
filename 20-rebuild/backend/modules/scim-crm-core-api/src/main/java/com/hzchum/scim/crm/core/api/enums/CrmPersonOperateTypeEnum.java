package com.hzchum.scim.crm.core.api.enums;

public enum CrmPersonOperateTypeEnum {
   ROUTINE_OPERATIONS(1, "常规操作"),
   NOT_MODIFIABLE(2, "不可修改");

   private final Integer type;
   private final String name;

   CrmPersonOperateTypeEnum(final Integer type, final String name) {
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
