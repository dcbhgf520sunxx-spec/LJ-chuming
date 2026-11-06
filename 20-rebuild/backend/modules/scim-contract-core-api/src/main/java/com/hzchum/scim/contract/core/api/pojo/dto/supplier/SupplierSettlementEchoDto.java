package com.hzchum.scim.contract.core.api.pojo.dto.supplier;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel("付款开票信息回显（内包制and自合营通用）")
public class SupplierSettlementEchoDto {
   @ApiModelProperty("付款金额")
   private BigDecimal paymentAmount;
   @ApiModelProperty("付款日期")
   private LocalDateTime paymentDate;
   @ApiModelProperty("开票金额")
   private BigDecimal invoiceAmount;
   @ApiModelProperty("开票日期")
   private LocalDateTime invoiceDate;

   public static SupplierSettlementEchoDto.SupplierSettlementEchoDtoBuilder builder() {
      return new SupplierSettlementEchoDto.SupplierSettlementEchoDtoBuilder();
   }

   public BigDecimal getPaymentAmount() {
      return this.paymentAmount;
   }

   public LocalDateTime getPaymentDate() {
      return this.paymentDate;
   }

   public BigDecimal getInvoiceAmount() {
      return this.invoiceAmount;
   }

   public LocalDateTime getInvoiceDate() {
      return this.invoiceDate;
   }

   public SupplierSettlementEchoDto setPaymentAmount(final BigDecimal paymentAmount) {
      this.paymentAmount = paymentAmount;
      return this;
   }

   public SupplierSettlementEchoDto setPaymentDate(final LocalDateTime paymentDate) {
      this.paymentDate = paymentDate;
      return this;
   }

   public SupplierSettlementEchoDto setInvoiceAmount(final BigDecimal invoiceAmount) {
      this.invoiceAmount = invoiceAmount;
      return this;
   }

   public SupplierSettlementEchoDto setInvoiceDate(final LocalDateTime invoiceDate) {
      this.invoiceDate = invoiceDate;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierSettlementEchoDto)) {
         return false;
      }

      SupplierSettlementEchoDto other = (SupplierSettlementEchoDto)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$paymentAmount = this.getPaymentAmount();
      Object other$paymentAmount = other.getPaymentAmount();
      if (this$paymentAmount == null ? other$paymentAmount == null : this$paymentAmount.equals(other$paymentAmount)) {
         Object this$paymentDate = this.getPaymentDate();
         Object other$paymentDate = other.getPaymentDate();
         if (this$paymentDate == null ? other$paymentDate == null : this$paymentDate.equals(other$paymentDate)) {
            Object this$invoiceAmount = this.getInvoiceAmount();
            Object other$invoiceAmount = other.getInvoiceAmount();
            if (this$invoiceAmount == null ? other$invoiceAmount == null : this$invoiceAmount.equals(other$invoiceAmount)) {
               Object this$invoiceDate = this.getInvoiceDate();
               Object other$invoiceDate = other.getInvoiceDate();
               return this$invoiceDate == null ? other$invoiceDate == null : this$invoiceDate.equals(other$invoiceDate);
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
      return other instanceof SupplierSettlementEchoDto;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $paymentAmount = this.getPaymentAmount();
      result = result * 59 + ($paymentAmount == null ? 43 : $paymentAmount.hashCode());
      Object $paymentDate = this.getPaymentDate();
      result = result * 59 + ($paymentDate == null ? 43 : $paymentDate.hashCode());
      Object $invoiceAmount = this.getInvoiceAmount();
      result = result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
      Object $invoiceDate = this.getInvoiceDate();
      return result * 59 + ($invoiceDate == null ? 43 : $invoiceDate.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierSettlementEchoDto(paymentAmount="
         + this.getPaymentAmount()
         + ", paymentDate="
         + this.getPaymentDate()
         + ", invoiceAmount="
         + this.getInvoiceAmount()
         + ", invoiceDate="
         + this.getInvoiceDate()
         + ")";
   }

   public SupplierSettlementEchoDto(
      final BigDecimal paymentAmount, final LocalDateTime paymentDate, final BigDecimal invoiceAmount, final LocalDateTime invoiceDate
   ) {
      this.paymentAmount = paymentAmount;
      this.paymentDate = paymentDate;
      this.invoiceAmount = invoiceAmount;
      this.invoiceDate = invoiceDate;
   }

   public SupplierSettlementEchoDto() {
   }

   public static class SupplierSettlementEchoDtoBuilder {
      private BigDecimal paymentAmount;
      private LocalDateTime paymentDate;
      private BigDecimal invoiceAmount;
      private LocalDateTime invoiceDate;

      SupplierSettlementEchoDtoBuilder() {
      }

      public SupplierSettlementEchoDto.SupplierSettlementEchoDtoBuilder paymentAmount(final BigDecimal paymentAmount) {
         this.paymentAmount = paymentAmount;
         return this;
      }

      public SupplierSettlementEchoDto.SupplierSettlementEchoDtoBuilder paymentDate(final LocalDateTime paymentDate) {
         this.paymentDate = paymentDate;
         return this;
      }

      public SupplierSettlementEchoDto.SupplierSettlementEchoDtoBuilder invoiceAmount(final BigDecimal invoiceAmount) {
         this.invoiceAmount = invoiceAmount;
         return this;
      }

      public SupplierSettlementEchoDto.SupplierSettlementEchoDtoBuilder invoiceDate(final LocalDateTime invoiceDate) {
         this.invoiceDate = invoiceDate;
         return this;
      }

      public SupplierSettlementEchoDto build() {
         return new SupplierSettlementEchoDto(this.paymentAmount, this.paymentDate, this.invoiceAmount, this.invoiceDate);
      }

      @Override
      public String toString() {
         return "SupplierSettlementEchoDto.SupplierSettlementEchoDtoBuilder(paymentAmount="
            + this.paymentAmount
            + ", paymentDate="
            + this.paymentDate
            + ", invoiceAmount="
            + this.invoiceAmount
            + ", invoiceDate="
            + this.invoiceDate
            + ")";
      }
   }
}
