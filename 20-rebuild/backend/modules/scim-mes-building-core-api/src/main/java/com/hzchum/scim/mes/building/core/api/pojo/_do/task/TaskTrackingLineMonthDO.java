package com.hzchum.scim.mes.building.core.api.pojo._do.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "TaskTrackingLineMonthDO", description = "月度任务跟踪")
public class TaskTrackingLineMonthDO {
   @ApiModelProperty(name = "month", notes = "月份")
   @JsonProperty("month")
   @JSONField(name = "month")
   private String month;
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "netWeight", notes = "净重")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "grossWeight", notes = "毛重")
   @JsonProperty("grossWeight")
   @JSONField(name = "grossWeight")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "completeQuantity", notes = "已完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "completeNetWeight", notes = "已完成重量(净重)")
   @JsonProperty("completeNetWeight")
   @JSONField(name = "completeNetWeight")
   private BigDecimal completeNetWeight;
   @ApiModelProperty(name = "completeGrossWeight", notes = "已完成重量(毛重)")
   @JsonProperty("completeGrossWeight")
   @JSONField(name = "completeGrossWeight")
   private BigDecimal completeGrossWeight;
   @ApiModelProperty(name = "rate", notes = "达成率")
   @JsonProperty("rate")
   @JSONField(name = "rate")
   private BigDecimal rate;

   public static TaskTrackingLineMonthDO.TaskTrackingLineMonthDOBuilder builder() {
      return new TaskTrackingLineMonthDO.TaskTrackingLineMonthDOBuilder();
   }

   public TaskTrackingLineMonthDO() {
   }

   public TaskTrackingLineMonthDO(
      final String month,
      final Integer quantity,
      final BigDecimal netWeight,
      final BigDecimal grossWeight,
      final Integer completeQuantity,
      final BigDecimal completeNetWeight,
      final BigDecimal completeGrossWeight,
      final BigDecimal rate
   ) {
      this.month = month;
      this.quantity = quantity;
      this.netWeight = netWeight;
      this.grossWeight = grossWeight;
      this.completeQuantity = completeQuantity;
      this.completeNetWeight = completeNetWeight;
      this.completeGrossWeight = completeGrossWeight;
      this.rate = rate;
   }

   public String getMonth() {
      return this.month;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public BigDecimal getCompleteNetWeight() {
      return this.completeNetWeight;
   }

   public BigDecimal getCompleteGrossWeight() {
      return this.completeGrossWeight;
   }

   public BigDecimal getRate() {
      return this.rate;
   }

   @JsonProperty("month")
   public TaskTrackingLineMonthDO setMonth(final String month) {
      this.month = month;
      return this;
   }

   @JsonProperty("quantity")
   public TaskTrackingLineMonthDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("netWeight")
   public TaskTrackingLineMonthDO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("grossWeight")
   public TaskTrackingLineMonthDO setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   @JsonProperty("completeQuantity")
   public TaskTrackingLineMonthDO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("completeNetWeight")
   public TaskTrackingLineMonthDO setCompleteNetWeight(final BigDecimal completeNetWeight) {
      this.completeNetWeight = completeNetWeight;
      return this;
   }

   @JsonProperty("completeGrossWeight")
   public TaskTrackingLineMonthDO setCompleteGrossWeight(final BigDecimal completeGrossWeight) {
      this.completeGrossWeight = completeGrossWeight;
      return this;
   }

   @JsonProperty("rate")
   public TaskTrackingLineMonthDO setRate(final BigDecimal rate) {
      this.rate = rate;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TaskTrackingLineMonthDO)) {
         return false;
      }

      TaskTrackingLineMonthDO other = (TaskTrackingLineMonthDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$completeQuantity = this.getCompleteQuantity();
         Object other$completeQuantity = other.getCompleteQuantity();
         if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
            Object this$month = this.getMonth();
            Object other$month = other.getMonth();
            if (this$month == null ? other$month == null : this$month.equals(other$month)) {
               Object this$netWeight = this.getNetWeight();
               Object other$netWeight = other.getNetWeight();
               if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                  Object this$grossWeight = this.getGrossWeight();
                  Object other$grossWeight = other.getGrossWeight();
                  if (this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight)) {
                     Object this$completeNetWeight = this.getCompleteNetWeight();
                     Object other$completeNetWeight = other.getCompleteNetWeight();
                     if (this$completeNetWeight == null ? other$completeNetWeight == null : this$completeNetWeight.equals(other$completeNetWeight)) {
                        Object this$completeGrossWeight = this.getCompleteGrossWeight();
                        Object other$completeGrossWeight = other.getCompleteGrossWeight();
                        if (this$completeGrossWeight == null ? other$completeGrossWeight == null : this$completeGrossWeight.equals(other$completeGrossWeight)) {
                           Object this$rate = this.getRate();
                           Object other$rate = other.getRate();
                           return this$rate == null ? other$rate == null : this$rate.equals(other$rate);
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
      return other instanceof TaskTrackingLineMonthDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $month = this.getMonth();
      result = result * 59 + ($month == null ? 43 : $month.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $completeNetWeight = this.getCompleteNetWeight();
      result = result * 59 + ($completeNetWeight == null ? 43 : $completeNetWeight.hashCode());
      Object $completeGrossWeight = this.getCompleteGrossWeight();
      result = result * 59 + ($completeGrossWeight == null ? 43 : $completeGrossWeight.hashCode());
      Object $rate = this.getRate();
      return result * 59 + ($rate == null ? 43 : $rate.hashCode());
   }

   @Override
   public String toString() {
      return "TaskTrackingLineMonthDO(month="
         + this.getMonth()
         + ", quantity="
         + this.getQuantity()
         + ", netWeight="
         + this.getNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", completeNetWeight="
         + this.getCompleteNetWeight()
         + ", completeGrossWeight="
         + this.getCompleteGrossWeight()
         + ", rate="
         + this.getRate()
         + ")";
   }

   public static class TaskTrackingLineMonthDOBuilder {
      private String month;
      private Integer quantity;
      private BigDecimal netWeight;
      private BigDecimal grossWeight;
      private Integer completeQuantity;
      private BigDecimal completeNetWeight;
      private BigDecimal completeGrossWeight;
      private BigDecimal rate;

      TaskTrackingLineMonthDOBuilder() {
      }

      @JsonProperty("month")
      public TaskTrackingLineMonthDO.TaskTrackingLineMonthDOBuilder month(final String month) {
         this.month = month;
         return this;
      }

      @JsonProperty("quantity")
      public TaskTrackingLineMonthDO.TaskTrackingLineMonthDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("netWeight")
      public TaskTrackingLineMonthDO.TaskTrackingLineMonthDOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("grossWeight")
      public TaskTrackingLineMonthDO.TaskTrackingLineMonthDOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      @JsonProperty("completeQuantity")
      public TaskTrackingLineMonthDO.TaskTrackingLineMonthDOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("completeNetWeight")
      public TaskTrackingLineMonthDO.TaskTrackingLineMonthDOBuilder completeNetWeight(final BigDecimal completeNetWeight) {
         this.completeNetWeight = completeNetWeight;
         return this;
      }

      @JsonProperty("completeGrossWeight")
      public TaskTrackingLineMonthDO.TaskTrackingLineMonthDOBuilder completeGrossWeight(final BigDecimal completeGrossWeight) {
         this.completeGrossWeight = completeGrossWeight;
         return this;
      }

      @JsonProperty("rate")
      public TaskTrackingLineMonthDO.TaskTrackingLineMonthDOBuilder rate(final BigDecimal rate) {
         this.rate = rate;
         return this;
      }

      public TaskTrackingLineMonthDO build() {
         return new TaskTrackingLineMonthDO(
            this.month, this.quantity, this.netWeight, this.grossWeight, this.completeQuantity, this.completeNetWeight, this.completeGrossWeight, this.rate
         );
      }

      @Override
      public String toString() {
         return "TaskTrackingLineMonthDO.TaskTrackingLineMonthDOBuilder(month="
            + this.month
            + ", quantity="
            + this.quantity
            + ", netWeight="
            + this.netWeight
            + ", grossWeight="
            + this.grossWeight
            + ", completeQuantity="
            + this.completeQuantity
            + ", completeNetWeight="
            + this.completeNetWeight
            + ", completeGrossWeight="
            + this.completeGrossWeight
            + ", rate="
            + this.rate
            + ")";
      }
   }
}
