package com.hzchum.scim.mes.enclosure.core.api.enums.factory;

import java.util.Arrays;
import java.util.Optional;

public enum MesEnclosureCutTypeEnum {
   FLAME_CUT(1, "火焰切割"),
   PLASMA_CUT(2, "等离子切割"),
   LASER_CUT(4, "激光切割"),
   PLATE_CUT(8, "剪版");

   private final int type;
   private String name;

   MesEnclosureCutTypeEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(long type) {
      Optional<MesEnclosureCutTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
