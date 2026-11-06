package com.hzchum.scim.system.core.api.pojo.dto.DingDing;

import java.util.List;

public class UserChangeInfo {
   private String CorpId;
   private String EventType;
   private List<String> UserId;
   private String OptStaffId;
   private String TimeStamp;

   public String getCorpId() {
      return this.CorpId;
   }

   public String getEventType() {
      return this.EventType;
   }

   public List<String> getUserId() {
      return this.UserId;
   }

   public String getOptStaffId() {
      return this.OptStaffId;
   }

   public String getTimeStamp() {
      return this.TimeStamp;
   }

   public void setCorpId(final String CorpId) {
      this.CorpId = CorpId;
   }

   public void setEventType(final String EventType) {
      this.EventType = EventType;
   }

   public void setUserId(final List<String> UserId) {
      this.UserId = UserId;
   }

   public void setOptStaffId(final String OptStaffId) {
      this.OptStaffId = OptStaffId;
   }

   public void setTimeStamp(final String TimeStamp) {
      this.TimeStamp = TimeStamp;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof UserChangeInfo)) {
         return false;
      }

      UserChangeInfo other = (UserChangeInfo)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$CorpId = this.getCorpId();
      Object other$CorpId = other.getCorpId();
      if (this$CorpId == null ? other$CorpId == null : this$CorpId.equals(other$CorpId)) {
         Object this$EventType = this.getEventType();
         Object other$EventType = other.getEventType();
         if (this$EventType == null ? other$EventType == null : this$EventType.equals(other$EventType)) {
            Object this$UserId = this.getUserId();
            Object other$UserId = other.getUserId();
            if (this$UserId == null ? other$UserId == null : this$UserId.equals(other$UserId)) {
               Object this$OptStaffId = this.getOptStaffId();
               Object other$OptStaffId = other.getOptStaffId();
               if (this$OptStaffId == null ? other$OptStaffId == null : this$OptStaffId.equals(other$OptStaffId)) {
                  Object this$TimeStamp = this.getTimeStamp();
                  Object other$TimeStamp = other.getTimeStamp();
                  return this$TimeStamp == null ? other$TimeStamp == null : this$TimeStamp.equals(other$TimeStamp);
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
      return other instanceof UserChangeInfo;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $CorpId = this.getCorpId();
      result = result * 59 + ($CorpId == null ? 43 : $CorpId.hashCode());
      Object $EventType = this.getEventType();
      result = result * 59 + ($EventType == null ? 43 : $EventType.hashCode());
      Object $UserId = this.getUserId();
      result = result * 59 + ($UserId == null ? 43 : $UserId.hashCode());
      Object $OptStaffId = this.getOptStaffId();
      result = result * 59 + ($OptStaffId == null ? 43 : $OptStaffId.hashCode());
      Object $TimeStamp = this.getTimeStamp();
      return result * 59 + ($TimeStamp == null ? 43 : $TimeStamp.hashCode());
   }

   @Override
   public String toString() {
      return "UserChangeInfo(CorpId="
         + this.getCorpId()
         + ", EventType="
         + this.getEventType()
         + ", UserId="
         + this.getUserId()
         + ", OptStaffId="
         + this.getOptStaffId()
         + ", TimeStamp="
         + this.getTimeStamp()
         + ")";
   }
}
