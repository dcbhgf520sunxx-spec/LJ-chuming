package com.hzchum.scim.plan.core.api.enums;

import java.util.Arrays;

public enum EnclosureCategoryEnum {
   PRESSURE_COLOR_PLATE(2, "压型彩板", "PressureColorPlate"),
   SANDWICH_BOARD(4, "夹芯板", "SandwichBoard"),
   TRUSS_FLOOR_BEARING_PLATE(8, "桁架楼承板", "TrussFloorBearingPlate"),
   PRESSURE_FLOOR_BEARING_PLATE(16, "压型楼承板", "PressureFloorBearingPlate"),
   FLANG_PIECE(32, "折边件", "FlangPiece");

   private final Integer category;
   private final String name;
   private final String fileName;

   public Integer getType() {
      return this.category;
   }

   public static String getNameByCategory(Integer category) {
      EnclosureCategoryEnum[] enums = values();

      for (EnclosureCategoryEnum anEnum : enums) {
         if (anEnum.getCategory().equals(category)) {
            return anEnum.getName();
         }
      }

      return null;
   }

   public static String getFileNameByCategory(Integer category) {
      EnclosureCategoryEnum[] enums = values();

      for (EnclosureCategoryEnum anEnum : enums) {
         if (anEnum.getCategory().equals(category)) {
            return anEnum.getFileName();
         }
      }

      return null;
   }

   public static Boolean isExist(Integer category) {
      EnclosureCategoryEnum[] values = values();

      for (EnclosureCategoryEnum categoryEnum : values) {
         if (categoryEnum.getCategory().equals(category)) {
            return Boolean.TRUE;
         }
      }

      return Boolean.FALSE;
   }

   public static Boolean boolContain(String name) {
      return Arrays.stream(values()).anyMatch(e -> e.getName().equals(name));
   }

   public Integer getCategory() {
      return this.category;
   }

   public String getName() {
      return this.name;
   }

   public String getFileName() {
      return this.fileName;
   }

   EnclosureCategoryEnum(final Integer category, final String name, final String fileName) {
      this.category = category;
      this.name = name;
      this.fileName = fileName;
   }
}
