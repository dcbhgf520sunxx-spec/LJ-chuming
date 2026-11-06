package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.save;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "发运包修改类")
public class CargoListPackConcertDTOParam {
   @ApiModelProperty(name = "packageId", notes = "包Id")
   private Long packageId;
   @ApiModelProperty(name = "quantity", value = "数量")
   private Integer quantity;

   public Long getPackageId() {
      return this.packageId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public void setPackageId(final Long packageId) {
      this.packageId = packageId;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof CargoListPackConcertDTOParam)) {
         return false;
      } else {
         CargoListPackConcertDTOParam other = (CargoListPackConcertDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$packageId = this.getPackageId();
            Object other$packageId = other.getPackageId();
            if (this$packageId == null ? other$packageId == null : this$packageId.equals(other$packageId)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               return this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CargoListPackConcertDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $packageId = this.getPackageId();
      result = result * 59 + ($packageId == null ? 43 : $packageId.hashCode());
      Object $quantity = this.getQuantity();
      return result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
   }

   @Override
   public String toString() {
      return "CargoListPackConcertDTOParam(packageId=" + this.getPackageId() + ", quantity=" + this.getQuantity() + ")";
   }
}
