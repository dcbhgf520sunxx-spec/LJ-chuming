package com.hzchum.scim.contract.core.api.enums;

public enum CostTypeEnum {
   MATERIAL_COST(1, "材料费用"),
   SERVICE_COST(2, "劳务成本"),
   SUBCONTRACTING_COST(3, "分包成本"),
   LEASE_CHARGE(4, "租赁费"),
   PERIOD_EXPENSE(5, "期间费用"),
   OTHER_COST(6, "其他费用");

   private final Integer type;
   private final String name;

   CostTypeEnum(final Integer type, final String name) {
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
