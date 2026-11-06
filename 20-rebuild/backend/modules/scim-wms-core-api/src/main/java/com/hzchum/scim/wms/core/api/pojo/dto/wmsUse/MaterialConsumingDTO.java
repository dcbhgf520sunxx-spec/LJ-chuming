package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import java.math.BigDecimal;

public class MaterialConsumingDTO {
   private BigDecimal consumingMete;
   private BigDecimal totalNetWeight;
   private BigDecimal totalGrossWeight;

   public static MaterialConsumingDTO.MaterialConsumingDTOBuilder builder() {
      return new MaterialConsumingDTO.MaterialConsumingDTOBuilder();
   }

   public BigDecimal getConsumingMete() {
      return this.consumingMete;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public void setConsumingMete(final BigDecimal consumingMete) {
      this.consumingMete = consumingMete;
   }

   public void setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
   }

   public void setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MaterialConsumingDTO)) {
         return false;
      }

      MaterialConsumingDTO other = (MaterialConsumingDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$consumingMete = this.getConsumingMete();
      Object other$consumingMete = other.getConsumingMete();
      if (this$consumingMete == null ? other$consumingMete == null : this$consumingMete.equals(other$consumingMete)) {
         Object this$totalNetWeight = this.getTotalNetWeight();
         Object other$totalNetWeight = other.getTotalNetWeight();
         if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
            Object this$totalGrossWeight = this.getTotalGrossWeight();
            Object other$totalGrossWeight = other.getTotalGrossWeight();
            return this$totalGrossWeight == null ? other$totalGrossWeight == null : this$totalGrossWeight.equals(other$totalGrossWeight);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MaterialConsumingDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $consumingMete = this.getConsumingMete();
      result = result * 59 + ($consumingMete == null ? 43 : $consumingMete.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      return result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
   }

   @Override
   public String toString() {
      return "MaterialConsumingDTO(consumingMete="
         + this.getConsumingMete()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ")";
   }

   public MaterialConsumingDTO(final BigDecimal consumingMete, final BigDecimal totalNetWeight, final BigDecimal totalGrossWeight) {
      this.consumingMete = consumingMete;
      this.totalNetWeight = totalNetWeight;
      this.totalGrossWeight = totalGrossWeight;
   }

   public MaterialConsumingDTO() {
   }

   public static class MaterialConsumingDTOBuilder {
      private BigDecimal consumingMete;
      private BigDecimal totalNetWeight;
      private BigDecimal totalGrossWeight;

      MaterialConsumingDTOBuilder() {
      }

      public MaterialConsumingDTO.MaterialConsumingDTOBuilder consumingMete(final BigDecimal consumingMete) {
         this.consumingMete = consumingMete;
         return this;
      }

      public MaterialConsumingDTO.MaterialConsumingDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      public MaterialConsumingDTO.MaterialConsumingDTOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      public MaterialConsumingDTO build() {
         return new MaterialConsumingDTO(this.consumingMete, this.totalNetWeight, this.totalGrossWeight);
      }

      @Override
      public String toString() {
         return "MaterialConsumingDTO.MaterialConsumingDTOBuilder(consumingMete="
            + this.consumingMete
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ")";
      }
   }
}
