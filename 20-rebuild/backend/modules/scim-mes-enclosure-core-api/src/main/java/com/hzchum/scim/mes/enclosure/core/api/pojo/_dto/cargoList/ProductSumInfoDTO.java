package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.cargoList;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "产品汇总")
public class ProductSumInfoDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("产品类型")
   private Integer productType;
   @ApiModelProperty(name = "category", notes = "品类 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
   private Integer category;
   @ApiModelProperty("包内数量")
   private Integer quantity;
   @ApiModelProperty("单毛重（kg）")
   private BigDecimal grossWeight;
   @ApiModelProperty("单净重（kg）")
   private BigDecimal netWeight;
   @ApiModelProperty("单长度（mm）")
   private BigDecimal length;
   @ApiModelProperty("单面积（㎡）")
   private BigDecimal surfaceArea;
   @ApiModelProperty("结构毛重（kg）")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty("结构净重（kg）")
   private BigDecimal totalNetWeight;
   @ApiModelProperty("总长度（mm）")
   private BigDecimal enclLength;

   ProductSumInfoDTO(
      final Integer productType,
      final Integer category,
      final Integer quantity,
      final BigDecimal grossWeight,
      final BigDecimal netWeight,
      final BigDecimal length,
      final BigDecimal surfaceArea,
      final BigDecimal totalGrossWeight,
      final BigDecimal totalNetWeight,
      final BigDecimal enclLength
   ) {
      this.productType = productType;
      this.category = category;
      this.quantity = quantity;
      this.grossWeight = grossWeight;
      this.netWeight = netWeight;
      this.length = length;
      this.surfaceArea = surfaceArea;
      this.totalGrossWeight = totalGrossWeight;
      this.totalNetWeight = totalNetWeight;
      this.enclLength = enclLength;
   }

   public static ProductSumInfoDTO.ProductSumInfoDTOBuilder builder() {
      return new ProductSumInfoDTO.ProductSumInfoDTOBuilder();
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getCategory() {
      return this.category;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getEnclLength() {
      return this.enclLength;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setCategory(final Integer category) {
      this.category = category;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
   }

   public void setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
   }

   public void setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
   }

   public void setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
   }

   public void setEnclLength(final BigDecimal enclLength) {
      this.enclLength = enclLength;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductSumInfoDTO)) {
         return false;
      }

      ProductSumInfoDTO other = (ProductSumInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productType = this.getProductType();
      Object other$productType = other.getProductType();
      if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
         Object this$category = this.getCategory();
         Object other$category = other.getCategory();
         if (this$category == null ? other$category == null : this$category.equals(other$category)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$grossWeight = this.getGrossWeight();
               Object other$grossWeight = other.getGrossWeight();
               if (this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight)) {
                  Object this$netWeight = this.getNetWeight();
                  Object other$netWeight = other.getNetWeight();
                  if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                     Object this$length = this.getLength();
                     Object other$length = other.getLength();
                     if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                        Object this$surfaceArea = this.getSurfaceArea();
                        Object other$surfaceArea = other.getSurfaceArea();
                        if (this$surfaceArea == null ? other$surfaceArea == null : this$surfaceArea.equals(other$surfaceArea)) {
                           Object this$totalGrossWeight = this.getTotalGrossWeight();
                           Object other$totalGrossWeight = other.getTotalGrossWeight();
                           if (this$totalGrossWeight == null ? other$totalGrossWeight == null : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                              Object this$totalNetWeight = this.getTotalNetWeight();
                              Object other$totalNetWeight = other.getTotalNetWeight();
                              if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
                                 Object this$enclLength = this.getEnclLength();
                                 Object other$enclLength = other.getEnclLength();
                                 return this$enclLength == null ? other$enclLength == null : this$enclLength.equals(other$enclLength);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProductSumInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $enclLength = this.getEnclLength();
      return result * 59 + ($enclLength == null ? 43 : $enclLength.hashCode());
   }

   @Override
   public String toString() {
      return "ProductSumInfoDTO(productType="
         + this.getProductType()
         + ", category="
         + this.getCategory()
         + ", quantity="
         + this.getQuantity()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", netWeight="
         + this.getNetWeight()
         + ", length="
         + this.getLength()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", enclLength="
         + this.getEnclLength()
         + ")";
   }

   public static class ProductSumInfoDTOBuilder {
      private Integer productType;
      private Integer category;
      private Integer quantity;
      private BigDecimal grossWeight;
      private BigDecimal netWeight;
      private BigDecimal length;
      private BigDecimal surfaceArea;
      private BigDecimal totalGrossWeight;
      private BigDecimal totalNetWeight;
      private BigDecimal enclLength;

      ProductSumInfoDTOBuilder() {
      }

      public ProductSumInfoDTO.ProductSumInfoDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ProductSumInfoDTO.ProductSumInfoDTOBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public ProductSumInfoDTO.ProductSumInfoDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public ProductSumInfoDTO.ProductSumInfoDTOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      public ProductSumInfoDTO.ProductSumInfoDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public ProductSumInfoDTO.ProductSumInfoDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public ProductSumInfoDTO.ProductSumInfoDTOBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      public ProductSumInfoDTO.ProductSumInfoDTOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      public ProductSumInfoDTO.ProductSumInfoDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      public ProductSumInfoDTO.ProductSumInfoDTOBuilder enclLength(final BigDecimal enclLength) {
         this.enclLength = enclLength;
         return this;
      }

      public ProductSumInfoDTO build() {
         return new ProductSumInfoDTO(
            this.productType,
            this.category,
            this.quantity,
            this.grossWeight,
            this.netWeight,
            this.length,
            this.surfaceArea,
            this.totalGrossWeight,
            this.totalNetWeight,
            this.enclLength
         );
      }

      @Override
      public String toString() {
         return "ProductSumInfoDTO.ProductSumInfoDTOBuilder(productType="
            + this.productType
            + ", category="
            + this.category
            + ", quantity="
            + this.quantity
            + ", grossWeight="
            + this.grossWeight
            + ", netWeight="
            + this.netWeight
            + ", length="
            + this.length
            + ", surfaceArea="
            + this.surfaceArea
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", enclLength="
            + this.enclLength
            + ")";
      }
   }
}
