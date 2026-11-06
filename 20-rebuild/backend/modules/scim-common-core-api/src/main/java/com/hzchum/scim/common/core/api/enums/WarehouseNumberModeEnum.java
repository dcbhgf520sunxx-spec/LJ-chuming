package com.hzchum.scim.common.core.api.enums;

import java.util.Arrays;

public enum WarehouseNumberModeEnum {
   AUTO_MODE(1),
   MANUAL_MODE(2);

   private final Integer type;

   public static Boolean check(Integer type) {
      return Arrays.stream(values()).anyMatch(em -> em.getType().equals(type));
   }

   WarehouseNumberModeEnum(final Integer type) {
      this.type = type;
   }

   public Integer getType() {
      return this.type;
   }
}
