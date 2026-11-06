package com.hzchum.scim.contract.core.api.enums.payment;

import io.swagger.annotations.ApiOperation;

@ApiOperation("采购枚举")
public enum ProcurementTypeEnum {
   SELF_EMPLOYED(1, "自营"),
   INSOURCING(2, "内包(合营)制");

   private Integer type;
   private String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   ProcurementTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
