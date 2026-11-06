package com.hzchum.scim.wms.core.api.enums;

public enum InboundWayEnum {
   ORDINARY(1, "普通入库"),
   BEGIN_PERIOD(2, "期初入库");

   private Integer type;
   private String name;

   InboundWayEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public String getName() {
      return this.name;
   }

   public Integer getType() {
      return this.type;
   }
}
