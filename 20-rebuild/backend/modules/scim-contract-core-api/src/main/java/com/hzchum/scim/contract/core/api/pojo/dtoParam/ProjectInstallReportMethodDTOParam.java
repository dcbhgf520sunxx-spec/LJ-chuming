package com.hzchum.scim.contract.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModelProperty;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.contract.core.api.enums.ReportMethodEnum;
import javax.validation.constraints.NotNull;

public class ProjectInstallReportMethodDTOParam {
   @NotNull(message = "项目id不能为空")
   @ApiModelProperty("项目id")
   private Long projectId;
   @NotNull(message = "安装填报方式不能为空")
   @ApiModelProperty("填报方式: 1.app端填报 0.PC端填报")
   @EnumValidator(value = ReportMethodEnum.class, message = "安装填报方式仅支持0或1")
   private Integer reportMethod;

   public static ProjectInstallReportMethodDTOParam.ProjectInstallReportMethodDTOParamBuilder builder() {
      return new ProjectInstallReportMethodDTOParam.ProjectInstallReportMethodDTOParamBuilder();
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getReportMethod() {
      return this.reportMethod;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setReportMethod(final Integer reportMethod) {
      this.reportMethod = reportMethod;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProjectInstallReportMethodDTOParam)) {
         return false;
      } else {
         ProjectInstallReportMethodDTOParam other = (ProjectInstallReportMethodDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$reportMethod = this.getReportMethod();
               Object other$reportMethod = other.getReportMethod();
               return this$reportMethod == null ? other$reportMethod == null : this$reportMethod.equals(other$reportMethod);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectInstallReportMethodDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $reportMethod = this.getReportMethod();
      return result * 59 + ($reportMethod == null ? 43 : $reportMethod.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectInstallReportMethodDTOParam(projectId=" + this.getProjectId() + ", reportMethod=" + this.getReportMethod() + ")";
   }

   public ProjectInstallReportMethodDTOParam(final Long projectId, final Integer reportMethod) {
      this.projectId = projectId;
      this.reportMethod = reportMethod;
   }

   public ProjectInstallReportMethodDTOParam() {
   }

   public static class ProjectInstallReportMethodDTOParamBuilder {
      private Long projectId;
      @EnumValidator(value = ReportMethodEnum.class, message = "安装填报方式仅支持0或1")
   private Integer reportMethod;

      ProjectInstallReportMethodDTOParamBuilder() {
      }

      public ProjectInstallReportMethodDTOParam.ProjectInstallReportMethodDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectInstallReportMethodDTOParam.ProjectInstallReportMethodDTOParamBuilder reportMethod(final Integer reportMethod) {
         this.reportMethod = reportMethod;
         return this;
      }

      public ProjectInstallReportMethodDTOParam build() {
         return new ProjectInstallReportMethodDTOParam(this.projectId, this.reportMethod);
      }

      @Override
      public String toString() {
         return "ProjectInstallReportMethodDTOParam.ProjectInstallReportMethodDTOParamBuilder(projectId="
            + this.projectId
            + ", reportMethod="
            + this.reportMethod
            + ")";
      }
   }
}
