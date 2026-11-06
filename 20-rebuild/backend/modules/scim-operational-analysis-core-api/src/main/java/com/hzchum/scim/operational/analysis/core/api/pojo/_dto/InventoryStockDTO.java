package com.hzchum.scim.operational.analysis.core.api.pojo._dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class InventoryStockDTO {
   @ApiModelProperty(name = "month", value = "月份", notes = "月份")
   @JsonProperty("month")
   @JSONField(name = "month")
   private Integer month;
   @ApiModelProperty(name = "weight", value = "库存重量", notes = "库存重量")
   @JsonProperty("weight")
   @JSONField(name = "weight")
   private BigDecimal weight;
   @ApiModelProperty(name = "amount", value = "库存金额", notes = "库存金额")
   @JsonProperty("amount")
   @JSONField(name = "amount")
   private BigDecimal amount;

   public static InventoryStockDTO.InventoryStockDTOBuilder builder() {
      return new InventoryStockDTO.InventoryStockDTOBuilder();
   }

   public Integer getMonth() {
      return this.month;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   @JsonProperty("month")
   public void setMonth(final Integer month) {
      this.month = month;
   }

   @JsonProperty("weight")
   public void setWeight(final BigDecimal weight) {
      this.weight = weight;
   }

   @JsonProperty("amount")
   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InventoryStockDTO)) {
         return false;
      }

      InventoryStockDTO other = (InventoryStockDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$month = this.getMonth();
      Object other$month = other.getMonth();
      if (this$month == null ? other$month == null : this$month.equals(other$month)) {
         Object this$weight = this.getWeight();
         Object other$weight = other.getWeight();
         if (this$weight == null ? other$weight == null : this$weight.equals(other$weight)) {
            Object this$amount = this.getAmount();
            Object other$amount = other.getAmount();
            return this$amount == null ? other$amount == null : this$amount.equals(other$amount);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof InventoryStockDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $month = this.getMonth();
      result = result * 59 + ($month == null ? 43 : $month.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $amount = this.getAmount();
      return result * 59 + ($amount == null ? 43 : $amount.hashCode());
   }

   @Override
   public String toString() {
      return "InventoryStockDTO(month=" + this.getMonth() + ", weight=" + this.getWeight() + ", amount=" + this.getAmount() + ")";
   }

   public InventoryStockDTO(final Integer month, final BigDecimal weight, final BigDecimal amount) {
      this.month = month;
      this.weight = weight;
      this.amount = amount;
   }

   public InventoryStockDTO() {
   }

   public static class InventoryStockDTOBuilder {
      private Integer month;
      private BigDecimal weight;
      private BigDecimal amount;

      InventoryStockDTOBuilder() {
      }

      @JsonProperty("month")
      public InventoryStockDTO.InventoryStockDTOBuilder month(final Integer month) {
         this.month = month;
         return this;
      }

      @JsonProperty("weight")
      public InventoryStockDTO.InventoryStockDTOBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      @JsonProperty("amount")
      public InventoryStockDTO.InventoryStockDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public InventoryStockDTO build() {
         return new InventoryStockDTO(this.month, this.weight, this.amount);
      }

      @Override
      public String toString() {
         return "InventoryStockDTO.InventoryStockDTOBuilder(month=" + this.month + ", weight=" + this.weight + ", amount=" + this.amount + ")";
      }
   }
}
