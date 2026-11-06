package com.hzchum.scim.business.core.api.pojo._do;

import com.hzchum.scim.common.core.api.pojo.common.EnclosureBaseInfo;
import java.math.BigDecimal;

public class BusinessEnclosureDO extends EnclosureBaseInfo {
   private BigDecimal price;
   private BigDecimal totalPrice;

   public BigDecimal getPrice() {
      return this.price;
   }

   public BigDecimal getTotalPrice() {
      return this.totalPrice;
   }

   public void setPrice(final BigDecimal price) {
      this.price = price;
   }

   public void setTotalPrice(final BigDecimal totalPrice) {
      this.totalPrice = totalPrice;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof BusinessEnclosureDO)) {
         return false;
      } else {
         BusinessEnclosureDO other = (BusinessEnclosureDO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$price = this.getPrice();
            Object other$price = other.getPrice();
            if (this$price == null ? other$price == null : this$price.equals(other$price)) {
               Object this$totalPrice = this.getTotalPrice();
               Object other$totalPrice = other.getTotalPrice();
               return this$totalPrice == null ? other$totalPrice == null : this$totalPrice.equals(other$totalPrice);
            } else {
               return false;
            }
         }
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof BusinessEnclosureDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $totalPrice = this.getTotalPrice();
      return result * 59 + ($totalPrice == null ? 43 : $totalPrice.hashCode());
   }

   @Override
   public String toString() {
      return "BusinessEnclosureDO(price=" + this.getPrice() + ", totalPrice=" + this.getTotalPrice() + ")";
   }
}
