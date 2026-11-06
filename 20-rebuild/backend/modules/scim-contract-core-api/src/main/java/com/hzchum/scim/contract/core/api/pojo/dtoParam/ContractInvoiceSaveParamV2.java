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

@ApiModel("新增项目发票填报-请求类v2")
public class ContractInvoiceSaveParamV2 {
   @ApiModelProperty(name = "projectId", value = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "level", value = "单位等级 1一级单位 2二级单位")
   private Integer level;
   @ApiModelProperty(name = "invoiceAmount", value = "发票面额")
   @NotNull(message = "发票面额不能为空")
   private BigDecimal invoiceAmount;
   @ApiModelProperty(name = "invoiceUnitId", value = "开票单位id")
   @NotNull(message = "开票单位id不能为空!")
   private Long invoiceUnitId;
   @ApiModelProperty(name = "collectionUnit", value = "收票单位")
   @NotBlank(message = "收票单位不能为空")
   private String collectionUnit;
   @ApiModelProperty(name = "invoiceDate", value = "发票日期")
   @NotNull(message = "开票日期不能为空")
   private LocalDateTime invoiceDate;
   @ApiModelProperty(name = "invoiceNo", value = "发票号码")
   @Size(max = 250, message = "发票号码长度太长,超出限制!")
   private String invoiceNo;
   @ApiModelProperty(name = "invoiceType", value = "发票类型 1增值专用票 2增值普发票 4收据")
   private Integer invoiceType;
   @ApiModelProperty(name = "bool_include_tax", value = "是否含税 true含税 false免税")
   private Boolean boolIncludeTax;
   @ApiModelProperty(name = "taxRateTypeValue", value = "字典配置税率value值")
   private String taxRateTypeValue;
   @ApiModelProperty(name = "taxRate", value = "税率")
   @DecimalMin(value = "0.0", message = "税率不能为负数!")
   private BigDecimal taxRate;
   @ApiModelProperty(name = "writtenById", value = "填报人id")
   private Long writtenById;
   @ApiModelProperty(name = "projectManagerId", notes = "项目经理id")
   private Long projectManagerId;
   @ApiModelProperty(name = "paymentDepositBank", value = "付款方银行")
   private String paymentDepositBank;
   @ApiModelProperty(name = "collectionDepositBank", value = "收款开户行")
   private String collectionDepositBank;
   @ApiModelProperty(name = "priceExcludingTax", value = "不含税金额")
   private BigDecimal priceExcludingTax;
   @ApiModelProperty(name = "attachmentIds", value = "附件id数组")
   @Size(max = 20, message = "附件数量不能超过10个!")
   private List<Long> attachmentId;

   public static ContractInvoiceSaveParamV2.ContractInvoiceSaveParamV2Builder builder() {
      return new ContractInvoiceSaveParamV2.ContractInvoiceSaveParamV2Builder();
   }

   public ContractInvoiceSaveParamV2() {
   }

   public ContractInvoiceSaveParamV2(
      final Long projectId,
      final Integer level,
      final BigDecimal invoiceAmount,
      final Long invoiceUnitId,
      final String collectionUnit,
      final LocalDateTime invoiceDate,
      final String invoiceNo,
      final Integer invoiceType,
      final Boolean boolIncludeTax,
      final String taxRateTypeValue,
      final BigDecimal taxRate,
      final Long writtenById,
      final Long projectManagerId,
      final String paymentDepositBank,
      final String collectionDepositBank,
      final BigDecimal priceExcludingTax,
      final List<Long> attachmentId
   ) {
      this.projectId = projectId;
      this.level = level;
      this.invoiceAmount = invoiceAmount;
      this.invoiceUnitId = invoiceUnitId;
      this.collectionUnit = collectionUnit;
      this.invoiceDate = invoiceDate;
      this.invoiceNo = invoiceNo;
      this.invoiceType = invoiceType;
      this.boolIncludeTax = boolIncludeTax;
      this.taxRateTypeValue = taxRateTypeValue;
      this.taxRate = taxRate;
      this.writtenById = writtenById;
      this.projectManagerId = projectManagerId;
      this.paymentDepositBank = paymentDepositBank;
      this.collectionDepositBank = collectionDepositBank;
      this.priceExcludingTax = priceExcludingTax;
      this.attachmentId = attachmentId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getLevel() {
      return this.level;
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

   public String getTaxRateTypeValue() {
      return this.taxRateTypeValue;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public Long getWrittenById() {
      return this.writtenById;
   }

   public Long getProjectManagerId() {
      return this.projectManagerId;
   }

   public String getPaymentDepositBank() {
      return this.paymentDepositBank;
   }

   public String getCollectionDepositBank() {
      return this.collectionDepositBank;
   }

   public BigDecimal getPriceExcludingTax() {
      return this.priceExcludingTax;
   }

   public List<Long> getAttachmentId() {
      return this.attachmentId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setLevel(final Integer level) {
      this.level = level;
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

   public void setTaxRateTypeValue(final String taxRateTypeValue) {
      this.taxRateTypeValue = taxRateTypeValue;
   }

   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
   }

   public void setWrittenById(final Long writtenById) {
      this.writtenById = writtenById;
   }

   public void setProjectManagerId(final Long projectManagerId) {
      this.projectManagerId = projectManagerId;
   }

   public void setPaymentDepositBank(final String paymentDepositBank) {
      this.paymentDepositBank = paymentDepositBank;
   }

   public void setCollectionDepositBank(final String collectionDepositBank) {
      this.collectionDepositBank = collectionDepositBank;
   }

   public void setPriceExcludingTax(final BigDecimal priceExcludingTax) {
      this.priceExcludingTax = priceExcludingTax;
   }

   public void setAttachmentId(final List<Long> attachmentId) {
      this.attachmentId = attachmentId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractInvoiceSaveParamV2)) {
         return false;
      }

      ContractInvoiceSaveParamV2 other = (ContractInvoiceSaveParamV2)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$level = this.getLevel();
         Object other$level = other.getLevel();
         if (this$level == null ? other$level == null : this$level.equals(other$level)) {
            Object this$invoiceUnitId = this.getInvoiceUnitId();
            Object other$invoiceUnitId = other.getInvoiceUnitId();
            if (this$invoiceUnitId == null ? other$invoiceUnitId == null : this$invoiceUnitId.equals(other$invoiceUnitId)) {
               Object this$invoiceType = this.getInvoiceType();
               Object other$invoiceType = other.getInvoiceType();
               if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                  Object this$boolIncludeTax = this.getBoolIncludeTax();
                  Object other$boolIncludeTax = other.getBoolIncludeTax();
                  if (this$boolIncludeTax == null ? other$boolIncludeTax == null : this$boolIncludeTax.equals(other$boolIncludeTax)) {
                     Object this$writtenById = this.getWrittenById();
                     Object other$writtenById = other.getWrittenById();
                     if (this$writtenById == null ? other$writtenById == null : this$writtenById.equals(other$writtenById)) {
                        Object this$projectManagerId = this.getProjectManagerId();
                        Object other$projectManagerId = other.getProjectManagerId();
                        if (this$projectManagerId == null ? other$projectManagerId == null : this$projectManagerId.equals(other$projectManagerId)) {
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
                                       Object this$taxRateTypeValue = this.getTaxRateTypeValue();
                                       Object other$taxRateTypeValue = other.getTaxRateTypeValue();
                                       if (this$taxRateTypeValue == null
                                          ? other$taxRateTypeValue == null
                                          : this$taxRateTypeValue.equals(other$taxRateTypeValue)) {
                                          Object this$taxRate = this.getTaxRate();
                                          Object other$taxRate = other.getTaxRate();
                                          if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
                                             Object this$paymentDepositBank = this.getPaymentDepositBank();
                                             Object other$paymentDepositBank = other.getPaymentDepositBank();
                                             if (this$paymentDepositBank == null
                                                ? other$paymentDepositBank == null
                                                : this$paymentDepositBank.equals(other$paymentDepositBank)) {
                                                Object this$collectionDepositBank = this.getCollectionDepositBank();
                                                Object other$collectionDepositBank = other.getCollectionDepositBank();
                                                if (this$collectionDepositBank == null
                                                   ? other$collectionDepositBank == null
                                                   : this$collectionDepositBank.equals(other$collectionDepositBank)) {
                                                   Object this$priceExcludingTax = this.getPriceExcludingTax();
                                                   Object other$priceExcludingTax = other.getPriceExcludingTax();
                                                   if (this$priceExcludingTax == null
                                                      ? other$priceExcludingTax == null
                                                      : this$priceExcludingTax.equals(other$priceExcludingTax)) {
                                                      Object this$attachmentId = this.getAttachmentId();
                                                      Object other$attachmentId = other.getAttachmentId();
                                                      return this$attachmentId == null
                                                         ? other$attachmentId == null
                                                         : this$attachmentId.equals(other$attachmentId);
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
      return other instanceof ContractInvoiceSaveParamV2;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $level = this.getLevel();
      result = result * 59 + ($level == null ? 43 : $level.hashCode());
      Object $invoiceUnitId = this.getInvoiceUnitId();
      result = result * 59 + ($invoiceUnitId == null ? 43 : $invoiceUnitId.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $boolIncludeTax = this.getBoolIncludeTax();
      result = result * 59 + ($boolIncludeTax == null ? 43 : $boolIncludeTax.hashCode());
      Object $writtenById = this.getWrittenById();
      result = result * 59 + ($writtenById == null ? 43 : $writtenById.hashCode());
      Object $projectManagerId = this.getProjectManagerId();
      result = result * 59 + ($projectManagerId == null ? 43 : $projectManagerId.hashCode());
      Object $invoiceAmount = this.getInvoiceAmount();
      result = result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
      Object $collectionUnit = this.getCollectionUnit();
      result = result * 59 + ($collectionUnit == null ? 43 : $collectionUnit.hashCode());
      Object $invoiceDate = this.getInvoiceDate();
      result = result * 59 + ($invoiceDate == null ? 43 : $invoiceDate.hashCode());
      Object $invoiceNo = this.getInvoiceNo();
      result = result * 59 + ($invoiceNo == null ? 43 : $invoiceNo.hashCode());
      Object $taxRateTypeValue = this.getTaxRateTypeValue();
      result = result * 59 + ($taxRateTypeValue == null ? 43 : $taxRateTypeValue.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $paymentDepositBank = this.getPaymentDepositBank();
      result = result * 59 + ($paymentDepositBank == null ? 43 : $paymentDepositBank.hashCode());
      Object $collectionDepositBank = this.getCollectionDepositBank();
      result = result * 59 + ($collectionDepositBank == null ? 43 : $collectionDepositBank.hashCode());
      Object $priceExcludingTax = this.getPriceExcludingTax();
      result = result * 59 + ($priceExcludingTax == null ? 43 : $priceExcludingTax.hashCode());
      Object $attachmentId = this.getAttachmentId();
      return result * 59 + ($attachmentId == null ? 43 : $attachmentId.hashCode());
   }

   @Override
   public String toString() {
      return "ContractInvoiceSaveParamV2(projectId="
         + this.getProjectId()
         + ", level="
         + this.getLevel()
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
         + ", taxRateTypeValue="
         + this.getTaxRateTypeValue()
         + ", taxRate="
         + this.getTaxRate()
         + ", writtenById="
         + this.getWrittenById()
         + ", projectManagerId="
         + this.getProjectManagerId()
         + ", paymentDepositBank="
         + this.getPaymentDepositBank()
         + ", collectionDepositBank="
         + this.getCollectionDepositBank()
         + ", priceExcludingTax="
         + this.getPriceExcludingTax()
         + ", attachmentId="
         + this.getAttachmentId()
         + ")";
   }

   public static class ContractInvoiceSaveParamV2Builder {
      private Long projectId;
      private Integer level;
      private BigDecimal invoiceAmount;
      private Long invoiceUnitId;
      private String collectionUnit;
      private LocalDateTime invoiceDate;
      private String invoiceNo;
      private Integer invoiceType;
      private Boolean boolIncludeTax;
      private String taxRateTypeValue;
      private BigDecimal taxRate;
      private Long writtenById;
      private Long projectManagerId;
      private String paymentDepositBank;
      private String collectionDepositBank;
      private BigDecimal priceExcludingTax;
      private List<Long> attachmentId;

      ContractInvoiceSaveParamV2Builder() {
      }

      public ContractInvoiceSaveParamV2.ContractInvoiceSaveParamV2Builder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ContractInvoiceSaveParamV2.ContractInvoiceSaveParamV2Builder level(final Integer level) {
         this.level = level;
         return this;
      }

      public ContractInvoiceSaveParamV2.ContractInvoiceSaveParamV2Builder invoiceAmount(final BigDecimal invoiceAmount) {
         this.invoiceAmount = invoiceAmount;
         return this;
      }

      public ContractInvoiceSaveParamV2.ContractInvoiceSaveParamV2Builder invoiceUnitId(final Long invoiceUnitId) {
         this.invoiceUnitId = invoiceUnitId;
         return this;
      }

      public ContractInvoiceSaveParamV2.ContractInvoiceSaveParamV2Builder collectionUnit(final String collectionUnit) {
         this.collectionUnit = collectionUnit;
         return this;
      }

      public ContractInvoiceSaveParamV2.ContractInvoiceSaveParamV2Builder invoiceDate(final LocalDateTime invoiceDate) {
         this.invoiceDate = invoiceDate;
         return this;
      }

      public ContractInvoiceSaveParamV2.ContractInvoiceSaveParamV2Builder invoiceNo(final String invoiceNo) {
         this.invoiceNo = invoiceNo;
         return this;
      }

      public ContractInvoiceSaveParamV2.ContractInvoiceSaveParamV2Builder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public ContractInvoiceSaveParamV2.ContractInvoiceSaveParamV2Builder boolIncludeTax(final Boolean boolIncludeTax) {
         this.boolIncludeTax = boolIncludeTax;
         return this;
      }

      public ContractInvoiceSaveParamV2.ContractInvoiceSaveParamV2Builder taxRateTypeValue(final String taxRateTypeValue) {
         this.taxRateTypeValue = taxRateTypeValue;
         return this;
      }

      public ContractInvoiceSaveParamV2.ContractInvoiceSaveParamV2Builder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public ContractInvoiceSaveParamV2.ContractInvoiceSaveParamV2Builder writtenById(final Long writtenById) {
         this.writtenById = writtenById;
         return this;
      }

      public ContractInvoiceSaveParamV2.ContractInvoiceSaveParamV2Builder projectManagerId(final Long projectManagerId) {
         this.projectManagerId = projectManagerId;
         return this;
      }

      public ContractInvoiceSaveParamV2.ContractInvoiceSaveParamV2Builder paymentDepositBank(final String paymentDepositBank) {
         this.paymentDepositBank = paymentDepositBank;
         return this;
      }

      public ContractInvoiceSaveParamV2.ContractInvoiceSaveParamV2Builder collectionDepositBank(final String collectionDepositBank) {
         this.collectionDepositBank = collectionDepositBank;
         return this;
      }

      public ContractInvoiceSaveParamV2.ContractInvoiceSaveParamV2Builder priceExcludingTax(final BigDecimal priceExcludingTax) {
         this.priceExcludingTax = priceExcludingTax;
         return this;
      }

      public ContractInvoiceSaveParamV2.ContractInvoiceSaveParamV2Builder attachmentId(final List<Long> attachmentId) {
         this.attachmentId = attachmentId;
         return this;
      }

      public ContractInvoiceSaveParamV2 build() {
         return new ContractInvoiceSaveParamV2(
            this.projectId,
            this.level,
            this.invoiceAmount,
            this.invoiceUnitId,
            this.collectionUnit,
            this.invoiceDate,
            this.invoiceNo,
            this.invoiceType,
            this.boolIncludeTax,
            this.taxRateTypeValue,
            this.taxRate,
            this.writtenById,
            this.projectManagerId,
            this.paymentDepositBank,
            this.collectionDepositBank,
            this.priceExcludingTax,
            this.attachmentId
         );
      }

      @Override
      public String toString() {
         return "ContractInvoiceSaveParamV2.ContractInvoiceSaveParamV2Builder(projectId="
            + this.projectId
            + ", level="
            + this.level
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
            + ", taxRateTypeValue="
            + this.taxRateTypeValue
            + ", taxRate="
            + this.taxRate
            + ", writtenById="
            + this.writtenById
            + ", projectManagerId="
            + this.projectManagerId
            + ", paymentDepositBank="
            + this.paymentDepositBank
            + ", collectionDepositBank="
            + this.collectionDepositBank
            + ", priceExcludingTax="
            + this.priceExcludingTax
            + ", attachmentId="
            + this.attachmentId
            + ")";
      }
   }
}
