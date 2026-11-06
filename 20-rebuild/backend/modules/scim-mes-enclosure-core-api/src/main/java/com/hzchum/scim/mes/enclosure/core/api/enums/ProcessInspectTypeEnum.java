package com.hzchum.scim.mes.enclosure.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum ProcessInspectTypeEnum {
   SINGLE_UNSCAN(0, "单件(不扫码)"),
   SINGLE_SCAN(1, "单件(需扫码)"),
   BATCH_UNSCAN(2, "批量(不扫码)"),
   BATCH_SCAN(3, "批量(需扫码)"),
   MACHINE(4, "机连");

   private int type;
   private String name;

   ProcessInspectTypeEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(int type) {
      Optional<ProcessInspectTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
