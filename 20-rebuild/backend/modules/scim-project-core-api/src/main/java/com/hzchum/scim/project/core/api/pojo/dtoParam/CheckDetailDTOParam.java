package com.hzchum.scim.project.core.api.pojo.dtoParam;

import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

public class CheckDetailDTOParam {
   @NotNull(message = "id不能为空")
   private Long id;
   private BigDecimal unitPrice;

   public Long getId() {
      return this.id;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof CheckDetailDTOParam)) {
         return false;
      } else {
         CheckDetailDTOParam other = (CheckDetailDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$unitPrice = this.getUnitPrice();
               Object other$unitPrice = other.getUnitPrice();
               return this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CheckDetailDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $unitPrice = this.getUnitPrice();
      return result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
   }

   @Override
   public String toString() {
      return "CheckDetailDTOParam(id=" + this.getId() + ", unitPrice=" + this.getUnitPrice() + ")";
   }
}
