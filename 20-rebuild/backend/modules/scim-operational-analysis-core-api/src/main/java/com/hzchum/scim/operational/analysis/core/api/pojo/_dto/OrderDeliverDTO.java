package com.hzchum.scim.operational.analysis.core.api.pojo._dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

public class OrderDeliverDTO {
   @ApiModelProperty(name = "orderSummary", value = "订单量", notes = "订单量")
   @JsonProperty("orderSummary")
   @JSONField(name = "orderSummary")
   private BigDecimal orderSummary;
   @ApiModelProperty(name = "completeSummary", value = "完成量", notes = "完成量")
   @JsonProperty("completeSummary")
   @JSONField(name = "completeSummary")
   private BigDecimal completeSummary;
   @ApiModelProperty(name = "avgDeliverRatio", value = "平均交付率", notes = "平均交付率")
   @JsonProperty("avgDeliverRatio")
   @JSONField(name = "avgDeliverRatio")
   private BigDecimal avgDeliverRatio;
   @ApiModelProperty(name = "details", value = "每月详情", notes = "每月详情")
   @JsonProperty("details")
   @JSONField(name = "details")
   private List<OrderDeliverDetailsDTO> details;

   public static OrderDeliverDTO.OrderDeliverDTOBuilder builder() {
      return new OrderDeliverDTO.OrderDeliverDTOBuilder();
   }

   public BigDecimal getOrderSummary() {
      return this.orderSummary;
   }

   public BigDecimal getCompleteSummary() {
      return this.completeSummary;
   }

   public BigDecimal getAvgDeliverRatio() {
      return this.avgDeliverRatio;
   }

   public List<OrderDeliverDetailsDTO> getDetails() {
      return this.details;
   }

   @JsonProperty("orderSummary")
   public void setOrderSummary(final BigDecimal orderSummary) {
      this.orderSummary = orderSummary;
   }

   @JsonProperty("completeSummary")
   public void setCompleteSummary(final BigDecimal completeSummary) {
      this.completeSummary = completeSummary;
   }

   @JsonProperty("avgDeliverRatio")
   public void setAvgDeliverRatio(final BigDecimal avgDeliverRatio) {
      this.avgDeliverRatio = avgDeliverRatio;
   }

   @JsonProperty("details")
   public void setDetails(final List<OrderDeliverDetailsDTO> details) {
      this.details = details;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OrderDeliverDTO)) {
         return false;
      }

      OrderDeliverDTO other = (OrderDeliverDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$orderSummary = this.getOrderSummary();
      Object other$orderSummary = other.getOrderSummary();
      if (this$orderSummary == null ? other$orderSummary == null : this$orderSummary.equals(other$orderSummary)) {
         Object this$completeSummary = this.getCompleteSummary();
         Object other$completeSummary = other.getCompleteSummary();
         if (this$completeSummary == null ? other$completeSummary == null : this$completeSummary.equals(other$completeSummary)) {
            Object this$avgDeliverRatio = this.getAvgDeliverRatio();
            Object other$avgDeliverRatio = other.getAvgDeliverRatio();
            if (this$avgDeliverRatio == null ? other$avgDeliverRatio == null : this$avgDeliverRatio.equals(other$avgDeliverRatio)) {
               Object this$details = this.getDetails();
               Object other$details = other.getDetails();
               return this$details == null ? other$details == null : this$details.equals(other$details);
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
      return other instanceof OrderDeliverDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderSummary = this.getOrderSummary();
      result = result * 59 + ($orderSummary == null ? 43 : $orderSummary.hashCode());
      Object $completeSummary = this.getCompleteSummary();
      result = result * 59 + ($completeSummary == null ? 43 : $completeSummary.hashCode());
      Object $avgDeliverRatio = this.getAvgDeliverRatio();
      result = result * 59 + ($avgDeliverRatio == null ? 43 : $avgDeliverRatio.hashCode());
      Object $details = this.getDetails();
      return result * 59 + ($details == null ? 43 : $details.hashCode());
   }

   @Override
   public String toString() {
      return "OrderDeliverDTO(orderSummary="
         + this.getOrderSummary()
         + ", completeSummary="
         + this.getCompleteSummary()
         + ", avgDeliverRatio="
         + this.getAvgDeliverRatio()
         + ", details="
         + this.getDetails()
         + ")";
   }

   public OrderDeliverDTO(
      final BigDecimal orderSummary, final BigDecimal completeSummary, final BigDecimal avgDeliverRatio, final List<OrderDeliverDetailsDTO> details
   ) {
      this.orderSummary = orderSummary;
      this.completeSummary = completeSummary;
      this.avgDeliverRatio = avgDeliverRatio;
      this.details = details;
   }

   public OrderDeliverDTO() {
   }

   public static class OrderDeliverDTOBuilder {
      private BigDecimal orderSummary;
      private BigDecimal completeSummary;
      private BigDecimal avgDeliverRatio;
      private List<OrderDeliverDetailsDTO> details;

      OrderDeliverDTOBuilder() {
      }

      @JsonProperty("orderSummary")
      public OrderDeliverDTO.OrderDeliverDTOBuilder orderSummary(final BigDecimal orderSummary) {
         this.orderSummary = orderSummary;
         return this;
      }

      @JsonProperty("completeSummary")
      public OrderDeliverDTO.OrderDeliverDTOBuilder completeSummary(final BigDecimal completeSummary) {
         this.completeSummary = completeSummary;
         return this;
      }

      @JsonProperty("avgDeliverRatio")
      public OrderDeliverDTO.OrderDeliverDTOBuilder avgDeliverRatio(final BigDecimal avgDeliverRatio) {
         this.avgDeliverRatio = avgDeliverRatio;
         return this;
      }

      @JsonProperty("details")
      public OrderDeliverDTO.OrderDeliverDTOBuilder details(final List<OrderDeliverDetailsDTO> details) {
         this.details = details;
         return this;
      }

      public OrderDeliverDTO build() {
         return new OrderDeliverDTO(this.orderSummary, this.completeSummary, this.avgDeliverRatio, this.details);
      }

      @Override
      public String toString() {
         return "OrderDeliverDTO.OrderDeliverDTOBuilder(orderSummary="
            + this.orderSummary
            + ", completeSummary="
            + this.completeSummary
            + ", avgDeliverRatio="
            + this.avgDeliverRatio
            + ", details="
            + this.details
            + ")";
      }
   }
}
