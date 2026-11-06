package com.hzchum.scim.contract.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("报销明细 列表")
public class ReimbursementDetailDTO {
   @ApiModelProperty(name = "报销明细id")
   private Long id;
   @ApiModelProperty(name = "reimbursementId", value = "报销表id")
   private Long reimbursementId;
   @ApiModelProperty(name = "invoiceAmount", value = "发票金额")
   private BigDecimal invoiceAmount;
   @ApiModelProperty(name = "invoiceNo", value = "发票号码")
   private String invoiceNo;
   @ApiModelProperty(name = "invoiceType", value = "发票类型 1增值专用票 2增值普发票 4收据")
   private Integer invoiceType;
   @ApiModelProperty(name = "applyAmount", value = "申请报销金额")
   private BigDecimal applyAmount;
   @ApiModelProperty(name = "taxRate", value = "税率")
   private BigDecimal taxRate;
   @ApiModelProperty(name = "inputTax", value = "进项税额")
   private BigDecimal inputTax;
   @ApiModelProperty(name = "actuallyPayAmount", value = "实付金额")
   private BigDecimal actuallyPayAmount;
   @ApiModelProperty(name = "expenseTypeId", value = "费用类别id")
   private Long expenseTypeId;
   @ApiModelProperty(name = "dictionaryId", value = "字典表id")
   private Long dictionaryId;
   @ApiModelProperty(name = "dictionaryLabel", value = "字典表label")
   private String dictionaryLabel;

   public static ReimbursementDetailDTO.ReimbursementDetailDTOBuilder builder() {
      return new ReimbursementDetailDTO.ReimbursementDetailDTOBuilder();
   }

   public ReimbursementDetailDTO() {
   }

   public ReimbursementDetailDTO(
      final Long id,
      final Long reimbursementId,
      final BigDecimal invoiceAmount,
      final String invoiceNo,
      final Integer invoiceType,
      final BigDecimal applyAmount,
      final BigDecimal taxRate,
      final BigDecimal inputTax,
      final BigDecimal actuallyPayAmount,
      final Long expenseTypeId,
      final Long dictionaryId,
      final String dictionaryLabel
   ) {
      this.id = id;
      this.reimbursementId = reimbursementId;
      this.invoiceAmount = invoiceAmount;
      this.invoiceNo = invoiceNo;
      this.invoiceType = invoiceType;
      this.applyAmount = applyAmount;
      this.taxRate = taxRate;
      this.inputTax = inputTax;
      this.actuallyPayAmount = actuallyPayAmount;
      this.expenseTypeId = expenseTypeId;
      this.dictionaryId = dictionaryId;
      this.dictionaryLabel = dictionaryLabel;
   }

   public Long getId() {
      return this.id;
   }

   public Long getReimbursementId() {
      return this.reimbursementId;
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

   public BigDecimal getActuallyPayAmount() {
      return this.actuallyPayAmount;
   }

   public Long getExpenseTypeId() {
      return this.expenseTypeId;
   }

   public Long getDictionaryId() {
      return this.dictionaryId;
   }

   public String getDictionaryLabel() {
      return this.dictionaryLabel;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setReimbursementId(final Long reimbursementId) {
      this.reimbursementId = reimbursementId;
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

   public void setActuallyPayAmount(final BigDecimal actuallyPayAmount) {
      this.actuallyPayAmount = actuallyPayAmount;
   }

   public void setExpenseTypeId(final Long expenseTypeId) {
      this.expenseTypeId = expenseTypeId;
   }

   public void setDictionaryId(final Long dictionaryId) {
      this.dictionaryId = dictionaryId;
   }

   public void setDictionaryLabel(final String dictionaryLabel) {
      this.dictionaryLabel = dictionaryLabel;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ReimbursementDetailDTO)) {
         return false;
      }

      ReimbursementDetailDTO other = (ReimbursementDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$reimbursementId = this.getReimbursementId();
         Object other$reimbursementId = other.getReimbursementId();
         if (this$reimbursementId == null ? other$reimbursementId == null : this$reimbursementId.equals(other$reimbursementId)) {
            Object this$invoiceType = this.getInvoiceType();
            Object other$invoiceType = other.getInvoiceType();
            if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
               Object this$expenseTypeId = this.getExpenseTypeId();
               Object other$expenseTypeId = other.getExpenseTypeId();
               if (this$expenseTypeId == null ? other$expenseTypeId == null : this$expenseTypeId.equals(other$expenseTypeId)) {
                  Object this$dictionaryId = this.getDictionaryId();
                  Object other$dictionaryId = other.getDictionaryId();
                  if (this$dictionaryId == null ? other$dictionaryId == null : this$dictionaryId.equals(other$dictionaryId)) {
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
                                 if (this$inputTax == null ? other$inputTax == null : this$inputTax.equals(other$inputTax)) {
                                    Object this$actuallyPayAmount = this.getActuallyPayAmount();
                                    Object other$actuallyPayAmount = other.getActuallyPayAmount();
                                    if (this$actuallyPayAmount == null
                                       ? other$actuallyPayAmount == null
                                       : this$actuallyPayAmount.equals(other$actuallyPayAmount)) {
                                       Object this$dictionaryLabel = this.getDictionaryLabel();
                                       Object other$dictionaryLabel = other.getDictionaryLabel();
                                       return this$dictionaryLabel == null ? other$dictionaryLabel == null : this$dictionaryLabel.equals(other$dictionaryLabel);
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
      return other instanceof ReimbursementDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $reimbursementId = this.getReimbursementId();
      result = result * 59 + ($reimbursementId == null ? 43 : $reimbursementId.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $expenseTypeId = this.getExpenseTypeId();
      result = result * 59 + ($expenseTypeId == null ? 43 : $expenseTypeId.hashCode());
      Object $dictionaryId = this.getDictionaryId();
      result = result * 59 + ($dictionaryId == null ? 43 : $dictionaryId.hashCode());
      Object $invoiceAmount = this.getInvoiceAmount();
      result = result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
      Object $invoiceNo = this.getInvoiceNo();
      result = result * 59 + ($invoiceNo == null ? 43 : $invoiceNo.hashCode());
      Object $applyAmount = this.getApplyAmount();
      result = result * 59 + ($applyAmount == null ? 43 : $applyAmount.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $inputTax = this.getInputTax();
      result = result * 59 + ($inputTax == null ? 43 : $inputTax.hashCode());
      Object $actuallyPayAmount = this.getActuallyPayAmount();
      result = result * 59 + ($actuallyPayAmount == null ? 43 : $actuallyPayAmount.hashCode());
      Object $dictionaryLabel = this.getDictionaryLabel();
      return result * 59 + ($dictionaryLabel == null ? 43 : $dictionaryLabel.hashCode());
   }

   @Override
   public String toString() {
      return "ReimbursementDetailDTO(id="
         + this.getId()
         + ", reimbursementId="
         + this.getReimbursementId()
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
         + ", actuallyPayAmount="
         + this.getActuallyPayAmount()
         + ", expenseTypeId="
         + this.getExpenseTypeId()
         + ", dictionaryId="
         + this.getDictionaryId()
         + ", dictionaryLabel="
         + this.getDictionaryLabel()
         + ")";
   }

   public static class ReimbursementDetailDTOBuilder {
      private Long id;
      private Long reimbursementId;
      private BigDecimal invoiceAmount;
      private String invoiceNo;
      private Integer invoiceType;
      private BigDecimal applyAmount;
      private BigDecimal taxRate;
      private BigDecimal inputTax;
      private BigDecimal actuallyPayAmount;
      private Long expenseTypeId;
      private Long dictionaryId;
      private String dictionaryLabel;

      ReimbursementDetailDTOBuilder() {
      }

      public ReimbursementDetailDTO.ReimbursementDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ReimbursementDetailDTO.ReimbursementDetailDTOBuilder reimbursementId(final Long reimbursementId) {
         this.reimbursementId = reimbursementId;
         return this;
      }

      public ReimbursementDetailDTO.ReimbursementDetailDTOBuilder invoiceAmount(final BigDecimal invoiceAmount) {
         this.invoiceAmount = invoiceAmount;
         return this;
      }

      public ReimbursementDetailDTO.ReimbursementDetailDTOBuilder invoiceNo(final String invoiceNo) {
         this.invoiceNo = invoiceNo;
         return this;
      }

      public ReimbursementDetailDTO.ReimbursementDetailDTOBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public ReimbursementDetailDTO.ReimbursementDetailDTOBuilder applyAmount(final BigDecimal applyAmount) {
         this.applyAmount = applyAmount;
         return this;
      }

      public ReimbursementDetailDTO.ReimbursementDetailDTOBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public ReimbursementDetailDTO.ReimbursementDetailDTOBuilder inputTax(final BigDecimal inputTax) {
         this.inputTax = inputTax;
         return this;
      }

      public ReimbursementDetailDTO.ReimbursementDetailDTOBuilder actuallyPayAmount(final BigDecimal actuallyPayAmount) {
         this.actuallyPayAmount = actuallyPayAmount;
         return this;
      }

      public ReimbursementDetailDTO.ReimbursementDetailDTOBuilder expenseTypeId(final Long expenseTypeId) {
         this.expenseTypeId = expenseTypeId;
         return this;
      }

      public ReimbursementDetailDTO.ReimbursementDetailDTOBuilder dictionaryId(final Long dictionaryId) {
         this.dictionaryId = dictionaryId;
         return this;
      }

      public ReimbursementDetailDTO.ReimbursementDetailDTOBuilder dictionaryLabel(final String dictionaryLabel) {
         this.dictionaryLabel = dictionaryLabel;
         return this;
      }

      public ReimbursementDetailDTO build() {
         return new ReimbursementDetailDTO(
            this.id,
            this.reimbursementId,
            this.invoiceAmount,
            this.invoiceNo,
            this.invoiceType,
            this.applyAmount,
            this.taxRate,
            this.inputTax,
            this.actuallyPayAmount,
            this.expenseTypeId,
            this.dictionaryId,
            this.dictionaryLabel
         );
      }

      @Override
      public String toString() {
         return "ReimbursementDetailDTO.ReimbursementDetailDTOBuilder(id="
            + this.id
            + ", reimbursementId="
            + this.reimbursementId
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
            + ", actuallyPayAmount="
            + this.actuallyPayAmount
            + ", expenseTypeId="
            + this.expenseTypeId
            + ", dictionaryId="
            + this.dictionaryId
            + ", dictionaryLabel="
            + this.dictionaryLabel
            + ")";
      }
   }
}
