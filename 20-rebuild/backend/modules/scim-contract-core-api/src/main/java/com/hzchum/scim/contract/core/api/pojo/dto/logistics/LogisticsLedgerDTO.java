package com.hzchum.scim.contract.core.api.pojo.dto.logistics;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.SupplierInfo;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;

@ApiOperation("物流台账")
public class LogisticsLedgerDTO {
   @ApiModelProperty("供应商信息")
   private SupplierInfo supplier;
   @ApiModelProperty("签约主体")
   private NameInfo branchCompany;
   @ApiModelProperty("车次")
   private Integer trainNumber;
   @ApiModelProperty("累计金额")
   private BigDecimal freight;
   @ApiModelProperty("结算额")
   private BigDecimal settlementAmount;
   @ApiModelProperty("累计付款")
   private BigDecimal paymentAmount;
   @ApiModelProperty("累计收票")
   private BigDecimal invoiceAmount;
   @ApiModelProperty("状态")
   private Integer statusEnum;

   LogisticsLedgerDTO(
      final SupplierInfo supplier,
      final NameInfo branchCompany,
      final Integer trainNumber,
      final BigDecimal freight,
      final BigDecimal settlementAmount,
      final BigDecimal paymentAmount,
      final BigDecimal invoiceAmount,
      final Integer statusEnum
   ) {
      this.supplier = supplier;
      this.branchCompany = branchCompany;
      this.trainNumber = trainNumber;
      this.freight = freight;
      this.settlementAmount = settlementAmount;
      this.paymentAmount = paymentAmount;
      this.invoiceAmount = invoiceAmount;
      this.statusEnum = statusEnum;
   }

   public static LogisticsLedgerDTO.LogisticsLedgerDTOBuilder builder() {
      return new LogisticsLedgerDTO.LogisticsLedgerDTOBuilder();
   }

   public SupplierInfo getSupplier() {
      return this.supplier;
   }

   public NameInfo getBranchCompany() {
      return this.branchCompany;
   }

   public Integer getTrainNumber() {
      return this.trainNumber;
   }

   public BigDecimal getFreight() {
      return this.freight;
   }

   public BigDecimal getSettlementAmount() {
      return this.settlementAmount;
   }

   public BigDecimal getPaymentAmount() {
      return this.paymentAmount;
   }

   public BigDecimal getInvoiceAmount() {
      return this.invoiceAmount;
   }

   public Integer getStatusEnum() {
      return this.statusEnum;
   }

   public void setSupplier(final SupplierInfo supplier) {
      this.supplier = supplier;
   }

   public void setBranchCompany(final NameInfo branchCompany) {
      this.branchCompany = branchCompany;
   }

   public void setTrainNumber(final Integer trainNumber) {
      this.trainNumber = trainNumber;
   }

   public void setFreight(final BigDecimal freight) {
      this.freight = freight;
   }

   public void setSettlementAmount(final BigDecimal settlementAmount) {
      this.settlementAmount = settlementAmount;
   }

   public void setPaymentAmount(final BigDecimal paymentAmount) {
      this.paymentAmount = paymentAmount;
   }

   public void setInvoiceAmount(final BigDecimal invoiceAmount) {
      this.invoiceAmount = invoiceAmount;
   }

   public void setStatusEnum(final Integer statusEnum) {
      this.statusEnum = statusEnum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof LogisticsLedgerDTO)) {
         return false;
      }

      LogisticsLedgerDTO other = (LogisticsLedgerDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$trainNumber = this.getTrainNumber();
      Object other$trainNumber = other.getTrainNumber();
      if (this$trainNumber == null ? other$trainNumber == null : this$trainNumber.equals(other$trainNumber)) {
         Object this$statusEnum = this.getStatusEnum();
         Object other$statusEnum = other.getStatusEnum();
         if (this$statusEnum == null ? other$statusEnum == null : this$statusEnum.equals(other$statusEnum)) {
            Object this$supplier = this.getSupplier();
            Object other$supplier = other.getSupplier();
            if (this$supplier == null ? other$supplier == null : this$supplier.equals(other$supplier)) {
               Object this$branchCompany = this.getBranchCompany();
               Object other$branchCompany = other.getBranchCompany();
               if (this$branchCompany == null ? other$branchCompany == null : this$branchCompany.equals(other$branchCompany)) {
                  Object this$freight = this.getFreight();
                  Object other$freight = other.getFreight();
                  if (this$freight == null ? other$freight == null : this$freight.equals(other$freight)) {
                     Object this$settlementAmount = this.getSettlementAmount();
                     Object other$settlementAmount = other.getSettlementAmount();
                     if (this$settlementAmount == null ? other$settlementAmount == null : this$settlementAmount.equals(other$settlementAmount)) {
                        Object this$paymentAmount = this.getPaymentAmount();
                        Object other$paymentAmount = other.getPaymentAmount();
                        if (this$paymentAmount == null ? other$paymentAmount == null : this$paymentAmount.equals(other$paymentAmount)) {
                           Object this$invoiceAmount = this.getInvoiceAmount();
                           Object other$invoiceAmount = other.getInvoiceAmount();
                           return this$invoiceAmount == null ? other$invoiceAmount == null : this$invoiceAmount.equals(other$invoiceAmount);
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
      return other instanceof LogisticsLedgerDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $trainNumber = this.getTrainNumber();
      result = result * 59 + ($trainNumber == null ? 43 : $trainNumber.hashCode());
      Object $statusEnum = this.getStatusEnum();
      result = result * 59 + ($statusEnum == null ? 43 : $statusEnum.hashCode());
      Object $supplier = this.getSupplier();
      result = result * 59 + ($supplier == null ? 43 : $supplier.hashCode());
      Object $branchCompany = this.getBranchCompany();
      result = result * 59 + ($branchCompany == null ? 43 : $branchCompany.hashCode());
      Object $freight = this.getFreight();
      result = result * 59 + ($freight == null ? 43 : $freight.hashCode());
      Object $settlementAmount = this.getSettlementAmount();
      result = result * 59 + ($settlementAmount == null ? 43 : $settlementAmount.hashCode());
      Object $paymentAmount = this.getPaymentAmount();
      result = result * 59 + ($paymentAmount == null ? 43 : $paymentAmount.hashCode());
      Object $invoiceAmount = this.getInvoiceAmount();
      return result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
   }

   @Override
   public String toString() {
      return "LogisticsLedgerDTO(supplier="
         + this.getSupplier()
         + ", branchCompany="
         + this.getBranchCompany()
         + ", trainNumber="
         + this.getTrainNumber()
         + ", freight="
         + this.getFreight()
         + ", settlementAmount="
         + this.getSettlementAmount()
         + ", paymentAmount="
         + this.getPaymentAmount()
         + ", invoiceAmount="
         + this.getInvoiceAmount()
         + ", statusEnum="
         + this.getStatusEnum()
         + ")";
   }

   public static class LogisticsLedgerDTOBuilder {
      private SupplierInfo supplier;
      private NameInfo branchCompany;
      private Integer trainNumber;
      private BigDecimal freight;
      private BigDecimal settlementAmount;
      private BigDecimal paymentAmount;
      private BigDecimal invoiceAmount;
      private Integer statusEnum;

      LogisticsLedgerDTOBuilder() {
      }

      public LogisticsLedgerDTO.LogisticsLedgerDTOBuilder supplier(final SupplierInfo supplier) {
         this.supplier = supplier;
         return this;
      }

      public LogisticsLedgerDTO.LogisticsLedgerDTOBuilder branchCompany(final NameInfo branchCompany) {
         this.branchCompany = branchCompany;
         return this;
      }

      public LogisticsLedgerDTO.LogisticsLedgerDTOBuilder trainNumber(final Integer trainNumber) {
         this.trainNumber = trainNumber;
         return this;
      }

      public LogisticsLedgerDTO.LogisticsLedgerDTOBuilder freight(final BigDecimal freight) {
         this.freight = freight;
         return this;
      }

      public LogisticsLedgerDTO.LogisticsLedgerDTOBuilder settlementAmount(final BigDecimal settlementAmount) {
         this.settlementAmount = settlementAmount;
         return this;
      }

      public LogisticsLedgerDTO.LogisticsLedgerDTOBuilder paymentAmount(final BigDecimal paymentAmount) {
         this.paymentAmount = paymentAmount;
         return this;
      }

      public LogisticsLedgerDTO.LogisticsLedgerDTOBuilder invoiceAmount(final BigDecimal invoiceAmount) {
         this.invoiceAmount = invoiceAmount;
         return this;
      }

      public LogisticsLedgerDTO.LogisticsLedgerDTOBuilder statusEnum(final Integer statusEnum) {
         this.statusEnum = statusEnum;
         return this;
      }

      public LogisticsLedgerDTO build() {
         return new LogisticsLedgerDTO(
            this.supplier, this.branchCompany, this.trainNumber, this.freight, this.settlementAmount, this.paymentAmount, this.invoiceAmount, this.statusEnum
         );
      }

      @Override
      public String toString() {
         return "LogisticsLedgerDTO.LogisticsLedgerDTOBuilder(supplier="
            + this.supplier
            + ", branchCompany="
            + this.branchCompany
            + ", trainNumber="
            + this.trainNumber
            + ", freight="
            + this.freight
            + ", settlementAmount="
            + this.settlementAmount
            + ", paymentAmount="
            + this.paymentAmount
            + ", invoiceAmount="
            + this.invoiceAmount
            + ", statusEnum="
            + this.statusEnum
            + ")";
      }
   }
}
