package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel("设置项目模式类")
public class ProjectModeDTO {
   @ApiModelProperty("项目模式 项目模式 1 便捷模式 2 标准模式 4 精益模式")
   @NotNull(message = "项目模式不能为空")
   private Integer projectMode;

   public static ProjectModeDTO.ProjectModeDTOBuilder builder() {
      return new ProjectModeDTO.ProjectModeDTOBuilder();
   }

   public Integer getProjectMode() {
      return this.projectMode;
   }

   public void setProjectMode(final Integer projectMode) {
      this.projectMode = projectMode;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectModeDTO)) {
         return false;
      }

      ProjectModeDTO other = (ProjectModeDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectMode = this.getProjectMode();
      Object other$projectMode = other.getProjectMode();
      return this$projectMode == null ? other$projectMode == null : this$projectMode.equals(other$projectMode);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectModeDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectMode = this.getProjectMode();
      return result * 59 + ($projectMode == null ? 43 : $projectMode.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectModeDTO(projectMode=" + this.getProjectMode() + ")";
   }

   public ProjectModeDTO() {
   }

   public ProjectModeDTO(final Integer projectMode) {
      this.projectMode = projectMode;
   }

   public static class ProjectModeDTOBuilder {
      private Integer projectMode;

      ProjectModeDTOBuilder() {
      }

      public ProjectModeDTO.ProjectModeDTOBuilder projectMode(final Integer projectMode) {
         this.projectMode = projectMode;
         return this;
      }

      public ProjectModeDTO build() {
         return new ProjectModeDTO(this.projectMode);
      }

      @Override
      public String toString() {
         return "ProjectModeDTO.ProjectModeDTOBuilder(projectMode=" + this.projectMode + ")";
      }
   }
}
