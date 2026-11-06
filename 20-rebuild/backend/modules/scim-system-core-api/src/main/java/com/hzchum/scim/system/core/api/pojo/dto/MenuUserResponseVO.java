package com.hzchum.scim.system.core.api.pojo.dto;

public class MenuUserResponseVO {
   private Long id;
   private String name;
   private String icon;
   private String redirect;
   private Boolean iframe;
   private Boolean isTripartite;

   public static MenuUserResponseVO.MenuUserResponseVOBuilder builder() {
      return new MenuUserResponseVO.MenuUserResponseVOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getIcon() {
      return this.icon;
   }

   public String getRedirect() {
      return this.redirect;
   }

   public Boolean getIframe() {
      return this.iframe;
   }

   public Boolean getIsTripartite() {
      return this.isTripartite;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setIcon(final String icon) {
      this.icon = icon;
   }

   public void setRedirect(final String redirect) {
      this.redirect = redirect;
   }

   public void setIframe(final Boolean iframe) {
      this.iframe = iframe;
   }

   public void setIsTripartite(final Boolean isTripartite) {
      this.isTripartite = isTripartite;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MenuUserResponseVO)) {
         return false;
      }

      MenuUserResponseVO other = (MenuUserResponseVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$iframe = this.getIframe();
         Object other$iframe = other.getIframe();
         if (this$iframe == null ? other$iframe == null : this$iframe.equals(other$iframe)) {
            Object this$isTripartite = this.getIsTripartite();
            Object other$isTripartite = other.getIsTripartite();
            if (this$isTripartite == null ? other$isTripartite == null : this$isTripartite.equals(other$isTripartite)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$icon = this.getIcon();
                  Object other$icon = other.getIcon();
                  if (this$icon == null ? other$icon == null : this$icon.equals(other$icon)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MenuUserResponseVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $iframe = this.getIframe();
      result = result * 59 + ($iframe == null ? 43 : $iframe.hashCode());
      Object $isTripartite = this.getIsTripartite();
      result = result * 59 + ($isTripartite == null ? 43 : $isTripartite.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $icon = this.getIcon();
      result = result * 59 + ($icon == null ? 43 : $icon.hashCode());
      Object $redirect = this.getRedirect();
      return result * 59 + ($redirect == null ? 43 : $redirect.hashCode());
   }

   @Override
   public String toString() {
      return "MenuUserResponseVO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", icon="
         + this.getIcon()
         + ", redirect="
         + this.getRedirect()
         + ", iframe="
         + this.getIframe()
         + ", isTripartite="
         + this.getIsTripartite()
         + ")";
   }

   public MenuUserResponseVO(final Long id, final String name, final String icon, final String redirect, final Boolean iframe, final Boolean isTripartite) {
      this.id = id;
      this.name = name;
      this.icon = icon;
      this.redirect = redirect;
      this.iframe = iframe;
      this.isTripartite = isTripartite;
   }

   public MenuUserResponseVO() {
   }

   public static class MenuUserResponseVOBuilder {
      private Long id;
      private String name;
      private String icon;
      private String redirect;
      private Boolean iframe;
      private Boolean isTripartite;

      MenuUserResponseVOBuilder() {
      }

      public MenuUserResponseVO.MenuUserResponseVOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MenuUserResponseVO.MenuUserResponseVOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public MenuUserResponseVO.MenuUserResponseVOBuilder icon(final String icon) {
         this.icon = icon;
         return this;
      }

      public MenuUserResponseVO.MenuUserResponseVOBuilder redirect(final String redirect) {
         this.redirect = redirect;
         return this;
      }

      public MenuUserResponseVO.MenuUserResponseVOBuilder iframe(final Boolean iframe) {
         this.iframe = iframe;
         return this;
      }

      public MenuUserResponseVO.MenuUserResponseVOBuilder isTripartite(final Boolean isTripartite) {
         this.isTripartite = isTripartite;
         return this;
      }

      public MenuUserResponseVO build() {
         return new MenuUserResponseVO(this.id, this.name, this.icon, this.redirect, this.iframe, this.isTripartite);
      }

      @Override
      public String toString() {
         return "MenuUserResponseVO.MenuUserResponseVOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", icon="
            + this.icon
            + ", redirect="
            + this.redirect
            + ", iframe="
            + this.iframe
            + ", isTripartite="
            + this.isTripartite
            + ")";
      }
   }
}
