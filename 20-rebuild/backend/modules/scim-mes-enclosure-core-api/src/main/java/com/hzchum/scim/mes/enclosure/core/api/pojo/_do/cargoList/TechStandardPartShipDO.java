package com.hzchum.scim.mes.enclosure.core.api.pojo._do.cargoList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.TechStandardPartBaseInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "辅材商务")
public class TechStandardPartShipDO extends TechStandardPartBaseInfo {
   @ApiModelProperty("当前装车量")
   private BigDecimal shipMete;
   @ApiModelProperty("当前装车数量")
   private Integer shipQuantity;
   @ApiModelProperty("单价")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal unitPrice;
   @ApiModelProperty("总价")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal totalPrice;
   @ApiModelProperty("序号")
   private Integer pid;

   public BigDecimal getShipMete() {
      return this.shipMete;
   }

   public Integer getShipQuantity() {
      return this.shipQuantity;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getTotalPrice() {
      return this.totalPrice;
   }

   public Integer getPid() {
      return this.pid;
   }

   public void setShipMete(final BigDecimal shipMete) {
      this.shipMete = shipMete;
   }

   public void setShipQuantity(final Integer shipQuantity) {
      this.shipQuantity = shipQuantity;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   public void setTotalPrice(final BigDecimal totalPrice) {
      this.totalPrice = totalPrice;
   }

   public void setPid(final Integer pid) {
      this.pid = pid;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechStandardPartShipDO)) {
         return false;
      }

      TechStandardPartShipDO other = (TechStandardPartShipDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$shipQuantity = this.getShipQuantity();
      Object other$shipQuantity = other.getShipQuantity();
      if (this$shipQuantity == null ? other$shipQuantity == null : this$shipQuantity.equals(other$shipQuantity)) {
         Object this$pid = this.getPid();
         Object other$pid = other.getPid();
         if (this$pid == null ? other$pid == null : this$pid.equals(other$pid)) {
            Object this$shipMete = this.getShipMete();
            Object other$shipMete = other.getShipMete();
            if (this$shipMete == null ? other$shipMete == null : this$shipMete.equals(other$shipMete)) {
               Object this$unitPrice = this.getUnitPrice();
               Object other$unitPrice = other.getUnitPrice();
               if (this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice)) {
                  Object this$totalPrice = this.getTotalPrice();
                  Object other$totalPrice = other.getTotalPrice();
                  return this$totalPrice == null ? other$totalPrice == null : this$totalPrice.equals(other$totalPrice);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof TechStandardPartShipDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $shipQuantity = this.getShipQuantity();
      result = result * 59 + ($shipQuantity == null ? 43 : $shipQuantity.hashCode());
      Object $pid = this.getPid();
      result = result * 59 + ($pid == null ? 43 : $pid.hashCode());
      Object $shipMete = this.getShipMete();
      result = result * 59 + ($shipMete == null ? 43 : $shipMete.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $totalPrice = this.getTotalPrice();
      return result * 59 + ($totalPrice == null ? 43 : $totalPrice.hashCode());
   }

   @Override
   public String toString() {
      return "TechStandardPartShipDO(shipMete="
         + this.getShipMete()
         + ", shipQuantity="
         + this.getShipQuantity()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", totalPrice="
         + this.getTotalPrice()
         + ", pid="
         + this.getPid()
         + ")";
   }
}
