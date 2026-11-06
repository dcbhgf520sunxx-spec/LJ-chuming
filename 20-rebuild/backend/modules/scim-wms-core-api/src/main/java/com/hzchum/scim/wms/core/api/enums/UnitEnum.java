package com.hzchum.scim.wms.core.api.enums;

public enum UnitEnum {
   DIGIT(1, "计数单位"),
   WEIGHT(2, "质量单位"),
   LENGTH(3, "长度单位"),
   AREA(4, "面积单位"),
   VOLUME(5, "体积单位");

   private final Integer type;
   private final String name;

   UnitEnum(Integer type, String name) {
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
