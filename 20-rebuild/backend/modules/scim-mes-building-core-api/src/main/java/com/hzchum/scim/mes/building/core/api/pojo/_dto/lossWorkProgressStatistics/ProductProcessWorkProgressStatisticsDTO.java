package com.hzchum.scim.mes.building.core.api.pojo._dto.lossWorkProgressStatistics;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

public class ProductProcessWorkProgressStatisticsDTO {
   @ApiModelProperty(name = "schedulingTotalQuantity", notes = "总排产数量")
   private Integer totalSchedulingQuantity;
   @ApiModelProperty(name = "schedulingTotalNetWeight", notes = "总排产量(净重吨)")
   private BigDecimal totalSchedulingNetWeight;
   @ApiModelProperty(name = "schedulingTotalGrossWeight", notes = "总排产量(毛重吨)")
   private BigDecimal totalSchedulingGrossWeight;
   @ApiModelProperty(name = "totalFeedingWeight", notes = "累计投料量")
   private BigDecimal totalFeedingWeight;
   @ApiModelProperty(name = "totalPickingWeight", notes = "累计领料量")
   private BigDecimal totalPickingWeight;
   @ApiModelProperty(name = "statisticsDetailDTOS", notes = "任务工序生产详情列表")
   private List<ProductProcessWorkProgressStatisticsDetailDTO> statisticsDetailDTOS;

   public static ProductProcessWorkProgressStatisticsDTO.ProductProcessWorkProgressStatisticsDTOBuilder builder() {
      return new ProductProcessWorkProgressStatisticsDTO.ProductProcessWorkProgressStatisticsDTOBuilder();
   }

   public Integer getTotalSchedulingQuantity() {
      return this.totalSchedulingQuantity;
   }

   public BigDecimal getTotalSchedulingNetWeight() {
      return this.totalSchedulingNetWeight;
   }

   public BigDecimal getTotalSchedulingGrossWeight() {
      return this.totalSchedulingGrossWeight;
   }

   public BigDecimal getTotalFeedingWeight() {
      return this.totalFeedingWeight;
   }

   public BigDecimal getTotalPickingWeight() {
      return this.totalPickingWeight;
   }

   public List<ProductProcessWorkProgressStatisticsDetailDTO> getStatisticsDetailDTOS() {
      return this.statisticsDetailDTOS;
   }

   public void setTotalSchedulingQuantity(final Integer totalSchedulingQuantity) {
      this.totalSchedulingQuantity = totalSchedulingQuantity;
   }

   public void setTotalSchedulingNetWeight(final BigDecimal totalSchedulingNetWeight) {
      this.totalSchedulingNetWeight = totalSchedulingNetWeight;
   }

   public void setTotalSchedulingGrossWeight(final BigDecimal totalSchedulingGrossWeight) {
      this.totalSchedulingGrossWeight = totalSchedulingGrossWeight;
   }

   public void setTotalFeedingWeight(final BigDecimal totalFeedingWeight) {
      this.totalFeedingWeight = totalFeedingWeight;
   }

   public void setTotalPickingWeight(final BigDecimal totalPickingWeight) {
      this.totalPickingWeight = totalPickingWeight;
   }

   public void setStatisticsDetailDTOS(final List<ProductProcessWorkProgressStatisticsDetailDTO> statisticsDetailDTOS) {
      this.statisticsDetailDTOS = statisticsDetailDTOS;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductProcessWorkProgressStatisticsDTO)) {
         return false;
      }

      ProductProcessWorkProgressStatisticsDTO other = (ProductProcessWorkProgressStatisticsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$totalSchedulingQuantity = this.getTotalSchedulingQuantity();
      Object other$totalSchedulingQuantity = other.getTotalSchedulingQuantity();
      if (this$totalSchedulingQuantity == null ? other$totalSchedulingQuantity == null : this$totalSchedulingQuantity.equals(other$totalSchedulingQuantity)) {
         Object this$totalSchedulingNetWeight = this.getTotalSchedulingNetWeight();
         Object other$totalSchedulingNetWeight = other.getTotalSchedulingNetWeight();
         if (this$totalSchedulingNetWeight == null
            ? other$totalSchedulingNetWeight == null
            : this$totalSchedulingNetWeight.equals(other$totalSchedulingNetWeight)) {
            Object this$totalSchedulingGrossWeight = this.getTotalSchedulingGrossWeight();
            Object other$totalSchedulingGrossWeight = other.getTotalSchedulingGrossWeight();
            if (this$totalSchedulingGrossWeight == null
               ? other$totalSchedulingGrossWeight == null
               : this$totalSchedulingGrossWeight.equals(other$totalSchedulingGrossWeight)) {
               Object this$totalFeedingWeight = this.getTotalFeedingWeight();
               Object other$totalFeedingWeight = other.getTotalFeedingWeight();
               if (this$totalFeedingWeight == null ? other$totalFeedingWeight == null : this$totalFeedingWeight.equals(other$totalFeedingWeight)) {
                  Object this$totalPickingWeight = this.getTotalPickingWeight();
                  Object other$totalPickingWeight = other.getTotalPickingWeight();
                  if (this$totalPickingWeight == null ? other$totalPickingWeight == null : this$totalPickingWeight.equals(other$totalPickingWeight)) {
                     Object this$statisticsDetailDTOS = this.getStatisticsDetailDTOS();
                     Object other$statisticsDetailDTOS = other.getStatisticsDetailDTOS();
                     return this$statisticsDetailDTOS == null
                        ? other$statisticsDetailDTOS == null
                        : this$statisticsDetailDTOS.equals(other$statisticsDetailDTOS);
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
      return other instanceof ProductProcessWorkProgressStatisticsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $totalSchedulingQuantity = this.getTotalSchedulingQuantity();
      result = result * 59 + ($totalSchedulingQuantity == null ? 43 : $totalSchedulingQuantity.hashCode());
      Object $totalSchedulingNetWeight = this.getTotalSchedulingNetWeight();
      result = result * 59 + ($totalSchedulingNetWeight == null ? 43 : $totalSchedulingNetWeight.hashCode());
      Object $totalSchedulingGrossWeight = this.getTotalSchedulingGrossWeight();
      result = result * 59 + ($totalSchedulingGrossWeight == null ? 43 : $totalSchedulingGrossWeight.hashCode());
      Object $totalFeedingWeight = this.getTotalFeedingWeight();
      result = result * 59 + ($totalFeedingWeight == null ? 43 : $totalFeedingWeight.hashCode());
      Object $totalPickingWeight = this.getTotalPickingWeight();
      result = result * 59 + ($totalPickingWeight == null ? 43 : $totalPickingWeight.hashCode());
      Object $statisticsDetailDTOS = this.getStatisticsDetailDTOS();
      return result * 59 + ($statisticsDetailDTOS == null ? 43 : $statisticsDetailDTOS.hashCode());
   }

   @Override
   public String toString() {
      return "ProductProcessWorkProgressStatisticsDTO(totalSchedulingQuantity="
         + this.getTotalSchedulingQuantity()
         + ", totalSchedulingNetWeight="
         + this.getTotalSchedulingNetWeight()
         + ", totalSchedulingGrossWeight="
         + this.getTotalSchedulingGrossWeight()
         + ", totalFeedingWeight="
         + this.getTotalFeedingWeight()
         + ", totalPickingWeight="
         + this.getTotalPickingWeight()
         + ", statisticsDetailDTOS="
         + this.getStatisticsDetailDTOS()
         + ")";
   }

   public ProductProcessWorkProgressStatisticsDTO(
      final Integer totalSchedulingQuantity,
      final BigDecimal totalSchedulingNetWeight,
      final BigDecimal totalSchedulingGrossWeight,
      final BigDecimal totalFeedingWeight,
      final BigDecimal totalPickingWeight,
      final List<ProductProcessWorkProgressStatisticsDetailDTO> statisticsDetailDTOS
   ) {
      this.totalSchedulingQuantity = totalSchedulingQuantity;
      this.totalSchedulingNetWeight = totalSchedulingNetWeight;
      this.totalSchedulingGrossWeight = totalSchedulingGrossWeight;
      this.totalFeedingWeight = totalFeedingWeight;
      this.totalPickingWeight = totalPickingWeight;
      this.statisticsDetailDTOS = statisticsDetailDTOS;
   }

   public ProductProcessWorkProgressStatisticsDTO() {
   }

   public static class ProductProcessWorkProgressStatisticsDTOBuilder {
      private Integer totalSchedulingQuantity;
      private BigDecimal totalSchedulingNetWeight;
      private BigDecimal totalSchedulingGrossWeight;
      private BigDecimal totalFeedingWeight;
      private BigDecimal totalPickingWeight;
      private List<ProductProcessWorkProgressStatisticsDetailDTO> statisticsDetailDTOS;

      ProductProcessWorkProgressStatisticsDTOBuilder() {
      }

      public ProductProcessWorkProgressStatisticsDTO.ProductProcessWorkProgressStatisticsDTOBuilder totalSchedulingQuantity(
         final Integer totalSchedulingQuantity
      ) {
         this.totalSchedulingQuantity = totalSchedulingQuantity;
         return this;
      }

      public ProductProcessWorkProgressStatisticsDTO.ProductProcessWorkProgressStatisticsDTOBuilder totalSchedulingNetWeight(
         final BigDecimal totalSchedulingNetWeight
      ) {
         this.totalSchedulingNetWeight = totalSchedulingNetWeight;
         return this;
      }

      public ProductProcessWorkProgressStatisticsDTO.ProductProcessWorkProgressStatisticsDTOBuilder totalSchedulingGrossWeight(
         final BigDecimal totalSchedulingGrossWeight
      ) {
         this.totalSchedulingGrossWeight = totalSchedulingGrossWeight;
         return this;
      }

      public ProductProcessWorkProgressStatisticsDTO.ProductProcessWorkProgressStatisticsDTOBuilder totalFeedingWeight(final BigDecimal totalFeedingWeight) {
         this.totalFeedingWeight = totalFeedingWeight;
         return this;
      }

      public ProductProcessWorkProgressStatisticsDTO.ProductProcessWorkProgressStatisticsDTOBuilder totalPickingWeight(final BigDecimal totalPickingWeight) {
         this.totalPickingWeight = totalPickingWeight;
         return this;
      }

      public ProductProcessWorkProgressStatisticsDTO.ProductProcessWorkProgressStatisticsDTOBuilder statisticsDetailDTOS(
         final List<ProductProcessWorkProgressStatisticsDetailDTO> statisticsDetailDTOS
      ) {
         this.statisticsDetailDTOS = statisticsDetailDTOS;
         return this;
      }

      public ProductProcessWorkProgressStatisticsDTO build() {
         return new ProductProcessWorkProgressStatisticsDTO(
            this.totalSchedulingQuantity,
            this.totalSchedulingNetWeight,
            this.totalSchedulingGrossWeight,
            this.totalFeedingWeight,
            this.totalPickingWeight,
            this.statisticsDetailDTOS
         );
      }

      @Override
      public String toString() {
         return "ProductProcessWorkProgressStatisticsDTO.ProductProcessWorkProgressStatisticsDTOBuilder(totalSchedulingQuantity="
            + this.totalSchedulingQuantity
            + ", totalSchedulingNetWeight="
            + this.totalSchedulingNetWeight
            + ", totalSchedulingGrossWeight="
            + this.totalSchedulingGrossWeight
            + ", totalFeedingWeight="
            + this.totalFeedingWeight
            + ", totalPickingWeight="
            + this.totalPickingWeight
            + ", statisticsDetailDTOS="
            + this.statisticsDetailDTOS
            + ")";
      }
   }
}
