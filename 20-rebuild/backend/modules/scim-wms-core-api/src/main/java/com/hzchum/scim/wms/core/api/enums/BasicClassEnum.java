package com.hzchum.scim.wms.core.api.enums;

import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.exception.BusinessException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public enum BasicClassEnum {
   STEEL_PLATE(1, "钢板", "GB"),
   SECTION_STEEL(2, "型材", "XC"),
   COLOR_ROLL(4, "钢卷", "GJ"),
   GENERAL_MATERIAL(8, "生产辅材", "FC"),
   GAS(16, "气体", "QT"),
   STRUC_MANUFACTURED(32, "制成品-结构制品", "JGZP"),
   ENCL_MANUFACTURED(64, "制成品-围护制品", "WHZP"),
   OTHER(128, "办公用品", "BGYP"),
   OTHER_STEEL_MATERIALS(256, "其它钢材", "QTGC"),
   AUX_MANUFACTURED(512, "制成品-配套制品", "PTZP");

   private final Integer type;
   private final String name;
   private final String acronym;

   BasicClassEnum(Integer type, String name, String acronym) {
      this.type = type;
      this.name = name;
      this.acronym = acronym;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   public String getAcronym() {
      return this.acronym;
   }

   public static Integer getMaterialNum() {
      return STEEL_PLATE.getType()
         | COLOR_ROLL.getType()
         | SECTION_STEEL.getType()
         | GENERAL_MATERIAL.getType()
         | GAS.getType()
         | OTHER.getType()
         | OTHER_STEEL_MATERIALS.getType();
   }

   public static Integer getFinishedProductsNum() {
      return STRUC_MANUFACTURED.getType() | ENCL_MANUFACTURED.getType() | AUX_MANUFACTURED.getType();
   }

   public static Integer getSteelNum() {
      return STEEL_PLATE.getType() | COLOR_ROLL.getType() | SECTION_STEEL.getType();
   }

   public static Boolean checkIsSteel(Integer type) {
      int i = STEEL_PLATE.getType() | COLOR_ROLL.getType() | SECTION_STEEL.getType();
      return (i & type) == type;
   }

   public static Boolean checkIsSteelAddOtherSteelMaterials(Integer type) {
      int i = STEEL_PLATE.getType() | COLOR_ROLL.getType() | SECTION_STEEL.getType() | OTHER_STEEL_MATERIALS.getType();
      return (i & type) == type;
   }

   public static Boolean checkIsFinishedProducts(Integer type) {
      int i = STRUC_MANUFACTURED.getType() | ENCL_MANUFACTURED.getType() | AUX_MANUFACTURED.getType();
      return (i & type) == type;
   }

   public static List<Integer> getSteelList() {
      List<Integer> steelList = new ArrayList<>();
      steelList.add(STEEL_PLATE.getType());
      steelList.add(SECTION_STEEL.getType());
      steelList.add(COLOR_ROLL.getType());
      return steelList;
   }

   public static Boolean checkNotSteel(Integer type) {
      int i = GENERAL_MATERIAL.getType() | GAS.getType() | OTHER.getType() | OTHER_STEEL_MATERIALS.getType();
      return (i & type) == type;
   }

   public static Boolean checkMaterialByType(Integer type) {
      switch (type) {
         case 1:
         case 2:
         case 4:
         case 8:
         case 16:
         case 128:
         case 256:
            return true;
         default:
            return false;
      }
   }

   public static String getNameByType(Integer type) {
      Preconditions.checkArgument(type != null, "物料类型值不能为空!");
      BasicClassEnum[] values = values();

      for (BasicClassEnum basicClassEnum : values) {
         if (type.equals(basicClassEnum.getType())) {
            return basicClassEnum.getName();
         }
      }

      throw new BusinessException("物料类型值不存在!");
   }

   public static String getAcronymByType(Integer type) {
      Preconditions.checkArgument(type != null, "物料类型值不能为空!");
      BasicClassEnum[] values = values();

      for (BasicClassEnum basicClassEnum : values) {
         if (type.equals(basicClassEnum.getType())) {
            return basicClassEnum.getAcronym();
         }
      }

      throw new BusinessException("物料类型值不存在!");
   }

   public static String getNameStr(Integer type) {
      BasicClassEnum[] classEnums = values();
      List<String> names = new ArrayList<>();

      for (BasicClassEnum classEnum : classEnums) {
         if ((classEnum.getType() & type) > 0) {
            names.add(classEnum.getName());
         }
      }

      return StringUtils.join(names, "、");
   }

   public static String getNameStr1(Integer type) {
      BasicClassEnum[] classEnums = values();
      List<String> names = new ArrayList<>();

      for (BasicClassEnum classEnum : classEnums) {
         if ((classEnum.getType() & type) > 0 && checkIsSteel(classEnum.getType())) {
            names.add("钢材");
            break;
         }

         if ((classEnum.getType() & type) > 0) {
            names.add(classEnum.getName());
         }
      }

      return StringUtils.join(names, "、");
   }

   public static List<Integer> getNameStr2(Integer type) {
      BasicClassEnum[] classEnums = values();
      List<Integer> names = new ArrayList<>();

      for (BasicClassEnum classEnum : classEnums) {
         if ((classEnum.getType() & type) > 0) {
            names.add(classEnum.getType());
         }
      }

      return names;
   }
}
