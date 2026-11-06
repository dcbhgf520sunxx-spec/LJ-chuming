package com.hzchum.scim.system.core.api.common.enums;

import java.util.Arrays;
import java.util.Optional;

public enum CcPositionEnum {
   START(1, "START"),
   FINISH(2, "FINISH"),
   START_FINISH(3, "START_FINISH");

   private int type;
   private String name;

   CcPositionEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static String getNameByType(int type) {
      Optional<CcPositionEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.map(CcPositionEnum::getName).orElse(null);
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
