package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.productionAnalysis;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ProjectKanBanDTO", description = "项目看板")
public class ArtifactGropAnalysisDTO {
   @ApiModelProperty(notes = "项目信息")
   private ProjectInfo project;
   @ApiModelProperty(notes = "单体信息")
   private NameInfo monomer;
   @ApiModelProperty(notes = "区域信息")
   private NameInfo areaDetail;
   @ApiModelProperty(notes = "名称")
   private String name;
   @ApiModelProperty(notes = "材质")
   private String material;

   public ProjectInfo getProject() {
      return this.project;
   }

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public NameInfo getAreaDetail() {
      return this.areaDetail;
   }

   public String getName() {
      return this.name;
   }

   public String getMaterial() {
      return this.material;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
   }

   public void setAreaDetail(final NameInfo areaDetail) {
      this.areaDetail = areaDetail;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactGropAnalysisDTO)) {
         return false;
      }

      ArtifactGropAnalysisDTO other = (ArtifactGropAnalysisDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$project = this.getProject();
      Object other$project = other.getProject();
      if (this$project == null ? other$project == null : this$project.equals(other$project)) {
         Object this$monomer = this.getMonomer();
         Object other$monomer = other.getMonomer();
         if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
            Object this$areaDetail = this.getAreaDetail();
            Object other$areaDetail = other.getAreaDetail();
            if (this$areaDetail == null ? other$areaDetail == null : this$areaDetail.equals(other$areaDetail)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$material = this.getMaterial();
                  Object other$material = other.getMaterial();
                  return this$material == null ? other$material == null : this$material.equals(other$material);
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
      return other instanceof ArtifactGropAnalysisDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $areaDetail = this.getAreaDetail();
      result = result * 59 + ($areaDetail == null ? 43 : $areaDetail.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $material = this.getMaterial();
      return result * 59 + ($material == null ? 43 : $material.hashCode());
   }

   @Override
   public String toString() {
      return "ArtifactGropAnalysisDTO(project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", areaDetail="
         + this.getAreaDetail()
         + ", name="
         + this.getName()
         + ", material="
         + this.getMaterial()
         + ")";
   }
}
