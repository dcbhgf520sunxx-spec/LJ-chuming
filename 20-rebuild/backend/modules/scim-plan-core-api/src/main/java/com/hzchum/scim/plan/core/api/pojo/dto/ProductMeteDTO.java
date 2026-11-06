package com.hzchum.scim.plan.core.api.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class ProductMeteDTO {
   @ApiModelProperty("深化数量")
   private Integer quantity;
   @ApiModelProperty("深化量:构件(净重:t)/围护(总长度:m)")
   private BigDecimal mete;
   @ApiModelProperty("深化量:构件(毛重:t)/围护(总面积:m2)")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal meteTwo;

   public static ProductMeteDTO.ProductMeteDTOBuilder builder() {
      return new ProductMeteDTO.ProductMeteDTOBuilder();
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getMeteTwo() {
      return this.meteTwo;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setMeteTwo(final BigDecimal meteTwo) {
      this.meteTwo = meteTwo;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductMeteDTO)) {
         return false;
      }

      ProductMeteDTO other = (ProductMeteDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$mete = this.getMete();
         Object other$mete = other.getMete();
         if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
            Object this$meteTwo = this.getMeteTwo();
            Object other$meteTwo = other.getMeteTwo();
            return this$meteTwo == null ? other$meteTwo == null : this$meteTwo.equals(other$meteTwo);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProductMeteDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $meteTwo = this.getMeteTwo();
      return result * 59 + ($meteTwo == null ? 43 : $meteTwo.hashCode());
   }

   @Override
   public String toString() {
      return "ProductMeteDTO(quantity=" + this.getQuantity() + ", mete=" + this.getMete() + ", meteTwo=" + this.getMeteTwo() + ")";
   }

   public ProductMeteDTO() {
   }

   public ProductMeteDTO(final Integer quantity, final BigDecimal mete, final BigDecimal meteTwo) {
      this.quantity = quantity;
      this.mete = mete;
      this.meteTwo = meteTwo;
   }

   public static class ProductMeteDTOBuilder {
      private Integer quantity;
      private BigDecimal mete;
      private BigDecimal meteTwo;

      ProductMeteDTOBuilder() {
      }

      public ProductMeteDTO.ProductMeteDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public ProductMeteDTO.ProductMeteDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public ProductMeteDTO.ProductMeteDTOBuilder meteTwo(final BigDecimal meteTwo) {
         this.meteTwo = meteTwo;
         return this;
      }

      public ProductMeteDTO build() {
         return new ProductMeteDTO(this.quantity, this.mete, this.meteTwo);
      }

      @Override
      public String toString() {
         return "ProductMeteDTO.ProductMeteDTOBuilder(quantity=" + this.quantity + ", mete=" + this.mete + ", meteTwo=" + this.meteTwo + ")";
      }
   }
}
