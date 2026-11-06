package com.hzchum.scim.project.core.api.pojo.dtoParam.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("安装看板查询类")
public class InstallBoardQueryDTOParam extends ProjectBaseQueryDTOParam {
   @ApiModelProperty("项目类型")
   private Integer projectType;
   @ApiModelProperty(name = "installStatus", value = "安装状态 1未安装 2部分安装 4全部安装", notes = "安装状态")
   private Integer installStatus;

   public Integer getProjectType() {
      return this.projectType;
   }

   public Integer getInstallStatus() {
      return this.installStatus;
   }

   public void setProjectType(final Integer projectType) {
      this.projectType = projectType;
   }

   public void setInstallStatus(final Integer installStatus) {
      this.installStatus = installStatus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof InstallBoardQueryDTOParam)) {
         return false;
      } else {
         InstallBoardQueryDTOParam other = (InstallBoardQueryDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$projectType = this.getProjectType();
            Object other$projectType = other.getProjectType();
            if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
               Object this$installStatus = this.getInstallStatus();
               Object other$installStatus = other.getInstallStatus();
               return this$installStatus == null ? other$installStatus == null : this$installStatus.equals(other$installStatus);
            } else {
               return false;
            }
         }
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof InstallBoardQueryDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $installStatus = this.getInstallStatus();
      return result * 59 + ($installStatus == null ? 43 : $installStatus.hashCode());
   }

   @Override
   public String toString() {
      return "InstallBoardQueryDTOParam(projectType=" + this.getProjectType() + ", installStatus=" + this.getInstallStatus() + ")";
   }
}
