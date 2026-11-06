package com.hzchum.scim.common.core.api.enums;

public enum PaintingTypeEnum {
   PRIMER(1, "底漆"),
   INTERMEDIATE_PAINT(2, "中间漆"),
   TOPCOAT(4, "面漆");

   private final Integer type;
   private final String name;

   PaintingTypeEnum(final Integer type, final String name) {
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
