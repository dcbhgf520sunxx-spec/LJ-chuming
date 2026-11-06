package com.hzchum.scim.wms.core.api.pojo.dto.common;

import java.math.BigDecimal;

public class PriceDTO {
   private BigDecimal amount;
   private BigDecimal amountExcludingVat;
   private BigDecimal amountNoFreight;
   private BigDecimal amountExcludingVatNoFreight;
   private BigDecimal oneMete;

   public static PriceDTO.PriceDTOBuilder builder() {
      return new PriceDTO.PriceDTOBuilder();
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getAmountExcludingVat() {
      return this.amountExcludingVat;
   }

   public BigDecimal getAmountNoFreight() {
      return this.amountNoFreight;
   }

   public BigDecimal getAmountExcludingVatNoFreight() {
      return this.amountExcludingVatNoFreight;
   }

   public BigDecimal getOneMete() {
      return this.oneMete;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
   }

   public void setAmountNoFreight(final BigDecimal amountNoFreight) {
      this.amountNoFreight = amountNoFreight;
   }

   public void setAmountExcludingVatNoFreight(final BigDecimal amountExcludingVatNoFreight) {
      this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
   }

   public void setOneMete(final BigDecimal oneMete) {
      this.oneMete = oneMete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PriceDTO)) {
         return false;
      }

      PriceDTO other = (PriceDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$amount = this.getAmount();
      Object other$amount = other.getAmount();
      if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
         Object this$amountExcludingVat = this.getAmountExcludingVat();
         Object other$amountExcludingVat = other.getAmountExcludingVat();
         if (this$amountExcludingVat == null ? other$amountExcludingVat == null : this$amountExcludingVat.equals(other$amountExcludingVat)) {
            Object this$amountNoFreight = this.getAmountNoFreight();
            Object other$amountNoFreight = other.getAmountNoFreight();
            if (this$amountNoFreight == null ? other$amountNoFreight == null : this$amountNoFreight.equals(other$amountNoFreight)) {
               Object this$amountExcludingVatNoFreight = this.getAmountExcludingVatNoFreight();
               Object other$amountExcludingVatNoFreight = other.getAmountExcludingVatNoFreight();
               if (this$amountExcludingVatNoFreight == null
                  ? other$amountExcludingVatNoFreight == null
                  : this$amountExcludingVatNoFreight.equals(other$amountExcludingVatNoFreight)) {
                  Object this$oneMete = this.getOneMete();
                  Object other$oneMete = other.getOneMete();
                  return this$oneMete == null ? other$oneMete == null : this$oneMete.equals(other$oneMete);
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
      return other instanceof PriceDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $amountExcludingVat = this.getAmountExcludingVat();
      result = result * 59 + ($amountExcludingVat == null ? 43 : $amountExcludingVat.hashCode());
      Object $amountNoFreight = this.getAmountNoFreight();
      result = result * 59 + ($amountNoFreight == null ? 43 : $amountNoFreight.hashCode());
      Object $amountExcludingVatNoFreight = this.getAmountExcludingVatNoFreight();
      result = result * 59 + ($amountExcludingVatNoFreight == null ? 43 : $amountExcludingVatNoFreight.hashCode());
      Object $oneMete = this.getOneMete();
      return result * 59 + ($oneMete == null ? 43 : $oneMete.hashCode());
   }

   @Override
   public String toString() {
      return "PriceDTO(amount="
         + this.getAmount()
         + ", amountExcludingVat="
         + this.getAmountExcludingVat()
         + ", amountNoFreight="
         + this.getAmountNoFreight()
         + ", amountExcludingVatNoFreight="
         + this.getAmountExcludingVatNoFreight()
         + ", oneMete="
         + this.getOneMete()
         + ")";
   }

   public PriceDTO(
      final BigDecimal amount,
      final BigDecimal amountExcludingVat,
      final BigDecimal amountNoFreight,
      final BigDecimal amountExcludingVatNoFreight,
      final BigDecimal oneMete
   ) {
      this.amount = amount;
      this.amountExcludingVat = amountExcludingVat;
      this.amountNoFreight = amountNoFreight;
      this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
      this.oneMete = oneMete;
   }

   public PriceDTO() {
   }

   public static class PriceDTOBuilder {
      private BigDecimal amount;
      private BigDecimal amountExcludingVat;
      private BigDecimal amountNoFreight;
      private BigDecimal amountExcludingVatNoFreight;
      private BigDecimal oneMete;

      PriceDTOBuilder() {
      }

      public PriceDTO.PriceDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public PriceDTO.PriceDTOBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      public PriceDTO.PriceDTOBuilder amountNoFreight(final BigDecimal amountNoFreight) {
         this.amountNoFreight = amountNoFreight;
         return this;
      }

      public PriceDTO.PriceDTOBuilder amountExcludingVatNoFreight(final BigDecimal amountExcludingVatNoFreight) {
         this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
         return this;
      }

      public PriceDTO.PriceDTOBuilder oneMete(final BigDecimal oneMete) {
         this.oneMete = oneMete;
         return this;
      }

      public PriceDTO build() {
         return new PriceDTO(this.amount, this.amountExcludingVat, this.amountNoFreight, this.amountExcludingVatNoFreight, this.oneMete);
      }

      @Override
      public String toString() {
         return "PriceDTO.PriceDTOBuilder(amount="
            + this.amount
            + ", amountExcludingVat="
            + this.amountExcludingVat
            + ", amountNoFreight="
            + this.amountNoFreight
            + ", amountExcludingVatNoFreight="
            + this.amountExcludingVatNoFreight
            + ", oneMete="
            + this.oneMete
            + ")";
      }
   }
}
