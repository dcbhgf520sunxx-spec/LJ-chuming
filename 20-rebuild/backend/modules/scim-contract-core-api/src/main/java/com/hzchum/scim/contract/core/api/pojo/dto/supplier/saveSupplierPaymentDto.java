package com.hzchum.scim.contract.core.api.pojo.dto.supplier;

import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;

@ApiOperation("自合营付款-合同信息返回")
public class saveSupplierPaymentDto {
   private Long supplierPaymentId;
   private BigDecimal moneyAmount;

   public Long getSupplierPaymentId() {
      return this.supplierPaymentId;
   }

   public BigDecimal getMoneyAmount() {
      return this.moneyAmount;
   }

   public void setSupplierPaymentId(final Long supplierPaymentId) {
      this.supplierPaymentId = supplierPaymentId;
   }

   public void setMoneyAmount(final BigDecimal moneyAmount) {
      this.moneyAmount = moneyAmount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof saveSupplierPaymentDto)) {
         return false;
      } else {
         saveSupplierPaymentDto other = (saveSupplierPaymentDto)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$supplierPaymentId = this.getSupplierPaymentId();
            Object other$supplierPaymentId = other.getSupplierPaymentId();
            if (this$supplierPaymentId == null ? other$supplierPaymentId == null : this$supplierPaymentId.equals(other$supplierPaymentId)) {
               Object this$moneyAmount = this.getMoneyAmount();
               Object other$moneyAmount = other.getMoneyAmount();
               return this$moneyAmount == null ? other$moneyAmount == null : this$moneyAmount.equals(other$moneyAmount);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof saveSupplierPaymentDto;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $supplierPaymentId = this.getSupplierPaymentId();
      result = result * 59 + ($supplierPaymentId == null ? 43 : $supplierPaymentId.hashCode());
      Object $moneyAmount = this.getMoneyAmount();
      return result * 59 + ($moneyAmount == null ? 43 : $moneyAmount.hashCode());
   }

   @Override
   public String toString() {
      return "saveSupplierPaymentDto(supplierPaymentId=" + this.getSupplierPaymentId() + ", moneyAmount=" + this.getMoneyAmount() + ")";
   }
}
