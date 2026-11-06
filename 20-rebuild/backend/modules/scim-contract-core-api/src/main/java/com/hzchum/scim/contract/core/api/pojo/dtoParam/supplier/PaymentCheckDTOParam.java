package com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.contract.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.contract.core.api.enums.PayTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

@ApiModel(description = "付款审核")
public class PaymentCheckDTOParam {
   @ApiModelProperty(notes = "付款表id")
   @NotNull(message = "id不能为空")
   private Long id;
   @ApiModelProperty(notes = "审核状态 2通过 4不通过")
   @EnumValidator(value = AuditStatusEnum.class, message = "审核状态类型不正确")
   @NotNull(message = "审核状态类型不支持")
   private Integer auditStatus;
   @ApiModelProperty("实付金额")
   private BigDecimal actuallyPaymentAmount;
   @ApiModelProperty("付款方式 1对公转账 2对私转账 4其他 8承兑汇票 16转账支票")
   @EnumValidator(value = PayTypeEnum.class, message = "付款方式不支持")
   private Integer paymentMethod;
   @ApiModelProperty("付款银行")
   private String paymentBank;
   @ApiModelProperty("付款账号")
   private String paymentBankAccount;

   public Long getId() {
      return this.id;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public BigDecimal getActuallyPaymentAmount() {
      return this.actuallyPaymentAmount;
   }

   public Integer getPaymentMethod() {
      return this.paymentMethod;
   }

   public String getPaymentBank() {
      return this.paymentBank;
   }

   public String getPaymentBankAccount() {
      return this.paymentBankAccount;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
   }

   public void setActuallyPaymentAmount(final BigDecimal actuallyPaymentAmount) {
      this.actuallyPaymentAmount = actuallyPaymentAmount;
   }

   public void setPaymentMethod(final Integer paymentMethod) {
      this.paymentMethod = paymentMethod;
   }

   public void setPaymentBank(final String paymentBank) {
      this.paymentBank = paymentBank;
   }

   public void setPaymentBankAccount(final String paymentBankAccount) {
      this.paymentBankAccount = paymentBankAccount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PaymentCheckDTOParam)) {
         return false;
      }

      PaymentCheckDTOParam other = (PaymentCheckDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$auditStatus = this.getAuditStatus();
         Object other$auditStatus = other.getAuditStatus();
         if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
            Object this$paymentMethod = this.getPaymentMethod();
            Object other$paymentMethod = other.getPaymentMethod();
            if (this$paymentMethod == null ? other$paymentMethod == null : this$paymentMethod.equals(other$paymentMethod)) {
               Object this$actuallyPaymentAmount = this.getActuallyPaymentAmount();
               Object other$actuallyPaymentAmount = other.getActuallyPaymentAmount();
               if (this$actuallyPaymentAmount == null ? other$actuallyPaymentAmount == null : this$actuallyPaymentAmount.equals(other$actuallyPaymentAmount)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PaymentCheckDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $paymentMethod = this.getPaymentMethod();
      result = result * 59 + ($paymentMethod == null ? 43 : $paymentMethod.hashCode());
      Object $actuallyPaymentAmount = this.getActuallyPaymentAmount();
      result = result * 59 + ($actuallyPaymentAmount == null ? 43 : $actuallyPaymentAmount.hashCode());
      Object $paymentBank = this.getPaymentBank();
      result = result * 59 + ($paymentBank == null ? 43 : $paymentBank.hashCode());
      Object $paymentBankAccount = this.getPaymentBankAccount();
      return result * 59 + ($paymentBankAccount == null ? 43 : $paymentBankAccount.hashCode());
   }

   @Override
   public String toString() {
      return "PaymentCheckDTOParam(id="
         + this.getId()
         + ", auditStatus="
         + this.getAuditStatus()
         + ", actuallyPaymentAmount="
         + this.getActuallyPaymentAmount()
         + ", paymentMethod="
         + this.getPaymentMethod()
         + ", paymentBank="
         + this.getPaymentBank()
         + ", paymentBankAccount="
         + this.getPaymentBankAccount()
         + ")";
   }
}
