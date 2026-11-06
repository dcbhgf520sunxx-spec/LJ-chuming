package com.hzchum.scim.scm.core.api.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("采购订单月度")
public class PurchaseOrderGroupMonthDTO {
   @ApiModelProperty(name = "dateTime", value = "时间", notes = "时间")
   @JsonInclude(Include.NON_NULL)
   private String dateTime;
   @ApiModelProperty(name = "numbers", value = "订单数量", notes = "订单数量")
   private Integer numbers;
   @ApiModelProperty(name = "amount", value = "订单金额", notes = "订单金额")
   private BigDecimal amount;
   @ApiModelProperty(name = "supplierName", value = "供应商", notes = "供应商")
   @JsonInclude(Include.NON_NULL)
   private String supplierName;
   @ApiModelProperty(name = "supplierName", value = "供应商", notes = "供应商")
   @JsonInclude(Include.NON_NULL)
   private String shortName;
   @ApiModelProperty(name = "supplierId", value = "供应商", notes = "供应商")
   @JsonInclude(Include.NON_NULL)
   private Long supplierId;

   public static PurchaseOrderGroupMonthDTO.PurchaseOrderGroupMonthDTOBuilder builder() {
      return new PurchaseOrderGroupMonthDTO.PurchaseOrderGroupMonthDTOBuilder();
   }

   public String getDateTime() {
      return this.dateTime;
   }

   public Integer getNumbers() {
      return this.numbers;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public String getShortName() {
      return this.shortName;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public void setDateTime(final String dateTime) {
      this.dateTime = dateTime;
   }

   public void setNumbers(final Integer numbers) {
      this.numbers = numbers;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PurchaseOrderGroupMonthDTO)) {
         return false;
      }

      PurchaseOrderGroupMonthDTO other = (PurchaseOrderGroupMonthDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$numbers = this.getNumbers();
      Object other$numbers = other.getNumbers();
      if (this$numbers == null ? other$numbers == null : this$numbers.equals(other$numbers)) {
         Object this$supplierId = this.getSupplierId();
         Object other$supplierId = other.getSupplierId();
         if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
            Object this$dateTime = this.getDateTime();
            Object other$dateTime = other.getDateTime();
            if (this$dateTime == null ? other$dateTime == null : this$dateTime.equals(other$dateTime)) {
               Object this$amount = this.getAmount();
               Object other$amount = other.getAmount();
               if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                  Object this$supplierName = this.getSupplierName();
                  Object other$supplierName = other.getSupplierName();
                  if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                     Object this$shortName = this.getShortName();
                     Object other$shortName = other.getShortName();
                     return this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName);
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
      return other instanceof PurchaseOrderGroupMonthDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $numbers = this.getNumbers();
      result = result * 59 + ($numbers == null ? 43 : $numbers.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $dateTime = this.getDateTime();
      result = result * 59 + ($dateTime == null ? 43 : $dateTime.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $shortName = this.getShortName();
      return result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
   }

   @Override
   public String toString() {
      return "PurchaseOrderGroupMonthDTO(dateTime="
         + this.getDateTime()
         + ", numbers="
         + this.getNumbers()
         + ", amount="
         + this.getAmount()
         + ", supplierName="
         + this.getSupplierName()
         + ", shortName="
         + this.getShortName()
         + ", supplierId="
         + this.getSupplierId()
         + ")";
   }

   public PurchaseOrderGroupMonthDTO(
      final String dateTime, final Integer numbers, final BigDecimal amount, final String supplierName, final String shortName, final Long supplierId
   ) {
      this.dateTime = dateTime;
      this.numbers = numbers;
      this.amount = amount;
      this.supplierName = supplierName;
      this.shortName = shortName;
      this.supplierId = supplierId;
   }

   public PurchaseOrderGroupMonthDTO() {
   }

   public static class PurchaseOrderGroupMonthDTOBuilder {
      private String dateTime;
      private Integer numbers;
      private BigDecimal amount;
      private String supplierName;
      private String shortName;
      private Long supplierId;

      PurchaseOrderGroupMonthDTOBuilder() {
      }

      public PurchaseOrderGroupMonthDTO.PurchaseOrderGroupMonthDTOBuilder dateTime(final String dateTime) {
         this.dateTime = dateTime;
         return this;
      }

      public PurchaseOrderGroupMonthDTO.PurchaseOrderGroupMonthDTOBuilder numbers(final Integer numbers) {
         this.numbers = numbers;
         return this;
      }

      public PurchaseOrderGroupMonthDTO.PurchaseOrderGroupMonthDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public PurchaseOrderGroupMonthDTO.PurchaseOrderGroupMonthDTOBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public PurchaseOrderGroupMonthDTO.PurchaseOrderGroupMonthDTOBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      public PurchaseOrderGroupMonthDTO.PurchaseOrderGroupMonthDTOBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public PurchaseOrderGroupMonthDTO build() {
         return new PurchaseOrderGroupMonthDTO(this.dateTime, this.numbers, this.amount, this.supplierName, this.shortName, this.supplierId);
      }

      @Override
      public String toString() {
         return "PurchaseOrderGroupMonthDTO.PurchaseOrderGroupMonthDTOBuilder(dateTime="
            + this.dateTime
            + ", numbers="
            + this.numbers
            + ", amount="
            + this.amount
            + ", supplierName="
            + this.supplierName
            + ", shortName="
            + this.shortName
            + ", supplierId="
            + this.supplierId
            + ")";
      }
   }
}
