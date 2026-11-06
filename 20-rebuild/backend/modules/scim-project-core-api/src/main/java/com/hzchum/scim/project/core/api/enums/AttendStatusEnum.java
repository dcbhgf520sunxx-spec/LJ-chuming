package com.hzchum.scim.project.core.api.enums;

public enum AttendStatusEnum {
   ABSENTEE(1, "旷工"),
   ABSENCE(2, "缺勤"),
   NORMAL(4, "正常");

   private final Integer type;
   private final String name;

   AttendStatusEnum(final Integer type, final String name) {
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
