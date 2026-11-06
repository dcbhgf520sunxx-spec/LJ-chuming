package com.hzchum.scim.system.core.api.common.enums;

public enum UserTypeEnum {
   COMMON_USER(1, "公司普通用户(编制内)"),
   TEMP_USER(2, "临时用户"),
   LABOR_USER(4, "中南劳务人员用户(编制外)");

   private final Integer type;
   private final String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   UserTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
