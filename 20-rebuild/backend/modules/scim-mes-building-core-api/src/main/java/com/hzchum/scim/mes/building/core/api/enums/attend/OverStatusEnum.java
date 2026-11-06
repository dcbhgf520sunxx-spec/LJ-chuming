package com.hzchum.scim.mes.building.core.api.enums.attend;

public enum OverStatusEnum {
   UNDISTRIBUTED(0, "未分配"),
   ABSENTEE(1, "旷工"),
   ABSENCE(2, "缺勤"),
   NORMAL(4, "正常");

   private final Integer type;
   private final String name;

   OverStatusEnum(final Integer type, final String name) {
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
