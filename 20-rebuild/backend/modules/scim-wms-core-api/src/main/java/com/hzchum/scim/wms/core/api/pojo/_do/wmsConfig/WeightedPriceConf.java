package com.hzchum.scim.wms.core.api.pojo._do.wmsConfig;

public class WeightedPriceConf {
   private Integer weightedType;
   private Boolean boolUpdate;

   public static WeightedPriceConf.WeightedPriceConfBuilder builder() {
      return new WeightedPriceConf.WeightedPriceConfBuilder();
   }

   public Integer getWeightedType() {
      return this.weightedType;
   }

   public Boolean getBoolUpdate() {
      return this.boolUpdate;
   }

   public void setWeightedType(final Integer weightedType) {
      this.weightedType = weightedType;
   }

   public void setBoolUpdate(final Boolean boolUpdate) {
      this.boolUpdate = boolUpdate;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof WeightedPriceConf)) {
         return false;
      } else {
         WeightedPriceConf other = (WeightedPriceConf)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$weightedType = this.getWeightedType();
            Object other$weightedType = other.getWeightedType();
            if (this$weightedType == null ? other$weightedType == null : this$weightedType.equals(other$weightedType)) {
               Object this$boolUpdate = this.getBoolUpdate();
               Object other$boolUpdate = other.getBoolUpdate();
               return this$boolUpdate == null ? other$boolUpdate == null : this$boolUpdate.equals(other$boolUpdate);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof WeightedPriceConf;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $weightedType = this.getWeightedType();
      result = result * 59 + ($weightedType == null ? 43 : $weightedType.hashCode());
      Object $boolUpdate = this.getBoolUpdate();
      return result * 59 + ($boolUpdate == null ? 43 : $boolUpdate.hashCode());
   }

   @Override
   public String toString() {
      return "WeightedPriceConf(weightedType=" + this.getWeightedType() + ", boolUpdate=" + this.getBoolUpdate() + ")";
   }

   public WeightedPriceConf(final Integer weightedType, final Boolean boolUpdate) {
      this.weightedType = weightedType;
      this.boolUpdate = boolUpdate;
   }

   public WeightedPriceConf() {
   }

   public static class WeightedPriceConfBuilder {
      private Integer weightedType;
      private Boolean boolUpdate;

      WeightedPriceConfBuilder() {
      }

      public WeightedPriceConf.WeightedPriceConfBuilder weightedType(final Integer weightedType) {
         this.weightedType = weightedType;
         return this;
      }

      public WeightedPriceConf.WeightedPriceConfBuilder boolUpdate(final Boolean boolUpdate) {
         this.boolUpdate = boolUpdate;
         return this;
      }

      public WeightedPriceConf build() {
         return new WeightedPriceConf(this.weightedType, this.boolUpdate);
      }

      @Override
      public String toString() {
         return "WeightedPriceConf.WeightedPriceConfBuilder(weightedType=" + this.weightedType + ", boolUpdate=" + this.boolUpdate + ")";
      }
   }
}
