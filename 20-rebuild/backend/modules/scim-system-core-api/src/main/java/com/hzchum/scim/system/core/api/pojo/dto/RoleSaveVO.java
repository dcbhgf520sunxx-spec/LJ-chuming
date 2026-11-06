package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

@ApiModel("角色新增请求类")
public class RoleSaveVO {
   @NotBlank(message = "角色的名称不能为空")
   @Length(max = 64, message = "角色名称最大长度为64个字")
   private String name;
   @Length(max = 512, message = "角色描述最大长度为512个字")
   private String remark;
   @Min(value = 1L, message = "排序值不能小于1")
   private Integer sort;

   public String getName() {
      return this.name;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getSort() {
      return this.sort;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof RoleSaveVO)) {
         return false;
      }

      RoleSaveVO other = (RoleSaveVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$sort = this.getSort();
      Object other$sort = other.getSort();
      if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$remark = this.getRemark();
            Object other$remark = other.getRemark();
            return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof RoleSaveVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "RoleSaveVO(name=" + this.getName() + ", remark=" + this.getRemark() + ", sort=" + this.getSort() + ")";
   }
}
