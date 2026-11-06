package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class ProductDeepenMeteDTO {
   @ApiModelProperty("深化数量")
   private Integer quantity;
   @ApiModelProperty("深化量:构件(净重:kg)/围护(总长度:m)")
   private BigDecimal mete;
   @ApiModelProperty("深化量:构件(毛重:t)/围护(总面积:m2)")
   private BigDecimal totalArea;

   public static ProductDeepenMeteDTO.ProductDeepenMeteDTOBuilder builder() {
      return new ProductDeepenMeteDTO.ProductDeepenMeteDTOBuilder();
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public void setQuantity(final Integer quantity) {
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

      if (!(o instanceof ProductDeepenMeteDTO)) {
         return false;
      }

      ProductDeepenMeteDTO other = (ProductDeepenMeteDTO)o;
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
      return other instanceof ProductDeepenMeteDTO;
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
      return "ProductDeepenMeteDTO(quantity=" + this.getQuantity() + ", mete=" + this.getMete() + ", totalArea=" + this.getTotalArea() + ")";
   }

   public ProductDeepenMeteDTO() {
   }

   public ProductDeepenMeteDTO(final Integer quantity, final BigDecimal mete, final BigDecimal totalArea) {
      this.quantity = quantity;
      this.mete = mete;
      this.totalArea = totalArea;
   }

   public static class ProductDeepenMeteDTOBuilder {
      private Integer quantity;
      private BigDecimal mete;
      private BigDecimal totalArea;

      ProductDeepenMeteDTOBuilder() {
      }

      public ProductDeepenMeteDTO.ProductDeepenMeteDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public ProductDeepenMeteDTO.ProductDeepenMeteDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public ProductDeepenMeteDTO.ProductDeepenMeteDTOBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      public ProductDeepenMeteDTO build() {
         return new ProductDeepenMeteDTO(this.quantity, this.mete, this.totalArea);
      }

      @Override
      public String toString() {
         return "ProductDeepenMeteDTO.ProductDeepenMeteDTOBuilder(quantity=" + this.quantity + ", mete=" + this.mete + ", totalArea=" + this.totalArea + ")";
      }
   }
}
