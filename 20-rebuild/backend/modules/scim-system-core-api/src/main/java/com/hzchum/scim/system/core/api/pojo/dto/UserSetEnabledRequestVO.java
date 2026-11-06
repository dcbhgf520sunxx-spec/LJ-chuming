package com.hzchum.scim.system.core.api.pojo.dto;

import javax.validation.constraints.NotNull;

public class UserSetEnabledRequestVO {
   @NotNull(message = "用户id不能为空")
   private Long id;
   @NotNull(message = "用户状态不能为空")
   private Boolean enabled;

   public Long getId() {
      return this.id;
   }

   public Boolean getEnabled() {
      return this.enabled;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setEnabled(final Boolean enabled) {
      this.enabled = enabled;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof UserSetEnabledRequestVO)) {
         return false;
      } else {
         UserSetEnabledRequestVO other = (UserSetEnabledRequestVO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$enabled = this.getEnabled();
               Object other$enabled = other.getEnabled();
               return this$enabled == null ? other$enabled == null : this$enabled.equals(other$enabled);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof UserSetEnabledRequestVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $enabled = this.getEnabled();
      return result * 59 + ($enabled == null ? 43 : $enabled.hashCode());
   }

   @Override
   public String toString() {
      return "UserSetEnabledRequestVO(id=" + this.getId() + ", enabled=" + this.getEnabled() + ")";
   }
}
