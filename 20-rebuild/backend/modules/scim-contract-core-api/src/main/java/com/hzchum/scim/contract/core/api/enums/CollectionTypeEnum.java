package com.hzchum.scim.contract.core.api.enums;

import java.util.Arrays;

public enum CollectionTypeEnum {
   PROJECT_COLLECTION(1, "项目收款"),
   WASTE_COLLECTION(2, "废料收款"),
   SCRAP_COLLECTION(4, "废品收款");

   private final Integer type;
   private final String name;

   public static Boolean boolContain(Integer type) {
      return Arrays.stream(values()).anyMatch(e -> e.getType().equals(type));
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   CollectionTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
