package com.hzchum.scim.business.core.api.pojo.dto;

import java.math.BigDecimal;

public class SummaryDTO {
   private Integer quantity;
   private BigDecimal mete;
   private BigDecimal price;

   SummaryDTO(final Integer quantity, final BigDecimal mete, final BigDecimal price) {
      this.quantity = quantity;
      this.mete = mete;
      this.price = price;
   }

   public static SummaryDTO.SummaryDTOBuilder builder() {
      return new SummaryDTO.SummaryDTOBuilder();
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setPrice(final BigDecimal price) {
      this.price = price;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SummaryDTO)) {
         return false;
      }

      SummaryDTO other = (SummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$mete = this.getMete();
         Object other$mete = other.getMete();
         if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
            Object this$price = this.getPrice();
            Object other$price = other.getPrice();
            return this$price == null ? other$price == null : this$price.equals(other$price);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   @Override
   public String toString() {
      return "SummaryDTO(quantity=" + this.getQuantity() + ", mete=" + this.getMete() + ", price=" + this.getPrice() + ")";
   }

   public static class SummaryDTOBuilder {
      private Integer quantity;
      private BigDecimal mete;
      private BigDecimal price;

      SummaryDTOBuilder() {
      }

      public SummaryDTO.SummaryDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public SummaryDTO.SummaryDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public SummaryDTO.SummaryDTOBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public SummaryDTO build() {
         return new SummaryDTO(this.quantity, this.mete, this.price);
      }

      @Override
      public String toString() {
         return "SummaryDTO.SummaryDTOBuilder(quantity=" + this.quantity + ", mete=" + this.mete + ", price=" + this.price + ")";
      }
   }
}
