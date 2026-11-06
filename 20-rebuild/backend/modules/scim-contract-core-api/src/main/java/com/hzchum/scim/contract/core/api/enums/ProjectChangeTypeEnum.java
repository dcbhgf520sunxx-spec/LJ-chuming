package com.hzchum.scim.contract.core.api.enums;

public enum ProjectChangeTypeEnum {
   INFO_CHANGE(1, "合同信息修改"),
   AMOUNT_CHANGE(2, "合同金额变更");

   private final Integer type;
   private final String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   ProjectChangeTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
