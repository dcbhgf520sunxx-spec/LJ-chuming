package com.hzchum.scim.contract.core.api.pojo.dto.supplier;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class SupplierSummaryLedgerDTO {
   @ApiModelProperty(notes = "供应商id")
   private Long supplierId;
   @ApiModelProperty(notes = "供应商名称")
   private String supplierName;
   @ApiModelProperty(notes = "总额")
   private BigDecimal totalAmount;
   @ApiModelProperty(notes = "入库额")
   private BigDecimal inboundAmount;
   @ApiModelProperty(notes = "已付款额")
   private BigDecimal paidAmount;
   @ApiModelProperty(notes = "未付款额")
   private BigDecimal unPaidAmount;
   @ApiModelProperty(notes = "付款率")
   private BigDecimal paymentRate;
   @ApiModelProperty(notes = "已收票额")
   private BigDecimal receivedInvoiceAmount;
   @ApiModelProperty(notes = "未收票额")
   private BigDecimal unreceivedInvoiceAmount;
   @ApiModelProperty(notes = "收票率")
   private BigDecimal invoiceRate;

   public static SupplierSummaryLedgerDTO.SupplierSummaryLedgerDTOBuilder builder() {
      return new SupplierSummaryLedgerDTO.SupplierSummaryLedgerDTOBuilder();
   }

   public SupplierSummaryLedgerDTO(
      final Long supplierId,
      final String supplierName,
      final BigDecimal totalAmount,
      final BigDecimal inboundAmount,
      final BigDecimal paidAmount,
      final BigDecimal unPaidAmount,
      final BigDecimal paymentRate,
      final BigDecimal receivedInvoiceAmount,
      final BigDecimal unreceivedInvoiceAmount,
      final BigDecimal invoiceRate
   ) {
      this.supplierId = supplierId;
      this.supplierName = supplierName;
      this.totalAmount = totalAmount;
      this.inboundAmount = inboundAmount;
      this.paidAmount = paidAmount;
      this.unPaidAmount = unPaidAmount;
      this.paymentRate = paymentRate;
      this.receivedInvoiceAmount = receivedInvoiceAmount;
      this.unreceivedInvoiceAmount = unreceivedInvoiceAmount;
      this.invoiceRate = invoiceRate;
   }

   public SupplierSummaryLedgerDTO() {
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public BigDecimal getTotalAmount() {
      return this.totalAmount;
   }

   public BigDecimal getInboundAmount() {
      return this.inboundAmount;
   }

   public BigDecimal getPaidAmount() {
      return this.paidAmount;
   }

   public BigDecimal getUnPaidAmount() {
      return this.unPaidAmount;
   }

   public BigDecimal getPaymentRate() {
      return this.paymentRate;
   }

   public BigDecimal getReceivedInvoiceAmount() {
      return this.receivedInvoiceAmount;
   }

   public BigDecimal getUnreceivedInvoiceAmount() {
      return this.unreceivedInvoiceAmount;
   }

   public BigDecimal getInvoiceRate() {
      return this.invoiceRate;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setTotalAmount(final BigDecimal totalAmount) {
      this.totalAmount = totalAmount;
   }

   public void setInboundAmount(final BigDecimal inboundAmount) {
      this.inboundAmount = inboundAmount;
   }

   public void setPaidAmount(final BigDecimal paidAmount) {
      this.paidAmount = paidAmount;
   }

   public void setUnPaidAmount(final BigDecimal unPaidAmount) {
      this.unPaidAmount = unPaidAmount;
   }

   public void setPaymentRate(final BigDecimal paymentRate) {
      this.paymentRate = paymentRate;
   }

   public void setReceivedInvoiceAmount(final BigDecimal receivedInvoiceAmount) {
      this.receivedInvoiceAmount = receivedInvoiceAmount;
   }

   public void setUnreceivedInvoiceAmount(final BigDecimal unreceivedInvoiceAmount) {
      this.unreceivedInvoiceAmount = unreceivedInvoiceAmount;
   }

   public void setInvoiceRate(final BigDecimal invoiceRate) {
      this.invoiceRate = invoiceRate;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierSummaryLedgerDTO)) {
         return false;
      }

      SupplierSummaryLedgerDTO other = (SupplierSummaryLedgerDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$supplierId = this.getSupplierId();
      Object other$supplierId = other.getSupplierId();
      if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
         Object this$supplierName = this.getSupplierName();
         Object other$supplierName = other.getSupplierName();
         if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
            Object this$totalAmount = this.getTotalAmount();
            Object other$totalAmount = other.getTotalAmount();
            if (this$totalAmount == null ? other$totalAmount == null : this$totalAmount.equals(other$totalAmount)) {
               Object this$inboundAmount = this.getInboundAmount();
               Object other$inboundAmount = other.getInboundAmount();
               if (this$inboundAmount == null ? other$inboundAmount == null : this$inboundAmount.equals(other$inboundAmount)) {
                  Object this$paidAmount = this.getPaidAmount();
                  Object other$paidAmount = other.getPaidAmount();
                  if (this$paidAmount == null ? other$paidAmount == null : this$paidAmount.equals(other$paidAmount)) {
                     Object this$unPaidAmount = this.getUnPaidAmount();
                     Object other$unPaidAmount = other.getUnPaidAmount();
                     if (this$unPaidAmount == null ? other$unPaidAmount == null : this$unPaidAmount.equals(other$unPaidAmount)) {
                        Object this$paymentRate = this.getPaymentRate();
                        Object other$paymentRate = other.getPaymentRate();
                        if (this$paymentRate == null ? other$paymentRate == null : this$paymentRate.equals(other$paymentRate)) {
                           Object this$receivedInvoiceAmount = this.getReceivedInvoiceAmount();
                           Object other$receivedInvoiceAmount = other.getReceivedInvoiceAmount();
                           if (this$receivedInvoiceAmount == null
                              ? other$receivedInvoiceAmount == null
                              : this$receivedInvoiceAmount.equals(other$receivedInvoiceAmount)) {
                              Object this$unreceivedInvoiceAmount = this.getUnreceivedInvoiceAmount();
                              Object other$unreceivedInvoiceAmount = other.getUnreceivedInvoiceAmount();
                              if (this$unreceivedInvoiceAmount == null
                                 ? other$unreceivedInvoiceAmount == null
                                 : this$unreceivedInvoiceAmount.equals(other$unreceivedInvoiceAmount)) {
                                 Object this$invoiceRate = this.getInvoiceRate();
                                 Object other$invoiceRate = other.getInvoiceRate();
                                 return this$invoiceRate == null ? other$invoiceRate == null : this$invoiceRate.equals(other$invoiceRate);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SupplierSummaryLedgerDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $totalAmount = this.getTotalAmount();
      result = result * 59 + ($totalAmount == null ? 43 : $totalAmount.hashCode());
      Object $inboundAmount = this.getInboundAmount();
      result = result * 59 + ($inboundAmount == null ? 43 : $inboundAmount.hashCode());
      Object $paidAmount = this.getPaidAmount();
      result = result * 59 + ($paidAmount == null ? 43 : $paidAmount.hashCode());
      Object $unPaidAmount = this.getUnPaidAmount();
      result = result * 59 + ($unPaidAmount == null ? 43 : $unPaidAmount.hashCode());
      Object $paymentRate = this.getPaymentRate();
      result = result * 59 + ($paymentRate == null ? 43 : $paymentRate.hashCode());
      Object $receivedInvoiceAmount = this.getReceivedInvoiceAmount();
      result = result * 59 + ($receivedInvoiceAmount == null ? 43 : $receivedInvoiceAmount.hashCode());
      Object $unreceivedInvoiceAmount = this.getUnreceivedInvoiceAmount();
      result = result * 59 + ($unreceivedInvoiceAmount == null ? 43 : $unreceivedInvoiceAmount.hashCode());
      Object $invoiceRate = this.getInvoiceRate();
      return result * 59 + ($invoiceRate == null ? 43 : $invoiceRate.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierSummaryLedgerDTO(supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", totalAmount="
         + this.getTotalAmount()
         + ", inboundAmount="
         + this.getInboundAmount()
         + ", paidAmount="
         + this.getPaidAmount()
         + ", unPaidAmount="
         + this.getUnPaidAmount()
         + ", paymentRate="
         + this.getPaymentRate()
         + ", receivedInvoiceAmount="
         + this.getReceivedInvoiceAmount()
         + ", unreceivedInvoiceAmount="
         + this.getUnreceivedInvoiceAmount()
         + ", invoiceRate="
         + this.getInvoiceRate()
         + ")";
   }

   public static class SupplierSummaryLedgerDTOBuilder {
      private Long supplierId;
      private String supplierName;
      private BigDecimal totalAmount;
      private BigDecimal inboundAmount;
      private BigDecimal paidAmount;
      private BigDecimal unPaidAmount;
      private BigDecimal paymentRate;
      private BigDecimal receivedInvoiceAmount;
      private BigDecimal unreceivedInvoiceAmount;
      private BigDecimal invoiceRate;

      SupplierSummaryLedgerDTOBuilder() {
      }

      public SupplierSummaryLedgerDTO.SupplierSummaryLedgerDTOBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public SupplierSummaryLedgerDTO.SupplierSummaryLedgerDTOBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public SupplierSummaryLedgerDTO.SupplierSummaryLedgerDTOBuilder totalAmount(final BigDecimal totalAmount) {
         this.totalAmount = totalAmount;
         return this;
      }

      public SupplierSummaryLedgerDTO.SupplierSummaryLedgerDTOBuilder inboundAmount(final BigDecimal inboundAmount) {
         this.inboundAmount = inboundAmount;
         return this;
      }

      public SupplierSummaryLedgerDTO.SupplierSummaryLedgerDTOBuilder paidAmount(final BigDecimal paidAmount) {
         this.paidAmount = paidAmount;
         return this;
      }

      public SupplierSummaryLedgerDTO.SupplierSummaryLedgerDTOBuilder unPaidAmount(final BigDecimal unPaidAmount) {
         this.unPaidAmount = unPaidAmount;
         return this;
      }

      public SupplierSummaryLedgerDTO.SupplierSummaryLedgerDTOBuilder paymentRate(final BigDecimal paymentRate) {
         this.paymentRate = paymentRate;
         return this;
      }

      public SupplierSummaryLedgerDTO.SupplierSummaryLedgerDTOBuilder receivedInvoiceAmount(final BigDecimal receivedInvoiceAmount) {
         this.receivedInvoiceAmount = receivedInvoiceAmount;
         return this;
      }

      public SupplierSummaryLedgerDTO.SupplierSummaryLedgerDTOBuilder unreceivedInvoiceAmount(final BigDecimal unreceivedInvoiceAmount) {
         this.unreceivedInvoiceAmount = unreceivedInvoiceAmount;
         return this;
      }

      public SupplierSummaryLedgerDTO.SupplierSummaryLedgerDTOBuilder invoiceRate(final BigDecimal invoiceRate) {
         this.invoiceRate = invoiceRate;
         return this;
      }

      public SupplierSummaryLedgerDTO build() {
         return new SupplierSummaryLedgerDTO(
            this.supplierId,
            this.supplierName,
            this.totalAmount,
            this.inboundAmount,
            this.paidAmount,
            this.unPaidAmount,
            this.paymentRate,
            this.receivedInvoiceAmount,
            this.unreceivedInvoiceAmount,
            this.invoiceRate
         );
      }

      @Override
      public String toString() {
         return "SupplierSummaryLedgerDTO.SupplierSummaryLedgerDTOBuilder(supplierId="
            + this.supplierId
            + ", supplierName="
            + this.supplierName
            + ", totalAmount="
            + this.totalAmount
            + ", inboundAmount="
            + this.inboundAmount
            + ", paidAmount="
            + this.paidAmount
            + ", unPaidAmount="
            + this.unPaidAmount
            + ", paymentRate="
            + this.paymentRate
            + ", receivedInvoiceAmount="
            + this.receivedInvoiceAmount
            + ", unreceivedInvoiceAmount="
            + this.unreceivedInvoiceAmount
            + ", invoiceRate="
            + this.invoiceRate
            + ")";
      }
   }
}
