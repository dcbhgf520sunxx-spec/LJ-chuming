package com.hzchum.scim.system.core.api.common.enums;

import java.util.Arrays;

public enum AuxiliaryTypeEnum {
   MALE_PIN(1, "栓钉"),
   SLEEVE(2, "套筒"),
   OTHER(4, "其他");

   private final Integer type;
   private final String name;

   public static Boolean checkExist(Integer type) {
      return Arrays.stream(values()).anyMatch(s -> s.getType().equals(type));
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   AuxiliaryTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
