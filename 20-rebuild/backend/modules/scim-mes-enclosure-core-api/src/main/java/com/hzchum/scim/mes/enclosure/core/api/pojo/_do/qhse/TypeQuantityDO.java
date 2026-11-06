package com.hzchum.scim.mes.enclosure.core.api.pojo._do.qhse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("类型数量")
public class TypeQuantityDO {
   @ApiModelProperty("type")
   private String type;
   @ApiModelProperty("数量")
   private Integer quantity;

   public String getType() {
      return this.type;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public void setType(final String type) {
      this.type = type;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof TypeQuantityDO)) {
         return false;
      } else {
         TypeQuantityDO other = (TypeQuantityDO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$type = this.getType();
               Object other$type = other.getType();
               return this$type == null ? other$type == null : this$type.equals(other$type);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TypeQuantityDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $type = this.getType();
      return result * 59 + ($type == null ? 43 : $type.hashCode());
   }

   @Override
   public String toString() {
      return "TypeQuantityDO(type=" + this.getType() + ", quantity=" + this.getQuantity() + ")";
   }
}
