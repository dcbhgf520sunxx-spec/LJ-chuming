package com.hzchum.scim.contract.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("承兑汇票类")
public class AcceptanceDraftDTO {
   @ApiModelProperty("承兑面额")
   private BigDecimal amount;
   @ApiModelProperty("贴现面额")
   private BigDecimal discount;

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getDiscount() {
      return this.discount;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setDiscount(final BigDecimal discount) {
      this.discount = discount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof AcceptanceDraftDTO)) {
         return false;
      } else {
         AcceptanceDraftDTO other = (AcceptanceDraftDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$amount = this.getAmount();
            Object other$amount = other.getAmount();
            if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
               Object this$discount = this.getDiscount();
               Object other$discount = other.getDiscount();
               return this$discount == null ? other$discount == null : this$discount.equals(other$discount);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AcceptanceDraftDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $discount = this.getDiscount();
      return result * 59 + ($discount == null ? 43 : $discount.hashCode());
   }

   @Override
   public String toString() {
      return "AcceptanceDraftDTO(amount=" + this.getAmount() + ", discount=" + this.getDiscount() + ")";
   }
}
