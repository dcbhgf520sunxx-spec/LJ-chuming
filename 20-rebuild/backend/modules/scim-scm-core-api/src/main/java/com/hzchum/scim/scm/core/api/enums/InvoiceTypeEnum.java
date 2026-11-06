package com.hzchum.scim.scm.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum InvoiceTypeEnum {
   PLAIN_INVOICE(1, "增值税专用发票"),
   SPECIAL_INVOICE(2, "增值税普通发票"),
   RECEIPT(4, "收据");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      Optional<InvoiceTypeEnum> invoiceTypeEnum = Arrays.stream(values()).filter(s -> s.getType().equals(type)).findFirst();
      return invoiceTypeEnum.map(InvoiceTypeEnum::getName).orElse(null);
   }

   public static boolean isExist(Integer type) {
      Optional<InvoiceTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.isPresent();
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   InvoiceTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
