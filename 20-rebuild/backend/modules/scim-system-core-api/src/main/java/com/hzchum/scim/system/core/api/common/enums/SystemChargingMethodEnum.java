package com.hzchum.scim.system.core.api.common.enums;

import java.util.Arrays;
import java.util.Optional;

public enum SystemChargingMethodEnum {
   MAINTENANCE_FEE("维护费"),
   RENTAL_FEE("租赁费"),
   PROGRESS_PAYMENT("进度款");

   private final String type;

   public static boolean isExist(String type) {
      Optional<SystemChargingMethodEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.isPresent();
   }

   SystemChargingMethodEnum(final String type) {
      this.type = type;
   }

   public String getType() {
      return this.type;
   }
}
