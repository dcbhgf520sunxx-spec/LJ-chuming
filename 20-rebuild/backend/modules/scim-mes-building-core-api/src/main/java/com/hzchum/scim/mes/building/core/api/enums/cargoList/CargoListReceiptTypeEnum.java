package com.hzchum.scim.mes.building.core.api.enums.cargoList;

public enum CargoListReceiptTypeEnum {
   RESERVED_LOADING(1, "保留装车"),
   NO_RESERVED_LOADING(2, "不保留装车");

   private final Integer type;
   private final String name;

   CargoListReceiptTypeEnum(final Integer type, final String name) {
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
