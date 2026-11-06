package com.hzchum.scim.system.core.api.common.enums;

import com.hzchum.pangu.common.exception.BusinessException;

public enum CostBasicClassEnum {
   STEEL_PLATE(1, "钢材"),
   SECTION_STEEL(2, "型材"),
   COLOR_ROLL(4, "钢卷"),
   ENCLOSURE(8, "围护"),
   GENERAL_MATERIAL(16, "一般物料"),
   GAS_OIL(32, "气体");

   private Integer type;
   private String name;

   CostBasicClassEnum(Integer type, String name) {
      this.type = type;
      this.name = name;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   public static String getNameByType(Integer type) {
      switch (type) {
         case 1:
            return STEEL_PLATE.getName();
         case 2:
            return SECTION_STEEL.getName();
         case 4:
            return COLOR_ROLL.getName();
         case 8:
            return ENCLOSURE.getName();
         case 16:
            return GENERAL_MATERIAL.getName();
         case 32:
            return GAS_OIL.getName();
         default:
            throw new BusinessException("分类编号错误");
      }
   }

   public static Integer getTypeByName(String name) {
      switch (name) {
         case "钢板":
            return STEEL_PLATE.getType();
         case "型钢":
            return SECTION_STEEL.getType();
         case "钢卷":
            return COLOR_ROLL.getType();
         case "围护":
         case "成品围护":
            return ENCLOSURE.getType();
         case "一般物料":
            return GENERAL_MATERIAL.getType();
         case "气体":
            return GAS_OIL.getType();
         default:
            throw new BusinessException("分类名称错误");
      }
   }

   public static boolean isGetSteelDosage(Integer basicClass) {
      return (STEEL_PLATE.getType() + SECTION_STEEL.getType() + COLOR_ROLL.getType() & basicClass) != 0;
   }
}
