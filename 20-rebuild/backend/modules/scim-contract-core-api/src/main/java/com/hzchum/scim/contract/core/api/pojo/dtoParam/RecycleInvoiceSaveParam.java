package com.hzchum.scim.contract.core.api.pojo.dtoParam;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.contract.core.api.enums.payment.InvoiceTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel("新增-回收制品收票")
public class RecycleInvoiceSaveParam {
   @ApiModelProperty("收票日期")
   @NotNull(message = "收票日期不能为空")
   private LocalDate receiveInvoiceDate;
   @ApiModelProperty("收票单位id(购买方)")
   @NotNull(message = "收票单位不能为空")
   private Long branchCompanyId;
   @ApiModelProperty("开票单位(出售方)")
   @NotBlank(message = "开票单位不能为空")
   private String customerUnit;
   @ApiModelProperty("发票面额")
   @NotNull(message = "发票面额不能为空")
   private BigDecimal invoiceAmount;
   @ApiModelProperty("发票类型 1增值专用票 2增值普发票 4收据")
   @NotNull(message = "发票类型不能为空")
   @EnumValidator(value = InvoiceTypeEnum.class, message = "发票类型不支持")
   private Integer invoiceType;
   @ApiModelProperty(name = "boolIncludeTax", value = "是否含税 true含税 false免税")
   @NotNull(message = "是否含税不能为空!")
   private Boolean boolIncludeTax;
   @ApiModelProperty("税率")
   private BigDecimal taxRate;
   @ApiModelProperty("发票号码")
   @NotBlank(message = "发票号码不能为空")
   @Size(max = 250, message = "发票号码长度超出范围!")
   private String invoiceSerialNumber;
   @ApiModelProperty("附件ids")
   @Size(max = 20, message = "附件过多,超出数量限制!")
   private List<Long> attachmentIds;
   @ApiModelProperty("备注")
   @Size(max = 250, message = "备注字数超出限制!")
   private String remark;

   public static RecycleInvoiceSaveParam.RecycleInvoiceSaveParamBuilder builder() {
      return new RecycleInvoiceSaveParam.RecycleInvoiceSaveParamBuilder();
   }

   public RecycleInvoiceSaveParam() {
   }

   public RecycleInvoiceSaveParam(
      final LocalDate receiveInvoiceDate,
      final Long branchCompanyId,
      final String customerUnit,
      final BigDecimal invoiceAmount,
      final Integer invoiceType,
      final Boolean boolIncludeTax,
      final BigDecimal taxRate,
      final String invoiceSerialNumber,
      final List<Long> attachmentIds,
      final String remark
   ) {
      this.receiveInvoiceDate = receiveInvoiceDate;
      this.branchCompanyId = branchCompanyId;
      this.customerUnit = customerUnit;
      this.invoiceAmount = invoiceAmount;
      this.invoiceType = invoiceType;
      this.boolIncludeTax = boolIncludeTax;
      this.taxRate = taxRate;
      this.invoiceSerialNumber = invoiceSerialNumber;
      this.attachmentIds = attachmentIds;
      this.remark = remark;
   }

   public LocalDate getReceiveInvoiceDate() {
      return this.receiveInvoiceDate;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public String getCustomerUnit() {
      return this.customerUnit;
   }

   public BigDecimal getInvoiceAmount() {
      return this.invoiceAmount;
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

   public String getInvoiceSerialNumber() {
      return this.invoiceSerialNumber;
   }

   public List<Long> getAttachmentIds() {
      return this.attachmentIds;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setReceiveInvoiceDate(final LocalDate receiveInvoiceDate) {
      this.receiveInvoiceDate = receiveInvoiceDate;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setCustomerUnit(final String customerUnit) {
      this.customerUnit = customerUnit;
   }

   public void setInvoiceAmount(final BigDecimal invoiceAmount) {
      this.invoiceAmount = invoiceAmount;
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

   public void setInvoiceSerialNumber(final String invoiceSerialNumber) {
      this.invoiceSerialNumber = invoiceSerialNumber;
   }

   public void setAttachmentIds(final List<Long> attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof RecycleInvoiceSaveParam)) {
         return false;
      }

      RecycleInvoiceSaveParam other = (RecycleInvoiceSaveParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$branchCompanyId = this.getBranchCompanyId();
      Object other$branchCompanyId = other.getBranchCompanyId();
      if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
         Object this$invoiceType = this.getInvoiceType();
         Object other$invoiceType = other.getInvoiceType();
         if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
            Object this$boolIncludeTax = this.getBoolIncludeTax();
            Object other$boolIncludeTax = other.getBoolIncludeTax();
            if (this$boolIncludeTax == null ? other$boolIncludeTax == null : this$boolIncludeTax.equals(other$boolIncludeTax)) {
               Object this$receiveInvoiceDate = this.getReceiveInvoiceDate();
               Object other$receiveInvoiceDate = other.getReceiveInvoiceDate();
               if (this$receiveInvoiceDate == null ? other$receiveInvoiceDate == null : this$receiveInvoiceDate.equals(other$receiveInvoiceDate)) {
                  Object this$customerUnit = this.getCustomerUnit();
                  Object other$customerUnit = other.getCustomerUnit();
                  if (this$customerUnit == null ? other$customerUnit == null : this$customerUnit.equals(other$customerUnit)) {
                     Object this$invoiceAmount = this.getInvoiceAmount();
                     Object other$invoiceAmount = other.getInvoiceAmount();
                     if (this$invoiceAmount == null ? other$invoiceAmount == null : this$invoiceAmount.equals(other$invoiceAmount)) {
                        Object this$taxRate = this.getTaxRate();
                        Object other$taxRate = other.getTaxRate();
                        if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
                           Object this$invoiceSerialNumber = this.getInvoiceSerialNumber();
                           Object other$invoiceSerialNumber = other.getInvoiceSerialNumber();
                           if (this$invoiceSerialNumber == null
                              ? other$invoiceSerialNumber == null
                              : this$invoiceSerialNumber.equals(other$invoiceSerialNumber)) {
                              Object this$attachmentIds = this.getAttachmentIds();
                              Object other$attachmentIds = other.getAttachmentIds();
                              if (this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds)) {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof RecycleInvoiceSaveParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $boolIncludeTax = this.getBoolIncludeTax();
      result = result * 59 + ($boolIncludeTax == null ? 43 : $boolIncludeTax.hashCode());
      Object $receiveInvoiceDate = this.getReceiveInvoiceDate();
      result = result * 59 + ($receiveInvoiceDate == null ? 43 : $receiveInvoiceDate.hashCode());
      Object $customerUnit = this.getCustomerUnit();
      result = result * 59 + ($customerUnit == null ? 43 : $customerUnit.hashCode());
      Object $invoiceAmount = this.getInvoiceAmount();
      result = result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $invoiceSerialNumber = this.getInvoiceSerialNumber();
      result = result * 59 + ($invoiceSerialNumber == null ? 43 : $invoiceSerialNumber.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "RecycleInvoiceSaveParam(receiveInvoiceDate="
         + this.getReceiveInvoiceDate()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", customerUnit="
         + this.getCustomerUnit()
         + ", invoiceAmount="
         + this.getInvoiceAmount()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", boolIncludeTax="
         + this.getBoolIncludeTax()
         + ", taxRate="
         + this.getTaxRate()
         + ", invoiceSerialNumber="
         + this.getInvoiceSerialNumber()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   public static class RecycleInvoiceSaveParamBuilder {
      private LocalDate receiveInvoiceDate;
      private Long branchCompanyId;
      private String customerUnit;
      private BigDecimal invoiceAmount;
      private Integer invoiceType;
      private Boolean boolIncludeTax;
      private BigDecimal taxRate;
      private String invoiceSerialNumber;
      private List<Long> attachmentIds;
      private String remark;

      RecycleInvoiceSaveParamBuilder() {
      }

      public RecycleInvoiceSaveParam.RecycleInvoiceSaveParamBuilder receiveInvoiceDate(final LocalDate receiveInvoiceDate) {
         this.receiveInvoiceDate = receiveInvoiceDate;
         return this;
      }

      public RecycleInvoiceSaveParam.RecycleInvoiceSaveParamBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public RecycleInvoiceSaveParam.RecycleInvoiceSaveParamBuilder customerUnit(final String customerUnit) {
         this.customerUnit = customerUnit;
         return this;
      }

      public RecycleInvoiceSaveParam.RecycleInvoiceSaveParamBuilder invoiceAmount(final BigDecimal invoiceAmount) {
         this.invoiceAmount = invoiceAmount;
         return this;
      }

      public RecycleInvoiceSaveParam.RecycleInvoiceSaveParamBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public RecycleInvoiceSaveParam.RecycleInvoiceSaveParamBuilder boolIncludeTax(final Boolean boolIncludeTax) {
         this.boolIncludeTax = boolIncludeTax;
         return this;
      }

      public RecycleInvoiceSaveParam.RecycleInvoiceSaveParamBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public RecycleInvoiceSaveParam.RecycleInvoiceSaveParamBuilder invoiceSerialNumber(final String invoiceSerialNumber) {
         this.invoiceSerialNumber = invoiceSerialNumber;
         return this;
      }

      public RecycleInvoiceSaveParam.RecycleInvoiceSaveParamBuilder attachmentIds(final List<Long> attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public RecycleInvoiceSaveParam.RecycleInvoiceSaveParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public RecycleInvoiceSaveParam build() {
         return new RecycleInvoiceSaveParam(
            this.receiveInvoiceDate,
            this.branchCompanyId,
            this.customerUnit,
            this.invoiceAmount,
            this.invoiceType,
            this.boolIncludeTax,
            this.taxRate,
            this.invoiceSerialNumber,
            this.attachmentIds,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "RecycleInvoiceSaveParam.RecycleInvoiceSaveParamBuilder(receiveInvoiceDate="
            + this.receiveInvoiceDate
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", customerUnit="
            + this.customerUnit
            + ", invoiceAmount="
            + this.invoiceAmount
            + ", invoiceType="
            + this.invoiceType
            + ", boolIncludeTax="
            + this.boolIncludeTax
            + ", taxRate="
            + this.taxRate
            + ", invoiceSerialNumber="
            + this.invoiceSerialNumber
            + ", attachmentIds="
            + this.attachmentIds
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
