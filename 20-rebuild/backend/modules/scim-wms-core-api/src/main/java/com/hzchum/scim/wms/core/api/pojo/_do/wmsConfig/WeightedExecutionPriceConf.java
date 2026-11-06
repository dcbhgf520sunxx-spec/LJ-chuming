package com.hzchum.scim.wms.core.api.pojo._do.wmsConfig;

public class WeightedExecutionPriceConf {
   private Integer weightedExecutionType;

   public static WeightedExecutionPriceConf.WeightedExecutionPriceConfBuilder builder() {
      return new WeightedExecutionPriceConf.WeightedExecutionPriceConfBuilder();
   }

   public Integer getWeightedExecutionType() {
      return this.weightedExecutionType;
   }

   public void setWeightedExecutionType(final Integer weightedExecutionType) {
      this.weightedExecutionType = weightedExecutionType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WeightedExecutionPriceConf)) {
         return false;
      }

      WeightedExecutionPriceConf other = (WeightedExecutionPriceConf)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$weightedExecutionType = this.getWeightedExecutionType();
      Object other$weightedExecutionType = other.getWeightedExecutionType();
      return this$weightedExecutionType == null ? other$weightedExecutionType == null : this$weightedExecutionType.equals(other$weightedExecutionType);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof WeightedExecutionPriceConf;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $weightedExecutionType = this.getWeightedExecutionType();
      return result * 59 + ($weightedExecutionType == null ? 43 : $weightedExecutionType.hashCode());
   }

   @Override
   public String toString() {
      return "WeightedExecutionPriceConf(weightedExecutionType=" + this.getWeightedExecutionType() + ")";
   }

   public WeightedExecutionPriceConf(final Integer weightedExecutionType) {
      this.weightedExecutionType = weightedExecutionType;
   }

   public WeightedExecutionPriceConf() {
   }

   public static class WeightedExecutionPriceConfBuilder {
      private Integer weightedExecutionType;

      WeightedExecutionPriceConfBuilder() {
      }

      public WeightedExecutionPriceConf.WeightedExecutionPriceConfBuilder weightedExecutionType(final Integer weightedExecutionType) {
         this.weightedExecutionType = weightedExecutionType;
         return this;
      }

      public WeightedExecutionPriceConf build() {
         return new WeightedExecutionPriceConf(this.weightedExecutionType);
      }

      @Override
      public String toString() {
         return "WeightedExecutionPriceConf.WeightedExecutionPriceConfBuilder(weightedExecutionType=" + this.weightedExecutionType + ")";
      }
   }
}
