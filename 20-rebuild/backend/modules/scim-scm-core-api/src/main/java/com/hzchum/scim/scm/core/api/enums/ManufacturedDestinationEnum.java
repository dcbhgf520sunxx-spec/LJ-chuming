package com.hzchum.scim.scm.core.api.enums;

public enum ManufacturedDestinationEnum {
   CONSTRUCTION_SITE(1, "工地"),
   FACTORY(2, "工厂");

   private final Integer type;
   private final String name;

   ManufacturedDestinationEnum(Integer type, String name) {
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
