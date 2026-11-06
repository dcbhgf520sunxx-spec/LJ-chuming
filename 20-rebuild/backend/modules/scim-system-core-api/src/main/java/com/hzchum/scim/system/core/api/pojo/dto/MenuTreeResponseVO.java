package com.hzchum.scim.system.core.api.pojo.dto;

import java.util.List;

public class MenuTreeResponseVO {
   private Long id;
   private String label;
   private Boolean own;
   private Long permissionTypeId;
   private Integer type;
   private Integer category;
   private List<MenuTreeResponseVO> children;

   public Long getId() {
      return this.id;
   }

   public String getLabel() {
      return this.label;
   }

   public Boolean getOwn() {
      return this.own;
   }

   public Long getPermissionTypeId() {
      return this.permissionTypeId;
   }

   public Integer getType() {
      return this.type;
   }

   public Integer getCategory() {
      return this.category;
   }

   public List<MenuTreeResponseVO> getChildren() {
      return this.children;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setLabel(final String label) {
      this.label = label;
   }

   public void setOwn(final Boolean own) {
      this.own = own;
   }

   public void setPermissionTypeId(final Long permissionTypeId) {
      this.permissionTypeId = permissionTypeId;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setCategory(final Integer category) {
      this.category = category;
   }

   public void setChildren(final List<MenuTreeResponseVO> children) {
      this.children = children;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MenuTreeResponseVO)) {
         return false;
      }

      MenuTreeResponseVO other = (MenuTreeResponseVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$own = this.getOwn();
         Object other$own = other.getOwn();
         if (this$own == null ? other$own == null : this$own.equals(other$own)) {
            Object this$permissionTypeId = this.getPermissionTypeId();
            Object other$permissionTypeId = other.getPermissionTypeId();
            if (this$permissionTypeId == null ? other$permissionTypeId == null : this$permissionTypeId.equals(other$permissionTypeId)) {
               Object this$type = this.getType();
               Object other$type = other.getType();
               if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                  Object this$category = this.getCategory();
                  Object other$category = other.getCategory();
                  if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                     Object this$label = this.getLabel();
                     Object other$label = other.getLabel();
                     if (this$label == null ? other$label == null : this$label.equals(other$label)) {
                        Object this$children = this.getChildren();
                        Object other$children = other.getChildren();
                        return this$children == null ? other$children == null : this$children.equals(other$children);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MenuTreeResponseVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $own = this.getOwn();
      result = result * 59 + ($own == null ? 43 : $own.hashCode());
      Object $permissionTypeId = this.getPermissionTypeId();
      result = result * 59 + ($permissionTypeId == null ? 43 : $permissionTypeId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $label = this.getLabel();
      result = result * 59 + ($label == null ? 43 : $label.hashCode());
      Object $children = this.getChildren();
      return result * 59 + ($children == null ? 43 : $children.hashCode());
   }

   @Override
   public String toString() {
      return "MenuTreeResponseVO(id="
         + this.getId()
         + ", label="
         + this.getLabel()
         + ", own="
         + this.getOwn()
         + ", permissionTypeId="
         + this.getPermissionTypeId()
         + ", type="
         + this.getType()
         + ", category="
         + this.getCategory()
         + ", children="
         + this.getChildren()
         + ")";
   }
}
