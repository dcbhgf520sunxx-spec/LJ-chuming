package com.hzchum.scim.rest.pojo.vo.wms.wmsConfig;

import java.math.BigDecimal;
import java.util.Map;

public class WarningVORequest {
   private Long id;
   private Long workshopId;
   private Long classifyId;
   private String specification;
   private Map<String, String> specificationMap;
   private String unit;
   private Integer unitType;
   private BigDecimal minimumInventory;

   public Long getId() {
      return this.id;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getSpecification() {
      return this.specification;
   }

   public Map<String, String> getSpecificationMap() {
      return this.specificationMap;
   }

   public String getUnit() {
      return this.unit;
   }

   public Integer getUnitType() {
      return this.unitType;
   }

   public BigDecimal getMinimumInventory() {
      return this.minimumInventory;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setSpecificationMap(final Map<String, String> specificationMap) {
      this.specificationMap = specificationMap;
   }

   public void setUnit(final String unit) {
      this.unit = unit;
   }

   public void setUnitType(final Integer unitType) {
      this.unitType = unitType;
   }

   public void setMinimumInventory(final BigDecimal minimumInventory) {
      this.minimumInventory = minimumInventory;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WarningVORequest)) {
         return false;
      }

      WarningVORequest other = (WarningVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$workshopId = this.getWorkshopId();
         Object other$workshopId = other.getWorkshopId();
         if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
            Object this$classifyId = this.getClassifyId();
            Object other$classifyId = other.getClassifyId();
            if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
               Object this$unitType = this.getUnitType();
               Object other$unitType = other.getUnitType();
               if (this$unitType == null ? other$unitType == null : this$unitType.equals(other$unitType)) {
                  Object this$specification = this.getSpecification();
                  Object other$specification = other.getSpecification();
                  if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                     Object this$specificationMap = this.getSpecificationMap();
                     Object other$specificationMap = other.getSpecificationMap();
                     if (this$specificationMap == null ? other$specificationMap == null : this$specificationMap.equals(other$specificationMap)) {
                        Object this$unit = this.getUnit();
                        Object other$unit = other.getUnit();
                        if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
                           Object this$minimumInventory = this.getMinimumInventory();
                           Object other$minimumInventory = other.getMinimumInventory();
                           return this$minimumInventory == null ? other$minimumInventory == null : this$minimumInventory.equals(other$minimumInventory);
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
      return other instanceof WarningVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $unitType = this.getUnitType();
      result = result * 59 + ($unitType == null ? 43 : $unitType.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $specificationMap = this.getSpecificationMap();
      result = result * 59 + ($specificationMap == null ? 43 : $specificationMap.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $minimumInventory = this.getMinimumInventory();
      return result * 59 + ($minimumInventory == null ? 43 : $minimumInventory.hashCode());
   }

   @Override
   public String toString() {
      return "WarningVORequest(id="
         + this.getId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", classifyId="
         + this.getClassifyId()
         + ", specification="
         + this.getSpecification()
         + ", specificationMap="
         + this.getSpecificationMap()
         + ", unit="
         + this.getUnit()
         + ", unitType="
         + this.getUnitType()
         + ", minimumInventory="
         + this.getMinimumInventory()
         + ")";
   }
}
