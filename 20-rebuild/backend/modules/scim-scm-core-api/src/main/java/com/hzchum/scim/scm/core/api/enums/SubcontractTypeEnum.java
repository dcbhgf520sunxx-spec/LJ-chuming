package com.hzchum.scim.scm.core.api.enums;

public enum SubcontractTypeEnum {
   UNDER_WAY(1, "执行中"),
   SETTLE_STATUS(2, "已结算"),
   TEMPORARY_STORAGE(3, "暂存");

   private final Integer type;
   private final String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   SubcontractTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
