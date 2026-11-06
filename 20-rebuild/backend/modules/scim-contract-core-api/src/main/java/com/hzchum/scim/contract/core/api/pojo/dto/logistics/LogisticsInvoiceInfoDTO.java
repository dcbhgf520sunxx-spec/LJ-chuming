package com.hzchum.scim.contract.core.api.pojo.dto.logistics;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel("物流开票显示信息")
public class LogisticsInvoiceInfoDTO {
   @ApiModelProperty("已付款额")
   private BigDecimal paymentAmount;
   @ApiModelProperty("付款日期")
   private LocalDateTime paymentDate;
   @ApiModelProperty("发票金额")
   private BigDecimal invoiceAmount;
   @ApiModelProperty("开票时间")
   private LocalDateTime invoiceDate;
   @ApiModelProperty("付款id")
   private Long paymentId;

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

   public Long getPaymentId() {
      return this.paymentId;
   }

   public void setPaymentAmount(final BigDecimal paymentAmount) {
      this.paymentAmount = paymentAmount;
   }

   public void setPaymentDate(final LocalDateTime paymentDate) {
      this.paymentDate = paymentDate;
   }

   public void setInvoiceAmount(final BigDecimal invoiceAmount) {
      this.invoiceAmount = invoiceAmount;
   }

   public void setInvoiceDate(final LocalDateTime invoiceDate) {
      this.invoiceDate = invoiceDate;
   }

   public void setPaymentId(final Long paymentId) {
      this.paymentId = paymentId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof LogisticsInvoiceInfoDTO)) {
         return false;
      }

      LogisticsInvoiceInfoDTO other = (LogisticsInvoiceInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$paymentId = this.getPaymentId();
      Object other$paymentId = other.getPaymentId();
      if (this$paymentId == null ? other$paymentId == null : this$paymentId.equals(other$paymentId)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof LogisticsInvoiceInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $paymentId = this.getPaymentId();
      result = result * 59 + ($paymentId == null ? 43 : $paymentId.hashCode());
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
      return "LogisticsInvoiceInfoDTO(paymentAmount="
         + this.getPaymentAmount()
         + ", paymentDate="
         + this.getPaymentDate()
         + ", invoiceAmount="
         + this.getInvoiceAmount()
         + ", invoiceDate="
         + this.getInvoiceDate()
         + ", paymentId="
         + this.getPaymentId()
         + ")";
   }
}
