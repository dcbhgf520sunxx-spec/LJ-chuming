package com.hzchum.scim.contract.core.api.pojo.dto.audit;

import io.swagger.annotations.ApiModelProperty;

public class ContractAuditBaseDTO {
   @ApiModelProperty(name = "paymentEnum", value = "付款类型", notes = "付款类型")
   private Integer paymentEnum;
   @ApiModelProperty("通过按钮")
   private Boolean passButton;
   @ApiModelProperty("是否可撤销")
   private Boolean boolCancel;
   @ApiModelProperty(name = "boolFinalApprover", value = "是否最后一个审批人", notes = "是否最后一个审批人")
   private Boolean boolFinalApprover;
   @ApiModelProperty(value = "审批id", notes = "审批id")
   private Long auditId;

   public Integer getPaymentEnum() {
      return this.paymentEnum;
   }

   public Boolean getPassButton() {
      return this.passButton;
   }

   public Boolean getBoolCancel() {
      return this.boolCancel;
   }

   public Boolean getBoolFinalApprover() {
      return this.boolFinalApprover;
   }

   public Long getAuditId() {
      return this.auditId;
   }

   public void setPaymentEnum(final Integer paymentEnum) {
      this.paymentEnum = paymentEnum;
   }

   public void setPassButton(final Boolean passButton) {
      this.passButton = passButton;
   }

   public void setBoolCancel(final Boolean boolCancel) {
      this.boolCancel = boolCancel;
   }

   public void setBoolFinalApprover(final Boolean boolFinalApprover) {
      this.boolFinalApprover = boolFinalApprover;
   }

   public void setAuditId(final Long auditId) {
      this.auditId = auditId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractAuditBaseDTO)) {
         return false;
      }

      ContractAuditBaseDTO other = (ContractAuditBaseDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$paymentEnum = this.getPaymentEnum();
      Object other$paymentEnum = other.getPaymentEnum();
      if (this$paymentEnum == null ? other$paymentEnum == null : this$paymentEnum.equals(other$paymentEnum)) {
         Object this$passButton = this.getPassButton();
         Object other$passButton = other.getPassButton();
         if (this$passButton == null ? other$passButton == null : this$passButton.equals(other$passButton)) {
            Object this$boolCancel = this.getBoolCancel();
            Object other$boolCancel = other.getBoolCancel();
            if (this$boolCancel == null ? other$boolCancel == null : this$boolCancel.equals(other$boolCancel)) {
               Object this$boolFinalApprover = this.getBoolFinalApprover();
               Object other$boolFinalApprover = other.getBoolFinalApprover();
               if (this$boolFinalApprover == null ? other$boolFinalApprover == null : this$boolFinalApprover.equals(other$boolFinalApprover)) {
                  Object this$auditId = this.getAuditId();
                  Object other$auditId = other.getAuditId();
                  return this$auditId == null ? other$auditId == null : this$auditId.equals(other$auditId);
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
      return other instanceof ContractAuditBaseDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $paymentEnum = this.getPaymentEnum();
      result = result * 59 + ($paymentEnum == null ? 43 : $paymentEnum.hashCode());
      Object $passButton = this.getPassButton();
      result = result * 59 + ($passButton == null ? 43 : $passButton.hashCode());
      Object $boolCancel = this.getBoolCancel();
      result = result * 59 + ($boolCancel == null ? 43 : $boolCancel.hashCode());
      Object $boolFinalApprover = this.getBoolFinalApprover();
      result = result * 59 + ($boolFinalApprover == null ? 43 : $boolFinalApprover.hashCode());
      Object $auditId = this.getAuditId();
      return result * 59 + ($auditId == null ? 43 : $auditId.hashCode());
   }

   @Override
   public String toString() {
      return "ContractAuditBaseDTO(paymentEnum="
         + this.getPaymentEnum()
         + ", passButton="
         + this.getPassButton()
         + ", boolCancel="
         + this.getBoolCancel()
         + ", boolFinalApprover="
         + this.getBoolFinalApprover()
         + ", auditId="
         + this.getAuditId()
         + ")";
   }
}
