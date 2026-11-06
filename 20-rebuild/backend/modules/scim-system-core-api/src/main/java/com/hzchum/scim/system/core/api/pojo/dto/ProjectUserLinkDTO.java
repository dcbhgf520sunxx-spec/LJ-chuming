package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("项目(部门)和用户关联信息返回类")
public class ProjectUserLinkDTO {
   @ApiModelProperty("用户id")
   private Long id;
   @ApiModelProperty("用户姓名")
   private String name;
   @ApiModelProperty("部门id")
   private Long deptId;
   @ApiModelProperty("部门名称")
   private String deptName;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Long getDeptId() {
      return this.deptId;
   }

   public String getDeptName() {
      return this.deptName;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setDeptId(final Long deptId) {
      this.deptId = deptId;
   }

   public void setDeptName(final String deptName) {
      this.deptName = deptName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectUserLinkDTO)) {
         return false;
      }

      ProjectUserLinkDTO other = (ProjectUserLinkDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$deptId = this.getDeptId();
         Object other$deptId = other.getDeptId();
         if (this$deptId == null ? other$deptId == null : this$deptId.equals(other$deptId)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$deptName = this.getDeptName();
               Object other$deptName = other.getDeptName();
               return this$deptName == null ? other$deptName == null : this$deptName.equals(other$deptName);
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
      return other instanceof ProjectUserLinkDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $deptId = this.getDeptId();
      result = result * 59 + ($deptId == null ? 43 : $deptId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $deptName = this.getDeptName();
      return result * 59 + ($deptName == null ? 43 : $deptName.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectUserLinkDTO(id=" + this.getId() + ", name=" + this.getName() + ", deptId=" + this.getDeptId() + ", deptName=" + this.getDeptName() + ")";
   }
}
