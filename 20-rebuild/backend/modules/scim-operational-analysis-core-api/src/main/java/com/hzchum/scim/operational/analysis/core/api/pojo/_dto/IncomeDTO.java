package com.hzchum.scim.operational.analysis.core.api.pojo._dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class IncomeDTO {
   @ApiModelProperty(name = "month", value = "月份", notes = "月份")
   @JsonProperty("month")
   @JSONField(name = "month")
   private Integer month;
   @ApiModelProperty("收入金额")
   @JsonProperty("collectionAmount")
   @JSONField(name = "collectionAmount")
   private BigDecimal collectionAmount;
   @ApiModelProperty("付款金额")
   @JsonProperty("paymentAmount")
   @JSONField(name = "paymentAmount")
   private BigDecimal paymentAmount;

   public static IncomeDTO.IncomeDTOBuilder builder() {
      return new IncomeDTO.IncomeDTOBuilder();
   }

   public Integer getMonth() {
      return this.month;
   }

   public BigDecimal getCollectionAmount() {
      return this.collectionAmount;
   }

   public BigDecimal getPaymentAmount() {
      return this.paymentAmount;
   }

   @JsonProperty("month")
   public void setMonth(final Integer month) {
      this.month = month;
   }

   @JsonProperty("collectionAmount")
   public void setCollectionAmount(final BigDecimal collectionAmount) {
      this.collectionAmount = collectionAmount;
   }

   @JsonProperty("paymentAmount")
   public void setPaymentAmount(final BigDecimal paymentAmount) {
      this.paymentAmount = paymentAmount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof IncomeDTO)) {
         return false;
      }

      IncomeDTO other = (IncomeDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$month = this.getMonth();
      Object other$month = other.getMonth();
      if (this$month == null ? other$month == null : this$month.equals(other$month)) {
         Object this$collectionAmount = this.getCollectionAmount();
         Object other$collectionAmount = other.getCollectionAmount();
         if (this$collectionAmount == null ? other$collectionAmount == null : this$collectionAmount.equals(other$collectionAmount)) {
            Object this$paymentAmount = this.getPaymentAmount();
            Object other$paymentAmount = other.getPaymentAmount();
            return this$paymentAmount == null ? other$paymentAmount == null : this$paymentAmount.equals(other$paymentAmount);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof IncomeDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $month = this.getMonth();
      result = result * 59 + ($month == null ? 43 : $month.hashCode());
      Object $collectionAmount = this.getCollectionAmount();
      result = result * 59 + ($collectionAmount == null ? 43 : $collectionAmount.hashCode());
      Object $paymentAmount = this.getPaymentAmount();
      return result * 59 + ($paymentAmount == null ? 43 : $paymentAmount.hashCode());
   }

   @Override
   public String toString() {
      return "IncomeDTO(month=" + this.getMonth() + ", collectionAmount=" + this.getCollectionAmount() + ", paymentAmount=" + this.getPaymentAmount() + ")";
   }

   public IncomeDTO(final Integer month, final BigDecimal collectionAmount, final BigDecimal paymentAmount) {
      this.month = month;
      this.collectionAmount = collectionAmount;
      this.paymentAmount = paymentAmount;
   }

   public IncomeDTO() {
   }

   public static class IncomeDTOBuilder {
      private Integer month;
      private BigDecimal collectionAmount;
      private BigDecimal paymentAmount;

      IncomeDTOBuilder() {
      }

      @JsonProperty("month")
      public IncomeDTO.IncomeDTOBuilder month(final Integer month) {
         this.month = month;
         return this;
      }

      @JsonProperty("collectionAmount")
      public IncomeDTO.IncomeDTOBuilder collectionAmount(final BigDecimal collectionAmount) {
         this.collectionAmount = collectionAmount;
         return this;
      }

      @JsonProperty("paymentAmount")
      public IncomeDTO.IncomeDTOBuilder paymentAmount(final BigDecimal paymentAmount) {
         this.paymentAmount = paymentAmount;
         return this;
      }

      public IncomeDTO build() {
         return new IncomeDTO(this.month, this.collectionAmount, this.paymentAmount);
      }

      @Override
      public String toString() {
         return "IncomeDTO.IncomeDTOBuilder(month="
            + this.month
            + ", collectionAmount="
            + this.collectionAmount
            + ", paymentAmount="
            + this.paymentAmount
            + ")";
      }
   }
}
