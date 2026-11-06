package com.hzchum.scim.wms.core.api.enums;

public enum FillWayEnum {
   APPLICATION(1, "入库提交时填写"),
   AUDIT(2, "入库审核时填写");

   private final Integer type;
   private final String name;

   FillWayEnum(Integer type, String name) {
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
