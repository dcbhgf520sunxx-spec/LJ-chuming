package com.hzchum.scim.system.core.api.pojo.dto;

public class LogoConfigVO {
   private Long id;
   private String path;
   private Boolean isDefault;

   public Long getId() {
      return this.id;
   }

   public String getPath() {
      return this.path;
   }

   public Boolean getIsDefault() {
      return this.isDefault;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setPath(final String path) {
      this.path = path;
   }

   public void setIsDefault(final Boolean isDefault) {
      this.isDefault = isDefault;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof LogoConfigVO)) {
         return false;
      }

      LogoConfigVO other = (LogoConfigVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$isDefault = this.getIsDefault();
         Object other$isDefault = other.getIsDefault();
         if (this$isDefault == null ? other$isDefault == null : this$isDefault.equals(other$isDefault)) {
            Object this$path = this.getPath();
            Object other$path = other.getPath();
            return this$path == null ? other$path == null : this$path.equals(other$path);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof LogoConfigVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $isDefault = this.getIsDefault();
      result = result * 59 + ($isDefault == null ? 43 : $isDefault.hashCode());
      Object $path = this.getPath();
      return result * 59 + ($path == null ? 43 : $path.hashCode());
   }

   @Override
   public String toString() {
      return "LogoConfigVO(id=" + this.getId() + ", path=" + this.getPath() + ", isDefault=" + this.getIsDefault() + ")";
   }
}
