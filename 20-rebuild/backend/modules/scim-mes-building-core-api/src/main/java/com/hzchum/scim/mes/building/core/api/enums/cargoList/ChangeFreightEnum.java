package com.hzchum.scim.mes.building.core.api.enums.cargoList;

import java.util.Arrays;
import java.util.Optional;

public enum ChangeFreightEnum {
   FREIGHT_RETAIN(1, "运费保留"),
   FREIGHT_INVALID(2, "运费作废"),
   FREIGHT_CHANGES(4, "运费变更");

   private Integer type;
   private String name;

   ChangeFreightEnum(Integer type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(int type) {
      Optional<ChangeFreightEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
