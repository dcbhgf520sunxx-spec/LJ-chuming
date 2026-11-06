package com.hzchum.scim.contract.core.api.pojo.dto.audit;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel("PaymentCommon")
public class PaymentCommon {
   @NotNull(message = "本次付款额不能为空")
   @ApiModelProperty("本次付款额")
   private BigDecimal actualPayment;
   @ApiModelProperty("付款事由id")
   @NotBlank(message = "付款事由不能为空")
   private String paymentReasonId;
   @NotNull(message = "付款银行不能为空")
   @ApiModelProperty("付款银行")
   private String paymentBank;
   @NotNull(message = "付款账号不能为空")
   @ApiModelProperty("付款账号")
   private String paymentBankAccount;
   @ApiModelProperty("附件id")
   private Long attachmentId;

   public PaymentCommon() {
   }

   public PaymentCommon(
      final BigDecimal actualPayment, final String paymentReasonId, final String paymentBank, final String paymentBankAccount, final Long attachmentId
   ) {
      this.actualPayment = actualPayment;
      this.paymentReasonId = paymentReasonId;
      this.paymentBank = paymentBank;
      this.paymentBankAccount = paymentBankAccount;
      this.attachmentId = attachmentId;
   }

   public BigDecimal getActualPayment() {
      return this.actualPayment;
   }

   public String getPaymentReasonId() {
      return this.paymentReasonId;
   }

   public String getPaymentBank() {
      return this.paymentBank;
   }

   public String getPaymentBankAccount() {
      return this.paymentBankAccount;
   }

   public Long getAttachmentId() {
      return this.attachmentId;
   }

   public PaymentCommon setActualPayment(final BigDecimal actualPayment) {
      this.actualPayment = actualPayment;
      return this;
   }

   public PaymentCommon setPaymentReasonId(final String paymentReasonId) {
      this.paymentReasonId = paymentReasonId;
      return this;
   }

   public PaymentCommon setPaymentBank(final String paymentBank) {
      this.paymentBank = paymentBank;
      return this;
   }

   public PaymentCommon setPaymentBankAccount(final String paymentBankAccount) {
      this.paymentBankAccount = paymentBankAccount;
      return this;
   }

   public PaymentCommon setAttachmentId(final Long attachmentId) {
      this.attachmentId = attachmentId;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PaymentCommon)) {
         return false;
      }

      PaymentCommon other = (PaymentCommon)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$attachmentId = this.getAttachmentId();
      Object other$attachmentId = other.getAttachmentId();
      if (this$attachmentId == null ? other$attachmentId == null : this$attachmentId.equals(other$attachmentId)) {
         Object this$actualPayment = this.getActualPayment();
         Object other$actualPayment = other.getActualPayment();
         if (this$actualPayment == null ? other$actualPayment == null : this$actualPayment.equals(other$actualPayment)) {
            Object this$paymentReasonId = this.getPaymentReasonId();
            Object other$paymentReasonId = other.getPaymentReasonId();
            if (this$paymentReasonId == null ? other$paymentReasonId == null : this$paymentReasonId.equals(other$paymentReasonId)) {
               Object this$paymentBank = this.getPaymentBank();
               Object other$paymentBank = other.getPaymentBank();
               if (this$paymentBank == null ? other$paymentBank == null : this$paymentBank.equals(other$paymentBank)) {
                  Object this$paymentBankAccount = this.getPaymentBankAccount();
                  Object other$paymentBankAccount = other.getPaymentBankAccount();
                  return this$paymentBankAccount == null ? other$paymentBankAccount == null : this$paymentBankAccount.equals(other$paymentBankAccount);
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
      return other instanceof PaymentCommon;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $attachmentId = this.getAttachmentId();
      result = result * 59 + ($attachmentId == null ? 43 : $attachmentId.hashCode());
      Object $actualPayment = this.getActualPayment();
      result = result * 59 + ($actualPayment == null ? 43 : $actualPayment.hashCode());
      Object $paymentReasonId = this.getPaymentReasonId();
      result = result * 59 + ($paymentReasonId == null ? 43 : $paymentReasonId.hashCode());
      Object $paymentBank = this.getPaymentBank();
      result = result * 59 + ($paymentBank == null ? 43 : $paymentBank.hashCode());
      Object $paymentBankAccount = this.getPaymentBankAccount();
      return result * 59 + ($paymentBankAccount == null ? 43 : $paymentBankAccount.hashCode());
   }

   @Override
   public String toString() {
      return "PaymentCommon(actualPayment="
         + this.getActualPayment()
         + ", paymentReasonId="
         + this.getPaymentReasonId()
         + ", paymentBank="
         + this.getPaymentBank()
         + ", paymentBankAccount="
         + this.getPaymentBankAccount()
         + ", attachmentId="
         + this.getAttachmentId()
         + ")";
   }
}
