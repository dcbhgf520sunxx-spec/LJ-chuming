package com.hzchum.scim.operational.analysis.core.api.pojo._dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class InventoryDTO {
   @ApiModelProperty(name = "month", value = "月份", notes = "月份")
   @JsonProperty("month")
   @JSONField(name = "month")
   private Integer month;
   @ApiModelProperty(name = "intoAmount", value = "采购金额", notes = "采购金额")
   @JsonProperty("intoAmount")
   @JSONField(name = "intoAmount")
   private BigDecimal intoAmount;
   @ApiModelProperty(name = "outAmount", value = "出库金额", notes = "出库金额")
   @JsonProperty("outAmount")
   @JSONField(name = "outAmount")
   private BigDecimal outAmount;

   public static InventoryDTO.InventoryDTOBuilder builder() {
      return new InventoryDTO.InventoryDTOBuilder();
   }

   public Integer getMonth() {
      return this.month;
   }

   public BigDecimal getIntoAmount() {
      return this.intoAmount;
   }

   public BigDecimal getOutAmount() {
      return this.outAmount;
   }

   @JsonProperty("month")
   public void setMonth(final Integer month) {
      this.month = month;
   }

   @JsonProperty("intoAmount")
   public void setIntoAmount(final BigDecimal intoAmount) {
      this.intoAmount = intoAmount;
   }

   @JsonProperty("outAmount")
   public void setOutAmount(final BigDecimal outAmount) {
      this.outAmount = outAmount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InventoryDTO)) {
         return false;
      }

      InventoryDTO other = (InventoryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$month = this.getMonth();
      Object other$month = other.getMonth();
      if (this$month == null ? other$month == null : this$month.equals(other$month)) {
         Object this$intoAmount = this.getIntoAmount();
         Object other$intoAmount = other.getIntoAmount();
         if (this$intoAmount == null ? other$intoAmount == null : this$intoAmount.equals(other$intoAmount)) {
            Object this$outAmount = this.getOutAmount();
            Object other$outAmount = other.getOutAmount();
            return this$outAmount == null ? other$outAmount == null : this$outAmount.equals(other$outAmount);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof InventoryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $month = this.getMonth();
      result = result * 59 + ($month == null ? 43 : $month.hashCode());
      Object $intoAmount = this.getIntoAmount();
      result = result * 59 + ($intoAmount == null ? 43 : $intoAmount.hashCode());
      Object $outAmount = this.getOutAmount();
      return result * 59 + ($outAmount == null ? 43 : $outAmount.hashCode());
   }

   @Override
   public String toString() {
      return "InventoryDTO(month=" + this.getMonth() + ", intoAmount=" + this.getIntoAmount() + ", outAmount=" + this.getOutAmount() + ")";
   }

   public InventoryDTO(final Integer month, final BigDecimal intoAmount, final BigDecimal outAmount) {
      this.month = month;
      this.intoAmount = intoAmount;
      this.outAmount = outAmount;
   }

   public InventoryDTO() {
   }

   public static class InventoryDTOBuilder {
      private Integer month;
      private BigDecimal intoAmount;
      private BigDecimal outAmount;

      InventoryDTOBuilder() {
      }

      @JsonProperty("month")
      public InventoryDTO.InventoryDTOBuilder month(final Integer month) {
         this.month = month;
         return this;
      }

      @JsonProperty("intoAmount")
      public InventoryDTO.InventoryDTOBuilder intoAmount(final BigDecimal intoAmount) {
         this.intoAmount = intoAmount;
         return this;
      }

      @JsonProperty("outAmount")
      public InventoryDTO.InventoryDTOBuilder outAmount(final BigDecimal outAmount) {
         this.outAmount = outAmount;
         return this;
      }

      public InventoryDTO build() {
         return new InventoryDTO(this.month, this.intoAmount, this.outAmount);
      }

      @Override
      public String toString() {
         return "InventoryDTO.InventoryDTOBuilder(month=" + this.month + ", intoAmount=" + this.intoAmount + ", outAmount=" + this.outAmount + ")";
      }
   }
}
