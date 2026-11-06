package com.hzchum.scim.mes.building.core.api.enums.cargoList;

import java.util.Arrays;
import java.util.Optional;

public enum MeansConveyanceEnum {
   CAR(1, "车"),
   BOAT(2, "船");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      Optional<MeansConveyanceEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.map(MeansConveyanceEnum::getName).orElse(null);
   }

   MeansConveyanceEnum(final Integer type, final String name) {
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
