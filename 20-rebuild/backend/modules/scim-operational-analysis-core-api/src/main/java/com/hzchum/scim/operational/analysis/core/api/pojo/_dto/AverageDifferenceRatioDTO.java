package com.hzchum.scim.operational.analysis.core.api.pojo._dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "AverageDifferenceRatioDTO", description = "近十年平均差异率")
public class AverageDifferenceRatioDTO {
   @ApiModelProperty(name = "year", value = "年份", notes = "年份")
   @JsonProperty("year")
   @JSONField(name = "year")
   private String year;
   @ApiModelProperty(name = "averageDifferenceRatio", value = "平均差异率", notes = "平均差异率")
   @JsonProperty("averageDifferenceRatio")
   @JSONField(name = "averageDifferenceRatio")
   private BigDecimal averageDifferenceRatio;

   public static AverageDifferenceRatioDTO.AverageDifferenceRatioDTOBuilder builder() {
      return new AverageDifferenceRatioDTO.AverageDifferenceRatioDTOBuilder();
   }

   public AverageDifferenceRatioDTO(final String year, final BigDecimal averageDifferenceRatio) {
      this.year = year;
      this.averageDifferenceRatio = averageDifferenceRatio;
   }

   public AverageDifferenceRatioDTO() {
   }

   public String getYear() {
      return this.year;
   }

   public BigDecimal getAverageDifferenceRatio() {
      return this.averageDifferenceRatio;
   }

   @JsonProperty("year")
   public AverageDifferenceRatioDTO setYear(final String year) {
      this.year = year;
      return this;
   }

   @JsonProperty("averageDifferenceRatio")
   public AverageDifferenceRatioDTO setAverageDifferenceRatio(final BigDecimal averageDifferenceRatio) {
      this.averageDifferenceRatio = averageDifferenceRatio;
      return this;
   }

   @Override
   public String toString() {
      return "AverageDifferenceRatioDTO(year=" + this.getYear() + ", averageDifferenceRatio=" + this.getAverageDifferenceRatio() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof AverageDifferenceRatioDTO)) {
         return false;
      } else {
         AverageDifferenceRatioDTO other = (AverageDifferenceRatioDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$year = this.getYear();
            Object other$year = other.getYear();
            if (this$year == null ? other$year == null : this$year.equals(other$year)) {
               Object this$averageDifferenceRatio = this.getAverageDifferenceRatio();
               Object other$averageDifferenceRatio = other.getAverageDifferenceRatio();
               return this$averageDifferenceRatio == null
                  ? other$averageDifferenceRatio == null
                  : this$averageDifferenceRatio.equals(other$averageDifferenceRatio);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AverageDifferenceRatioDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $year = this.getYear();
      result = result * 59 + ($year == null ? 43 : $year.hashCode());
      Object $averageDifferenceRatio = this.getAverageDifferenceRatio();
      return result * 59 + ($averageDifferenceRatio == null ? 43 : $averageDifferenceRatio.hashCode());
   }

   public static class AverageDifferenceRatioDTOBuilder {
      private String year;
      private BigDecimal averageDifferenceRatio;

      AverageDifferenceRatioDTOBuilder() {
      }

      @JsonProperty("year")
      public AverageDifferenceRatioDTO.AverageDifferenceRatioDTOBuilder year(final String year) {
         this.year = year;
         return this;
      }

      @JsonProperty("averageDifferenceRatio")
      public AverageDifferenceRatioDTO.AverageDifferenceRatioDTOBuilder averageDifferenceRatio(final BigDecimal averageDifferenceRatio) {
         this.averageDifferenceRatio = averageDifferenceRatio;
         return this;
      }

      public AverageDifferenceRatioDTO build() {
         return new AverageDifferenceRatioDTO(this.year, this.averageDifferenceRatio);
      }

      @Override
      public String toString() {
         return "AverageDifferenceRatioDTO.AverageDifferenceRatioDTOBuilder(year="
            + this.year
            + ", averageDifferenceRatio="
            + this.averageDifferenceRatio
            + ")";
      }
   }
}
