package com.hzchum.scim.contract.core.api.pojo.dto.finance;

import com.hzchum.scim.common.core.api.pojo.common.SupplierInfo;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class InjectionExpendituresDetailDTO {
   @ApiModelProperty("日期")
   private LocalDateTime date;
   @ApiModelProperty("供应商")
   private SupplierInfo supplier;
   @ApiModelProperty("采购合同号")
   private String supplierNumber;
   @ApiModelProperty("凭证号")
   private String voucherNumber;
   @ApiModelProperty("审批编号")
   private String approvalNumber;
   @ApiModelProperty("金额")
   private BigDecimal amount;
   @ApiModelProperty("签订主体支付金额")
   private BigDecimal signBodyPayAmount;
   @ApiModelProperty("项目经理支出金额")
   private BigDecimal projectManagerPayAmount;

   public static InjectionExpendituresDetailDTO.InjectionExpendituresDetailDTOBuilder builder() {
      return new InjectionExpendituresDetailDTO.InjectionExpendituresDetailDTOBuilder();
   }

   public LocalDateTime getDate() {
      return this.date;
   }

   public SupplierInfo getSupplier() {
      return this.supplier;
   }

   public String getSupplierNumber() {
      return this.supplierNumber;
   }

   public String getVoucherNumber() {
      return this.voucherNumber;
   }

   public String getApprovalNumber() {
      return this.approvalNumber;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getSignBodyPayAmount() {
      return this.signBodyPayAmount;
   }

   public BigDecimal getProjectManagerPayAmount() {
      return this.projectManagerPayAmount;
   }

   public void setDate(final LocalDateTime date) {
      this.date = date;
   }

   public void setSupplier(final SupplierInfo supplier) {
      this.supplier = supplier;
   }

   public void setSupplierNumber(final String supplierNumber) {
      this.supplierNumber = supplierNumber;
   }

   public void setVoucherNumber(final String voucherNumber) {
      this.voucherNumber = voucherNumber;
   }

   public void setApprovalNumber(final String approvalNumber) {
      this.approvalNumber = approvalNumber;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setSignBodyPayAmount(final BigDecimal signBodyPayAmount) {
      this.signBodyPayAmount = signBodyPayAmount;
   }

   public void setProjectManagerPayAmount(final BigDecimal projectManagerPayAmount) {
      this.projectManagerPayAmount = projectManagerPayAmount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InjectionExpendituresDetailDTO)) {
         return false;
      }

      InjectionExpendituresDetailDTO other = (InjectionExpendituresDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$date = this.getDate();
      Object other$date = other.getDate();
      if (this$date == null ? other$date == null : this$date.equals(other$date)) {
         Object this$supplier = this.getSupplier();
         Object other$supplier = other.getSupplier();
         if (this$supplier == null ? other$supplier == null : this$supplier.equals(other$supplier)) {
            Object this$supplierNumber = this.getSupplierNumber();
            Object other$supplierNumber = other.getSupplierNumber();
            if (this$supplierNumber == null ? other$supplierNumber == null : this$supplierNumber.equals(other$supplierNumber)) {
               Object this$voucherNumber = this.getVoucherNumber();
               Object other$voucherNumber = other.getVoucherNumber();
               if (this$voucherNumber == null ? other$voucherNumber == null : this$voucherNumber.equals(other$voucherNumber)) {
                  Object this$approvalNumber = this.getApprovalNumber();
                  Object other$approvalNumber = other.getApprovalNumber();
                  if (this$approvalNumber == null ? other$approvalNumber == null : this$approvalNumber.equals(other$approvalNumber)) {
                     Object this$amount = this.getAmount();
                     Object other$amount = other.getAmount();
                     if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                        Object this$signBodyPayAmount = this.getSignBodyPayAmount();
                        Object other$signBodyPayAmount = other.getSignBodyPayAmount();
                        if (this$signBodyPayAmount == null ? other$signBodyPayAmount == null : this$signBodyPayAmount.equals(other$signBodyPayAmount)) {
                           Object this$projectManagerPayAmount = this.getProjectManagerPayAmount();
                           Object other$projectManagerPayAmount = other.getProjectManagerPayAmount();
                           return this$projectManagerPayAmount == null
                              ? other$projectManagerPayAmount == null
                              : this$projectManagerPayAmount.equals(other$projectManagerPayAmount);
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
      return other instanceof InjectionExpendituresDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $supplier = this.getSupplier();
      result = result * 59 + ($supplier == null ? 43 : $supplier.hashCode());
      Object $supplierNumber = this.getSupplierNumber();
      result = result * 59 + ($supplierNumber == null ? 43 : $supplierNumber.hashCode());
      Object $voucherNumber = this.getVoucherNumber();
      result = result * 59 + ($voucherNumber == null ? 43 : $voucherNumber.hashCode());
      Object $approvalNumber = this.getApprovalNumber();
      result = result * 59 + ($approvalNumber == null ? 43 : $approvalNumber.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $signBodyPayAmount = this.getSignBodyPayAmount();
      result = result * 59 + ($signBodyPayAmount == null ? 43 : $signBodyPayAmount.hashCode());
      Object $projectManagerPayAmount = this.getProjectManagerPayAmount();
      return result * 59 + ($projectManagerPayAmount == null ? 43 : $projectManagerPayAmount.hashCode());
   }

   @Override
   public String toString() {
      return "InjectionExpendituresDetailDTO(date="
         + this.getDate()
         + ", supplier="
         + this.getSupplier()
         + ", supplierNumber="
         + this.getSupplierNumber()
         + ", voucherNumber="
         + this.getVoucherNumber()
         + ", approvalNumber="
         + this.getApprovalNumber()
         + ", amount="
         + this.getAmount()
         + ", signBodyPayAmount="
         + this.getSignBodyPayAmount()
         + ", projectManagerPayAmount="
         + this.getProjectManagerPayAmount()
         + ")";
   }

   public InjectionExpendituresDetailDTO(
      final LocalDateTime date,
      final SupplierInfo supplier,
      final String supplierNumber,
      final String voucherNumber,
      final String approvalNumber,
      final BigDecimal amount,
      final BigDecimal signBodyPayAmount,
      final BigDecimal projectManagerPayAmount
   ) {
      this.date = date;
      this.supplier = supplier;
      this.supplierNumber = supplierNumber;
      this.voucherNumber = voucherNumber;
      this.approvalNumber = approvalNumber;
      this.amount = amount;
      this.signBodyPayAmount = signBodyPayAmount;
      this.projectManagerPayAmount = projectManagerPayAmount;
   }

   public InjectionExpendituresDetailDTO() {
   }

   public static class InjectionExpendituresDetailDTOBuilder {
      private LocalDateTime date;
      private SupplierInfo supplier;
      private String supplierNumber;
      private String voucherNumber;
      private String approvalNumber;
      private BigDecimal amount;
      private BigDecimal signBodyPayAmount;
      private BigDecimal projectManagerPayAmount;

      InjectionExpendituresDetailDTOBuilder() {
      }

      public InjectionExpendituresDetailDTO.InjectionExpendituresDetailDTOBuilder date(final LocalDateTime date) {
         this.date = date;
         return this;
      }

      public InjectionExpendituresDetailDTO.InjectionExpendituresDetailDTOBuilder supplier(final SupplierInfo supplier) {
         this.supplier = supplier;
         return this;
      }

      public InjectionExpendituresDetailDTO.InjectionExpendituresDetailDTOBuilder supplierNumber(final String supplierNumber) {
         this.supplierNumber = supplierNumber;
         return this;
      }

      public InjectionExpendituresDetailDTO.InjectionExpendituresDetailDTOBuilder voucherNumber(final String voucherNumber) {
         this.voucherNumber = voucherNumber;
         return this;
      }

      public InjectionExpendituresDetailDTO.InjectionExpendituresDetailDTOBuilder approvalNumber(final String approvalNumber) {
         this.approvalNumber = approvalNumber;
         return this;
      }

      public InjectionExpendituresDetailDTO.InjectionExpendituresDetailDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public InjectionExpendituresDetailDTO.InjectionExpendituresDetailDTOBuilder signBodyPayAmount(final BigDecimal signBodyPayAmount) {
         this.signBodyPayAmount = signBodyPayAmount;
         return this;
      }

      public InjectionExpendituresDetailDTO.InjectionExpendituresDetailDTOBuilder projectManagerPayAmount(final BigDecimal projectManagerPayAmount) {
         this.projectManagerPayAmount = projectManagerPayAmount;
         return this;
      }

      public InjectionExpendituresDetailDTO build() {
         return new InjectionExpendituresDetailDTO(
            this.date,
            this.supplier,
            this.supplierNumber,
            this.voucherNumber,
            this.approvalNumber,
            this.amount,
            this.signBodyPayAmount,
            this.projectManagerPayAmount
         );
      }

      @Override
      public String toString() {
         return "InjectionExpendituresDetailDTO.InjectionExpendituresDetailDTOBuilder(date="
            + this.date
            + ", supplier="
            + this.supplier
            + ", supplierNumber="
            + this.supplierNumber
            + ", voucherNumber="
            + this.voucherNumber
            + ", approvalNumber="
            + this.approvalNumber
            + ", amount="
            + this.amount
            + ", signBodyPayAmount="
            + this.signBodyPayAmount
            + ", projectManagerPayAmount="
            + this.projectManagerPayAmount
            + ")";
      }
   }
}
