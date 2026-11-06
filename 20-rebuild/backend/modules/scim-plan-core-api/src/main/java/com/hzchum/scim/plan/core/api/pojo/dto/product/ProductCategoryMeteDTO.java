package com.hzchum.scim.plan.core.api.pojo.dto.product;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class ProductCategoryMeteDTO {
   @ApiModelProperty("产品类型")
   private Integer productType;
   @ApiModelProperty("围护分类")
   private Integer category;
   @ApiModelProperty("清单量")
   private BigDecimal menuMete;
   @ApiModelProperty("完成量")
   private BigDecimal finishMete;

   ProductCategoryMeteDTO(final Integer productType, final Integer category, final BigDecimal menuMete, final BigDecimal finishMete) {
      this.productType = productType;
      this.category = category;
      this.menuMete = menuMete;
      this.finishMete = finishMete;
   }

   public static ProductCategoryMeteDTO.ProductCategoryMeteDTOBuilder builder() {
      return new ProductCategoryMeteDTO.ProductCategoryMeteDTOBuilder();
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getCategory() {
      return this.category;
   }

   public BigDecimal getMenuMete() {
      return this.menuMete;
   }

   public BigDecimal getFinishMete() {
      return this.finishMete;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setCategory(final Integer category) {
      this.category = category;
   }

   public void setMenuMete(final BigDecimal menuMete) {
      this.menuMete = menuMete;
   }

   public void setFinishMete(final BigDecimal finishMete) {
      this.finishMete = finishMete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductCategoryMeteDTO)) {
         return false;
      }

      ProductCategoryMeteDTO other = (ProductCategoryMeteDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productType = this.getProductType();
      Object other$productType = other.getProductType();
      if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
         Object this$category = this.getCategory();
         Object other$category = other.getCategory();
         if (this$category == null ? other$category == null : this$category.equals(other$category)) {
            Object this$menuMete = this.getMenuMete();
            Object other$menuMete = other.getMenuMete();
            if (this$menuMete == null ? other$menuMete == null : this$menuMete.equals(other$menuMete)) {
               Object this$finishMete = this.getFinishMete();
               Object other$finishMete = other.getFinishMete();
               return this$finishMete == null ? other$finishMete == null : this$finishMete.equals(other$finishMete);
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
      return other instanceof ProductCategoryMeteDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $menuMete = this.getMenuMete();
      result = result * 59 + ($menuMete == null ? 43 : $menuMete.hashCode());
      Object $finishMete = this.getFinishMete();
      return result * 59 + ($finishMete == null ? 43 : $finishMete.hashCode());
   }

   @Override
   public String toString() {
      return "ProductCategoryMeteDTO(productType="
         + this.getProductType()
         + ", category="
         + this.getCategory()
         + ", menuMete="
         + this.getMenuMete()
         + ", finishMete="
         + this.getFinishMete()
         + ")";
   }

   public static class ProductCategoryMeteDTOBuilder {
      private Integer productType;
      private Integer category;
      private BigDecimal menuMete;
      private BigDecimal finishMete;

      ProductCategoryMeteDTOBuilder() {
      }

      public ProductCategoryMeteDTO.ProductCategoryMeteDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ProductCategoryMeteDTO.ProductCategoryMeteDTOBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public ProductCategoryMeteDTO.ProductCategoryMeteDTOBuilder menuMete(final BigDecimal menuMete) {
         this.menuMete = menuMete;
         return this;
      }

      public ProductCategoryMeteDTO.ProductCategoryMeteDTOBuilder finishMete(final BigDecimal finishMete) {
         this.finishMete = finishMete;
         return this;
      }

      public ProductCategoryMeteDTO build() {
         return new ProductCategoryMeteDTO(this.productType, this.category, this.menuMete, this.finishMete);
      }

      @Override
      public String toString() {
         return "ProductCategoryMeteDTO.ProductCategoryMeteDTOBuilder(productType="
            + this.productType
            + ", category="
            + this.category
            + ", menuMete="
            + this.menuMete
            + ", finishMete="
            + this.finishMete
            + ")";
      }
   }
}
