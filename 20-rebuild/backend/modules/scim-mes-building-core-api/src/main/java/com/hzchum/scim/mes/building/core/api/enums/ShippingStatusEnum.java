package com.hzchum.scim.mes.building.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum ShippingStatusEnum {
   NOT_SHIPPED(1, "未发运"),
   PARTIAL_SHIPPED(2, "部分发运"),
   ALL_SHIPPED(4, "已发运");

   private final Integer type;
   private final String name;

   ShippingStatusEnum(Integer type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(Integer type) {
      Optional<ShippingStatusEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.isPresent();
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
