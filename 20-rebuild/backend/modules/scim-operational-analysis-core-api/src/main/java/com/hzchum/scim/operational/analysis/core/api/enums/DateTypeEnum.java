package com.hzchum.scim.operational.analysis.core.api.enums;

public enum DateTypeEnum {
   YEAR(1, "年度", "yyyy"),
   MONTH(2, "月度", "yyyy-MM"),
   DAY(4, "日度", "yyyy-MM-dd");

   private final Integer type;
   private final String name;
   private final String format;

   public static String getFormatByType(Integer type) {
      for (DateTypeEnum dateTypeEnum : values()) {
         if (dateTypeEnum.getType().equals(type)) {
            return dateTypeEnum.getFormat();
         }
      }

      return "";
   }

   public static String getNameByType(Integer type) {
      for (DateTypeEnum dateTypeEnum : values()) {
         if (dateTypeEnum.getType().equals(type)) {
            return dateTypeEnum.getName();
         }
      }

      return "";
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   public String getFormat() {
      return this.format;
   }

   DateTypeEnum(final Integer type, final String name, final String format) {
      this.type = type;
      this.name = name;
      this.format = format;
   }
}
