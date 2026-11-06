package com.hzchum.scim.plan.core.api.pojo.dto.product.bridge;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.plan.core.api.pojo.dto.AreaInfoDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@JsonInclude(Include.NON_NULL)
public class BridgeProductMeteGroupDTO {
   @ApiModelProperty("单体信息")
   private NameInfo monomer;
   @ApiModelProperty("区域信息")
   private AreaInfoDTO area;
   @ApiModelProperty("数量")
   private Integer quantity;
   @ApiModelProperty("总净重")
   private BigDecimal totalNetWeight;
   @ApiModelProperty("总毛重")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty("总长度")
   private BigDecimal totalLength;

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public AreaInfoDTO getArea() {
      return this.area;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public void setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
   }

   public void setArea(final AreaInfoDTO area) {
      this.area = area;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
   }

   public void setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
   }

   public void setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BridgeProductMeteGroupDTO)) {
         return false;
      }

      BridgeProductMeteGroupDTO other = (BridgeProductMeteGroupDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$monomer = this.getMonomer();
         Object other$monomer = other.getMonomer();
         if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
            Object this$area = this.getArea();
            Object other$area = other.getArea();
            if (this$area == null ? other$area == null : this$area.equals(other$area)) {
               Object this$totalNetWeight = this.getTotalNetWeight();
               Object other$totalNetWeight = other.getTotalNetWeight();
               if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
                  Object this$totalGrossWeight = this.getTotalGrossWeight();
                  Object other$totalGrossWeight = other.getTotalGrossWeight();
                  if (this$totalGrossWeight == null ? other$totalGrossWeight == null : this$totalGrossWeight.equals(other$totalGrossWeight)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof BridgeProductMeteGroupDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $totalLength = this.getTotalLength();
      return result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
   }

   @Override
   public String toString() {
      return "BridgeProductMeteGroupDTO(monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", quantity="
         + this.getQuantity()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", totalLength="
         + this.getTotalLength()
         + ")";
   }
}
