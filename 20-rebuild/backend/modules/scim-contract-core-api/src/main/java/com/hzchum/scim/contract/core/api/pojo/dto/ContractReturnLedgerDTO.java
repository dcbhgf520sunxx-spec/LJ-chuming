package com.hzchum.scim.contract.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class ContractReturnLedgerDTO {
   @ApiModelProperty(name = "branchCompanyId", value = "分支机构id(购买方)", notes = "分支机构id(购买方)")
   private Long branchCompanyId;
   @ApiModelProperty(name = "branchCompanyName", value = "分支机构(购买方)", notes = "分支机构(购买方)")
   private String branchCompanyName;
   @ApiModelProperty(name = "customerUnit", value = "客户单位(出售方)", notes = "客户单位(出售方)")
   private String customerUnit;
   @ApiModelProperty(name = "totalAmount", value = "总金额", notes = "总金额")
   private BigDecimal totalAmount;
   @ApiModelProperty("付款额")
   private BigDecimal paymentAmount;
   @ApiModelProperty("付款率")
   private BigDecimal paymentRate;
   @ApiModelProperty("收票额")
   private BigDecimal invoiceAmount;
   @ApiModelProperty("收票率")
   private BigDecimal invoiceRate;
   @ApiModelProperty("未审核付款数")
   private Integer unCheckPaymentCount;
   @ApiModelProperty("未审核收票数")
   private Integer unCheckInvoiceCount;

   public static ContractReturnLedgerDTO.ContractReturnLedgerDTOBuilder builder() {
      return new ContractReturnLedgerDTO.ContractReturnLedgerDTOBuilder();
   }

   public ContractReturnLedgerDTO(
      final Long branchCompanyId,
      final String branchCompanyName,
      final String customerUnit,
      final BigDecimal totalAmount,
      final BigDecimal paymentAmount,
      final BigDecimal paymentRate,
      final BigDecimal invoiceAmount,
      final BigDecimal invoiceRate,
      final Integer unCheckPaymentCount,
      final Integer unCheckInvoiceCount
   ) {
      this.branchCompanyId = branchCompanyId;
      this.branchCompanyName = branchCompanyName;
      this.customerUnit = customerUnit;
      this.totalAmount = totalAmount;
      this.paymentAmount = paymentAmount;
      this.paymentRate = paymentRate;
      this.invoiceAmount = invoiceAmount;
      this.invoiceRate = invoiceRate;
      this.unCheckPaymentCount = unCheckPaymentCount;
      this.unCheckInvoiceCount = unCheckInvoiceCount;
   }

   public ContractReturnLedgerDTO() {
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public String getBranchCompanyName() {
      return this.branchCompanyName;
   }

   public String getCustomerUnit() {
      return this.customerUnit;
   }

   public BigDecimal getTotalAmount() {
      return this.totalAmount;
   }

   public BigDecimal getPaymentAmount() {
      return this.paymentAmount;
   }

   public BigDecimal getPaymentRate() {
      return this.paymentRate;
   }

   public BigDecimal getInvoiceAmount() {
      return this.invoiceAmount;
   }

   public BigDecimal getInvoiceRate() {
      return this.invoiceRate;
   }

   public Integer getUnCheckPaymentCount() {
      return this.unCheckPaymentCount;
   }

   public Integer getUnCheckInvoiceCount() {
      return this.unCheckInvoiceCount;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setBranchCompanyName(final String branchCompanyName) {
      this.branchCompanyName = branchCompanyName;
   }

   public void setCustomerUnit(final String customerUnit) {
      this.customerUnit = customerUnit;
   }

   public void setTotalAmount(final BigDecimal totalAmount) {
      this.totalAmount = totalAmount;
   }

   public void setPaymentAmount(final BigDecimal paymentAmount) {
      this.paymentAmount = paymentAmount;
   }

   public void setPaymentRate(final BigDecimal paymentRate) {
      this.paymentRate = paymentRate;
   }

   public void setInvoiceAmount(final BigDecimal invoiceAmount) {
      this.invoiceAmount = invoiceAmount;
   }

   public void setInvoiceRate(final BigDecimal invoiceRate) {
      this.invoiceRate = invoiceRate;
   }

   public void setUnCheckPaymentCount(final Integer unCheckPaymentCount) {
      this.unCheckPaymentCount = unCheckPaymentCount;
   }

   public void setUnCheckInvoiceCount(final Integer unCheckInvoiceCount) {
      this.unCheckInvoiceCount = unCheckInvoiceCount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractReturnLedgerDTO)) {
         return false;
      }

      ContractReturnLedgerDTO other = (ContractReturnLedgerDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$branchCompanyId = this.getBranchCompanyId();
      Object other$branchCompanyId = other.getBranchCompanyId();
      if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
         Object this$unCheckPaymentCount = this.getUnCheckPaymentCount();
         Object other$unCheckPaymentCount = other.getUnCheckPaymentCount();
         if (this$unCheckPaymentCount == null ? other$unCheckPaymentCount == null : this$unCheckPaymentCount.equals(other$unCheckPaymentCount)) {
            Object this$unCheckInvoiceCount = this.getUnCheckInvoiceCount();
            Object other$unCheckInvoiceCount = other.getUnCheckInvoiceCount();
            if (this$unCheckInvoiceCount == null ? other$unCheckInvoiceCount == null : this$unCheckInvoiceCount.equals(other$unCheckInvoiceCount)) {
               Object this$branchCompanyName = this.getBranchCompanyName();
               Object other$branchCompanyName = other.getBranchCompanyName();
               if (this$branchCompanyName == null ? other$branchCompanyName == null : this$branchCompanyName.equals(other$branchCompanyName)) {
                  Object this$customerUnit = this.getCustomerUnit();
                  Object other$customerUnit = other.getCustomerUnit();
                  if (this$customerUnit == null ? other$customerUnit == null : this$customerUnit.equals(other$customerUnit)) {
                     Object this$totalAmount = this.getTotalAmount();
                     Object other$totalAmount = other.getTotalAmount();
                     if (this$totalAmount == null ? other$totalAmount == null : this$totalAmount.equals(other$totalAmount)) {
                        Object this$paymentAmount = this.getPaymentAmount();
                        Object other$paymentAmount = other.getPaymentAmount();
                        if (this$paymentAmount == null ? other$paymentAmount == null : this$paymentAmount.equals(other$paymentAmount)) {
                           Object this$paymentRate = this.getPaymentRate();
                           Object other$paymentRate = other.getPaymentRate();
                           if (this$paymentRate == null ? other$paymentRate == null : this$paymentRate.equals(other$paymentRate)) {
                              Object this$invoiceAmount = this.getInvoiceAmount();
                              Object other$invoiceAmount = other.getInvoiceAmount();
                              if (this$invoiceAmount == null ? other$invoiceAmount == null : this$invoiceAmount.equals(other$invoiceAmount)) {
                                 Object this$invoiceRate = this.getInvoiceRate();
                                 Object other$invoiceRate = other.getInvoiceRate();
                                 return this$invoiceRate == null ? other$invoiceRate == null : this$invoiceRate.equals(other$invoiceRate);
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
      return other instanceof ContractReturnLedgerDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $unCheckPaymentCount = this.getUnCheckPaymentCount();
      result = result * 59 + ($unCheckPaymentCount == null ? 43 : $unCheckPaymentCount.hashCode());
      Object $unCheckInvoiceCount = this.getUnCheckInvoiceCount();
      result = result * 59 + ($unCheckInvoiceCount == null ? 43 : $unCheckInvoiceCount.hashCode());
      Object $branchCompanyName = this.getBranchCompanyName();
      result = result * 59 + ($branchCompanyName == null ? 43 : $branchCompanyName.hashCode());
      Object $customerUnit = this.getCustomerUnit();
      result = result * 59 + ($customerUnit == null ? 43 : $customerUnit.hashCode());
      Object $totalAmount = this.getTotalAmount();
      result = result * 59 + ($totalAmount == null ? 43 : $totalAmount.hashCode());
      Object $paymentAmount = this.getPaymentAmount();
      result = result * 59 + ($paymentAmount == null ? 43 : $paymentAmount.hashCode());
      Object $paymentRate = this.getPaymentRate();
      result = result * 59 + ($paymentRate == null ? 43 : $paymentRate.hashCode());
      Object $invoiceAmount = this.getInvoiceAmount();
      result = result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
      Object $invoiceRate = this.getInvoiceRate();
      return result * 59 + ($invoiceRate == null ? 43 : $invoiceRate.hashCode());
   }

   @Override
   public String toString() {
      return "ContractReturnLedgerDTO(branchCompanyId="
         + this.getBranchCompanyId()
         + ", branchCompanyName="
         + this.getBranchCompanyName()
         + ", customerUnit="
         + this.getCustomerUnit()
         + ", totalAmount="
         + this.getTotalAmount()
         + ", paymentAmount="
         + this.getPaymentAmount()
         + ", paymentRate="
         + this.getPaymentRate()
         + ", invoiceAmount="
         + this.getInvoiceAmount()
         + ", invoiceRate="
         + this.getInvoiceRate()
         + ", unCheckPaymentCount="
         + this.getUnCheckPaymentCount()
         + ", unCheckInvoiceCount="
         + this.getUnCheckInvoiceCount()
         + ")";
   }

   public static class ContractReturnLedgerDTOBuilder {
      private Long branchCompanyId;
      private String branchCompanyName;
      private String customerUnit;
      private BigDecimal totalAmount;
      private BigDecimal paymentAmount;
      private BigDecimal paymentRate;
      private BigDecimal invoiceAmount;
      private BigDecimal invoiceRate;
      private Integer unCheckPaymentCount;
      private Integer unCheckInvoiceCount;

      ContractReturnLedgerDTOBuilder() {
      }

      public ContractReturnLedgerDTO.ContractReturnLedgerDTOBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public ContractReturnLedgerDTO.ContractReturnLedgerDTOBuilder branchCompanyName(final String branchCompanyName) {
         this.branchCompanyName = branchCompanyName;
         return this;
      }

      public ContractReturnLedgerDTO.ContractReturnLedgerDTOBuilder customerUnit(final String customerUnit) {
         this.customerUnit = customerUnit;
         return this;
      }

      public ContractReturnLedgerDTO.ContractReturnLedgerDTOBuilder totalAmount(final BigDecimal totalAmount) {
         this.totalAmount = totalAmount;
         return this;
      }

      public ContractReturnLedgerDTO.ContractReturnLedgerDTOBuilder paymentAmount(final BigDecimal paymentAmount) {
         this.paymentAmount = paymentAmount;
         return this;
      }

      public ContractReturnLedgerDTO.ContractReturnLedgerDTOBuilder paymentRate(final BigDecimal paymentRate) {
         this.paymentRate = paymentRate;
         return this;
      }

      public ContractReturnLedgerDTO.ContractReturnLedgerDTOBuilder invoiceAmount(final BigDecimal invoiceAmount) {
         this.invoiceAmount = invoiceAmount;
         return this;
      }

      public ContractReturnLedgerDTO.ContractReturnLedgerDTOBuilder invoiceRate(final BigDecimal invoiceRate) {
         this.invoiceRate = invoiceRate;
         return this;
      }

      public ContractReturnLedgerDTO.ContractReturnLedgerDTOBuilder unCheckPaymentCount(final Integer unCheckPaymentCount) {
         this.unCheckPaymentCount = unCheckPaymentCount;
         return this;
      }

      public ContractReturnLedgerDTO.ContractReturnLedgerDTOBuilder unCheckInvoiceCount(final Integer unCheckInvoiceCount) {
         this.unCheckInvoiceCount = unCheckInvoiceCount;
         return this;
      }

      public ContractReturnLedgerDTO build() {
         return new ContractReturnLedgerDTO(
            this.branchCompanyId,
            this.branchCompanyName,
            this.customerUnit,
            this.totalAmount,
            this.paymentAmount,
            this.paymentRate,
            this.invoiceAmount,
            this.invoiceRate,
            this.unCheckPaymentCount,
            this.unCheckInvoiceCount
         );
      }

      @Override
      public String toString() {
         return "ContractReturnLedgerDTO.ContractReturnLedgerDTOBuilder(branchCompanyId="
            + this.branchCompanyId
            + ", branchCompanyName="
            + this.branchCompanyName
            + ", customerUnit="
            + this.customerUnit
            + ", totalAmount="
            + this.totalAmount
            + ", paymentAmount="
            + this.paymentAmount
            + ", paymentRate="
            + this.paymentRate
            + ", invoiceAmount="
            + this.invoiceAmount
            + ", invoiceRate="
            + this.invoiceRate
            + ", unCheckPaymentCount="
            + this.unCheckPaymentCount
            + ", unCheckInvoiceCount="
            + this.unCheckInvoiceCount
            + ")";
      }
   }
}
