package com.hzchum.scim.scm.core.api.pojo.dtoParam;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.scm.core.api.enums.SubSupplyTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel("saveSubcontractOrderDTOParam")
public class SaveSubcontractOrderDTOParam {
   @ApiModelProperty(name = "id", value = "订单id", notes = "订单id")
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @NotNull(message = "项目ID不能为空")
   private Long projectId;
   @ApiModelProperty(name = "signDate", value = "签订日期", notes = "签订日期")
   private LocalDate signDate;
   @ApiModelProperty(name = "userId", value = "创建人id", notes = "创建人id")
   private Long userId;
   @ApiModelProperty(name = "serialNumber", value = "订单编号", notes = "订单编号")
   private String serialNumber;
   @ApiModelProperty(name = "subcontractClassId", value = "分供类型id", notes = "分供类型id")
   @NotNull(message = "分包类型不能为空")
   @EnumValidator(value = SubSupplyTypeEnum.class, message = "分供类型有误!")
   private Long subcontractClassId;
   @ApiModelProperty(name = "subcontractClassName", value = "分供类型", notes = "分供类型")
   private String subcontractClassName;
   @ApiModelProperty(name = "supplierId", value = "分包单位(供应商)id", notes = "分包单位(供应商)id")
   @NotNull(message = "分包单位ID不能为空")
   private Long supplierId;
   @ApiModelProperty(name = "supplierName", value = "分包单位(供应商)", notes = "分包单位(供应商)")
   private String supplierName;
   @ApiModelProperty(name = "branchCompanyId", value = "签订主体公司ID")
   @NotNull(message = "签订主体id不能为空!")
   private Long branchCompanyId;
   @ApiModelProperty(name = "amount", value = "合同金额", notes = "合同金额")
   @NotNull(message = "合同额不能为空")
   @DecimalMin(value = "0", message = "合同金额不能为负数!")
   private BigDecimal amount;
   @ApiModelProperty(name = "invoiceType", value = "发票类型", notes = "发票类型")
   @NotNull(message = "发票类型不能为空")
   private Integer invoiceType;
   @ApiModelProperty(name = "taxRateTypeValue", value = "字典税率value值", notes = "字典税率value值")
   private String taxRateTypeValue;
   @ApiModelProperty(name = "taxRate", value = "税率", notes = "税率")
   private BigDecimal taxRate;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @Size(max = 1000, message = "备注字数超出限制")
   private String remark;
   @ApiModelProperty(name = "monomerIds", value = "单体ID列表")
   private Set<Long> monomerIds;
   @ApiModelProperty(name = "attachmentIds", value = "附件ID列表", notes = "附件ID列表")
   private Set<Long> attachmentIds;
   @ApiModelProperty(name = "level", value = "单位等级")
   private Integer level;

   public static SaveSubcontractOrderDTOParam.SaveSubcontractOrderDTOParamBuilder builder() {
      return new SaveSubcontractOrderDTOParam.SaveSubcontractOrderDTOParamBuilder();
   }

   public SaveSubcontractOrderDTOParam() {
   }

   public SaveSubcontractOrderDTOParam(
      final Long id,
      final Long projectId,
      final LocalDate signDate,
      final Long userId,
      final String serialNumber,
      final Long subcontractClassId,
      final String subcontractClassName,
      final Long supplierId,
      final String supplierName,
      final Long branchCompanyId,
      final BigDecimal amount,
      final Integer invoiceType,
      final String taxRateTypeValue,
      final BigDecimal taxRate,
      final String remark,
      final Set<Long> monomerIds,
      final Set<Long> attachmentIds,
      final Integer level
   ) {
      this.id = id;
      this.projectId = projectId;
      this.signDate = signDate;
      this.userId = userId;
      this.serialNumber = serialNumber;
      this.subcontractClassId = subcontractClassId;
      this.subcontractClassName = subcontractClassName;
      this.supplierId = supplierId;
      this.supplierName = supplierName;
      this.branchCompanyId = branchCompanyId;
      this.amount = amount;
      this.invoiceType = invoiceType;
      this.taxRateTypeValue = taxRateTypeValue;
      this.taxRate = taxRate;
      this.remark = remark;
      this.monomerIds = monomerIds;
      this.attachmentIds = attachmentIds;
      this.level = level;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public LocalDate getSignDate() {
      return this.signDate;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getSubcontractClassId() {
      return this.subcontractClassId;
   }

   public String getSubcontractClassName() {
      return this.subcontractClassName;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public String getTaxRateTypeValue() {
      return this.taxRateTypeValue;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public String getRemark() {
      return this.remark;
   }

   public Set<Long> getMonomerIds() {
      return this.monomerIds;
   }

   public Set<Long> getAttachmentIds() {
      return this.attachmentIds;
   }

   public Integer getLevel() {
      return this.level;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setSignDate(final LocalDate signDate) {
      this.signDate = signDate;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSubcontractClassId(final Long subcontractClassId) {
      this.subcontractClassId = subcontractClassId;
   }

   public void setSubcontractClassName(final String subcontractClassName) {
      this.subcontractClassName = subcontractClassName;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
   }

   public void setTaxRateTypeValue(final String taxRateTypeValue) {
      this.taxRateTypeValue = taxRateTypeValue;
   }

   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setMonomerIds(final Set<Long> monomerIds) {
      this.monomerIds = monomerIds;
   }

   public void setAttachmentIds(final Set<Long> attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   public void setLevel(final Integer level) {
      this.level = level;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SaveSubcontractOrderDTOParam)) {
         return false;
      }

      SaveSubcontractOrderDTOParam other = (SaveSubcontractOrderDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$userId = this.getUserId();
            Object other$userId = other.getUserId();
            if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
               Object this$subcontractClassId = this.getSubcontractClassId();
               Object other$subcontractClassId = other.getSubcontractClassId();
               if (this$subcontractClassId == null ? other$subcontractClassId == null : this$subcontractClassId.equals(other$subcontractClassId)) {
                  Object this$supplierId = this.getSupplierId();
                  Object other$supplierId = other.getSupplierId();
                  if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                     Object this$branchCompanyId = this.getBranchCompanyId();
                     Object other$branchCompanyId = other.getBranchCompanyId();
                     if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
                        Object this$invoiceType = this.getInvoiceType();
                        Object other$invoiceType = other.getInvoiceType();
                        if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                           Object this$level = this.getLevel();
                           Object other$level = other.getLevel();
                           if (this$level == null ? other$level == null : this$level.equals(other$level)) {
                              Object this$signDate = this.getSignDate();
                              Object other$signDate = other.getSignDate();
                              if (this$signDate == null ? other$signDate == null : this$signDate.equals(other$signDate)) {
                                 Object this$serialNumber = this.getSerialNumber();
                                 Object other$serialNumber = other.getSerialNumber();
                                 if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                    Object this$subcontractClassName = this.getSubcontractClassName();
                                    Object other$subcontractClassName = other.getSubcontractClassName();
                                    if (this$subcontractClassName == null
                                       ? other$subcontractClassName == null
                                       : this$subcontractClassName.equals(other$subcontractClassName)) {
                                       Object this$supplierName = this.getSupplierName();
                                       Object other$supplierName = other.getSupplierName();
                                       if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                                          Object this$amount = this.getAmount();
                                          Object other$amount = other.getAmount();
                                          if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                             Object this$taxRateTypeValue = this.getTaxRateTypeValue();
                                             Object other$taxRateTypeValue = other.getTaxRateTypeValue();
                                             if (this$taxRateTypeValue == null
                                                ? other$taxRateTypeValue == null
                                                : this$taxRateTypeValue.equals(other$taxRateTypeValue)) {
                                                Object this$taxRate = this.getTaxRate();
                                                Object other$taxRate = other.getTaxRate();
                                                if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
                                                   Object this$remark = this.getRemark();
                                                   Object other$remark = other.getRemark();
                                                   if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                      Object this$monomerIds = this.getMonomerIds();
                                                      Object other$monomerIds = other.getMonomerIds();
                                                      if (this$monomerIds == null ? other$monomerIds == null : this$monomerIds.equals(other$monomerIds)) {
                                                         Object this$attachmentIds = this.getAttachmentIds();
                                                         Object other$attachmentIds = other.getAttachmentIds();
                                                         return this$attachmentIds == null
                                                            ? other$attachmentIds == null
                                                            : this$attachmentIds.equals(other$attachmentIds);
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
      return other instanceof SaveSubcontractOrderDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $subcontractClassId = this.getSubcontractClassId();
      result = result * 59 + ($subcontractClassId == null ? 43 : $subcontractClassId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $level = this.getLevel();
      result = result * 59 + ($level == null ? 43 : $level.hashCode());
      Object $signDate = this.getSignDate();
      result = result * 59 + ($signDate == null ? 43 : $signDate.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $subcontractClassName = this.getSubcontractClassName();
      result = result * 59 + ($subcontractClassName == null ? 43 : $subcontractClassName.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $taxRateTypeValue = this.getTaxRateTypeValue();
      result = result * 59 + ($taxRateTypeValue == null ? 43 : $taxRateTypeValue.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $monomerIds = this.getMonomerIds();
      result = result * 59 + ($monomerIds == null ? 43 : $monomerIds.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      return result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
   }

   @Override
   public String toString() {
      return "SaveSubcontractOrderDTOParam(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", signDate="
         + this.getSignDate()
         + ", userId="
         + this.getUserId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", subcontractClassId="
         + this.getSubcontractClassId()
         + ", subcontractClassName="
         + this.getSubcontractClassName()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", amount="
         + this.getAmount()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", taxRateTypeValue="
         + this.getTaxRateTypeValue()
         + ", taxRate="
         + this.getTaxRate()
         + ", remark="
         + this.getRemark()
         + ", monomerIds="
         + this.getMonomerIds()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", level="
         + this.getLevel()
         + ")";
   }

   public static class SaveSubcontractOrderDTOParamBuilder {
      private Long id;
      private Long projectId;
      private LocalDate signDate;
      private Long userId;
      private String serialNumber;
      private Long subcontractClassId;
      private String subcontractClassName;
      private Long supplierId;
      private String supplierName;
      private Long branchCompanyId;
      private BigDecimal amount;
      private Integer invoiceType;
      private String taxRateTypeValue;
      private BigDecimal taxRate;
      private String remark;
      private Set<Long> monomerIds;
      private Set<Long> attachmentIds;
      private Integer level;

      SaveSubcontractOrderDTOParamBuilder() {
      }

      public SaveSubcontractOrderDTOParam.SaveSubcontractOrderDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SaveSubcontractOrderDTOParam.SaveSubcontractOrderDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public SaveSubcontractOrderDTOParam.SaveSubcontractOrderDTOParamBuilder signDate(final LocalDate signDate) {
         this.signDate = signDate;
         return this;
      }

      public SaveSubcontractOrderDTOParam.SaveSubcontractOrderDTOParamBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public SaveSubcontractOrderDTOParam.SaveSubcontractOrderDTOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public SaveSubcontractOrderDTOParam.SaveSubcontractOrderDTOParamBuilder subcontractClassId(final Long subcontractClassId) {
         this.subcontractClassId = subcontractClassId;
         return this;
      }

      public SaveSubcontractOrderDTOParam.SaveSubcontractOrderDTOParamBuilder subcontractClassName(final String subcontractClassName) {
         this.subcontractClassName = subcontractClassName;
         return this;
      }

      public SaveSubcontractOrderDTOParam.SaveSubcontractOrderDTOParamBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public SaveSubcontractOrderDTOParam.SaveSubcontractOrderDTOParamBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public SaveSubcontractOrderDTOParam.SaveSubcontractOrderDTOParamBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public SaveSubcontractOrderDTOParam.SaveSubcontractOrderDTOParamBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public SaveSubcontractOrderDTOParam.SaveSubcontractOrderDTOParamBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public SaveSubcontractOrderDTOParam.SaveSubcontractOrderDTOParamBuilder taxRateTypeValue(final String taxRateTypeValue) {
         this.taxRateTypeValue = taxRateTypeValue;
         return this;
      }

      public SaveSubcontractOrderDTOParam.SaveSubcontractOrderDTOParamBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public SaveSubcontractOrderDTOParam.SaveSubcontractOrderDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public SaveSubcontractOrderDTOParam.SaveSubcontractOrderDTOParamBuilder monomerIds(final Set<Long> monomerIds) {
         this.monomerIds = monomerIds;
         return this;
      }

      public SaveSubcontractOrderDTOParam.SaveSubcontractOrderDTOParamBuilder attachmentIds(final Set<Long> attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public SaveSubcontractOrderDTOParam.SaveSubcontractOrderDTOParamBuilder level(final Integer level) {
         this.level = level;
         return this;
      }

      public SaveSubcontractOrderDTOParam build() {
         return new SaveSubcontractOrderDTOParam(
            this.id,
            this.projectId,
            this.signDate,
            this.userId,
            this.serialNumber,
            this.subcontractClassId,
            this.subcontractClassName,
            this.supplierId,
            this.supplierName,
            this.branchCompanyId,
            this.amount,
            this.invoiceType,
            this.taxRateTypeValue,
            this.taxRate,
            this.remark,
            this.monomerIds,
            this.attachmentIds,
            this.level
         );
      }

      @Override
      public String toString() {
         return "SaveSubcontractOrderDTOParam.SaveSubcontractOrderDTOParamBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", signDate="
            + this.signDate
            + ", userId="
            + this.userId
            + ", serialNumber="
            + this.serialNumber
            + ", subcontractClassId="
            + this.subcontractClassId
            + ", subcontractClassName="
            + this.subcontractClassName
            + ", supplierId="
            + this.supplierId
            + ", supplierName="
            + this.supplierName
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", amount="
            + this.amount
            + ", invoiceType="
            + this.invoiceType
            + ", taxRateTypeValue="
            + this.taxRateTypeValue
            + ", taxRate="
            + this.taxRate
            + ", remark="
            + this.remark
            + ", monomerIds="
            + this.monomerIds
            + ", attachmentIds="
            + this.attachmentIds
            + ", level="
            + this.level
            + ")";
      }
   }
}
