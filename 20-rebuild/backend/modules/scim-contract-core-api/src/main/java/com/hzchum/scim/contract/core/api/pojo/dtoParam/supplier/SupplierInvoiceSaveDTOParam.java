package com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.contract.core.api.enums.payment.InvoiceTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel("新增-收票填报类")
public class SupplierInvoiceSaveDTOParam {
   @ApiModelProperty("属性 1.原材料-采购费 2.运输费 4.制成品-采购费 8.分包费")
   @NotNull(message = "付款类型不能为空")
   private Integer propertyType;
   @ApiModelProperty("订单id")
   private Long orderId;
   @ApiModelProperty("收票日期(申请日期)")
   @NotNull(message = "收票日期不能为空")
   private LocalDate receiveInvoiceDate;
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
   @DecimalMin(value = "0.0", message = "税率不能为负数!")
   private BigDecimal taxRate;
   @ApiModelProperty("购方单位(签订主体id) 物流开票需要传递")
   @NotNull(message = "收票单位不能为空")
   private Long branchCompanyId;
   @ApiModelProperty("销售单位（供应商id） 物流开票需要传递")
   @NotNull(message = "开票单位不能为空")
   private Long supplierId;
   @ApiModelProperty("发票号码")
   @NotBlank(message = "发票号码不能为空")
   private String invoiceSerialNumber;
   @ApiModelProperty("附件ids")
   private List<Long> attachmentIds;
   @ApiModelProperty("备注")
   private String remark;

   public static SupplierInvoiceSaveDTOParam.SupplierInvoiceSaveDTOParamBuilder builder() {
      return new SupplierInvoiceSaveDTOParam.SupplierInvoiceSaveDTOParamBuilder();
   }

   public SupplierInvoiceSaveDTOParam() {
   }

   public SupplierInvoiceSaveDTOParam(
      final Integer propertyType,
      final Long orderId,
      final LocalDate receiveInvoiceDate,
      final BigDecimal invoiceAmount,
      final Integer invoiceType,
      final Boolean boolIncludeTax,
      final BigDecimal taxRate,
      final Long branchCompanyId,
      final Long supplierId,
      final String invoiceSerialNumber,
      final List<Long> attachmentIds,
      final String remark
   ) {
      this.propertyType = propertyType;
      this.orderId = orderId;
      this.receiveInvoiceDate = receiveInvoiceDate;
      this.invoiceAmount = invoiceAmount;
      this.invoiceType = invoiceType;
      this.boolIncludeTax = boolIncludeTax;
      this.taxRate = taxRate;
      this.branchCompanyId = branchCompanyId;
      this.supplierId = supplierId;
      this.invoiceSerialNumber = invoiceSerialNumber;
      this.attachmentIds = attachmentIds;
      this.remark = remark;
   }

   public Integer getPropertyType() {
      return this.propertyType;
   }

   public Long getOrderId() {
      return this.orderId;
   }

   public LocalDate getReceiveInvoiceDate() {
      return this.receiveInvoiceDate;
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

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public Long getSupplierId() {
      return this.supplierId;
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

   public void setPropertyType(final Integer propertyType) {
      this.propertyType = propertyType;
   }

   public void setOrderId(final Long orderId) {
      this.orderId = orderId;
   }

   public void setReceiveInvoiceDate(final LocalDate receiveInvoiceDate) {
      this.receiveInvoiceDate = receiveInvoiceDate;
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

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
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

      if (!(o instanceof SupplierInvoiceSaveDTOParam)) {
         return false;
      }

      SupplierInvoiceSaveDTOParam other = (SupplierInvoiceSaveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$propertyType = this.getPropertyType();
      Object other$propertyType = other.getPropertyType();
      if (this$propertyType == null ? other$propertyType == null : this$propertyType.equals(other$propertyType)) {
         Object this$orderId = this.getOrderId();
         Object other$orderId = other.getOrderId();
         if (this$orderId == null ? other$orderId == null : this$orderId.equals(other$orderId)) {
            Object this$invoiceType = this.getInvoiceType();
            Object other$invoiceType = other.getInvoiceType();
            if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
               Object this$boolIncludeTax = this.getBoolIncludeTax();
               Object other$boolIncludeTax = other.getBoolIncludeTax();
               if (this$boolIncludeTax == null ? other$boolIncludeTax == null : this$boolIncludeTax.equals(other$boolIncludeTax)) {
                  Object this$branchCompanyId = this.getBranchCompanyId();
                  Object other$branchCompanyId = other.getBranchCompanyId();
                  if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
                     Object this$supplierId = this.getSupplierId();
                     Object other$supplierId = other.getSupplierId();
                     if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                        Object this$receiveInvoiceDate = this.getReceiveInvoiceDate();
                        Object other$receiveInvoiceDate = other.getReceiveInvoiceDate();
                        if (this$receiveInvoiceDate == null ? other$receiveInvoiceDate == null : this$receiveInvoiceDate.equals(other$receiveInvoiceDate)) {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SupplierInvoiceSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $propertyType = this.getPropertyType();
      result = result * 59 + ($propertyType == null ? 43 : $propertyType.hashCode());
      Object $orderId = this.getOrderId();
      result = result * 59 + ($orderId == null ? 43 : $orderId.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $boolIncludeTax = this.getBoolIncludeTax();
      result = result * 59 + ($boolIncludeTax == null ? 43 : $boolIncludeTax.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $receiveInvoiceDate = this.getReceiveInvoiceDate();
      result = result * 59 + ($receiveInvoiceDate == null ? 43 : $receiveInvoiceDate.hashCode());
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
      return "SupplierInvoiceSaveDTOParam(propertyType="
         + this.getPropertyType()
         + ", orderId="
         + this.getOrderId()
         + ", receiveInvoiceDate="
         + this.getReceiveInvoiceDate()
         + ", invoiceAmount="
         + this.getInvoiceAmount()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", boolIncludeTax="
         + this.getBoolIncludeTax()
         + ", taxRate="
         + this.getTaxRate()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", supplierId="
         + this.getSupplierId()
         + ", invoiceSerialNumber="
         + this.getInvoiceSerialNumber()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   public static class SupplierInvoiceSaveDTOParamBuilder {
      private Integer propertyType;
      private Long orderId;
      private LocalDate receiveInvoiceDate;
      private BigDecimal invoiceAmount;
      private Integer invoiceType;
      private Boolean boolIncludeTax;
      private BigDecimal taxRate;
      private Long branchCompanyId;
      private Long supplierId;
      private String invoiceSerialNumber;
      private List<Long> attachmentIds;
      private String remark;

      SupplierInvoiceSaveDTOParamBuilder() {
      }

      public SupplierInvoiceSaveDTOParam.SupplierInvoiceSaveDTOParamBuilder propertyType(final Integer propertyType) {
         this.propertyType = propertyType;
         return this;
      }

      public SupplierInvoiceSaveDTOParam.SupplierInvoiceSaveDTOParamBuilder orderId(final Long orderId) {
         this.orderId = orderId;
         return this;
      }

      public SupplierInvoiceSaveDTOParam.SupplierInvoiceSaveDTOParamBuilder receiveInvoiceDate(final LocalDate receiveInvoiceDate) {
         this.receiveInvoiceDate = receiveInvoiceDate;
         return this;
      }

      public SupplierInvoiceSaveDTOParam.SupplierInvoiceSaveDTOParamBuilder invoiceAmount(final BigDecimal invoiceAmount) {
         this.invoiceAmount = invoiceAmount;
         return this;
      }

      public SupplierInvoiceSaveDTOParam.SupplierInvoiceSaveDTOParamBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public SupplierInvoiceSaveDTOParam.SupplierInvoiceSaveDTOParamBuilder boolIncludeTax(final Boolean boolIncludeTax) {
         this.boolIncludeTax = boolIncludeTax;
         return this;
      }

      public SupplierInvoiceSaveDTOParam.SupplierInvoiceSaveDTOParamBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public SupplierInvoiceSaveDTOParam.SupplierInvoiceSaveDTOParamBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public SupplierInvoiceSaveDTOParam.SupplierInvoiceSaveDTOParamBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public SupplierInvoiceSaveDTOParam.SupplierInvoiceSaveDTOParamBuilder invoiceSerialNumber(final String invoiceSerialNumber) {
         this.invoiceSerialNumber = invoiceSerialNumber;
         return this;
      }

      public SupplierInvoiceSaveDTOParam.SupplierInvoiceSaveDTOParamBuilder attachmentIds(final List<Long> attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public SupplierInvoiceSaveDTOParam.SupplierInvoiceSaveDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public SupplierInvoiceSaveDTOParam build() {
         return new SupplierInvoiceSaveDTOParam(
            this.propertyType,
            this.orderId,
            this.receiveInvoiceDate,
            this.invoiceAmount,
            this.invoiceType,
            this.boolIncludeTax,
            this.taxRate,
            this.branchCompanyId,
            this.supplierId,
            this.invoiceSerialNumber,
            this.attachmentIds,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "SupplierInvoiceSaveDTOParam.SupplierInvoiceSaveDTOParamBuilder(propertyType="
            + this.propertyType
            + ", orderId="
            + this.orderId
            + ", receiveInvoiceDate="
            + this.receiveInvoiceDate
            + ", invoiceAmount="
            + this.invoiceAmount
            + ", invoiceType="
            + this.invoiceType
            + ", boolIncludeTax="
            + this.boolIncludeTax
            + ", taxRate="
            + this.taxRate
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", supplierId="
            + this.supplierId
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
