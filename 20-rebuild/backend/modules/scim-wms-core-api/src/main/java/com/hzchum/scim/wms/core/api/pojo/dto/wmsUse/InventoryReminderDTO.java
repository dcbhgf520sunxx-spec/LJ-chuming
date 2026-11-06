package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import java.math.BigDecimal;

public class InventoryReminderDTO {
   private BigDecimal inventory;
   private BigDecimal minimumInventory;
   private Integer unitType;
   private Integer basicClass;
   private Long classifyId;
   private String specification;
   private Long workshopId;
   private String classifyCode;
   private String classifyName;
   private String unit;

   public static InventoryReminderDTO.InventoryReminderDTOBuilder builder() {
      return new InventoryReminderDTO.InventoryReminderDTOBuilder();
   }

   public BigDecimal getInventory() {
      return this.inventory;
   }

   public BigDecimal getMinimumInventory() {
      return this.minimumInventory;
   }

   public Integer getUnitType() {
      return this.unitType;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getSpecification() {
      return this.specification;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public String getClassifyCode() {
      return this.classifyCode;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public String getUnit() {
      return this.unit;
   }

   public void setInventory(final BigDecimal inventory) {
      this.inventory = inventory;
   }

   public void setMinimumInventory(final BigDecimal minimumInventory) {
      this.minimumInventory = minimumInventory;
   }

   public void setUnitType(final Integer unitType) {
      this.unitType = unitType;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setClassifyCode(final String classifyCode) {
      this.classifyCode = classifyCode;
   }

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   public void setUnit(final String unit) {
      this.unit = unit;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InventoryReminderDTO)) {
         return false;
      }

      InventoryReminderDTO other = (InventoryReminderDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$unitType = this.getUnitType();
      Object other$unitType = other.getUnitType();
      if (this$unitType == null ? other$unitType == null : this$unitType.equals(other$unitType)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$classifyId = this.getClassifyId();
            Object other$classifyId = other.getClassifyId();
            if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
               Object this$workshopId = this.getWorkshopId();
               Object other$workshopId = other.getWorkshopId();
               if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                  Object this$inventory = this.getInventory();
                  Object other$inventory = other.getInventory();
                  if (this$inventory == null ? other$inventory == null : this$inventory.equals(other$inventory)) {
                     Object this$minimumInventory = this.getMinimumInventory();
                     Object other$minimumInventory = other.getMinimumInventory();
                     if (this$minimumInventory == null ? other$minimumInventory == null : this$minimumInventory.equals(other$minimumInventory)) {
                        Object this$specification = this.getSpecification();
                        Object other$specification = other.getSpecification();
                        if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                           Object this$classifyCode = this.getClassifyCode();
                           Object other$classifyCode = other.getClassifyCode();
                           if (this$classifyCode == null ? other$classifyCode == null : this$classifyCode.equals(other$classifyCode)) {
                              Object this$classifyName = this.getClassifyName();
                              Object other$classifyName = other.getClassifyName();
                              if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
                                 Object this$unit = this.getUnit();
                                 Object other$unit = other.getUnit();
                                 return this$unit == null ? other$unit == null : this$unit.equals(other$unit);
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
      return other instanceof InventoryReminderDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $unitType = this.getUnitType();
      result = result * 59 + ($unitType == null ? 43 : $unitType.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $inventory = this.getInventory();
      result = result * 59 + ($inventory == null ? 43 : $inventory.hashCode());
      Object $minimumInventory = this.getMinimumInventory();
      result = result * 59 + ($minimumInventory == null ? 43 : $minimumInventory.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $classifyCode = this.getClassifyCode();
      result = result * 59 + ($classifyCode == null ? 43 : $classifyCode.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $unit = this.getUnit();
      return result * 59 + ($unit == null ? 43 : $unit.hashCode());
   }

   @Override
   public String toString() {
      return "InventoryReminderDTO(inventory="
         + this.getInventory()
         + ", minimumInventory="
         + this.getMinimumInventory()
         + ", unitType="
         + this.getUnitType()
         + ", basicClass="
         + this.getBasicClass()
         + ", classifyId="
         + this.getClassifyId()
         + ", specification="
         + this.getSpecification()
         + ", workshopId="
         + this.getWorkshopId()
         + ", classifyCode="
         + this.getClassifyCode()
         + ", classifyName="
         + this.getClassifyName()
         + ", unit="
         + this.getUnit()
         + ")";
   }

   public InventoryReminderDTO(
      final BigDecimal inventory,
      final BigDecimal minimumInventory,
      final Integer unitType,
      final Integer basicClass,
      final Long classifyId,
      final String specification,
      final Long workshopId,
      final String classifyCode,
      final String classifyName,
      final String unit
   ) {
      this.inventory = inventory;
      this.minimumInventory = minimumInventory;
      this.unitType = unitType;
      this.basicClass = basicClass;
      this.classifyId = classifyId;
      this.specification = specification;
      this.workshopId = workshopId;
      this.classifyCode = classifyCode;
      this.classifyName = classifyName;
      this.unit = unit;
   }

   public InventoryReminderDTO() {
   }

   public static class InventoryReminderDTOBuilder {
      private BigDecimal inventory;
      private BigDecimal minimumInventory;
      private Integer unitType;
      private Integer basicClass;
      private Long classifyId;
      private String specification;
      private Long workshopId;
      private String classifyCode;
      private String classifyName;
      private String unit;

      InventoryReminderDTOBuilder() {
      }

      public InventoryReminderDTO.InventoryReminderDTOBuilder inventory(final BigDecimal inventory) {
         this.inventory = inventory;
         return this;
      }

      public InventoryReminderDTO.InventoryReminderDTOBuilder minimumInventory(final BigDecimal minimumInventory) {
         this.minimumInventory = minimumInventory;
         return this;
      }

      public InventoryReminderDTO.InventoryReminderDTOBuilder unitType(final Integer unitType) {
         this.unitType = unitType;
         return this;
      }

      public InventoryReminderDTO.InventoryReminderDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public InventoryReminderDTO.InventoryReminderDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public InventoryReminderDTO.InventoryReminderDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public InventoryReminderDTO.InventoryReminderDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public InventoryReminderDTO.InventoryReminderDTOBuilder classifyCode(final String classifyCode) {
         this.classifyCode = classifyCode;
         return this;
      }

      public InventoryReminderDTO.InventoryReminderDTOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public InventoryReminderDTO.InventoryReminderDTOBuilder unit(final String unit) {
         this.unit = unit;
         return this;
      }

      public InventoryReminderDTO build() {
         return new InventoryReminderDTO(
            this.inventory,
            this.minimumInventory,
            this.unitType,
            this.basicClass,
            this.classifyId,
            this.specification,
            this.workshopId,
            this.classifyCode,
            this.classifyName,
            this.unit
         );
      }

      @Override
      public String toString() {
         return "InventoryReminderDTO.InventoryReminderDTOBuilder(inventory="
            + this.inventory
            + ", minimumInventory="
            + this.minimumInventory
            + ", unitType="
            + this.unitType
            + ", basicClass="
            + this.basicClass
            + ", classifyId="
            + this.classifyId
            + ", specification="
            + this.specification
            + ", workshopId="
            + this.workshopId
            + ", classifyCode="
            + this.classifyCode
            + ", classifyName="
            + this.classifyName
            + ", unit="
            + this.unit
            + ")";
      }
   }
}
