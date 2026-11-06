package com.hzchum.scim.mes.enclosure.core.api.enums.record;

public enum PrintProductTypeEnum {
   ARTIFACT(1),
   ENCLOSURE(2),
   PACKAGE(4);

   private Integer type;

   PrintProductTypeEnum(Integer type) {
      this.type = type;
   }

   public Integer getType() {
      return this.type;
   }
}
