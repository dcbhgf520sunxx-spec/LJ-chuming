package com.hzchum.scim.wms.core.api.pojo.dto.wmsReport;

import java.math.BigDecimal;

public class DetailDTO {
   private Long id;
   private BigDecimal mete;
   private BigDecimal quantity;
   private BigDecimal unitPrice;
   private BigDecimal unitPriceExcludingVAT;
   private BigDecimal amount;
   private BigDecimal amountExcludingVAT;
   private BigDecimal inputVAT;

   public static DetailDTO.DetailDTOBuilder builder() {
      return new DetailDTO.DetailDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getUnitPriceExcludingVAT() {
      return this.unitPriceExcludingVAT;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getAmountExcludingVAT() {
      return this.amountExcludingVAT;
   }

   public BigDecimal getInputVAT() {
      return this.inputVAT;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   public void setUnitPriceExcludingVAT(final BigDecimal unitPriceExcludingVAT) {
      this.unitPriceExcludingVAT = unitPriceExcludingVAT;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setAmountExcludingVAT(final BigDecimal amountExcludingVAT) {
      this.amountExcludingVAT = amountExcludingVAT;
   }

   public void setInputVAT(final BigDecimal inputVAT) {
      this.inputVAT = inputVAT;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DetailDTO)) {
         return false;
      }

      DetailDTO other = (DetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$mete = this.getMete();
         Object other$mete = other.getMete();
         if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$unitPrice = this.getUnitPrice();
               Object other$unitPrice = other.getUnitPrice();
               if (this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice)) {
                  Object this$unitPriceExcludingVAT = this.getUnitPriceExcludingVAT();
                  Object other$unitPriceExcludingVAT = other.getUnitPriceExcludingVAT();
                  if (this$unitPriceExcludingVAT == null ? other$unitPriceExcludingVAT == null : this$unitPriceExcludingVAT.equals(other$unitPriceExcludingVAT)
                     )
                   {
                     Object this$amount = this.getAmount();
                     Object other$amount = other.getAmount();
                     if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                        Object this$amountExcludingVAT = this.getAmountExcludingVAT();
                        Object other$amountExcludingVAT = other.getAmountExcludingVAT();
                        if (this$amountExcludingVAT == null ? other$amountExcludingVAT == null : this$amountExcludingVAT.equals(other$amountExcludingVAT)) {
                           Object this$inputVAT = this.getInputVAT();
                           Object other$inputVAT = other.getInputVAT();
                           return this$inputVAT == null ? other$inputVAT == null : this$inputVAT.equals(other$inputVAT);
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
      return other instanceof DetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $unitPriceExcludingVAT = this.getUnitPriceExcludingVAT();
      result = result * 59 + ($unitPriceExcludingVAT == null ? 43 : $unitPriceExcludingVAT.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $amountExcludingVAT = this.getAmountExcludingVAT();
      result = result * 59 + ($amountExcludingVAT == null ? 43 : $amountExcludingVAT.hashCode());
      Object $inputVAT = this.getInputVAT();
      return result * 59 + ($inputVAT == null ? 43 : $inputVAT.hashCode());
   }

   @Override
   public String toString() {
      return "DetailDTO(id="
         + this.getId()
         + ", mete="
         + this.getMete()
         + ", quantity="
         + this.getQuantity()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", unitPriceExcludingVAT="
         + this.getUnitPriceExcludingVAT()
         + ", amount="
         + this.getAmount()
         + ", amountExcludingVAT="
         + this.getAmountExcludingVAT()
         + ", inputVAT="
         + this.getInputVAT()
         + ")";
   }

   public DetailDTO(
      final Long id,
      final BigDecimal mete,
      final BigDecimal quantity,
      final BigDecimal unitPrice,
      final BigDecimal unitPriceExcludingVAT,
      final BigDecimal amount,
      final BigDecimal amountExcludingVAT,
      final BigDecimal inputVAT
   ) {
      this.id = id;
      this.mete = mete;
      this.quantity = quantity;
      this.unitPrice = unitPrice;
      this.unitPriceExcludingVAT = unitPriceExcludingVAT;
      this.amount = amount;
      this.amountExcludingVAT = amountExcludingVAT;
      this.inputVAT = inputVAT;
   }

   public DetailDTO() {
   }

   public static class DetailDTOBuilder {
      private Long id;
      private BigDecimal mete;
      private BigDecimal quantity;
      private BigDecimal unitPrice;
      private BigDecimal unitPriceExcludingVAT;
      private BigDecimal amount;
      private BigDecimal amountExcludingVAT;
      private BigDecimal inputVAT;

      DetailDTOBuilder() {
      }

      public DetailDTO.DetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public DetailDTO.DetailDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public DetailDTO.DetailDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public DetailDTO.DetailDTOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public DetailDTO.DetailDTOBuilder unitPriceExcludingVAT(final BigDecimal unitPriceExcludingVAT) {
         this.unitPriceExcludingVAT = unitPriceExcludingVAT;
         return this;
      }

      public DetailDTO.DetailDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public DetailDTO.DetailDTOBuilder amountExcludingVAT(final BigDecimal amountExcludingVAT) {
         this.amountExcludingVAT = amountExcludingVAT;
         return this;
      }

      public DetailDTO.DetailDTOBuilder inputVAT(final BigDecimal inputVAT) {
         this.inputVAT = inputVAT;
         return this;
      }

      public DetailDTO build() {
         return new DetailDTO(
            this.id, this.mete, this.quantity, this.unitPrice, this.unitPriceExcludingVAT, this.amount, this.amountExcludingVAT, this.inputVAT
         );
      }

      @Override
      public String toString() {
         return "DetailDTO.DetailDTOBuilder(id="
            + this.id
            + ", mete="
            + this.mete
            + ", quantity="
            + this.quantity
            + ", unitPrice="
            + this.unitPrice
            + ", unitPriceExcludingVAT="
            + this.unitPriceExcludingVAT
            + ", amount="
            + this.amount
            + ", amountExcludingVAT="
            + this.amountExcludingVAT
            + ", inputVAT="
            + this.inputVAT
            + ")";
      }
   }
}
