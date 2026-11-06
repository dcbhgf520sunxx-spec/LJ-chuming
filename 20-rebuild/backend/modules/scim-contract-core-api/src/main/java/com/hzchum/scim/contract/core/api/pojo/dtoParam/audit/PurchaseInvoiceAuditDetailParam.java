package com.hzchum.scim.contract.core.api.pojo.dtoParam.audit;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

public class PurchaseInvoiceAuditDetailParam {
   @NotNull(message = "订单id不能为空!")
   @ApiModelProperty("订单id")
   private Long orderId;
   @ApiModelProperty("实开发票金额")
   private BigDecimal actualInvoiceAmount;

   public Long getOrderId() {
      return this.orderId;
   }

   public BigDecimal getActualInvoiceAmount() {
      return this.actualInvoiceAmount;
   }

   public void setOrderId(final Long orderId) {
      this.orderId = orderId;
   }

   public void setActualInvoiceAmount(final BigDecimal actualInvoiceAmount) {
      this.actualInvoiceAmount = actualInvoiceAmount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof PurchaseInvoiceAuditDetailParam)) {
         return false;
      } else {
         PurchaseInvoiceAuditDetailParam other = (PurchaseInvoiceAuditDetailParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$orderId = this.getOrderId();
            Object other$orderId = other.getOrderId();
            if (this$orderId == null ? other$orderId == null : this$orderId.equals(other$orderId)) {
               Object this$actualInvoiceAmount = this.getActualInvoiceAmount();
               Object other$actualInvoiceAmount = other.getActualInvoiceAmount();
               return this$actualInvoiceAmount == null ? other$actualInvoiceAmount == null : this$actualInvoiceAmount.equals(other$actualInvoiceAmount);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PurchaseInvoiceAuditDetailParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderId = this.getOrderId();
      result = result * 59 + ($orderId == null ? 43 : $orderId.hashCode());
      Object $actualInvoiceAmount = this.getActualInvoiceAmount();
      return result * 59 + ($actualInvoiceAmount == null ? 43 : $actualInvoiceAmount.hashCode());
   }

   @Override
   public String toString() {
      return "PurchaseInvoiceAuditDetailParam(orderId=" + this.getOrderId() + ", actualInvoiceAmount=" + this.getActualInvoiceAmount() + ")";
   }
}
