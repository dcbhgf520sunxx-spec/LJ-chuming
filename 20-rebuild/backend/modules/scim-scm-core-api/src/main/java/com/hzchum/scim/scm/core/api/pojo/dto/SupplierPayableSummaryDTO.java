package com.hzchum.scim.scm.core.api.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("应付汇总类")
public class SupplierPayableSummaryDTO {
   @ApiModelProperty("供应商id")
   private Long supplierId;
   @ApiModelProperty("供应商名称")
   private String supplierName;
   @ApiModelProperty("供应商分类")
   private Integer supplierClassification;
   @ApiModelProperty("合同额")
   private BigDecimal amount;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty("结算额")
   private BigDecimal settlementAmount;
   @ApiModelProperty("付款额")
   private BigDecimal paymentAmount;
   @ApiModelProperty("未付款额")
   private BigDecimal unPaymentAmount;
   @ApiModelProperty("收票额")
   private BigDecimal invoiceAmount;
   @ApiModelProperty("未收票额")
   private BigDecimal unInvoiceAmount;

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public Integer getSupplierClassification() {
      return this.supplierClassification;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getSettlementAmount() {
      return this.settlementAmount;
   }

   public BigDecimal getPaymentAmount() {
      return this.paymentAmount;
   }

   public BigDecimal getUnPaymentAmount() {
      return this.unPaymentAmount;
   }

   public BigDecimal getInvoiceAmount() {
      return this.invoiceAmount;
   }

   public BigDecimal getUnInvoiceAmount() {
      return this.unInvoiceAmount;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setSupplierClassification(final Integer supplierClassification) {
      this.supplierClassification = supplierClassification;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setSettlementAmount(final BigDecimal settlementAmount) {
      this.settlementAmount = settlementAmount;
   }

   public void setPaymentAmount(final BigDecimal paymentAmount) {
      this.paymentAmount = paymentAmount;
   }

   public void setUnPaymentAmount(final BigDecimal unPaymentAmount) {
      this.unPaymentAmount = unPaymentAmount;
   }

   public void setInvoiceAmount(final BigDecimal invoiceAmount) {
      this.invoiceAmount = invoiceAmount;
   }

   public void setUnInvoiceAmount(final BigDecimal unInvoiceAmount) {
      this.unInvoiceAmount = unInvoiceAmount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierPayableSummaryDTO)) {
         return false;
      }

      SupplierPayableSummaryDTO other = (SupplierPayableSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$supplierId = this.getSupplierId();
      Object other$supplierId = other.getSupplierId();
      if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
         Object this$supplierClassification = this.getSupplierClassification();
         Object other$supplierClassification = other.getSupplierClassification();
         if (this$supplierClassification == null ? other$supplierClassification == null : this$supplierClassification.equals(other$supplierClassification)) {
            Object this$supplierName = this.getSupplierName();
            Object other$supplierName = other.getSupplierName();
            if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
               Object this$amount = this.getAmount();
               Object other$amount = other.getAmount();
               if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                  Object this$settlementAmount = this.getSettlementAmount();
                  Object other$settlementAmount = other.getSettlementAmount();
                  if (this$settlementAmount == null ? other$settlementAmount == null : this$settlementAmount.equals(other$settlementAmount)) {
                     Object this$paymentAmount = this.getPaymentAmount();
                     Object other$paymentAmount = other.getPaymentAmount();
                     if (this$paymentAmount == null ? other$paymentAmount == null : this$paymentAmount.equals(other$paymentAmount)) {
                        Object this$unPaymentAmount = this.getUnPaymentAmount();
                        Object other$unPaymentAmount = other.getUnPaymentAmount();
                        if (this$unPaymentAmount == null ? other$unPaymentAmount == null : this$unPaymentAmount.equals(other$unPaymentAmount)) {
                           Object this$invoiceAmount = this.getInvoiceAmount();
                           Object other$invoiceAmount = other.getInvoiceAmount();
                           if (this$invoiceAmount == null ? other$invoiceAmount == null : this$invoiceAmount.equals(other$invoiceAmount)) {
                              Object this$unInvoiceAmount = this.getUnInvoiceAmount();
                              Object other$unInvoiceAmount = other.getUnInvoiceAmount();
                              return this$unInvoiceAmount == null ? other$unInvoiceAmount == null : this$unInvoiceAmount.equals(other$unInvoiceAmount);
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof SupplierPayableSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $supplierClassification = this.getSupplierClassification();
      result = result * 59 + ($supplierClassification == null ? 43 : $supplierClassification.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $settlementAmount = this.getSettlementAmount();
      result = result * 59 + ($settlementAmount == null ? 43 : $settlementAmount.hashCode());
      Object $paymentAmount = this.getPaymentAmount();
      result = result * 59 + ($paymentAmount == null ? 43 : $paymentAmount.hashCode());
      Object $unPaymentAmount = this.getUnPaymentAmount();
      result = result * 59 + ($unPaymentAmount == null ? 43 : $unPaymentAmount.hashCode());
      Object $invoiceAmount = this.getInvoiceAmount();
      result = result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
      Object $unInvoiceAmount = this.getUnInvoiceAmount();
      return result * 59 + ($unInvoiceAmount == null ? 43 : $unInvoiceAmount.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierPayableSummaryDTO(supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", supplierClassification="
         + this.getSupplierClassification()
         + ", amount="
         + this.getAmount()
         + ", settlementAmount="
         + this.getSettlementAmount()
         + ", paymentAmount="
         + this.getPaymentAmount()
         + ", unPaymentAmount="
         + this.getUnPaymentAmount()
         + ", invoiceAmount="
         + this.getInvoiceAmount()
         + ", unInvoiceAmount="
         + this.getUnInvoiceAmount()
         + ")";
   }
}
