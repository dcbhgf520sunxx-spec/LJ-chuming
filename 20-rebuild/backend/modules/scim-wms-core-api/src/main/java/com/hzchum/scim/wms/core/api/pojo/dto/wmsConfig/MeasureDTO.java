package com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig;

import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Measure;

public class MeasureDTO extends Measure {
   private String unitSymbol;
   private Integer unitType;
   private Boolean unitBoolSystem;

   public String getUnitSymbol() {
      return this.unitSymbol;
   }

   public Integer getUnitType() {
      return this.unitType;
   }

   public Boolean getUnitBoolSystem() {
      return this.unitBoolSystem;
   }

   public void setUnitSymbol(final String unitSymbol) {
      this.unitSymbol = unitSymbol;
   }

   public void setUnitType(final Integer unitType) {
      this.unitType = unitType;
   }

   public void setUnitBoolSystem(final Boolean unitBoolSystem) {
      this.unitBoolSystem = unitBoolSystem;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MeasureDTO)) {
         return false;
      }

      MeasureDTO other = (MeasureDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$unitType = this.getUnitType();
      Object other$unitType = other.getUnitType();
      if (this$unitType == null ? other$unitType == null : this$unitType.equals(other$unitType)) {
         Object this$unitBoolSystem = this.getUnitBoolSystem();
         Object other$unitBoolSystem = other.getUnitBoolSystem();
         if (this$unitBoolSystem == null ? other$unitBoolSystem == null : this$unitBoolSystem.equals(other$unitBoolSystem)) {
            Object this$unitSymbol = this.getUnitSymbol();
            Object other$unitSymbol = other.getUnitSymbol();
            return this$unitSymbol == null ? other$unitSymbol == null : this$unitSymbol.equals(other$unitSymbol);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MeasureDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $unitType = this.getUnitType();
      result = result * 59 + ($unitType == null ? 43 : $unitType.hashCode());
      Object $unitBoolSystem = this.getUnitBoolSystem();
      result = result * 59 + ($unitBoolSystem == null ? 43 : $unitBoolSystem.hashCode());
      Object $unitSymbol = this.getUnitSymbol();
      return result * 59 + ($unitSymbol == null ? 43 : $unitSymbol.hashCode());
   }

   @Override
   public String toString() {
      return "MeasureDTO(unitSymbol=" + this.getUnitSymbol() + ", unitType=" + this.getUnitType() + ", unitBoolSystem=" + this.getUnitBoolSystem() + ")";
   }

   public MeasureDTO(final String unitSymbol, final Integer unitType, final Boolean unitBoolSystem) {
      this.unitSymbol = unitSymbol;
      this.unitType = unitType;
      this.unitBoolSystem = unitBoolSystem;
   }

   public MeasureDTO() {
   }
}
