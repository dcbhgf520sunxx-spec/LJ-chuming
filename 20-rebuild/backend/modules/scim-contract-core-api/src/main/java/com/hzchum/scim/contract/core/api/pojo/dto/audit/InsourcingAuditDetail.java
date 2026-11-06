package com.hzchum.scim.contract.core.api.pojo.dto.audit;

import com.hzchum.scim.contract.core.api.pojo.dto.supplier.ProjectOutputInvoiceDto;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

@ApiOperation("审批管理-销项发票")
public class InsourcingAuditDetail {
   @ApiModelProperty(name = "paymentEnum", value = "付款类型", notes = "付款类型")
   private Integer paymentEnum;
   @ApiModelProperty("通过按钮")
   private Boolean passButton;
   @ApiModelProperty("项目类型")
   private Integer projectAttribute;
   @ApiModelProperty(name = "boolFinalApprover", value = "是否最后一个审批人", notes = "是否最后一个审批人")
   private Boolean boolFinalApprover;
   @ApiModelProperty(name = "outputInvoice", value = "销项发票数据回显", notes = "销项发票数据回显")
   private ProjectOutputInvoiceDto outputInvoice;

   public static InsourcingAuditDetail.InsourcingAuditDetailBuilder builder() {
      return new InsourcingAuditDetail.InsourcingAuditDetailBuilder();
   }

   public Integer getPaymentEnum() {
      return this.paymentEnum;
   }

   public Boolean getPassButton() {
      return this.passButton;
   }

   public Integer getProjectAttribute() {
      return this.projectAttribute;
   }

   public Boolean getBoolFinalApprover() {
      return this.boolFinalApprover;
   }

   public ProjectOutputInvoiceDto getOutputInvoice() {
      return this.outputInvoice;
   }

   public InsourcingAuditDetail setPaymentEnum(final Integer paymentEnum) {
      this.paymentEnum = paymentEnum;
      return this;
   }

   public InsourcingAuditDetail setPassButton(final Boolean passButton) {
      this.passButton = passButton;
      return this;
   }

   public InsourcingAuditDetail setProjectAttribute(final Integer projectAttribute) {
      this.projectAttribute = projectAttribute;
      return this;
   }

   public InsourcingAuditDetail setBoolFinalApprover(final Boolean boolFinalApprover) {
      this.boolFinalApprover = boolFinalApprover;
      return this;
   }

   public InsourcingAuditDetail setOutputInvoice(final ProjectOutputInvoiceDto outputInvoice) {
      this.outputInvoice = outputInvoice;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InsourcingAuditDetail)) {
         return false;
      }

      InsourcingAuditDetail other = (InsourcingAuditDetail)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$paymentEnum = this.getPaymentEnum();
      Object other$paymentEnum = other.getPaymentEnum();
      if (this$paymentEnum == null ? other$paymentEnum == null : this$paymentEnum.equals(other$paymentEnum)) {
         Object this$passButton = this.getPassButton();
         Object other$passButton = other.getPassButton();
         if (this$passButton == null ? other$passButton == null : this$passButton.equals(other$passButton)) {
            Object this$projectAttribute = this.getProjectAttribute();
            Object other$projectAttribute = other.getProjectAttribute();
            if (this$projectAttribute == null ? other$projectAttribute == null : this$projectAttribute.equals(other$projectAttribute)) {
               Object this$boolFinalApprover = this.getBoolFinalApprover();
               Object other$boolFinalApprover = other.getBoolFinalApprover();
               if (this$boolFinalApprover == null ? other$boolFinalApprover == null : this$boolFinalApprover.equals(other$boolFinalApprover)) {
                  Object this$outputInvoice = this.getOutputInvoice();
                  Object other$outputInvoice = other.getOutputInvoice();
                  return this$outputInvoice == null ? other$outputInvoice == null : this$outputInvoice.equals(other$outputInvoice);
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
      return other instanceof InsourcingAuditDetail;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $paymentEnum = this.getPaymentEnum();
      result = result * 59 + ($paymentEnum == null ? 43 : $paymentEnum.hashCode());
      Object $passButton = this.getPassButton();
      result = result * 59 + ($passButton == null ? 43 : $passButton.hashCode());
      Object $projectAttribute = this.getProjectAttribute();
      result = result * 59 + ($projectAttribute == null ? 43 : $projectAttribute.hashCode());
      Object $boolFinalApprover = this.getBoolFinalApprover();
      result = result * 59 + ($boolFinalApprover == null ? 43 : $boolFinalApprover.hashCode());
      Object $outputInvoice = this.getOutputInvoice();
      return result * 59 + ($outputInvoice == null ? 43 : $outputInvoice.hashCode());
   }

   @Override
   public String toString() {
      return "InsourcingAuditDetail(paymentEnum="
         + this.getPaymentEnum()
         + ", passButton="
         + this.getPassButton()
         + ", projectAttribute="
         + this.getProjectAttribute()
         + ", boolFinalApprover="
         + this.getBoolFinalApprover()
         + ", outputInvoice="
         + this.getOutputInvoice()
         + ")";
   }

   public InsourcingAuditDetail(
      final Integer paymentEnum,
      final Boolean passButton,
      final Integer projectAttribute,
      final Boolean boolFinalApprover,
      final ProjectOutputInvoiceDto outputInvoice
   ) {
      this.paymentEnum = paymentEnum;
      this.passButton = passButton;
      this.projectAttribute = projectAttribute;
      this.boolFinalApprover = boolFinalApprover;
      this.outputInvoice = outputInvoice;
   }

   public InsourcingAuditDetail() {
   }

   public static class InsourcingAuditDetailBuilder {
      private Integer paymentEnum;
      private Boolean passButton;
      private Integer projectAttribute;
      private Boolean boolFinalApprover;
      private ProjectOutputInvoiceDto outputInvoice;

      InsourcingAuditDetailBuilder() {
      }

      public InsourcingAuditDetail.InsourcingAuditDetailBuilder paymentEnum(final Integer paymentEnum) {
         this.paymentEnum = paymentEnum;
         return this;
      }

      public InsourcingAuditDetail.InsourcingAuditDetailBuilder passButton(final Boolean passButton) {
         this.passButton = passButton;
         return this;
      }

      public InsourcingAuditDetail.InsourcingAuditDetailBuilder projectAttribute(final Integer projectAttribute) {
         this.projectAttribute = projectAttribute;
         return this;
      }

      public InsourcingAuditDetail.InsourcingAuditDetailBuilder boolFinalApprover(final Boolean boolFinalApprover) {
         this.boolFinalApprover = boolFinalApprover;
         return this;
      }

      public InsourcingAuditDetail.InsourcingAuditDetailBuilder outputInvoice(final ProjectOutputInvoiceDto outputInvoice) {
         this.outputInvoice = outputInvoice;
         return this;
      }

      public InsourcingAuditDetail build() {
         return new InsourcingAuditDetail(this.paymentEnum, this.passButton, this.projectAttribute, this.boolFinalApprover, this.outputInvoice);
      }

      @Override
      public String toString() {
         return "InsourcingAuditDetail.InsourcingAuditDetailBuilder(paymentEnum="
            + this.paymentEnum
            + ", passButton="
            + this.passButton
            + ", projectAttribute="
            + this.projectAttribute
            + ", boolFinalApprover="
            + this.boolFinalApprover
            + ", outputInvoice="
            + this.outputInvoice
            + ")";
      }
   }
}
