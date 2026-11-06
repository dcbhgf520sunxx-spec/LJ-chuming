package com.hzchum.scim.common.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import java.math.BigDecimal;

@ApiModel(value = "TwoQuantityDTO", description = "Mapper返回两数")
public class TwoQuantityDTO {
   private BigDecimal oneQuantity;
   private BigDecimal twoQuantity;

   public BigDecimal getOneQuantity() {
      return this.oneQuantity;
   }

   public BigDecimal getTwoQuantity() {
      return this.twoQuantity;
   }

   public void setOneQuantity(final BigDecimal oneQuantity) {
      this.oneQuantity = oneQuantity;
   }

   public void setTwoQuantity(final BigDecimal twoQuantity) {
      this.twoQuantity = twoQuantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof TwoQuantityDTO)) {
         return false;
      } else {
         TwoQuantityDTO other = (TwoQuantityDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$oneQuantity = this.getOneQuantity();
            Object other$oneQuantity = other.getOneQuantity();
            if (this$oneQuantity == null ? other$oneQuantity == null : this$oneQuantity.equals(other$oneQuantity)) {
               Object this$twoQuantity = this.getTwoQuantity();
               Object other$twoQuantity = other.getTwoQuantity();
               return this$twoQuantity == null ? other$twoQuantity == null : this$twoQuantity.equals(other$twoQuantity);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TwoQuantityDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $oneQuantity = this.getOneQuantity();
      result = result * 59 + ($oneQuantity == null ? 43 : $oneQuantity.hashCode());
      Object $twoQuantity = this.getTwoQuantity();
      return result * 59 + ($twoQuantity == null ? 43 : $twoQuantity.hashCode());
   }

   @Override
   public String toString() {
      return "TwoQuantityDTO(oneQuantity=" + this.getOneQuantity() + ", twoQuantity=" + this.getTwoQuantity() + ")";
   }
}
