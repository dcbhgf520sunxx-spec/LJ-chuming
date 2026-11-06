package com.hzchum.scim.mes.building.core.api.enums.temp_work;

import java.util.Objects;
import java.util.stream.Stream;

public enum TempWorkReasonEnum {
   PROJECT(1, "项目点工"),
   NON_PROJECT(2, "非项目点工");

   private final Integer type;
   private final String name;

   public static boolean isExist(Integer type) {
      return Stream.of(values()).anyMatch(e -> Objects.equals(e.getType(), type));
   }

   public static String getName(Integer type) {
      return Stream.of(values())
         .filter(e -> Objects.equals(e.getType(), type))
         .map(TempWorkReasonEnum::getName)
         .findFirst()
         .orElseThrow(() -> new IllegalArgumentException("点工原因不存在"));
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   TempWorkReasonEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
