package com.hzchum.scim.bid.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum InvoiceTypeEnum {
   SPECIAL(1, "增值税专用发票"),
   ORDINARY(2, "增值税普通发票"),
   NO(4, "收据");

   private Integer type;
   private String name;

   InvoiceTypeEnum(Integer type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(int type) {
      Optional<InvoiceTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public String getName() {
      return this.name;
   }

   public Integer getType() {
      return this.type;
   }

   public static String getNameByType(Integer type) {
      Optional<InvoiceTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.isPresent() ? optional.get().getName() : null;
   }
}
