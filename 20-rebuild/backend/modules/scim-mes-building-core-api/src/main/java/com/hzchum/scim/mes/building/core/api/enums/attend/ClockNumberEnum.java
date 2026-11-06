package com.hzchum.scim.mes.building.core.api.enums.attend;

public enum ClockNumberEnum {
   TWICE(2, "两次"),
   FOUR(4, "四次");

   private Integer type;
   private String name;

   ClockNumberEnum(final Integer type, final String name) {
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
