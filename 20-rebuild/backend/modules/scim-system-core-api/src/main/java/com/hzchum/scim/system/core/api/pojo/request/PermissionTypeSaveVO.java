package com.hzchum.scim.system.core.api.pojo.request;

import io.swagger.annotations.ApiModel;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel("权限类型新增请求类")
public class PermissionTypeSaveVO {
   @NotBlank(message = "名称不能为空")
   private String name;
   private String icon;
   @NotNull(message = "排序不能为空")
   private Integer sort;

   public String getName() {
      return this.name;
   }

   public String getIcon() {
      return this.icon;
   }

   public Integer getSort() {
      return this.sort;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setIcon(final String icon) {
      this.icon = icon;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PermissionTypeSaveVO)) {
         return false;
      }

      PermissionTypeSaveVO other = (PermissionTypeSaveVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$sort = this.getSort();
      Object other$sort = other.getSort();
      if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$icon = this.getIcon();
            Object other$icon = other.getIcon();
            return this$icon == null ? other$icon == null : this$icon.equals(other$icon);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PermissionTypeSaveVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $icon = this.getIcon();
      return result * 59 + ($icon == null ? 43 : $icon.hashCode());
   }

   @Override
   public String toString() {
      return "PermissionTypeSaveVO(name=" + this.getName() + ", icon=" + this.getIcon() + ", sort=" + this.getSort() + ")";
   }
}
