package com.hzchum.scim.mes.enclosure.core.api.enums.scheduling;

import java.util.Arrays;
import java.util.Optional;

public enum SchedulingStatusEnum {
   un_Issued(1, "未下发"),
   PAINT(2, "油漆类"),
   MAKINGS(4, "下料类"),
   DRILL_HOLE(8, "钻孔类"),
   PRESSING(16, "压板类");

   private int type;
   private String name;

   SchedulingStatusEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(int type) {
      Optional<SchedulingStatusEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
