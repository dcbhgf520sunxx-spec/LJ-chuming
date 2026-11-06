package com.hzchum.scim.business.core.api.pojo.dto;

import java.math.BigDecimal;

public class SummaryPriceDTO {
   private BigDecimal projectPrice;
   private BigDecimal monomerPrice;
   private BigDecimal areaPrice;
   private BigDecimal shipPrice;

   SummaryPriceDTO(final BigDecimal projectPrice, final BigDecimal monomerPrice, final BigDecimal areaPrice, final BigDecimal shipPrice) {
      this.projectPrice = projectPrice;
      this.monomerPrice = monomerPrice;
      this.areaPrice = areaPrice;
      this.shipPrice = shipPrice;
   }

   public static SummaryPriceDTO.SummaryPriceDTOBuilder builder() {
      return new SummaryPriceDTO.SummaryPriceDTOBuilder();
   }

   public BigDecimal getProjectPrice() {
      return this.projectPrice;
   }

   public BigDecimal getMonomerPrice() {
      return this.monomerPrice;
   }

   public BigDecimal getAreaPrice() {
      return this.areaPrice;
   }

   public BigDecimal getShipPrice() {
      return this.shipPrice;
   }

   public void setProjectPrice(final BigDecimal projectPrice) {
      this.projectPrice = projectPrice;
   }

   public void setMonomerPrice(final BigDecimal monomerPrice) {
      this.monomerPrice = monomerPrice;
   }

   public void setAreaPrice(final BigDecimal areaPrice) {
      this.areaPrice = areaPrice;
   }

   public void setShipPrice(final BigDecimal shipPrice) {
      this.shipPrice = shipPrice;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SummaryPriceDTO)) {
         return false;
      }

      SummaryPriceDTO other = (SummaryPriceDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectPrice = this.getProjectPrice();
      Object other$projectPrice = other.getProjectPrice();
      if (this$projectPrice == null ? other$projectPrice == null : this$projectPrice.equals(other$projectPrice)) {
         Object this$monomerPrice = this.getMonomerPrice();
         Object other$monomerPrice = other.getMonomerPrice();
         if (this$monomerPrice == null ? other$monomerPrice == null : this$monomerPrice.equals(other$monomerPrice)) {
            Object this$areaPrice = this.getAreaPrice();
            Object other$areaPrice = other.getAreaPrice();
            if (this$areaPrice == null ? other$areaPrice == null : this$areaPrice.equals(other$areaPrice)) {
               Object this$shipPrice = this.getShipPrice();
               Object other$shipPrice = other.getShipPrice();
               return this$shipPrice == null ? other$shipPrice == null : this$shipPrice.equals(other$shipPrice);
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
      return other instanceof SummaryPriceDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectPrice = this.getProjectPrice();
      result = result * 59 + ($projectPrice == null ? 43 : $projectPrice.hashCode());
      Object $monomerPrice = this.getMonomerPrice();
      result = result * 59 + ($monomerPrice == null ? 43 : $monomerPrice.hashCode());
      Object $areaPrice = this.getAreaPrice();
      result = result * 59 + ($areaPrice == null ? 43 : $areaPrice.hashCode());
      Object $shipPrice = this.getShipPrice();
      return result * 59 + ($shipPrice == null ? 43 : $shipPrice.hashCode());
   }

   @Override
   public String toString() {
      return "SummaryPriceDTO(projectPrice="
         + this.getProjectPrice()
         + ", monomerPrice="
         + this.getMonomerPrice()
         + ", areaPrice="
         + this.getAreaPrice()
         + ", shipPrice="
         + this.getShipPrice()
         + ")";
   }

   public static class SummaryPriceDTOBuilder {
      private BigDecimal projectPrice;
      private BigDecimal monomerPrice;
      private BigDecimal areaPrice;
      private BigDecimal shipPrice;

      SummaryPriceDTOBuilder() {
      }

      public SummaryPriceDTO.SummaryPriceDTOBuilder projectPrice(final BigDecimal projectPrice) {
         this.projectPrice = projectPrice;
         return this;
      }

      public SummaryPriceDTO.SummaryPriceDTOBuilder monomerPrice(final BigDecimal monomerPrice) {
         this.monomerPrice = monomerPrice;
         return this;
      }

      public SummaryPriceDTO.SummaryPriceDTOBuilder areaPrice(final BigDecimal areaPrice) {
         this.areaPrice = areaPrice;
         return this;
      }

      public SummaryPriceDTO.SummaryPriceDTOBuilder shipPrice(final BigDecimal shipPrice) {
         this.shipPrice = shipPrice;
         return this;
      }

      public SummaryPriceDTO build() {
         return new SummaryPriceDTO(this.projectPrice, this.monomerPrice, this.areaPrice, this.shipPrice);
      }

      @Override
      public String toString() {
         return "SummaryPriceDTO.SummaryPriceDTOBuilder(projectPrice="
            + this.projectPrice
            + ", monomerPrice="
            + this.monomerPrice
            + ", areaPrice="
            + this.areaPrice
            + ", shipPrice="
            + this.shipPrice
            + ")";
      }
   }
}
