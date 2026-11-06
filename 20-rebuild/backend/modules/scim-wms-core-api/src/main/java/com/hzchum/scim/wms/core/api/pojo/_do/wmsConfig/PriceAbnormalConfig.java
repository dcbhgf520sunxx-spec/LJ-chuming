package com.hzchum.scim.wms.core.api.pojo._do.wmsConfig;

import java.math.BigDecimal;

public class PriceAbnormalConfig {
   private Integer basicClass;
   private BigDecimal minPrice;
   private BigDecimal maxPrice;

   public static PriceAbnormalConfig.PriceAbnormalConfigBuilder builder() {
      return new PriceAbnormalConfig.PriceAbnormalConfigBuilder();
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public BigDecimal getMinPrice() {
      return this.minPrice;
   }

   public BigDecimal getMaxPrice() {
      return this.maxPrice;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setMinPrice(final BigDecimal minPrice) {
      this.minPrice = minPrice;
   }

   public void setMaxPrice(final BigDecimal maxPrice) {
      this.maxPrice = maxPrice;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PriceAbnormalConfig)) {
         return false;
      }

      PriceAbnormalConfig other = (PriceAbnormalConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$basicClass = this.getBasicClass();
      Object other$basicClass = other.getBasicClass();
      if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
         Object this$minPrice = this.getMinPrice();
         Object other$minPrice = other.getMinPrice();
         if (this$minPrice == null ? other$minPrice == null : this$minPrice.equals(other$minPrice)) {
            Object this$maxPrice = this.getMaxPrice();
            Object other$maxPrice = other.getMaxPrice();
            return this$maxPrice == null ? other$maxPrice == null : this$maxPrice.equals(other$maxPrice);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PriceAbnormalConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $minPrice = this.getMinPrice();
      result = result * 59 + ($minPrice == null ? 43 : $minPrice.hashCode());
      Object $maxPrice = this.getMaxPrice();
      return result * 59 + ($maxPrice == null ? 43 : $maxPrice.hashCode());
   }

   @Override
   public String toString() {
      return "PriceAbnormalConfig(basicClass=" + this.getBasicClass() + ", minPrice=" + this.getMinPrice() + ", maxPrice=" + this.getMaxPrice() + ")";
   }

   public PriceAbnormalConfig(final Integer basicClass, final BigDecimal minPrice, final BigDecimal maxPrice) {
      this.basicClass = basicClass;
      this.minPrice = minPrice;
      this.maxPrice = maxPrice;
   }

   public PriceAbnormalConfig() {
   }

   public static class PriceAbnormalConfigBuilder {
      private Integer basicClass;
      private BigDecimal minPrice;
      private BigDecimal maxPrice;

      PriceAbnormalConfigBuilder() {
      }

      public PriceAbnormalConfig.PriceAbnormalConfigBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public PriceAbnormalConfig.PriceAbnormalConfigBuilder minPrice(final BigDecimal minPrice) {
         this.minPrice = minPrice;
         return this;
      }

      public PriceAbnormalConfig.PriceAbnormalConfigBuilder maxPrice(final BigDecimal maxPrice) {
         this.maxPrice = maxPrice;
         return this;
      }

      public PriceAbnormalConfig build() {
         return new PriceAbnormalConfig(this.basicClass, this.minPrice, this.maxPrice);
      }

      @Override
      public String toString() {
         return "PriceAbnormalConfig.PriceAbnormalConfigBuilder(basicClass="
            + this.basicClass
            + ", minPrice="
            + this.minPrice
            + ", maxPrice="
            + this.maxPrice
            + ")";
      }
   }
}
