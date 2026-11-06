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

@ApiModel("修改-回收制品收票")
public class RecycleInvoiceUpdateParam {
   @ApiModelProperty("收票记录id")
   @NotNull(message = "收票记录id不能为空")
   private Long id;
   @ApiModelProperty("收票日期")
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
   private BigDecimal taxRate;
   @ApiModelProperty("发票号码")
   @NotBlank(message = "发票号码不能为空")
   private String invoiceSerialNumber;
   @ApiModelProperty("发票内容")
   @Size(max = 200, message = "发票内容长度超出范围!")
   private String invoiceContent;
   @ApiModelProperty("附件ids")
   private List<Long> attachmentIds;
   @ApiModelProperty("备注")
   private String remark;

   public static RecycleInvoiceUpdateParam.RecycleInvoiceUpdateParamBuilder builder() {
      return new RecycleInvoiceUpdateParam.RecycleInvoiceUpdateParamBuilder();
   }

   public RecycleInvoiceUpdateParam() {
   }

   public RecycleInvoiceUpdateParam(
      final Long id,
      final LocalDate receiveInvoiceDate,
      final BigDecimal invoiceAmount,
      final Integer invoiceType,
      final Boolean boolIncludeTax,
      final BigDecimal taxRate,
      final String invoiceSerialNumber,
      final String invoiceContent,
      final List<Long> attachmentIds,
      final String remark
   ) {
      this.id = id;
      this.receiveInvoiceDate = receiveInvoiceDate;
      this.invoiceAmount = invoiceAmount;
      this.invoiceType = invoiceType;
      this.boolIncludeTax = boolIncludeTax;
      this.taxRate = taxRate;
      this.invoiceSerialNumber = invoiceSerialNumber;
      this.invoiceContent = invoiceContent;
      this.attachmentIds = attachmentIds;
      this.remark = remark;
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

   public String getInvoiceContent() {
      return this.invoiceContent;
   }

   public List<Long> getAttachmentIds() {
      return this.attachmentIds;
   }

   public String getRemark() {
      return this.remark;
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

   public void setInvoiceContent(final String invoiceContent) {
      this.invoiceContent = invoiceContent;
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

      if (!(o instanceof RecycleInvoiceUpdateParam)) {
         return false;
      }

      RecycleInvoiceUpdateParam other = (RecycleInvoiceUpdateParam)o;
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
                     Object this$taxRate = this.getTaxRate();
                     Object other$taxRate = other.getTaxRate();
                     if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
                        Object this$invoiceSerialNumber = this.getInvoiceSerialNumber();
                        Object other$invoiceSerialNumber = other.getInvoiceSerialNumber();
                        if (this$invoiceSerialNumber == null ? other$invoiceSerialNumber == null : this$invoiceSerialNumber.equals(other$invoiceSerialNumber)) {
                           Object this$invoiceContent = this.getInvoiceContent();
                           Object other$invoiceContent = other.getInvoiceContent();
                           if (this$invoiceContent == null ? other$invoiceContent == null : this$invoiceContent.equals(other$invoiceContent)) {
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
      return other instanceof RecycleInvoiceUpdateParam;
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
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $invoiceSerialNumber = this.getInvoiceSerialNumber();
      result = result * 59 + ($invoiceSerialNumber == null ? 43 : $invoiceSerialNumber.hashCode());
      Object $invoiceContent = this.getInvoiceContent();
      result = result * 59 + ($invoiceContent == null ? 43 : $invoiceContent.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "RecycleInvoiceUpdateParam(id="
         + this.getId()
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
         + ", invoiceSerialNumber="
         + this.getInvoiceSerialNumber()
         + ", invoiceContent="
         + this.getInvoiceContent()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   public static class RecycleInvoiceUpdateParamBuilder {
      private Long id;
      private LocalDate receiveInvoiceDate;
      private BigDecimal invoiceAmount;
      private Integer invoiceType;
      private Boolean boolIncludeTax;
      private BigDecimal taxRate;
      private String invoiceSerialNumber;
      private String invoiceContent;
      private List<Long> attachmentIds;
      private String remark;

      RecycleInvoiceUpdateParamBuilder() {
      }

      public RecycleInvoiceUpdateParam.RecycleInvoiceUpdateParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public RecycleInvoiceUpdateParam.RecycleInvoiceUpdateParamBuilder receiveInvoiceDate(final LocalDate receiveInvoiceDate) {
         this.receiveInvoiceDate = receiveInvoiceDate;
         return this;
      }

      public RecycleInvoiceUpdateParam.RecycleInvoiceUpdateParamBuilder invoiceAmount(final BigDecimal invoiceAmount) {
         this.invoiceAmount = invoiceAmount;
         return this;
      }

      public RecycleInvoiceUpdateParam.RecycleInvoiceUpdateParamBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public RecycleInvoiceUpdateParam.RecycleInvoiceUpdateParamBuilder boolIncludeTax(final Boolean boolIncludeTax) {
         this.boolIncludeTax = boolIncludeTax;
         return this;
      }

      public RecycleInvoiceUpdateParam.RecycleInvoiceUpdateParamBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public RecycleInvoiceUpdateParam.RecycleInvoiceUpdateParamBuilder invoiceSerialNumber(final String invoiceSerialNumber) {
         this.invoiceSerialNumber = invoiceSerialNumber;
         return this;
      }

      public RecycleInvoiceUpdateParam.RecycleInvoiceUpdateParamBuilder invoiceContent(final String invoiceContent) {
         this.invoiceContent = invoiceContent;
         return this;
      }

      public RecycleInvoiceUpdateParam.RecycleInvoiceUpdateParamBuilder attachmentIds(final List<Long> attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public RecycleInvoiceUpdateParam.RecycleInvoiceUpdateParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public RecycleInvoiceUpdateParam build() {
         return new RecycleInvoiceUpdateParam(
            this.id,
            this.receiveInvoiceDate,
            this.invoiceAmount,
            this.invoiceType,
            this.boolIncludeTax,
            this.taxRate,
            this.invoiceSerialNumber,
            this.invoiceContent,
            this.attachmentIds,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "RecycleInvoiceUpdateParam.RecycleInvoiceUpdateParamBuilder(id="
            + this.id
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
            + ", invoiceSerialNumber="
            + this.invoiceSerialNumber
            + ", invoiceContent="
            + this.invoiceContent
            + ", attachmentIds="
            + this.attachmentIds
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
