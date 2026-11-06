package com.hzchum.scim.mes.building.core.api.enums.wage_quota;

import java.util.Objects;
import java.util.stream.Stream;

public enum EnclosureProductQuotaConfigSpecificationClassEnum {
   LENGTH(1, "长度(mm)");

   private final Integer type;
   private final String name;

   public static boolean isExist(Integer type) {
      return Stream.of(values()).anyMatch(e -> Objects.equals(e.getType(), type));
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   EnclosureProductQuotaConfigSpecificationClassEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
