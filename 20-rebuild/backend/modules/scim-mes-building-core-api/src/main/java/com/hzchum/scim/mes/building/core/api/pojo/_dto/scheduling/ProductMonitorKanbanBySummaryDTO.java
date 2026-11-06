package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ProductMonitorKanbanByProductionLineDTO", description = "")
public class ProductMonitorKanbanBySummaryDTO {
   @ApiModelProperty(name = "capacityNetWeight", notes = "设计产能")
   @JsonProperty("capacityNetWeight")
   @JSONField(name = "capacityNetWeight")
   private BigDecimal capacityNetWeight;
   @ApiModelProperty(name = "yearAvgNetWeight", notes = "年度平均产量")
   @JsonProperty("yearAvgNetWeight")
   @JSONField(name = "yearAvgNetWeight")
   private BigDecimal yearAvgNetWeight;
   @ApiModelProperty(name = "orderQuantity", notes = "在手订单数")
   @JsonProperty("orderQuantity")
   @JSONField(name = "orderQuantity")
   private Integer orderQuantity;
   @ApiModelProperty(name = "unNetWeight", notes = "未完成量")
   @JsonProperty("unNetWeight")
   @JSONField(name = "unNetWeight")
   private BigDecimal unNetWeight;
   @ApiModelProperty(name = "taskNetWeight", notes = "任务量")
   @JsonProperty("taskNetWeight")
   @JSONField(name = "taskNetWeight")
   private BigDecimal taskNetWeight;
   @ApiModelProperty(name = "capacityRatio", notes = "产能空余率")
   @JsonProperty("capacityRatio")
   @JSONField(name = "capacityRatio")
   private BigDecimal capacityRatio;

   public static ProductMonitorKanbanBySummaryDTO.ProductMonitorKanbanBySummaryDTOBuilder builder() {
      return new ProductMonitorKanbanBySummaryDTO.ProductMonitorKanbanBySummaryDTOBuilder();
   }

   public ProductMonitorKanbanBySummaryDTO() {
   }

   public ProductMonitorKanbanBySummaryDTO(
      final BigDecimal capacityNetWeight,
      final BigDecimal yearAvgNetWeight,
      final Integer orderQuantity,
      final BigDecimal unNetWeight,
      final BigDecimal taskNetWeight,
      final BigDecimal capacityRatio
   ) {
      this.capacityNetWeight = capacityNetWeight;
      this.yearAvgNetWeight = yearAvgNetWeight;
      this.orderQuantity = orderQuantity;
      this.unNetWeight = unNetWeight;
      this.taskNetWeight = taskNetWeight;
      this.capacityRatio = capacityRatio;
   }

   public BigDecimal getCapacityNetWeight() {
      return this.capacityNetWeight;
   }

   public BigDecimal getYearAvgNetWeight() {
      return this.yearAvgNetWeight;
   }

   public Integer getOrderQuantity() {
      return this.orderQuantity;
   }

   public BigDecimal getUnNetWeight() {
      return this.unNetWeight;
   }

   public BigDecimal getTaskNetWeight() {
      return this.taskNetWeight;
   }

   public BigDecimal getCapacityRatio() {
      return this.capacityRatio;
   }

   @JsonProperty("capacityNetWeight")
   public ProductMonitorKanbanBySummaryDTO setCapacityNetWeight(final BigDecimal capacityNetWeight) {
      this.capacityNetWeight = capacityNetWeight;
      return this;
   }

   @JsonProperty("yearAvgNetWeight")
   public ProductMonitorKanbanBySummaryDTO setYearAvgNetWeight(final BigDecimal yearAvgNetWeight) {
      this.yearAvgNetWeight = yearAvgNetWeight;
      return this;
   }

   @JsonProperty("orderQuantity")
   public ProductMonitorKanbanBySummaryDTO setOrderQuantity(final Integer orderQuantity) {
      this.orderQuantity = orderQuantity;
      return this;
   }

   @JsonProperty("unNetWeight")
   public ProductMonitorKanbanBySummaryDTO setUnNetWeight(final BigDecimal unNetWeight) {
      this.unNetWeight = unNetWeight;
      return this;
   }

   @JsonProperty("taskNetWeight")
   public ProductMonitorKanbanBySummaryDTO setTaskNetWeight(final BigDecimal taskNetWeight) {
      this.taskNetWeight = taskNetWeight;
      return this;
   }

   @JsonProperty("capacityRatio")
   public ProductMonitorKanbanBySummaryDTO setCapacityRatio(final BigDecimal capacityRatio) {
      this.capacityRatio = capacityRatio;
      return this;
   }

   @Override
   public String toString() {
      return "ProductMonitorKanbanBySummaryDTO(capacityNetWeight="
         + this.getCapacityNetWeight()
         + ", yearAvgNetWeight="
         + this.getYearAvgNetWeight()
         + ", orderQuantity="
         + this.getOrderQuantity()
         + ", unNetWeight="
         + this.getUnNetWeight()
         + ", taskNetWeight="
         + this.getTaskNetWeight()
         + ", capacityRatio="
         + this.getCapacityRatio()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductMonitorKanbanBySummaryDTO)) {
         return false;
      }

      ProductMonitorKanbanBySummaryDTO other = (ProductMonitorKanbanBySummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$orderQuantity = this.getOrderQuantity();
      Object other$orderQuantity = other.getOrderQuantity();
      if (this$orderQuantity == null ? other$orderQuantity == null : this$orderQuantity.equals(other$orderQuantity)) {
         Object this$capacityNetWeight = this.getCapacityNetWeight();
         Object other$capacityNetWeight = other.getCapacityNetWeight();
         if (this$capacityNetWeight == null ? other$capacityNetWeight == null : this$capacityNetWeight.equals(other$capacityNetWeight)) {
            Object this$yearAvgNetWeight = this.getYearAvgNetWeight();
            Object other$yearAvgNetWeight = other.getYearAvgNetWeight();
            if (this$yearAvgNetWeight == null ? other$yearAvgNetWeight == null : this$yearAvgNetWeight.equals(other$yearAvgNetWeight)) {
               Object this$unNetWeight = this.getUnNetWeight();
               Object other$unNetWeight = other.getUnNetWeight();
               if (this$unNetWeight == null ? other$unNetWeight == null : this$unNetWeight.equals(other$unNetWeight)) {
                  Object this$taskNetWeight = this.getTaskNetWeight();
                  Object other$taskNetWeight = other.getTaskNetWeight();
                  if (this$taskNetWeight == null ? other$taskNetWeight == null : this$taskNetWeight.equals(other$taskNetWeight)) {
                     Object this$capacityRatio = this.getCapacityRatio();
                     Object other$capacityRatio = other.getCapacityRatio();
                     return this$capacityRatio == null ? other$capacityRatio == null : this$capacityRatio.equals(other$capacityRatio);
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
      return other instanceof ProductMonitorKanbanBySummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderQuantity = this.getOrderQuantity();
      result = result * 59 + ($orderQuantity == null ? 43 : $orderQuantity.hashCode());
      Object $capacityNetWeight = this.getCapacityNetWeight();
      result = result * 59 + ($capacityNetWeight == null ? 43 : $capacityNetWeight.hashCode());
      Object $yearAvgNetWeight = this.getYearAvgNetWeight();
      result = result * 59 + ($yearAvgNetWeight == null ? 43 : $yearAvgNetWeight.hashCode());
      Object $unNetWeight = this.getUnNetWeight();
      result = result * 59 + ($unNetWeight == null ? 43 : $unNetWeight.hashCode());
      Object $taskNetWeight = this.getTaskNetWeight();
      result = result * 59 + ($taskNetWeight == null ? 43 : $taskNetWeight.hashCode());
      Object $capacityRatio = this.getCapacityRatio();
      return result * 59 + ($capacityRatio == null ? 43 : $capacityRatio.hashCode());
   }

   public static class ProductMonitorKanbanBySummaryDTOBuilder {
      private BigDecimal capacityNetWeight;
      private BigDecimal yearAvgNetWeight;
      private Integer orderQuantity;
      private BigDecimal unNetWeight;
      private BigDecimal taskNetWeight;
      private BigDecimal capacityRatio;

      ProductMonitorKanbanBySummaryDTOBuilder() {
      }

      @JsonProperty("capacityNetWeight")
      public ProductMonitorKanbanBySummaryDTO.ProductMonitorKanbanBySummaryDTOBuilder capacityNetWeight(final BigDecimal capacityNetWeight) {
         this.capacityNetWeight = capacityNetWeight;
         return this;
      }

      @JsonProperty("yearAvgNetWeight")
      public ProductMonitorKanbanBySummaryDTO.ProductMonitorKanbanBySummaryDTOBuilder yearAvgNetWeight(final BigDecimal yearAvgNetWeight) {
         this.yearAvgNetWeight = yearAvgNetWeight;
         return this;
      }

      @JsonProperty("orderQuantity")
      public ProductMonitorKanbanBySummaryDTO.ProductMonitorKanbanBySummaryDTOBuilder orderQuantity(final Integer orderQuantity) {
         this.orderQuantity = orderQuantity;
         return this;
      }

      @JsonProperty("unNetWeight")
      public ProductMonitorKanbanBySummaryDTO.ProductMonitorKanbanBySummaryDTOBuilder unNetWeight(final BigDecimal unNetWeight) {
         this.unNetWeight = unNetWeight;
         return this;
      }

      @JsonProperty("taskNetWeight")
      public ProductMonitorKanbanBySummaryDTO.ProductMonitorKanbanBySummaryDTOBuilder taskNetWeight(final BigDecimal taskNetWeight) {
         this.taskNetWeight = taskNetWeight;
         return this;
      }

      @JsonProperty("capacityRatio")
      public ProductMonitorKanbanBySummaryDTO.ProductMonitorKanbanBySummaryDTOBuilder capacityRatio(final BigDecimal capacityRatio) {
         this.capacityRatio = capacityRatio;
         return this;
      }

      public ProductMonitorKanbanBySummaryDTO build() {
         return new ProductMonitorKanbanBySummaryDTO(
            this.capacityNetWeight, this.yearAvgNetWeight, this.orderQuantity, this.unNetWeight, this.taskNetWeight, this.capacityRatio
         );
      }

      @Override
      public String toString() {
         return "ProductMonitorKanbanBySummaryDTO.ProductMonitorKanbanBySummaryDTOBuilder(capacityNetWeight="
            + this.capacityNetWeight
            + ", yearAvgNetWeight="
            + this.yearAvgNetWeight
            + ", orderQuantity="
            + this.orderQuantity
            + ", unNetWeight="
            + this.unNetWeight
            + ", taskNetWeight="
            + this.taskNetWeight
            + ", capacityRatio="
            + this.capacityRatio
            + ")";
      }
   }
}
