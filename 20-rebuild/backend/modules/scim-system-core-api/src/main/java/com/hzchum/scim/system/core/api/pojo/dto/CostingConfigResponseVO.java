package com.hzchum.scim.system.core.api.pojo.dto;

import java.util.Map;

public class CostingConfigResponseVO {
   private Long id;
   private Integer taxType;
   private Integer meteredMethod;
   private Integer fillAmountMethod;
   private Integer fillFactoryMethod;
   private Double errorValue;
   private Double errorPercentage;
   private Map<String, String> measurementUnit;

   public Long getId() {
      return this.id;
   }

   public Integer getTaxType() {
      return this.taxType;
   }

   public Integer getMeteredMethod() {
      return this.meteredMethod;
   }

   public Integer getFillAmountMethod() {
      return this.fillAmountMethod;
   }

   public Integer getFillFactoryMethod() {
      return this.fillFactoryMethod;
   }

   public Double getErrorValue() {
      return this.errorValue;
   }

   public Double getErrorPercentage() {
      return this.errorPercentage;
   }

   public Map<String, String> getMeasurementUnit() {
      return this.measurementUnit;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setTaxType(final Integer taxType) {
      this.taxType = taxType;
   }

   public void setMeteredMethod(final Integer meteredMethod) {
      this.meteredMethod = meteredMethod;
   }

   public void setFillAmountMethod(final Integer fillAmountMethod) {
      this.fillAmountMethod = fillAmountMethod;
   }

   public void setFillFactoryMethod(final Integer fillFactoryMethod) {
      this.fillFactoryMethod = fillFactoryMethod;
   }

   public void setErrorValue(final Double errorValue) {
      this.errorValue = errorValue;
   }

   public void setErrorPercentage(final Double errorPercentage) {
      this.errorPercentage = errorPercentage;
   }

   public void setMeasurementUnit(final Map<String, String> measurementUnit) {
      this.measurementUnit = measurementUnit;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CostingConfigResponseVO)) {
         return false;
      }

      CostingConfigResponseVO other = (CostingConfigResponseVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$taxType = this.getTaxType();
         Object other$taxType = other.getTaxType();
         if (this$taxType == null ? other$taxType == null : this$taxType.equals(other$taxType)) {
            Object this$meteredMethod = this.getMeteredMethod();
            Object other$meteredMethod = other.getMeteredMethod();
            if (this$meteredMethod == null ? other$meteredMethod == null : this$meteredMethod.equals(other$meteredMethod)) {
               Object this$fillAmountMethod = this.getFillAmountMethod();
               Object other$fillAmountMethod = other.getFillAmountMethod();
               if (this$fillAmountMethod == null ? other$fillAmountMethod == null : this$fillAmountMethod.equals(other$fillAmountMethod)) {
                  Object this$fillFactoryMethod = this.getFillFactoryMethod();
                  Object other$fillFactoryMethod = other.getFillFactoryMethod();
                  if (this$fillFactoryMethod == null ? other$fillFactoryMethod == null : this$fillFactoryMethod.equals(other$fillFactoryMethod)) {
                     Object this$errorValue = this.getErrorValue();
                     Object other$errorValue = other.getErrorValue();
                     if (this$errorValue == null ? other$errorValue == null : this$errorValue.equals(other$errorValue)) {
                        Object this$errorPercentage = this.getErrorPercentage();
                        Object other$errorPercentage = other.getErrorPercentage();
                        if (this$errorPercentage == null ? other$errorPercentage == null : this$errorPercentage.equals(other$errorPercentage)) {
                           Object this$measurementUnit = this.getMeasurementUnit();
                           Object other$measurementUnit = other.getMeasurementUnit();
                           return this$measurementUnit == null ? other$measurementUnit == null : this$measurementUnit.equals(other$measurementUnit);
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
      return other instanceof CostingConfigResponseVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $taxType = this.getTaxType();
      result = result * 59 + ($taxType == null ? 43 : $taxType.hashCode());
      Object $meteredMethod = this.getMeteredMethod();
      result = result * 59 + ($meteredMethod == null ? 43 : $meteredMethod.hashCode());
      Object $fillAmountMethod = this.getFillAmountMethod();
      result = result * 59 + ($fillAmountMethod == null ? 43 : $fillAmountMethod.hashCode());
      Object $fillFactoryMethod = this.getFillFactoryMethod();
      result = result * 59 + ($fillFactoryMethod == null ? 43 : $fillFactoryMethod.hashCode());
      Object $errorValue = this.getErrorValue();
      result = result * 59 + ($errorValue == null ? 43 : $errorValue.hashCode());
      Object $errorPercentage = this.getErrorPercentage();
      result = result * 59 + ($errorPercentage == null ? 43 : $errorPercentage.hashCode());
      Object $measurementUnit = this.getMeasurementUnit();
      return result * 59 + ($measurementUnit == null ? 43 : $measurementUnit.hashCode());
   }

   @Override
   public String toString() {
      return "CostingConfigResponseVO(id="
         + this.getId()
         + ", taxType="
         + this.getTaxType()
         + ", meteredMethod="
         + this.getMeteredMethod()
         + ", fillAmountMethod="
         + this.getFillAmountMethod()
         + ", fillFactoryMethod="
         + this.getFillFactoryMethod()
         + ", errorValue="
         + this.getErrorValue()
         + ", errorPercentage="
         + this.getErrorPercentage()
         + ", measurementUnit="
         + this.getMeasurementUnit()
         + ")";
   }
}
