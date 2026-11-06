package com.hzchum.scim.system.core.api.common.enums;

import java.util.Arrays;

public enum WastePriceEntryTypeEnum {
   CREATE_ENTRY_PRICE(1, "创建时录入"),
   CHECK_ENTRY_PRICE(2, "审核时录入");

   private final Integer type;
   private final String name;

   public static Boolean boolExist(Integer type) {
      return Arrays.stream(values()).anyMatch(e -> e.getType().equals(type));
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   WastePriceEntryTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
