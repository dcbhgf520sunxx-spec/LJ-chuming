package com.hzchum.scim.contract.core.api.enums.payment;

public enum OrderClassEnum {
   MATERIAL_ORDER(1, "原材料订单"),
   MANUFACTURE_ORDER(2, "制成品订单"),
   SUB_ORDER(4, "分包订单");

   private final Integer type;
   private final String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   OrderClassEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
