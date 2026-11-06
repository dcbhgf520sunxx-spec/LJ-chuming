package com.hzchum.scim.contract.core.api.pojo.dtoParam.project;

import io.swagger.annotations.ApiModelProperty;

public class ContractProjectIsArchivistParam {
   @ApiModelProperty(name = "projectId", notes = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "isArchivist", notes = "是否归档 1.归档 0.未归档")
   private Integer isArchivist;

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getIsArchivist() {
      return this.isArchivist;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setIsArchivist(final Integer isArchivist) {
      this.isArchivist = isArchivist;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ContractProjectIsArchivistParam)) {
         return false;
      } else {
         ContractProjectIsArchivistParam other = (ContractProjectIsArchivistParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$isArchivist = this.getIsArchivist();
               Object other$isArchivist = other.getIsArchivist();
               return this$isArchivist == null ? other$isArchivist == null : this$isArchivist.equals(other$isArchivist);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ContractProjectIsArchivistParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $isArchivist = this.getIsArchivist();
      return result * 59 + ($isArchivist == null ? 43 : $isArchivist.hashCode());
   }

   @Override
   public String toString() {
      return "ContractProjectIsArchivistParam(projectId=" + this.getProjectId() + ", isArchivist=" + this.getIsArchivist() + ")";
   }
}
