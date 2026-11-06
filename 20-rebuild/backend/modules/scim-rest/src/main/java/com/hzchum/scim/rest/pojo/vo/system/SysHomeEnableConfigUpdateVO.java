package com.hzchum.scim.rest.pojo.vo.system;

public class SysHomeEnableConfigUpdateVO {
   private Boolean isEnable;

   public SysHomeEnableConfigUpdateVO(final Boolean isEnable) {
      this.isEnable = isEnable;
   }

   public SysHomeEnableConfigUpdateVO() {
   }

   public Boolean getIsEnable() {
      return this.isEnable;
   }

   public void setIsEnable(final Boolean isEnable) {
      this.isEnable = isEnable;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysHomeEnableConfigUpdateVO)) {
         return false;
      }

      SysHomeEnableConfigUpdateVO other = (SysHomeEnableConfigUpdateVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$isEnable = this.getIsEnable();
      Object other$isEnable = other.getIsEnable();
      return this$isEnable == null ? other$isEnable == null : this$isEnable.equals(other$isEnable);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SysHomeEnableConfigUpdateVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $isEnable = this.getIsEnable();
      return result * 59 + ($isEnable == null ? 43 : $isEnable.hashCode());
   }

   @Override
   public String toString() {
      return "SysHomeEnableConfigUpdateVO(isEnable=" + this.getIsEnable() + ")";
   }
}
