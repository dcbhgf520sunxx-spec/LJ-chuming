package com.hzchum.scim.wms.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum InvoiceTypeEnum {
   SPECIAL(1, "专用发票"),
   ORDINARY(2, "普通发票"),
   RECEIPT(4, "收据"),
   CASH(8, "现金");

   private final Integer type;
   private final String name;

   InvoiceTypeEnum(Integer type, String name) {
      this.type = type;
      this.name = name;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   public static boolean isExist(int type) {
      Optional<InvoiceTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public static String getValueByType(Integer type) {
      Optional<InvoiceTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.map(InvoiceTypeEnum::getName).orElse(null);
   }
}
