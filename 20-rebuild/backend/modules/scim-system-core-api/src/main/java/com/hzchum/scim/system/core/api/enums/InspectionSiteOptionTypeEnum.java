package com.hzchum.scim.system.core.api.enums;

public enum InspectionSiteOptionTypeEnum {
   GET_ALL(1, "获取全部"),
   GET_MYSELF(2, "我创建");

   private final Integer type;
   private final String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   InspectionSiteOptionTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
