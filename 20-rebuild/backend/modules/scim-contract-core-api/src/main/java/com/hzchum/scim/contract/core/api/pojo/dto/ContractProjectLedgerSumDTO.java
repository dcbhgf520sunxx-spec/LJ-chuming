package com.hzchum.scim.contract.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("财务统计类")
public class ContractProjectLedgerSumDTO {
   @ApiModelProperty(name = "contractAmountSum", notes = "累计合同金额（元）")
   private BigDecimal contractAmountSum;
   @ApiModelProperty(name = "settlementAmountSum", notes = "累计结算金额（元）")
   private BigDecimal settlementAmountSum;
   @ApiModelProperty(name = "collectionAmountSum", notes = "累计已收款金额（元）")
   private BigDecimal collectionAmountSum;
   @ApiModelProperty(name = "invoiceAmountSum", value = "累计开票金额")
   private BigDecimal invoiceAmountSum;

   public static ContractProjectLedgerSumDTO.ContractProjectLedgerSumDTOBuilder builder() {
      return new ContractProjectLedgerSumDTO.ContractProjectLedgerSumDTOBuilder();
   }

   public ContractProjectLedgerSumDTO() {
   }

   public ContractProjectLedgerSumDTO(
      final BigDecimal contractAmountSum, final BigDecimal settlementAmountSum, final BigDecimal collectionAmountSum, final BigDecimal invoiceAmountSum
   ) {
      this.contractAmountSum = contractAmountSum;
      this.settlementAmountSum = settlementAmountSum;
      this.collectionAmountSum = collectionAmountSum;
      this.invoiceAmountSum = invoiceAmountSum;
   }

   public BigDecimal getContractAmountSum() {
      return this.contractAmountSum;
   }

   public BigDecimal getSettlementAmountSum() {
      return this.settlementAmountSum;
   }

   public BigDecimal getCollectionAmountSum() {
      return this.collectionAmountSum;
   }

   public BigDecimal getInvoiceAmountSum() {
      return this.invoiceAmountSum;
   }

   public void setContractAmountSum(final BigDecimal contractAmountSum) {
      this.contractAmountSum = contractAmountSum;
   }

   public void setSettlementAmountSum(final BigDecimal settlementAmountSum) {
      this.settlementAmountSum = settlementAmountSum;
   }

   public void setCollectionAmountSum(final BigDecimal collectionAmountSum) {
      this.collectionAmountSum = collectionAmountSum;
   }

   public void setInvoiceAmountSum(final BigDecimal invoiceAmountSum) {
      this.invoiceAmountSum = invoiceAmountSum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractProjectLedgerSumDTO)) {
         return false;
      }

      ContractProjectLedgerSumDTO other = (ContractProjectLedgerSumDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$contractAmountSum = this.getContractAmountSum();
      Object other$contractAmountSum = other.getContractAmountSum();
      if (this$contractAmountSum == null ? other$contractAmountSum == null : this$contractAmountSum.equals(other$contractAmountSum)) {
         Object this$settlementAmountSum = this.getSettlementAmountSum();
         Object other$settlementAmountSum = other.getSettlementAmountSum();
         if (this$settlementAmountSum == null ? other$settlementAmountSum == null : this$settlementAmountSum.equals(other$settlementAmountSum)) {
            Object this$collectionAmountSum = this.getCollectionAmountSum();
            Object other$collectionAmountSum = other.getCollectionAmountSum();
            if (this$collectionAmountSum == null ? other$collectionAmountSum == null : this$collectionAmountSum.equals(other$collectionAmountSum)) {
               Object this$invoiceAmountSum = this.getInvoiceAmountSum();
               Object other$invoiceAmountSum = other.getInvoiceAmountSum();
               return this$invoiceAmountSum == null ? other$invoiceAmountSum == null : this$invoiceAmountSum.equals(other$invoiceAmountSum);
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
      return other instanceof ContractProjectLedgerSumDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $contractAmountSum = this.getContractAmountSum();
      result = result * 59 + ($contractAmountSum == null ? 43 : $contractAmountSum.hashCode());
      Object $settlementAmountSum = this.getSettlementAmountSum();
      result = result * 59 + ($settlementAmountSum == null ? 43 : $settlementAmountSum.hashCode());
      Object $collectionAmountSum = this.getCollectionAmountSum();
      result = result * 59 + ($collectionAmountSum == null ? 43 : $collectionAmountSum.hashCode());
      Object $invoiceAmountSum = this.getInvoiceAmountSum();
      return result * 59 + ($invoiceAmountSum == null ? 43 : $invoiceAmountSum.hashCode());
   }

   @Override
   public String toString() {
      return "ContractProjectLedgerSumDTO(contractAmountSum="
         + this.getContractAmountSum()
         + ", settlementAmountSum="
         + this.getSettlementAmountSum()
         + ", collectionAmountSum="
         + this.getCollectionAmountSum()
         + ", invoiceAmountSum="
         + this.getInvoiceAmountSum()
         + ")";
   }

   public static class ContractProjectLedgerSumDTOBuilder {
      private BigDecimal contractAmountSum;
      private BigDecimal settlementAmountSum;
      private BigDecimal collectionAmountSum;
      private BigDecimal invoiceAmountSum;

      ContractProjectLedgerSumDTOBuilder() {
      }

      public ContractProjectLedgerSumDTO.ContractProjectLedgerSumDTOBuilder contractAmountSum(final BigDecimal contractAmountSum) {
         this.contractAmountSum = contractAmountSum;
         return this;
      }

      public ContractProjectLedgerSumDTO.ContractProjectLedgerSumDTOBuilder settlementAmountSum(final BigDecimal settlementAmountSum) {
         this.settlementAmountSum = settlementAmountSum;
         return this;
      }

      public ContractProjectLedgerSumDTO.ContractProjectLedgerSumDTOBuilder collectionAmountSum(final BigDecimal collectionAmountSum) {
         this.collectionAmountSum = collectionAmountSum;
         return this;
      }

      public ContractProjectLedgerSumDTO.ContractProjectLedgerSumDTOBuilder invoiceAmountSum(final BigDecimal invoiceAmountSum) {
         this.invoiceAmountSum = invoiceAmountSum;
         return this;
      }

      public ContractProjectLedgerSumDTO build() {
         return new ContractProjectLedgerSumDTO(this.contractAmountSum, this.settlementAmountSum, this.collectionAmountSum, this.invoiceAmountSum);
      }

      @Override
      public String toString() {
         return "ContractProjectLedgerSumDTO.ContractProjectLedgerSumDTOBuilder(contractAmountSum="
            + this.contractAmountSum
            + ", settlementAmountSum="
            + this.settlementAmountSum
            + ", collectionAmountSum="
            + this.collectionAmountSum
            + ", invoiceAmountSum="
            + this.invoiceAmountSum
            + ")";
      }
   }
}
