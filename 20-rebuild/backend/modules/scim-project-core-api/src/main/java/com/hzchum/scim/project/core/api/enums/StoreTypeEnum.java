package com.hzchum.scim.project.core.api.enums;

public enum StoreTypeEnum {
   BEGINNING(1, "期初"),
   INBOUND(2, "入库"),
   OUTBOUND(3, "出库"),
   STOCK(4, "期末");

   private Integer type;
   private String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   StoreTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
