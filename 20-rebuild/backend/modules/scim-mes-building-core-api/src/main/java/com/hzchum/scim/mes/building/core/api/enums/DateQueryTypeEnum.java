package com.hzchum.scim.mes.building.core.api.enums;

public enum DateQueryTypeEnum {
   DAY("天", "day", "%Y-%m-%d"),
   WEEK("周", "week", "%Y-%m-%d"),
   MONTH("月", "month", "%Y-%m"),
   LAST_MONTH("上月", "last_month", "%Y-%m"),
   YEAR("年", "year", "%Y");

   private final String type;
   private final String typeEn;
   private final String format;

   public String getType() {
      return this.type;
   }

   public String getTypeEn() {
      return this.typeEn;
   }

   public String getFormat() {
      return this.format;
   }

   DateQueryTypeEnum(final String type, final String typeEn, final String format) {
      this.type = type;
      this.typeEn = typeEn;
      this.format = format;
   }
}
