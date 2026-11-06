package com.hzchum.scim.wms.core.api.enums;

public enum SchedulingDataTypeEnum {
   MES_DATA(1, "MES数据"),
   APP_DATA(2, "APP数据");

   private final Integer type;
   private final String name;

   SchedulingDataTypeEnum(Integer type, String name) {
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
