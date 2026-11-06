package com.hzchum.scim.system.core.api.common.enums.config;

import java.util.Arrays;

public enum PriceEditModeEnum {
   INSTANT_AUDIT(1, "立即审核"),
   TEMPORARY_SAVE(2, "暂时保存");

   private final Integer type;
   private final String name;

   public static Boolean boolExist(Integer type) {
      return Arrays.stream(values()).anyMatch(e -> e.getType().equals(type));
   }

   PriceEditModeEnum(final Integer type, final String name) {
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
