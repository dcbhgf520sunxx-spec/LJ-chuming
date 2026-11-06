package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MoveMaterialDetail;

public class MoveMaterialDetailDTO extends MoveMaterialDetail {
   private NameInfo sourceWarehouse;
   private NameInfo sourceWorkshop;
   private NameInfo directionWarehouse;
   private NameInfo directionWorkshop;
   private ProjectInfo project;
   private Integer measurePrecision;
   private String monomerName;
   private String areaName;
   private String moveSerialNumber;
   private String materialSnNew;

   public NameInfo getSourceWarehouse() {
      return this.sourceWarehouse;
   }

   public NameInfo getSourceWorkshop() {
      return this.sourceWorkshop;
   }

   public NameInfo getDirectionWarehouse() {
      return this.directionWarehouse;
   }

   public NameInfo getDirectionWorkshop() {
      return this.directionWorkshop;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public Integer getMeasurePrecision() {
      return this.measurePrecision;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public String getMoveSerialNumber() {
      return this.moveSerialNumber;
   }

   public String getMaterialSnNew() {
      return this.materialSnNew;
   }

   public void setSourceWarehouse(final NameInfo sourceWarehouse) {
      this.sourceWarehouse = sourceWarehouse;
   }

   public void setSourceWorkshop(final NameInfo sourceWorkshop) {
      this.sourceWorkshop = sourceWorkshop;
   }

   public void setDirectionWarehouse(final NameInfo directionWarehouse) {
      this.directionWarehouse = directionWarehouse;
   }

   public void setDirectionWorkshop(final NameInfo directionWorkshop) {
      this.directionWorkshop = directionWorkshop;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setMeasurePrecision(final Integer measurePrecision) {
      this.measurePrecision = measurePrecision;
   }

   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
   }

   public void setAreaName(final String areaName) {
      this.areaName = areaName;
   }

   public void setMoveSerialNumber(final String moveSerialNumber) {
      this.moveSerialNumber = moveSerialNumber;
   }

   public void setMaterialSnNew(final String materialSnNew) {
      this.materialSnNew = materialSnNew;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MoveMaterialDetailDTO)) {
         return false;
      }

      MoveMaterialDetailDTO other = (MoveMaterialDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$measurePrecision = this.getMeasurePrecision();
      Object other$measurePrecision = other.getMeasurePrecision();
      if (this$measurePrecision == null ? other$measurePrecision == null : this$measurePrecision.equals(other$measurePrecision)) {
         Object this$sourceWarehouse = this.getSourceWarehouse();
         Object other$sourceWarehouse = other.getSourceWarehouse();
         if (this$sourceWarehouse == null ? other$sourceWarehouse == null : this$sourceWarehouse.equals(other$sourceWarehouse)) {
            Object this$sourceWorkshop = this.getSourceWorkshop();
            Object other$sourceWorkshop = other.getSourceWorkshop();
            if (this$sourceWorkshop == null ? other$sourceWorkshop == null : this$sourceWorkshop.equals(other$sourceWorkshop)) {
               Object this$directionWarehouse = this.getDirectionWarehouse();
               Object other$directionWarehouse = other.getDirectionWarehouse();
               if (this$directionWarehouse == null ? other$directionWarehouse == null : this$directionWarehouse.equals(other$directionWarehouse)) {
                  Object this$directionWorkshop = this.getDirectionWorkshop();
                  Object other$directionWorkshop = other.getDirectionWorkshop();
                  if (this$directionWorkshop == null ? other$directionWorkshop == null : this$directionWorkshop.equals(other$directionWorkshop)) {
                     Object this$project = this.getProject();
                     Object other$project = other.getProject();
                     if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                        Object this$monomerName = this.getMonomerName();
                        Object other$monomerName = other.getMonomerName();
                        if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
                           Object this$areaName = this.getAreaName();
                           Object other$areaName = other.getAreaName();
                           if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
                              Object this$moveSerialNumber = this.getMoveSerialNumber();
                              Object other$moveSerialNumber = other.getMoveSerialNumber();
                              if (this$moveSerialNumber == null ? other$moveSerialNumber == null : this$moveSerialNumber.equals(other$moveSerialNumber)) {
                                 Object this$materialSnNew = this.getMaterialSnNew();
                                 Object other$materialSnNew = other.getMaterialSnNew();
                                 return this$materialSnNew == null ? other$materialSnNew == null : this$materialSnNew.equals(other$materialSnNew);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MoveMaterialDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $measurePrecision = this.getMeasurePrecision();
      result = result * 59 + ($measurePrecision == null ? 43 : $measurePrecision.hashCode());
      Object $sourceWarehouse = this.getSourceWarehouse();
      result = result * 59 + ($sourceWarehouse == null ? 43 : $sourceWarehouse.hashCode());
      Object $sourceWorkshop = this.getSourceWorkshop();
      result = result * 59 + ($sourceWorkshop == null ? 43 : $sourceWorkshop.hashCode());
      Object $directionWarehouse = this.getDirectionWarehouse();
      result = result * 59 + ($directionWarehouse == null ? 43 : $directionWarehouse.hashCode());
      Object $directionWorkshop = this.getDirectionWorkshop();
      result = result * 59 + ($directionWorkshop == null ? 43 : $directionWorkshop.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $moveSerialNumber = this.getMoveSerialNumber();
      result = result * 59 + ($moveSerialNumber == null ? 43 : $moveSerialNumber.hashCode());
      Object $materialSnNew = this.getMaterialSnNew();
      return result * 59 + ($materialSnNew == null ? 43 : $materialSnNew.hashCode());
   }

   @Override
   public String toString() {
      return "MoveMaterialDetailDTO(sourceWarehouse="
         + this.getSourceWarehouse()
         + ", sourceWorkshop="
         + this.getSourceWorkshop()
         + ", directionWarehouse="
         + this.getDirectionWarehouse()
         + ", directionWorkshop="
         + this.getDirectionWorkshop()
         + ", project="
         + this.getProject()
         + ", measurePrecision="
         + this.getMeasurePrecision()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaName="
         + this.getAreaName()
         + ", moveSerialNumber="
         + this.getMoveSerialNumber()
         + ", materialSnNew="
         + this.getMaterialSnNew()
         + ")";
   }

   public MoveMaterialDetailDTO(
      final NameInfo sourceWarehouse,
      final NameInfo sourceWorkshop,
      final NameInfo directionWarehouse,
      final NameInfo directionWorkshop,
      final ProjectInfo project,
      final Integer measurePrecision,
      final String monomerName,
      final String areaName,
      final String moveSerialNumber,
      final String materialSnNew
   ) {
      this.sourceWarehouse = sourceWarehouse;
      this.sourceWorkshop = sourceWorkshop;
      this.directionWarehouse = directionWarehouse;
      this.directionWorkshop = directionWorkshop;
      this.project = project;
      this.measurePrecision = measurePrecision;
      this.monomerName = monomerName;
      this.areaName = areaName;
      this.moveSerialNumber = moveSerialNumber;
      this.materialSnNew = materialSnNew;
   }

   public MoveMaterialDetailDTO() {
   }
}
