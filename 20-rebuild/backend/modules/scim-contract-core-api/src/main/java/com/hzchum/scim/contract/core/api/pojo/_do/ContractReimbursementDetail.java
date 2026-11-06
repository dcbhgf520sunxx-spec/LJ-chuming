package com.hzchum.scim.contract.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "ContractReimbursementDetail对象", description = "报销明细表")
@Entity
@TableName("contract_reimbursement_detail")
@Table(name = "contract_reimbursement_detail")
public class ContractReimbursementDetail extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "reimbursementId", value = "报销表id")
   @JsonProperty("reimbursementId")
   @JSONField(name = "reimbursementId")
   @TableField("reimbursement_id")
   @Column(name = "reimbursement_id")
   private Long reimbursementId;
   @ApiModelProperty(name = "invoiceAmount", value = "发票金额")
   @JsonProperty("invoiceAmount")
   @JSONField(name = "invoiceAmount")
   @TableField("invoice_amount")
   @Column(name = "invoice_amount")
   private BigDecimal invoiceAmount;
   @ApiModelProperty(name = "invoiceNo", value = "发票号码")
   @JsonProperty("invoiceNo")
   @JSONField(name = "invoiceNo")
   @TableField("invoice_no")
   @Column(name = "invoice_no")
   private String invoiceNo;
   @ApiModelProperty(name = "invoiceType", value = "发票类型 1增值专用票 2增值普发票 4收据")
   @JsonProperty("invoiceType")
   @JSONField(name = "invoiceType")
   @TableField("invoice_type")
   @Column(name = "invoice_type")
   private Integer invoiceType;
   @ApiModelProperty(name = "applyAmount", value = "申请报销金额")
   @JsonProperty("applyAmount")
   @JSONField(name = "applyAmount")
   @TableField("apply_amount")
   @Column(name = "apply_amount")
   private BigDecimal applyAmount;
   @ApiModelProperty(name = "taxRate", value = "税率")
   @JsonProperty("taxRate")
   @JSONField(name = "taxRate")
   @TableField("tax_rate")
   @Column(name = "tax_rate")
   private BigDecimal taxRate;
   @ApiModelProperty(name = "inputTax", value = "进项税额")
   @JsonProperty("inputTax")
   @JSONField(name = "inputTax")
   @TableField("input_tax")
   @Column(name = "input_tax")
   private BigDecimal inputTax;
   @ApiModelProperty(name = "actuallyPayAmount", value = "实付金额")
   @JsonProperty("actuallyPayAmount")
   @JSONField(name = "actuallyPayAmount")
   @TableField("actually_pay_amount")
   @Column(name = "actually_pay_amount")
   private BigDecimal actuallyPayAmount;
   @ApiModelProperty(name = "expenseTypeId", value = "费用类别id")
   @JsonProperty("expenseTypeId")
   @JSONField(name = "expenseTypeId")
   @TableField("expense_type_id")
   @Column(name = "expense_type_id")
   private Long expenseTypeId;
   @ApiModelProperty(name = "dictionaryId", value = "字典表id")
   @JsonProperty("dictionaryId")
   @JSONField(name = "dictionaryId")
   @TableField("dictionary_id")
   @Column(name = "dictionary_id")
   private Long dictionaryId;

   public static ContractReimbursementDetail.ContractReimbursementDetailBuilder builder() {
      return new ContractReimbursementDetail.ContractReimbursementDetailBuilder();
   }

   public ContractReimbursementDetail() {
   }

   public ContractReimbursementDetail(
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
      final Long dictionaryId
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

   @JsonProperty("id")
   public ContractReimbursementDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("reimbursementId")
   public ContractReimbursementDetail setReimbursementId(final Long reimbursementId) {
      this.reimbursementId = reimbursementId;
      return this;
   }

   @JsonProperty("invoiceAmount")
   public ContractReimbursementDetail setInvoiceAmount(final BigDecimal invoiceAmount) {
      this.invoiceAmount = invoiceAmount;
      return this;
   }

   @JsonProperty("invoiceNo")
   public ContractReimbursementDetail setInvoiceNo(final String invoiceNo) {
      this.invoiceNo = invoiceNo;
      return this;
   }

   @JsonProperty("invoiceType")
   public ContractReimbursementDetail setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
      return this;
   }

   @JsonProperty("applyAmount")
   public ContractReimbursementDetail setApplyAmount(final BigDecimal applyAmount) {
      this.applyAmount = applyAmount;
      return this;
   }

   @JsonProperty("taxRate")
   public ContractReimbursementDetail setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
      return this;
   }

   @JsonProperty("inputTax")
   public ContractReimbursementDetail setInputTax(final BigDecimal inputTax) {
      this.inputTax = inputTax;
      return this;
   }

   @JsonProperty("actuallyPayAmount")
   public ContractReimbursementDetail setActuallyPayAmount(final BigDecimal actuallyPayAmount) {
      this.actuallyPayAmount = actuallyPayAmount;
      return this;
   }

   @JsonProperty("expenseTypeId")
   public ContractReimbursementDetail setExpenseTypeId(final Long expenseTypeId) {
      this.expenseTypeId = expenseTypeId;
      return this;
   }

   @JsonProperty("dictionaryId")
   public ContractReimbursementDetail setDictionaryId(final Long dictionaryId) {
      this.dictionaryId = dictionaryId;
      return this;
   }

   @Override
   public String toString() {
      return "ContractReimbursementDetail(id="
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
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractReimbursementDetail)) {
         return false;
      }

      ContractReimbursementDetail other = (ContractReimbursementDetail)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
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
                                    return this$actuallyPayAmount == null
                                       ? other$actuallyPayAmount == null
                                       : this$actuallyPayAmount.equals(other$actuallyPayAmount);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ContractReimbursementDetail;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
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
      return result * 59 + ($actuallyPayAmount == null ? 43 : $actuallyPayAmount.hashCode());
   }

   public static class ContractReimbursementDetailBuilder {
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

      ContractReimbursementDetailBuilder() {
      }

      @JsonProperty("id")
      public ContractReimbursementDetail.ContractReimbursementDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("reimbursementId")
      public ContractReimbursementDetail.ContractReimbursementDetailBuilder reimbursementId(final Long reimbursementId) {
         this.reimbursementId = reimbursementId;
         return this;
      }

      @JsonProperty("invoiceAmount")
      public ContractReimbursementDetail.ContractReimbursementDetailBuilder invoiceAmount(final BigDecimal invoiceAmount) {
         this.invoiceAmount = invoiceAmount;
         return this;
      }

      @JsonProperty("invoiceNo")
      public ContractReimbursementDetail.ContractReimbursementDetailBuilder invoiceNo(final String invoiceNo) {
         this.invoiceNo = invoiceNo;
         return this;
      }

      @JsonProperty("invoiceType")
      public ContractReimbursementDetail.ContractReimbursementDetailBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      @JsonProperty("applyAmount")
      public ContractReimbursementDetail.ContractReimbursementDetailBuilder applyAmount(final BigDecimal applyAmount) {
         this.applyAmount = applyAmount;
         return this;
      }

      @JsonProperty("taxRate")
      public ContractReimbursementDetail.ContractReimbursementDetailBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      @JsonProperty("inputTax")
      public ContractReimbursementDetail.ContractReimbursementDetailBuilder inputTax(final BigDecimal inputTax) {
         this.inputTax = inputTax;
         return this;
      }

      @JsonProperty("actuallyPayAmount")
      public ContractReimbursementDetail.ContractReimbursementDetailBuilder actuallyPayAmount(final BigDecimal actuallyPayAmount) {
         this.actuallyPayAmount = actuallyPayAmount;
         return this;
      }

      @JsonProperty("expenseTypeId")
      public ContractReimbursementDetail.ContractReimbursementDetailBuilder expenseTypeId(final Long expenseTypeId) {
         this.expenseTypeId = expenseTypeId;
         return this;
      }

      @JsonProperty("dictionaryId")
      public ContractReimbursementDetail.ContractReimbursementDetailBuilder dictionaryId(final Long dictionaryId) {
         this.dictionaryId = dictionaryId;
         return this;
      }

      public ContractReimbursementDetail build() {
         return new ContractReimbursementDetail(
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
            this.dictionaryId
         );
      }

      @Override
      public String toString() {
         return "ContractReimbursementDetail.ContractReimbursementDetailBuilder(id="
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
            + ")";
      }
   }
}
