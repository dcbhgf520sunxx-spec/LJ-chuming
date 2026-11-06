package com.hzchum.scim.contract.core.api.enums;

public enum ProjectContentNoEnum {
   STRUCTURE(1, "结构件"),
   PRESSURE_PLATE(2, "压型彩板"),
   SANDWICH_BOARD(4, "夹芯板"),
   TRUSS_FLOOR_PLATE(8, "桁架楼承板"),
   PRESSURE_FLOOR_PLATE(16, "压型楼承板"),
   EDGEFOLD(32, "折边件"),
   AUXILIARY(64, "配套件"),
   BODY_PARTS(128, "箱体件"),
   All_ENCLOSURE(256, "围护");

   private final Integer no;
   private final String name;

   public static String getNameByType(Integer type) {
      for (ProjectContentNoEnum contentCategoryEnum : values()) {
         if (contentCategoryEnum.getNo().equals(type)) {
            return contentCategoryEnum.getName();
         }
      }

      return null;
   }

   public Integer getType() {
      return this.no;
   }

   public Integer getNo() {
      return this.no;
   }

   public String getName() {
      return this.name;
   }

   ProjectContentNoEnum(final Integer no, final String name) {
      this.no = no;
      this.name = name;
   }
}
