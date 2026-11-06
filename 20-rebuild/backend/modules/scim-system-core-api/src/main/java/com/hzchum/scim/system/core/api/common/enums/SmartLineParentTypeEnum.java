package com.hzchum.scim.system.core.api.common.enums;

public enum SmartLineParentTypeEnum {
   BEAM(1, "梁"),
   COLUMN(2, "柱");

   private final Integer type;
   private final String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   SmartLineParentTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
