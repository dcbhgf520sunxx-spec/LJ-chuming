package com.hzchum.scim.contract.core.api.pojo.dtoParam.project;

import io.swagger.annotations.ApiModelProperty;

public class ProjectDTOParam {
   @ApiModelProperty("项目id")
   private Long projectId;
   @ApiModelProperty("项目名称")
   private String name;
   @ApiModelProperty("项目年份")
   private String year;
   @ApiModelProperty("用户id")
   private Long userId;
   @ApiModelProperty("项目产品类型")
   private Integer projectType;
   @ApiModelProperty("包干制项目管理类型")
   private Integer lumpSumSystemType;

   public Long getProjectId() {
      return this.projectId;
   }

   public String getName() {
      return this.name;
   }

   public String getYear() {
      return this.year;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Integer getProjectType() {
      return this.projectType;
   }

   public Integer getLumpSumSystemType() {
      return this.lumpSumSystemType;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setYear(final String year) {
      this.year = year;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setProjectType(final Integer projectType) {
      this.projectType = projectType;
   }

   public void setLumpSumSystemType(final Integer lumpSumSystemType) {
      this.lumpSumSystemType = lumpSumSystemType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectDTOParam)) {
         return false;
      }

      ProjectDTOParam other = (ProjectDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$userId = this.getUserId();
         Object other$userId = other.getUserId();
         if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
            Object this$projectType = this.getProjectType();
            Object other$projectType = other.getProjectType();
            if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
               Object this$lumpSumSystemType = this.getLumpSumSystemType();
               Object other$lumpSumSystemType = other.getLumpSumSystemType();
               if (this$lumpSumSystemType == null ? other$lumpSumSystemType == null : this$lumpSumSystemType.equals(other$lumpSumSystemType)) {
                  Object this$name = this.getName();
                  Object other$name = other.getName();
                  if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                     Object this$year = this.getYear();
                     Object other$year = other.getYear();
                     return this$year == null ? other$year == null : this$year.equals(other$year);
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

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $lumpSumSystemType = this.getLumpSumSystemType();
      result = result * 59 + ($lumpSumSystemType == null ? 43 : $lumpSumSystemType.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $year = this.getYear();
      return result * 59 + ($year == null ? 43 : $year.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectDTOParam(projectId="
         + this.getProjectId()
         + ", name="
         + this.getName()
         + ", year="
         + this.getYear()
         + ", userId="
         + this.getUserId()
         + ", projectType="
         + this.getProjectType()
         + ", lumpSumSystemType="
         + this.getLumpSumSystemType()
         + ")";
   }
}
