package com.hzchum.scim.wms.core.api.enums;

public enum MessageEnum {
   INVENTORY_WARNING(1, "库存预警"),
   PURCHASE_ORDER(2, "采购订单"),
   FREEZE_INFORMATION(3, "冻结信息"),
   RETURN_INVENTORY_INFORMATION(4, "退库信息"),
   APPLICATION_INFORMATION(5, "申领信息");

   private final Integer type;
   private final String name;

   MessageEnum(Integer type, String name) {
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
