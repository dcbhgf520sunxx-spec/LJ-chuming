package com.hzchum.scim.mes.building.core.api.enums.wage_quota_management;

import java.util.Objects;
import java.util.stream.Stream;

public enum AssembleClassificationWayEnum {
   SECTION_HEIGHT(1, "按截面高度"),
   SECTION_HEIGHT_AND_WEB_THICKNESS(2, "按截面高度 + 腹板厚度");

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

   AssembleClassificationWayEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
