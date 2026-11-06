package com.hzchum.scim.contract.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

public class ProjectInstallDivideMethodDTOParam {
   @NotNull(message = "项目id不能为空")
   @ApiModelProperty("项目id")
   private Long projectId;
   @NotNull(message = "安装内容划分方式不能为空！")
   @ApiModelProperty("划分方式 1:按清单划分 0:按区域划分")
   private Integer divideMethod;

   public static ProjectInstallDivideMethodDTOParam.ProjectInstallDivideMethodDTOParamBuilder builder() {
      return new ProjectInstallDivideMethodDTOParam.ProjectInstallDivideMethodDTOParamBuilder();
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getDivideMethod() {
      return this.divideMethod;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setDivideMethod(final Integer divideMethod) {
      this.divideMethod = divideMethod;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProjectInstallDivideMethodDTOParam)) {
         return false;
      } else {
         ProjectInstallDivideMethodDTOParam other = (ProjectInstallDivideMethodDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$divideMethod = this.getDivideMethod();
               Object other$divideMethod = other.getDivideMethod();
               return this$divideMethod == null ? other$divideMethod == null : this$divideMethod.equals(other$divideMethod);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectInstallDivideMethodDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $divideMethod = this.getDivideMethod();
      return result * 59 + ($divideMethod == null ? 43 : $divideMethod.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectInstallDivideMethodDTOParam(projectId=" + this.getProjectId() + ", divideMethod=" + this.getDivideMethod() + ")";
   }

   public ProjectInstallDivideMethodDTOParam(final Long projectId, final Integer divideMethod) {
      this.projectId = projectId;
      this.divideMethod = divideMethod;
   }

   public ProjectInstallDivideMethodDTOParam() {
   }

   public static class ProjectInstallDivideMethodDTOParamBuilder {
      private Long projectId;
      private Integer divideMethod;

      ProjectInstallDivideMethodDTOParamBuilder() {
      }

      public ProjectInstallDivideMethodDTOParam.ProjectInstallDivideMethodDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectInstallDivideMethodDTOParam.ProjectInstallDivideMethodDTOParamBuilder divideMethod(final Integer divideMethod) {
         this.divideMethod = divideMethod;
         return this;
      }

      public ProjectInstallDivideMethodDTOParam build() {
         return new ProjectInstallDivideMethodDTOParam(this.projectId, this.divideMethod);
      }

      @Override
      public String toString() {
         return "ProjectInstallDivideMethodDTOParam.ProjectInstallDivideMethodDTOParamBuilder(projectId="
            + this.projectId
            + ", divideMethod="
            + this.divideMethod
            + ")";
      }
   }
}
