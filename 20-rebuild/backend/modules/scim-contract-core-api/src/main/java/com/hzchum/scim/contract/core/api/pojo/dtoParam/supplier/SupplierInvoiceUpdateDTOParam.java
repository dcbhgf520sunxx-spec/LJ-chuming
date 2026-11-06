package com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.contract.core.api.enums.payment.InvoiceTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel("修改-收票填报类")
public class SupplierInvoiceUpdateDTOParam {
   @ApiModelProperty("收票记录id")
   @NotNull(message = "收票记录id不能为空")
   private Long id;
   @ApiModelProperty("收票日期(申请日期)")
   @NotNull(message = "收票日期不能为空")
   private LocalDate receiveInvoiceDate;
   @ApiModelProperty("发票面额")
   @NotNull(message = "发票面额不能为空")
   private BigDecimal invoiceAmount;
   @ApiModelProperty("发票号码")
   @NotBlank(message = "发票号码不能为空")
   private String invoiceSerialNumber;
   @ApiModelProperty("附件ids")
   private List<Long> attachmentIds;
   @ApiModelProperty("备注")
   private String remark;
   @ApiModelProperty("发票类型 1增值专用票 2增值普发票 4收据")
   @NotNull(message = "发票类型不能为空")
   @EnumValidator(value = InvoiceTypeEnum.class, message = "发票类型不支持")
   private Integer invoiceType;
   @ApiModelProperty(name = "bool_include_tax", value = "是否含税 true含税 false免税")
   @NotNull(message = "是否含税不能为空!")
   private Boolean boolIncludeTax;
   @ApiModelProperty("税率")
   private BigDecimal taxRate;

   public static SupplierInvoiceUpdateDTOParam.SupplierInvoiceUpdateDTOParamBuilder builder() {
      return new SupplierInvoiceUpdateDTOParam.SupplierInvoiceUpdateDTOParamBuilder();
   }

   public SupplierInvoiceUpdateDTOParam() {
   }

   public SupplierInvoiceUpdateDTOParam(
      final Long id,
      final LocalDate receiveInvoiceDate,
      final BigDecimal invoiceAmount,
      final String invoiceSerialNumber,
      final List<Long> attachmentIds,
      final String remark,
      final Integer invoiceType,
      final Boolean boolIncludeTax,
      final BigDecimal taxRate
   ) {
      this.id = id;
      this.receiveInvoiceDate = receiveInvoiceDate;
      this.invoiceAmount = invoiceAmount;
      this.invoiceSerialNumber = invoiceSerialNumber;
      this.attachmentIds = attachmentIds;
      this.remark = remark;
      this.invoiceType = invoiceType;
      this.boolIncludeTax = boolIncludeTax;
      this.taxRate = taxRate;
   }

   public Long getId() {
      return this.id;
   }

   public LocalDate getReceiveInvoiceDate() {
      return this.receiveInvoiceDate;
   }

   public BigDecimal getInvoiceAmount() {
      return this.invoiceAmount;
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

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public Boolean getBoolIncludeTax() {
      return this.boolIncludeTax;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setReceiveInvoiceDate(final LocalDate receiveInvoiceDate) {
      this.receiveInvoiceDate = receiveInvoiceDate;
   }

   public void setInvoiceAmount(final BigDecimal invoiceAmount) {
      this.invoiceAmount = invoiceAmount;
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

   public void setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
   }

   public void setBoolIncludeTax(final Boolean boolIncludeTax) {
      this.boolIncludeTax = boolIncludeTax;
   }

   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierInvoiceUpdateDTOParam)) {
         return false;
      }

      SupplierInvoiceUpdateDTOParam other = (SupplierInvoiceUpdateDTOParam)o;
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
               Object this$receiveInvoiceDate = this.getReceiveInvoiceDate();
               Object other$receiveInvoiceDate = other.getReceiveInvoiceDate();
               if (this$receiveInvoiceDate == null ? other$receiveInvoiceDate == null : this$receiveInvoiceDate.equals(other$receiveInvoiceDate)) {
                  Object this$invoiceAmount = this.getInvoiceAmount();
                  Object other$invoiceAmount = other.getInvoiceAmount();
                  if (this$invoiceAmount == null ? other$invoiceAmount == null : this$invoiceAmount.equals(other$invoiceAmount)) {
                     Object this$invoiceSerialNumber = this.getInvoiceSerialNumber();
                     Object other$invoiceSerialNumber = other.getInvoiceSerialNumber();
                     if (this$invoiceSerialNumber == null ? other$invoiceSerialNumber == null : this$invoiceSerialNumber.equals(other$invoiceSerialNumber)) {
                        Object this$attachmentIds = this.getAttachmentIds();
                        Object other$attachmentIds = other.getAttachmentIds();
                        if (this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds)) {
                           Object this$remark = this.getRemark();
                           Object other$remark = other.getRemark();
                           if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                              Object this$taxRate = this.getTaxRate();
                              Object other$taxRate = other.getTaxRate();
                              return this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate);
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
      return other instanceof SupplierInvoiceUpdateDTOParam;
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
      Object $receiveInvoiceDate = this.getReceiveInvoiceDate();
      result = result * 59 + ($receiveInvoiceDate == null ? 43 : $receiveInvoiceDate.hashCode());
      Object $invoiceAmount = this.getInvoiceAmount();
      result = result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
      Object $invoiceSerialNumber = this.getInvoiceSerialNumber();
      result = result * 59 + ($invoiceSerialNumber == null ? 43 : $invoiceSerialNumber.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $taxRate = this.getTaxRate();
      return result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierInvoiceUpdateDTOParam(id="
         + this.getId()
         + ", receiveInvoiceDate="
         + this.getReceiveInvoiceDate()
         + ", invoiceAmount="
         + this.getInvoiceAmount()
         + ", invoiceSerialNumber="
         + this.getInvoiceSerialNumber()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", remark="
         + this.getRemark()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", boolIncludeTax="
         + this.getBoolIncludeTax()
         + ", taxRate="
         + this.getTaxRate()
         + ")";
   }

   public static class SupplierInvoiceUpdateDTOParamBuilder {
      private Long id;
      private LocalDate receiveInvoiceDate;
      private BigDecimal invoiceAmount;
      private String invoiceSerialNumber;
      private List<Long> attachmentIds;
      private String remark;
      private Integer invoiceType;
      private Boolean boolIncludeTax;
      private BigDecimal taxRate;

      SupplierInvoiceUpdateDTOParamBuilder() {
      }

      public SupplierInvoiceUpdateDTOParam.SupplierInvoiceUpdateDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SupplierInvoiceUpdateDTOParam.SupplierInvoiceUpdateDTOParamBuilder receiveInvoiceDate(final LocalDate receiveInvoiceDate) {
         this.receiveInvoiceDate = receiveInvoiceDate;
         return this;
      }

      public SupplierInvoiceUpdateDTOParam.SupplierInvoiceUpdateDTOParamBuilder invoiceAmount(final BigDecimal invoiceAmount) {
         this.invoiceAmount = invoiceAmount;
         return this;
      }

      public SupplierInvoiceUpdateDTOParam.SupplierInvoiceUpdateDTOParamBuilder invoiceSerialNumber(final String invoiceSerialNumber) {
         this.invoiceSerialNumber = invoiceSerialNumber;
         return this;
      }

      public SupplierInvoiceUpdateDTOParam.SupplierInvoiceUpdateDTOParamBuilder attachmentIds(final List<Long> attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public SupplierInvoiceUpdateDTOParam.SupplierInvoiceUpdateDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public SupplierInvoiceUpdateDTOParam.SupplierInvoiceUpdateDTOParamBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public SupplierInvoiceUpdateDTOParam.SupplierInvoiceUpdateDTOParamBuilder boolIncludeTax(final Boolean boolIncludeTax) {
         this.boolIncludeTax = boolIncludeTax;
         return this;
      }

      public SupplierInvoiceUpdateDTOParam.SupplierInvoiceUpdateDTOParamBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public SupplierInvoiceUpdateDTOParam build() {
         return new SupplierInvoiceUpdateDTOParam(
            this.id,
            this.receiveInvoiceDate,
            this.invoiceAmount,
            this.invoiceSerialNumber,
            this.attachmentIds,
            this.remark,
            this.invoiceType,
            this.boolIncludeTax,
            this.taxRate
         );
      }

      @Override
      public String toString() {
         return "SupplierInvoiceUpdateDTOParam.SupplierInvoiceUpdateDTOParamBuilder(id="
            + this.id
            + ", receiveInvoiceDate="
            + this.receiveInvoiceDate
            + ", invoiceAmount="
            + this.invoiceAmount
            + ", invoiceSerialNumber="
            + this.invoiceSerialNumber
            + ", attachmentIds="
            + this.attachmentIds
            + ", remark="
            + this.remark
            + ", invoiceType="
            + this.invoiceType
            + ", boolIncludeTax="
            + this.boolIncludeTax
            + ", taxRate="
            + this.taxRate
            + ")";
      }
   }
}
