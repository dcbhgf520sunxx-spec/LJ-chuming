package com.hzchum.scim.mes.enclosure.core.api.pojo._do.cargoList;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "发运数量日期分组")
public class ShipQuantityGroupByDateDO {
   @ApiModelProperty(notes = "月份")
   private String date;
   @ApiModelProperty(notes = "数量")
   private Integer quantity;

   public String getDate() {
      return this.date;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public void setDate(final String date) {
      this.date = date;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ShipQuantityGroupByDateDO)) {
         return false;
      } else {
         ShipQuantityGroupByDateDO other = (ShipQuantityGroupByDateDO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$date = this.getDate();
               Object other$date = other.getDate();
               return this$date == null ? other$date == null : this$date.equals(other$date);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ShipQuantityGroupByDateDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $date = this.getDate();
      return result * 59 + ($date == null ? 43 : $date.hashCode());
   }

   @Override
   public String toString() {
      return "ShipQuantityGroupByDateDO(date=" + this.getDate() + ", quantity=" + this.getQuantity() + ")";
   }
}
