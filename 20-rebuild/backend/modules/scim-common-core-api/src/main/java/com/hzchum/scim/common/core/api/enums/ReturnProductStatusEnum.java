package com.hzchum.scim.common.core.api.enums;

import java.util.Arrays;

public enum ReturnProductStatusEnum {
   SHIPPED(1, "已发运"),
   WAREHOUSED(2, "已入库"),
   UN_WAREHOUSE(4, "未入库");

   private final Integer type;
   private final String name;

   public static ReturnProductStatusEnum getByType(Integer type) {
      return Arrays.stream(values()).filter(em -> em.getType().equals(type)).findFirst().orElse(null);
   }

   ReturnProductStatusEnum(final Integer type, final String name) {
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
