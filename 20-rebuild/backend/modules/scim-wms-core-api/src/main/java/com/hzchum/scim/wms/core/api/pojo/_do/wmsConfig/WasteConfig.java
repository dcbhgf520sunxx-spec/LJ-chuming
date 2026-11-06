package com.hzchum.scim.wms.core.api.pojo._do.wmsConfig;

import java.math.BigDecimal;

public class WasteConfig {
   private BigDecimal steelPlateShortestSideMinLength;
   private BigDecimal sectionSteelMinLength;
   private BigDecimal steelCoilMinLength;

   public static WasteConfig.WasteConfigBuilder builder() {
      return new WasteConfig.WasteConfigBuilder();
   }

   public BigDecimal getSteelPlateShortestSideMinLength() {
      return this.steelPlateShortestSideMinLength;
   }

   public BigDecimal getSectionSteelMinLength() {
      return this.sectionSteelMinLength;
   }

   public BigDecimal getSteelCoilMinLength() {
      return this.steelCoilMinLength;
   }

   public void setSteelPlateShortestSideMinLength(final BigDecimal steelPlateShortestSideMinLength) {
      this.steelPlateShortestSideMinLength = steelPlateShortestSideMinLength;
   }

   public void setSectionSteelMinLength(final BigDecimal sectionSteelMinLength) {
      this.sectionSteelMinLength = sectionSteelMinLength;
   }

   public void setSteelCoilMinLength(final BigDecimal steelCoilMinLength) {
      this.steelCoilMinLength = steelCoilMinLength;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WasteConfig)) {
         return false;
      }

      WasteConfig other = (WasteConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$steelPlateShortestSideMinLength = this.getSteelPlateShortestSideMinLength();
      Object other$steelPlateShortestSideMinLength = other.getSteelPlateShortestSideMinLength();
      if (this$steelPlateShortestSideMinLength == null
         ? other$steelPlateShortestSideMinLength == null
         : this$steelPlateShortestSideMinLength.equals(other$steelPlateShortestSideMinLength)) {
         Object this$sectionSteelMinLength = this.getSectionSteelMinLength();
         Object other$sectionSteelMinLength = other.getSectionSteelMinLength();
         if (this$sectionSteelMinLength == null ? other$sectionSteelMinLength == null : this$sectionSteelMinLength.equals(other$sectionSteelMinLength)) {
            Object this$steelCoilMinLength = this.getSteelCoilMinLength();
            Object other$steelCoilMinLength = other.getSteelCoilMinLength();
            return this$steelCoilMinLength == null ? other$steelCoilMinLength == null : this$steelCoilMinLength.equals(other$steelCoilMinLength);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof WasteConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $steelPlateShortestSideMinLength = this.getSteelPlateShortestSideMinLength();
      result = result * 59 + ($steelPlateShortestSideMinLength == null ? 43 : $steelPlateShortestSideMinLength.hashCode());
      Object $sectionSteelMinLength = this.getSectionSteelMinLength();
      result = result * 59 + ($sectionSteelMinLength == null ? 43 : $sectionSteelMinLength.hashCode());
      Object $steelCoilMinLength = this.getSteelCoilMinLength();
      return result * 59 + ($steelCoilMinLength == null ? 43 : $steelCoilMinLength.hashCode());
   }

   @Override
   public String toString() {
      return "WasteConfig(steelPlateShortestSideMinLength="
         + this.getSteelPlateShortestSideMinLength()
         + ", sectionSteelMinLength="
         + this.getSectionSteelMinLength()
         + ", steelCoilMinLength="
         + this.getSteelCoilMinLength()
         + ")";
   }

   public WasteConfig(final BigDecimal steelPlateShortestSideMinLength, final BigDecimal sectionSteelMinLength, final BigDecimal steelCoilMinLength) {
      this.steelPlateShortestSideMinLength = steelPlateShortestSideMinLength;
      this.sectionSteelMinLength = sectionSteelMinLength;
      this.steelCoilMinLength = steelCoilMinLength;
   }

   public WasteConfig() {
   }

   public static class WasteConfigBuilder {
      private BigDecimal steelPlateShortestSideMinLength;
      private BigDecimal sectionSteelMinLength;
      private BigDecimal steelCoilMinLength;

      WasteConfigBuilder() {
      }

      public WasteConfig.WasteConfigBuilder steelPlateShortestSideMinLength(final BigDecimal steelPlateShortestSideMinLength) {
         this.steelPlateShortestSideMinLength = steelPlateShortestSideMinLength;
         return this;
      }

      public WasteConfig.WasteConfigBuilder sectionSteelMinLength(final BigDecimal sectionSteelMinLength) {
         this.sectionSteelMinLength = sectionSteelMinLength;
         return this;
      }

      public WasteConfig.WasteConfigBuilder steelCoilMinLength(final BigDecimal steelCoilMinLength) {
         this.steelCoilMinLength = steelCoilMinLength;
         return this;
      }

      public WasteConfig build() {
         return new WasteConfig(this.steelPlateShortestSideMinLength, this.sectionSteelMinLength, this.steelCoilMinLength);
      }

      @Override
      public String toString() {
         return "WasteConfig.WasteConfigBuilder(steelPlateShortestSideMinLength="
            + this.steelPlateShortestSideMinLength
            + ", sectionSteelMinLength="
            + this.sectionSteelMinLength
            + ", steelCoilMinLength="
            + this.steelCoilMinLength
            + ")";
      }
   }
}
