package com.hzchum.scim.plan.core.api.pojo.dto;

import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactStandardPartLink;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("构件和配套件关联DTO类")
public class TechArtifactStandardPartLinkDTO extends TechArtifactStandardPartLink {
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "standardPartName", value = "标准件表(配套件)名称", notes = "标准件表(配套件)名称")
   private String standardPartName;
   @ApiModelProperty(name = "standardPartName", value = "标准件表(配套件)规格", notes = "标准件表(配套件)规格")
   private String standardPartSpecification;

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechArtifactStandardPartLinkDTO)) {
         return false;
      }

      TechArtifactStandardPartLinkDTO other = (TechArtifactStandardPartLinkDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$standardPartName = this.getStandardPartName();
         Object other$standardPartName = other.getStandardPartName();
         if (this$standardPartName == null ? other$standardPartName == null : this$standardPartName.equals(other$standardPartName)) {
            Object this$standardPartSpecification = this.getStandardPartSpecification();
            Object other$standardPartSpecification = other.getStandardPartSpecification();
            return this$standardPartSpecification == null
               ? other$standardPartSpecification == null
               : this$standardPartSpecification.equals(other$standardPartSpecification);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof TechArtifactStandardPartLinkDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $standardPartName = this.getStandardPartName();
      result = result * 59 + ($standardPartName == null ? 43 : $standardPartName.hashCode());
      Object $standardPartSpecification = this.getStandardPartSpecification();
      return result * 59 + ($standardPartSpecification == null ? 43 : $standardPartSpecification.hashCode());
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getStandardPartName() {
      return this.standardPartName;
   }

   public String getStandardPartSpecification() {
      return this.standardPartSpecification;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setStandardPartName(final String standardPartName) {
      this.standardPartName = standardPartName;
   }

   public void setStandardPartSpecification(final String standardPartSpecification) {
      this.standardPartSpecification = standardPartSpecification;
   }

   @Override
   public String toString() {
      return "TechArtifactStandardPartLinkDTO(super="
         + super.toString()
         + ", projectId="
         + this.getProjectId()
         + ", standardPartName="
         + this.getStandardPartName()
         + ", standardPartSpecification="
         + this.getStandardPartSpecification()
         + ")";
   }
}
