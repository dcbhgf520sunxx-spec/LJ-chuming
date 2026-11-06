package com.hzchum.scim.contract.core.api.pojo.dto.audit;

import com.hzchum.scim.contract.core.api.pojo.dto.project.ProjectSupplierDto;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

@ApiOperation("内包制付款审核详情")
public class InsourcingDetailAuditDetail {
   @ApiModelProperty(name = "paymentEnum", value = "付款类型", notes = "付款类型")
   private Integer paymentEnum;
   @ApiModelProperty("通过按钮")
   private Boolean passButton;
   @ApiModelProperty("项目类型")
   private Integer projectAttribute;
   @ApiModelProperty(name = "ProjectSupplierDto", value = "采购付款（内包）", notes = "采购付款（内包）")
   private ProjectSupplierDto projectSupplierDto;

   public static InsourcingDetailAuditDetail.InsourcingDetailAuditDetailBuilder builder() {
      return new InsourcingDetailAuditDetail.InsourcingDetailAuditDetailBuilder();
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

   public ProjectSupplierDto getProjectSupplierDto() {
      return this.projectSupplierDto;
   }

   public InsourcingDetailAuditDetail setPaymentEnum(final Integer paymentEnum) {
      this.paymentEnum = paymentEnum;
      return this;
   }

   public InsourcingDetailAuditDetail setPassButton(final Boolean passButton) {
      this.passButton = passButton;
      return this;
   }

   public InsourcingDetailAuditDetail setProjectAttribute(final Integer projectAttribute) {
      this.projectAttribute = projectAttribute;
      return this;
   }

   public InsourcingDetailAuditDetail setProjectSupplierDto(final ProjectSupplierDto projectSupplierDto) {
      this.projectSupplierDto = projectSupplierDto;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InsourcingDetailAuditDetail)) {
         return false;
      }

      InsourcingDetailAuditDetail other = (InsourcingDetailAuditDetail)o;
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
               Object this$projectSupplierDto = this.getProjectSupplierDto();
               Object other$projectSupplierDto = other.getProjectSupplierDto();
               return this$projectSupplierDto == null ? other$projectSupplierDto == null : this$projectSupplierDto.equals(other$projectSupplierDto);
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
      return other instanceof InsourcingDetailAuditDetail;
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
      Object $projectSupplierDto = this.getProjectSupplierDto();
      return result * 59 + ($projectSupplierDto == null ? 43 : $projectSupplierDto.hashCode());
   }

   @Override
   public String toString() {
      return "InsourcingDetailAuditDetail(paymentEnum="
         + this.getPaymentEnum()
         + ", passButton="
         + this.getPassButton()
         + ", projectAttribute="
         + this.getProjectAttribute()
         + ", projectSupplierDto="
         + this.getProjectSupplierDto()
         + ")";
   }

   public InsourcingDetailAuditDetail(
      final Integer paymentEnum, final Boolean passButton, final Integer projectAttribute, final ProjectSupplierDto projectSupplierDto
   ) {
      this.paymentEnum = paymentEnum;
      this.passButton = passButton;
      this.projectAttribute = projectAttribute;
      this.projectSupplierDto = projectSupplierDto;
   }

   public InsourcingDetailAuditDetail() {
   }

   public static class InsourcingDetailAuditDetailBuilder {
      private Integer paymentEnum;
      private Boolean passButton;
      private Integer projectAttribute;
      private ProjectSupplierDto projectSupplierDto;

      InsourcingDetailAuditDetailBuilder() {
      }

      public InsourcingDetailAuditDetail.InsourcingDetailAuditDetailBuilder paymentEnum(final Integer paymentEnum) {
         this.paymentEnum = paymentEnum;
         return this;
      }

      public InsourcingDetailAuditDetail.InsourcingDetailAuditDetailBuilder passButton(final Boolean passButton) {
         this.passButton = passButton;
         return this;
      }

      public InsourcingDetailAuditDetail.InsourcingDetailAuditDetailBuilder projectAttribute(final Integer projectAttribute) {
         this.projectAttribute = projectAttribute;
         return this;
      }

      public InsourcingDetailAuditDetail.InsourcingDetailAuditDetailBuilder projectSupplierDto(final ProjectSupplierDto projectSupplierDto) {
         this.projectSupplierDto = projectSupplierDto;
         return this;
      }

      public InsourcingDetailAuditDetail build() {
         return new InsourcingDetailAuditDetail(this.paymentEnum, this.passButton, this.projectAttribute, this.projectSupplierDto);
      }

      @Override
      public String toString() {
         return "InsourcingDetailAuditDetail.InsourcingDetailAuditDetailBuilder(paymentEnum="
            + this.paymentEnum
            + ", passButton="
            + this.passButton
            + ", projectAttribute="
            + this.projectAttribute
            + ", projectSupplierDto="
            + this.projectSupplierDto
            + ")";
      }
   }
}
