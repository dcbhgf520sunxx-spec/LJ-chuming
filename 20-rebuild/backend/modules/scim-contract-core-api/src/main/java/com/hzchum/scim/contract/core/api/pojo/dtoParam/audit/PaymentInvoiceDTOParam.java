package com.hzchum.scim.contract.core.api.pojo.dtoParam.audit;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PaymentInvoiceDTOParam {
   @NotNull(message = "审批id不能为空")
   @ApiModelProperty(value = "审批id", notes = "审批id")
   private Long auditId;
   @NotNull(message = "本次实开发票金额不能为空")
   @ApiModelProperty(value = "本次实开发票金额(销项)", notes = "本次实开发票金额")
   private BigDecimal practicalInvoice;
   @ApiModelProperty(name = "taxRateTypeValue", value = "字典配置税率value值")
   private String taxRateTypeValue;
   @ApiModelProperty(value = "发票税率", notes = "发票税率")
   private BigDecimal taxRate;
   @ApiModelProperty(value = "发票编号", notes = "发票编号")
   private String invoiceNumber;
   @NotNull(message = "审批状态不能为空")
   @ApiModelProperty(value = "审批状态", notes = "审批状态")
   private Integer auditStatusEnum;
   @ApiModelProperty(value = "发票附件", notes = "发票附件")
   private Long attachmentId;
   @ApiModelProperty(value = "备注", notes = "备注")
   @Size(max = 1000, message = "备注长度不能超过1000")
   private String remark;

   PaymentInvoiceDTOParam(
      final Long auditId,
      final BigDecimal practicalInvoice,
      final String taxRateTypeValue,
      final BigDecimal taxRate,
      final String invoiceNumber,
      final Integer auditStatusEnum,
      final Long attachmentId,
      final String remark
   ) {
      this.auditId = auditId;
      this.practicalInvoice = practicalInvoice;
      this.taxRateTypeValue = taxRateTypeValue;
      this.taxRate = taxRate;
      this.invoiceNumber = invoiceNumber;
      this.auditStatusEnum = auditStatusEnum;
      this.attachmentId = attachmentId;
      this.remark = remark;
   }

   public static PaymentInvoiceDTOParam.PaymentInvoiceDTOParamBuilder builder() {
      return new PaymentInvoiceDTOParam.PaymentInvoiceDTOParamBuilder();
   }

   public Long getAuditId() {
      return this.auditId;
   }

   public BigDecimal getPracticalInvoice() {
      return this.practicalInvoice;
   }

   public String getTaxRateTypeValue() {
      return this.taxRateTypeValue;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public String getInvoiceNumber() {
      return this.invoiceNumber;
   }

   public Integer getAuditStatusEnum() {
      return this.auditStatusEnum;
   }

   public Long getAttachmentId() {
      return this.attachmentId;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setAuditId(final Long auditId) {
      this.auditId = auditId;
   }

   public void setPracticalInvoice(final BigDecimal practicalInvoice) {
      this.practicalInvoice = practicalInvoice;
   }

   public void setTaxRateTypeValue(final String taxRateTypeValue) {
      this.taxRateTypeValue = taxRateTypeValue;
   }

   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
   }

   public void setInvoiceNumber(final String invoiceNumber) {
      this.invoiceNumber = invoiceNumber;
   }

   public void setAuditStatusEnum(final Integer auditStatusEnum) {
      this.auditStatusEnum = auditStatusEnum;
   }

   public void setAttachmentId(final Long attachmentId) {
      this.attachmentId = attachmentId;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PaymentInvoiceDTOParam)) {
         return false;
      }

      PaymentInvoiceDTOParam other = (PaymentInvoiceDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$auditId = this.getAuditId();
      Object other$auditId = other.getAuditId();
      if (this$auditId == null ? other$auditId == null : this$auditId.equals(other$auditId)) {
         Object this$auditStatusEnum = this.getAuditStatusEnum();
         Object other$auditStatusEnum = other.getAuditStatusEnum();
         if (this$auditStatusEnum == null ? other$auditStatusEnum == null : this$auditStatusEnum.equals(other$auditStatusEnum)) {
            Object this$attachmentId = this.getAttachmentId();
            Object other$attachmentId = other.getAttachmentId();
            if (this$attachmentId == null ? other$attachmentId == null : this$attachmentId.equals(other$attachmentId)) {
               Object this$practicalInvoice = this.getPracticalInvoice();
               Object other$practicalInvoice = other.getPracticalInvoice();
               if (this$practicalInvoice == null ? other$practicalInvoice == null : this$practicalInvoice.equals(other$practicalInvoice)) {
                  Object this$taxRateTypeValue = this.getTaxRateTypeValue();
                  Object other$taxRateTypeValue = other.getTaxRateTypeValue();
                  if (this$taxRateTypeValue == null ? other$taxRateTypeValue == null : this$taxRateTypeValue.equals(other$taxRateTypeValue)) {
                     Object this$taxRate = this.getTaxRate();
                     Object other$taxRate = other.getTaxRate();
                     if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
                        Object this$invoiceNumber = this.getInvoiceNumber();
                        Object other$invoiceNumber = other.getInvoiceNumber();
                        if (this$invoiceNumber == null ? other$invoiceNumber == null : this$invoiceNumber.equals(other$invoiceNumber)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PaymentInvoiceDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $auditId = this.getAuditId();
      result = result * 59 + ($auditId == null ? 43 : $auditId.hashCode());
      Object $auditStatusEnum = this.getAuditStatusEnum();
      result = result * 59 + ($auditStatusEnum == null ? 43 : $auditStatusEnum.hashCode());
      Object $attachmentId = this.getAttachmentId();
      result = result * 59 + ($attachmentId == null ? 43 : $attachmentId.hashCode());
      Object $practicalInvoice = this.getPracticalInvoice();
      result = result * 59 + ($practicalInvoice == null ? 43 : $practicalInvoice.hashCode());
      Object $taxRateTypeValue = this.getTaxRateTypeValue();
      result = result * 59 + ($taxRateTypeValue == null ? 43 : $taxRateTypeValue.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $invoiceNumber = this.getInvoiceNumber();
      result = result * 59 + ($invoiceNumber == null ? 43 : $invoiceNumber.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "PaymentInvoiceDTOParam(auditId="
         + this.getAuditId()
         + ", practicalInvoice="
         + this.getPracticalInvoice()
         + ", taxRateTypeValue="
         + this.getTaxRateTypeValue()
         + ", taxRate="
         + this.getTaxRate()
         + ", invoiceNumber="
         + this.getInvoiceNumber()
         + ", auditStatusEnum="
         + this.getAuditStatusEnum()
         + ", attachmentId="
         + this.getAttachmentId()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   public static class PaymentInvoiceDTOParamBuilder {
      private Long auditId;
      private BigDecimal practicalInvoice;
      private String taxRateTypeValue;
      private BigDecimal taxRate;
      private String invoiceNumber;
      private Integer auditStatusEnum;
      private Long attachmentId;
      private String remark;

      PaymentInvoiceDTOParamBuilder() {
      }

      public PaymentInvoiceDTOParam.PaymentInvoiceDTOParamBuilder auditId(final Long auditId) {
         this.auditId = auditId;
         return this;
      }

      public PaymentInvoiceDTOParam.PaymentInvoiceDTOParamBuilder practicalInvoice(final BigDecimal practicalInvoice) {
         this.practicalInvoice = practicalInvoice;
         return this;
      }

      public PaymentInvoiceDTOParam.PaymentInvoiceDTOParamBuilder taxRateTypeValue(final String taxRateTypeValue) {
         this.taxRateTypeValue = taxRateTypeValue;
         return this;
      }

      public PaymentInvoiceDTOParam.PaymentInvoiceDTOParamBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public PaymentInvoiceDTOParam.PaymentInvoiceDTOParamBuilder invoiceNumber(final String invoiceNumber) {
         this.invoiceNumber = invoiceNumber;
         return this;
      }

      public PaymentInvoiceDTOParam.PaymentInvoiceDTOParamBuilder auditStatusEnum(final Integer auditStatusEnum) {
         this.auditStatusEnum = auditStatusEnum;
         return this;
      }

      public PaymentInvoiceDTOParam.PaymentInvoiceDTOParamBuilder attachmentId(final Long attachmentId) {
         this.attachmentId = attachmentId;
         return this;
      }

      public PaymentInvoiceDTOParam.PaymentInvoiceDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public PaymentInvoiceDTOParam build() {
         return new PaymentInvoiceDTOParam(
            this.auditId, this.practicalInvoice, this.taxRateTypeValue, this.taxRate, this.invoiceNumber, this.auditStatusEnum, this.attachmentId, this.remark
         );
      }

      @Override
      public String toString() {
         return "PaymentInvoiceDTOParam.PaymentInvoiceDTOParamBuilder(auditId="
            + this.auditId
            + ", practicalInvoice="
            + this.practicalInvoice
            + ", taxRateTypeValue="
            + this.taxRateTypeValue
            + ", taxRate="
            + this.taxRate
            + ", invoiceNumber="
            + this.invoiceNumber
            + ", auditStatusEnum="
            + this.auditStatusEnum
            + ", attachmentId="
            + this.attachmentId
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
