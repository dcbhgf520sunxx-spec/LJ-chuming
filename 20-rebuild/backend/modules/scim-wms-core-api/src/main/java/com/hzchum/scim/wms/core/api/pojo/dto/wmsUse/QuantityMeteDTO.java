package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class QuantityMeteDTO {
   @ApiModelProperty(name = "quantity", value = "数量")
   private BigDecimal quantity;
   @ApiModelProperty(name = "mete", value = "核算量")
   private BigDecimal mete;

   public static QuantityMeteDTO.QuantityMeteDTOBuilder builder() {
      return new QuantityMeteDTO.QuantityMeteDTOBuilder();
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof QuantityMeteDTO)) {
         return false;
      } else {
         QuantityMeteDTO other = (QuantityMeteDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$mete = this.getMete();
               Object other$mete = other.getMete();
               return this$mete == null ? other$mete == null : this$mete.equals(other$mete);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof QuantityMeteDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $mete = this.getMete();
      return result * 59 + ($mete == null ? 43 : $mete.hashCode());
   }

   @Override
   public String toString() {
      return "QuantityMeteDTO(quantity=" + this.getQuantity() + ", mete=" + this.getMete() + ")";
   }

   public QuantityMeteDTO(final BigDecimal quantity, final BigDecimal mete) {
      this.quantity = quantity;
      this.mete = mete;
   }

   public QuantityMeteDTO() {
   }

   public static class QuantityMeteDTOBuilder {
      private BigDecimal quantity;
      private BigDecimal mete;

      QuantityMeteDTOBuilder() {
      }

      public QuantityMeteDTO.QuantityMeteDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public QuantityMeteDTO.QuantityMeteDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public QuantityMeteDTO build() {
         return new QuantityMeteDTO(this.quantity, this.mete);
      }

      @Override
      public String toString() {
         return "QuantityMeteDTO.QuantityMeteDTOBuilder(quantity=" + this.quantity + ", mete=" + this.mete + ")";
      }
   }
}
