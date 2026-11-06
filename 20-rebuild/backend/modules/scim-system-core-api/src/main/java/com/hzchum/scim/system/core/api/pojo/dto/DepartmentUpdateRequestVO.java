package com.hzchum.scim.system.core.api.pojo.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class DepartmentUpdateRequestVO {
   @NotNull(message = "部门id不能为空")
   private Long id;
   @NotBlank(message = "部门的名称不能为空")
   @Length(max = 64, message = "部门名称最大长度为64个字")
   private String name;
   @Length(max = 512, message = "部门简介最大长度为512个字")
   private String introduction;
   private Long pid;
   @Min(value = 1L, message = "排序值不能小于1")
   private Integer sort;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getIntroduction() {
      return this.introduction;
   }

   public Long getPid() {
      return this.pid;
   }

   public Integer getSort() {
      return this.sort;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setIntroduction(final String introduction) {
      this.introduction = introduction;
   }

   public void setPid(final Long pid) {
      this.pid = pid;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DepartmentUpdateRequestVO)) {
         return false;
      }

      DepartmentUpdateRequestVO other = (DepartmentUpdateRequestVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$pid = this.getPid();
         Object other$pid = other.getPid();
         if (this$pid == null ? other$pid == null : this$pid.equals(other$pid)) {
            Object this$sort = this.getSort();
            Object other$sort = other.getSort();
            if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$introduction = this.getIntroduction();
                  Object other$introduction = other.getIntroduction();
                  return this$introduction == null ? other$introduction == null : this$introduction.equals(other$introduction);
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
      return other instanceof DepartmentUpdateRequestVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $pid = this.getPid();
      result = result * 59 + ($pid == null ? 43 : $pid.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $introduction = this.getIntroduction();
      return result * 59 + ($introduction == null ? 43 : $introduction.hashCode());
   }

   @Override
   public String toString() {
      return "DepartmentUpdateRequestVO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", introduction="
         + this.getIntroduction()
         + ", pid="
         + this.getPid()
         + ", sort="
         + this.getSort()
         + ")";
   }
}
