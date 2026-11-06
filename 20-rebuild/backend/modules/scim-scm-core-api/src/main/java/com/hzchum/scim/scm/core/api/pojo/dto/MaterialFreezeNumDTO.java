package com.hzchum.scim.scm.core.api.pojo.dto;

import java.math.BigDecimal;

public class MaterialFreezeNumDTO {
   private BigDecimal mete;
   private BigDecimal frozenMete;
   private BigDecimal quantity;
   private BigDecimal frozenQuantity;

   public static MaterialFreezeNumDTO.MaterialFreezeNumDTOBuilder builder() {
      return new MaterialFreezeNumDTO.MaterialFreezeNumDTOBuilder();
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getFrozenMete() {
      return this.frozenMete;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getFrozenQuantity() {
      return this.frozenQuantity;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setFrozenMete(final BigDecimal frozenMete) {
      this.frozenMete = frozenMete;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setFrozenQuantity(final BigDecimal frozenQuantity) {
      this.frozenQuantity = frozenQuantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MaterialFreezeNumDTO)) {
         return false;
      }

      MaterialFreezeNumDTO other = (MaterialFreezeNumDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$mete = this.getMete();
      Object other$mete = other.getMete();
      if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
         Object this$frozenMete = this.getFrozenMete();
         Object other$frozenMete = other.getFrozenMete();
         if (this$frozenMete == null ? other$frozenMete == null : this$frozenMete.equals(other$frozenMete)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$frozenQuantity = this.getFrozenQuantity();
               Object other$frozenQuantity = other.getFrozenQuantity();
               return this$frozenQuantity == null ? other$frozenQuantity == null : this$frozenQuantity.equals(other$frozenQuantity);
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
      return other instanceof MaterialFreezeNumDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $frozenMete = this.getFrozenMete();
      result = result * 59 + ($frozenMete == null ? 43 : $frozenMete.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $frozenQuantity = this.getFrozenQuantity();
      return result * 59 + ($frozenQuantity == null ? 43 : $frozenQuantity.hashCode());
   }

   @Override
   public String toString() {
      return "MaterialFreezeNumDTO(mete="
         + this.getMete()
         + ", frozenMete="
         + this.getFrozenMete()
         + ", quantity="
         + this.getQuantity()
         + ", frozenQuantity="
         + this.getFrozenQuantity()
         + ")";
   }

   public MaterialFreezeNumDTO(final BigDecimal mete, final BigDecimal frozenMete, final BigDecimal quantity, final BigDecimal frozenQuantity) {
      this.mete = mete;
      this.frozenMete = frozenMete;
      this.quantity = quantity;
      this.frozenQuantity = frozenQuantity;
   }

   public MaterialFreezeNumDTO() {
   }

   public static class MaterialFreezeNumDTOBuilder {
      private BigDecimal mete;
      private BigDecimal frozenMete;
      private BigDecimal quantity;
      private BigDecimal frozenQuantity;

      MaterialFreezeNumDTOBuilder() {
      }

      public MaterialFreezeNumDTO.MaterialFreezeNumDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public MaterialFreezeNumDTO.MaterialFreezeNumDTOBuilder frozenMete(final BigDecimal frozenMete) {
         this.frozenMete = frozenMete;
         return this;
      }

      public MaterialFreezeNumDTO.MaterialFreezeNumDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public MaterialFreezeNumDTO.MaterialFreezeNumDTOBuilder frozenQuantity(final BigDecimal frozenQuantity) {
         this.frozenQuantity = frozenQuantity;
         return this;
      }

      public MaterialFreezeNumDTO build() {
         return new MaterialFreezeNumDTO(this.mete, this.frozenMete, this.quantity, this.frozenQuantity);
      }

      @Override
      public String toString() {
         return "MaterialFreezeNumDTO.MaterialFreezeNumDTOBuilder(mete="
            + this.mete
            + ", frozenMete="
            + this.frozenMete
            + ", quantity="
            + this.quantity
            + ", frozenQuantity="
            + this.frozenQuantity
            + ")";
      }
   }
}
