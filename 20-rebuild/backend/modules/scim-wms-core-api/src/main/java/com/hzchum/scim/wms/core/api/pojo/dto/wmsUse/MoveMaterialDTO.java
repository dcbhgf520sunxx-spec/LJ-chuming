package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordFlowDTO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MoveMaterial;
import java.util.List;

public class MoveMaterialDTO extends MoveMaterial {
   private List<NameInfo> sourceWorkshopList;
   private List<ProjectInfo> projectList;
   private Boolean boolHasUnfreeze;
   private List<MaterialUnfreezeDTO> unfreezeList;
   private List<MoveMaterialDetailDTO> detailList;
   private NameInfo directionWarehouse;
   private NameInfo directionWorkshop;
   private WmsApproveRecordFlowDTO wmsApproveRecordFlowDTO;

   public List<NameInfo> getSourceWorkshopList() {
      return this.sourceWorkshopList;
   }

   public List<ProjectInfo> getProjectList() {
      return this.projectList;
   }

   public Boolean getBoolHasUnfreeze() {
      return this.boolHasUnfreeze;
   }

   public List<MaterialUnfreezeDTO> getUnfreezeList() {
      return this.unfreezeList;
   }

   public List<MoveMaterialDetailDTO> getDetailList() {
      return this.detailList;
   }

   public NameInfo getDirectionWarehouse() {
      return this.directionWarehouse;
   }

   public NameInfo getDirectionWorkshop() {
      return this.directionWorkshop;
   }

   public WmsApproveRecordFlowDTO getWmsApproveRecordFlowDTO() {
      return this.wmsApproveRecordFlowDTO;
   }

   public void setSourceWorkshopList(final List<NameInfo> sourceWorkshopList) {
      this.sourceWorkshopList = sourceWorkshopList;
   }

   public void setProjectList(final List<ProjectInfo> projectList) {
      this.projectList = projectList;
   }

   public void setBoolHasUnfreeze(final Boolean boolHasUnfreeze) {
      this.boolHasUnfreeze = boolHasUnfreeze;
   }

   public void setUnfreezeList(final List<MaterialUnfreezeDTO> unfreezeList) {
      this.unfreezeList = unfreezeList;
   }

   public void setDetailList(final List<MoveMaterialDetailDTO> detailList) {
      this.detailList = detailList;
   }

   public void setDirectionWarehouse(final NameInfo directionWarehouse) {
      this.directionWarehouse = directionWarehouse;
   }

   public void setDirectionWorkshop(final NameInfo directionWorkshop) {
      this.directionWorkshop = directionWorkshop;
   }

   public void setWmsApproveRecordFlowDTO(final WmsApproveRecordFlowDTO wmsApproveRecordFlowDTO) {
      this.wmsApproveRecordFlowDTO = wmsApproveRecordFlowDTO;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MoveMaterialDTO)) {
         return false;
      }

      MoveMaterialDTO other = (MoveMaterialDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$boolHasUnfreeze = this.getBoolHasUnfreeze();
      Object other$boolHasUnfreeze = other.getBoolHasUnfreeze();
      if (this$boolHasUnfreeze == null ? other$boolHasUnfreeze == null : this$boolHasUnfreeze.equals(other$boolHasUnfreeze)) {
         Object this$sourceWorkshopList = this.getSourceWorkshopList();
         Object other$sourceWorkshopList = other.getSourceWorkshopList();
         if (this$sourceWorkshopList == null ? other$sourceWorkshopList == null : this$sourceWorkshopList.equals(other$sourceWorkshopList)) {
            Object this$projectList = this.getProjectList();
            Object other$projectList = other.getProjectList();
            if (this$projectList == null ? other$projectList == null : this$projectList.equals(other$projectList)) {
               Object this$unfreezeList = this.getUnfreezeList();
               Object other$unfreezeList = other.getUnfreezeList();
               if (this$unfreezeList == null ? other$unfreezeList == null : this$unfreezeList.equals(other$unfreezeList)) {
                  Object this$detailList = this.getDetailList();
                  Object other$detailList = other.getDetailList();
                  if (this$detailList == null ? other$detailList == null : this$detailList.equals(other$detailList)) {
                     Object this$directionWarehouse = this.getDirectionWarehouse();
                     Object other$directionWarehouse = other.getDirectionWarehouse();
                     if (this$directionWarehouse == null ? other$directionWarehouse == null : this$directionWarehouse.equals(other$directionWarehouse)) {
                        Object this$directionWorkshop = this.getDirectionWorkshop();
                        Object other$directionWorkshop = other.getDirectionWorkshop();
                        if (this$directionWorkshop == null ? other$directionWorkshop == null : this$directionWorkshop.equals(other$directionWorkshop)) {
                           Object this$wmsApproveRecordFlowDTO = this.getWmsApproveRecordFlowDTO();
                           Object other$wmsApproveRecordFlowDTO = other.getWmsApproveRecordFlowDTO();
                           return this$wmsApproveRecordFlowDTO == null
                              ? other$wmsApproveRecordFlowDTO == null
                              : this$wmsApproveRecordFlowDTO.equals(other$wmsApproveRecordFlowDTO);
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
      return other instanceof MoveMaterialDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $boolHasUnfreeze = this.getBoolHasUnfreeze();
      result = result * 59 + ($boolHasUnfreeze == null ? 43 : $boolHasUnfreeze.hashCode());
      Object $sourceWorkshopList = this.getSourceWorkshopList();
      result = result * 59 + ($sourceWorkshopList == null ? 43 : $sourceWorkshopList.hashCode());
      Object $projectList = this.getProjectList();
      result = result * 59 + ($projectList == null ? 43 : $projectList.hashCode());
      Object $unfreezeList = this.getUnfreezeList();
      result = result * 59 + ($unfreezeList == null ? 43 : $unfreezeList.hashCode());
      Object $detailList = this.getDetailList();
      result = result * 59 + ($detailList == null ? 43 : $detailList.hashCode());
      Object $directionWarehouse = this.getDirectionWarehouse();
      result = result * 59 + ($directionWarehouse == null ? 43 : $directionWarehouse.hashCode());
      Object $directionWorkshop = this.getDirectionWorkshop();
      result = result * 59 + ($directionWorkshop == null ? 43 : $directionWorkshop.hashCode());
      Object $wmsApproveRecordFlowDTO = this.getWmsApproveRecordFlowDTO();
      return result * 59 + ($wmsApproveRecordFlowDTO == null ? 43 : $wmsApproveRecordFlowDTO.hashCode());
   }

   @Override
   public String toString() {
      return "MoveMaterialDTO(sourceWorkshopList="
         + this.getSourceWorkshopList()
         + ", projectList="
         + this.getProjectList()
         + ", boolHasUnfreeze="
         + this.getBoolHasUnfreeze()
         + ", unfreezeList="
         + this.getUnfreezeList()
         + ", detailList="
         + this.getDetailList()
         + ", directionWarehouse="
         + this.getDirectionWarehouse()
         + ", directionWorkshop="
         + this.getDirectionWorkshop()
         + ", wmsApproveRecordFlowDTO="
         + this.getWmsApproveRecordFlowDTO()
         + ")";
   }

   public MoveMaterialDTO(
      final List<NameInfo> sourceWorkshopList,
      final List<ProjectInfo> projectList,
      final Boolean boolHasUnfreeze,
      final List<MaterialUnfreezeDTO> unfreezeList,
      final List<MoveMaterialDetailDTO> detailList,
      final NameInfo directionWarehouse,
      final NameInfo directionWorkshop,
      final WmsApproveRecordFlowDTO wmsApproveRecordFlowDTO
   ) {
      this.sourceWorkshopList = sourceWorkshopList;
      this.projectList = projectList;
      this.boolHasUnfreeze = boolHasUnfreeze;
      this.unfreezeList = unfreezeList;
      this.detailList = detailList;
      this.directionWarehouse = directionWarehouse;
      this.directionWorkshop = directionWorkshop;
      this.wmsApproveRecordFlowDTO = wmsApproveRecordFlowDTO;
   }

   public MoveMaterialDTO() {
   }
}
