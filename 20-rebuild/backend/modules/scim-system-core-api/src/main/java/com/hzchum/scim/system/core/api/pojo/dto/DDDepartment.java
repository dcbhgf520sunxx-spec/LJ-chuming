package com.hzchum.scim.system.core.api.pojo.dto;

public class DDDepartment {
   private Long id;
   private String name;
   private Long parentid;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Long getParentid() {
      return this.parentid;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setParentid(final Long parentid) {
      this.parentid = parentid;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DDDepartment)) {
         return false;
      }

      DDDepartment other = (DDDepartment)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$parentid = this.getParentid();
         Object other$parentid = other.getParentid();
         if (this$parentid == null ? other$parentid == null : this$parentid.equals(other$parentid)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            return this$name == null ? other$name == null : this$name.equals(other$name);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof DDDepartment;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $parentid = this.getParentid();
      result = result * 59 + ($parentid == null ? 43 : $parentid.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "DDDepartment(id=" + this.getId() + ", name=" + this.getName() + ", parentid=" + this.getParentid() + ")";
   }
}
