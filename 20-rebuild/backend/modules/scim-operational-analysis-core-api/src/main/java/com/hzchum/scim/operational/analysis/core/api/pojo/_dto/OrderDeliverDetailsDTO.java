package com.hzchum.scim.operational.analysis.core.api.pojo._dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class OrderDeliverDetailsDTO {
   @ApiModelProperty(name = "month", value = "月份", notes = "月份")
   @JsonProperty("month")
   @JSONField(name = "month")
   private Integer month;
   @ApiModelProperty(name = "order", value = "订单量", notes = "订单量")
   @JsonProperty("order")
   @JSONField(name = "order")
   private BigDecimal order;
   @ApiModelProperty(name = "complete", value = "完成量", notes = "完成量")
   @JsonProperty("complete")
   @JSONField(name = "complete")
   private BigDecimal complete;
   @ApiModelProperty(name = "deliverRatio", value = "交付率", notes = "交付率")
   @JsonProperty("deliverRatio")
   @JSONField(name = "deliverRatio")
   private BigDecimal deliverRatio;

   public static OrderDeliverDetailsDTO.OrderDeliverDetailsDTOBuilder builder() {
      return new OrderDeliverDetailsDTO.OrderDeliverDetailsDTOBuilder();
   }

   public Integer getMonth() {
      return this.month;
   }

   public BigDecimal getOrder() {
      return this.order;
   }

   public BigDecimal getComplete() {
      return this.complete;
   }

   public BigDecimal getDeliverRatio() {
      return this.deliverRatio;
   }

   @JsonProperty("month")
   public void setMonth(final Integer month) {
      this.month = month;
   }

   @JsonProperty("order")
   public void setOrder(final BigDecimal order) {
      this.order = order;
   }

   @JsonProperty("complete")
   public void setComplete(final BigDecimal complete) {
      this.complete = complete;
   }

   @JsonProperty("deliverRatio")
   public void setDeliverRatio(final BigDecimal deliverRatio) {
      this.deliverRatio = deliverRatio;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OrderDeliverDetailsDTO)) {
         return false;
      }

      OrderDeliverDetailsDTO other = (OrderDeliverDetailsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$month = this.getMonth();
      Object other$month = other.getMonth();
      if (this$month == null ? other$month == null : this$month.equals(other$month)) {
         Object this$order = this.getOrder();
         Object other$order = other.getOrder();
         if (this$order == null ? other$order == null : this$order.equals(other$order)) {
            Object this$complete = this.getComplete();
            Object other$complete = other.getComplete();
            if (this$complete == null ? other$complete == null : this$complete.equals(other$complete)) {
               Object this$deliverRatio = this.getDeliverRatio();
               Object other$deliverRatio = other.getDeliverRatio();
               return this$deliverRatio == null ? other$deliverRatio == null : this$deliverRatio.equals(other$deliverRatio);
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
      return other instanceof OrderDeliverDetailsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $month = this.getMonth();
      result = result * 59 + ($month == null ? 43 : $month.hashCode());
      Object $order = this.getOrder();
      result = result * 59 + ($order == null ? 43 : $order.hashCode());
      Object $complete = this.getComplete();
      result = result * 59 + ($complete == null ? 43 : $complete.hashCode());
      Object $deliverRatio = this.getDeliverRatio();
      return result * 59 + ($deliverRatio == null ? 43 : $deliverRatio.hashCode());
   }

   @Override
   public String toString() {
      return "OrderDeliverDetailsDTO(month="
         + this.getMonth()
         + ", order="
         + this.getOrder()
         + ", complete="
         + this.getComplete()
         + ", deliverRatio="
         + this.getDeliverRatio()
         + ")";
   }

   public OrderDeliverDetailsDTO(final Integer month, final BigDecimal order, final BigDecimal complete, final BigDecimal deliverRatio) {
      this.month = month;
      this.order = order;
      this.complete = complete;
      this.deliverRatio = deliverRatio;
   }

   public OrderDeliverDetailsDTO() {
   }

   public static class OrderDeliverDetailsDTOBuilder {
      private Integer month;
      private BigDecimal order;
      private BigDecimal complete;
      private BigDecimal deliverRatio;

      OrderDeliverDetailsDTOBuilder() {
      }

      @JsonProperty("month")
      public OrderDeliverDetailsDTO.OrderDeliverDetailsDTOBuilder month(final Integer month) {
         this.month = month;
         return this;
      }

      @JsonProperty("order")
      public OrderDeliverDetailsDTO.OrderDeliverDetailsDTOBuilder order(final BigDecimal order) {
         this.order = order;
         return this;
      }

      @JsonProperty("complete")
      public OrderDeliverDetailsDTO.OrderDeliverDetailsDTOBuilder complete(final BigDecimal complete) {
         this.complete = complete;
         return this;
      }

      @JsonProperty("deliverRatio")
      public OrderDeliverDetailsDTO.OrderDeliverDetailsDTOBuilder deliverRatio(final BigDecimal deliverRatio) {
         this.deliverRatio = deliverRatio;
         return this;
      }

      public OrderDeliverDetailsDTO build() {
         return new OrderDeliverDetailsDTO(this.month, this.order, this.complete, this.deliverRatio);
      }

      @Override
      public String toString() {
         return "OrderDeliverDetailsDTO.OrderDeliverDetailsDTOBuilder(month="
            + this.month
            + ", order="
            + this.order
            + ", complete="
            + this.complete
            + ", deliverRatio="
            + this.deliverRatio
            + ")";
      }
   }
}
