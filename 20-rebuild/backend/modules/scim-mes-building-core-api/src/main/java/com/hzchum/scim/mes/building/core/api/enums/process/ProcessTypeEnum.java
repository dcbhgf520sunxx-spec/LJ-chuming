package com.hzchum.scim.mes.building.core.api.enums.process;

import java.util.Arrays;
import java.util.Optional;

public enum ProcessTypeEnum {
   ASSEMBLY_RIVETING_WELDING(1, "组铆焊类"),
   PAINT(2, "油漆类"),
   MAKINGS(4, "下料类"),
   DRILL_HOLE(8, "钻孔类"),
   PRESSING(16, "压板类");

   private int type;
   private String name;

   ProcessTypeEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(int type) {
      Optional<ProcessTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   public static String getNameByType(Integer type) {
      for (ProcessTypeEnum value : values()) {
         if (value.getType().equals(type)) {
            return value.getName();
         }
      }

      return "";
   }
}
