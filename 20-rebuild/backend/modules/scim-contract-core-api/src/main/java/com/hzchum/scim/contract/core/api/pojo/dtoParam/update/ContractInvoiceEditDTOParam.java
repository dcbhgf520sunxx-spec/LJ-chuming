package com.hzchum.scim.contract.core.api.pojo.dtoParam.update;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.contract.core.api.enums.payment.InvoiceTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel("编辑 发票填报 请求类")
public class ContractInvoiceEditDTOParam {
   @ApiModelProperty(name = "id", value = "开票id")
   @NotNull(message = "开票填报id不能为空")
   private Long id;
   @ApiModelProperty(name = "invoiceAmount", value = "发票面额")
   @NotNull(message = "发票面额不能为空")
   private BigDecimal invoiceAmount;
   @ApiModelProperty(name = "collectionUnit", value = "收票单位")
   @NotBlank(message = "收票单位不能为空")
   @Size(max = 50, message = "收票单位名称过长,超出限制!")
   private String collectionUnit;
   @ApiModelProperty(name = "invoiceDate", value = "发票日期")
   @NotNull(message = "发票日期不能为空")
   private LocalDateTime invoiceDate;
   @ApiModelProperty(name = "invoiceNo", value = "发票号码")
   @Size(max = 250, message = "发票号码长度太长,超出限制!")
   @NotBlank(message = "发票号码不能为空")
   private String invoiceNo;
   @ApiModelProperty(name = "invoiceType", value = "发票类型 1增值专用票 2增值普发票 4收据")
   @NotNull(message = "发票类型不能为空")
   @EnumValidator(value = InvoiceTypeEnum.class, message = "发票类型错误!")
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
   @Size(max = 250, message = "备注内容字数太多,超出限制!")
   private String remark;
   @ApiModelProperty(name = "attachmentIds", value = "附件id数组")
   @Size(max = 20, message = "附件数量不能超过20个!")
   private List<Long> attachmentIds;

   public static ContractInvoiceEditDTOParam.ContractInvoiceEditDTOParamBuilder builder() {
      return new ContractInvoiceEditDTOParam.ContractInvoiceEditDTOParamBuilder();
   }

   public ContractInvoiceEditDTOParam() {
   }

   public ContractInvoiceEditDTOParam(
      final Long id,
      final BigDecimal invoiceAmount,
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
      this.id = id;
      this.invoiceAmount = invoiceAmount;
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

   public Long getId() {
      return this.id;
   }

   public BigDecimal getInvoiceAmount() {
      return this.invoiceAmount;
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

   public void setId(final Long id) {
      this.id = id;
   }

   public void setInvoiceAmount(final BigDecimal invoiceAmount) {
      this.invoiceAmount = invoiceAmount;
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

      if (!(o instanceof ContractInvoiceEditDTOParam)) {
         return false;
      }

      ContractInvoiceEditDTOParam other = (ContractInvoiceEditDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ContractInvoiceEditDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
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
      return "ContractInvoiceEditDTOParam(id="
         + this.getId()
         + ", invoiceAmount="
         + this.getInvoiceAmount()
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

   public static class ContractInvoiceEditDTOParamBuilder {
      private Long id;
      private BigDecimal invoiceAmount;
      private String collectionUnit;
      private LocalDateTime invoiceDate;
      private String invoiceNo;
      private Integer invoiceType;
      private Boolean boolIncludeTax;
      private BigDecimal taxRate;
      private String invoiceContent;
      private String remark;
      private List<Long> attachmentIds;

      ContractInvoiceEditDTOParamBuilder() {
      }

      public ContractInvoiceEditDTOParam.ContractInvoiceEditDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractInvoiceEditDTOParam.ContractInvoiceEditDTOParamBuilder invoiceAmount(final BigDecimal invoiceAmount) {
         this.invoiceAmount = invoiceAmount;
         return this;
      }

      public ContractInvoiceEditDTOParam.ContractInvoiceEditDTOParamBuilder collectionUnit(final String collectionUnit) {
         this.collectionUnit = collectionUnit;
         return this;
      }

      public ContractInvoiceEditDTOParam.ContractInvoiceEditDTOParamBuilder invoiceDate(final LocalDateTime invoiceDate) {
         this.invoiceDate = invoiceDate;
         return this;
      }

      public ContractInvoiceEditDTOParam.ContractInvoiceEditDTOParamBuilder invoiceNo(final String invoiceNo) {
         this.invoiceNo = invoiceNo;
         return this;
      }

      public ContractInvoiceEditDTOParam.ContractInvoiceEditDTOParamBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public ContractInvoiceEditDTOParam.ContractInvoiceEditDTOParamBuilder boolIncludeTax(final Boolean boolIncludeTax) {
         this.boolIncludeTax = boolIncludeTax;
         return this;
      }

      public ContractInvoiceEditDTOParam.ContractInvoiceEditDTOParamBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public ContractInvoiceEditDTOParam.ContractInvoiceEditDTOParamBuilder invoiceContent(final String invoiceContent) {
         this.invoiceContent = invoiceContent;
         return this;
      }

      public ContractInvoiceEditDTOParam.ContractInvoiceEditDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractInvoiceEditDTOParam.ContractInvoiceEditDTOParamBuilder attachmentIds(final List<Long> attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public ContractInvoiceEditDTOParam build() {
         return new ContractInvoiceEditDTOParam(
            this.id,
            this.invoiceAmount,
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
         return "ContractInvoiceEditDTOParam.ContractInvoiceEditDTOParamBuilder(id="
            + this.id
            + ", invoiceAmount="
            + this.invoiceAmount
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
