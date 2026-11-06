package com.hzchum.scim.mes.building.core.api.enums;

public enum MeteUnitEnum {
   NET_WEIGHT(1, "净重"),
   GROSS_WEIGHT(2, "毛重");

   private int type;
   private String name;

   MeteUnitEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
