package com.hzchum.scim.system.core.api.common.enums;

public enum CompareMinLengthEnum {
   GREAT_THAN(1, ">"),
   GREAT_THAN_EQUAL(2, ">=");

   private final Integer type;
   private final String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   CompareMinLengthEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
