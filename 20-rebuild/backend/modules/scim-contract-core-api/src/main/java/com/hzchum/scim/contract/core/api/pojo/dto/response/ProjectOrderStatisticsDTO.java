package com.hzchum.scim.contract.core.api.pojo.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("项目统计类")
public class ProjectOrderStatisticsDTO {
   @ApiModelProperty(name = "sumQuantity", notes = "项目总数量")
   private Integer sumQuantity;
   @ApiModelProperty(name = "selfSupportQuantity", notes = "自营项目数量")
   private Long selfSupportQuantity;
   @ApiModelProperty(name = "jointVentureQuantity", notes = "合营项目数量")
   private Long jointVentureQuantity;
   @ApiModelProperty(name = "lumpSumSystemQuantity", notes = "包干制项目数量")
   private Long lumpSumSystemQuantity;
   @ApiModelProperty(name = "processingQuantity", notes = "进行中数量")
   private Long processingQuantity;
   @ApiModelProperty(name = "completedQuantity", notes = "已完工数量")
   private Long completedQuantity;
   @ApiModelProperty(name = "settlementQuantity", notes = "已结算数量")
   private Long settlementQuantity;
   @ApiModelProperty(name = "contractAmount", notes = "合同总金额")
   private BigDecimal contractAmount;

   public static ProjectOrderStatisticsDTO.ProjectOrderStatisticsDTOBuilder builder() {
      return new ProjectOrderStatisticsDTO.ProjectOrderStatisticsDTOBuilder();
   }

   public Integer getSumQuantity() {
      return this.sumQuantity;
   }

   public Long getSelfSupportQuantity() {
      return this.selfSupportQuantity;
   }

   public Long getJointVentureQuantity() {
      return this.jointVentureQuantity;
   }

   public Long getLumpSumSystemQuantity() {
      return this.lumpSumSystemQuantity;
   }

   public Long getProcessingQuantity() {
      return this.processingQuantity;
   }

   public Long getCompletedQuantity() {
      return this.completedQuantity;
   }

   public Long getSettlementQuantity() {
      return this.settlementQuantity;
   }

   public BigDecimal getContractAmount() {
      return this.contractAmount;
   }

   public void setSumQuantity(final Integer sumQuantity) {
      this.sumQuantity = sumQuantity;
   }

   public void setSelfSupportQuantity(final Long selfSupportQuantity) {
      this.selfSupportQuantity = selfSupportQuantity;
   }

   public void setJointVentureQuantity(final Long jointVentureQuantity) {
      this.jointVentureQuantity = jointVentureQuantity;
   }

   public void setLumpSumSystemQuantity(final Long lumpSumSystemQuantity) {
      this.lumpSumSystemQuantity = lumpSumSystemQuantity;
   }

   public void setProcessingQuantity(final Long processingQuantity) {
      this.processingQuantity = processingQuantity;
   }

   public void setCompletedQuantity(final Long completedQuantity) {
      this.completedQuantity = completedQuantity;
   }

   public void setSettlementQuantity(final Long settlementQuantity) {
      this.settlementQuantity = settlementQuantity;
   }

   public void setContractAmount(final BigDecimal contractAmount) {
      this.contractAmount = contractAmount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectOrderStatisticsDTO)) {
         return false;
      }

      ProjectOrderStatisticsDTO other = (ProjectOrderStatisticsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$sumQuantity = this.getSumQuantity();
      Object other$sumQuantity = other.getSumQuantity();
      if (this$sumQuantity == null ? other$sumQuantity == null : this$sumQuantity.equals(other$sumQuantity)) {
         Object this$selfSupportQuantity = this.getSelfSupportQuantity();
         Object other$selfSupportQuantity = other.getSelfSupportQuantity();
         if (this$selfSupportQuantity == null ? other$selfSupportQuantity == null : this$selfSupportQuantity.equals(other$selfSupportQuantity)) {
            Object this$jointVentureQuantity = this.getJointVentureQuantity();
            Object other$jointVentureQuantity = other.getJointVentureQuantity();
            if (this$jointVentureQuantity == null ? other$jointVentureQuantity == null : this$jointVentureQuantity.equals(other$jointVentureQuantity)) {
               Object this$lumpSumSystemQuantity = this.getLumpSumSystemQuantity();
               Object other$lumpSumSystemQuantity = other.getLumpSumSystemQuantity();
               if (this$lumpSumSystemQuantity == null ? other$lumpSumSystemQuantity == null : this$lumpSumSystemQuantity.equals(other$lumpSumSystemQuantity)) {
                  Object this$processingQuantity = this.getProcessingQuantity();
                  Object other$processingQuantity = other.getProcessingQuantity();
                  if (this$processingQuantity == null ? other$processingQuantity == null : this$processingQuantity.equals(other$processingQuantity)) {
                     Object this$completedQuantity = this.getCompletedQuantity();
                     Object other$completedQuantity = other.getCompletedQuantity();
                     if (this$completedQuantity == null ? other$completedQuantity == null : this$completedQuantity.equals(other$completedQuantity)) {
                        Object this$settlementQuantity = this.getSettlementQuantity();
                        Object other$settlementQuantity = other.getSettlementQuantity();
                        if (this$settlementQuantity == null ? other$settlementQuantity == null : this$settlementQuantity.equals(other$settlementQuantity)) {
                           Object this$contractAmount = this.getContractAmount();
                           Object other$contractAmount = other.getContractAmount();
                           return this$contractAmount == null ? other$contractAmount == null : this$contractAmount.equals(other$contractAmount);
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
      return other instanceof ProjectOrderStatisticsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $sumQuantity = this.getSumQuantity();
      result = result * 59 + ($sumQuantity == null ? 43 : $sumQuantity.hashCode());
      Object $selfSupportQuantity = this.getSelfSupportQuantity();
      result = result * 59 + ($selfSupportQuantity == null ? 43 : $selfSupportQuantity.hashCode());
      Object $jointVentureQuantity = this.getJointVentureQuantity();
      result = result * 59 + ($jointVentureQuantity == null ? 43 : $jointVentureQuantity.hashCode());
      Object $lumpSumSystemQuantity = this.getLumpSumSystemQuantity();
      result = result * 59 + ($lumpSumSystemQuantity == null ? 43 : $lumpSumSystemQuantity.hashCode());
      Object $processingQuantity = this.getProcessingQuantity();
      result = result * 59 + ($processingQuantity == null ? 43 : $processingQuantity.hashCode());
      Object $completedQuantity = this.getCompletedQuantity();
      result = result * 59 + ($completedQuantity == null ? 43 : $completedQuantity.hashCode());
      Object $settlementQuantity = this.getSettlementQuantity();
      result = result * 59 + ($settlementQuantity == null ? 43 : $settlementQuantity.hashCode());
      Object $contractAmount = this.getContractAmount();
      return result * 59 + ($contractAmount == null ? 43 : $contractAmount.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectOrderStatisticsDTO(sumQuantity="
         + this.getSumQuantity()
         + ", selfSupportQuantity="
         + this.getSelfSupportQuantity()
         + ", jointVentureQuantity="
         + this.getJointVentureQuantity()
         + ", lumpSumSystemQuantity="
         + this.getLumpSumSystemQuantity()
         + ", processingQuantity="
         + this.getProcessingQuantity()
         + ", completedQuantity="
         + this.getCompletedQuantity()
         + ", settlementQuantity="
         + this.getSettlementQuantity()
         + ", contractAmount="
         + this.getContractAmount()
         + ")";
   }

   public ProjectOrderStatisticsDTO() {
   }

   public ProjectOrderStatisticsDTO(
      final Integer sumQuantity,
      final Long selfSupportQuantity,
      final Long jointVentureQuantity,
      final Long lumpSumSystemQuantity,
      final Long processingQuantity,
      final Long completedQuantity,
      final Long settlementQuantity,
      final BigDecimal contractAmount
   ) {
      this.sumQuantity = sumQuantity;
      this.selfSupportQuantity = selfSupportQuantity;
      this.jointVentureQuantity = jointVentureQuantity;
      this.lumpSumSystemQuantity = lumpSumSystemQuantity;
      this.processingQuantity = processingQuantity;
      this.completedQuantity = completedQuantity;
      this.settlementQuantity = settlementQuantity;
      this.contractAmount = contractAmount;
   }

   public static class ProjectOrderStatisticsDTOBuilder {
      private Integer sumQuantity;
      private Long selfSupportQuantity;
      private Long jointVentureQuantity;
      private Long lumpSumSystemQuantity;
      private Long processingQuantity;
      private Long completedQuantity;
      private Long settlementQuantity;
      private BigDecimal contractAmount;

      ProjectOrderStatisticsDTOBuilder() {
      }

      public ProjectOrderStatisticsDTO.ProjectOrderStatisticsDTOBuilder sumQuantity(final Integer sumQuantity) {
         this.sumQuantity = sumQuantity;
         return this;
      }

      public ProjectOrderStatisticsDTO.ProjectOrderStatisticsDTOBuilder selfSupportQuantity(final Long selfSupportQuantity) {
         this.selfSupportQuantity = selfSupportQuantity;
         return this;
      }

      public ProjectOrderStatisticsDTO.ProjectOrderStatisticsDTOBuilder jointVentureQuantity(final Long jointVentureQuantity) {
         this.jointVentureQuantity = jointVentureQuantity;
         return this;
      }

      public ProjectOrderStatisticsDTO.ProjectOrderStatisticsDTOBuilder lumpSumSystemQuantity(final Long lumpSumSystemQuantity) {
         this.lumpSumSystemQuantity = lumpSumSystemQuantity;
         return this;
      }

      public ProjectOrderStatisticsDTO.ProjectOrderStatisticsDTOBuilder processingQuantity(final Long processingQuantity) {
         this.processingQuantity = processingQuantity;
         return this;
      }

      public ProjectOrderStatisticsDTO.ProjectOrderStatisticsDTOBuilder completedQuantity(final Long completedQuantity) {
         this.completedQuantity = completedQuantity;
         return this;
      }

      public ProjectOrderStatisticsDTO.ProjectOrderStatisticsDTOBuilder settlementQuantity(final Long settlementQuantity) {
         this.settlementQuantity = settlementQuantity;
         return this;
      }

      public ProjectOrderStatisticsDTO.ProjectOrderStatisticsDTOBuilder contractAmount(final BigDecimal contractAmount) {
         this.contractAmount = contractAmount;
         return this;
      }

      public ProjectOrderStatisticsDTO build() {
         return new ProjectOrderStatisticsDTO(
            this.sumQuantity,
            this.selfSupportQuantity,
            this.jointVentureQuantity,
            this.lumpSumSystemQuantity,
            this.processingQuantity,
            this.completedQuantity,
            this.settlementQuantity,
            this.contractAmount
         );
      }

      @Override
      public String toString() {
         return "ProjectOrderStatisticsDTO.ProjectOrderStatisticsDTOBuilder(sumQuantity="
            + this.sumQuantity
            + ", selfSupportQuantity="
            + this.selfSupportQuantity
            + ", jointVentureQuantity="
            + this.jointVentureQuantity
            + ", lumpSumSystemQuantity="
            + this.lumpSumSystemQuantity
            + ", processingQuantity="
            + this.processingQuantity
            + ", completedQuantity="
            + this.completedQuantity
            + ", settlementQuantity="
            + this.settlementQuantity
            + ", contractAmount="
            + this.contractAmount
            + ")";
      }
   }
}
