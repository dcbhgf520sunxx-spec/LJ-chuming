package com.hzchum.scim.mes.building.core.api.pojo._dto.wage_manage;

import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactExt;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("涂装工艺构件清单DTO类")
public class MesCoatingProcessArtifactExtDTO extends TechArtifactExt {
   @ApiModelProperty(name = "projectName", value = "项目名称")
   private String projectName;
   @ApiModelProperty(name = "monomerName", value = "单体名称")
   private String monomerName;
   @ApiModelProperty(name = "areaName", value = "区域名称")
   private String areaName;
   @ApiModelProperty(name = "artifactName", value = "构件名称")
   private String artifactName;
   @ApiModelProperty(name = "artifactSerialNumber", value = "构件编号")
   private String artifactSerialNumber;
   @ApiModelProperty(name = "artifactSpecification", value = "构件规格")
   private String artifactSpecification;
   @ApiModelProperty(name = "artifactLength", value = "构件长度")
   private String artifactLength;
   @ApiModelProperty(name = "artifactMaterial", value = "构件材质")
   private String artifactMaterial;

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesCoatingProcessArtifactExtDTO)) {
         return false;
      }

      MesCoatingProcessArtifactExtDTO other = (MesCoatingProcessArtifactExtDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$projectName = this.getProjectName();
      Object other$projectName = other.getProjectName();
      if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
         Object this$monomerName = this.getMonomerName();
         Object other$monomerName = other.getMonomerName();
         if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
            Object this$areaName = this.getAreaName();
            Object other$areaName = other.getAreaName();
            if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
               Object this$artifactName = this.getArtifactName();
               Object other$artifactName = other.getArtifactName();
               if (this$artifactName == null ? other$artifactName == null : this$artifactName.equals(other$artifactName)) {
                  Object this$artifactSerialNumber = this.getArtifactSerialNumber();
                  Object other$artifactSerialNumber = other.getArtifactSerialNumber();
                  if (this$artifactSerialNumber == null ? other$artifactSerialNumber == null : this$artifactSerialNumber.equals(other$artifactSerialNumber)) {
                     Object this$artifactSpecification = this.getArtifactSpecification();
                     Object other$artifactSpecification = other.getArtifactSpecification();
                     if (this$artifactSpecification == null
                        ? other$artifactSpecification == null
                        : this$artifactSpecification.equals(other$artifactSpecification)) {
                        Object this$artifactLength = this.getArtifactLength();
                        Object other$artifactLength = other.getArtifactLength();
                        if (this$artifactLength == null ? other$artifactLength == null : this$artifactLength.equals(other$artifactLength)) {
                           Object this$artifactMaterial = this.getArtifactMaterial();
                           Object other$artifactMaterial = other.getArtifactMaterial();
                           return this$artifactMaterial == null ? other$artifactMaterial == null : this$artifactMaterial.equals(other$artifactMaterial);
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
      return other instanceof MesCoatingProcessArtifactExtDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $artifactName = this.getArtifactName();
      result = result * 59 + ($artifactName == null ? 43 : $artifactName.hashCode());
      Object $artifactSerialNumber = this.getArtifactSerialNumber();
      result = result * 59 + ($artifactSerialNumber == null ? 43 : $artifactSerialNumber.hashCode());
      Object $artifactSpecification = this.getArtifactSpecification();
      result = result * 59 + ($artifactSpecification == null ? 43 : $artifactSpecification.hashCode());
      Object $artifactLength = this.getArtifactLength();
      result = result * 59 + ($artifactLength == null ? 43 : $artifactLength.hashCode());
      Object $artifactMaterial = this.getArtifactMaterial();
      return result * 59 + ($artifactMaterial == null ? 43 : $artifactMaterial.hashCode());
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public String getArtifactName() {
      return this.artifactName;
   }

   public String getArtifactSerialNumber() {
      return this.artifactSerialNumber;
   }

   public String getArtifactSpecification() {
      return this.artifactSpecification;
   }

   public String getArtifactLength() {
      return this.artifactLength;
   }

   public String getArtifactMaterial() {
      return this.artifactMaterial;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
   }

   public void setAreaName(final String areaName) {
      this.areaName = areaName;
   }

   public void setArtifactName(final String artifactName) {
      this.artifactName = artifactName;
   }

   public void setArtifactSerialNumber(final String artifactSerialNumber) {
      this.artifactSerialNumber = artifactSerialNumber;
   }

   public void setArtifactSpecification(final String artifactSpecification) {
      this.artifactSpecification = artifactSpecification;
   }

   public void setArtifactLength(final String artifactLength) {
      this.artifactLength = artifactLength;
   }

   public void setArtifactMaterial(final String artifactMaterial) {
      this.artifactMaterial = artifactMaterial;
   }

   @Override
   public String toString() {
      return "MesCoatingProcessArtifactExtDTO(super="
         + super.toString()
         + ", projectName="
         + this.getProjectName()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaName="
         + this.getAreaName()
         + ", artifactName="
         + this.getArtifactName()
         + ", artifactSerialNumber="
         + this.getArtifactSerialNumber()
         + ", artifactSpecification="
         + this.getArtifactSpecification()
         + ", artifactLength="
         + this.getArtifactLength()
         + ", artifactMaterial="
         + this.getArtifactMaterial()
         + ")";
   }
}
