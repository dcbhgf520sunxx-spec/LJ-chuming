package com.hzchum.scim.system.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(description = "分支机构和项目联动列表")
public class BranchProjectVO {
   @ApiModelProperty("分支机构id")
   private Long id;
   @ApiModelProperty("分支机构名称")
   private String name;
   @ApiModelProperty("项目列表")
   private List<ProjectInfo> projectList;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public List<ProjectInfo> getProjectList() {
      return this.projectList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setProjectList(final List<ProjectInfo> projectList) {
      this.projectList = projectList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BranchProjectVO)) {
         return false;
      }

      BranchProjectVO other = (BranchProjectVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$projectList = this.getProjectList();
            Object other$projectList = other.getProjectList();
            return this$projectList == null ? other$projectList == null : this$projectList.equals(other$projectList);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof BranchProjectVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $projectList = this.getProjectList();
      return result * 59 + ($projectList == null ? 43 : $projectList.hashCode());
   }

   @Override
   public String toString() {
      return "BranchProjectVO(id=" + this.getId() + ", name=" + this.getName() + ", projectList=" + this.getProjectList() + ")";
   }
}
