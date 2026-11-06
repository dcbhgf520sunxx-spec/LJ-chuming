package com.hzchum.scim.mes.enclosure.core.api.enums.process;

public enum ProcessNameEnum {
   MAKINGS("下料");

   private String name;

   ProcessNameEnum(String name) {
      this.name = name;
   }

   public String getName() {
      return this.name;
   }
}
