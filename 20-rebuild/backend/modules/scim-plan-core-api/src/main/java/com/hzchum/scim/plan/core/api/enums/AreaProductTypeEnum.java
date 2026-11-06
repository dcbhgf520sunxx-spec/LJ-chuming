package com.hzchum.scim.plan.core.api.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum AreaProductTypeEnum {
   STRUCTURE(1, "structure", "结构件"),
   PRESSURE_PLATE(2, "contourPlate", "压型彩板"),
   SANDWICH_BOARD(4, "battenBoard", "夹芯板"),
   TRUSS_FLOOR_PLATE(8, "trussFloorPlate", "桁架楼承板"),
   PRESSURE_FLOOR_PLATE(16, "pressureBearingPlate", "压型楼承板"),
   EDGEFOLD(32, "flangingPiece", "折边件"),
   BODY_PARTS(128, "body_parts", "箱体件");

   private final Integer type;
   private final String name;
   private final String desc;

   public static String getDescByType(Integer type) {
      for (AreaProductTypeEnum AreaProductTypeEnum : values()) {
         if (AreaProductTypeEnum.getType().equals(type)) {
            return AreaProductTypeEnum.getDesc();
         }
      }

      return null;
   }

   public static Boolean isExist(Integer type) {
      List<Integer> list = Arrays.stream(values()).map(AreaProductTypeEnum::getType).collect(Collectors.toList());
      return list.contains(type);
   }

   public static String getNameByType(Integer type) {
      for (AreaProductTypeEnum AreaProductTypeEnum : values()) {
         if (AreaProductTypeEnum.getType().equals(type)) {
            return AreaProductTypeEnum.getDesc();
         }
      }

      return null;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   public String getDesc() {
      return this.desc;
   }

   AreaProductTypeEnum(final Integer type, final String name, final String desc) {
      this.type = type;
      this.name = name;
      this.desc = desc;
   }
}
