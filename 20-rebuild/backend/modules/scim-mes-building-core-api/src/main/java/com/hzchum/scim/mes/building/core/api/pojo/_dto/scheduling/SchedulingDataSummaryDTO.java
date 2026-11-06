package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "SchedulingDataSummaryDTO", description = "排产汇总对象")
public class SchedulingDataSummaryDTO {
   @ApiModelProperty(name = "projectCount", notes = "项目数")
   @JsonProperty("projectCount")
   @JSONField(name = "projectCount")
   private Long projectCount;
   @ApiModelProperty(name = "quantity", notes = "清单数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "totalWeight", notes = "清单重量")
   @JsonProperty("totalWeight")
   @JSONField(name = "totalWeight")
   private BigDecimal totalWeight;

   public static SchedulingDataSummaryDTO.SchedulingDataSummaryDTOBuilder builder() {
      return new SchedulingDataSummaryDTO.SchedulingDataSummaryDTOBuilder();
   }

   public SchedulingDataSummaryDTO() {
   }

   public SchedulingDataSummaryDTO(final Long projectCount, final Integer quantity, final BigDecimal totalWeight) {
      this.projectCount = projectCount;
      this.quantity = quantity;
      this.totalWeight = totalWeight;
   }

   public Long getProjectCount() {
      return this.projectCount;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   @JsonProperty("projectCount")
   public SchedulingDataSummaryDTO setProjectCount(final Long projectCount) {
      this.projectCount = projectCount;
      return this;
   }

   @JsonProperty("quantity")
   public SchedulingDataSummaryDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("totalWeight")
   public SchedulingDataSummaryDTO setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SchedulingDataSummaryDTO)) {
         return false;
      }

      SchedulingDataSummaryDTO other = (SchedulingDataSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectCount = this.getProjectCount();
      Object other$projectCount = other.getProjectCount();
      if (this$projectCount == null ? other$projectCount == null : this$projectCount.equals(other$projectCount)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$totalWeight = this.getTotalWeight();
            Object other$totalWeight = other.getTotalWeight();
            return this$totalWeight == null ? other$totalWeight == null : this$totalWeight.equals(other$totalWeight);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SchedulingDataSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectCount = this.getProjectCount();
      result = result * 59 + ($projectCount == null ? 43 : $projectCount.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $totalWeight = this.getTotalWeight();
      return result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
   }

   @Override
   public String toString() {
      return "SchedulingDataSummaryDTO(projectCount="
         + this.getProjectCount()
         + ", quantity="
         + this.getQuantity()
         + ", totalWeight="
         + this.getTotalWeight()
         + ")";
   }

   public static class SchedulingDataSummaryDTOBuilder {
      private Long projectCount;
      private Integer quantity;
      private BigDecimal totalWeight;

      SchedulingDataSummaryDTOBuilder() {
      }

      @JsonProperty("projectCount")
      public SchedulingDataSummaryDTO.SchedulingDataSummaryDTOBuilder projectCount(final Long projectCount) {
         this.projectCount = projectCount;
         return this;
      }

      @JsonProperty("quantity")
      public SchedulingDataSummaryDTO.SchedulingDataSummaryDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("totalWeight")
      public SchedulingDataSummaryDTO.SchedulingDataSummaryDTOBuilder totalWeight(final BigDecimal totalWeight) {
         this.totalWeight = totalWeight;
         return this;
      }

      public SchedulingDataSummaryDTO build() {
         return new SchedulingDataSummaryDTO(this.projectCount, this.quantity, this.totalWeight);
      }

      @Override
      public String toString() {
         return "SchedulingDataSummaryDTO.SchedulingDataSummaryDTOBuilder(projectCount="
            + this.projectCount
            + ", quantity="
            + this.quantity
            + ", totalWeight="
            + this.totalWeight
            + ")";
      }
   }
}
