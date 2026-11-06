package com.hzchum.scim.cut.core.api.param;

public class TaskParam {
   Integer plantId;
   String mac;
   String endTime;

   public Integer getPlantId() {
      return this.plantId;
   }

   public String getMac() {
      return this.mac;
   }

   public String getEndTime() {
      return this.endTime;
   }

   public void setPlantId(final Integer plantId) {
      this.plantId = plantId;
   }

   public void setMac(final String mac) {
      this.mac = mac;
   }

   public void setEndTime(final String endTime) {
      this.endTime = endTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TaskParam)) {
         return false;
      }

      TaskParam other = (TaskParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$plantId = this.getPlantId();
      Object other$plantId = other.getPlantId();
      if (this$plantId == null ? other$plantId == null : this$plantId.equals(other$plantId)) {
         Object this$mac = this.getMac();
         Object other$mac = other.getMac();
         if (this$mac == null ? other$mac == null : this$mac.equals(other$mac)) {
            Object this$endTime = this.getEndTime();
            Object other$endTime = other.getEndTime();
            return this$endTime == null ? other$endTime == null : this$endTime.equals(other$endTime);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TaskParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $plantId = this.getPlantId();
      result = result * 59 + ($plantId == null ? 43 : $plantId.hashCode());
      Object $mac = this.getMac();
      result = result * 59 + ($mac == null ? 43 : $mac.hashCode());
      Object $endTime = this.getEndTime();
      return result * 59 + ($endTime == null ? 43 : $endTime.hashCode());
   }

   @Override
   public String toString() {
      return "TaskParam(plantId=" + this.getPlantId() + ", mac=" + this.getMac() + ", endTime=" + this.getEndTime() + ")";
   }
}
