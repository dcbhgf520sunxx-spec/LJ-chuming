package com.hzchum.scim.mes.building.core.api.pojo._dto._package;

import com.hzchum.scim.mes.building.core.api.pojo._do._package.ArtifactDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.EnclosureDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.SendDirectlyDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.TechStandardPartDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(description = "包详情")
public class PackageLinkDetailsDTO extends PackageDTO {
   @ApiModelProperty("构件")
   private List<ArtifactDetailDO> artifactList;
   @ApiModelProperty("零件-直发件")
   private List<SendDirectlyDetailDO> partList;
   @ApiModelProperty("部件-直发件")
   private List<SendDirectlyDetailDO> assembleList;
   @ApiModelProperty("围护")
   private List<EnclosureDetailDO> enclosureList;
   @ApiModelProperty("辅材")
   private List<TechStandardPartDetailDO> auxiliaryMaterialList;
   @ApiModelProperty("包详情列表")
   private List<PackageLinkDetailsCommonDTO> detailsList;

   public List<ArtifactDetailDO> getArtifactList() {
      return this.artifactList;
   }

   public List<SendDirectlyDetailDO> getPartList() {
      return this.partList;
   }

   public List<SendDirectlyDetailDO> getAssembleList() {
      return this.assembleList;
   }

   public List<EnclosureDetailDO> getEnclosureList() {
      return this.enclosureList;
   }

   public List<TechStandardPartDetailDO> getAuxiliaryMaterialList() {
      return this.auxiliaryMaterialList;
   }

   public List<PackageLinkDetailsCommonDTO> getDetailsList() {
      return this.detailsList;
   }

   public void setArtifactList(final List<ArtifactDetailDO> artifactList) {
      this.artifactList = artifactList;
   }

   public void setPartList(final List<SendDirectlyDetailDO> partList) {
      this.partList = partList;
   }

   public void setAssembleList(final List<SendDirectlyDetailDO> assembleList) {
      this.assembleList = assembleList;
   }

   public void setEnclosureList(final List<EnclosureDetailDO> enclosureList) {
      this.enclosureList = enclosureList;
   }

   public void setAuxiliaryMaterialList(final List<TechStandardPartDetailDO> auxiliaryMaterialList) {
      this.auxiliaryMaterialList = auxiliaryMaterialList;
   }

   public void setDetailsList(final List<PackageLinkDetailsCommonDTO> detailsList) {
      this.detailsList = detailsList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PackageLinkDetailsDTO)) {
         return false;
      }

      PackageLinkDetailsDTO other = (PackageLinkDetailsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$artifactList = this.getArtifactList();
      Object other$artifactList = other.getArtifactList();
      if (this$artifactList == null ? other$artifactList == null : this$artifactList.equals(other$artifactList)) {
         Object this$partList = this.getPartList();
         Object other$partList = other.getPartList();
         if (this$partList == null ? other$partList == null : this$partList.equals(other$partList)) {
            Object this$assembleList = this.getAssembleList();
            Object other$assembleList = other.getAssembleList();
            if (this$assembleList == null ? other$assembleList == null : this$assembleList.equals(other$assembleList)) {
               Object this$enclosureList = this.getEnclosureList();
               Object other$enclosureList = other.getEnclosureList();
               if (this$enclosureList == null ? other$enclosureList == null : this$enclosureList.equals(other$enclosureList)) {
                  Object this$auxiliaryMaterialList = this.getAuxiliaryMaterialList();
                  Object other$auxiliaryMaterialList = other.getAuxiliaryMaterialList();
                  if (this$auxiliaryMaterialList == null ? other$auxiliaryMaterialList == null : this$auxiliaryMaterialList.equals(other$auxiliaryMaterialList)
                     )
                   {
                     Object this$detailsList = this.getDetailsList();
                     Object other$detailsList = other.getDetailsList();
                     return this$detailsList == null ? other$detailsList == null : this$detailsList.equals(other$detailsList);
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
      return other instanceof PackageLinkDetailsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $artifactList = this.getArtifactList();
      result = result * 59 + ($artifactList == null ? 43 : $artifactList.hashCode());
      Object $partList = this.getPartList();
      result = result * 59 + ($partList == null ? 43 : $partList.hashCode());
      Object $assembleList = this.getAssembleList();
      result = result * 59 + ($assembleList == null ? 43 : $assembleList.hashCode());
      Object $enclosureList = this.getEnclosureList();
      result = result * 59 + ($enclosureList == null ? 43 : $enclosureList.hashCode());
      Object $auxiliaryMaterialList = this.getAuxiliaryMaterialList();
      result = result * 59 + ($auxiliaryMaterialList == null ? 43 : $auxiliaryMaterialList.hashCode());
      Object $detailsList = this.getDetailsList();
      return result * 59 + ($detailsList == null ? 43 : $detailsList.hashCode());
   }

   @Override
   public String toString() {
      return "PackageLinkDetailsDTO(artifactList="
         + this.getArtifactList()
         + ", partList="
         + this.getPartList()
         + ", assembleList="
         + this.getAssembleList()
         + ", enclosureList="
         + this.getEnclosureList()
         + ", auxiliaryMaterialList="
         + this.getAuxiliaryMaterialList()
         + ", detailsList="
         + this.getDetailsList()
         + ")";
   }
}
