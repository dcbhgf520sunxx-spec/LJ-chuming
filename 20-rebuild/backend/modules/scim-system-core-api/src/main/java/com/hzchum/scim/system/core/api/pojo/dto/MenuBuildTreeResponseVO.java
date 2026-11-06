package com.hzchum.scim.system.core.api.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.List;

public class MenuBuildTreeResponseVO {
   private Long id;
   private String path;
   private String redirect;
   private String name;
   private String component;
   private Boolean alwaysShow;
   private Boolean hidden;
   @JsonInclude(Include.NON_NULL)
   private Long branchCompanyId;
   private Boolean boolMainSystem;
   private MenuBuildMetaResponseVO meta;
   private List<MenuBuildTreeResponseVO> children;

   public Long getId() {
      return this.id;
   }

   public String getPath() {
      return this.path;
   }

   public String getRedirect() {
      return this.redirect;
   }

   public String getName() {
      return this.name;
   }

   public String getComponent() {
      return this.component;
   }

   public Boolean getAlwaysShow() {
      return this.alwaysShow;
   }

   public Boolean getHidden() {
      return this.hidden;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public Boolean getBoolMainSystem() {
      return this.boolMainSystem;
   }

   public MenuBuildMetaResponseVO getMeta() {
      return this.meta;
   }

   public List<MenuBuildTreeResponseVO> getChildren() {
      return this.children;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setPath(final String path) {
      this.path = path;
   }

   public void setRedirect(final String redirect) {
      this.redirect = redirect;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setComponent(final String component) {
      this.component = component;
   }

   public void setAlwaysShow(final Boolean alwaysShow) {
      this.alwaysShow = alwaysShow;
   }

   public void setHidden(final Boolean hidden) {
      this.hidden = hidden;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setBoolMainSystem(final Boolean boolMainSystem) {
      this.boolMainSystem = boolMainSystem;
   }

   public void setMeta(final MenuBuildMetaResponseVO meta) {
      this.meta = meta;
   }

   public void setChildren(final List<MenuBuildTreeResponseVO> children) {
      this.children = children;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MenuBuildTreeResponseVO)) {
         return false;
      }

      MenuBuildTreeResponseVO other = (MenuBuildTreeResponseVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$alwaysShow = this.getAlwaysShow();
         Object other$alwaysShow = other.getAlwaysShow();
         if (this$alwaysShow == null ? other$alwaysShow == null : this$alwaysShow.equals(other$alwaysShow)) {
            Object this$hidden = this.getHidden();
            Object other$hidden = other.getHidden();
            if (this$hidden == null ? other$hidden == null : this$hidden.equals(other$hidden)) {
               Object this$branchCompanyId = this.getBranchCompanyId();
               Object other$branchCompanyId = other.getBranchCompanyId();
               if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
                  Object this$boolMainSystem = this.getBoolMainSystem();
                  Object other$boolMainSystem = other.getBoolMainSystem();
                  if (this$boolMainSystem == null ? other$boolMainSystem == null : this$boolMainSystem.equals(other$boolMainSystem)) {
                     Object this$path = this.getPath();
                     Object other$path = other.getPath();
                     if (this$path == null ? other$path == null : this$path.equals(other$path)) {
                        Object this$redirect = this.getRedirect();
                        Object other$redirect = other.getRedirect();
                        if (this$redirect == null ? other$redirect == null : this$redirect.equals(other$redirect)) {
                           Object this$name = this.getName();
                           Object other$name = other.getName();
                           if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                              Object this$component = this.getComponent();
                              Object other$component = other.getComponent();
                              if (this$component == null ? other$component == null : this$component.equals(other$component)) {
                                 Object this$meta = this.getMeta();
                                 Object other$meta = other.getMeta();
                                 if (this$meta == null ? other$meta == null : this$meta.equals(other$meta)) {
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
      return other instanceof MenuBuildTreeResponseVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $alwaysShow = this.getAlwaysShow();
      result = result * 59 + ($alwaysShow == null ? 43 : $alwaysShow.hashCode());
      Object $hidden = this.getHidden();
      result = result * 59 + ($hidden == null ? 43 : $hidden.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $boolMainSystem = this.getBoolMainSystem();
      result = result * 59 + ($boolMainSystem == null ? 43 : $boolMainSystem.hashCode());
      Object $path = this.getPath();
      result = result * 59 + ($path == null ? 43 : $path.hashCode());
      Object $redirect = this.getRedirect();
      result = result * 59 + ($redirect == null ? 43 : $redirect.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $component = this.getComponent();
      result = result * 59 + ($component == null ? 43 : $component.hashCode());
      Object $meta = this.getMeta();
      result = result * 59 + ($meta == null ? 43 : $meta.hashCode());
      Object $children = this.getChildren();
      return result * 59 + ($children == null ? 43 : $children.hashCode());
   }

   @Override
   public String toString() {
      return "MenuBuildTreeResponseVO(id="
         + this.getId()
         + ", path="
         + this.getPath()
         + ", redirect="
         + this.getRedirect()
         + ", name="
         + this.getName()
         + ", component="
         + this.getComponent()
         + ", alwaysShow="
         + this.getAlwaysShow()
         + ", hidden="
         + this.getHidden()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", boolMainSystem="
         + this.getBoolMainSystem()
         + ", meta="
         + this.getMeta()
         + ", children="
         + this.getChildren()
         + ")";
   }
}
