package com.hzchum.scim.business.core.api.pojo._do;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class AuxiliaryMaterialSummaryDO {
   @ApiModelProperty("总量")
   private BigDecimal totalMete;
   @ApiModelProperty("总价")
   private BigDecimal totalPrice;

   public BigDecimal getTotalMete() {
      return this.totalMete;
   }

   public BigDecimal getTotalPrice() {
      return this.totalPrice;
   }

   public void setTotalMete(final BigDecimal totalMete) {
      this.totalMete = totalMete;
   }

   public void setTotalPrice(final BigDecimal totalPrice) {
      this.totalPrice = totalPrice;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof AuxiliaryMaterialSummaryDO)) {
         return false;
      } else {
         AuxiliaryMaterialSummaryDO other = (AuxiliaryMaterialSummaryDO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$totalMete = this.getTotalMete();
            Object other$totalMete = other.getTotalMete();
            if (this$totalMete == null ? other$totalMete == null : this$totalMete.equals(other$totalMete)) {
               Object this$totalPrice = this.getTotalPrice();
               Object other$totalPrice = other.getTotalPrice();
               return this$totalPrice == null ? other$totalPrice == null : this$totalPrice.equals(other$totalPrice);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AuxiliaryMaterialSummaryDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $totalMete = this.getTotalMete();
      result = result * 59 + ($totalMete == null ? 43 : $totalMete.hashCode());
      Object $totalPrice = this.getTotalPrice();
      return result * 59 + ($totalPrice == null ? 43 : $totalPrice.hashCode());
   }

   @Override
   public String toString() {
      return "AuxiliaryMaterialSummaryDO(totalMete=" + this.getTotalMete() + ", totalPrice=" + this.getTotalPrice() + ")";
   }
}
