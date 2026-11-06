package com.hzchum.scim.project.core.api.pojo.dao;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("收货量")
public class ProjectReceivingMeteDO {
   @ApiModelProperty(name = "quality", value = "收货数量")
   private BigDecimal quantity;
   @ApiModelProperty(name = "mete", value = "产品总量(重量kg/长度mm)")
   private BigDecimal mete;
   @ApiModelProperty(name = "totalArea", value = "总面积(mm2)")
   private BigDecimal totalArea;

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectReceivingMeteDO)) {
         return false;
      }

      ProjectReceivingMeteDO other = (ProjectReceivingMeteDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$mete = this.getMete();
         Object other$mete = other.getMete();
         if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
            Object this$totalArea = this.getTotalArea();
            Object other$totalArea = other.getTotalArea();
            return this$totalArea == null ? other$totalArea == null : this$totalArea.equals(other$totalArea);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectReceivingMeteDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $totalArea = this.getTotalArea();
      return result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectReceivingMeteDO(quantity=" + this.getQuantity() + ", mete=" + this.getMete() + ", totalArea=" + this.getTotalArea() + ")";
   }
}
