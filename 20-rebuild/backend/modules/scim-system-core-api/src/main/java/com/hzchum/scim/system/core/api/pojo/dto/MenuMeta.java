package com.hzchum.scim.system.core.api.pojo.dto;

public class MenuMeta {
   private String title;
   private String icon;
   private Boolean noCache;

   public String getTitle() {
      return this.title;
   }

   public String getIcon() {
      return this.icon;
   }

   public Boolean getNoCache() {
      return this.noCache;
   }

   public void setTitle(final String title) {
      this.title = title;
   }

   public void setIcon(final String icon) {
      this.icon = icon;
   }

   public void setNoCache(final Boolean noCache) {
      this.noCache = noCache;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MenuMeta)) {
         return false;
      }

      MenuMeta other = (MenuMeta)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$noCache = this.getNoCache();
      Object other$noCache = other.getNoCache();
      if (this$noCache == null ? other$noCache == null : this$noCache.equals(other$noCache)) {
         Object this$title = this.getTitle();
         Object other$title = other.getTitle();
         if (this$title == null ? other$title == null : this$title.equals(other$title)) {
            Object this$icon = this.getIcon();
            Object other$icon = other.getIcon();
            return this$icon == null ? other$icon == null : this$icon.equals(other$icon);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MenuMeta;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $noCache = this.getNoCache();
      result = result * 59 + ($noCache == null ? 43 : $noCache.hashCode());
      Object $title = this.getTitle();
      result = result * 59 + ($title == null ? 43 : $title.hashCode());
      Object $icon = this.getIcon();
      return result * 59 + ($icon == null ? 43 : $icon.hashCode());
   }

   @Override
   public String toString() {
      return "MenuMeta(title=" + this.getTitle() + ", icon=" + this.getIcon() + ", noCache=" + this.getNoCache() + ")";
   }
}
