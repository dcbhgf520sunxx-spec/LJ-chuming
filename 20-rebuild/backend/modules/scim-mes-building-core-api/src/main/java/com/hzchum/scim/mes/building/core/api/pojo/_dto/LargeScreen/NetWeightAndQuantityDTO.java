package com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class NetWeightAndQuantityDTO {
   @ApiModelProperty(name = "weight", value = "重量")
   private BigDecimal weight;
   @ApiModelProperty(name = "quantity", value = "数量")
   private Integer quantity;

   public BigDecimal getWeight() {
      return this.weight;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public void setWeight(final BigDecimal weight) {
      this.weight = weight;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof NetWeightAndQuantityDTO)) {
         return false;
      } else {
         NetWeightAndQuantityDTO other = (NetWeightAndQuantityDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$weight = this.getWeight();
               Object other$weight = other.getWeight();
               return this$weight == null ? other$weight == null : this$weight.equals(other$weight);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof NetWeightAndQuantityDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $weight = this.getWeight();
      return result * 59 + ($weight == null ? 43 : $weight.hashCode());
   }

   @Override
   public String toString() {
      return "NetWeightAndQuantityDTO(weight=" + this.getWeight() + ", quantity=" + this.getQuantity() + ")";
   }
}
