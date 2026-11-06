package com.hzchum.scim.scm.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("分包订单汇总")
public class SubcontractOrderSummaryDTO {
   @ApiModelProperty(name = "amount", value = "合同总金额", notes = "合同总金额")
   private BigDecimal amount;
   @ApiModelProperty(name = "orderQuantity", value = "订单数", notes = "订单数")
   private int orderQuantity;
   @ApiModelProperty(name = "unSettlementQuantity", value = "未结算订单数", notes = "未结算订单数")
   private int unSettlementQuantity;
   @ApiModelProperty(name = "settlementQuantity", value = "已结算订单数", notes = "已结算订单数")
   private int settlementQuantity;
   @ApiModelProperty(name = "settlementAmount", value = "结算总额", notes = "结算总额")
   private BigDecimal settlementAmount;

   public static SubcontractOrderSummaryDTO.SubcontractOrderSummaryDTOBuilder builder() {
      return new SubcontractOrderSummaryDTO.SubcontractOrderSummaryDTOBuilder();
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public int getOrderQuantity() {
      return this.orderQuantity;
   }

   public int getUnSettlementQuantity() {
      return this.unSettlementQuantity;
   }

   public int getSettlementQuantity() {
      return this.settlementQuantity;
   }

   public BigDecimal getSettlementAmount() {
      return this.settlementAmount;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setOrderQuantity(final int orderQuantity) {
      this.orderQuantity = orderQuantity;
   }

   public void setUnSettlementQuantity(final int unSettlementQuantity) {
      this.unSettlementQuantity = unSettlementQuantity;
   }

   public void setSettlementQuantity(final int settlementQuantity) {
      this.settlementQuantity = settlementQuantity;
   }

   public void setSettlementAmount(final BigDecimal settlementAmount) {
      this.settlementAmount = settlementAmount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof SubcontractOrderSummaryDTO)) {
         return false;
      } else {
         SubcontractOrderSummaryDTO other = (SubcontractOrderSummaryDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (this.getOrderQuantity() != other.getOrderQuantity()) {
            return false;
         } else if (this.getUnSettlementQuantity() != other.getUnSettlementQuantity()) {
            return false;
         } else if (this.getSettlementQuantity() != other.getSettlementQuantity()) {
            return false;
         } else {
            Object this$amount = this.getAmount();
            Object other$amount = other.getAmount();
            if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
               Object this$settlementAmount = this.getSettlementAmount();
               Object other$settlementAmount = other.getSettlementAmount();
               return this$settlementAmount == null ? other$settlementAmount == null : this$settlementAmount.equals(other$settlementAmount);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SubcontractOrderSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getOrderQuantity();
      result = result * 59 + this.getUnSettlementQuantity();
      result = result * 59 + this.getSettlementQuantity();
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $settlementAmount = this.getSettlementAmount();
      return result * 59 + ($settlementAmount == null ? 43 : $settlementAmount.hashCode());
   }

   @Override
   public String toString() {
      return "SubcontractOrderSummaryDTO(amount="
         + this.getAmount()
         + ", orderQuantity="
         + this.getOrderQuantity()
         + ", unSettlementQuantity="
         + this.getUnSettlementQuantity()
         + ", settlementQuantity="
         + this.getSettlementQuantity()
         + ", settlementAmount="
         + this.getSettlementAmount()
         + ")";
   }

   public SubcontractOrderSummaryDTO(
      final BigDecimal amount, final int orderQuantity, final int unSettlementQuantity, final int settlementQuantity, final BigDecimal settlementAmount
   ) {
      this.amount = amount;
      this.orderQuantity = orderQuantity;
      this.unSettlementQuantity = unSettlementQuantity;
      this.settlementQuantity = settlementQuantity;
      this.settlementAmount = settlementAmount;
   }

   public SubcontractOrderSummaryDTO() {
   }

   public static class SubcontractOrderSummaryDTOBuilder {
      private BigDecimal amount;
      private int orderQuantity;
      private int unSettlementQuantity;
      private int settlementQuantity;
      private BigDecimal settlementAmount;

      SubcontractOrderSummaryDTOBuilder() {
      }

      public SubcontractOrderSummaryDTO.SubcontractOrderSummaryDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public SubcontractOrderSummaryDTO.SubcontractOrderSummaryDTOBuilder orderQuantity(final int orderQuantity) {
         this.orderQuantity = orderQuantity;
         return this;
      }

      public SubcontractOrderSummaryDTO.SubcontractOrderSummaryDTOBuilder unSettlementQuantity(final int unSettlementQuantity) {
         this.unSettlementQuantity = unSettlementQuantity;
         return this;
      }

      public SubcontractOrderSummaryDTO.SubcontractOrderSummaryDTOBuilder settlementQuantity(final int settlementQuantity) {
         this.settlementQuantity = settlementQuantity;
         return this;
      }

      public SubcontractOrderSummaryDTO.SubcontractOrderSummaryDTOBuilder settlementAmount(final BigDecimal settlementAmount) {
         this.settlementAmount = settlementAmount;
         return this;
      }

      public SubcontractOrderSummaryDTO build() {
         return new SubcontractOrderSummaryDTO(this.amount, this.orderQuantity, this.unSettlementQuantity, this.settlementQuantity, this.settlementAmount);
      }

      @Override
      public String toString() {
         return "SubcontractOrderSummaryDTO.SubcontractOrderSummaryDTOBuilder(amount="
            + this.amount
            + ", orderQuantity="
            + this.orderQuantity
            + ", unSettlementQuantity="
            + this.unSettlementQuantity
            + ", settlementQuantity="
            + this.settlementQuantity
            + ", settlementAmount="
            + this.settlementAmount
            + ")";
      }
   }
}
