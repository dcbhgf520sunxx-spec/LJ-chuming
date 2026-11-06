package com.hzchum.scim.system.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@ApiModel(value = "Menu对象", description = "")
@TableName("sys_menu")
@Table(name = "sys_menu")
public class Menu extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(value = "id", type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "cache")
   @JsonProperty("cache")
   @JSONField(name = "cache")
   @TableField("cache")
   @Column(name = "cache")
   private Boolean cache;
   @ApiModelProperty(name = "component")
   @JsonProperty("component")
   @JSONField(name = "component")
   @TableField("component")
   @Column(name = "component")
   private String component;
   @ApiModelProperty(name = "component_name")
   @JsonProperty("component_name")
   @JSONField(name = "component_name")
   @TableField("component_name")
   @Column(name = "component_name")
   private String componentName;
   @ApiModelProperty(name = "icon")
   @JsonProperty("icon")
   @JSONField(name = "icon")
   @TableField("icon")
   @Column(name = "icon")
   private String icon;
   @ApiModelProperty(name = "iframe")
   @JsonProperty("iframe")
   @JSONField(name = "iframe")
   @TableField("iframe")
   @Column(name = "iframe")
   private Boolean iframe;
   @ApiModelProperty(name = "name")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name")
   private String name;
   @ApiModelProperty(name = "path")
   @JsonProperty("path")
   @JSONField(name = "path")
   @TableField("path")
   @Column(name = "path")
   private String path;
   @ApiModelProperty(name = "permission")
   @JsonProperty("permission")
   @JSONField(name = "permission")
   @TableField("permission")
   @Column(name = "permission")
   private String permission;
   @ApiModelProperty(name = "sort")
   @JsonProperty("sort")
   @JSONField(name = "sort")
   @TableField("sort")
   @Column(name = "sort")
   private Integer sort;
   @ApiModelProperty(name = "always_show")
   @JsonProperty("always_show")
   @JSONField(name = "always_show")
   @TableField("always_show")
   @Column(name = "always_show")
   private Boolean alwaysShow;
   @ApiModelProperty(name = "category")
   @JsonProperty("category")
   @JSONField(name = "category")
   @TableField("category")
   @Column(name = "category")
   private Integer category;
   @ApiModelProperty(name = "hidden")
   @JsonProperty("hidden")
   @JSONField(name = "hidden")
   @TableField("hidden")
   @Column(name = "hidden")
   private Boolean hidden;
   @ApiModelProperty(name = "permission_type_id")
   @JsonProperty("permission_type_id")
   @JSONField(name = "permission_type_id")
   @TableField("permission_type_id")
   @Column(name = "permission_type_id")
   private Long permissionTypeId;
   @ApiModelProperty(name = "pid")
   @JsonProperty("pid")
   @JSONField(name = "pid")
   @TableField("pid")
   @Column(name = "pid")
   private Long pid;
   @ApiModelProperty(name = "redirect")
   @JsonProperty("redirect")
   @JSONField(name = "redirect")
   @TableField("redirect")
   @Column(name = "redirect")
   private String redirect;
   @ApiModelProperty(name = "type")
   @JsonProperty("type")
   @JSONField(name = "type")
   @TableField("type")
   @Column(name = "type")
   private Integer type;
   @ApiModelProperty(name = "boolMainSystem", value = "是否为主系统：0false否，1true是", notes = "是否为主系统：0false否，1true是")
   @JsonProperty("boolMainSystem")
   @JSONField(name = "boolMainSystem")
   @TableField("bool_main_system")
   @Column(name = "bool_main_system", columnDefinition = "tinyint(1) default '0' COMMENT '是否为主系统：0false否，1true是'", nullable = false)
   private Boolean boolMainSystem;

   public static Menu.MenuBuilder builder() {
      return new Menu.MenuBuilder();
   }

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

   @JsonProperty("id")
   public Menu setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("cache")
   public Menu setCache(final Boolean cache) {
      this.cache = cache;
      return this;
   }

   @JsonProperty("component")
   public Menu setComponent(final String component) {
      this.component = component;
      return this;
   }

   @JsonProperty("component_name")
   public Menu setComponentName(final String componentName) {
      this.componentName = componentName;
      return this;
   }

   @JsonProperty("icon")
   public Menu setIcon(final String icon) {
      this.icon = icon;
      return this;
   }

   @JsonProperty("iframe")
   public Menu setIframe(final Boolean iframe) {
      this.iframe = iframe;
      return this;
   }

   @JsonProperty("name")
   public Menu setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("path")
   public Menu setPath(final String path) {
      this.path = path;
      return this;
   }

   @JsonProperty("permission")
   public Menu setPermission(final String permission) {
      this.permission = permission;
      return this;
   }

   @JsonProperty("sort")
   public Menu setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @JsonProperty("always_show")
   public Menu setAlwaysShow(final Boolean alwaysShow) {
      this.alwaysShow = alwaysShow;
      return this;
   }

   @JsonProperty("category")
   public Menu setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   @JsonProperty("hidden")
   public Menu setHidden(final Boolean hidden) {
      this.hidden = hidden;
      return this;
   }

   @JsonProperty("permission_type_id")
   public Menu setPermissionTypeId(final Long permissionTypeId) {
      this.permissionTypeId = permissionTypeId;
      return this;
   }

   @JsonProperty("pid")
   public Menu setPid(final Long pid) {
      this.pid = pid;
      return this;
   }

   @JsonProperty("redirect")
   public Menu setRedirect(final String redirect) {
      this.redirect = redirect;
      return this;
   }

   @JsonProperty("type")
   public Menu setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("boolMainSystem")
   public Menu setBoolMainSystem(final Boolean boolMainSystem) {
      this.boolMainSystem = boolMainSystem;
      return this;
   }

   @Override
   public String toString() {
      return "Menu(id="
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
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof Menu)) {
         return false;
      }

      Menu other = (Menu)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
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
                                                         return this$redirect == null ? other$redirect == null : this$redirect.equals(other$redirect);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof Menu;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
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
      return result * 59 + ($redirect == null ? 43 : $redirect.hashCode());
   }

   public Menu(
      final Long id,
      final Boolean cache,
      final String component,
      final String componentName,
      final String icon,
      final Boolean iframe,
      final String name,
      final String path,
      final String permission,
      final Integer sort,
      final Boolean alwaysShow,
      final Integer category,
      final Boolean hidden,
      final Long permissionTypeId,
      final Long pid,
      final String redirect,
      final Integer type,
      final Boolean boolMainSystem
   ) {
      this.id = id;
      this.cache = cache;
      this.component = component;
      this.componentName = componentName;
      this.icon = icon;
      this.iframe = iframe;
      this.name = name;
      this.path = path;
      this.permission = permission;
      this.sort = sort;
      this.alwaysShow = alwaysShow;
      this.category = category;
      this.hidden = hidden;
      this.permissionTypeId = permissionTypeId;
      this.pid = pid;
      this.redirect = redirect;
      this.type = type;
      this.boolMainSystem = boolMainSystem;
   }

   public Menu() {
   }

   public static class MenuBuilder {
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

      MenuBuilder() {
      }

      @JsonProperty("id")
      public Menu.MenuBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("cache")
      public Menu.MenuBuilder cache(final Boolean cache) {
         this.cache = cache;
         return this;
      }

      @JsonProperty("component")
      public Menu.MenuBuilder component(final String component) {
         this.component = component;
         return this;
      }

      @JsonProperty("component_name")
      public Menu.MenuBuilder componentName(final String componentName) {
         this.componentName = componentName;
         return this;
      }

      @JsonProperty("icon")
      public Menu.MenuBuilder icon(final String icon) {
         this.icon = icon;
         return this;
      }

      @JsonProperty("iframe")
      public Menu.MenuBuilder iframe(final Boolean iframe) {
         this.iframe = iframe;
         return this;
      }

      @JsonProperty("name")
      public Menu.MenuBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("path")
      public Menu.MenuBuilder path(final String path) {
         this.path = path;
         return this;
      }

      @JsonProperty("permission")
      public Menu.MenuBuilder permission(final String permission) {
         this.permission = permission;
         return this;
      }

      @JsonProperty("sort")
      public Menu.MenuBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      @JsonProperty("always_show")
      public Menu.MenuBuilder alwaysShow(final Boolean alwaysShow) {
         this.alwaysShow = alwaysShow;
         return this;
      }

      @JsonProperty("category")
      public Menu.MenuBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      @JsonProperty("hidden")
      public Menu.MenuBuilder hidden(final Boolean hidden) {
         this.hidden = hidden;
         return this;
      }

      @JsonProperty("permission_type_id")
      public Menu.MenuBuilder permissionTypeId(final Long permissionTypeId) {
         this.permissionTypeId = permissionTypeId;
         return this;
      }

      @JsonProperty("pid")
      public Menu.MenuBuilder pid(final Long pid) {
         this.pid = pid;
         return this;
      }

      @JsonProperty("redirect")
      public Menu.MenuBuilder redirect(final String redirect) {
         this.redirect = redirect;
         return this;
      }

      @JsonProperty("type")
      public Menu.MenuBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("boolMainSystem")
      public Menu.MenuBuilder boolMainSystem(final Boolean boolMainSystem) {
         this.boolMainSystem = boolMainSystem;
         return this;
      }

      public Menu build() {
         return new Menu(
            this.id,
            this.cache,
            this.component,
            this.componentName,
            this.icon,
            this.iframe,
            this.name,
            this.path,
            this.permission,
            this.sort,
            this.alwaysShow,
            this.category,
            this.hidden,
            this.permissionTypeId,
            this.pid,
            this.redirect,
            this.type,
            this.boolMainSystem
         );
      }

      @Override
      public String toString() {
         return "Menu.MenuBuilder(id="
            + this.id
            + ", cache="
            + this.cache
            + ", component="
            + this.component
            + ", componentName="
            + this.componentName
            + ", icon="
            + this.icon
            + ", iframe="
            + this.iframe
            + ", name="
            + this.name
            + ", path="
            + this.path
            + ", permission="
            + this.permission
            + ", sort="
            + this.sort
            + ", alwaysShow="
            + this.alwaysShow
            + ", category="
            + this.category
            + ", hidden="
            + this.hidden
            + ", permissionTypeId="
            + this.permissionTypeId
            + ", pid="
            + this.pid
            + ", redirect="
            + this.redirect
            + ", type="
            + this.type
            + ", boolMainSystem="
            + this.boolMainSystem
            + ")";
      }
   }
}
