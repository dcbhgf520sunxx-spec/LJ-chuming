package com.hzchum.scim.mes.enclosure.core.api.pojo._do.cargoList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "构件商务")
public class AuxiliaryMaterialShipMeteDO {
   @ApiModelProperty("装车核算量")
   private BigDecimal shipMete;
   @ApiModelProperty("当前装车量")
   private Integer shipQuantity;
   @ApiModelProperty("核算量")
   private BigDecimal mete;
   @ApiModelProperty("数量")
   private Integer quantity;
   @ApiModelProperty("单价")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal unitPrice;

   public BigDecimal getShipMete() {
      return this.shipMete;
   }

   public Integer getShipQuantity() {
      return this.shipQuantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public void setShipMete(final BigDecimal shipMete) {
      this.shipMete = shipMete;
   }

   public void setShipQuantity(final Integer shipQuantity) {
      this.shipQuantity = shipQuantity;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AuxiliaryMaterialShipMeteDO)) {
         return false;
      }

      AuxiliaryMaterialShipMeteDO other = (AuxiliaryMaterialShipMeteDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$shipQuantity = this.getShipQuantity();
      Object other$shipQuantity = other.getShipQuantity();
      if (this$shipQuantity == null ? other$shipQuantity == null : this$shipQuantity.equals(other$shipQuantity)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$shipMete = this.getShipMete();
            Object other$shipMete = other.getShipMete();
            if (this$shipMete == null ? other$shipMete == null : this$shipMete.equals(other$shipMete)) {
               Object this$mete = this.getMete();
               Object other$mete = other.getMete();
               if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                  Object this$unitPrice = this.getUnitPrice();
                  Object other$unitPrice = other.getUnitPrice();
                  return this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice);
               } else {
                  return false;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AuxiliaryMaterialShipMeteDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $shipQuantity = this.getShipQuantity();
      result = result * 59 + ($shipQuantity == null ? 43 : $shipQuantity.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $shipMete = this.getShipMete();
      result = result * 59 + ($shipMete == null ? 43 : $shipMete.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $unitPrice = this.getUnitPrice();
      return result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
   }

   @Override
   public String toString() {
      return "AuxiliaryMaterialShipMeteDO(shipMete="
         + this.getShipMete()
         + ", shipQuantity="
         + this.getShipQuantity()
         + ", mete="
         + this.getMete()
         + ", quantity="
         + this.getQuantity()
         + ", unitPrice="
         + this.getUnitPrice()
         + ")";
   }
}
