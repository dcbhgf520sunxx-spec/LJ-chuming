package com.hzchum.scim.system.core.api.pojo.dto;

import java.util.List;

public class MenuFirst {
   private String component;
   private String name;
   private String path;
   private String redirect;
   private Boolean hidden;
   private Boolean alwaysShow;
   private MenuMeta meta;
   private Integer type;
   private Integer sort;
   private List<PermissionDTO> permission;
   private List<MenuFirst> children;

   public String getComponent() {
      return this.component;
   }

   public String getName() {
      return this.name;
   }

   public String getPath() {
      return this.path;
   }

   public String getRedirect() {
      return this.redirect;
   }

   public Boolean getHidden() {
      return this.hidden;
   }

   public Boolean getAlwaysShow() {
      return this.alwaysShow;
   }

   public MenuMeta getMeta() {
      return this.meta;
   }

   public Integer getType() {
      return this.type;
   }

   public Integer getSort() {
      return this.sort;
   }

   public List<PermissionDTO> getPermission() {
      return this.permission;
   }

   public List<MenuFirst> getChildren() {
      return this.children;
   }

   public void setComponent(final String component) {
      this.component = component;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setPath(final String path) {
      this.path = path;
   }

   public void setRedirect(final String redirect) {
      this.redirect = redirect;
   }

   public void setHidden(final Boolean hidden) {
      this.hidden = hidden;
   }

   public void setAlwaysShow(final Boolean alwaysShow) {
      this.alwaysShow = alwaysShow;
   }

   public void setMeta(final MenuMeta meta) {
      this.meta = meta;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   public void setPermission(final List<PermissionDTO> permission) {
      this.permission = permission;
   }

   public void setChildren(final List<MenuFirst> children) {
      this.children = children;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MenuFirst)) {
         return false;
      }

      MenuFirst other = (MenuFirst)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$hidden = this.getHidden();
      Object other$hidden = other.getHidden();
      if (this$hidden == null ? other$hidden == null : this$hidden.equals(other$hidden)) {
         Object this$alwaysShow = this.getAlwaysShow();
         Object other$alwaysShow = other.getAlwaysShow();
         if (this$alwaysShow == null ? other$alwaysShow == null : this$alwaysShow.equals(other$alwaysShow)) {
            Object this$type = this.getType();
            Object other$type = other.getType();
            if (this$type == null ? other$type == null : this$type.equals(other$type)) {
               Object this$sort = this.getSort();
               Object other$sort = other.getSort();
               if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                  Object this$component = this.getComponent();
                  Object other$component = other.getComponent();
                  if (this$component == null ? other$component == null : this$component.equals(other$component)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                        Object this$path = this.getPath();
                        Object other$path = other.getPath();
                        if (this$path == null ? other$path == null : this$path.equals(other$path)) {
                           Object this$redirect = this.getRedirect();
                           Object other$redirect = other.getRedirect();
                           if (this$redirect == null ? other$redirect == null : this$redirect.equals(other$redirect)) {
                              Object this$meta = this.getMeta();
                              Object other$meta = other.getMeta();
                              if (this$meta == null ? other$meta == null : this$meta.equals(other$meta)) {
                                 Object this$permission = this.getPermission();
                                 Object other$permission = other.getPermission();
                                 if (this$permission == null ? other$permission == null : this$permission.equals(other$permission)) {
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
      return other instanceof MenuFirst;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $hidden = this.getHidden();
      result = result * 59 + ($hidden == null ? 43 : $hidden.hashCode());
      Object $alwaysShow = this.getAlwaysShow();
      result = result * 59 + ($alwaysShow == null ? 43 : $alwaysShow.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $component = this.getComponent();
      result = result * 59 + ($component == null ? 43 : $component.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $path = this.getPath();
      result = result * 59 + ($path == null ? 43 : $path.hashCode());
      Object $redirect = this.getRedirect();
      result = result * 59 + ($redirect == null ? 43 : $redirect.hashCode());
      Object $meta = this.getMeta();
      result = result * 59 + ($meta == null ? 43 : $meta.hashCode());
      Object $permission = this.getPermission();
      result = result * 59 + ($permission == null ? 43 : $permission.hashCode());
      Object $children = this.getChildren();
      return result * 59 + ($children == null ? 43 : $children.hashCode());
   }

   @Override
   public String toString() {
      return "MenuFirst(component="
         + this.getComponent()
         + ", name="
         + this.getName()
         + ", path="
         + this.getPath()
         + ", redirect="
         + this.getRedirect()
         + ", hidden="
         + this.getHidden()
         + ", alwaysShow="
         + this.getAlwaysShow()
         + ", meta="
         + this.getMeta()
         + ", type="
         + this.getType()
         + ", sort="
         + this.getSort()
         + ", permission="
         + this.getPermission()
         + ", children="
         + this.getChildren()
         + ")";
   }
}
