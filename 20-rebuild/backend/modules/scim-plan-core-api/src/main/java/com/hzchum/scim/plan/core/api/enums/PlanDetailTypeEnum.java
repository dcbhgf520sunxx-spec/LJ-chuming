package com.hzchum.scim.plan.core.api.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum PlanDetailTypeEnum {
   DEEPEN_PLAN(1, "深化计划"),
   PROCESSING_PLAN(2, "加工计划"),
   INSTALL_PLAN(4, "安装计划"),
   SHIP_PLAN(8, "发运计划"),
   MATERIAL_PURCHASE_PLAN(16, "材料采购计划");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      PlanDetailTypeEnum[] values = values();

      for (PlanDetailTypeEnum value : values) {
         if (value.getType().equals(type)) {
            return value.getName();
         }
      }

      return null;
   }

   public static List<Integer> listAllType() {
      return Arrays.stream(values()).map(PlanDetailTypeEnum::getType).collect(Collectors.toList());
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   PlanDetailTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
