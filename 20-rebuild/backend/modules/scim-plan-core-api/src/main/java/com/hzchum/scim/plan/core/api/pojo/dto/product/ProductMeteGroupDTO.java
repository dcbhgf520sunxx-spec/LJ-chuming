package com.hzchum.scim.plan.core.api.pojo.dto.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.plan.core.api.pojo.dto.AreaInfoDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@JsonInclude(Include.NON_NULL)
public class ProductMeteGroupDTO {
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
   @ApiModelProperty("总面积(㎡)")
   private BigDecimal totalArea;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty("总上翼缘面积(㎡)")
   private BigDecimal topFlangeArea;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty("总图纸重量(kg)")
   private BigDecimal totalDrawingWeight;

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

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public BigDecimal getTopFlangeArea() {
      return this.topFlangeArea;
   }

   public BigDecimal getTotalDrawingWeight() {
      return this.totalDrawingWeight;
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

   public void setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
   }

   public void setTopFlangeArea(final BigDecimal topFlangeArea) {
      this.topFlangeArea = topFlangeArea;
   }

   public void setTotalDrawingWeight(final BigDecimal totalDrawingWeight) {
      this.totalDrawingWeight = totalDrawingWeight;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductMeteGroupDTO)) {
         return false;
      }

      ProductMeteGroupDTO other = (ProductMeteGroupDTO)o;
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
                     if (this$totalLength == null ? other$totalLength == null : this$totalLength.equals(other$totalLength)) {
                        Object this$totalArea = this.getTotalArea();
                        Object other$totalArea = other.getTotalArea();
                        if (this$totalArea == null ? other$totalArea == null : this$totalArea.equals(other$totalArea)) {
                           Object this$topFlangeArea = this.getTopFlangeArea();
                           Object other$topFlangeArea = other.getTopFlangeArea();
                           if (this$topFlangeArea == null ? other$topFlangeArea == null : this$topFlangeArea.equals(other$topFlangeArea)) {
                              Object this$totalDrawingWeight = this.getTotalDrawingWeight();
                              Object other$totalDrawingWeight = other.getTotalDrawingWeight();
                              return this$totalDrawingWeight == null
                                 ? other$totalDrawingWeight == null
                                 : this$totalDrawingWeight.equals(other$totalDrawingWeight);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProductMeteGroupDTO;
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
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $topFlangeArea = this.getTopFlangeArea();
      result = result * 59 + ($topFlangeArea == null ? 43 : $topFlangeArea.hashCode());
      Object $totalDrawingWeight = this.getTotalDrawingWeight();
      return result * 59 + ($totalDrawingWeight == null ? 43 : $totalDrawingWeight.hashCode());
   }

   @Override
   public String toString() {
      return "ProductMeteGroupDTO(monomer="
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
         + ", totalArea="
         + this.getTotalArea()
         + ", topFlangeArea="
         + this.getTopFlangeArea()
         + ", totalDrawingWeight="
         + this.getTotalDrawingWeight()
         + ")";
   }
}
