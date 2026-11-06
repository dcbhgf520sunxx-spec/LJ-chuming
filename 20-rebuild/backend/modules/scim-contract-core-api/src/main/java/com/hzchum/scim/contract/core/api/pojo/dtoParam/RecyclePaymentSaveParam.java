package com.hzchum.scim.contract.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel("新增回收付款类")
public class RecyclePaymentSaveParam {
   @ApiModelProperty("付款日期")
   @NotNull(message = "付款日期不能为空")
   private LocalDate paymentDate;
   @ApiModelProperty("付款单位id")
   @NotNull(message = "付款单位id不能为空")
   private Long branchCompanyId;
   @ApiModelProperty("收款单位(出售方)")
   @NotBlank(message = "收款单位不能为空")
   private String customerUnit;
   @ApiModelProperty("收款银行")
   private String receiveBank;
   @ApiModelProperty("收款账号")
   private String receiveBankAccount;
   @ApiModelProperty("付款方式")
   @NotNull(message = "支付方式不能为空!")
   private Integer paymentMethod;
   @ApiModelProperty("付款银行")
   private String paymentBank;
   @ApiModelProperty("付款账号")
   private String paymentBankAccount;
   @ApiModelProperty("付款金额")
   @NotNull(message = "付款金额不能为空")
   private BigDecimal applyAmount;
   @ApiModelProperty("付款事由id")
   @NotBlank(message = "付款事由不能为空")
   private String paymentReasonId;
   @ApiModelProperty("附件ids")
   private List<Long> attachmentIds;
   @ApiModelProperty("备注")
   @Size(max = 250, message = "备注字数太多,超出限制!")
   private String remark;

   public LocalDate getPaymentDate() {
      return this.paymentDate;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public String getCustomerUnit() {
      return this.customerUnit;
   }

   public String getReceiveBank() {
      return this.receiveBank;
   }

   public String getReceiveBankAccount() {
      return this.receiveBankAccount;
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

   public BigDecimal getApplyAmount() {
      return this.applyAmount;
   }

   public String getPaymentReasonId() {
      return this.paymentReasonId;
   }

   public List<Long> getAttachmentIds() {
      return this.attachmentIds;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setPaymentDate(final LocalDate paymentDate) {
      this.paymentDate = paymentDate;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setCustomerUnit(final String customerUnit) {
      this.customerUnit = customerUnit;
   }

   public void setReceiveBank(final String receiveBank) {
      this.receiveBank = receiveBank;
   }

   public void setReceiveBankAccount(final String receiveBankAccount) {
      this.receiveBankAccount = receiveBankAccount;
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

   public void setApplyAmount(final BigDecimal applyAmount) {
      this.applyAmount = applyAmount;
   }

   public void setPaymentReasonId(final String paymentReasonId) {
      this.paymentReasonId = paymentReasonId;
   }

   public void setAttachmentIds(final List<Long> attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof RecyclePaymentSaveParam)) {
         return false;
      }

      RecyclePaymentSaveParam other = (RecyclePaymentSaveParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$branchCompanyId = this.getBranchCompanyId();
      Object other$branchCompanyId = other.getBranchCompanyId();
      if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
         Object this$paymentMethod = this.getPaymentMethod();
         Object other$paymentMethod = other.getPaymentMethod();
         if (this$paymentMethod == null ? other$paymentMethod == null : this$paymentMethod.equals(other$paymentMethod)) {
            Object this$paymentDate = this.getPaymentDate();
            Object other$paymentDate = other.getPaymentDate();
            if (this$paymentDate == null ? other$paymentDate == null : this$paymentDate.equals(other$paymentDate)) {
               Object this$customerUnit = this.getCustomerUnit();
               Object other$customerUnit = other.getCustomerUnit();
               if (this$customerUnit == null ? other$customerUnit == null : this$customerUnit.equals(other$customerUnit)) {
                  Object this$receiveBank = this.getReceiveBank();
                  Object other$receiveBank = other.getReceiveBank();
                  if (this$receiveBank == null ? other$receiveBank == null : this$receiveBank.equals(other$receiveBank)) {
                     Object this$receiveBankAccount = this.getReceiveBankAccount();
                     Object other$receiveBankAccount = other.getReceiveBankAccount();
                     if (this$receiveBankAccount == null ? other$receiveBankAccount == null : this$receiveBankAccount.equals(other$receiveBankAccount)) {
                        Object this$paymentBank = this.getPaymentBank();
                        Object other$paymentBank = other.getPaymentBank();
                        if (this$paymentBank == null ? other$paymentBank == null : this$paymentBank.equals(other$paymentBank)) {
                           Object this$paymentBankAccount = this.getPaymentBankAccount();
                           Object other$paymentBankAccount = other.getPaymentBankAccount();
                           if (this$paymentBankAccount == null ? other$paymentBankAccount == null : this$paymentBankAccount.equals(other$paymentBankAccount)) {
                              Object this$applyAmount = this.getApplyAmount();
                              Object other$applyAmount = other.getApplyAmount();
                              if (this$applyAmount == null ? other$applyAmount == null : this$applyAmount.equals(other$applyAmount)) {
                                 Object this$paymentReasonId = this.getPaymentReasonId();
                                 Object other$paymentReasonId = other.getPaymentReasonId();
                                 if (this$paymentReasonId == null ? other$paymentReasonId == null : this$paymentReasonId.equals(other$paymentReasonId)) {
                                    Object this$attachmentIds = this.getAttachmentIds();
                                    Object other$attachmentIds = other.getAttachmentIds();
                                    if (this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds)) {
                                       Object this$remark = this.getRemark();
                                       Object other$remark = other.getRemark();
                                       return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof RecyclePaymentSaveParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $paymentMethod = this.getPaymentMethod();
      result = result * 59 + ($paymentMethod == null ? 43 : $paymentMethod.hashCode());
      Object $paymentDate = this.getPaymentDate();
      result = result * 59 + ($paymentDate == null ? 43 : $paymentDate.hashCode());
      Object $customerUnit = this.getCustomerUnit();
      result = result * 59 + ($customerUnit == null ? 43 : $customerUnit.hashCode());
      Object $receiveBank = this.getReceiveBank();
      result = result * 59 + ($receiveBank == null ? 43 : $receiveBank.hashCode());
      Object $receiveBankAccount = this.getReceiveBankAccount();
      result = result * 59 + ($receiveBankAccount == null ? 43 : $receiveBankAccount.hashCode());
      Object $paymentBank = this.getPaymentBank();
      result = result * 59 + ($paymentBank == null ? 43 : $paymentBank.hashCode());
      Object $paymentBankAccount = this.getPaymentBankAccount();
      result = result * 59 + ($paymentBankAccount == null ? 43 : $paymentBankAccount.hashCode());
      Object $applyAmount = this.getApplyAmount();
      result = result * 59 + ($applyAmount == null ? 43 : $applyAmount.hashCode());
      Object $paymentReasonId = this.getPaymentReasonId();
      result = result * 59 + ($paymentReasonId == null ? 43 : $paymentReasonId.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "RecyclePaymentSaveParam(paymentDate="
         + this.getPaymentDate()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", customerUnit="
         + this.getCustomerUnit()
         + ", receiveBank="
         + this.getReceiveBank()
         + ", receiveBankAccount="
         + this.getReceiveBankAccount()
         + ", paymentMethod="
         + this.getPaymentMethod()
         + ", paymentBank="
         + this.getPaymentBank()
         + ", paymentBankAccount="
         + this.getPaymentBankAccount()
         + ", applyAmount="
         + this.getApplyAmount()
         + ", paymentReasonId="
         + this.getPaymentReasonId()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   public RecyclePaymentSaveParam() {
   }

   public RecyclePaymentSaveParam(
      final LocalDate paymentDate,
      final Long branchCompanyId,
      final String customerUnit,
      final String receiveBank,
      final String receiveBankAccount,
      final Integer paymentMethod,
      final String paymentBank,
      final String paymentBankAccount,
      final BigDecimal applyAmount,
      final String paymentReasonId,
      final List<Long> attachmentIds,
      final String remark
   ) {
      this.paymentDate = paymentDate;
      this.branchCompanyId = branchCompanyId;
      this.customerUnit = customerUnit;
      this.receiveBank = receiveBank;
      this.receiveBankAccount = receiveBankAccount;
      this.paymentMethod = paymentMethod;
      this.paymentBank = paymentBank;
      this.paymentBankAccount = paymentBankAccount;
      this.applyAmount = applyAmount;
      this.paymentReasonId = paymentReasonId;
      this.attachmentIds = attachmentIds;
      this.remark = remark;
   }
}
