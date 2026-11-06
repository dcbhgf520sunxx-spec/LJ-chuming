package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("角色dto类")
public class RoleDTO {
   private Long id;
   private String name;
   private String remark;
   @ApiModelProperty(name = "permission", value = "角色权限")
   private String permission;
   private Integer sort;
   @ApiModelProperty(name = "menus", value = "角色菜单id列表")
   private List<Long> menus;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getPermission() {
      return this.permission;
   }

   public Integer getSort() {
      return this.sort;
   }

   public List<Long> getMenus() {
      return this.menus;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setPermission(final String permission) {
      this.permission = permission;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   public void setMenus(final List<Long> menus) {
      this.menus = menus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof RoleDTO)) {
         return false;
      }

      RoleDTO other = (RoleDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$sort = this.getSort();
         Object other$sort = other.getSort();
         if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$remark = this.getRemark();
               Object other$remark = other.getRemark();
               if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                  Object this$permission = this.getPermission();
                  Object other$permission = other.getPermission();
                  if (this$permission == null ? other$permission == null : this$permission.equals(other$permission)) {
                     Object this$menus = this.getMenus();
                     Object other$menus = other.getMenus();
                     return this$menus == null ? other$menus == null : this$menus.equals(other$menus);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof RoleDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $permission = this.getPermission();
      result = result * 59 + ($permission == null ? 43 : $permission.hashCode());
      Object $menus = this.getMenus();
      return result * 59 + ($menus == null ? 43 : $menus.hashCode());
   }

   @Override
   public String toString() {
      return "RoleDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", remark="
         + this.getRemark()
         + ", permission="
         + this.getPermission()
         + ", sort="
         + this.getSort()
         + ", menus="
         + this.getMenus()
         + ")";
   }
}
