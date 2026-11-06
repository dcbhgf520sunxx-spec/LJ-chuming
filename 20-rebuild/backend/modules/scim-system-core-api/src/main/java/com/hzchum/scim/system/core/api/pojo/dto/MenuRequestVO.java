package com.hzchum.scim.system.core.api.pojo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class MenuRequestVO {
   private Long id;
   @NotNull(message = "菜单父id不能为空")
   private Long pid;
   @NotNull(message = "菜单种类不能为空")
   private Integer category;
   @NotNull(message = "菜单类型不能为空")
   private Integer type;
   @NotBlank(message = "名称不能为空")
   private String name;
   private String permission;
   private Long permissionTypeId;
   private String icon;
   private String path;
   private String redirect;
   private String component;
   private String componentName;
   private Boolean iframe;
   private Boolean cache;
   private Boolean hidden;
   private Integer sort;
   private Boolean alwaysShow;

   public Long getId() {
      return this.id;
   }

   public Long getPid() {
      return this.pid;
   }

   public Integer getCategory() {
      return this.category;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   public String getPermission() {
      return this.permission;
   }

   public Long getPermissionTypeId() {
      return this.permissionTypeId;
   }

   public String getIcon() {
      return this.icon;
   }

   public String getPath() {
      return this.path;
   }

   public String getRedirect() {
      return this.redirect;
   }

   public String getComponent() {
      return this.component;
   }

   public String getComponentName() {
      return this.componentName;
   }

   public Boolean getIframe() {
      return this.iframe;
   }

   public Boolean getCache() {
      return this.cache;
   }

   public Boolean getHidden() {
      return this.hidden;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Boolean getAlwaysShow() {
      return this.alwaysShow;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setPid(final Long pid) {
      this.pid = pid;
   }

   public void setCategory(final Integer category) {
      this.category = category;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setPermission(final String permission) {
      this.permission = permission;
   }

   public void setPermissionTypeId(final Long permissionTypeId) {
      this.permissionTypeId = permissionTypeId;
   }

   public void setIcon(final String icon) {
      this.icon = icon;
   }

   public void setPath(final String path) {
      this.path = path;
   }

   public void setRedirect(final String redirect) {
      this.redirect = redirect;
   }

   public void setComponent(final String component) {
      this.component = component;
   }

   public void setComponentName(final String componentName) {
      this.componentName = componentName;
   }

   public void setIframe(final Boolean iframe) {
      this.iframe = iframe;
   }

   public void setCache(final Boolean cache) {
      this.cache = cache;
   }

   public void setHidden(final Boolean hidden) {
      this.hidden = hidden;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   public void setAlwaysShow(final Boolean alwaysShow) {
      this.alwaysShow = alwaysShow;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MenuRequestVO)) {
         return false;
      }

      MenuRequestVO other = (MenuRequestVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$pid = this.getPid();
         Object other$pid = other.getPid();
         if (this$pid == null ? other$pid == null : this$pid.equals(other$pid)) {
            Object this$category = this.getCategory();
            Object other$category = other.getCategory();
            if (this$category == null ? other$category == null : this$category.equals(other$category)) {
               Object this$type = this.getType();
               Object other$type = other.getType();
               if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                  Object this$permissionTypeId = this.getPermissionTypeId();
                  Object other$permissionTypeId = other.getPermissionTypeId();
                  if (this$permissionTypeId == null ? other$permissionTypeId == null : this$permissionTypeId.equals(other$permissionTypeId)) {
                     Object this$iframe = this.getIframe();
                     Object other$iframe = other.getIframe();
                     if (this$iframe == null ? other$iframe == null : this$iframe.equals(other$iframe)) {
                        Object this$cache = this.getCache();
                        Object other$cache = other.getCache();
                        if (this$cache == null ? other$cache == null : this$cache.equals(other$cache)) {
                           Object this$hidden = this.getHidden();
                           Object other$hidden = other.getHidden();
                           if (this$hidden == null ? other$hidden == null : this$hidden.equals(other$hidden)) {
                              Object this$sort = this.getSort();
                              Object other$sort = other.getSort();
                              if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                                 Object this$alwaysShow = this.getAlwaysShow();
                                 Object other$alwaysShow = other.getAlwaysShow();
                                 if (this$alwaysShow == null ? other$alwaysShow == null : this$alwaysShow.equals(other$alwaysShow)) {
                                    Object this$name = this.getName();
                                    Object other$name = other.getName();
                                    if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                       Object this$permission = this.getPermission();
                                       Object other$permission = other.getPermission();
                                       if (this$permission == null ? other$permission == null : this$permission.equals(other$permission)) {
                                          Object this$icon = this.getIcon();
                                          Object other$icon = other.getIcon();
                                          if (this$icon == null ? other$icon == null : this$icon.equals(other$icon)) {
                                             Object this$path = this.getPath();
                                             Object other$path = other.getPath();
                                             if (this$path == null ? other$path == null : this$path.equals(other$path)) {
                                                Object this$redirect = this.getRedirect();
                                                Object other$redirect = other.getRedirect();
                                                if (this$redirect == null ? other$redirect == null : this$redirect.equals(other$redirect)) {
                                                   Object this$component = this.getComponent();
                                                   Object other$component = other.getComponent();
                                                   if (this$component == null ? other$component == null : this$component.equals(other$component)) {
                                                      Object this$componentName = this.getComponentName();
                                                      Object other$componentName = other.getComponentName();
                                                      return this$componentName == null
                                                         ? other$componentName == null
                                                         : this$componentName.equals(other$componentName);
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
      return other instanceof MenuRequestVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $pid = this.getPid();
      result = result * 59 + ($pid == null ? 43 : $pid.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $permissionTypeId = this.getPermissionTypeId();
      result = result * 59 + ($permissionTypeId == null ? 43 : $permissionTypeId.hashCode());
      Object $iframe = this.getIframe();
      result = result * 59 + ($iframe == null ? 43 : $iframe.hashCode());
      Object $cache = this.getCache();
      result = result * 59 + ($cache == null ? 43 : $cache.hashCode());
      Object $hidden = this.getHidden();
      result = result * 59 + ($hidden == null ? 43 : $hidden.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $alwaysShow = this.getAlwaysShow();
      result = result * 59 + ($alwaysShow == null ? 43 : $alwaysShow.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $permission = this.getPermission();
      result = result * 59 + ($permission == null ? 43 : $permission.hashCode());
      Object $icon = this.getIcon();
      result = result * 59 + ($icon == null ? 43 : $icon.hashCode());
      Object $path = this.getPath();
      result = result * 59 + ($path == null ? 43 : $path.hashCode());
      Object $redirect = this.getRedirect();
      result = result * 59 + ($redirect == null ? 43 : $redirect.hashCode());
      Object $component = this.getComponent();
      result = result * 59 + ($component == null ? 43 : $component.hashCode());
      Object $componentName = this.getComponentName();
      return result * 59 + ($componentName == null ? 43 : $componentName.hashCode());
   }

   @Override
   public String toString() {
      return "MenuRequestVO(id="
         + this.getId()
         + ", pid="
         + this.getPid()
         + ", category="
         + this.getCategory()
         + ", type="
         + this.getType()
         + ", name="
         + this.getName()
         + ", permission="
         + this.getPermission()
         + ", permissionTypeId="
         + this.getPermissionTypeId()
         + ", icon="
         + this.getIcon()
         + ", path="
         + this.getPath()
         + ", redirect="
         + this.getRedirect()
         + ", component="
         + this.getComponent()
         + ", componentName="
         + this.getComponentName()
         + ", iframe="
         + this.getIframe()
         + ", cache="
         + this.getCache()
         + ", hidden="
         + this.getHidden()
         + ", sort="
         + this.getSort()
         + ", alwaysShow="
         + this.getAlwaysShow()
         + ")";
   }
}
