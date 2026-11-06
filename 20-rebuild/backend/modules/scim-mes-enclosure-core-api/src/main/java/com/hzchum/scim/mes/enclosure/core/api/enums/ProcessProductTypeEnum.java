package com.hzchum.scim.mes.enclosure.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum ProcessProductTypeEnum {
   MACHINE_PART_PROCESS(1, "零件"),
   ARTIFACT_PROCESS(2, "构件"),
   ENCLOSURE_PROCESS(4, "围护");

   private int type;
   private String name;

   ProcessProductTypeEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(int type) {
      Optional<ProcessProductTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
