package com.hzchum.scim.contract.core.api.enums;

import java.util.Arrays;

public enum OrderSourceTypeEnum {
   INNER(1, "内部"),
   OUTER(2, "外部");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      OrderSourceTypeEnum orderSourceTypeEnum = Arrays.stream(values()).filter(em -> em.getType().equals(type)).findFirst().orElse(null);
      return orderSourceTypeEnum != null ? orderSourceTypeEnum.name : null;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   OrderSourceTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
