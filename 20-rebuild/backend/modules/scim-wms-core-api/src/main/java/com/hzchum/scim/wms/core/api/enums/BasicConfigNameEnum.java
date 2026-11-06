package com.hzchum.scim.wms.core.api.enums;

public enum BasicConfigNameEnum {
   BASIC_(1, "基础入库配置"),
   PROXIMATE_MATTER(2, "钢材入库配置"),
   COLOR_ROLL(3, "基础出库配置");

   private final Integer type;
   private final String name;

   BasicConfigNameEnum(Integer type, String name) {
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
