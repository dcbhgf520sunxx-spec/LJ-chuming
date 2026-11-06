package com.hzchum.scim.wms.core.api.enums;

public enum MeasuringWayEnum {
   NUMERICAL(1, "数值"),
   ACCOUNTING(2, "百分比");

   private final Integer type;
   private final String name;

   MeasuringWayEnum(Integer type, String name) {
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
