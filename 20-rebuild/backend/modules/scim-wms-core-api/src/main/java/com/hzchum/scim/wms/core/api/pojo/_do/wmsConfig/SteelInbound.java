package com.hzchum.scim.wms.core.api.pojo._do.wmsConfig;

import java.math.BigDecimal;

public class SteelInbound {
   private Integer steelDiffType;
   private BigDecimal steelDiff;
   private Integer trainsDiffType;
   private BigDecimal trainsDiff;
   private Boolean overDiffSubmittable;

   public static SteelInbound.SteelInboundBuilder builder() {
      return new SteelInbound.SteelInboundBuilder();
   }

   public Integer getSteelDiffType() {
      return this.steelDiffType;
   }

   public BigDecimal getSteelDiff() {
      return this.steelDiff;
   }

   public Integer getTrainsDiffType() {
      return this.trainsDiffType;
   }

   public BigDecimal getTrainsDiff() {
      return this.trainsDiff;
   }

   public Boolean getOverDiffSubmittable() {
      return this.overDiffSubmittable;
   }

   public void setSteelDiffType(final Integer steelDiffType) {
      this.steelDiffType = steelDiffType;
   }

   public void setSteelDiff(final BigDecimal steelDiff) {
      this.steelDiff = steelDiff;
   }

   public void setTrainsDiffType(final Integer trainsDiffType) {
      this.trainsDiffType = trainsDiffType;
   }

   public void setTrainsDiff(final BigDecimal trainsDiff) {
      this.trainsDiff = trainsDiff;
   }

   public void setOverDiffSubmittable(final Boolean overDiffSubmittable) {
      this.overDiffSubmittable = overDiffSubmittable;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SteelInbound)) {
         return false;
      }

      SteelInbound other = (SteelInbound)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$steelDiffType = this.getSteelDiffType();
      Object other$steelDiffType = other.getSteelDiffType();
      if (this$steelDiffType == null ? other$steelDiffType == null : this$steelDiffType.equals(other$steelDiffType)) {
         Object this$trainsDiffType = this.getTrainsDiffType();
         Object other$trainsDiffType = other.getTrainsDiffType();
         if (this$trainsDiffType == null ? other$trainsDiffType == null : this$trainsDiffType.equals(other$trainsDiffType)) {
            Object this$overDiffSubmittable = this.getOverDiffSubmittable();
            Object other$overDiffSubmittable = other.getOverDiffSubmittable();
            if (this$overDiffSubmittable == null ? other$overDiffSubmittable == null : this$overDiffSubmittable.equals(other$overDiffSubmittable)) {
               Object this$steelDiff = this.getSteelDiff();
               Object other$steelDiff = other.getSteelDiff();
               if (this$steelDiff == null ? other$steelDiff == null : this$steelDiff.equals(other$steelDiff)) {
                  Object this$trainsDiff = this.getTrainsDiff();
                  Object other$trainsDiff = other.getTrainsDiff();
                  return this$trainsDiff == null ? other$trainsDiff == null : this$trainsDiff.equals(other$trainsDiff);
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
      return other instanceof SteelInbound;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $steelDiffType = this.getSteelDiffType();
      result = result * 59 + ($steelDiffType == null ? 43 : $steelDiffType.hashCode());
      Object $trainsDiffType = this.getTrainsDiffType();
      result = result * 59 + ($trainsDiffType == null ? 43 : $trainsDiffType.hashCode());
      Object $overDiffSubmittable = this.getOverDiffSubmittable();
      result = result * 59 + ($overDiffSubmittable == null ? 43 : $overDiffSubmittable.hashCode());
      Object $steelDiff = this.getSteelDiff();
      result = result * 59 + ($steelDiff == null ? 43 : $steelDiff.hashCode());
      Object $trainsDiff = this.getTrainsDiff();
      return result * 59 + ($trainsDiff == null ? 43 : $trainsDiff.hashCode());
   }

   @Override
   public String toString() {
      return "SteelInbound(steelDiffType="
         + this.getSteelDiffType()
         + ", steelDiff="
         + this.getSteelDiff()
         + ", trainsDiffType="
         + this.getTrainsDiffType()
         + ", trainsDiff="
         + this.getTrainsDiff()
         + ", overDiffSubmittable="
         + this.getOverDiffSubmittable()
         + ")";
   }

   public SteelInbound(
      final Integer steelDiffType, final BigDecimal steelDiff, final Integer trainsDiffType, final BigDecimal trainsDiff, final Boolean overDiffSubmittable
   ) {
      this.steelDiffType = steelDiffType;
      this.steelDiff = steelDiff;
      this.trainsDiffType = trainsDiffType;
      this.trainsDiff = trainsDiff;
      this.overDiffSubmittable = overDiffSubmittable;
   }

   public SteelInbound() {
   }

   public static class SteelInboundBuilder {
      private Integer steelDiffType;
      private BigDecimal steelDiff;
      private Integer trainsDiffType;
      private BigDecimal trainsDiff;
      private Boolean overDiffSubmittable;

      SteelInboundBuilder() {
      }

      public SteelInbound.SteelInboundBuilder steelDiffType(final Integer steelDiffType) {
         this.steelDiffType = steelDiffType;
         return this;
      }

      public SteelInbound.SteelInboundBuilder steelDiff(final BigDecimal steelDiff) {
         this.steelDiff = steelDiff;
         return this;
      }

      public SteelInbound.SteelInboundBuilder trainsDiffType(final Integer trainsDiffType) {
         this.trainsDiffType = trainsDiffType;
         return this;
      }

      public SteelInbound.SteelInboundBuilder trainsDiff(final BigDecimal trainsDiff) {
         this.trainsDiff = trainsDiff;
         return this;
      }

      public SteelInbound.SteelInboundBuilder overDiffSubmittable(final Boolean overDiffSubmittable) {
         this.overDiffSubmittable = overDiffSubmittable;
         return this;
      }

      public SteelInbound build() {
         return new SteelInbound(this.steelDiffType, this.steelDiff, this.trainsDiffType, this.trainsDiff, this.overDiffSubmittable);
      }

      @Override
      public String toString() {
         return "SteelInbound.SteelInboundBuilder(steelDiffType="
            + this.steelDiffType
            + ", steelDiff="
            + this.steelDiff
            + ", trainsDiffType="
            + this.trainsDiffType
            + ", trainsDiff="
            + this.trainsDiff
            + ", overDiffSubmittable="
            + this.overDiffSubmittable
            + ")";
      }
   }
}
