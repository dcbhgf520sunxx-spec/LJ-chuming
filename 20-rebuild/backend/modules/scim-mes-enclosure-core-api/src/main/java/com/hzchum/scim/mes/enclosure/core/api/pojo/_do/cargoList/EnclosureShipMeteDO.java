package com.hzchum.scim.mes.enclosure.core.api.pojo._do.cargoList;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("围护发运")
public class EnclosureShipMeteDO {
   @ApiModelProperty("总长度（mm）")
   private BigDecimal totalLength;
   @ApiModelProperty("总面积（㎡）")
   private BigDecimal totalArea;
   @ApiModelProperty("单价")
   private BigDecimal unitPrice;

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public void setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
   }

   public void setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosureShipMeteDO)) {
         return false;
      }

      EnclosureShipMeteDO other = (EnclosureShipMeteDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$totalLength = this.getTotalLength();
      Object other$totalLength = other.getTotalLength();
      if (this$totalLength == null ? other$totalLength == null : this$totalLength.equals(other$totalLength)) {
         Object this$totalArea = this.getTotalArea();
         Object other$totalArea = other.getTotalArea();
         if (this$totalArea == null ? other$totalArea == null : this$totalArea.equals(other$totalArea)) {
            Object this$unitPrice = this.getUnitPrice();
            Object other$unitPrice = other.getUnitPrice();
            return this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof EnclosureShipMeteDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $unitPrice = this.getUnitPrice();
      return result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
   }

   @Override
   public String toString() {
      return "EnclosureShipMeteDO(totalLength=" + this.getTotalLength() + ", totalArea=" + this.getTotalArea() + ", unitPrice=" + this.getUnitPrice() + ")";
   }
}
