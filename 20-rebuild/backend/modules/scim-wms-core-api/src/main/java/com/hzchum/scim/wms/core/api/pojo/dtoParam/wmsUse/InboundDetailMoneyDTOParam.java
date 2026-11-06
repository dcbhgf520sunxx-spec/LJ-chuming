package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.io.Serializable;
import java.math.BigDecimal;

public class InboundDetailMoneyDTOParam implements Serializable {
   private Long id;
   private BigDecimal unitPrice;
   private BigDecimal amount;

   public Long getId() {
      return this.id;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InboundDetailMoneyDTOParam)) {
         return false;
      }

      InboundDetailMoneyDTOParam other = (InboundDetailMoneyDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$unitPrice = this.getUnitPrice();
         Object other$unitPrice = other.getUnitPrice();
         if (this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice)) {
            Object this$amount = this.getAmount();
            Object other$amount = other.getAmount();
            return this$amount == null ? other$amount == null : this$amount.equals(other$amount);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof InboundDetailMoneyDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $amount = this.getAmount();
      return result * 59 + ($amount == null ? 43 : $amount.hashCode());
   }

   @Override
   public String toString() {
      return "InboundDetailMoneyDTOParam(id=" + this.getId() + ", unitPrice=" + this.getUnitPrice() + ", amount=" + this.getAmount() + ")";
   }
}
