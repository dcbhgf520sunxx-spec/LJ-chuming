package com.hzchum.scim.system.core.api.pojo.dto;

import java.util.List;

public class MenuResponseVO {
   private Long id;
   private Boolean cache;
   private String component;
   private String componentName;
   private String icon;
   private Boolean iframe;
   private String name;
   private String path;
   private String permission;
   private Integer sort;
   private Boolean alwaysShow;
   private Integer category;
   private Boolean hidden;
   private Long permissionTypeId;
   private Long pid;
   private String redirect;
   private Integer type;
   private Boolean boolMainSystem;
   List<MenuResponseVO> children;

   public Long getId() {
      return this.id;
   }

   public Boolean getCache() {
      return this.cache;
   }

   public String getComponent() {
      return this.component;
   }

   public String getComponentName() {
      return this.componentName;
   }

   public String getIcon() {
      return this.icon;
   }

   public Boolean getIframe() {
      return this.iframe;
   }

   public String getName() {
      return this.name;
   }

   public String getPath() {
      return this.path;
   }

   public String getPermission() {
      return this.permission;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Boolean getAlwaysShow() {
      return this.alwaysShow;
   }

   public Integer getCategory() {
      return this.category;
   }

   public Boolean getHidden() {
      return this.hidden;
   }

   public Long getPermissionTypeId() {
      return this.permissionTypeId;
   }

   public Long getPid() {
      return this.pid;
   }

   public String getRedirect() {
      return this.redirect;
   }

   public Integer getType() {
      return this.type;
   }

   public Boolean getBoolMainSystem() {
      return this.boolMainSystem;
   }

   public List<MenuResponseVO> getChildren() {
      return this.children;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setCache(final Boolean cache) {
      this.cache = cache;
   }

   public void setComponent(final String component) {
      this.component = component;
   }

   public void setComponentName(final String componentName) {
      this.componentName = componentName;
   }

   public void setIcon(final String icon) {
      this.icon = icon;
   }

   public void setIframe(final Boolean iframe) {
      this.iframe = iframe;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setPath(final String path) {
      this.path = path;
   }

   public void setPermission(final String permission) {
      this.permission = permission;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   public void setAlwaysShow(final Boolean alwaysShow) {
      this.alwaysShow = alwaysShow;
   }

   public void setCategory(final Integer category) {
      this.category = category;
   }

   public void setHidden(final Boolean hidden) {
      this.hidden = hidden;
   }

   public void setPermissionTypeId(final Long permissionTypeId) {
      this.permissionTypeId = permissionTypeId;
   }

   public void setPid(final Long pid) {
      this.pid = pid;
   }

   public void setRedirect(final String redirect) {
      this.redirect = redirect;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setBoolMainSystem(final Boolean boolMainSystem) {
      this.boolMainSystem = boolMainSystem;
   }

   public void setChildren(final List<MenuResponseVO> children) {
      this.children = children;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MenuResponseVO)) {
         return false;
      }

      MenuResponseVO other = (MenuResponseVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$cache = this.getCache();
         Object other$cache = other.getCache();
         if (this$cache == null ? other$cache == null : this$cache.equals(other$cache)) {
            Object this$iframe = this.getIframe();
            Object other$iframe = other.getIframe();
            if (this$iframe == null ? other$iframe == null : this$iframe.equals(other$iframe)) {
               Object this$sort = this.getSort();
               Object other$sort = other.getSort();
               if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                  Object this$alwaysShow = this.getAlwaysShow();
                  Object other$alwaysShow = other.getAlwaysShow();
                  if (this$alwaysShow == null ? other$alwaysShow == null : this$alwaysShow.equals(other$alwaysShow)) {
                     Object this$category = this.getCategory();
                     Object other$category = other.getCategory();
                     if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                        Object this$hidden = this.getHidden();
                        Object other$hidden = other.getHidden();
                        if (this$hidden == null ? other$hidden == null : this$hidden.equals(other$hidden)) {
                           Object this$permissionTypeId = this.getPermissionTypeId();
                           Object other$permissionTypeId = other.getPermissionTypeId();
                           if (this$permissionTypeId == null ? other$permissionTypeId == null : this$permissionTypeId.equals(other$permissionTypeId)) {
                              Object this$pid = this.getPid();
                              Object other$pid = other.getPid();
                              if (this$pid == null ? other$pid == null : this$pid.equals(other$pid)) {
                                 Object this$type = this.getType();
                                 Object other$type = other.getType();
                                 if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                                    Object this$boolMainSystem = this.getBoolMainSystem();
                                    Object other$boolMainSystem = other.getBoolMainSystem();
                                    if (this$boolMainSystem == null ? other$boolMainSystem == null : this$boolMainSystem.equals(other$boolMainSystem)) {
                                       Object this$component = this.getComponent();
                                       Object other$component = other.getComponent();
                                       if (this$component == null ? other$component == null : this$component.equals(other$component)) {
                                          Object this$componentName = this.getComponentName();
                                          Object other$componentName = other.getComponentName();
                                          if (this$componentName == null ? other$componentName == null : this$componentName.equals(other$componentName)) {
                                             Object this$icon = this.getIcon();
                                             Object other$icon = other.getIcon();
                                             if (this$icon == null ? other$icon == null : this$icon.equals(other$icon)) {
                                                Object this$name = this.getName();
                                                Object other$name = other.getName();
                                                if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                   Object this$path = this.getPath();
                                                   Object other$path = other.getPath();
                                                   if (this$path == null ? other$path == null : this$path.equals(other$path)) {
                                                      Object this$permission = this.getPermission();
                                                      Object other$permission = other.getPermission();
                                                      if (this$permission == null ? other$permission == null : this$permission.equals(other$permission)) {
                                                         Object this$redirect = this.getRedirect();
                                                         Object other$redirect = other.getRedirect();
                                                         if (this$redirect == null ? other$redirect == null : this$redirect.equals(other$redirect)) {
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
      return other instanceof MenuResponseVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $cache = this.getCache();
      result = result * 59 + ($cache == null ? 43 : $cache.hashCode());
      Object $iframe = this.getIframe();
      result = result * 59 + ($iframe == null ? 43 : $iframe.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $alwaysShow = this.getAlwaysShow();
      result = result * 59 + ($alwaysShow == null ? 43 : $alwaysShow.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $hidden = this.getHidden();
      result = result * 59 + ($hidden == null ? 43 : $hidden.hashCode());
      Object $permissionTypeId = this.getPermissionTypeId();
      result = result * 59 + ($permissionTypeId == null ? 43 : $permissionTypeId.hashCode());
      Object $pid = this.getPid();
      result = result * 59 + ($pid == null ? 43 : $pid.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $boolMainSystem = this.getBoolMainSystem();
      result = result * 59 + ($boolMainSystem == null ? 43 : $boolMainSystem.hashCode());
      Object $component = this.getComponent();
      result = result * 59 + ($component == null ? 43 : $component.hashCode());
      Object $componentName = this.getComponentName();
      result = result * 59 + ($componentName == null ? 43 : $componentName.hashCode());
      Object $icon = this.getIcon();
      result = result * 59 + ($icon == null ? 43 : $icon.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $path = this.getPath();
      result = result * 59 + ($path == null ? 43 : $path.hashCode());
      Object $permission = this.getPermission();
      result = result * 59 + ($permission == null ? 43 : $permission.hashCode());
      Object $redirect = this.getRedirect();
      result = result * 59 + ($redirect == null ? 43 : $redirect.hashCode());
      Object $children = this.getChildren();
      return result * 59 + ($children == null ? 43 : $children.hashCode());
   }

   @Override
   public String toString() {
      return "MenuResponseVO(id="
         + this.getId()
         + ", cache="
         + this.getCache()
         + ", component="
         + this.getComponent()
         + ", componentName="
         + this.getComponentName()
         + ", icon="
         + this.getIcon()
         + ", iframe="
         + this.getIframe()
         + ", name="
         + this.getName()
         + ", path="
         + this.getPath()
         + ", permission="
         + this.getPermission()
         + ", sort="
         + this.getSort()
         + ", alwaysShow="
         + this.getAlwaysShow()
         + ", category="
         + this.getCategory()
         + ", hidden="
         + this.getHidden()
         + ", permissionTypeId="
         + this.getPermissionTypeId()
         + ", pid="
         + this.getPid()
         + ", redirect="
         + this.getRedirect()
         + ", type="
         + this.getType()
         + ", boolMainSystem="
         + this.getBoolMainSystem()
         + ", children="
         + this.getChildren()
         + ")";
   }
}
