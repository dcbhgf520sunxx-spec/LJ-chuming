package com.hzchum.scim.contract.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum ProjectTypeEnum {
   DEFAULT(0, "默认0"),
   MES(1, "建筑钢结构"),
   BRIDGE(2, "桥梁钢结构"),
   PARKING_LOT(4, "立体停车库"),
   ENCLOSURE(8, "建筑围护制品"),
   PAINTING(16, "涂装分项"),
   WINDOWS(32, "门窗分项"),
   OTHER(64, "其他分项");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      Optional<ProjectTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.map(ProjectTypeEnum::getName).orElse(null);
   }

   public static boolean checkIsExist(Integer type) {
      for (ProjectTypeEnum projectTypeEnum : values()) {
         if (projectTypeEnum.getType().equals(type)) {
            return true;
         }
      }

      return false;
   }

   ProjectTypeEnum(final Integer type, final String name) {
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
