package com.hzchum.scim.system.core.api.pojo.dto;

public class PermissionDTO {
   private Integer sort;
   private Integer type;
   private String permission;
   private String name;

   public Integer getSort() {
      return this.sort;
   }

   public Integer getType() {
      return this.type;
   }

   public String getPermission() {
      return this.permission;
   }

   public String getName() {
      return this.name;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setPermission(final String permission) {
      this.permission = permission;
   }

   public void setName(final String name) {
      this.name = name;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PermissionDTO)) {
         return false;
      }

      PermissionDTO other = (PermissionDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$sort = this.getSort();
      Object other$sort = other.getSort();
      if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
         Object this$type = this.getType();
         Object other$type = other.getType();
         if (this$type == null ? other$type == null : this$type.equals(other$type)) {
            Object this$permission = this.getPermission();
            Object other$permission = other.getPermission();
            if (this$permission == null ? other$permission == null : this$permission.equals(other$permission)) {
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
      return other instanceof PermissionDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $permission = this.getPermission();
      result = result * 59 + ($permission == null ? 43 : $permission.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "PermissionDTO(sort=" + this.getSort() + ", type=" + this.getType() + ", permission=" + this.getPermission() + ", name=" + this.getName() + ")";
   }
}
