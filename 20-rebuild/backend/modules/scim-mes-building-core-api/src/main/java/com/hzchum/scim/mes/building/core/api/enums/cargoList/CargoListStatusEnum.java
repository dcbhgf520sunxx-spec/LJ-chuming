package com.hzchum.scim.mes.building.core.api.enums.cargoList;

public enum CargoListStatusEnum {
   LOADING(1, "装车"),
   WEIGH(2, "过磅"),
   SHIPMENT(4, "发运"),
   RECEIPT(8, "收货"),
   LOADING_NO(16, "未装车");

   private final Integer type;
   private final String name;

   CargoListStatusEnum(final Integer type, final String name) {
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
