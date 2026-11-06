package com.hzchum.scim.contract.core.api.enums.payment;

import java.util.Arrays;

public enum SupplierPaymentInvoiceDetailTypeEnum {
   MATERIALS_PURCHASE(1, "原材料采购物流费"),
   MANUFACTURES_SHIP(2, "制成品发运物流费"),
   MANUFACTURES_PURCHASE(4, "制成品采购物流费"),
   SPORADIC_PURCHASE(8, "零星物流费");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      SupplierPaymentInvoiceDetailTypeEnum[] values = values();

      for (SupplierPaymentInvoiceDetailTypeEnum invoiceTypeEnum : values) {
         if (invoiceTypeEnum.getType().equals(type)) {
            return invoiceTypeEnum.getName();
         }
      }

      return null;
   }

   public static Boolean isExist(Integer type) {
      return Arrays.stream(values()).anyMatch(s -> s.type.equals(type));
   }

   SupplierPaymentInvoiceDetailTypeEnum(final Integer type, final String name) {
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
