package com.hzchum.scim.mes.building.core.api.pojo._do.cargoList;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class SupplierPriceInfo {
   @ApiModelProperty("供应商id")
   private Long id;
   @ApiModelProperty("供应商名称")
   private String name;
   @ApiModelProperty("计价方式 [1重量, 2 车次]")
   private Integer priceType;
   @ApiModelProperty("价格")
   private BigDecimal price;

   public static SupplierPriceInfo.SupplierPriceInfoBuilder builder() {
      return new SupplierPriceInfo.SupplierPriceInfoBuilder();
   }

   public SupplierPriceInfo(final Long id, final String name, final Integer priceType, final BigDecimal price) {
      this.id = id;
      this.name = name;
      this.priceType = priceType;
      this.price = price;
   }

   public SupplierPriceInfo() {
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getPriceType() {
      return this.priceType;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setPriceType(final Integer priceType) {
      this.priceType = priceType;
   }

   public void setPrice(final BigDecimal price) {
      this.price = price;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierPriceInfo)) {
         return false;
      }

      SupplierPriceInfo other = (SupplierPriceInfo)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$priceType = this.getPriceType();
         Object other$priceType = other.getPriceType();
         if (this$priceType == null ? other$priceType == null : this$priceType.equals(other$priceType)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$price = this.getPrice();
               Object other$price = other.getPrice();
               return this$price == null ? other$price == null : this$price.equals(other$price);
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
      return other instanceof SupplierPriceInfo;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $priceType = this.getPriceType();
      result = result * 59 + ($priceType == null ? 43 : $priceType.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierPriceInfo(id=" + this.getId() + ", name=" + this.getName() + ", priceType=" + this.getPriceType() + ", price=" + this.getPrice() + ")";
   }

   public static class SupplierPriceInfoBuilder {
      private Long id;
      private String name;
      private Integer priceType;
      private BigDecimal price;

      SupplierPriceInfoBuilder() {
      }

      public SupplierPriceInfo.SupplierPriceInfoBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SupplierPriceInfo.SupplierPriceInfoBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SupplierPriceInfo.SupplierPriceInfoBuilder priceType(final Integer priceType) {
         this.priceType = priceType;
         return this;
      }

      public SupplierPriceInfo.SupplierPriceInfoBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public SupplierPriceInfo build() {
         return new SupplierPriceInfo(this.id, this.name, this.priceType, this.price);
      }

      @Override
      public String toString() {
         return "SupplierPriceInfo.SupplierPriceInfoBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", priceType="
            + this.priceType
            + ", price="
            + this.price
            + ")";
      }
   }
}
