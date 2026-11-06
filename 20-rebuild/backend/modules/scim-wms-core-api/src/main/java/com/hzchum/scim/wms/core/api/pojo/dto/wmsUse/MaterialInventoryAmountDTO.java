package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import java.math.BigDecimal;

public class MaterialInventoryAmountDTO {
   private BigDecimal amount;
   private BigDecimal amountExcludingVAT;

   public static MaterialInventoryAmountDTO.MaterialInventoryAmountDTOBuilder builder() {
      return new MaterialInventoryAmountDTO.MaterialInventoryAmountDTOBuilder();
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getAmountExcludingVAT() {
      return this.amountExcludingVAT;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setAmountExcludingVAT(final BigDecimal amountExcludingVAT) {
      this.amountExcludingVAT = amountExcludingVAT;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MaterialInventoryAmountDTO)) {
         return false;
      } else {
         MaterialInventoryAmountDTO other = (MaterialInventoryAmountDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$amount = this.getAmount();
            Object other$amount = other.getAmount();
            if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
               Object this$amountExcludingVAT = this.getAmountExcludingVAT();
               Object other$amountExcludingVAT = other.getAmountExcludingVAT();
               return this$amountExcludingVAT == null ? other$amountExcludingVAT == null : this$amountExcludingVAT.equals(other$amountExcludingVAT);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MaterialInventoryAmountDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $amountExcludingVAT = this.getAmountExcludingVAT();
      return result * 59 + ($amountExcludingVAT == null ? 43 : $amountExcludingVAT.hashCode());
   }

   @Override
   public String toString() {
      return "MaterialInventoryAmountDTO(amount=" + this.getAmount() + ", amountExcludingVAT=" + this.getAmountExcludingVAT() + ")";
   }

   public MaterialInventoryAmountDTO(final BigDecimal amount, final BigDecimal amountExcludingVAT) {
      this.amount = amount;
      this.amountExcludingVAT = amountExcludingVAT;
   }

   public MaterialInventoryAmountDTO() {
   }

   public static class MaterialInventoryAmountDTOBuilder {
      private BigDecimal amount;
      private BigDecimal amountExcludingVAT;

      MaterialInventoryAmountDTOBuilder() {
      }

      public MaterialInventoryAmountDTO.MaterialInventoryAmountDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public MaterialInventoryAmountDTO.MaterialInventoryAmountDTOBuilder amountExcludingVAT(final BigDecimal amountExcludingVAT) {
         this.amountExcludingVAT = amountExcludingVAT;
         return this;
      }

      public MaterialInventoryAmountDTO build() {
         return new MaterialInventoryAmountDTO(this.amount, this.amountExcludingVAT);
      }

      @Override
      public String toString() {
         return "MaterialInventoryAmountDTO.MaterialInventoryAmountDTOBuilder(amount=" + this.amount + ", amountExcludingVAT=" + this.amountExcludingVAT + ")";
      }
   }
}
