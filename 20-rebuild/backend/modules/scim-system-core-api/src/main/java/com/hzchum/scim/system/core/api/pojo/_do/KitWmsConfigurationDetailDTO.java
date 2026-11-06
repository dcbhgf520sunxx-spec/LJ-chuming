package com.hzchum.scim.system.core.api.pojo._do;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

public class KitWmsConfigurationDetailDTO {
   @ApiModelProperty("项目id")
   @NotNull(message = "项目id不能为空")
   private Long projectId;
   @ApiModelProperty("项目名称")
   private String projectName;
   @ApiModelProperty("是否关联0不关联，1关联")
   @NotNull(message = "是否关联不能为空")
   private Boolean boolLink;

   public static KitWmsConfigurationDetailDTO.KitWmsConfigurationDetailDTOBuilder builder() {
      return new KitWmsConfigurationDetailDTO.KitWmsConfigurationDetailDTOBuilder();
   }

   public KitWmsConfigurationDetailDTO() {
   }

   public KitWmsConfigurationDetailDTO(final Long projectId, final String projectName, final Boolean boolLink) {
      this.projectId = projectId;
      this.projectName = projectName;
      this.boolLink = boolLink;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public Boolean getBoolLink() {
      return this.boolLink;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setBoolLink(final Boolean boolLink) {
      this.boolLink = boolLink;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof KitWmsConfigurationDetailDTO)) {
         return false;
      }

      KitWmsConfigurationDetailDTO other = (KitWmsConfigurationDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$boolLink = this.getBoolLink();
         Object other$boolLink = other.getBoolLink();
         if (this$boolLink == null ? other$boolLink == null : this$boolLink.equals(other$boolLink)) {
            Object this$projectName = this.getProjectName();
            Object other$projectName = other.getProjectName();
            return this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof KitWmsConfigurationDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $boolLink = this.getBoolLink();
      result = result * 59 + ($boolLink == null ? 43 : $boolLink.hashCode());
      Object $projectName = this.getProjectName();
      return result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
   }

   @Override
   public String toString() {
      return "KitWmsConfigurationDetailDTO(projectId="
         + this.getProjectId()
         + ", projectName="
         + this.getProjectName()
         + ", boolLink="
         + this.getBoolLink()
         + ")";
   }

   public static class KitWmsConfigurationDetailDTOBuilder {
      private Long projectId;
      private String projectName;
      private Boolean boolLink;

      KitWmsConfigurationDetailDTOBuilder() {
      }

      public KitWmsConfigurationDetailDTO.KitWmsConfigurationDetailDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public KitWmsConfigurationDetailDTO.KitWmsConfigurationDetailDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public KitWmsConfigurationDetailDTO.KitWmsConfigurationDetailDTOBuilder boolLink(final Boolean boolLink) {
         this.boolLink = boolLink;
         return this;
      }

      public KitWmsConfigurationDetailDTO build() {
         return new KitWmsConfigurationDetailDTO(this.projectId, this.projectName, this.boolLink);
      }

      @Override
      public String toString() {
         return "KitWmsConfigurationDetailDTO.KitWmsConfigurationDetailDTOBuilder(projectId="
            + this.projectId
            + ", projectName="
            + this.projectName
            + ", boolLink="
            + this.boolLink
            + ")";
      }
   }
}
