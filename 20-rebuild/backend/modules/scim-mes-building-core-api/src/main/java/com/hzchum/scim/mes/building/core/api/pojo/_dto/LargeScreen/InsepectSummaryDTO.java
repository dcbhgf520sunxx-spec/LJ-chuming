package com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "质检汇总")
public class InsepectSummaryDTO {
   @ApiModelProperty(name = "inspectCountYear", notes = "全年质检总数", value = "全年质检总数")
   @JsonProperty("inspectCountYear")
   @JSONField(name = "inspectCountYear")
   private BigDecimal inspectCountYear;
   @ApiModelProperty(name = "qualifiedCount", notes = "合格数", value = "合格数")
   @JsonProperty("qualifiedCount")
   @JSONField(name = "qualifiedCount")
   private BigDecimal qualifiedCount;
   @ApiModelProperty(name = "firstInspectionRate", notes = "一次质检合格率", value = "一次质检合格率")
   @JsonProperty("firstInspectionRate")
   @JSONField(name = "firstInspectionRate")
   private BigDecimal firstInspectionRate;
   @ApiModelProperty(name = "qualityQhseCountYear", notes = "全年质量问题总数", value = "全年质量问题总数")
   @JsonProperty("qualityQhseCountYear")
   @JSONField(name = "qualityQhseCountYear")
   private BigDecimal qualityQhseCountYear;
   @ApiModelProperty(name = "rectificationCount", notes = "整改数", value = "整改数")
   @JsonProperty("rectificationCount")
   @JSONField(name = "rectificationCount")
   private BigDecimal rectificationCount;
   @ApiModelProperty(name = "rectificationPlaceCount", notes = "整改到位率", value = "整改到位率")
   @JsonProperty("rectificationPlaceCount")
   @JSONField(name = "rectificationPlaceCount")
   private BigDecimal rectificationPlaceCount;

   public static InsepectSummaryDTO.InsepectSummaryDTOBuilder builder() {
      return new InsepectSummaryDTO.InsepectSummaryDTOBuilder();
   }

   public BigDecimal getInspectCountYear() {
      return this.inspectCountYear;
   }

   public BigDecimal getQualifiedCount() {
      return this.qualifiedCount;
   }

   public BigDecimal getFirstInspectionRate() {
      return this.firstInspectionRate;
   }

   public BigDecimal getQualityQhseCountYear() {
      return this.qualityQhseCountYear;
   }

   public BigDecimal getRectificationCount() {
      return this.rectificationCount;
   }

   public BigDecimal getRectificationPlaceCount() {
      return this.rectificationPlaceCount;
   }

   @JsonProperty("inspectCountYear")
   public void setInspectCountYear(final BigDecimal inspectCountYear) {
      this.inspectCountYear = inspectCountYear;
   }

   @JsonProperty("qualifiedCount")
   public void setQualifiedCount(final BigDecimal qualifiedCount) {
      this.qualifiedCount = qualifiedCount;
   }

   @JsonProperty("firstInspectionRate")
   public void setFirstInspectionRate(final BigDecimal firstInspectionRate) {
      this.firstInspectionRate = firstInspectionRate;
   }

   @JsonProperty("qualityQhseCountYear")
   public void setQualityQhseCountYear(final BigDecimal qualityQhseCountYear) {
      this.qualityQhseCountYear = qualityQhseCountYear;
   }

   @JsonProperty("rectificationCount")
   public void setRectificationCount(final BigDecimal rectificationCount) {
      this.rectificationCount = rectificationCount;
   }

   @JsonProperty("rectificationPlaceCount")
   public void setRectificationPlaceCount(final BigDecimal rectificationPlaceCount) {
      this.rectificationPlaceCount = rectificationPlaceCount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InsepectSummaryDTO)) {
         return false;
      }

      InsepectSummaryDTO other = (InsepectSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$inspectCountYear = this.getInspectCountYear();
      Object other$inspectCountYear = other.getInspectCountYear();
      if (this$inspectCountYear == null ? other$inspectCountYear == null : this$inspectCountYear.equals(other$inspectCountYear)) {
         Object this$qualifiedCount = this.getQualifiedCount();
         Object other$qualifiedCount = other.getQualifiedCount();
         if (this$qualifiedCount == null ? other$qualifiedCount == null : this$qualifiedCount.equals(other$qualifiedCount)) {
            Object this$firstInspectionRate = this.getFirstInspectionRate();
            Object other$firstInspectionRate = other.getFirstInspectionRate();
            if (this$firstInspectionRate == null ? other$firstInspectionRate == null : this$firstInspectionRate.equals(other$firstInspectionRate)) {
               Object this$qualityQhseCountYear = this.getQualityQhseCountYear();
               Object other$qualityQhseCountYear = other.getQualityQhseCountYear();
               if (this$qualityQhseCountYear == null ? other$qualityQhseCountYear == null : this$qualityQhseCountYear.equals(other$qualityQhseCountYear)) {
                  Object this$rectificationCount = this.getRectificationCount();
                  Object other$rectificationCount = other.getRectificationCount();
                  if (this$rectificationCount == null ? other$rectificationCount == null : this$rectificationCount.equals(other$rectificationCount)) {
                     Object this$rectificationPlaceCount = this.getRectificationPlaceCount();
                     Object other$rectificationPlaceCount = other.getRectificationPlaceCount();
                     return this$rectificationPlaceCount == null
                        ? other$rectificationPlaceCount == null
                        : this$rectificationPlaceCount.equals(other$rectificationPlaceCount);
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof InsepectSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $inspectCountYear = this.getInspectCountYear();
      result = result * 59 + ($inspectCountYear == null ? 43 : $inspectCountYear.hashCode());
      Object $qualifiedCount = this.getQualifiedCount();
      result = result * 59 + ($qualifiedCount == null ? 43 : $qualifiedCount.hashCode());
      Object $firstInspectionRate = this.getFirstInspectionRate();
      result = result * 59 + ($firstInspectionRate == null ? 43 : $firstInspectionRate.hashCode());
      Object $qualityQhseCountYear = this.getQualityQhseCountYear();
      result = result * 59 + ($qualityQhseCountYear == null ? 43 : $qualityQhseCountYear.hashCode());
      Object $rectificationCount = this.getRectificationCount();
      result = result * 59 + ($rectificationCount == null ? 43 : $rectificationCount.hashCode());
      Object $rectificationPlaceCount = this.getRectificationPlaceCount();
      return result * 59 + ($rectificationPlaceCount == null ? 43 : $rectificationPlaceCount.hashCode());
   }

   @Override
   public String toString() {
      return "InsepectSummaryDTO(super="
         + super.toString()
         + ", inspectCountYear="
         + this.getInspectCountYear()
         + ", qualifiedCount="
         + this.getQualifiedCount()
         + ", firstInspectionRate="
         + this.getFirstInspectionRate()
         + ", qualityQhseCountYear="
         + this.getQualityQhseCountYear()
         + ", rectificationCount="
         + this.getRectificationCount()
         + ", rectificationPlaceCount="
         + this.getRectificationPlaceCount()
         + ")";
   }

   public InsepectSummaryDTO(
      final BigDecimal inspectCountYear,
      final BigDecimal qualifiedCount,
      final BigDecimal firstInspectionRate,
      final BigDecimal qualityQhseCountYear,
      final BigDecimal rectificationCount,
      final BigDecimal rectificationPlaceCount
   ) {
      this.inspectCountYear = inspectCountYear;
      this.qualifiedCount = qualifiedCount;
      this.firstInspectionRate = firstInspectionRate;
      this.qualityQhseCountYear = qualityQhseCountYear;
      this.rectificationCount = rectificationCount;
      this.rectificationPlaceCount = rectificationPlaceCount;
   }

   public InsepectSummaryDTO() {
   }

   public static class InsepectSummaryDTOBuilder {
      private BigDecimal inspectCountYear;
      private BigDecimal qualifiedCount;
      private BigDecimal firstInspectionRate;
      private BigDecimal qualityQhseCountYear;
      private BigDecimal rectificationCount;
      private BigDecimal rectificationPlaceCount;

      InsepectSummaryDTOBuilder() {
      }

      @JsonProperty("inspectCountYear")
      public InsepectSummaryDTO.InsepectSummaryDTOBuilder inspectCountYear(final BigDecimal inspectCountYear) {
         this.inspectCountYear = inspectCountYear;
         return this;
      }

      @JsonProperty("qualifiedCount")
      public InsepectSummaryDTO.InsepectSummaryDTOBuilder qualifiedCount(final BigDecimal qualifiedCount) {
         this.qualifiedCount = qualifiedCount;
         return this;
      }

      @JsonProperty("firstInspectionRate")
      public InsepectSummaryDTO.InsepectSummaryDTOBuilder firstInspectionRate(final BigDecimal firstInspectionRate) {
         this.firstInspectionRate = firstInspectionRate;
         return this;
      }

      @JsonProperty("qualityQhseCountYear")
      public InsepectSummaryDTO.InsepectSummaryDTOBuilder qualityQhseCountYear(final BigDecimal qualityQhseCountYear) {
         this.qualityQhseCountYear = qualityQhseCountYear;
         return this;
      }

      @JsonProperty("rectificationCount")
      public InsepectSummaryDTO.InsepectSummaryDTOBuilder rectificationCount(final BigDecimal rectificationCount) {
         this.rectificationCount = rectificationCount;
         return this;
      }

      @JsonProperty("rectificationPlaceCount")
      public InsepectSummaryDTO.InsepectSummaryDTOBuilder rectificationPlaceCount(final BigDecimal rectificationPlaceCount) {
         this.rectificationPlaceCount = rectificationPlaceCount;
         return this;
      }

      public InsepectSummaryDTO build() {
         return new InsepectSummaryDTO(
            this.inspectCountYear,
            this.qualifiedCount,
            this.firstInspectionRate,
            this.qualityQhseCountYear,
            this.rectificationCount,
            this.rectificationPlaceCount
         );
      }

      @Override
      public String toString() {
         return "InsepectSummaryDTO.InsepectSummaryDTOBuilder(inspectCountYear="
            + this.inspectCountYear
            + ", qualifiedCount="
            + this.qualifiedCount
            + ", firstInspectionRate="
            + this.firstInspectionRate
            + ", qualityQhseCountYear="
            + this.qualityQhseCountYear
            + ", rectificationCount="
            + this.rectificationCount
            + ", rectificationPlaceCount="
            + this.rectificationPlaceCount
            + ")";
      }
   }
}
