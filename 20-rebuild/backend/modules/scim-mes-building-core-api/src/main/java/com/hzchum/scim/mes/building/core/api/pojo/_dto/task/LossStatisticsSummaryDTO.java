package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "LossStatisticsSummaryDTO", description = "损耗统计汇总")
public class LossStatisticsSummaryDTO {
   @ApiModelProperty(name = "totalFeedingWeight", notes = "总投料量")
   private BigDecimal totalFeedingWeight;
   @ApiModelProperty(name = "totalPickingWeight", notes = "总领料量")
   private BigDecimal totalPickingWeight;
   @ApiModelProperty(name = "totalReportWeight", notes = "总报工量")
   private BigDecimal totalReportWeight;
   @ApiModelProperty(name = "avgLossRate", notes = "平均损耗率")
   private BigDecimal avgLossRate;

   public static LossStatisticsSummaryDTO.LossStatisticsSummaryDTOBuilder builder() {
      return new LossStatisticsSummaryDTO.LossStatisticsSummaryDTOBuilder();
   }

   public LossStatisticsSummaryDTO() {
   }

   public LossStatisticsSummaryDTO(
      final BigDecimal totalFeedingWeight, final BigDecimal totalPickingWeight, final BigDecimal totalReportWeight, final BigDecimal avgLossRate
   ) {
      this.totalFeedingWeight = totalFeedingWeight;
      this.totalPickingWeight = totalPickingWeight;
      this.totalReportWeight = totalReportWeight;
      this.avgLossRate = avgLossRate;
   }

   public BigDecimal getTotalFeedingWeight() {
      return this.totalFeedingWeight;
   }

   public BigDecimal getTotalPickingWeight() {
      return this.totalPickingWeight;
   }

   public BigDecimal getTotalReportWeight() {
      return this.totalReportWeight;
   }

   public BigDecimal getAvgLossRate() {
      return this.avgLossRate;
   }

   public LossStatisticsSummaryDTO setTotalFeedingWeight(final BigDecimal totalFeedingWeight) {
      this.totalFeedingWeight = totalFeedingWeight;
      return this;
   }

   public LossStatisticsSummaryDTO setTotalPickingWeight(final BigDecimal totalPickingWeight) {
      this.totalPickingWeight = totalPickingWeight;
      return this;
   }

   public LossStatisticsSummaryDTO setTotalReportWeight(final BigDecimal totalReportWeight) {
      this.totalReportWeight = totalReportWeight;
      return this;
   }

   public LossStatisticsSummaryDTO setAvgLossRate(final BigDecimal avgLossRate) {
      this.avgLossRate = avgLossRate;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof LossStatisticsSummaryDTO)) {
         return false;
      }

      LossStatisticsSummaryDTO other = (LossStatisticsSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$totalFeedingWeight = this.getTotalFeedingWeight();
      Object other$totalFeedingWeight = other.getTotalFeedingWeight();
      if (this$totalFeedingWeight == null ? other$totalFeedingWeight == null : this$totalFeedingWeight.equals(other$totalFeedingWeight)) {
         Object this$totalPickingWeight = this.getTotalPickingWeight();
         Object other$totalPickingWeight = other.getTotalPickingWeight();
         if (this$totalPickingWeight == null ? other$totalPickingWeight == null : this$totalPickingWeight.equals(other$totalPickingWeight)) {
            Object this$totalReportWeight = this.getTotalReportWeight();
            Object other$totalReportWeight = other.getTotalReportWeight();
            if (this$totalReportWeight == null ? other$totalReportWeight == null : this$totalReportWeight.equals(other$totalReportWeight)) {
               Object this$avgLossRate = this.getAvgLossRate();
               Object other$avgLossRate = other.getAvgLossRate();
               return this$avgLossRate == null ? other$avgLossRate == null : this$avgLossRate.equals(other$avgLossRate);
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
      return other instanceof LossStatisticsSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $totalFeedingWeight = this.getTotalFeedingWeight();
      result = result * 59 + ($totalFeedingWeight == null ? 43 : $totalFeedingWeight.hashCode());
      Object $totalPickingWeight = this.getTotalPickingWeight();
      result = result * 59 + ($totalPickingWeight == null ? 43 : $totalPickingWeight.hashCode());
      Object $totalReportWeight = this.getTotalReportWeight();
      result = result * 59 + ($totalReportWeight == null ? 43 : $totalReportWeight.hashCode());
      Object $avgLossRate = this.getAvgLossRate();
      return result * 59 + ($avgLossRate == null ? 43 : $avgLossRate.hashCode());
   }

   @Override
   public String toString() {
      return "LossStatisticsSummaryDTO(totalFeedingWeight="
         + this.getTotalFeedingWeight()
         + ", totalPickingWeight="
         + this.getTotalPickingWeight()
         + ", totalReportWeight="
         + this.getTotalReportWeight()
         + ", avgLossRate="
         + this.getAvgLossRate()
         + ")";
   }

   public static class LossStatisticsSummaryDTOBuilder {
      private BigDecimal totalFeedingWeight;
      private BigDecimal totalPickingWeight;
      private BigDecimal totalReportWeight;
      private BigDecimal avgLossRate;

      LossStatisticsSummaryDTOBuilder() {
      }

      public LossStatisticsSummaryDTO.LossStatisticsSummaryDTOBuilder totalFeedingWeight(final BigDecimal totalFeedingWeight) {
         this.totalFeedingWeight = totalFeedingWeight;
         return this;
      }

      public LossStatisticsSummaryDTO.LossStatisticsSummaryDTOBuilder totalPickingWeight(final BigDecimal totalPickingWeight) {
         this.totalPickingWeight = totalPickingWeight;
         return this;
      }

      public LossStatisticsSummaryDTO.LossStatisticsSummaryDTOBuilder totalReportWeight(final BigDecimal totalReportWeight) {
         this.totalReportWeight = totalReportWeight;
         return this;
      }

      public LossStatisticsSummaryDTO.LossStatisticsSummaryDTOBuilder avgLossRate(final BigDecimal avgLossRate) {
         this.avgLossRate = avgLossRate;
         return this;
      }

      public LossStatisticsSummaryDTO build() {
         return new LossStatisticsSummaryDTO(this.totalFeedingWeight, this.totalPickingWeight, this.totalReportWeight, this.avgLossRate);
      }

      @Override
      public String toString() {
         return "LossStatisticsSummaryDTO.LossStatisticsSummaryDTOBuilder(totalFeedingWeight="
            + this.totalFeedingWeight
            + ", totalPickingWeight="
            + this.totalPickingWeight
            + ", totalReportWeight="
            + this.totalReportWeight
            + ", avgLossRate="
            + this.avgLossRate
            + ")";
      }
   }
}
