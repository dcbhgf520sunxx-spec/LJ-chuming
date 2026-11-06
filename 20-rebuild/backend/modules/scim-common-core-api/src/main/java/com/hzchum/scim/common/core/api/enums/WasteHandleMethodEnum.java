package com.hzchum.scim.common.core.api.enums;

import java.util.Arrays;

public enum WasteHandleMethodEnum {
   REUSE(1, "二次利用"),
   WASTE_SALE(2, "废品出售");

   private final Integer type;
   private final String name;

   public static WasteHandleMethodEnum getByType(Integer type) {
      return Arrays.stream(values()).filter(em -> em.getType().equals(type)).findFirst().orElse(null);
   }

   public static String getNameByType(Integer type) {
      WasteHandleMethodEnum wasteHandleMethodEnum = Arrays.stream(values()).filter(em -> em.getType().equals(type)).findFirst().orElse(null);
      return wasteHandleMethodEnum != null ? wasteHandleMethodEnum.getName() : null;
   }

   WasteHandleMethodEnum(final Integer type, final String name) {
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
