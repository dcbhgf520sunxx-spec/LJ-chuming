package com.hzchum.scim.mes.building.core.api.enums.scheduling;

import java.util.Arrays;
import java.util.Optional;

public enum MachinePartSchedulingTypeEnum {
   NOT(1, "无"),
   WORKSHOP(2, "车间级"),
   PRODUCTION_LINE(4, "产线级"),
   GROUPS(8, "生产组级");

   private int type;
   private String name;

   MachinePartSchedulingTypeEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(int type) {
      Optional<MachinePartSchedulingTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
