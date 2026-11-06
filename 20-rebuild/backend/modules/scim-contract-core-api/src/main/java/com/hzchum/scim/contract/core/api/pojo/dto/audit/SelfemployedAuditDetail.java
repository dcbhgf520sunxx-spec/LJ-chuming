package com.hzchum.scim.contract.core.api.pojo.dto.audit;

import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierAuditSelfEmployedDto;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

@ApiOperation("付款审批(自营)--采购")
public class SelfemployedAuditDetail {
   @ApiModelProperty(name = "paymentEnum", value = "付款类型", notes = "付款类型")
   private Integer paymentEnum;
   @ApiModelProperty("通过按钮")
   private Boolean passButton;
   @ApiModelProperty("项目类型")
   private Integer projectAttribute;
   @ApiModelProperty(name = "SupplierAuditSelfEmployedDto", value = "采购付款（自合营）", notes = "采购付款（自合营）")
   private SupplierAuditSelfEmployedDto supplierAuditSelfEmployedDto;
   @ApiModelProperty(name = "boolFinalApprover", value = "是否最后一个审批人", notes = "是否最后一个审批人")
   private Boolean boolFinalApprover;

   public static SelfemployedAuditDetail.SelfemployedAuditDetailBuilder builder() {
      return new SelfemployedAuditDetail.SelfemployedAuditDetailBuilder();
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

   public SupplierAuditSelfEmployedDto getSupplierAuditSelfEmployedDto() {
      return this.supplierAuditSelfEmployedDto;
   }

   public Boolean getBoolFinalApprover() {
      return this.boolFinalApprover;
   }

   public SelfemployedAuditDetail setPaymentEnum(final Integer paymentEnum) {
      this.paymentEnum = paymentEnum;
      return this;
   }

   public SelfemployedAuditDetail setPassButton(final Boolean passButton) {
      this.passButton = passButton;
      return this;
   }

   public SelfemployedAuditDetail setProjectAttribute(final Integer projectAttribute) {
      this.projectAttribute = projectAttribute;
      return this;
   }

   public SelfemployedAuditDetail setSupplierAuditSelfEmployedDto(final SupplierAuditSelfEmployedDto supplierAuditSelfEmployedDto) {
      this.supplierAuditSelfEmployedDto = supplierAuditSelfEmployedDto;
      return this;
   }

   public SelfemployedAuditDetail setBoolFinalApprover(final Boolean boolFinalApprover) {
      this.boolFinalApprover = boolFinalApprover;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SelfemployedAuditDetail)) {
         return false;
      }

      SelfemployedAuditDetail other = (SelfemployedAuditDetail)o;
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
                  Object this$supplierAuditSelfEmployedDto = this.getSupplierAuditSelfEmployedDto();
                  Object other$supplierAuditSelfEmployedDto = other.getSupplierAuditSelfEmployedDto();
                  return this$supplierAuditSelfEmployedDto == null
                     ? other$supplierAuditSelfEmployedDto == null
                     : this$supplierAuditSelfEmployedDto.equals(other$supplierAuditSelfEmployedDto);
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
      return other instanceof SelfemployedAuditDetail;
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
      Object $supplierAuditSelfEmployedDto = this.getSupplierAuditSelfEmployedDto();
      return result * 59 + ($supplierAuditSelfEmployedDto == null ? 43 : $supplierAuditSelfEmployedDto.hashCode());
   }

   @Override
   public String toString() {
      return "SelfemployedAuditDetail(paymentEnum="
         + this.getPaymentEnum()
         + ", passButton="
         + this.getPassButton()
         + ", projectAttribute="
         + this.getProjectAttribute()
         + ", supplierAuditSelfEmployedDto="
         + this.getSupplierAuditSelfEmployedDto()
         + ", boolFinalApprover="
         + this.getBoolFinalApprover()
         + ")";
   }

   public SelfemployedAuditDetail(
      final Integer paymentEnum,
      final Boolean passButton,
      final Integer projectAttribute,
      final SupplierAuditSelfEmployedDto supplierAuditSelfEmployedDto,
      final Boolean boolFinalApprover
   ) {
      this.paymentEnum = paymentEnum;
      this.passButton = passButton;
      this.projectAttribute = projectAttribute;
      this.supplierAuditSelfEmployedDto = supplierAuditSelfEmployedDto;
      this.boolFinalApprover = boolFinalApprover;
   }

   public SelfemployedAuditDetail() {
   }

   public static class SelfemployedAuditDetailBuilder {
      private Integer paymentEnum;
      private Boolean passButton;
      private Integer projectAttribute;
      private SupplierAuditSelfEmployedDto supplierAuditSelfEmployedDto;
      private Boolean boolFinalApprover;

      SelfemployedAuditDetailBuilder() {
      }

      public SelfemployedAuditDetail.SelfemployedAuditDetailBuilder paymentEnum(final Integer paymentEnum) {
         this.paymentEnum = paymentEnum;
         return this;
      }

      public SelfemployedAuditDetail.SelfemployedAuditDetailBuilder passButton(final Boolean passButton) {
         this.passButton = passButton;
         return this;
      }

      public SelfemployedAuditDetail.SelfemployedAuditDetailBuilder projectAttribute(final Integer projectAttribute) {
         this.projectAttribute = projectAttribute;
         return this;
      }

      public SelfemployedAuditDetail.SelfemployedAuditDetailBuilder supplierAuditSelfEmployedDto(
         final SupplierAuditSelfEmployedDto supplierAuditSelfEmployedDto
      ) {
         this.supplierAuditSelfEmployedDto = supplierAuditSelfEmployedDto;
         return this;
      }

      public SelfemployedAuditDetail.SelfemployedAuditDetailBuilder boolFinalApprover(final Boolean boolFinalApprover) {
         this.boolFinalApprover = boolFinalApprover;
         return this;
      }

      public SelfemployedAuditDetail build() {
         return new SelfemployedAuditDetail(this.paymentEnum, this.passButton, this.projectAttribute, this.supplierAuditSelfEmployedDto, this.boolFinalApprover);
      }

      @Override
      public String toString() {
         return "SelfemployedAuditDetail.SelfemployedAuditDetailBuilder(paymentEnum="
            + this.paymentEnum
            + ", passButton="
            + this.passButton
            + ", projectAttribute="
            + this.projectAttribute
            + ", supplierAuditSelfEmployedDto="
            + this.supplierAuditSelfEmployedDto
            + ", boolFinalApprover="
            + this.boolFinalApprover
            + ")";
      }
   }
}
