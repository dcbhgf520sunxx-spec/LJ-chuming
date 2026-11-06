package com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig;

import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class WarningDTO {
   private Long id;
   private String serialNumber;
   private BriefIdAndNameDTO workshop;
   private Long classifyId;
   private String specification;
   private String unit;
   private Integer unitType;
   private BigDecimal minimumInventory;
   private Boolean enabled;
   private LocalDateTime createTime;
   private LocalDateTime updateTime;

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public BriefIdAndNameDTO getWorkshop() {
      return this.workshop;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getSpecification() {
      return this.specification;
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

   public Boolean getEnabled() {
      return this.enabled;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public LocalDateTime getUpdateTime() {
      return this.updateTime;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setWorkshop(final BriefIdAndNameDTO workshop) {
      this.workshop = workshop;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
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

   public void setEnabled(final Boolean enabled) {
      this.enabled = enabled;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setUpdateTime(final LocalDateTime updateTime) {
      this.updateTime = updateTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WarningDTO)) {
         return false;
      }

      WarningDTO other = (WarningDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$classifyId = this.getClassifyId();
         Object other$classifyId = other.getClassifyId();
         if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
            Object this$unitType = this.getUnitType();
            Object other$unitType = other.getUnitType();
            if (this$unitType == null ? other$unitType == null : this$unitType.equals(other$unitType)) {
               Object this$enabled = this.getEnabled();
               Object other$enabled = other.getEnabled();
               if (this$enabled == null ? other$enabled == null : this$enabled.equals(other$enabled)) {
                  Object this$serialNumber = this.getSerialNumber();
                  Object other$serialNumber = other.getSerialNumber();
                  if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                     Object this$workshop = this.getWorkshop();
                     Object other$workshop = other.getWorkshop();
                     if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                        Object this$specification = this.getSpecification();
                        Object other$specification = other.getSpecification();
                        if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                           Object this$unit = this.getUnit();
                           Object other$unit = other.getUnit();
                           if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
                              Object this$minimumInventory = this.getMinimumInventory();
                              Object other$minimumInventory = other.getMinimumInventory();
                              if (this$minimumInventory == null ? other$minimumInventory == null : this$minimumInventory.equals(other$minimumInventory)) {
                                 Object this$createTime = this.getCreateTime();
                                 Object other$createTime = other.getCreateTime();
                                 if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                    Object this$updateTime = this.getUpdateTime();
                                    Object other$updateTime = other.getUpdateTime();
                                    return this$updateTime == null ? other$updateTime == null : this$updateTime.equals(other$updateTime);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof WarningDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $unitType = this.getUnitType();
      result = result * 59 + ($unitType == null ? 43 : $unitType.hashCode());
      Object $enabled = this.getEnabled();
      result = result * 59 + ($enabled == null ? 43 : $enabled.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $minimumInventory = this.getMinimumInventory();
      result = result * 59 + ($minimumInventory == null ? 43 : $minimumInventory.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $updateTime = this.getUpdateTime();
      return result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
   }

   @Override
   public String toString() {
      return "WarningDTO(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", workshop="
         + this.getWorkshop()
         + ", classifyId="
         + this.getClassifyId()
         + ", specification="
         + this.getSpecification()
         + ", unit="
         + this.getUnit()
         + ", unitType="
         + this.getUnitType()
         + ", minimumInventory="
         + this.getMinimumInventory()
         + ", enabled="
         + this.getEnabled()
         + ", createTime="
         + this.getCreateTime()
         + ", updateTime="
         + this.getUpdateTime()
         + ")";
   }

   public WarningDTO(
      final Long id,
      final String serialNumber,
      final BriefIdAndNameDTO workshop,
      final Long classifyId,
      final String specification,
      final String unit,
      final Integer unitType,
      final BigDecimal minimumInventory,
      final Boolean enabled,
      final LocalDateTime createTime,
      final LocalDateTime updateTime
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.workshop = workshop;
      this.classifyId = classifyId;
      this.specification = specification;
      this.unit = unit;
      this.unitType = unitType;
      this.minimumInventory = minimumInventory;
      this.enabled = enabled;
      this.createTime = createTime;
      this.updateTime = updateTime;
   }

   public WarningDTO() {
   }
}
