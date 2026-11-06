package com.hzchum.scim.system.core.api.common.enums;

import java.util.Arrays;

public enum SmallArtifactClassEnum {
   OTHER(1, "其他"),
   PLATE(2, "板材类"),
   SECTION(4, "型材类"),
   PURLIN(8, "檩条类");

   private final Integer type;
   private final String name;

   public static Boolean checkExist(Integer type) {
      return Arrays.stream(values()).anyMatch(e -> e.getType().equals(type));
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   SmallArtifactClassEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
