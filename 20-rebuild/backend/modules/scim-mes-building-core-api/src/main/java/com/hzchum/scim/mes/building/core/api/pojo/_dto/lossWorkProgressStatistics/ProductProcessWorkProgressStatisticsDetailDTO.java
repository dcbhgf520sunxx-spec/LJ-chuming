package com.hzchum.scim.mes.building.core.api.pojo._dto.lossWorkProgressStatistics;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class ProductProcessWorkProgressStatisticsDetailDTO {
   @ApiModelProperty(name = "processId", notes = "工序Id")
   private Long processId;
   @ApiModelProperty(name = "taskQuantity", notes = "任务数量")
   private Integer totalTaskQuantity;
   @ApiModelProperty(name = "totalTaskNetWeight", notes = "任务总净重(吨)")
   private BigDecimal totalTaskNetWeight;
   @ApiModelProperty(name = "totalTaskGrossWeight", notes = "任务总毛重(吨)")
   private BigDecimal totalTaskGrossWeight;
   @ApiModelProperty(name = "totalInProductionQuantity", notes = "在制品数量")
   private Integer totalInProductionQuantity;
   @ApiModelProperty(name = "totalInProductionNetWeight", notes = "在制品总净重(吨)")
   private BigDecimal totalInProductionNetWeight;
   @ApiModelProperty(name = "totalInProductionGrossWeight", notes = "在制品总毛重(吨)")
   private BigDecimal totalInProductionGrossWeight;
   @ApiModelProperty(name = "totalCompleteQuantity", notes = "完成总数量")
   private Integer totalCompleteQuantity;
   @ApiModelProperty(name = "totalTaskNetWeight", notes = "完成总净重(吨)")
   private BigDecimal totalCompleteNetWeight;
   @ApiModelProperty(name = "totalTaskGrossWeight", notes = "完成总毛重(吨)")
   private BigDecimal totalCompleteGrossWeight;
   @ApiModelProperty(name = "totalLossWeight", notes = "累计损耗")
   private BigDecimal totalLossWeight;
   @ApiModelProperty(name = "totalLossRate", notes = "累计损耗率")
   private String totalLossRate;

   public static ProductProcessWorkProgressStatisticsDetailDTO.ProductProcessWorkProgressStatisticsDetailDTOBuilder builder() {
      return new ProductProcessWorkProgressStatisticsDetailDTO.ProductProcessWorkProgressStatisticsDetailDTOBuilder();
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Integer getTotalTaskQuantity() {
      return this.totalTaskQuantity;
   }

   public BigDecimal getTotalTaskNetWeight() {
      return this.totalTaskNetWeight;
   }

   public BigDecimal getTotalTaskGrossWeight() {
      return this.totalTaskGrossWeight;
   }

   public Integer getTotalInProductionQuantity() {
      return this.totalInProductionQuantity;
   }

   public BigDecimal getTotalInProductionNetWeight() {
      return this.totalInProductionNetWeight;
   }

   public BigDecimal getTotalInProductionGrossWeight() {
      return this.totalInProductionGrossWeight;
   }

   public Integer getTotalCompleteQuantity() {
      return this.totalCompleteQuantity;
   }

   public BigDecimal getTotalCompleteNetWeight() {
      return this.totalCompleteNetWeight;
   }

   public BigDecimal getTotalCompleteGrossWeight() {
      return this.totalCompleteGrossWeight;
   }

   public BigDecimal getTotalLossWeight() {
      return this.totalLossWeight;
   }

   public String getTotalLossRate() {
      return this.totalLossRate;
   }

   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   public void setTotalTaskQuantity(final Integer totalTaskQuantity) {
      this.totalTaskQuantity = totalTaskQuantity;
   }

   public void setTotalTaskNetWeight(final BigDecimal totalTaskNetWeight) {
      this.totalTaskNetWeight = totalTaskNetWeight;
   }

   public void setTotalTaskGrossWeight(final BigDecimal totalTaskGrossWeight) {
      this.totalTaskGrossWeight = totalTaskGrossWeight;
   }

   public void setTotalInProductionQuantity(final Integer totalInProductionQuantity) {
      this.totalInProductionQuantity = totalInProductionQuantity;
   }

   public void setTotalInProductionNetWeight(final BigDecimal totalInProductionNetWeight) {
      this.totalInProductionNetWeight = totalInProductionNetWeight;
   }

   public void setTotalInProductionGrossWeight(final BigDecimal totalInProductionGrossWeight) {
      this.totalInProductionGrossWeight = totalInProductionGrossWeight;
   }

   public void setTotalCompleteQuantity(final Integer totalCompleteQuantity) {
      this.totalCompleteQuantity = totalCompleteQuantity;
   }

   public void setTotalCompleteNetWeight(final BigDecimal totalCompleteNetWeight) {
      this.totalCompleteNetWeight = totalCompleteNetWeight;
   }

   public void setTotalCompleteGrossWeight(final BigDecimal totalCompleteGrossWeight) {
      this.totalCompleteGrossWeight = totalCompleteGrossWeight;
   }

   public void setTotalLossWeight(final BigDecimal totalLossWeight) {
      this.totalLossWeight = totalLossWeight;
   }

   public void setTotalLossRate(final String totalLossRate) {
      this.totalLossRate = totalLossRate;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductProcessWorkProgressStatisticsDetailDTO)) {
         return false;
      }

      ProductProcessWorkProgressStatisticsDetailDTO other = (ProductProcessWorkProgressStatisticsDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$processId = this.getProcessId();
      Object other$processId = other.getProcessId();
      if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
         Object this$totalTaskQuantity = this.getTotalTaskQuantity();
         Object other$totalTaskQuantity = other.getTotalTaskQuantity();
         if (this$totalTaskQuantity == null ? other$totalTaskQuantity == null : this$totalTaskQuantity.equals(other$totalTaskQuantity)) {
            Object this$totalInProductionQuantity = this.getTotalInProductionQuantity();
            Object other$totalInProductionQuantity = other.getTotalInProductionQuantity();
            if (this$totalInProductionQuantity == null
               ? other$totalInProductionQuantity == null
               : this$totalInProductionQuantity.equals(other$totalInProductionQuantity)) {
               Object this$totalCompleteQuantity = this.getTotalCompleteQuantity();
               Object other$totalCompleteQuantity = other.getTotalCompleteQuantity();
               if (this$totalCompleteQuantity == null ? other$totalCompleteQuantity == null : this$totalCompleteQuantity.equals(other$totalCompleteQuantity)) {
                  Object this$totalTaskNetWeight = this.getTotalTaskNetWeight();
                  Object other$totalTaskNetWeight = other.getTotalTaskNetWeight();
                  if (this$totalTaskNetWeight == null ? other$totalTaskNetWeight == null : this$totalTaskNetWeight.equals(other$totalTaskNetWeight)) {
                     Object this$totalTaskGrossWeight = this.getTotalTaskGrossWeight();
                     Object other$totalTaskGrossWeight = other.getTotalTaskGrossWeight();
                     if (this$totalTaskGrossWeight == null ? other$totalTaskGrossWeight == null : this$totalTaskGrossWeight.equals(other$totalTaskGrossWeight)) {
                        Object this$totalInProductionNetWeight = this.getTotalInProductionNetWeight();
                        Object other$totalInProductionNetWeight = other.getTotalInProductionNetWeight();
                        if (this$totalInProductionNetWeight == null
                           ? other$totalInProductionNetWeight == null
                           : this$totalInProductionNetWeight.equals(other$totalInProductionNetWeight)) {
                           Object this$totalInProductionGrossWeight = this.getTotalInProductionGrossWeight();
                           Object other$totalInProductionGrossWeight = other.getTotalInProductionGrossWeight();
                           if (this$totalInProductionGrossWeight == null
                              ? other$totalInProductionGrossWeight == null
                              : this$totalInProductionGrossWeight.equals(other$totalInProductionGrossWeight)) {
                              Object this$totalCompleteNetWeight = this.getTotalCompleteNetWeight();
                              Object other$totalCompleteNetWeight = other.getTotalCompleteNetWeight();
                              if (this$totalCompleteNetWeight == null
                                 ? other$totalCompleteNetWeight == null
                                 : this$totalCompleteNetWeight.equals(other$totalCompleteNetWeight)) {
                                 Object this$totalCompleteGrossWeight = this.getTotalCompleteGrossWeight();
                                 Object other$totalCompleteGrossWeight = other.getTotalCompleteGrossWeight();
                                 if (this$totalCompleteGrossWeight == null
                                    ? other$totalCompleteGrossWeight == null
                                    : this$totalCompleteGrossWeight.equals(other$totalCompleteGrossWeight)) {
                                    Object this$totalLossWeight = this.getTotalLossWeight();
                                    Object other$totalLossWeight = other.getTotalLossWeight();
                                    if (this$totalLossWeight == null ? other$totalLossWeight == null : this$totalLossWeight.equals(other$totalLossWeight)) {
                                       Object this$totalLossRate = this.getTotalLossRate();
                                       Object other$totalLossRate = other.getTotalLossRate();
                                       return this$totalLossRate == null ? other$totalLossRate == null : this$totalLossRate.equals(other$totalLossRate);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProductProcessWorkProgressStatisticsDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $totalTaskQuantity = this.getTotalTaskQuantity();
      result = result * 59 + ($totalTaskQuantity == null ? 43 : $totalTaskQuantity.hashCode());
      Object $totalInProductionQuantity = this.getTotalInProductionQuantity();
      result = result * 59 + ($totalInProductionQuantity == null ? 43 : $totalInProductionQuantity.hashCode());
      Object $totalCompleteQuantity = this.getTotalCompleteQuantity();
      result = result * 59 + ($totalCompleteQuantity == null ? 43 : $totalCompleteQuantity.hashCode());
      Object $totalTaskNetWeight = this.getTotalTaskNetWeight();
      result = result * 59 + ($totalTaskNetWeight == null ? 43 : $totalTaskNetWeight.hashCode());
      Object $totalTaskGrossWeight = this.getTotalTaskGrossWeight();
      result = result * 59 + ($totalTaskGrossWeight == null ? 43 : $totalTaskGrossWeight.hashCode());
      Object $totalInProductionNetWeight = this.getTotalInProductionNetWeight();
      result = result * 59 + ($totalInProductionNetWeight == null ? 43 : $totalInProductionNetWeight.hashCode());
      Object $totalInProductionGrossWeight = this.getTotalInProductionGrossWeight();
      result = result * 59 + ($totalInProductionGrossWeight == null ? 43 : $totalInProductionGrossWeight.hashCode());
      Object $totalCompleteNetWeight = this.getTotalCompleteNetWeight();
      result = result * 59 + ($totalCompleteNetWeight == null ? 43 : $totalCompleteNetWeight.hashCode());
      Object $totalCompleteGrossWeight = this.getTotalCompleteGrossWeight();
      result = result * 59 + ($totalCompleteGrossWeight == null ? 43 : $totalCompleteGrossWeight.hashCode());
      Object $totalLossWeight = this.getTotalLossWeight();
      result = result * 59 + ($totalLossWeight == null ? 43 : $totalLossWeight.hashCode());
      Object $totalLossRate = this.getTotalLossRate();
      return result * 59 + ($totalLossRate == null ? 43 : $totalLossRate.hashCode());
   }

   @Override
   public String toString() {
      return "ProductProcessWorkProgressStatisticsDetailDTO(processId="
         + this.getProcessId()
         + ", totalTaskQuantity="
         + this.getTotalTaskQuantity()
         + ", totalTaskNetWeight="
         + this.getTotalTaskNetWeight()
         + ", totalTaskGrossWeight="
         + this.getTotalTaskGrossWeight()
         + ", totalInProductionQuantity="
         + this.getTotalInProductionQuantity()
         + ", totalInProductionNetWeight="
         + this.getTotalInProductionNetWeight()
         + ", totalInProductionGrossWeight="
         + this.getTotalInProductionGrossWeight()
         + ", totalCompleteQuantity="
         + this.getTotalCompleteQuantity()
         + ", totalCompleteNetWeight="
         + this.getTotalCompleteNetWeight()
         + ", totalCompleteGrossWeight="
         + this.getTotalCompleteGrossWeight()
         + ", totalLossWeight="
         + this.getTotalLossWeight()
         + ", totalLossRate="
         + this.getTotalLossRate()
         + ")";
   }

   public ProductProcessWorkProgressStatisticsDetailDTO(
      final Long processId,
      final Integer totalTaskQuantity,
      final BigDecimal totalTaskNetWeight,
      final BigDecimal totalTaskGrossWeight,
      final Integer totalInProductionQuantity,
      final BigDecimal totalInProductionNetWeight,
      final BigDecimal totalInProductionGrossWeight,
      final Integer totalCompleteQuantity,
      final BigDecimal totalCompleteNetWeight,
      final BigDecimal totalCompleteGrossWeight,
      final BigDecimal totalLossWeight,
      final String totalLossRate
   ) {
      this.processId = processId;
      this.totalTaskQuantity = totalTaskQuantity;
      this.totalTaskNetWeight = totalTaskNetWeight;
      this.totalTaskGrossWeight = totalTaskGrossWeight;
      this.totalInProductionQuantity = totalInProductionQuantity;
      this.totalInProductionNetWeight = totalInProductionNetWeight;
      this.totalInProductionGrossWeight = totalInProductionGrossWeight;
      this.totalCompleteQuantity = totalCompleteQuantity;
      this.totalCompleteNetWeight = totalCompleteNetWeight;
      this.totalCompleteGrossWeight = totalCompleteGrossWeight;
      this.totalLossWeight = totalLossWeight;
      this.totalLossRate = totalLossRate;
   }

   public ProductProcessWorkProgressStatisticsDetailDTO() {
   }

   public static class ProductProcessWorkProgressStatisticsDetailDTOBuilder {
      private Long processId;
      private Integer totalTaskQuantity;
      private BigDecimal totalTaskNetWeight;
      private BigDecimal totalTaskGrossWeight;
      private Integer totalInProductionQuantity;
      private BigDecimal totalInProductionNetWeight;
      private BigDecimal totalInProductionGrossWeight;
      private Integer totalCompleteQuantity;
      private BigDecimal totalCompleteNetWeight;
      private BigDecimal totalCompleteGrossWeight;
      private BigDecimal totalLossWeight;
      private String totalLossRate;

      ProductProcessWorkProgressStatisticsDetailDTOBuilder() {
      }

      public ProductProcessWorkProgressStatisticsDetailDTO.ProductProcessWorkProgressStatisticsDetailDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public ProductProcessWorkProgressStatisticsDetailDTO.ProductProcessWorkProgressStatisticsDetailDTOBuilder totalTaskQuantity(
         final Integer totalTaskQuantity
      ) {
         this.totalTaskQuantity = totalTaskQuantity;
         return this;
      }

      public ProductProcessWorkProgressStatisticsDetailDTO.ProductProcessWorkProgressStatisticsDetailDTOBuilder totalTaskNetWeight(
         final BigDecimal totalTaskNetWeight
      ) {
         this.totalTaskNetWeight = totalTaskNetWeight;
         return this;
      }

      public ProductProcessWorkProgressStatisticsDetailDTO.ProductProcessWorkProgressStatisticsDetailDTOBuilder totalTaskGrossWeight(
         final BigDecimal totalTaskGrossWeight
      ) {
         this.totalTaskGrossWeight = totalTaskGrossWeight;
         return this;
      }

      public ProductProcessWorkProgressStatisticsDetailDTO.ProductProcessWorkProgressStatisticsDetailDTOBuilder totalInProductionQuantity(
         final Integer totalInProductionQuantity
      ) {
         this.totalInProductionQuantity = totalInProductionQuantity;
         return this;
      }

      public ProductProcessWorkProgressStatisticsDetailDTO.ProductProcessWorkProgressStatisticsDetailDTOBuilder totalInProductionNetWeight(
         final BigDecimal totalInProductionNetWeight
      ) {
         this.totalInProductionNetWeight = totalInProductionNetWeight;
         return this;
      }

      public ProductProcessWorkProgressStatisticsDetailDTO.ProductProcessWorkProgressStatisticsDetailDTOBuilder totalInProductionGrossWeight(
         final BigDecimal totalInProductionGrossWeight
      ) {
         this.totalInProductionGrossWeight = totalInProductionGrossWeight;
         return this;
      }

      public ProductProcessWorkProgressStatisticsDetailDTO.ProductProcessWorkProgressStatisticsDetailDTOBuilder totalCompleteQuantity(
         final Integer totalCompleteQuantity
      ) {
         this.totalCompleteQuantity = totalCompleteQuantity;
         return this;
      }

      public ProductProcessWorkProgressStatisticsDetailDTO.ProductProcessWorkProgressStatisticsDetailDTOBuilder totalCompleteNetWeight(
         final BigDecimal totalCompleteNetWeight
      ) {
         this.totalCompleteNetWeight = totalCompleteNetWeight;
         return this;
      }

      public ProductProcessWorkProgressStatisticsDetailDTO.ProductProcessWorkProgressStatisticsDetailDTOBuilder totalCompleteGrossWeight(
         final BigDecimal totalCompleteGrossWeight
      ) {
         this.totalCompleteGrossWeight = totalCompleteGrossWeight;
         return this;
      }

      public ProductProcessWorkProgressStatisticsDetailDTO.ProductProcessWorkProgressStatisticsDetailDTOBuilder totalLossWeight(
         final BigDecimal totalLossWeight
      ) {
         this.totalLossWeight = totalLossWeight;
         return this;
      }

      public ProductProcessWorkProgressStatisticsDetailDTO.ProductProcessWorkProgressStatisticsDetailDTOBuilder totalLossRate(final String totalLossRate) {
         this.totalLossRate = totalLossRate;
         return this;
      }

      public ProductProcessWorkProgressStatisticsDetailDTO build() {
         return new ProductProcessWorkProgressStatisticsDetailDTO(
            this.processId,
            this.totalTaskQuantity,
            this.totalTaskNetWeight,
            this.totalTaskGrossWeight,
            this.totalInProductionQuantity,
            this.totalInProductionNetWeight,
            this.totalInProductionGrossWeight,
            this.totalCompleteQuantity,
            this.totalCompleteNetWeight,
            this.totalCompleteGrossWeight,
            this.totalLossWeight,
            this.totalLossRate
         );
      }

      @Override
      public String toString() {
         return "ProductProcessWorkProgressStatisticsDetailDTO.ProductProcessWorkProgressStatisticsDetailDTOBuilder(processId="
            + this.processId
            + ", totalTaskQuantity="
            + this.totalTaskQuantity
            + ", totalTaskNetWeight="
            + this.totalTaskNetWeight
            + ", totalTaskGrossWeight="
            + this.totalTaskGrossWeight
            + ", totalInProductionQuantity="
            + this.totalInProductionQuantity
            + ", totalInProductionNetWeight="
            + this.totalInProductionNetWeight
            + ", totalInProductionGrossWeight="
            + this.totalInProductionGrossWeight
            + ", totalCompleteQuantity="
            + this.totalCompleteQuantity
            + ", totalCompleteNetWeight="
            + this.totalCompleteNetWeight
            + ", totalCompleteGrossWeight="
            + this.totalCompleteGrossWeight
            + ", totalLossWeight="
            + this.totalLossWeight
            + ", totalLossRate="
            + this.totalLossRate
            + ")";
      }
   }
}
