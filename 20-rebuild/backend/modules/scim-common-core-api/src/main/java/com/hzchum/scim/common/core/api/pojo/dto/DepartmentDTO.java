package com.hzchum.scim.common.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("部门返回类")
public class DepartmentDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "introduction")
   private String introduction;
   @ApiModelProperty(name = "name")
   private String name;
   @ApiModelProperty(name = "pid")
   private Long pid;

   public Long getId() {
      return this.id;
   }

   public String getIntroduction() {
      return this.introduction;
   }

   public String getName() {
      return this.name;
   }

   public Long getPid() {
      return this.pid;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setIntroduction(final String introduction) {
      this.introduction = introduction;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setPid(final Long pid) {
      this.pid = pid;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DepartmentDTO)) {
         return false;
      }

      DepartmentDTO other = (DepartmentDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$pid = this.getPid();
         Object other$pid = other.getPid();
         if (this$pid == null ? other$pid == null : this$pid.equals(other$pid)) {
            Object this$introduction = this.getIntroduction();
            Object other$introduction = other.getIntroduction();
            if (this$introduction == null ? other$introduction == null : this$introduction.equals(other$introduction)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               return this$name == null ? other$name == null : this$name.equals(other$name);
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
      return other instanceof DepartmentDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $pid = this.getPid();
      result = result * 59 + ($pid == null ? 43 : $pid.hashCode());
      Object $introduction = this.getIntroduction();
      result = result * 59 + ($introduction == null ? 43 : $introduction.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "DepartmentDTO(id=" + this.getId() + ", introduction=" + this.getIntroduction() + ", name=" + this.getName() + ", pid=" + this.getPid() + ")";
   }
}
