package com.hzchum.scim.plan.core.api.pojo.dto;

import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactAuxiliaryLink;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("构件配套件关联DTO类")
public class TechArtifactAuxiliaryLinkDTO extends TechArtifactAuxiliaryLink {
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "auxiliaryPartName", value = "配套件名称", notes = "配套件名称")
   private String auxiliaryPartName;

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof TechArtifactAuxiliaryLinkDTO)) {
         return false;
      } else {
         TechArtifactAuxiliaryLinkDTO other = (TechArtifactAuxiliaryLinkDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (!super.equals(o)) {
            return false;
         } else {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$auxiliaryPartName = this.getAuxiliaryPartName();
               Object other$auxiliaryPartName = other.getAuxiliaryPartName();
               return this$auxiliaryPartName == null ? other$auxiliaryPartName == null : this$auxiliaryPartName.equals(other$auxiliaryPartName);
            } else {
               return false;
            }
         }
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof TechArtifactAuxiliaryLinkDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $auxiliaryPartName = this.getAuxiliaryPartName();
      return result * 59 + ($auxiliaryPartName == null ? 43 : $auxiliaryPartName.hashCode());
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getAuxiliaryPartName() {
      return this.auxiliaryPartName;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setAuxiliaryPartName(final String auxiliaryPartName) {
      this.auxiliaryPartName = auxiliaryPartName;
   }

   @Override
   public String toString() {
      return "TechArtifactAuxiliaryLinkDTO(super="
         + super.toString()
         + ", projectId="
         + this.getProjectId()
         + ", auxiliaryPartName="
         + this.getAuxiliaryPartName()
         + ")";
   }
}
