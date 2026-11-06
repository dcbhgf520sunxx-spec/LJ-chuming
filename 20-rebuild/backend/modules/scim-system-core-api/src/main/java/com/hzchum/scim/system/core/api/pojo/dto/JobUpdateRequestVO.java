package com.hzchum.scim.system.core.api.pojo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class JobUpdateRequestVO {
   @NotNull(message = "职位id不能为空")
   private Long id;
   @NotBlank(message = "职位名称不能为空")
   @Length(max = 64, message = "职位名称最大长度为64个字")
   private String name;
   @NotNull(message = "排序名称不能为空")
   private Integer sort;
   @NotNull(message = "状态不能为空")
   private Integer enabled;
   @NotNull(message = "部门id不能为空")
   private Long deptId;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Integer getEnabled() {
      return this.enabled;
   }

   public Long getDeptId() {
      return this.deptId;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   public void setEnabled(final Integer enabled) {
      this.enabled = enabled;
   }

   public void setDeptId(final Long deptId) {
      this.deptId = deptId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof JobUpdateRequestVO)) {
         return false;
      }

      JobUpdateRequestVO other = (JobUpdateRequestVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$sort = this.getSort();
         Object other$sort = other.getSort();
         if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
            Object this$enabled = this.getEnabled();
            Object other$enabled = other.getEnabled();
            if (this$enabled == null ? other$enabled == null : this$enabled.equals(other$enabled)) {
               Object this$deptId = this.getDeptId();
               Object other$deptId = other.getDeptId();
               if (this$deptId == null ? other$deptId == null : this$deptId.equals(other$deptId)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof JobUpdateRequestVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $enabled = this.getEnabled();
      result = result * 59 + ($enabled == null ? 43 : $enabled.hashCode());
      Object $deptId = this.getDeptId();
      result = result * 59 + ($deptId == null ? 43 : $deptId.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "JobUpdateRequestVO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", sort="
         + this.getSort()
         + ", enabled="
         + this.getEnabled()
         + ", deptId="
         + this.getDeptId()
         + ")";
   }
}
