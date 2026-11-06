package com.hzchum.scim.wms.core.api.pojo.dto.wmsReport;

import java.math.BigDecimal;

public class RealTimeInventoryAmountDTO {
   private BigDecimal amount;
   private BigDecimal ratio;

   public static RealTimeInventoryAmountDTO.RealTimeInventoryAmountDTOBuilder builder() {
      return new RealTimeInventoryAmountDTO.RealTimeInventoryAmountDTOBuilder();
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getRatio() {
      return this.ratio;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setRatio(final BigDecimal ratio) {
      this.ratio = ratio;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof RealTimeInventoryAmountDTO)) {
         return false;
      } else {
         RealTimeInventoryAmountDTO other = (RealTimeInventoryAmountDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$amount = this.getAmount();
            Object other$amount = other.getAmount();
            if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
               Object this$ratio = this.getRatio();
               Object other$ratio = other.getRatio();
               return this$ratio == null ? other$ratio == null : this$ratio.equals(other$ratio);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof RealTimeInventoryAmountDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $ratio = this.getRatio();
      return result * 59 + ($ratio == null ? 43 : $ratio.hashCode());
   }

   @Override
   public String toString() {
      return "RealTimeInventoryAmountDTO(amount=" + this.getAmount() + ", ratio=" + this.getRatio() + ")";
   }

   public RealTimeInventoryAmountDTO(final BigDecimal amount, final BigDecimal ratio) {
      this.amount = amount;
      this.ratio = ratio;
   }

   public RealTimeInventoryAmountDTO() {
   }

   public static class RealTimeInventoryAmountDTOBuilder {
      private BigDecimal amount;
      private BigDecimal ratio;

      RealTimeInventoryAmountDTOBuilder() {
      }

      public RealTimeInventoryAmountDTO.RealTimeInventoryAmountDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public RealTimeInventoryAmountDTO.RealTimeInventoryAmountDTOBuilder ratio(final BigDecimal ratio) {
         this.ratio = ratio;
         return this;
      }

      public RealTimeInventoryAmountDTO build() {
         return new RealTimeInventoryAmountDTO(this.amount, this.ratio);
      }

      @Override
      public String toString() {
         return "RealTimeInventoryAmountDTO.RealTimeInventoryAmountDTOBuilder(amount=" + this.amount + ", ratio=" + this.ratio + ")";
      }
   }
}
