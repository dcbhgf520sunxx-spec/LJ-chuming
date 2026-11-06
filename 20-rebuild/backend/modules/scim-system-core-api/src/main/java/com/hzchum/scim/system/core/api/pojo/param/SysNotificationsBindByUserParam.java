package com.hzchum.scim.system.core.api.pojo.param;

import io.swagger.annotations.ApiModelProperty;

public class SysNotificationsBindByUserParam {
   @ApiModelProperty(name = "registrationId", notes = "设备id")
   private String registrationId;
   @ApiModelProperty(name = "platform", notes = "平台类型")
   private String platform;

   public SysNotificationsBindByUserParam(final String registrationId, final String platform) {
      this.registrationId = registrationId;
      this.platform = platform;
   }

   public SysNotificationsBindByUserParam() {
   }

   public String getRegistrationId() {
      return this.registrationId;
   }

   public String getPlatform() {
      return this.platform;
   }

   public void setRegistrationId(final String registrationId) {
      this.registrationId = registrationId;
   }

   public void setPlatform(final String platform) {
      this.platform = platform;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof SysNotificationsBindByUserParam)) {
         return false;
      } else {
         SysNotificationsBindByUserParam other = (SysNotificationsBindByUserParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$registrationId = this.getRegistrationId();
            Object other$registrationId = other.getRegistrationId();
            if (this$registrationId == null ? other$registrationId == null : this$registrationId.equals(other$registrationId)) {
               Object this$platform = this.getPlatform();
               Object other$platform = other.getPlatform();
               return this$platform == null ? other$platform == null : this$platform.equals(other$platform);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SysNotificationsBindByUserParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $registrationId = this.getRegistrationId();
      result = result * 59 + ($registrationId == null ? 43 : $registrationId.hashCode());
      Object $platform = this.getPlatform();
      return result * 59 + ($platform == null ? 43 : $platform.hashCode());
   }

   @Override
   public String toString() {
      return "SysNotificationsBindByUserParam(registrationId=" + this.getRegistrationId() + ", platform=" + this.getPlatform() + ")";
   }
}
