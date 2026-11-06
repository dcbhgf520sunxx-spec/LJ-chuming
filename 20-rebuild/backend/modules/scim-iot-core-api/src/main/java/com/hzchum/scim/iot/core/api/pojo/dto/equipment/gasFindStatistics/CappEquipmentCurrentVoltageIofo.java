package com.hzchum.scim.iot.core.api.pojo.dto.equipment.gasFindStatistics;

import java.math.BigDecimal;

public class CappEquipmentCurrentVoltageIofo {
   private BigDecimal currentWeldElectric;
   private BigDecimal currentWeldVoltage;

   public static CappEquipmentCurrentVoltageIofo.CappEquipmentCurrentVoltageIofoBuilder builder() {
      return new CappEquipmentCurrentVoltageIofo.CappEquipmentCurrentVoltageIofoBuilder();
   }

   public BigDecimal getCurrentWeldElectric() {
      return this.currentWeldElectric;
   }

   public BigDecimal getCurrentWeldVoltage() {
      return this.currentWeldVoltage;
   }

   public void setCurrentWeldElectric(final BigDecimal currentWeldElectric) {
      this.currentWeldElectric = currentWeldElectric;
   }

   public void setCurrentWeldVoltage(final BigDecimal currentWeldVoltage) {
      this.currentWeldVoltage = currentWeldVoltage;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof CappEquipmentCurrentVoltageIofo)) {
         return false;
      } else {
         CappEquipmentCurrentVoltageIofo other = (CappEquipmentCurrentVoltageIofo)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$currentWeldElectric = this.getCurrentWeldElectric();
            Object other$currentWeldElectric = other.getCurrentWeldElectric();
            if (this$currentWeldElectric == null ? other$currentWeldElectric == null : this$currentWeldElectric.equals(other$currentWeldElectric)) {
               Object this$currentWeldVoltage = this.getCurrentWeldVoltage();
               Object other$currentWeldVoltage = other.getCurrentWeldVoltage();
               return this$currentWeldVoltage == null ? other$currentWeldVoltage == null : this$currentWeldVoltage.equals(other$currentWeldVoltage);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CappEquipmentCurrentVoltageIofo;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $currentWeldElectric = this.getCurrentWeldElectric();
      result = result * 59 + ($currentWeldElectric == null ? 43 : $currentWeldElectric.hashCode());
      Object $currentWeldVoltage = this.getCurrentWeldVoltage();
      return result * 59 + ($currentWeldVoltage == null ? 43 : $currentWeldVoltage.hashCode());
   }

   @Override
   public String toString() {
      return "CappEquipmentCurrentVoltageIofo(currentWeldElectric="
         + this.getCurrentWeldElectric()
         + ", currentWeldVoltage="
         + this.getCurrentWeldVoltage()
         + ")";
   }

   public CappEquipmentCurrentVoltageIofo(final BigDecimal currentWeldElectric, final BigDecimal currentWeldVoltage) {
      this.currentWeldElectric = currentWeldElectric;
      this.currentWeldVoltage = currentWeldVoltage;
   }

   public CappEquipmentCurrentVoltageIofo() {
   }

   public static class CappEquipmentCurrentVoltageIofoBuilder {
      private BigDecimal currentWeldElectric;
      private BigDecimal currentWeldVoltage;

      CappEquipmentCurrentVoltageIofoBuilder() {
      }

      public CappEquipmentCurrentVoltageIofo.CappEquipmentCurrentVoltageIofoBuilder currentWeldElectric(final BigDecimal currentWeldElectric) {
         this.currentWeldElectric = currentWeldElectric;
         return this;
      }

      public CappEquipmentCurrentVoltageIofo.CappEquipmentCurrentVoltageIofoBuilder currentWeldVoltage(final BigDecimal currentWeldVoltage) {
         this.currentWeldVoltage = currentWeldVoltage;
         return this;
      }

      public CappEquipmentCurrentVoltageIofo build() {
         return new CappEquipmentCurrentVoltageIofo(this.currentWeldElectric, this.currentWeldVoltage);
      }

      @Override
      public String toString() {
         return "CappEquipmentCurrentVoltageIofo.CappEquipmentCurrentVoltageIofoBuilder(currentWeldElectric="
            + this.currentWeldElectric
            + ", currentWeldVoltage="
            + this.currentWeldVoltage
            + ")";
      }
   }
}
