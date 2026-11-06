package com.hzchum.scim.contract.core.api.pojo.dto.supplier;

import com.hzchum.scim.common.core.api.pojo.common.SupplierInfo;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;

@ApiOperation("项目台账-自营成本-材料明细表")
public class ProjectLedgerSeltSupportPaymentDetailDto {
   @ApiModelProperty("供应商")
   private SupplierInfo supplier;
   @ApiModelProperty("合同额")
   private BigDecimal contractAmount;
   @ApiModelProperty("结算金额")
   private BigDecimal settlementAmount;
   @ApiModelProperty("累计已支付")
   private BigDecimal totalPayment;
   @ApiModelProperty("累计未支付")
   private BigDecimal totalUnpaid;

   ProjectLedgerSeltSupportPaymentDetailDto(
      final SupplierInfo supplier,
      final BigDecimal contractAmount,
      final BigDecimal settlementAmount,
      final BigDecimal totalPayment,
      final BigDecimal totalUnpaid
   ) {
      this.supplier = supplier;
      this.contractAmount = contractAmount;
      this.settlementAmount = settlementAmount;
      this.totalPayment = totalPayment;
      this.totalUnpaid = totalUnpaid;
   }

   public static ProjectLedgerSeltSupportPaymentDetailDto.ProjectLedgerSeltSupportPaymentDetailDtoBuilder builder() {
      return new ProjectLedgerSeltSupportPaymentDetailDto.ProjectLedgerSeltSupportPaymentDetailDtoBuilder();
   }

   public SupplierInfo getSupplier() {
      return this.supplier;
   }

   public BigDecimal getContractAmount() {
      return this.contractAmount;
   }

   public BigDecimal getSettlementAmount() {
      return this.settlementAmount;
   }

   public BigDecimal getTotalPayment() {
      return this.totalPayment;
   }

   public BigDecimal getTotalUnpaid() {
      return this.totalUnpaid;
   }

   public void setSupplier(final SupplierInfo supplier) {
      this.supplier = supplier;
   }

   public void setContractAmount(final BigDecimal contractAmount) {
      this.contractAmount = contractAmount;
   }

   public void setSettlementAmount(final BigDecimal settlementAmount) {
      this.settlementAmount = settlementAmount;
   }

   public void setTotalPayment(final BigDecimal totalPayment) {
      this.totalPayment = totalPayment;
   }

   public void setTotalUnpaid(final BigDecimal totalUnpaid) {
      this.totalUnpaid = totalUnpaid;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectLedgerSeltSupportPaymentDetailDto)) {
         return false;
      }

      ProjectLedgerSeltSupportPaymentDetailDto other = (ProjectLedgerSeltSupportPaymentDetailDto)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$supplier = this.getSupplier();
      Object other$supplier = other.getSupplier();
      if (this$supplier == null ? other$supplier == null : this$supplier.equals(other$supplier)) {
         Object this$contractAmount = this.getContractAmount();
         Object other$contractAmount = other.getContractAmount();
         if (this$contractAmount == null ? other$contractAmount == null : this$contractAmount.equals(other$contractAmount)) {
            Object this$settlementAmount = this.getSettlementAmount();
            Object other$settlementAmount = other.getSettlementAmount();
            if (this$settlementAmount == null ? other$settlementAmount == null : this$settlementAmount.equals(other$settlementAmount)) {
               Object this$totalPayment = this.getTotalPayment();
               Object other$totalPayment = other.getTotalPayment();
               if (this$totalPayment == null ? other$totalPayment == null : this$totalPayment.equals(other$totalPayment)) {
                  Object this$totalUnpaid = this.getTotalUnpaid();
                  Object other$totalUnpaid = other.getTotalUnpaid();
                  return this$totalUnpaid == null ? other$totalUnpaid == null : this$totalUnpaid.equals(other$totalUnpaid);
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
      return other instanceof ProjectLedgerSeltSupportPaymentDetailDto;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $supplier = this.getSupplier();
      result = result * 59 + ($supplier == null ? 43 : $supplier.hashCode());
      Object $contractAmount = this.getContractAmount();
      result = result * 59 + ($contractAmount == null ? 43 : $contractAmount.hashCode());
      Object $settlementAmount = this.getSettlementAmount();
      result = result * 59 + ($settlementAmount == null ? 43 : $settlementAmount.hashCode());
      Object $totalPayment = this.getTotalPayment();
      result = result * 59 + ($totalPayment == null ? 43 : $totalPayment.hashCode());
      Object $totalUnpaid = this.getTotalUnpaid();
      return result * 59 + ($totalUnpaid == null ? 43 : $totalUnpaid.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectLedgerSeltSupportPaymentDetailDto(supplier="
         + this.getSupplier()
         + ", contractAmount="
         + this.getContractAmount()
         + ", settlementAmount="
         + this.getSettlementAmount()
         + ", totalPayment="
         + this.getTotalPayment()
         + ", totalUnpaid="
         + this.getTotalUnpaid()
         + ")";
   }

   public static class ProjectLedgerSeltSupportPaymentDetailDtoBuilder {
      private SupplierInfo supplier;
      private BigDecimal contractAmount;
      private BigDecimal settlementAmount;
      private BigDecimal totalPayment;
      private BigDecimal totalUnpaid;

      ProjectLedgerSeltSupportPaymentDetailDtoBuilder() {
      }

      public ProjectLedgerSeltSupportPaymentDetailDto.ProjectLedgerSeltSupportPaymentDetailDtoBuilder supplier(final SupplierInfo supplier) {
         this.supplier = supplier;
         return this;
      }

      public ProjectLedgerSeltSupportPaymentDetailDto.ProjectLedgerSeltSupportPaymentDetailDtoBuilder contractAmount(final BigDecimal contractAmount) {
         this.contractAmount = contractAmount;
         return this;
      }

      public ProjectLedgerSeltSupportPaymentDetailDto.ProjectLedgerSeltSupportPaymentDetailDtoBuilder settlementAmount(final BigDecimal settlementAmount) {
         this.settlementAmount = settlementAmount;
         return this;
      }

      public ProjectLedgerSeltSupportPaymentDetailDto.ProjectLedgerSeltSupportPaymentDetailDtoBuilder totalPayment(final BigDecimal totalPayment) {
         this.totalPayment = totalPayment;
         return this;
      }

      public ProjectLedgerSeltSupportPaymentDetailDto.ProjectLedgerSeltSupportPaymentDetailDtoBuilder totalUnpaid(final BigDecimal totalUnpaid) {
         this.totalUnpaid = totalUnpaid;
         return this;
      }

      public ProjectLedgerSeltSupportPaymentDetailDto build() {
         return new ProjectLedgerSeltSupportPaymentDetailDto(this.supplier, this.contractAmount, this.settlementAmount, this.totalPayment, this.totalUnpaid);
      }

      @Override
      public String toString() {
         return "ProjectLedgerSeltSupportPaymentDetailDto.ProjectLedgerSeltSupportPaymentDetailDtoBuilder(supplier="
            + this.supplier
            + ", contractAmount="
            + this.contractAmount
            + ", settlementAmount="
            + this.settlementAmount
            + ", totalPayment="
            + this.totalPayment
            + ", totalUnpaid="
            + this.totalUnpaid
            + ")";
      }
   }
}
