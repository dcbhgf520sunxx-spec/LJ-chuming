package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.math.BigDecimal;

public class BatchBorrowReturnDetailDTOParam {
   private Long id;
   private BigDecimal quantity;
   private BigDecimal mete;
   private BigDecimal amount;
   private BigDecimal unitPrice;
   private BigDecimal taxRate;

   public static BatchBorrowReturnDetailDTOParam.BatchBorrowReturnDetailDTOParamBuilder builder() {
      return new BatchBorrowReturnDetailDTOParam.BatchBorrowReturnDetailDTOParamBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BatchBorrowReturnDetailDTOParam)) {
         return false;
      }

      BatchBorrowReturnDetailDTOParam other = (BatchBorrowReturnDetailDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$mete = this.getMete();
            Object other$mete = other.getMete();
            if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
               Object this$amount = this.getAmount();
               Object other$amount = other.getAmount();
               if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                  Object this$unitPrice = this.getUnitPrice();
                  Object other$unitPrice = other.getUnitPrice();
                  if (this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice)) {
                     Object this$taxRate = this.getTaxRate();
                     Object other$taxRate = other.getTaxRate();
                     return this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate);
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
      return other instanceof BatchBorrowReturnDetailDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $taxRate = this.getTaxRate();
      return result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
   }

   @Override
   public String toString() {
      return "BatchBorrowReturnDetailDTOParam(id="
         + this.getId()
         + ", quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", amount="
         + this.getAmount()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", taxRate="
         + this.getTaxRate()
         + ")";
   }

   public BatchBorrowReturnDetailDTOParam(
      final Long id, final BigDecimal quantity, final BigDecimal mete, final BigDecimal amount, final BigDecimal unitPrice, final BigDecimal taxRate
   ) {
      this.id = id;
      this.quantity = quantity;
      this.mete = mete;
      this.amount = amount;
      this.unitPrice = unitPrice;
      this.taxRate = taxRate;
   }

   public BatchBorrowReturnDetailDTOParam() {
   }

   public static class BatchBorrowReturnDetailDTOParamBuilder {
      private Long id;
      private BigDecimal quantity;
      private BigDecimal mete;
      private BigDecimal amount;
      private BigDecimal unitPrice;
      private BigDecimal taxRate;

      BatchBorrowReturnDetailDTOParamBuilder() {
      }

      public BatchBorrowReturnDetailDTOParam.BatchBorrowReturnDetailDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public BatchBorrowReturnDetailDTOParam.BatchBorrowReturnDetailDTOParamBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public BatchBorrowReturnDetailDTOParam.BatchBorrowReturnDetailDTOParamBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public BatchBorrowReturnDetailDTOParam.BatchBorrowReturnDetailDTOParamBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public BatchBorrowReturnDetailDTOParam.BatchBorrowReturnDetailDTOParamBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public BatchBorrowReturnDetailDTOParam.BatchBorrowReturnDetailDTOParamBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public BatchBorrowReturnDetailDTOParam build() {
         return new BatchBorrowReturnDetailDTOParam(this.id, this.quantity, this.mete, this.amount, this.unitPrice, this.taxRate);
      }

      @Override
      public String toString() {
         return "BatchBorrowReturnDetailDTOParam.BatchBorrowReturnDetailDTOParamBuilder(id="
            + this.id
            + ", quantity="
            + this.quantity
            + ", mete="
            + this.mete
            + ", amount="
            + this.amount
            + ", unitPrice="
            + this.unitPrice
            + ", taxRate="
            + this.taxRate
            + ")";
      }
   }
}
