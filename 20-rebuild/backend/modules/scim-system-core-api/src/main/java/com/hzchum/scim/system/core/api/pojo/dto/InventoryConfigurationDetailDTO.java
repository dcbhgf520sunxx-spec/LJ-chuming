package com.hzchum.scim.system.core.api.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class InventoryConfigurationDetailDTO {
   @ApiModelProperty("产品类型")
   private Integer productType;
   @ApiModelProperty("长度")
   private BigDecimal length;
   @ApiModelProperty("净重")
   private BigDecimal netWeight;
   @ApiModelProperty("毛重")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "surfaceArea", value = "面积（平方毫米）")
   private BigDecimal surfaceArea;
   @ApiModelProperty("截面厚度")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal thickness;
   @ApiModelProperty("截面宽度")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal width;

   public static InventoryConfigurationDetailDTO.InventoryConfigurationDetailDTOBuilder builder() {
      return new InventoryConfigurationDetailDTO.InventoryConfigurationDetailDTOBuilder();
   }

   public InventoryConfigurationDetailDTO() {
   }

   public InventoryConfigurationDetailDTO(
      final Integer productType,
      final BigDecimal length,
      final BigDecimal netWeight,
      final BigDecimal grossWeight,
      final BigDecimal surfaceArea,
      final BigDecimal thickness,
      final BigDecimal width
   ) {
      this.productType = productType;
      this.length = length;
      this.netWeight = netWeight;
      this.grossWeight = grossWeight;
      this.surfaceArea = surfaceArea;
      this.thickness = thickness;
      this.width = width;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
   }

   public void setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
   }

   public void setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InventoryConfigurationDetailDTO)) {
         return false;
      }

      InventoryConfigurationDetailDTO other = (InventoryConfigurationDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productType = this.getProductType();
      Object other$productType = other.getProductType();
      if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
         Object this$length = this.getLength();
         Object other$length = other.getLength();
         if (this$length == null ? other$length == null : this$length.equals(other$length)) {
            Object this$netWeight = this.getNetWeight();
            Object other$netWeight = other.getNetWeight();
            if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
               Object this$grossWeight = this.getGrossWeight();
               Object other$grossWeight = other.getGrossWeight();
               if (this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight)) {
                  Object this$surfaceArea = this.getSurfaceArea();
                  Object other$surfaceArea = other.getSurfaceArea();
                  if (this$surfaceArea == null ? other$surfaceArea == null : this$surfaceArea.equals(other$surfaceArea)) {
                     Object this$thickness = this.getThickness();
                     Object other$thickness = other.getThickness();
                     if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                        Object this$width = this.getWidth();
                        Object other$width = other.getWidth();
                        return this$width == null ? other$width == null : this$width.equals(other$width);
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
      return other instanceof InventoryConfigurationDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $width = this.getWidth();
      return result * 59 + ($width == null ? 43 : $width.hashCode());
   }

   @Override
   public String toString() {
      return "InventoryConfigurationDetailDTO(productType="
         + this.getProductType()
         + ", length="
         + this.getLength()
         + ", netWeight="
         + this.getNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", thickness="
         + this.getThickness()
         + ", width="
         + this.getWidth()
         + ")";
   }

   public static class InventoryConfigurationDetailDTOBuilder {
      private Integer productType;
      private BigDecimal length;
      private BigDecimal netWeight;
      private BigDecimal grossWeight;
      private BigDecimal surfaceArea;
      private BigDecimal thickness;
      private BigDecimal width;

      InventoryConfigurationDetailDTOBuilder() {
      }

      public InventoryConfigurationDetailDTO.InventoryConfigurationDetailDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public InventoryConfigurationDetailDTO.InventoryConfigurationDetailDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public InventoryConfigurationDetailDTO.InventoryConfigurationDetailDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public InventoryConfigurationDetailDTO.InventoryConfigurationDetailDTOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      public InventoryConfigurationDetailDTO.InventoryConfigurationDetailDTOBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      public InventoryConfigurationDetailDTO.InventoryConfigurationDetailDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public InventoryConfigurationDetailDTO.InventoryConfigurationDetailDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public InventoryConfigurationDetailDTO build() {
         return new InventoryConfigurationDetailDTO(
            this.productType, this.length, this.netWeight, this.grossWeight, this.surfaceArea, this.thickness, this.width
         );
      }

      @Override
      public String toString() {
         return "InventoryConfigurationDetailDTO.InventoryConfigurationDetailDTOBuilder(productType="
            + this.productType
            + ", length="
            + this.length
            + ", netWeight="
            + this.netWeight
            + ", grossWeight="
            + this.grossWeight
            + ", surfaceArea="
            + this.surfaceArea
            + ", thickness="
            + this.thickness
            + ", width="
            + this.width
            + ")";
      }
   }
}
