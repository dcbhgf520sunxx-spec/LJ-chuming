package com.hzchum.scim.contract.core.api.pojo.dto.logistics;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class LogisticsListDto {
   @ApiModelProperty("物流单位")
   private String supplierName;
   @ApiModelProperty("历史记录")
   private String history;
   @ApiModelProperty("累计运费")
   private String freight;
   @ApiModelProperty("上年度运费")
   private BigDecimal lastYearFreight;
   @ApiModelProperty("本年度运费")
   private BigDecimal thisYearFreight;
   @ApiModelProperty("累计付款")
   private String payment;
   @ApiModelProperty("累计开票")
   private String invoice;

   public String getSupplierName() {
      return this.supplierName;
   }

   public String getHistory() {
      return this.history;
   }

   public String getFreight() {
      return this.freight;
   }

   public BigDecimal getLastYearFreight() {
      return this.lastYearFreight;
   }

   public BigDecimal getThisYearFreight() {
      return this.thisYearFreight;
   }

   public String getPayment() {
      return this.payment;
   }

   public String getInvoice() {
      return this.invoice;
   }

   public LogisticsListDto setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
      return this;
   }

   public LogisticsListDto setHistory(final String history) {
      this.history = history;
      return this;
   }

   public LogisticsListDto setFreight(final String freight) {
      this.freight = freight;
      return this;
   }

   public LogisticsListDto setLastYearFreight(final BigDecimal lastYearFreight) {
      this.lastYearFreight = lastYearFreight;
      return this;
   }

   public LogisticsListDto setThisYearFreight(final BigDecimal thisYearFreight) {
      this.thisYearFreight = thisYearFreight;
      return this;
   }

   public LogisticsListDto setPayment(final String payment) {
      this.payment = payment;
      return this;
   }

   public LogisticsListDto setInvoice(final String invoice) {
      this.invoice = invoice;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof LogisticsListDto)) {
         return false;
      }

      LogisticsListDto other = (LogisticsListDto)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$supplierName = this.getSupplierName();
      Object other$supplierName = other.getSupplierName();
      if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
         Object this$history = this.getHistory();
         Object other$history = other.getHistory();
         if (this$history == null ? other$history == null : this$history.equals(other$history)) {
            Object this$freight = this.getFreight();
            Object other$freight = other.getFreight();
            if (this$freight == null ? other$freight == null : this$freight.equals(other$freight)) {
               Object this$lastYearFreight = this.getLastYearFreight();
               Object other$lastYearFreight = other.getLastYearFreight();
               if (this$lastYearFreight == null ? other$lastYearFreight == null : this$lastYearFreight.equals(other$lastYearFreight)) {
                  Object this$thisYearFreight = this.getThisYearFreight();
                  Object other$thisYearFreight = other.getThisYearFreight();
                  if (this$thisYearFreight == null ? other$thisYearFreight == null : this$thisYearFreight.equals(other$thisYearFreight)) {
                     Object this$payment = this.getPayment();
                     Object other$payment = other.getPayment();
                     if (this$payment == null ? other$payment == null : this$payment.equals(other$payment)) {
                        Object this$invoice = this.getInvoice();
                        Object other$invoice = other.getInvoice();
                        return this$invoice == null ? other$invoice == null : this$invoice.equals(other$invoice);
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
      return other instanceof LogisticsListDto;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $history = this.getHistory();
      result = result * 59 + ($history == null ? 43 : $history.hashCode());
      Object $freight = this.getFreight();
      result = result * 59 + ($freight == null ? 43 : $freight.hashCode());
      Object $lastYearFreight = this.getLastYearFreight();
      result = result * 59 + ($lastYearFreight == null ? 43 : $lastYearFreight.hashCode());
      Object $thisYearFreight = this.getThisYearFreight();
      result = result * 59 + ($thisYearFreight == null ? 43 : $thisYearFreight.hashCode());
      Object $payment = this.getPayment();
      result = result * 59 + ($payment == null ? 43 : $payment.hashCode());
      Object $invoice = this.getInvoice();
      return result * 59 + ($invoice == null ? 43 : $invoice.hashCode());
   }

   @Override
   public String toString() {
      return "LogisticsListDto(supplierName="
         + this.getSupplierName()
         + ", history="
         + this.getHistory()
         + ", freight="
         + this.getFreight()
         + ", lastYearFreight="
         + this.getLastYearFreight()
         + ", thisYearFreight="
         + this.getThisYearFreight()
         + ", payment="
         + this.getPayment()
         + ", invoice="
         + this.getInvoice()
         + ")";
   }

   public LogisticsListDto(
      final String supplierName,
      final String history,
      final String freight,
      final BigDecimal lastYearFreight,
      final BigDecimal thisYearFreight,
      final String payment,
      final String invoice
   ) {
      this.supplierName = supplierName;
      this.history = history;
      this.freight = freight;
      this.lastYearFreight = lastYearFreight;
      this.thisYearFreight = thisYearFreight;
      this.payment = payment;
      this.invoice = invoice;
   }

   public LogisticsListDto() {
   }
}
