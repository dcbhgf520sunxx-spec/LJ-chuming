package com.hzchum.scim.contract.core.api.pojo.dtoParam.audit;

import com.hzchum.scim.contract.core.api.pojo.dto.supplier.saveSupplierPaymentDto;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.constraints.NotNull;

public class AddContractAuditDtoParam {
   @ApiModelProperty(name = "auditId", value = "审批id", notes = "审批id")
   private Long auditId;
   @ApiModelProperty(name = "actuallyPayAmount", value = "本次实付金额", notes = "本次实付金额")
   private BigDecimal actuallyPayAmount;
   @ApiModelProperty(name = "paymentType", value = "付款类型", notes = "付款类型")
   private Integer paymentType;
   @ApiModelProperty(name = "paymentDate", value = "付款日期", notes = "付款日期")
   private LocalDateTime paymentDate;
   @NotNull(message = "付款银行不能为空")
   @ApiModelProperty("付款银行")
   private String paymentBank;
   @NotNull(message = "付款账号不能为空")
   @ApiModelProperty("付款账号")
   private String paymentBankAccount;
   @ApiModelProperty(name = "voucherNumber", value = "凭证号", notes = "凭证号")
   private String voucherNumber;
   @ApiModelProperty(name = "auditStatusEnum", value = "审核状态 1:审核中2:审核通过4:驳回", notes = "审核状态 1:审核中2:审核通过4:驳回")
   @NotNull(message = "审核状态不能为空")
   private Integer auditStatusEnum;
   @ApiModelProperty("付款属性id")
   private Long paymentAttributeId;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @ApiModelProperty("订单实付金额列表")
   private List<saveSupplierPaymentDto> supplierPayment;

   public Long getAuditId() {
      return this.auditId;
   }

   public BigDecimal getActuallyPayAmount() {
      return this.actuallyPayAmount;
   }

   public Integer getPaymentType() {
      return this.paymentType;
   }

   public LocalDateTime getPaymentDate() {
      return this.paymentDate;
   }

   public String getPaymentBank() {
      return this.paymentBank;
   }

   public String getPaymentBankAccount() {
      return this.paymentBankAccount;
   }

   public String getVoucherNumber() {
      return this.voucherNumber;
   }

   public Integer getAuditStatusEnum() {
      return this.auditStatusEnum;
   }

   public Long getPaymentAttributeId() {
      return this.paymentAttributeId;
   }

   public String getRemark() {
      return this.remark;
   }

   public List<saveSupplierPaymentDto> getSupplierPayment() {
      return this.supplierPayment;
   }

   public AddContractAuditDtoParam setAuditId(final Long auditId) {
      this.auditId = auditId;
      return this;
   }

   public AddContractAuditDtoParam setActuallyPayAmount(final BigDecimal actuallyPayAmount) {
      this.actuallyPayAmount = actuallyPayAmount;
      return this;
   }

   public AddContractAuditDtoParam setPaymentType(final Integer paymentType) {
      this.paymentType = paymentType;
      return this;
   }

   public AddContractAuditDtoParam setPaymentDate(final LocalDateTime paymentDate) {
      this.paymentDate = paymentDate;
      return this;
   }

   public AddContractAuditDtoParam setPaymentBank(final String paymentBank) {
      this.paymentBank = paymentBank;
      return this;
   }

   public AddContractAuditDtoParam setPaymentBankAccount(final String paymentBankAccount) {
      this.paymentBankAccount = paymentBankAccount;
      return this;
   }

   public AddContractAuditDtoParam setVoucherNumber(final String voucherNumber) {
      this.voucherNumber = voucherNumber;
      return this;
   }

   public AddContractAuditDtoParam setAuditStatusEnum(final Integer auditStatusEnum) {
      this.auditStatusEnum = auditStatusEnum;
      return this;
   }

   public AddContractAuditDtoParam setPaymentAttributeId(final Long paymentAttributeId) {
      this.paymentAttributeId = paymentAttributeId;
      return this;
   }

   public AddContractAuditDtoParam setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public AddContractAuditDtoParam setSupplierPayment(final List<saveSupplierPaymentDto> supplierPayment) {
      this.supplierPayment = supplierPayment;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AddContractAuditDtoParam)) {
         return false;
      }

      AddContractAuditDtoParam other = (AddContractAuditDtoParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$auditId = this.getAuditId();
      Object other$auditId = other.getAuditId();
      if (this$auditId == null ? other$auditId == null : this$auditId.equals(other$auditId)) {
         Object this$paymentType = this.getPaymentType();
         Object other$paymentType = other.getPaymentType();
         if (this$paymentType == null ? other$paymentType == null : this$paymentType.equals(other$paymentType)) {
            Object this$auditStatusEnum = this.getAuditStatusEnum();
            Object other$auditStatusEnum = other.getAuditStatusEnum();
            if (this$auditStatusEnum == null ? other$auditStatusEnum == null : this$auditStatusEnum.equals(other$auditStatusEnum)) {
               Object this$paymentAttributeId = this.getPaymentAttributeId();
               Object other$paymentAttributeId = other.getPaymentAttributeId();
               if (this$paymentAttributeId == null ? other$paymentAttributeId == null : this$paymentAttributeId.equals(other$paymentAttributeId)) {
                  Object this$actuallyPayAmount = this.getActuallyPayAmount();
                  Object other$actuallyPayAmount = other.getActuallyPayAmount();
                  if (this$actuallyPayAmount == null ? other$actuallyPayAmount == null : this$actuallyPayAmount.equals(other$actuallyPayAmount)) {
                     Object this$paymentDate = this.getPaymentDate();
                     Object other$paymentDate = other.getPaymentDate();
                     if (this$paymentDate == null ? other$paymentDate == null : this$paymentDate.equals(other$paymentDate)) {
                        Object this$paymentBank = this.getPaymentBank();
                        Object other$paymentBank = other.getPaymentBank();
                        if (this$paymentBank == null ? other$paymentBank == null : this$paymentBank.equals(other$paymentBank)) {
                           Object this$paymentBankAccount = this.getPaymentBankAccount();
                           Object other$paymentBankAccount = other.getPaymentBankAccount();
                           if (this$paymentBankAccount == null ? other$paymentBankAccount == null : this$paymentBankAccount.equals(other$paymentBankAccount)) {
                              Object this$voucherNumber = this.getVoucherNumber();
                              Object other$voucherNumber = other.getVoucherNumber();
                              if (this$voucherNumber == null ? other$voucherNumber == null : this$voucherNumber.equals(other$voucherNumber)) {
                                 Object this$remark = this.getRemark();
                                 Object other$remark = other.getRemark();
                                 if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                    Object this$supplierPayment = this.getSupplierPayment();
                                    Object other$supplierPayment = other.getSupplierPayment();
                                    return this$supplierPayment == null ? other$supplierPayment == null : this$supplierPayment.equals(other$supplierPayment);
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
      return other instanceof AddContractAuditDtoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $auditId = this.getAuditId();
      result = result * 59 + ($auditId == null ? 43 : $auditId.hashCode());
      Object $paymentType = this.getPaymentType();
      result = result * 59 + ($paymentType == null ? 43 : $paymentType.hashCode());
      Object $auditStatusEnum = this.getAuditStatusEnum();
      result = result * 59 + ($auditStatusEnum == null ? 43 : $auditStatusEnum.hashCode());
      Object $paymentAttributeId = this.getPaymentAttributeId();
      result = result * 59 + ($paymentAttributeId == null ? 43 : $paymentAttributeId.hashCode());
      Object $actuallyPayAmount = this.getActuallyPayAmount();
      result = result * 59 + ($actuallyPayAmount == null ? 43 : $actuallyPayAmount.hashCode());
      Object $paymentDate = this.getPaymentDate();
      result = result * 59 + ($paymentDate == null ? 43 : $paymentDate.hashCode());
      Object $paymentBank = this.getPaymentBank();
      result = result * 59 + ($paymentBank == null ? 43 : $paymentBank.hashCode());
      Object $paymentBankAccount = this.getPaymentBankAccount();
      result = result * 59 + ($paymentBankAccount == null ? 43 : $paymentBankAccount.hashCode());
      Object $voucherNumber = this.getVoucherNumber();
      result = result * 59 + ($voucherNumber == null ? 43 : $voucherNumber.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $supplierPayment = this.getSupplierPayment();
      return result * 59 + ($supplierPayment == null ? 43 : $supplierPayment.hashCode());
   }

   @Override
   public String toString() {
      return "AddContractAuditDtoParam(auditId="
         + this.getAuditId()
         + ", actuallyPayAmount="
         + this.getActuallyPayAmount()
         + ", paymentType="
         + this.getPaymentType()
         + ", paymentDate="
         + this.getPaymentDate()
         + ", paymentBank="
         + this.getPaymentBank()
         + ", paymentBankAccount="
         + this.getPaymentBankAccount()
         + ", voucherNumber="
         + this.getVoucherNumber()
         + ", auditStatusEnum="
         + this.getAuditStatusEnum()
         + ", paymentAttributeId="
         + this.getPaymentAttributeId()
         + ", remark="
         + this.getRemark()
         + ", supplierPayment="
         + this.getSupplierPayment()
         + ")";
   }

   public AddContractAuditDtoParam(
      final Long auditId,
      final BigDecimal actuallyPayAmount,
      final Integer paymentType,
      final LocalDateTime paymentDate,
      final String paymentBank,
      final String paymentBankAccount,
      final String voucherNumber,
      final Integer auditStatusEnum,
      final Long paymentAttributeId,
      final String remark,
      final List<saveSupplierPaymentDto> supplierPayment
   ) {
      this.auditId = auditId;
      this.actuallyPayAmount = actuallyPayAmount;
      this.paymentType = paymentType;
      this.paymentDate = paymentDate;
      this.paymentBank = paymentBank;
      this.paymentBankAccount = paymentBankAccount;
      this.voucherNumber = voucherNumber;
      this.auditStatusEnum = auditStatusEnum;
      this.paymentAttributeId = paymentAttributeId;
      this.remark = remark;
      this.supplierPayment = supplierPayment;
   }

   public AddContractAuditDtoParam() {
   }
}
