package com.hzchum.scim.contract.core.api.pojo.dto.supplier;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import java.time.LocalDate;

@ApiOperation("付款与开票记录详情表")
public class PaymentDetailDto {
   @ApiModelProperty("申请日期")
   private LocalDate applyDate;
   @ApiModelProperty("OA编号")
   private String oaNumber;
   @ApiModelProperty("确认人")
   private String confirmUserName;
   @ApiModelProperty("付款金额")
   private BigDecimal paymentAmount;
   @ApiModelProperty("发票金额")
   private BigDecimal invoiceAmount;

   public LocalDate getApplyDate() {
      return this.applyDate;
   }

   public String getOaNumber() {
      return this.oaNumber;
   }

   public String getConfirmUserName() {
      return this.confirmUserName;
   }

   public BigDecimal getPaymentAmount() {
      return this.paymentAmount;
   }

   public BigDecimal getInvoiceAmount() {
      return this.invoiceAmount;
   }

   public PaymentDetailDto setApplyDate(final LocalDate applyDate) {
      this.applyDate = applyDate;
      return this;
   }

   public PaymentDetailDto setOaNumber(final String oaNumber) {
      this.oaNumber = oaNumber;
      return this;
   }

   public PaymentDetailDto setConfirmUserName(final String confirmUserName) {
      this.confirmUserName = confirmUserName;
      return this;
   }

   public PaymentDetailDto setPaymentAmount(final BigDecimal paymentAmount) {
      this.paymentAmount = paymentAmount;
      return this;
   }

   public PaymentDetailDto setInvoiceAmount(final BigDecimal invoiceAmount) {
      this.invoiceAmount = invoiceAmount;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PaymentDetailDto)) {
         return false;
      }

      PaymentDetailDto other = (PaymentDetailDto)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$applyDate = this.getApplyDate();
      Object other$applyDate = other.getApplyDate();
      if (this$applyDate == null ? other$applyDate == null : this$applyDate.equals(other$applyDate)) {
         Object this$oaNumber = this.getOaNumber();
         Object other$oaNumber = other.getOaNumber();
         if (this$oaNumber == null ? other$oaNumber == null : this$oaNumber.equals(other$oaNumber)) {
            Object this$confirmUserName = this.getConfirmUserName();
            Object other$confirmUserName = other.getConfirmUserName();
            if (this$confirmUserName == null ? other$confirmUserName == null : this$confirmUserName.equals(other$confirmUserName)) {
               Object this$paymentAmount = this.getPaymentAmount();
               Object other$paymentAmount = other.getPaymentAmount();
               if (this$paymentAmount == null ? other$paymentAmount == null : this$paymentAmount.equals(other$paymentAmount)) {
                  Object this$invoiceAmount = this.getInvoiceAmount();
                  Object other$invoiceAmount = other.getInvoiceAmount();
                  return this$invoiceAmount == null ? other$invoiceAmount == null : this$invoiceAmount.equals(other$invoiceAmount);
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
      return other instanceof PaymentDetailDto;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $applyDate = this.getApplyDate();
      result = result * 59 + ($applyDate == null ? 43 : $applyDate.hashCode());
      Object $oaNumber = this.getOaNumber();
      result = result * 59 + ($oaNumber == null ? 43 : $oaNumber.hashCode());
      Object $confirmUserName = this.getConfirmUserName();
      result = result * 59 + ($confirmUserName == null ? 43 : $confirmUserName.hashCode());
      Object $paymentAmount = this.getPaymentAmount();
      result = result * 59 + ($paymentAmount == null ? 43 : $paymentAmount.hashCode());
      Object $invoiceAmount = this.getInvoiceAmount();
      return result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
   }

   @Override
   public String toString() {
      return "PaymentDetailDto(applyDate="
         + this.getApplyDate()
         + ", oaNumber="
         + this.getOaNumber()
         + ", confirmUserName="
         + this.getConfirmUserName()
         + ", paymentAmount="
         + this.getPaymentAmount()
         + ", invoiceAmount="
         + this.getInvoiceAmount()
         + ")";
   }
}
