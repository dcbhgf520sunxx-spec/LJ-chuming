package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class JobSaveRequestVO {
   @NotBlank(message = "职位名称不能为空")
   @Length(max = 64, message = "职位名称最大长度为64个字")
   private String name;
   @NotNull(message = "排序名称不能为空")
   private Integer sort;
   @NotNull(message = "状态")
   @Max(value = 1L, message = "状态值为：0:启用,1:禁用")
   @Min(value = 0L, message = "状态值为：0:启用,1:禁用")
   private Integer enabled;
   @NotNull(message = "部门id不能为空")
   private Long deptId;
   @ApiModelProperty(name = "jobType", value = "岗位类型 1编制内 2编制外")
   private Integer jobType;

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

   public Integer getJobType() {
      return this.jobType;
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

   public void setJobType(final Integer jobType) {
      this.jobType = jobType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof JobSaveRequestVO)) {
         return false;
      }

      JobSaveRequestVO other = (JobSaveRequestVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$sort = this.getSort();
      Object other$sort = other.getSort();
      if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
         Object this$enabled = this.getEnabled();
         Object other$enabled = other.getEnabled();
         if (this$enabled == null ? other$enabled == null : this$enabled.equals(other$enabled)) {
            Object this$deptId = this.getDeptId();
            Object other$deptId = other.getDeptId();
            if (this$deptId == null ? other$deptId == null : this$deptId.equals(other$deptId)) {
               Object this$jobType = this.getJobType();
               Object other$jobType = other.getJobType();
               if (this$jobType == null ? other$jobType == null : this$jobType.equals(other$jobType)) {
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
      return other instanceof JobSaveRequestVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $enabled = this.getEnabled();
      result = result * 59 + ($enabled == null ? 43 : $enabled.hashCode());
      Object $deptId = this.getDeptId();
      result = result * 59 + ($deptId == null ? 43 : $deptId.hashCode());
      Object $jobType = this.getJobType();
      result = result * 59 + ($jobType == null ? 43 : $jobType.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "JobSaveRequestVO(name="
         + this.getName()
         + ", sort="
         + this.getSort()
         + ", enabled="
         + this.getEnabled()
         + ", deptId="
         + this.getDeptId()
         + ", jobType="
         + this.getJobType()
         + ")";
   }
}
