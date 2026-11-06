package com.hzchum.scim.contract.core.api.pojo.dtoParam.update;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel("报销明细 重新编辑类")
public class ReimbursementDetailEditDTOParam {
   @ApiModelProperty(name = "id", value = "报销明细id")
   private Long id;
   @ApiModelProperty(name = "expenseTypeId", value = "费用类别id")
   @NotNull(message = "费用类别id不能为空")
   private Long expenseTypeId;
   @ApiModelProperty(name = "dictionaryId", value = "报销明细种类(字典表id)")
   private Long dictionaryId;
   @ApiModelProperty(name = "invoiceAmount", value = "发票面额")
   @NotNull(message = "发票面额不能为空")
   private BigDecimal invoiceAmount;
   @ApiModelProperty(name = "invoiceNo", value = "发票号码")
   @NotBlank(message = "发票号码 不能为空")
   private String invoiceNo;
   @ApiModelProperty(name = "invoiceType", value = "发票类型 1增值专用票 2增值普发票 4收据")
   @NotNull(message = "发票类型 不能为空")
   private Integer invoiceType;
   @ApiModelProperty(name = "applyAmount", value = "申请报销金额")
   @NotNull(message = "申请报销金额 不能为空")
   private BigDecimal applyAmount;
   @ApiModelProperty(name = "taxRate", value = "税率")
   private BigDecimal taxRate;
   @ApiModelProperty(name = "inputTax", value = "进项税额")
   private BigDecimal inputTax;

   public static ReimbursementDetailEditDTOParam.ReimbursementDetailEditDTOParamBuilder builder() {
      return new ReimbursementDetailEditDTOParam.ReimbursementDetailEditDTOParamBuilder();
   }

   public ReimbursementDetailEditDTOParam() {
   }

   public ReimbursementDetailEditDTOParam(
      final Long id,
      final Long expenseTypeId,
      final Long dictionaryId,
      final BigDecimal invoiceAmount,
      final String invoiceNo,
      final Integer invoiceType,
      final BigDecimal applyAmount,
      final BigDecimal taxRate,
      final BigDecimal inputTax
   ) {
      this.id = id;
      this.expenseTypeId = expenseTypeId;
      this.dictionaryId = dictionaryId;
      this.invoiceAmount = invoiceAmount;
      this.invoiceNo = invoiceNo;
      this.invoiceType = invoiceType;
      this.applyAmount = applyAmount;
      this.taxRate = taxRate;
      this.inputTax = inputTax;
   }

   public Long getId() {
      return this.id;
   }

   public Long getExpenseTypeId() {
      return this.expenseTypeId;
   }

   public Long getDictionaryId() {
      return this.dictionaryId;
   }

   public BigDecimal getInvoiceAmount() {
      return this.invoiceAmount;
   }

   public String getInvoiceNo() {
      return this.invoiceNo;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public BigDecimal getApplyAmount() {
      return this.applyAmount;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public BigDecimal getInputTax() {
      return this.inputTax;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setExpenseTypeId(final Long expenseTypeId) {
      this.expenseTypeId = expenseTypeId;
   }

   public void setDictionaryId(final Long dictionaryId) {
      this.dictionaryId = dictionaryId;
   }

   public void setInvoiceAmount(final BigDecimal invoiceAmount) {
      this.invoiceAmount = invoiceAmount;
   }

   public void setInvoiceNo(final String invoiceNo) {
      this.invoiceNo = invoiceNo;
   }

   public void setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
   }

   public void setApplyAmount(final BigDecimal applyAmount) {
      this.applyAmount = applyAmount;
   }

   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
   }

   public void setInputTax(final BigDecimal inputTax) {
      this.inputTax = inputTax;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ReimbursementDetailEditDTOParam)) {
         return false;
      }

      ReimbursementDetailEditDTOParam other = (ReimbursementDetailEditDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$expenseTypeId = this.getExpenseTypeId();
         Object other$expenseTypeId = other.getExpenseTypeId();
         if (this$expenseTypeId == null ? other$expenseTypeId == null : this$expenseTypeId.equals(other$expenseTypeId)) {
            Object this$dictionaryId = this.getDictionaryId();
            Object other$dictionaryId = other.getDictionaryId();
            if (this$dictionaryId == null ? other$dictionaryId == null : this$dictionaryId.equals(other$dictionaryId)) {
               Object this$invoiceType = this.getInvoiceType();
               Object other$invoiceType = other.getInvoiceType();
               if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                  Object this$invoiceAmount = this.getInvoiceAmount();
                  Object other$invoiceAmount = other.getInvoiceAmount();
                  if (this$invoiceAmount == null ? other$invoiceAmount == null : this$invoiceAmount.equals(other$invoiceAmount)) {
                     Object this$invoiceNo = this.getInvoiceNo();
                     Object other$invoiceNo = other.getInvoiceNo();
                     if (this$invoiceNo == null ? other$invoiceNo == null : this$invoiceNo.equals(other$invoiceNo)) {
                        Object this$applyAmount = this.getApplyAmount();
                        Object other$applyAmount = other.getApplyAmount();
                        if (this$applyAmount == null ? other$applyAmount == null : this$applyAmount.equals(other$applyAmount)) {
                           Object this$taxRate = this.getTaxRate();
                           Object other$taxRate = other.getTaxRate();
                           if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
                              Object this$inputTax = this.getInputTax();
                              Object other$inputTax = other.getInputTax();
                              return this$inputTax == null ? other$inputTax == null : this$inputTax.equals(other$inputTax);
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
      return other instanceof ReimbursementDetailEditDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $expenseTypeId = this.getExpenseTypeId();
      result = result * 59 + ($expenseTypeId == null ? 43 : $expenseTypeId.hashCode());
      Object $dictionaryId = this.getDictionaryId();
      result = result * 59 + ($dictionaryId == null ? 43 : $dictionaryId.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $invoiceAmount = this.getInvoiceAmount();
      result = result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
      Object $invoiceNo = this.getInvoiceNo();
      result = result * 59 + ($invoiceNo == null ? 43 : $invoiceNo.hashCode());
      Object $applyAmount = this.getApplyAmount();
      result = result * 59 + ($applyAmount == null ? 43 : $applyAmount.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $inputTax = this.getInputTax();
      return result * 59 + ($inputTax == null ? 43 : $inputTax.hashCode());
   }

   @Override
   public String toString() {
      return "ReimbursementDetailEditDTOParam(id="
         + this.getId()
         + ", expenseTypeId="
         + this.getExpenseTypeId()
         + ", dictionaryId="
         + this.getDictionaryId()
         + ", invoiceAmount="
         + this.getInvoiceAmount()
         + ", invoiceNo="
         + this.getInvoiceNo()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", applyAmount="
         + this.getApplyAmount()
         + ", taxRate="
         + this.getTaxRate()
         + ", inputTax="
         + this.getInputTax()
         + ")";
   }

   public static class ReimbursementDetailEditDTOParamBuilder {
      private Long id;
      private Long expenseTypeId;
      private Long dictionaryId;
      private BigDecimal invoiceAmount;
      private String invoiceNo;
      private Integer invoiceType;
      private BigDecimal applyAmount;
      private BigDecimal taxRate;
      private BigDecimal inputTax;

      ReimbursementDetailEditDTOParamBuilder() {
      }

      public ReimbursementDetailEditDTOParam.ReimbursementDetailEditDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ReimbursementDetailEditDTOParam.ReimbursementDetailEditDTOParamBuilder expenseTypeId(final Long expenseTypeId) {
         this.expenseTypeId = expenseTypeId;
         return this;
      }

      public ReimbursementDetailEditDTOParam.ReimbursementDetailEditDTOParamBuilder dictionaryId(final Long dictionaryId) {
         this.dictionaryId = dictionaryId;
         return this;
      }

      public ReimbursementDetailEditDTOParam.ReimbursementDetailEditDTOParamBuilder invoiceAmount(final BigDecimal invoiceAmount) {
         this.invoiceAmount = invoiceAmount;
         return this;
      }

      public ReimbursementDetailEditDTOParam.ReimbursementDetailEditDTOParamBuilder invoiceNo(final String invoiceNo) {
         this.invoiceNo = invoiceNo;
         return this;
      }

      public ReimbursementDetailEditDTOParam.ReimbursementDetailEditDTOParamBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public ReimbursementDetailEditDTOParam.ReimbursementDetailEditDTOParamBuilder applyAmount(final BigDecimal applyAmount) {
         this.applyAmount = applyAmount;
         return this;
      }

      public ReimbursementDetailEditDTOParam.ReimbursementDetailEditDTOParamBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public ReimbursementDetailEditDTOParam.ReimbursementDetailEditDTOParamBuilder inputTax(final BigDecimal inputTax) {
         this.inputTax = inputTax;
         return this;
      }

      public ReimbursementDetailEditDTOParam build() {
         return new ReimbursementDetailEditDTOParam(
            this.id, this.expenseTypeId, this.dictionaryId, this.invoiceAmount, this.invoiceNo, this.invoiceType, this.applyAmount, this.taxRate, this.inputTax
         );
      }

      @Override
      public String toString() {
         return "ReimbursementDetailEditDTOParam.ReimbursementDetailEditDTOParamBuilder(id="
            + this.id
            + ", expenseTypeId="
            + this.expenseTypeId
            + ", dictionaryId="
            + this.dictionaryId
            + ", invoiceAmount="
            + this.invoiceAmount
            + ", invoiceNo="
            + this.invoiceNo
            + ", invoiceType="
            + this.invoiceType
            + ", applyAmount="
            + this.applyAmount
            + ", taxRate="
            + this.taxRate
            + ", inputTax="
            + this.inputTax
            + ")";
      }
   }
}
