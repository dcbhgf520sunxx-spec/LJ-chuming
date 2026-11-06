package com.hzchum.scim.contract.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class CollectionDetailsDto {
   @ApiModelProperty(notes = "项目id")
   private Long projectId;
   @ApiModelProperty("合同额")
   private BigDecimal contractAmount;
   @ApiModelProperty("结算额")
   private BigDecimal settlementAmount;
   @ApiModelProperty(name = "contractAmountSum", notes = "累计合同金额（元）")
   private BigDecimal contractAmountSum;
   @ApiModelProperty(name = "contractAmountRate", notes = "收款率")
   private BigDecimal contractAmountRate;
   @ApiModelProperty(name = "invoiceAmountSum", notes = "累计发票金额（元）")
   private BigDecimal invoiceAmountSum;
   @ApiModelProperty(name = "invoiceAmountRate", notes = "开票率")
   private BigDecimal invoiceAmountRate;
   @ApiModelProperty(name = "cashSurplus", notes = "现金余额（元）")
   private BigDecimal cashSurplus;

   public Long getProjectId() {
      return this.projectId;
   }

   public BigDecimal getContractAmount() {
      return this.contractAmount;
   }

   public BigDecimal getSettlementAmount() {
      return this.settlementAmount;
   }

   public BigDecimal getContractAmountSum() {
      return this.contractAmountSum;
   }

   public BigDecimal getContractAmountRate() {
      return this.contractAmountRate;
   }

   public BigDecimal getInvoiceAmountSum() {
      return this.invoiceAmountSum;
   }

   public BigDecimal getInvoiceAmountRate() {
      return this.invoiceAmountRate;
   }

   public BigDecimal getCashSurplus() {
      return this.cashSurplus;
   }

   public CollectionDetailsDto setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public CollectionDetailsDto setContractAmount(final BigDecimal contractAmount) {
      this.contractAmount = contractAmount;
      return this;
   }

   public CollectionDetailsDto setSettlementAmount(final BigDecimal settlementAmount) {
      this.settlementAmount = settlementAmount;
      return this;
   }

   public CollectionDetailsDto setContractAmountSum(final BigDecimal contractAmountSum) {
      this.contractAmountSum = contractAmountSum;
      return this;
   }

   public CollectionDetailsDto setContractAmountRate(final BigDecimal contractAmountRate) {
      this.contractAmountRate = contractAmountRate;
      return this;
   }

   public CollectionDetailsDto setInvoiceAmountSum(final BigDecimal invoiceAmountSum) {
      this.invoiceAmountSum = invoiceAmountSum;
      return this;
   }

   public CollectionDetailsDto setInvoiceAmountRate(final BigDecimal invoiceAmountRate) {
      this.invoiceAmountRate = invoiceAmountRate;
      return this;
   }

   public CollectionDetailsDto setCashSurplus(final BigDecimal cashSurplus) {
      this.cashSurplus = cashSurplus;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CollectionDetailsDto)) {
         return false;
      }

      CollectionDetailsDto other = (CollectionDetailsDto)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$contractAmount = this.getContractAmount();
         Object other$contractAmount = other.getContractAmount();
         if (this$contractAmount == null ? other$contractAmount == null : this$contractAmount.equals(other$contractAmount)) {
            Object this$settlementAmount = this.getSettlementAmount();
            Object other$settlementAmount = other.getSettlementAmount();
            if (this$settlementAmount == null ? other$settlementAmount == null : this$settlementAmount.equals(other$settlementAmount)) {
               Object this$contractAmountSum = this.getContractAmountSum();
               Object other$contractAmountSum = other.getContractAmountSum();
               if (this$contractAmountSum == null ? other$contractAmountSum == null : this$contractAmountSum.equals(other$contractAmountSum)) {
                  Object this$contractAmountRate = this.getContractAmountRate();
                  Object other$contractAmountRate = other.getContractAmountRate();
                  if (this$contractAmountRate == null ? other$contractAmountRate == null : this$contractAmountRate.equals(other$contractAmountRate)) {
                     Object this$invoiceAmountSum = this.getInvoiceAmountSum();
                     Object other$invoiceAmountSum = other.getInvoiceAmountSum();
                     if (this$invoiceAmountSum == null ? other$invoiceAmountSum == null : this$invoiceAmountSum.equals(other$invoiceAmountSum)) {
                        Object this$invoiceAmountRate = this.getInvoiceAmountRate();
                        Object other$invoiceAmountRate = other.getInvoiceAmountRate();
                        if (this$invoiceAmountRate == null ? other$invoiceAmountRate == null : this$invoiceAmountRate.equals(other$invoiceAmountRate)) {
                           Object this$cashSurplus = this.getCashSurplus();
                           Object other$cashSurplus = other.getCashSurplus();
                           return this$cashSurplus == null ? other$cashSurplus == null : this$cashSurplus.equals(other$cashSurplus);
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
      return other instanceof CollectionDetailsDto;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $contractAmount = this.getContractAmount();
      result = result * 59 + ($contractAmount == null ? 43 : $contractAmount.hashCode());
      Object $settlementAmount = this.getSettlementAmount();
      result = result * 59 + ($settlementAmount == null ? 43 : $settlementAmount.hashCode());
      Object $contractAmountSum = this.getContractAmountSum();
      result = result * 59 + ($contractAmountSum == null ? 43 : $contractAmountSum.hashCode());
      Object $contractAmountRate = this.getContractAmountRate();
      result = result * 59 + ($contractAmountRate == null ? 43 : $contractAmountRate.hashCode());
      Object $invoiceAmountSum = this.getInvoiceAmountSum();
      result = result * 59 + ($invoiceAmountSum == null ? 43 : $invoiceAmountSum.hashCode());
      Object $invoiceAmountRate = this.getInvoiceAmountRate();
      result = result * 59 + ($invoiceAmountRate == null ? 43 : $invoiceAmountRate.hashCode());
      Object $cashSurplus = this.getCashSurplus();
      return result * 59 + ($cashSurplus == null ? 43 : $cashSurplus.hashCode());
   }

   @Override
   public String toString() {
      return "CollectionDetailsDto(projectId="
         + this.getProjectId()
         + ", contractAmount="
         + this.getContractAmount()
         + ", settlementAmount="
         + this.getSettlementAmount()
         + ", contractAmountSum="
         + this.getContractAmountSum()
         + ", contractAmountRate="
         + this.getContractAmountRate()
         + ", invoiceAmountSum="
         + this.getInvoiceAmountSum()
         + ", invoiceAmountRate="
         + this.getInvoiceAmountRate()
         + ", cashSurplus="
         + this.getCashSurplus()
         + ")";
   }

   public CollectionDetailsDto(
      final Long projectId,
      final BigDecimal contractAmount,
      final BigDecimal settlementAmount,
      final BigDecimal contractAmountSum,
      final BigDecimal contractAmountRate,
      final BigDecimal invoiceAmountSum,
      final BigDecimal invoiceAmountRate,
      final BigDecimal cashSurplus
   ) {
      this.projectId = projectId;
      this.contractAmount = contractAmount;
      this.settlementAmount = settlementAmount;
      this.contractAmountSum = contractAmountSum;
      this.contractAmountRate = contractAmountRate;
      this.invoiceAmountSum = invoiceAmountSum;
      this.invoiceAmountRate = invoiceAmountRate;
      this.cashSurplus = cashSurplus;
   }

   public CollectionDetailsDto() {
   }
}
