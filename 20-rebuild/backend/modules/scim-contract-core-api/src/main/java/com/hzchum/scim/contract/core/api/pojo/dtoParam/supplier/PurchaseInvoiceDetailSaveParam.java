package com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

public class PurchaseInvoiceDetailSaveParam {
   @NotNull(message = "订单id不能为空!")
   @ApiModelProperty("订单id")
   private Long orderId;
   @NotNull(message = "申请发票金额不能为空!")
   @ApiModelProperty("申请发票金额")
   private BigDecimal invoiceAmount;

   public Long getOrderId() {
      return this.orderId;
   }

   public BigDecimal getInvoiceAmount() {
      return this.invoiceAmount;
   }

   public void setOrderId(final Long orderId) {
      this.orderId = orderId;
   }

   public void setInvoiceAmount(final BigDecimal invoiceAmount) {
      this.invoiceAmount = invoiceAmount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof PurchaseInvoiceDetailSaveParam)) {
         return false;
      } else {
         PurchaseInvoiceDetailSaveParam other = (PurchaseInvoiceDetailSaveParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$orderId = this.getOrderId();
            Object other$orderId = other.getOrderId();
            if (this$orderId == null ? other$orderId == null : this$orderId.equals(other$orderId)) {
               Object this$invoiceAmount = this.getInvoiceAmount();
               Object other$invoiceAmount = other.getInvoiceAmount();
               return this$invoiceAmount == null ? other$invoiceAmount == null : this$invoiceAmount.equals(other$invoiceAmount);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PurchaseInvoiceDetailSaveParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderId = this.getOrderId();
      result = result * 59 + ($orderId == null ? 43 : $orderId.hashCode());
      Object $invoiceAmount = this.getInvoiceAmount();
      return result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
   }

   @Override
   public String toString() {
      return "PurchaseInvoiceDetailSaveParam(orderId=" + this.getOrderId() + ", invoiceAmount=" + this.getInvoiceAmount() + ")";
   }
}
