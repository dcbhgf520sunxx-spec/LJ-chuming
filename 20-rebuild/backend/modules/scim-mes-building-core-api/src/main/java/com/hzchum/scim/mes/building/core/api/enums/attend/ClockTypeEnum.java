package com.hzchum.scim.mes.building.core.api.enums.attend;

public enum ClockTypeEnum {
   POSIT(1, "手机定位打卡"),
   FACE(2, "人脸识别打卡");

   private Integer type;
   private String name;

   ClockTypeEnum(final Integer type, final String name) {
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
