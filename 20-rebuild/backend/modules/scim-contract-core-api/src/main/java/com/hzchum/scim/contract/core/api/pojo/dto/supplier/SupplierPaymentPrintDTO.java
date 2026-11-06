package com.hzchum.scim.contract.core.api.pojo.dto.supplier;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;

@ApiModel("打印下载-付款信息类")
public class SupplierPaymentPrintDTO {
   @ApiModelProperty("付款单位")
   private String paymentUnit;
   @ApiModelProperty("付款银行")
   private String paymentBank;
   @ApiModelProperty("付款账号")
   private String paymentBankAccount;
   @ApiModelProperty("收款单位")
   private String receivingUnit;
   @ApiModelProperty("收款银行")
   private String receiveBank;
   @ApiModelProperty("收款账号")
   private String receiveBankAccount;
   @ApiModelProperty("申请金额")
   private BigDecimal applyAmount;
   @ApiModelProperty("付款事由名称")
   private String paymentReasonName;
   @ApiModelProperty("付款日期")
   private LocalDate paymentDate;
   @ApiModelProperty("申请人名称")
   private String applyUserName;
   @ApiModelProperty("备注")
   private String remark;
   @ApiModelProperty("实付金额")
   private BigDecimal actuallyPaymentAmount;
   @ApiModelProperty("付款方式 1对公转账 2对私转账 4承兑汇票 8转账支票")
   private Integer paymentMethod;
   @ApiModelProperty("审核人名字")
   private String auditUserName;
   @ApiModelProperty("审核状态 1未审核(审核中、待审核) 2审核通过 4驳回")
   private Integer auditStatus;

   public String getPaymentUnit() {
      return this.paymentUnit;
   }

   public String getPaymentBank() {
      return this.paymentBank;
   }

   public String getPaymentBankAccount() {
      return this.paymentBankAccount;
   }

   public String getReceivingUnit() {
      return this.receivingUnit;
   }

   public String getReceiveBank() {
      return this.receiveBank;
   }

   public String getReceiveBankAccount() {
      return this.receiveBankAccount;
   }

   public BigDecimal getApplyAmount() {
      return this.applyAmount;
   }

   public String getPaymentReasonName() {
      return this.paymentReasonName;
   }

   public LocalDate getPaymentDate() {
      return this.paymentDate;
   }

   public String getApplyUserName() {
      return this.applyUserName;
   }

   public String getRemark() {
      return this.remark;
   }

   public BigDecimal getActuallyPaymentAmount() {
      return this.actuallyPaymentAmount;
   }

   public Integer getPaymentMethod() {
      return this.paymentMethod;
   }

   public String getAuditUserName() {
      return this.auditUserName;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public void setPaymentUnit(final String paymentUnit) {
      this.paymentUnit = paymentUnit;
   }

   public void setPaymentBank(final String paymentBank) {
      this.paymentBank = paymentBank;
   }

   public void setPaymentBankAccount(final String paymentBankAccount) {
      this.paymentBankAccount = paymentBankAccount;
   }

   public void setReceivingUnit(final String receivingUnit) {
      this.receivingUnit = receivingUnit;
   }

   public void setReceiveBank(final String receiveBank) {
      this.receiveBank = receiveBank;
   }

   public void setReceiveBankAccount(final String receiveBankAccount) {
      this.receiveBankAccount = receiveBankAccount;
   }

   public void setApplyAmount(final BigDecimal applyAmount) {
      this.applyAmount = applyAmount;
   }

   public void setPaymentReasonName(final String paymentReasonName) {
      this.paymentReasonName = paymentReasonName;
   }

   public void setPaymentDate(final LocalDate paymentDate) {
      this.paymentDate = paymentDate;
   }

   public void setApplyUserName(final String applyUserName) {
      this.applyUserName = applyUserName;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setActuallyPaymentAmount(final BigDecimal actuallyPaymentAmount) {
      this.actuallyPaymentAmount = actuallyPaymentAmount;
   }

   public void setPaymentMethod(final Integer paymentMethod) {
      this.paymentMethod = paymentMethod;
   }

   public void setAuditUserName(final String auditUserName) {
      this.auditUserName = auditUserName;
   }

   public void setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierPaymentPrintDTO)) {
         return false;
      }

      SupplierPaymentPrintDTO other = (SupplierPaymentPrintDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$paymentMethod = this.getPaymentMethod();
      Object other$paymentMethod = other.getPaymentMethod();
      if (this$paymentMethod == null ? other$paymentMethod == null : this$paymentMethod.equals(other$paymentMethod)) {
         Object this$auditStatus = this.getAuditStatus();
         Object other$auditStatus = other.getAuditStatus();
         if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
            Object this$paymentUnit = this.getPaymentUnit();
            Object other$paymentUnit = other.getPaymentUnit();
            if (this$paymentUnit == null ? other$paymentUnit == null : this$paymentUnit.equals(other$paymentUnit)) {
               Object this$paymentBank = this.getPaymentBank();
               Object other$paymentBank = other.getPaymentBank();
               if (this$paymentBank == null ? other$paymentBank == null : this$paymentBank.equals(other$paymentBank)) {
                  Object this$paymentBankAccount = this.getPaymentBankAccount();
                  Object other$paymentBankAccount = other.getPaymentBankAccount();
                  if (this$paymentBankAccount == null ? other$paymentBankAccount == null : this$paymentBankAccount.equals(other$paymentBankAccount)) {
                     Object this$receivingUnit = this.getReceivingUnit();
                     Object other$receivingUnit = other.getReceivingUnit();
                     if (this$receivingUnit == null ? other$receivingUnit == null : this$receivingUnit.equals(other$receivingUnit)) {
                        Object this$receiveBank = this.getReceiveBank();
                        Object other$receiveBank = other.getReceiveBank();
                        if (this$receiveBank == null ? other$receiveBank == null : this$receiveBank.equals(other$receiveBank)) {
                           Object this$receiveBankAccount = this.getReceiveBankAccount();
                           Object other$receiveBankAccount = other.getReceiveBankAccount();
                           if (this$receiveBankAccount == null ? other$receiveBankAccount == null : this$receiveBankAccount.equals(other$receiveBankAccount)) {
                              Object this$applyAmount = this.getApplyAmount();
                              Object other$applyAmount = other.getApplyAmount();
                              if (this$applyAmount == null ? other$applyAmount == null : this$applyAmount.equals(other$applyAmount)) {
                                 Object this$paymentReasonName = this.getPaymentReasonName();
                                 Object other$paymentReasonName = other.getPaymentReasonName();
                                 if (this$paymentReasonName == null ? other$paymentReasonName == null : this$paymentReasonName.equals(other$paymentReasonName)) {
                                    Object this$paymentDate = this.getPaymentDate();
                                    Object other$paymentDate = other.getPaymentDate();
                                    if (this$paymentDate == null ? other$paymentDate == null : this$paymentDate.equals(other$paymentDate)) {
                                       Object this$applyUserName = this.getApplyUserName();
                                       Object other$applyUserName = other.getApplyUserName();
                                       if (this$applyUserName == null ? other$applyUserName == null : this$applyUserName.equals(other$applyUserName)) {
                                          Object this$remark = this.getRemark();
                                          Object other$remark = other.getRemark();
                                          if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                             Object this$actuallyPaymentAmount = this.getActuallyPaymentAmount();
                                             Object other$actuallyPaymentAmount = other.getActuallyPaymentAmount();
                                             if (this$actuallyPaymentAmount == null
                                                ? other$actuallyPaymentAmount == null
                                                : this$actuallyPaymentAmount.equals(other$actuallyPaymentAmount)) {
                                                Object this$auditUserName = this.getAuditUserName();
                                                Object other$auditUserName = other.getAuditUserName();
                                                return this$auditUserName == null
                                                   ? other$auditUserName == null
                                                   : this$auditUserName.equals(other$auditUserName);
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
      return other instanceof SupplierPaymentPrintDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $paymentMethod = this.getPaymentMethod();
      result = result * 59 + ($paymentMethod == null ? 43 : $paymentMethod.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $paymentUnit = this.getPaymentUnit();
      result = result * 59 + ($paymentUnit == null ? 43 : $paymentUnit.hashCode());
      Object $paymentBank = this.getPaymentBank();
      result = result * 59 + ($paymentBank == null ? 43 : $paymentBank.hashCode());
      Object $paymentBankAccount = this.getPaymentBankAccount();
      result = result * 59 + ($paymentBankAccount == null ? 43 : $paymentBankAccount.hashCode());
      Object $receivingUnit = this.getReceivingUnit();
      result = result * 59 + ($receivingUnit == null ? 43 : $receivingUnit.hashCode());
      Object $receiveBank = this.getReceiveBank();
      result = result * 59 + ($receiveBank == null ? 43 : $receiveBank.hashCode());
      Object $receiveBankAccount = this.getReceiveBankAccount();
      result = result * 59 + ($receiveBankAccount == null ? 43 : $receiveBankAccount.hashCode());
      Object $applyAmount = this.getApplyAmount();
      result = result * 59 + ($applyAmount == null ? 43 : $applyAmount.hashCode());
      Object $paymentReasonName = this.getPaymentReasonName();
      result = result * 59 + ($paymentReasonName == null ? 43 : $paymentReasonName.hashCode());
      Object $paymentDate = this.getPaymentDate();
      result = result * 59 + ($paymentDate == null ? 43 : $paymentDate.hashCode());
      Object $applyUserName = this.getApplyUserName();
      result = result * 59 + ($applyUserName == null ? 43 : $applyUserName.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $actuallyPaymentAmount = this.getActuallyPaymentAmount();
      result = result * 59 + ($actuallyPaymentAmount == null ? 43 : $actuallyPaymentAmount.hashCode());
      Object $auditUserName = this.getAuditUserName();
      return result * 59 + ($auditUserName == null ? 43 : $auditUserName.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierPaymentPrintDTO(paymentUnit="
         + this.getPaymentUnit()
         + ", paymentBank="
         + this.getPaymentBank()
         + ", paymentBankAccount="
         + this.getPaymentBankAccount()
         + ", receivingUnit="
         + this.getReceivingUnit()
         + ", receiveBank="
         + this.getReceiveBank()
         + ", receiveBankAccount="
         + this.getReceiveBankAccount()
         + ", applyAmount="
         + this.getApplyAmount()
         + ", paymentReasonName="
         + this.getPaymentReasonName()
         + ", paymentDate="
         + this.getPaymentDate()
         + ", applyUserName="
         + this.getApplyUserName()
         + ", remark="
         + this.getRemark()
         + ", actuallyPaymentAmount="
         + this.getActuallyPaymentAmount()
         + ", paymentMethod="
         + this.getPaymentMethod()
         + ", auditUserName="
         + this.getAuditUserName()
         + ", auditStatus="
         + this.getAuditStatus()
         + ")";
   }
}
