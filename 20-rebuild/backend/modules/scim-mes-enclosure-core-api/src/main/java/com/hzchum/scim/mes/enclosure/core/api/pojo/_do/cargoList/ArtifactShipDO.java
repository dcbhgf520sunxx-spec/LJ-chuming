package com.hzchum.scim.mes.enclosure.core.api.pojo._do.cargoList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.ArtifactBaseInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "构件商务")
public class ArtifactShipDO extends ArtifactBaseInfo {
   @ApiModelProperty("当前装车数")
   private Integer shipQuantity;
   @ApiModelProperty("过磅重量")
   private BigDecimal totalWeight;
   @ApiModelProperty("单价")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal unitPrice;
   @ApiModelProperty("总价")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal totalPrice;
   @ApiModelProperty("序号")
   private Integer pid;
   @ApiModelProperty("总重")
   private BigDecimal allWeight;
   @ApiModelProperty("总长度（mm）")
   private BigDecimal totalLength;
   @ApiModelProperty(name = "pricingManner", value = "计价方式", notes = "计价方式")
   private Integer pricingManner;

   public Integer getShipQuantity() {
      return this.shipQuantity;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
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

   public BigDecimal getAllWeight() {
      return this.allWeight;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public Integer getPricingManner() {
      return this.pricingManner;
   }

   public void setShipQuantity(final Integer shipQuantity) {
      this.shipQuantity = shipQuantity;
   }

   public void setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
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

   public void setAllWeight(final BigDecimal allWeight) {
      this.allWeight = allWeight;
   }

   public void setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
   }

   public void setPricingManner(final Integer pricingManner) {
      this.pricingManner = pricingManner;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactShipDO)) {
         return false;
      }

      ArtifactShipDO other = (ArtifactShipDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$shipQuantity = this.getShipQuantity();
      Object other$shipQuantity = other.getShipQuantity();
      if (this$shipQuantity == null ? other$shipQuantity == null : this$shipQuantity.equals(other$shipQuantity)) {
         Object this$pid = this.getPid();
         Object other$pid = other.getPid();
         if (this$pid == null ? other$pid == null : this$pid.equals(other$pid)) {
            Object this$pricingManner = this.getPricingManner();
            Object other$pricingManner = other.getPricingManner();
            if (this$pricingManner == null ? other$pricingManner == null : this$pricingManner.equals(other$pricingManner)) {
               Object this$totalWeight = this.getTotalWeight();
               Object other$totalWeight = other.getTotalWeight();
               if (this$totalWeight == null ? other$totalWeight == null : this$totalWeight.equals(other$totalWeight)) {
                  Object this$unitPrice = this.getUnitPrice();
                  Object other$unitPrice = other.getUnitPrice();
                  if (this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice)) {
                     Object this$totalPrice = this.getTotalPrice();
                     Object other$totalPrice = other.getTotalPrice();
                     if (this$totalPrice == null ? other$totalPrice == null : this$totalPrice.equals(other$totalPrice)) {
                        Object this$allWeight = this.getAllWeight();
                        Object other$allWeight = other.getAllWeight();
                        if (this$allWeight == null ? other$allWeight == null : this$allWeight.equals(other$allWeight)) {
                           Object this$totalLength = this.getTotalLength();
                           Object other$totalLength = other.getTotalLength();
                           return this$totalLength == null ? other$totalLength == null : this$totalLength.equals(other$totalLength);
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
      return other instanceof ArtifactShipDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $shipQuantity = this.getShipQuantity();
      result = result * 59 + ($shipQuantity == null ? 43 : $shipQuantity.hashCode());
      Object $pid = this.getPid();
      result = result * 59 + ($pid == null ? 43 : $pid.hashCode());
      Object $pricingManner = this.getPricingManner();
      result = result * 59 + ($pricingManner == null ? 43 : $pricingManner.hashCode());
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $totalPrice = this.getTotalPrice();
      result = result * 59 + ($totalPrice == null ? 43 : $totalPrice.hashCode());
      Object $allWeight = this.getAllWeight();
      result = result * 59 + ($allWeight == null ? 43 : $allWeight.hashCode());
      Object $totalLength = this.getTotalLength();
      return result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
   }

   @Override
   public String toString() {
      return "ArtifactShipDO(shipQuantity="
         + this.getShipQuantity()
         + ", totalWeight="
         + this.getTotalWeight()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", totalPrice="
         + this.getTotalPrice()
         + ", pid="
         + this.getPid()
         + ", allWeight="
         + this.getAllWeight()
         + ", totalLength="
         + this.getTotalLength()
         + ", pricingManner="
         + this.getPricingManner()
         + ")";
   }
}
