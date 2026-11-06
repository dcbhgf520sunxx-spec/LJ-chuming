package com.hzchum.scim.mes.enclosure.core.api.enums.cargoList;

public enum PackageStatusEnum {
   UNLOADING(0),
   LOADING(1),
   SHIPMENT(2),
   NO_SHIPMENT(4);

   private final Integer type;

   PackageStatusEnum(Integer type) {
      this.type = type;
   }

   public Integer getType() {
      return this.type;
   }
}
