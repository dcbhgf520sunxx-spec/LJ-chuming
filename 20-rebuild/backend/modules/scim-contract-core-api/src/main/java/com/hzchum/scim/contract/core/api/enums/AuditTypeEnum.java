package com.hzchum.scim.contract.core.api.enums;

import io.swagger.annotations.ApiOperation;

@ApiOperation("审核类型")
public enum AuditTypeEnum {
   PAYMENT_APPROVE(1, "采购审核"),
   CONTRACT_APPROVE(2, "项目审核"),
   SUB_CONTRACT_APPROVE(3, "分包审核"),
   EXPENSE_ENTRY_APPROVE(4, "录入费用审核");

   private final Integer type;
   private final String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   AuditTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
