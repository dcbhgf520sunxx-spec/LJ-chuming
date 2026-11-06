package com.hzchum.scim.common.core.api.enums;

public enum MesProductEnum {
   BUILDING(1, "建钢构件"),
   BRIDGE(2, "桥梁构件"),
   ENCLOSURE(4, "围护"),
   GRID(8, "网架构件");

   private final Integer type;
   private final String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   MesProductEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
