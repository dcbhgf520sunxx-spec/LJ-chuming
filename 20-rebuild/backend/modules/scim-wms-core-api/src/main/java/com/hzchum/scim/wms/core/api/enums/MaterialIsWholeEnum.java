package com.hzchum.scim.wms.core.api.enums;

public enum MaterialIsWholeEnum {
   WHOLE(1, "整料"),
   ODDMENT(2, "余料"),
   SCRAP(4, "废料");

   private final Integer type;
   private final String name;

   MaterialIsWholeEnum(Integer type, String name) {
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
