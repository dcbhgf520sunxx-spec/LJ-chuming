package com.hzchum.scim.contract.core.api.enums.payment;

import java.util.Arrays;

public enum InvoiceTypeEnum {
   DEDICATED(1, "增值税专用发票"),
   ORDINARY(2, "增值税普通发票"),
   RECEIPTS(4, "收据");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      for (InvoiceTypeEnum invoiceTypeEnum : values()) {
         if (invoiceTypeEnum.getType().equals(type)) {
            return invoiceTypeEnum.getName();
         }
      }

      return null;
   }

   public static Boolean isExist(Integer type) {
      return Arrays.stream(values()).anyMatch(s -> s.getType().equals(type));
   }

   InvoiceTypeEnum(final Integer type, final String name) {
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
