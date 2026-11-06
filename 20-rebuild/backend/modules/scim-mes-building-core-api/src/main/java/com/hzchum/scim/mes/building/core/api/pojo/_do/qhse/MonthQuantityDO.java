package com.hzchum.scim.mes.building.core.api.pojo._do.qhse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("月份数")
public class MonthQuantityDO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("月份")
   private String month;
   @ApiModelProperty("数量")
   private Integer quantity;

   public String getMonth() {
      return this.month;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public void setMonth(final String month) {
      this.month = month;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MonthQuantityDO)) {
         return false;
      } else {
         MonthQuantityDO other = (MonthQuantityDO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$month = this.getMonth();
               Object other$month = other.getMonth();
               return this$month == null ? other$month == null : this$month.equals(other$month);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MonthQuantityDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $month = this.getMonth();
      return result * 59 + ($month == null ? 43 : $month.hashCode());
   }

   @Override
   public String toString() {
      return "MonthQuantityDO(month=" + this.getMonth() + ", quantity=" + this.getQuantity() + ")";
   }
}
