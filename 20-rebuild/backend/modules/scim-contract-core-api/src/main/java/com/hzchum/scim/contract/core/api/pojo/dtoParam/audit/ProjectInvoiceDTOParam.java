package com.hzchum.scim.contract.core.api.pojo.dtoParam.audit;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

public class ProjectInvoiceDTOParam {
   @NotNull(message = "审批id不能为空")
   @ApiModelProperty(value = "审批id", notes = "审批id")
   private Long auditId;
   @NotNull(message = "本次实开发票金额不能为空")
   @ApiModelProperty(value = "本次实开发票金额", notes = "本次实开发票金额")
   private BigDecimal invoiceAmount;
   @NotNull(message = "发票税率不能为空")
   @ApiModelProperty(value = "发票税率", notes = "发票税率")
   private BigDecimal invoiceTaxRate;
   @NotNull(message = "发票编号不能为空")
   @ApiModelProperty(value = "发票编号", notes = "发票编号")
   private String invoiceNumber;
   @NotNull(message = "审批信息不能为空")
   @ApiModelProperty(value = "审批信息", notes = "审批信息")
   private Integer auditStatusEnum;
   @ApiModelProperty(value = "备注", notes = "备注")
   private String remark;

   ProjectInvoiceDTOParam(
      final Long auditId,
      final BigDecimal invoiceAmount,
      final BigDecimal invoiceTaxRate,
      final String invoiceNumber,
      final Integer auditStatusEnum,
      final String remark
   ) {
      this.auditId = auditId;
      this.invoiceAmount = invoiceAmount;
      this.invoiceTaxRate = invoiceTaxRate;
      this.invoiceNumber = invoiceNumber;
      this.auditStatusEnum = auditStatusEnum;
      this.remark = remark;
   }

   public static ProjectInvoiceDTOParam.ProjectInvoiceDTOParamBuilder builder() {
      return new ProjectInvoiceDTOParam.ProjectInvoiceDTOParamBuilder();
   }

   public Long getAuditId() {
      return this.auditId;
   }

   public BigDecimal getInvoiceAmount() {
      return this.invoiceAmount;
   }

   public BigDecimal getInvoiceTaxRate() {
      return this.invoiceTaxRate;
   }

   public String getInvoiceNumber() {
      return this.invoiceNumber;
   }

   public Integer getAuditStatusEnum() {
      return this.auditStatusEnum;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setAuditId(final Long auditId) {
      this.auditId = auditId;
   }

   public void setInvoiceAmount(final BigDecimal invoiceAmount) {
      this.invoiceAmount = invoiceAmount;
   }

   public void setInvoiceTaxRate(final BigDecimal invoiceTaxRate) {
      this.invoiceTaxRate = invoiceTaxRate;
   }

   public void setInvoiceNumber(final String invoiceNumber) {
      this.invoiceNumber = invoiceNumber;
   }

   public void setAuditStatusEnum(final Integer auditStatusEnum) {
      this.auditStatusEnum = auditStatusEnum;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectInvoiceDTOParam)) {
         return false;
      }

      ProjectInvoiceDTOParam other = (ProjectInvoiceDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$auditId = this.getAuditId();
      Object other$auditId = other.getAuditId();
      if (this$auditId == null ? other$auditId == null : this$auditId.equals(other$auditId)) {
         Object this$auditStatusEnum = this.getAuditStatusEnum();
         Object other$auditStatusEnum = other.getAuditStatusEnum();
         if (this$auditStatusEnum == null ? other$auditStatusEnum == null : this$auditStatusEnum.equals(other$auditStatusEnum)) {
            Object this$invoiceAmount = this.getInvoiceAmount();
            Object other$invoiceAmount = other.getInvoiceAmount();
            if (this$invoiceAmount == null ? other$invoiceAmount == null : this$invoiceAmount.equals(other$invoiceAmount)) {
               Object this$invoiceTaxRate = this.getInvoiceTaxRate();
               Object other$invoiceTaxRate = other.getInvoiceTaxRate();
               if (this$invoiceTaxRate == null ? other$invoiceTaxRate == null : this$invoiceTaxRate.equals(other$invoiceTaxRate)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectInvoiceDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $auditId = this.getAuditId();
      result = result * 59 + ($auditId == null ? 43 : $auditId.hashCode());
      Object $auditStatusEnum = this.getAuditStatusEnum();
      result = result * 59 + ($auditStatusEnum == null ? 43 : $auditStatusEnum.hashCode());
      Object $invoiceAmount = this.getInvoiceAmount();
      result = result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
      Object $invoiceTaxRate = this.getInvoiceTaxRate();
      result = result * 59 + ($invoiceTaxRate == null ? 43 : $invoiceTaxRate.hashCode());
      Object $invoiceNumber = this.getInvoiceNumber();
      result = result * 59 + ($invoiceNumber == null ? 43 : $invoiceNumber.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectInvoiceDTOParam(auditId="
         + this.getAuditId()
         + ", invoiceAmount="
         + this.getInvoiceAmount()
         + ", invoiceTaxRate="
         + this.getInvoiceTaxRate()
         + ", invoiceNumber="
         + this.getInvoiceNumber()
         + ", auditStatusEnum="
         + this.getAuditStatusEnum()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   public static class ProjectInvoiceDTOParamBuilder {
      private Long auditId;
      private BigDecimal invoiceAmount;
      private BigDecimal invoiceTaxRate;
      private String invoiceNumber;
      private Integer auditStatusEnum;
      private String remark;

      ProjectInvoiceDTOParamBuilder() {
      }

      public ProjectInvoiceDTOParam.ProjectInvoiceDTOParamBuilder auditId(final Long auditId) {
         this.auditId = auditId;
         return this;
      }

      public ProjectInvoiceDTOParam.ProjectInvoiceDTOParamBuilder invoiceAmount(final BigDecimal invoiceAmount) {
         this.invoiceAmount = invoiceAmount;
         return this;
      }

      public ProjectInvoiceDTOParam.ProjectInvoiceDTOParamBuilder invoiceTaxRate(final BigDecimal invoiceTaxRate) {
         this.invoiceTaxRate = invoiceTaxRate;
         return this;
      }

      public ProjectInvoiceDTOParam.ProjectInvoiceDTOParamBuilder invoiceNumber(final String invoiceNumber) {
         this.invoiceNumber = invoiceNumber;
         return this;
      }

      public ProjectInvoiceDTOParam.ProjectInvoiceDTOParamBuilder auditStatusEnum(final Integer auditStatusEnum) {
         this.auditStatusEnum = auditStatusEnum;
         return this;
      }

      public ProjectInvoiceDTOParam.ProjectInvoiceDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ProjectInvoiceDTOParam build() {
         return new ProjectInvoiceDTOParam(this.auditId, this.invoiceAmount, this.invoiceTaxRate, this.invoiceNumber, this.auditStatusEnum, this.remark);
      }

      @Override
      public String toString() {
         return "ProjectInvoiceDTOParam.ProjectInvoiceDTOParamBuilder(auditId="
            + this.auditId
            + ", invoiceAmount="
            + this.invoiceAmount
            + ", invoiceTaxRate="
            + this.invoiceTaxRate
            + ", invoiceNumber="
            + this.invoiceNumber
            + ", auditStatusEnum="
            + this.auditStatusEnum
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
