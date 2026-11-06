package com.hzchum.scim.scm.core.api.enums;

import cn.hutool.core.util.StrUtil;
import java.util.ArrayList;
import java.util.List;

public enum ApplyPurchaseMaterialTypeEnum {
   STEEL_PLATE(1, "钢板"),
   SECTION_STEEL(2, "型材"),
   COLOR_ROLL(4, "钢卷"),
   MATERIAL(8, "生产辅材"),
   GAS(16, "气体"),
   STRUC_MANUFACTURED(32, "制成品-结构制品"),
   ENCL_MANUFACTURED(64, "制成品-围护制品"),
   OTHER(128, "办公用品"),
   OTHER_STEEL_MATERIALS(256, "其它钢材"),
   STEEL(263, "钢材"),
   MANUFACTURED(96, "制成品");

   private final Integer type;
   private final String name;

   ApplyPurchaseMaterialTypeEnum(Integer type, String name) {
      this.type = type;
      this.name = name;
   }

   public static Boolean checkIsSteelAddOtherSteelMaterials(Integer type) {
      int i = STEEL_PLATE.getType() | COLOR_ROLL.getType() | SECTION_STEEL.getType() | OTHER_STEEL_MATERIALS.getType();
      return (i & type) == type;
   }

   public static Boolean checkIsManufacturedGoods(Integer type) {
      int i = STRUC_MANUFACTURED.getType() | ENCL_MANUFACTURED.getType();
      return (i & type) == type;
   }

   public static String getOrderTypeName(int materialType) {
      if (materialType == 263) {
         return "钢材";
      }

      if (materialType == 96) {
         return "制成品";
      }

      String name = "";
      List<Integer> result = new ArrayList<>();
      int power = 1;

      while (power * 2 <= materialType) {
         power *= 2;
      }

      for (; materialType > 0; power /= 2) {
         if (materialType >= power) {
            result.add(power);
            materialType -= power;
         }
      }

      for (Integer type : result) {
         if (StrUtil.isBlank(name)) {
            name = getName(type);
         } else {
            name = name + "|" + getName(type);
         }
      }

      return name;
   }

   public static String getName(Integer type) {
      String v = "";

      for (ApplyPurchaseMaterialTypeEnum value : values()) {
         if (value.getType().equals(type)) {
            v = value.getName();
         }
      }

      return v;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
