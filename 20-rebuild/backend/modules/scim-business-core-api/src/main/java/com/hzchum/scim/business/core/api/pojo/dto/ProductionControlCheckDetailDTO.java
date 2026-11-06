package com.hzchum.scim.business.core.api.pojo.dto;

import java.math.BigDecimal;

public class ProductionControlCheckDetailDTO {
   private Long id;
   private String name;
   private String specification;
   private String material;
   private String unit;
   private Integer quantity;
   private Boolean oldBoolEnableEnum;
   private Boolean newBoolEnableEnum;
   private BigDecimal oldLossFactor;
   private BigDecimal newLossFactor;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getUnit() {
      return this.unit;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Boolean getOldBoolEnableEnum() {
      return this.oldBoolEnableEnum;
   }

   public Boolean getNewBoolEnableEnum() {
      return this.newBoolEnableEnum;
   }

   public BigDecimal getOldLossFactor() {
      return this.oldLossFactor;
   }

   public BigDecimal getNewLossFactor() {
      return this.newLossFactor;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setUnit(final String unit) {
      this.unit = unit;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setOldBoolEnableEnum(final Boolean oldBoolEnableEnum) {
      this.oldBoolEnableEnum = oldBoolEnableEnum;
   }

   public void setNewBoolEnableEnum(final Boolean newBoolEnableEnum) {
      this.newBoolEnableEnum = newBoolEnableEnum;
   }

   public void setOldLossFactor(final BigDecimal oldLossFactor) {
      this.oldLossFactor = oldLossFactor;
   }

   public void setNewLossFactor(final BigDecimal newLossFactor) {
      this.newLossFactor = newLossFactor;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductionControlCheckDetailDTO)) {
         return false;
      }

      ProductionControlCheckDetailDTO other = (ProductionControlCheckDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$oldBoolEnableEnum = this.getOldBoolEnableEnum();
            Object other$oldBoolEnableEnum = other.getOldBoolEnableEnum();
            if (this$oldBoolEnableEnum == null ? other$oldBoolEnableEnum == null : this$oldBoolEnableEnum.equals(other$oldBoolEnableEnum)) {
               Object this$newBoolEnableEnum = this.getNewBoolEnableEnum();
               Object other$newBoolEnableEnum = other.getNewBoolEnableEnum();
               if (this$newBoolEnableEnum == null ? other$newBoolEnableEnum == null : this$newBoolEnableEnum.equals(other$newBoolEnableEnum)) {
                  Object this$name = this.getName();
                  Object other$name = other.getName();
                  if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                     Object this$specification = this.getSpecification();
                     Object other$specification = other.getSpecification();
                     if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                        Object this$material = this.getMaterial();
                        Object other$material = other.getMaterial();
                        if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                           Object this$unit = this.getUnit();
                           Object other$unit = other.getUnit();
                           if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
                              Object this$oldLossFactor = this.getOldLossFactor();
                              Object other$oldLossFactor = other.getOldLossFactor();
                              if (this$oldLossFactor == null ? other$oldLossFactor == null : this$oldLossFactor.equals(other$oldLossFactor)) {
                                 Object this$newLossFactor = this.getNewLossFactor();
                                 Object other$newLossFactor = other.getNewLossFactor();
                                 return this$newLossFactor == null ? other$newLossFactor == null : this$newLossFactor.equals(other$newLossFactor);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProductionControlCheckDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $oldBoolEnableEnum = this.getOldBoolEnableEnum();
      result = result * 59 + ($oldBoolEnableEnum == null ? 43 : $oldBoolEnableEnum.hashCode());
      Object $newBoolEnableEnum = this.getNewBoolEnableEnum();
      result = result * 59 + ($newBoolEnableEnum == null ? 43 : $newBoolEnableEnum.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $oldLossFactor = this.getOldLossFactor();
      result = result * 59 + ($oldLossFactor == null ? 43 : $oldLossFactor.hashCode());
      Object $newLossFactor = this.getNewLossFactor();
      return result * 59 + ($newLossFactor == null ? 43 : $newLossFactor.hashCode());
   }

   @Override
   public String toString() {
      return "ProductionControlCheckDetailDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", unit="
         + this.getUnit()
         + ", quantity="
         + this.getQuantity()
         + ", oldBoolEnableEnum="
         + this.getOldBoolEnableEnum()
         + ", newBoolEnableEnum="
         + this.getNewBoolEnableEnum()
         + ", oldLossFactor="
         + this.getOldLossFactor()
         + ", newLossFactor="
         + this.getNewLossFactor()
         + ")";
   }
}
