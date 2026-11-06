package com.hzchum.scim.operational.analysis.core.api.pojo._dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class MonthSummaryRangeDTO {
   @ApiModelProperty(name = "year", value = "年份", notes = "年份")
   @JsonProperty("year")
   @JSONField(name = "year")
   private String year;
   @ApiModelProperty(name = "summaryList", value = "当年汇总", notes = "当年汇总")
   @JsonProperty("summaryList")
   @JSONField(name = "summaryList")
   private List<MonthSummaryDTO> summaryList;

   public static MonthSummaryRangeDTO.MonthSummaryRangeDTOBuilder builder() {
      return new MonthSummaryRangeDTO.MonthSummaryRangeDTOBuilder();
   }

   public String getYear() {
      return this.year;
   }

   public List<MonthSummaryDTO> getSummaryList() {
      return this.summaryList;
   }

   @JsonProperty("year")
   public void setYear(final String year) {
      this.year = year;
   }

   @JsonProperty("summaryList")
   public void setSummaryList(final List<MonthSummaryDTO> summaryList) {
      this.summaryList = summaryList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MonthSummaryRangeDTO)) {
         return false;
      } else {
         MonthSummaryRangeDTO other = (MonthSummaryRangeDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$year = this.getYear();
            Object other$year = other.getYear();
            if (this$year == null ? other$year == null : this$year.equals(other$year)) {
               Object this$summaryList = this.getSummaryList();
               Object other$summaryList = other.getSummaryList();
               return this$summaryList == null ? other$summaryList == null : this$summaryList.equals(other$summaryList);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MonthSummaryRangeDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $year = this.getYear();
      result = result * 59 + ($year == null ? 43 : $year.hashCode());
      Object $summaryList = this.getSummaryList();
      return result * 59 + ($summaryList == null ? 43 : $summaryList.hashCode());
   }

   @Override
   public String toString() {
      return "MonthSummaryRangeDTO(year=" + this.getYear() + ", summaryList=" + this.getSummaryList() + ")";
   }

   public MonthSummaryRangeDTO(final String year, final List<MonthSummaryDTO> summaryList) {
      this.year = year;
      this.summaryList = summaryList;
   }

   public MonthSummaryRangeDTO() {
   }

   public static class MonthSummaryRangeDTOBuilder {
      private String year;
      private List<MonthSummaryDTO> summaryList;

      MonthSummaryRangeDTOBuilder() {
      }

      @JsonProperty("year")
      public MonthSummaryRangeDTO.MonthSummaryRangeDTOBuilder year(final String year) {
         this.year = year;
         return this;
      }

      @JsonProperty("summaryList")
      public MonthSummaryRangeDTO.MonthSummaryRangeDTOBuilder summaryList(final List<MonthSummaryDTO> summaryList) {
         this.summaryList = summaryList;
         return this;
      }

      public MonthSummaryRangeDTO build() {
         return new MonthSummaryRangeDTO(this.year, this.summaryList);
      }

      @Override
      public String toString() {
         return "MonthSummaryRangeDTO.MonthSummaryRangeDTOBuilder(year=" + this.year + ", summaryList=" + this.summaryList + ")";
      }
   }
}
