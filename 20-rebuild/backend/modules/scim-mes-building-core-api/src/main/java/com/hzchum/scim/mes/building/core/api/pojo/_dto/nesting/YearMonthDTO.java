package com.hzchum.scim.mes.building.core.api.pojo._dto.nesting;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "YearMonthDTO", description = "年月对象")
public class YearMonthDTO {
   @ApiModelProperty("年月")
   @JsonProperty("yearMonth")
   @JSONField(name = "yearMonth")
   private String yearMonth;
   @ApiModelProperty("年")
   @JsonProperty("year")
   @JSONField(name = "year")
   private String year;
   @ApiModelProperty("月")
   @JsonProperty("month")
   @JSONField(name = "month")
   private String month;

   public static YearMonthDTO.YearMonthDTOBuilder builder() {
      return new YearMonthDTO.YearMonthDTOBuilder();
   }

   public YearMonthDTO(final String yearMonth, final String year, final String month) {
      this.yearMonth = yearMonth;
      this.year = year;
      this.month = month;
   }

   public YearMonthDTO() {
   }

   public String getYearMonth() {
      return this.yearMonth;
   }

   public String getYear() {
      return this.year;
   }

   public String getMonth() {
      return this.month;
   }

   @JsonProperty("yearMonth")
   public YearMonthDTO setYearMonth(final String yearMonth) {
      this.yearMonth = yearMonth;
      return this;
   }

   @JsonProperty("year")
   public YearMonthDTO setYear(final String year) {
      this.year = year;
      return this;
   }

   @JsonProperty("month")
   public YearMonthDTO setMonth(final String month) {
      this.month = month;
      return this;
   }

   @Override
   public String toString() {
      return "YearMonthDTO(yearMonth=" + this.getYearMonth() + ", year=" + this.getYear() + ", month=" + this.getMonth() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof YearMonthDTO)) {
         return false;
      }

      YearMonthDTO other = (YearMonthDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$yearMonth = this.getYearMonth();
      Object other$yearMonth = other.getYearMonth();
      if (this$yearMonth == null ? other$yearMonth == null : this$yearMonth.equals(other$yearMonth)) {
         Object this$year = this.getYear();
         Object other$year = other.getYear();
         if (this$year == null ? other$year == null : this$year.equals(other$year)) {
            Object this$month = this.getMonth();
            Object other$month = other.getMonth();
            return this$month == null ? other$month == null : this$month.equals(other$month);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof YearMonthDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $yearMonth = this.getYearMonth();
      result = result * 59 + ($yearMonth == null ? 43 : $yearMonth.hashCode());
      Object $year = this.getYear();
      result = result * 59 + ($year == null ? 43 : $year.hashCode());
      Object $month = this.getMonth();
      return result * 59 + ($month == null ? 43 : $month.hashCode());
   }

   public static class YearMonthDTOBuilder {
      private String yearMonth;
      private String year;
      private String month;

      YearMonthDTOBuilder() {
      }

      @JsonProperty("yearMonth")
      public YearMonthDTO.YearMonthDTOBuilder yearMonth(final String yearMonth) {
         this.yearMonth = yearMonth;
         return this;
      }

      @JsonProperty("year")
      public YearMonthDTO.YearMonthDTOBuilder year(final String year) {
         this.year = year;
         return this;
      }

      @JsonProperty("month")
      public YearMonthDTO.YearMonthDTOBuilder month(final String month) {
         this.month = month;
         return this;
      }

      public YearMonthDTO build() {
         return new YearMonthDTO(this.yearMonth, this.year, this.month);
      }

      @Override
      public String toString() {
         return "YearMonthDTO.YearMonthDTOBuilder(yearMonth=" + this.yearMonth + ", year=" + this.year + ", month=" + this.month + ")";
      }
   }
}
