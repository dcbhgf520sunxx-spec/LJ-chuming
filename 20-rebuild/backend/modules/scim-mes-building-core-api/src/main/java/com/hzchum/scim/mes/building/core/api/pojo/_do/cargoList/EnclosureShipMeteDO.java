package com.hzchum.scim.mes.building.core.api.pojo._do.cargoList;

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
   @ApiModelProperty("入库类型 0普通入库 1回厂返修")
   private Integer warehouseType;

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public Integer getWarehouseType() {
      return this.warehouseType;
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

   public void setWarehouseType(final Integer warehouseType) {
      this.warehouseType = warehouseType;
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

      Object this$warehouseType = this.getWarehouseType();
      Object other$warehouseType = other.getWarehouseType();
      if (this$warehouseType == null ? other$warehouseType == null : this$warehouseType.equals(other$warehouseType)) {
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
      Object $warehouseType = this.getWarehouseType();
      result = result * 59 + ($warehouseType == null ? 43 : $warehouseType.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $unitPrice = this.getUnitPrice();
      return result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
   }

   @Override
   public String toString() {
      return "EnclosureShipMeteDO(totalLength="
         + this.getTotalLength()
         + ", totalArea="
         + this.getTotalArea()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", warehouseType="
         + this.getWarehouseType()
         + ")";
   }
}
