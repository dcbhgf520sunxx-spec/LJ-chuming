package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel(value = "PartDistributionDTO", description = "")
public class PartDistributionDTO {
   @ApiModelProperty(name = "orderNumber", notes = "任务单号", value = "任务单号")
   private String orderNumber;
   private LocalDateTime createTime;
   @ApiModelProperty("项目")
   List<ProjectMomentDTO> projectInfoList;
   @ApiModelProperty(name = "quantity", value = "零件数量")
   private Integer quantity;
   @ApiModelProperty(name = "cutQuantity", value = "钢板数量")
   private Integer cutQuantity;
   @ApiModelProperty("总净重量")
   private BigDecimal totalNetWeight;
   @ApiModelProperty("总毛重量")
   private BigDecimal totalGrossWeight;

   public static PartDistributionDTO.PartDistributionDTOBuilder builder() {
      return new PartDistributionDTO.PartDistributionDTOBuilder();
   }

   public PartDistributionDTO() {
   }

   public PartDistributionDTO(
      final String orderNumber,
      final LocalDateTime createTime,
      final List<ProjectMomentDTO> projectInfoList,
      final Integer quantity,
      final Integer cutQuantity,
      final BigDecimal totalNetWeight,
      final BigDecimal totalGrossWeight
   ) {
      this.orderNumber = orderNumber;
      this.createTime = createTime;
      this.projectInfoList = projectInfoList;
      this.quantity = quantity;
      this.cutQuantity = cutQuantity;
      this.totalNetWeight = totalNetWeight;
      this.totalGrossWeight = totalGrossWeight;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public List<ProjectMomentDTO> getProjectInfoList() {
      return this.projectInfoList;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getCutQuantity() {
      return this.cutQuantity;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public void setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setProjectInfoList(final List<ProjectMomentDTO> projectInfoList) {
      this.projectInfoList = projectInfoList;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setCutQuantity(final Integer cutQuantity) {
      this.cutQuantity = cutQuantity;
   }

   public void setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
   }

   public void setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PartDistributionDTO)) {
         return false;
      }

      PartDistributionDTO other = (PartDistributionDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$cutQuantity = this.getCutQuantity();
         Object other$cutQuantity = other.getCutQuantity();
         if (this$cutQuantity == null ? other$cutQuantity == null : this$cutQuantity.equals(other$cutQuantity)) {
            Object this$orderNumber = this.getOrderNumber();
            Object other$orderNumber = other.getOrderNumber();
            if (this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber)) {
               Object this$createTime = this.getCreateTime();
               Object other$createTime = other.getCreateTime();
               if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                  Object this$projectInfoList = this.getProjectInfoList();
                  Object other$projectInfoList = other.getProjectInfoList();
                  if (this$projectInfoList == null ? other$projectInfoList == null : this$projectInfoList.equals(other$projectInfoList)) {
                     Object this$totalNetWeight = this.getTotalNetWeight();
                     Object other$totalNetWeight = other.getTotalNetWeight();
                     if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
                        Object this$totalGrossWeight = this.getTotalGrossWeight();
                        Object other$totalGrossWeight = other.getTotalGrossWeight();
                        return this$totalGrossWeight == null ? other$totalGrossWeight == null : this$totalGrossWeight.equals(other$totalGrossWeight);
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
      return other instanceof PartDistributionDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $cutQuantity = this.getCutQuantity();
      result = result * 59 + ($cutQuantity == null ? 43 : $cutQuantity.hashCode());
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $projectInfoList = this.getProjectInfoList();
      result = result * 59 + ($projectInfoList == null ? 43 : $projectInfoList.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      return result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
   }

   @Override
   public String toString() {
      return "PartDistributionDTO(orderNumber="
         + this.getOrderNumber()
         + ", createTime="
         + this.getCreateTime()
         + ", projectInfoList="
         + this.getProjectInfoList()
         + ", quantity="
         + this.getQuantity()
         + ", cutQuantity="
         + this.getCutQuantity()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ")";
   }

   public static class PartDistributionDTOBuilder {
      private String orderNumber;
      private LocalDateTime createTime;
      private List<ProjectMomentDTO> projectInfoList;
      private Integer quantity;
      private Integer cutQuantity;
      private BigDecimal totalNetWeight;
      private BigDecimal totalGrossWeight;

      PartDistributionDTOBuilder() {
      }

      public PartDistributionDTO.PartDistributionDTOBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      public PartDistributionDTO.PartDistributionDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public PartDistributionDTO.PartDistributionDTOBuilder projectInfoList(final List<ProjectMomentDTO> projectInfoList) {
         this.projectInfoList = projectInfoList;
         return this;
      }

      public PartDistributionDTO.PartDistributionDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public PartDistributionDTO.PartDistributionDTOBuilder cutQuantity(final Integer cutQuantity) {
         this.cutQuantity = cutQuantity;
         return this;
      }

      public PartDistributionDTO.PartDistributionDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      public PartDistributionDTO.PartDistributionDTOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      public PartDistributionDTO build() {
         return new PartDistributionDTO(
            this.orderNumber, this.createTime, this.projectInfoList, this.quantity, this.cutQuantity, this.totalNetWeight, this.totalGrossWeight
         );
      }

      @Override
      public String toString() {
         return "PartDistributionDTO.PartDistributionDTOBuilder(orderNumber="
            + this.orderNumber
            + ", createTime="
            + this.createTime
            + ", projectInfoList="
            + this.projectInfoList
            + ", quantity="
            + this.quantity
            + ", cutQuantity="
            + this.cutQuantity
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ")";
      }
   }
}
