package com.hzchum.scim.system.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.system.core.api.pojo._do.SysProductTraceabilityConfig;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class SysProductTraceabilityConfigDTO extends SysProductTraceabilityConfig {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "projectList", value = "项目列表", notes = "项目列表")
   private List<ProjectInfo> projectList;

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysProductTraceabilityConfigDTO)) {
         return false;
      }

      SysProductTraceabilityConfigDTO other = (SysProductTraceabilityConfigDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$projectList = this.getProjectList();
      Object other$projectList = other.getProjectList();
      return this$projectList == null ? other$projectList == null : this$projectList.equals(other$projectList);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof SysProductTraceabilityConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $projectList = this.getProjectList();
      return result * 59 + ($projectList == null ? 43 : $projectList.hashCode());
   }

   public List<ProjectInfo> getProjectList() {
      return this.projectList;
   }

   public void setProjectList(final List<ProjectInfo> projectList) {
      this.projectList = projectList;
   }

   @Override
   public String toString() {
      return "SysProductTraceabilityConfigDTO(projectList=" + this.getProjectList() + ")";
   }
}
