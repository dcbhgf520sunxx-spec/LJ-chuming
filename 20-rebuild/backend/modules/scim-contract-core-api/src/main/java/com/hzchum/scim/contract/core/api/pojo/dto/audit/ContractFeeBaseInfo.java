package com.hzchum.scim.contract.core.api.pojo.dto.audit;

import io.swagger.annotations.ApiModelProperty;

public class ContractFeeBaseInfo {
   @ApiModelProperty("审批id")
   private Long auditId;
   @ApiModelProperty("审批日志表ID")
   private Long approveRecordId;
   @ApiModelProperty(name = "passButton", value = "结算按钮")
   private Boolean passButton;
   @ApiModelProperty(name = "paymentEnum", value = "审批类型")
   private Integer paymentEnum;
   @ApiModelProperty(name = "boolFinalApprover", value = "是否最后一个审批人")
   private Boolean boolFinalApprover;

   public Long getAuditId() {
      return this.auditId;
   }

   public Long getApproveRecordId() {
      return this.approveRecordId;
   }

   public Boolean getPassButton() {
      return this.passButton;
   }

   public Integer getPaymentEnum() {
      return this.paymentEnum;
   }

   public Boolean getBoolFinalApprover() {
      return this.boolFinalApprover;
   }

   public void setAuditId(final Long auditId) {
      this.auditId = auditId;
   }

   public void setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
   }

   public void setPassButton(final Boolean passButton) {
      this.passButton = passButton;
   }

   public void setPaymentEnum(final Integer paymentEnum) {
      this.paymentEnum = paymentEnum;
   }

   public void setBoolFinalApprover(final Boolean boolFinalApprover) {
      this.boolFinalApprover = boolFinalApprover;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractFeeBaseInfo)) {
         return false;
      }

      ContractFeeBaseInfo other = (ContractFeeBaseInfo)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$auditId = this.getAuditId();
      Object other$auditId = other.getAuditId();
      if (this$auditId == null ? other$auditId == null : this$auditId.equals(other$auditId)) {
         Object this$approveRecordId = this.getApproveRecordId();
         Object other$approveRecordId = other.getApproveRecordId();
         if (this$approveRecordId == null ? other$approveRecordId == null : this$approveRecordId.equals(other$approveRecordId)) {
            Object this$passButton = this.getPassButton();
            Object other$passButton = other.getPassButton();
            if (this$passButton == null ? other$passButton == null : this$passButton.equals(other$passButton)) {
               Object this$paymentEnum = this.getPaymentEnum();
               Object other$paymentEnum = other.getPaymentEnum();
               if (this$paymentEnum == null ? other$paymentEnum == null : this$paymentEnum.equals(other$paymentEnum)) {
                  Object this$boolFinalApprover = this.getBoolFinalApprover();
                  Object other$boolFinalApprover = other.getBoolFinalApprover();
                  return this$boolFinalApprover == null ? other$boolFinalApprover == null : this$boolFinalApprover.equals(other$boolFinalApprover);
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
      return other instanceof ContractFeeBaseInfo;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $auditId = this.getAuditId();
      result = result * 59 + ($auditId == null ? 43 : $auditId.hashCode());
      Object $approveRecordId = this.getApproveRecordId();
      result = result * 59 + ($approveRecordId == null ? 43 : $approveRecordId.hashCode());
      Object $passButton = this.getPassButton();
      result = result * 59 + ($passButton == null ? 43 : $passButton.hashCode());
      Object $paymentEnum = this.getPaymentEnum();
      result = result * 59 + ($paymentEnum == null ? 43 : $paymentEnum.hashCode());
      Object $boolFinalApprover = this.getBoolFinalApprover();
      return result * 59 + ($boolFinalApprover == null ? 43 : $boolFinalApprover.hashCode());
   }

   @Override
   public String toString() {
      return "ContractFeeBaseInfo(auditId="
         + this.getAuditId()
         + ", approveRecordId="
         + this.getApproveRecordId()
         + ", passButton="
         + this.getPassButton()
         + ", paymentEnum="
         + this.getPaymentEnum()
         + ", boolFinalApprover="
         + this.getBoolFinalApprover()
         + ")";
   }
}
