package com.hzchum.scim.scm.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel("SubcontractOrderDTO对象")
public class SubcontractOrderSaveDTOParam {
   @ApiModelProperty(name = "serialNumber", value = "订单编号", notes = "订单编号")
   @NotBlank(message = "订单编号不能为空")
   private String serialNumber;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @NotNull(message = "项目ID不能为空")
   private Long projectId;
   @ApiModelProperty(name = "supplierId", value = "分包单位(供应商)id", notes = "分包单位(供应商)id")
   @NotNull(message = "分包单位ID不能为空")
   private Long supplierId;
   @ApiModelProperty(name = "subcontractClassId", value = "分包类别id", notes = "分包类别id")
   @NotNull(message = "分包类别id不能为空")
   private Long subcontractClassId;
   @ApiModelProperty(name = "amount", value = "合同金额", notes = "合同金额")
   @NotNull(message = "合同额不能为空")
   @DecimalMin(value = "0", message = "合同金额不能为负数!")
   private BigDecimal amount;
   @ApiModelProperty(name = "invoiceType", value = "发票类型", notes = "发票类型")
   @NotNull(message = "发票类型不能为空")
   private Integer invoiceType;
   @ApiModelProperty(name = "taxRate", value = "税率", notes = "税率")
   private BigDecimal taxRate;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @Size(max = 1000, message = "备注字数超出限制")
   private String remark;
   @ApiModelProperty(name = "signDate", value = "签订日期", notes = "签订日期")
   private LocalDate signDate;
   @ApiModelProperty(name = "monomerIds", value = "单体ID列表")
   @NotEmpty(message = "单体ID列表不能为空")
   private Set<Long> monomerIds;
   @ApiModelProperty(name = "attachmentIds", value = "附件ID列表", notes = "附件ID列表")
   private Set<Long> attachmentIds;

   public static SubcontractOrderSaveDTOParam.SubcontractOrderSaveDTOParamBuilder builder() {
      return new SubcontractOrderSaveDTOParam.SubcontractOrderSaveDTOParamBuilder();
   }

   public SubcontractOrderSaveDTOParam() {
   }

   public SubcontractOrderSaveDTOParam(
      final String serialNumber,
      final Long projectId,
      final Long supplierId,
      final Long subcontractClassId,
      final BigDecimal amount,
      final Integer invoiceType,
      final BigDecimal taxRate,
      final String remark,
      final LocalDate signDate,
      final Set<Long> monomerIds,
      final Set<Long> attachmentIds
   ) {
      this.serialNumber = serialNumber;
      this.projectId = projectId;
      this.supplierId = supplierId;
      this.subcontractClassId = subcontractClassId;
      this.amount = amount;
      this.invoiceType = invoiceType;
      this.taxRate = taxRate;
      this.remark = remark;
      this.signDate = signDate;
      this.monomerIds = monomerIds;
      this.attachmentIds = attachmentIds;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public Long getSubcontractClassId() {
      return this.subcontractClassId;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public String getRemark() {
      return this.remark;
   }

   public LocalDate getSignDate() {
      return this.signDate;
   }

   public Set<Long> getMonomerIds() {
      return this.monomerIds;
   }

   public Set<Long> getAttachmentIds() {
      return this.attachmentIds;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setSubcontractClassId(final Long subcontractClassId) {
      this.subcontractClassId = subcontractClassId;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
   }

   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setSignDate(final LocalDate signDate) {
      this.signDate = signDate;
   }

   public void setMonomerIds(final Set<Long> monomerIds) {
      this.monomerIds = monomerIds;
   }

   public void setAttachmentIds(final Set<Long> attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SubcontractOrderSaveDTOParam)) {
         return false;
      }

      SubcontractOrderSaveDTOParam other = (SubcontractOrderSaveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$supplierId = this.getSupplierId();
         Object other$supplierId = other.getSupplierId();
         if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
            Object this$subcontractClassId = this.getSubcontractClassId();
            Object other$subcontractClassId = other.getSubcontractClassId();
            if (this$subcontractClassId == null ? other$subcontractClassId == null : this$subcontractClassId.equals(other$subcontractClassId)) {
               Object this$invoiceType = this.getInvoiceType();
               Object other$invoiceType = other.getInvoiceType();
               if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                  Object this$serialNumber = this.getSerialNumber();
                  Object other$serialNumber = other.getSerialNumber();
                  if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                     Object this$amount = this.getAmount();
                     Object other$amount = other.getAmount();
                     if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                        Object this$taxRate = this.getTaxRate();
                        Object other$taxRate = other.getTaxRate();
                        if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
                           Object this$remark = this.getRemark();
                           Object other$remark = other.getRemark();
                           if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                              Object this$signDate = this.getSignDate();
                              Object other$signDate = other.getSignDate();
                              if (this$signDate == null ? other$signDate == null : this$signDate.equals(other$signDate)) {
                                 Object this$monomerIds = this.getMonomerIds();
                                 Object other$monomerIds = other.getMonomerIds();
                                 if (this$monomerIds == null ? other$monomerIds == null : this$monomerIds.equals(other$monomerIds)) {
                                    Object this$attachmentIds = this.getAttachmentIds();
                                    Object other$attachmentIds = other.getAttachmentIds();
                                    return this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds);
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
      return other instanceof SubcontractOrderSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $subcontractClassId = this.getSubcontractClassId();
      result = result * 59 + ($subcontractClassId == null ? 43 : $subcontractClassId.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $signDate = this.getSignDate();
      result = result * 59 + ($signDate == null ? 43 : $signDate.hashCode());
      Object $monomerIds = this.getMonomerIds();
      result = result * 59 + ($monomerIds == null ? 43 : $monomerIds.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      return result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
   }

   @Override
   public String toString() {
      return "SubcontractOrderSaveDTOParam(serialNumber="
         + this.getSerialNumber()
         + ", projectId="
         + this.getProjectId()
         + ", supplierId="
         + this.getSupplierId()
         + ", subcontractClassId="
         + this.getSubcontractClassId()
         + ", amount="
         + this.getAmount()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", taxRate="
         + this.getTaxRate()
         + ", remark="
         + this.getRemark()
         + ", signDate="
         + this.getSignDate()
         + ", monomerIds="
         + this.getMonomerIds()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ")";
   }

   public static class SubcontractOrderSaveDTOParamBuilder {
      private String serialNumber;
      private Long projectId;
      private Long supplierId;
      private Long subcontractClassId;
      private BigDecimal amount;
      private Integer invoiceType;
      private BigDecimal taxRate;
      private String remark;
      private LocalDate signDate;
      private Set<Long> monomerIds;
      private Set<Long> attachmentIds;

      SubcontractOrderSaveDTOParamBuilder() {
      }

      public SubcontractOrderSaveDTOParam.SubcontractOrderSaveDTOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public SubcontractOrderSaveDTOParam.SubcontractOrderSaveDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public SubcontractOrderSaveDTOParam.SubcontractOrderSaveDTOParamBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public SubcontractOrderSaveDTOParam.SubcontractOrderSaveDTOParamBuilder subcontractClassId(final Long subcontractClassId) {
         this.subcontractClassId = subcontractClassId;
         return this;
      }

      public SubcontractOrderSaveDTOParam.SubcontractOrderSaveDTOParamBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public SubcontractOrderSaveDTOParam.SubcontractOrderSaveDTOParamBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public SubcontractOrderSaveDTOParam.SubcontractOrderSaveDTOParamBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public SubcontractOrderSaveDTOParam.SubcontractOrderSaveDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public SubcontractOrderSaveDTOParam.SubcontractOrderSaveDTOParamBuilder signDate(final LocalDate signDate) {
         this.signDate = signDate;
         return this;
      }

      public SubcontractOrderSaveDTOParam.SubcontractOrderSaveDTOParamBuilder monomerIds(final Set<Long> monomerIds) {
         this.monomerIds = monomerIds;
         return this;
      }

      public SubcontractOrderSaveDTOParam.SubcontractOrderSaveDTOParamBuilder attachmentIds(final Set<Long> attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public SubcontractOrderSaveDTOParam build() {
         return new SubcontractOrderSaveDTOParam(
            this.serialNumber,
            this.projectId,
            this.supplierId,
            this.subcontractClassId,
            this.amount,
            this.invoiceType,
            this.taxRate,
            this.remark,
            this.signDate,
            this.monomerIds,
            this.attachmentIds
         );
      }

      @Override
      public String toString() {
         return "SubcontractOrderSaveDTOParam.SubcontractOrderSaveDTOParamBuilder(serialNumber="
            + this.serialNumber
            + ", projectId="
            + this.projectId
            + ", supplierId="
            + this.supplierId
            + ", subcontractClassId="
            + this.subcontractClassId
            + ", amount="
            + this.amount
            + ", invoiceType="
            + this.invoiceType
            + ", taxRate="
            + this.taxRate
            + ", remark="
            + this.remark
            + ", signDate="
            + this.signDate
            + ", monomerIds="
            + this.monomerIds
            + ", attachmentIds="
            + this.attachmentIds
            + ")";
      }
   }
}
