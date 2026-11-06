package com.hzchum.scim.contract.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel("新增发票填报 请求类")
public class ContractInvoiceSaveDTOParam {
   @ApiModelProperty(name = "type", value = "开票类型")
   private Integer type;
   @ApiModelProperty(name = "projectId", value = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "contractWasteId", value = "废料合同id")
   private Long contractWasteId;
   @ApiModelProperty(name = "invoiceAmount", value = "发票面额")
   @NotNull(message = "发票面额不能为空")
   private BigDecimal invoiceAmount;
   @ApiModelProperty(name = "invoiceUnitId", value = "开票单位id")
   @NotNull(message = "开票单位不能为空")
   private Long invoiceUnitId;
   @ApiModelProperty(name = "collectionUnit", value = "收票单位")
   @NotBlank(message = "收票单位不能为空")
   private String collectionUnit;
   @ApiModelProperty(name = "invoiceDate", value = "发票日期")
   @NotNull(message = "开票日期不能为空")
   private LocalDateTime invoiceDate;
   @ApiModelProperty(name = "invoiceNo", value = "发票号码")
   @NotBlank(message = "发票号码不能为空")
   @Size(max = 250, message = "发票号码长度太长,超出限制!")
   private String invoiceNo;
   @ApiModelProperty(name = "invoiceType", value = "发票类型 1增值专用票 2增值普发票 4收据")
   private Integer invoiceType;
   @ApiModelProperty(name = "bool_include_tax", value = "是否含税 true含税 false免税")
   @NotNull(message = "是否含税不能为空!")
   private Boolean boolIncludeTax;
   @ApiModelProperty(name = "taxRate", value = "税率")
   @DecimalMin(value = "0.0", message = "税率不能为负数!")
   private BigDecimal taxRate;
   @ApiModelProperty(name = "invoiceContent", value = "发票内容")
   @Size(max = 250, message = "发票内容字数太多,超出限制!")
   private String invoiceContent;
   @ApiModelProperty(name = "remark", value = "备注")
   @Size(max = 250, message = "备注字数太多,超出限制!")
   private String remark;
   @ApiModelProperty(name = "attachmentIds", value = "附件id数组")
   @Size(max = 20, message = "附件数量不能超过20个!")
   private List<Long> attachmentIds;

   public static ContractInvoiceSaveDTOParam.ContractInvoiceSaveDTOParamBuilder builder() {
      return new ContractInvoiceSaveDTOParam.ContractInvoiceSaveDTOParamBuilder();
   }

   public ContractInvoiceSaveDTOParam() {
   }

   public ContractInvoiceSaveDTOParam(
      final Integer type,
      final Long projectId,
      final Long contractWasteId,
      final BigDecimal invoiceAmount,
      final Long invoiceUnitId,
      final String collectionUnit,
      final LocalDateTime invoiceDate,
      final String invoiceNo,
      final Integer invoiceType,
      final Boolean boolIncludeTax,
      final BigDecimal taxRate,
      final String invoiceContent,
      final String remark,
      final List<Long> attachmentIds
   ) {
      this.type = type;
      this.projectId = projectId;
      this.contractWasteId = contractWasteId;
      this.invoiceAmount = invoiceAmount;
      this.invoiceUnitId = invoiceUnitId;
      this.collectionUnit = collectionUnit;
      this.invoiceDate = invoiceDate;
      this.invoiceNo = invoiceNo;
      this.invoiceType = invoiceType;
      this.boolIncludeTax = boolIncludeTax;
      this.taxRate = taxRate;
      this.invoiceContent = invoiceContent;
      this.remark = remark;
      this.attachmentIds = attachmentIds;
   }

   public Integer getType() {
      return this.type;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getContractWasteId() {
      return this.contractWasteId;
   }

   public BigDecimal getInvoiceAmount() {
      return this.invoiceAmount;
   }

   public Long getInvoiceUnitId() {
      return this.invoiceUnitId;
   }

   public String getCollectionUnit() {
      return this.collectionUnit;
   }

   public LocalDateTime getInvoiceDate() {
      return this.invoiceDate;
   }

   public String getInvoiceNo() {
      return this.invoiceNo;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public Boolean getBoolIncludeTax() {
      return this.boolIncludeTax;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public String getInvoiceContent() {
      return this.invoiceContent;
   }

   public String getRemark() {
      return this.remark;
   }

   public List<Long> getAttachmentIds() {
      return this.attachmentIds;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setContractWasteId(final Long contractWasteId) {
      this.contractWasteId = contractWasteId;
   }

   public void setInvoiceAmount(final BigDecimal invoiceAmount) {
      this.invoiceAmount = invoiceAmount;
   }

   public void setInvoiceUnitId(final Long invoiceUnitId) {
      this.invoiceUnitId = invoiceUnitId;
   }

   public void setCollectionUnit(final String collectionUnit) {
      this.collectionUnit = collectionUnit;
   }

   public void setInvoiceDate(final LocalDateTime invoiceDate) {
      this.invoiceDate = invoiceDate;
   }

   public void setInvoiceNo(final String invoiceNo) {
      this.invoiceNo = invoiceNo;
   }

   public void setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
   }

   public void setBoolIncludeTax(final Boolean boolIncludeTax) {
      this.boolIncludeTax = boolIncludeTax;
   }

   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
   }

   public void setInvoiceContent(final String invoiceContent) {
      this.invoiceContent = invoiceContent;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setAttachmentIds(final List<Long> attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractInvoiceSaveDTOParam)) {
         return false;
      }

      ContractInvoiceSaveDTOParam other = (ContractInvoiceSaveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$type = this.getType();
      Object other$type = other.getType();
      if (this$type == null ? other$type == null : this$type.equals(other$type)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$contractWasteId = this.getContractWasteId();
            Object other$contractWasteId = other.getContractWasteId();
            if (this$contractWasteId == null ? other$contractWasteId == null : this$contractWasteId.equals(other$contractWasteId)) {
               Object this$invoiceUnitId = this.getInvoiceUnitId();
               Object other$invoiceUnitId = other.getInvoiceUnitId();
               if (this$invoiceUnitId == null ? other$invoiceUnitId == null : this$invoiceUnitId.equals(other$invoiceUnitId)) {
                  Object this$invoiceType = this.getInvoiceType();
                  Object other$invoiceType = other.getInvoiceType();
                  if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                     Object this$boolIncludeTax = this.getBoolIncludeTax();
                     Object other$boolIncludeTax = other.getBoolIncludeTax();
                     if (this$boolIncludeTax == null ? other$boolIncludeTax == null : this$boolIncludeTax.equals(other$boolIncludeTax)) {
                        Object this$invoiceAmount = this.getInvoiceAmount();
                        Object other$invoiceAmount = other.getInvoiceAmount();
                        if (this$invoiceAmount == null ? other$invoiceAmount == null : this$invoiceAmount.equals(other$invoiceAmount)) {
                           Object this$collectionUnit = this.getCollectionUnit();
                           Object other$collectionUnit = other.getCollectionUnit();
                           if (this$collectionUnit == null ? other$collectionUnit == null : this$collectionUnit.equals(other$collectionUnit)) {
                              Object this$invoiceDate = this.getInvoiceDate();
                              Object other$invoiceDate = other.getInvoiceDate();
                              if (this$invoiceDate == null ? other$invoiceDate == null : this$invoiceDate.equals(other$invoiceDate)) {
                                 Object this$invoiceNo = this.getInvoiceNo();
                                 Object other$invoiceNo = other.getInvoiceNo();
                                 if (this$invoiceNo == null ? other$invoiceNo == null : this$invoiceNo.equals(other$invoiceNo)) {
                                    Object this$taxRate = this.getTaxRate();
                                    Object other$taxRate = other.getTaxRate();
                                    if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
                                       Object this$invoiceContent = this.getInvoiceContent();
                                       Object other$invoiceContent = other.getInvoiceContent();
                                       if (this$invoiceContent == null ? other$invoiceContent == null : this$invoiceContent.equals(other$invoiceContent)) {
                                          Object this$remark = this.getRemark();
                                          Object other$remark = other.getRemark();
                                          if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
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
      return other instanceof ContractInvoiceSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $contractWasteId = this.getContractWasteId();
      result = result * 59 + ($contractWasteId == null ? 43 : $contractWasteId.hashCode());
      Object $invoiceUnitId = this.getInvoiceUnitId();
      result = result * 59 + ($invoiceUnitId == null ? 43 : $invoiceUnitId.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $boolIncludeTax = this.getBoolIncludeTax();
      result = result * 59 + ($boolIncludeTax == null ? 43 : $boolIncludeTax.hashCode());
      Object $invoiceAmount = this.getInvoiceAmount();
      result = result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
      Object $collectionUnit = this.getCollectionUnit();
      result = result * 59 + ($collectionUnit == null ? 43 : $collectionUnit.hashCode());
      Object $invoiceDate = this.getInvoiceDate();
      result = result * 59 + ($invoiceDate == null ? 43 : $invoiceDate.hashCode());
      Object $invoiceNo = this.getInvoiceNo();
      result = result * 59 + ($invoiceNo == null ? 43 : $invoiceNo.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $invoiceContent = this.getInvoiceContent();
      result = result * 59 + ($invoiceContent == null ? 43 : $invoiceContent.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      return result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
   }

   @Override
   public String toString() {
      return "ContractInvoiceSaveDTOParam(type="
         + this.getType()
         + ", projectId="
         + this.getProjectId()
         + ", contractWasteId="
         + this.getContractWasteId()
         + ", invoiceAmount="
         + this.getInvoiceAmount()
         + ", invoiceUnitId="
         + this.getInvoiceUnitId()
         + ", collectionUnit="
         + this.getCollectionUnit()
         + ", invoiceDate="
         + this.getInvoiceDate()
         + ", invoiceNo="
         + this.getInvoiceNo()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", boolIncludeTax="
         + this.getBoolIncludeTax()
         + ", taxRate="
         + this.getTaxRate()
         + ", invoiceContent="
         + this.getInvoiceContent()
         + ", remark="
         + this.getRemark()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ")";
   }

   public static class ContractInvoiceSaveDTOParamBuilder {
      private Integer type;
      private Long projectId;
      private Long contractWasteId;
      private BigDecimal invoiceAmount;
      private Long invoiceUnitId;
      private String collectionUnit;
      private LocalDateTime invoiceDate;
      private String invoiceNo;
      private Integer invoiceType;
      private Boolean boolIncludeTax;
      private BigDecimal taxRate;
      private String invoiceContent;
      private String remark;
      private List<Long> attachmentIds;

      ContractInvoiceSaveDTOParamBuilder() {
      }

      public ContractInvoiceSaveDTOParam.ContractInvoiceSaveDTOParamBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public ContractInvoiceSaveDTOParam.ContractInvoiceSaveDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ContractInvoiceSaveDTOParam.ContractInvoiceSaveDTOParamBuilder contractWasteId(final Long contractWasteId) {
         this.contractWasteId = contractWasteId;
         return this;
      }

      public ContractInvoiceSaveDTOParam.ContractInvoiceSaveDTOParamBuilder invoiceAmount(final BigDecimal invoiceAmount) {
         this.invoiceAmount = invoiceAmount;
         return this;
      }

      public ContractInvoiceSaveDTOParam.ContractInvoiceSaveDTOParamBuilder invoiceUnitId(final Long invoiceUnitId) {
         this.invoiceUnitId = invoiceUnitId;
         return this;
      }

      public ContractInvoiceSaveDTOParam.ContractInvoiceSaveDTOParamBuilder collectionUnit(final String collectionUnit) {
         this.collectionUnit = collectionUnit;
         return this;
      }

      public ContractInvoiceSaveDTOParam.ContractInvoiceSaveDTOParamBuilder invoiceDate(final LocalDateTime invoiceDate) {
         this.invoiceDate = invoiceDate;
         return this;
      }

      public ContractInvoiceSaveDTOParam.ContractInvoiceSaveDTOParamBuilder invoiceNo(final String invoiceNo) {
         this.invoiceNo = invoiceNo;
         return this;
      }

      public ContractInvoiceSaveDTOParam.ContractInvoiceSaveDTOParamBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public ContractInvoiceSaveDTOParam.ContractInvoiceSaveDTOParamBuilder boolIncludeTax(final Boolean boolIncludeTax) {
         this.boolIncludeTax = boolIncludeTax;
         return this;
      }

      public ContractInvoiceSaveDTOParam.ContractInvoiceSaveDTOParamBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public ContractInvoiceSaveDTOParam.ContractInvoiceSaveDTOParamBuilder invoiceContent(final String invoiceContent) {
         this.invoiceContent = invoiceContent;
         return this;
      }

      public ContractInvoiceSaveDTOParam.ContractInvoiceSaveDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractInvoiceSaveDTOParam.ContractInvoiceSaveDTOParamBuilder attachmentIds(final List<Long> attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public ContractInvoiceSaveDTOParam build() {
         return new ContractInvoiceSaveDTOParam(
            this.type,
            this.projectId,
            this.contractWasteId,
            this.invoiceAmount,
            this.invoiceUnitId,
            this.collectionUnit,
            this.invoiceDate,
            this.invoiceNo,
            this.invoiceType,
            this.boolIncludeTax,
            this.taxRate,
            this.invoiceContent,
            this.remark,
            this.attachmentIds
         );
      }

      @Override
      public String toString() {
         return "ContractInvoiceSaveDTOParam.ContractInvoiceSaveDTOParamBuilder(type="
            + this.type
            + ", projectId="
            + this.projectId
            + ", contractWasteId="
            + this.contractWasteId
            + ", invoiceAmount="
            + this.invoiceAmount
            + ", invoiceUnitId="
            + this.invoiceUnitId
            + ", collectionUnit="
            + this.collectionUnit
            + ", invoiceDate="
            + this.invoiceDate
            + ", invoiceNo="
            + this.invoiceNo
            + ", invoiceType="
            + this.invoiceType
            + ", boolIncludeTax="
            + this.boolIncludeTax
            + ", taxRate="
            + this.taxRate
            + ", invoiceContent="
            + this.invoiceContent
            + ", remark="
            + this.remark
            + ", attachmentIds="
            + this.attachmentIds
            + ")";
      }
   }
}
