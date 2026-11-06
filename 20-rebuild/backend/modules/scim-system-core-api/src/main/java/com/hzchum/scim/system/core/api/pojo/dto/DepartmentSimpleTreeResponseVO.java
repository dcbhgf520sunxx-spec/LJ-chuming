package com.hzchum.scim.system.core.api.pojo.dto;

import java.util.List;

public class DepartmentSimpleTreeResponseVO {
   private Long id;
   private String name;
   private List<DepartmentSimpleTreeResponseVO> children;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public List<DepartmentSimpleTreeResponseVO> getChildren() {
      return this.children;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setChildren(final List<DepartmentSimpleTreeResponseVO> children) {
      this.children = children;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DepartmentSimpleTreeResponseVO)) {
         return false;
      }

      DepartmentSimpleTreeResponseVO other = (DepartmentSimpleTreeResponseVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$children = this.getChildren();
            Object other$children = other.getChildren();
            return this$children == null ? other$children == null : this$children.equals(other$children);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof DepartmentSimpleTreeResponseVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $children = this.getChildren();
      return result * 59 + ($children == null ? 43 : $children.hashCode());
   }

   @Override
   public String toString() {
      return "DepartmentSimpleTreeResponseVO(id=" + this.getId() + ", name=" + this.getName() + ", children=" + this.getChildren() + ")";
   }
}
