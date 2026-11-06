package com.hzchum.scim.mes.enclosure.core.api.enums.cargoList;

import java.util.Arrays;
import java.util.Optional;

public enum ShipmentStatusEnum {
   DELIVERY(1, "送货中"),
   ABOLISH_DELIVERY(2, "取消送货"),
   SIGN_IN(4, "已签收");

   private Integer type;
   private String name;

   ShipmentStatusEnum(Integer type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(int type) {
      Optional<ShipmentStatusEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
