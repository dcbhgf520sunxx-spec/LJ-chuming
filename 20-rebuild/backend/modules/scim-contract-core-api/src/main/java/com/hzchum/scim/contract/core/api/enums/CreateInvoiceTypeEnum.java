package com.hzchum.scim.contract.core.api.enums;

import java.util.Arrays;

public enum CreateInvoiceTypeEnum {
   PROJECT_COLLECTION(1, "项目开票"),
   WASTE_COLLECTION(2, "废料开票"),
   SCRAP_COLLECTION(4, "废品出售开票");

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

   CreateInvoiceTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
