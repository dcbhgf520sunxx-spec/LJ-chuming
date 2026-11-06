package com.hzchum.scim.iot.core.api.pojo.dto.equipment.deviceTypeRead;

public class DeviceCurrentTypeVos {
   private Integer equipmentId;
   private Integer stationId;
   private String equipmentName;
   private Integer type;
   private Long startTime;
   private Long newTime;

   public static DeviceCurrentTypeVos.DeviceCurrentTypeVosBuilder builder() {
      return new DeviceCurrentTypeVos.DeviceCurrentTypeVosBuilder();
   }

   public Integer getEquipmentId() {
      return this.equipmentId;
   }

   public Integer getStationId() {
      return this.stationId;
   }

   public String getEquipmentName() {
      return this.equipmentName;
   }

   public Integer getType() {
      return this.type;
   }

   public Long getStartTime() {
      return this.startTime;
   }

   public Long getNewTime() {
      return this.newTime;
   }

   public void setEquipmentId(final Integer equipmentId) {
      this.equipmentId = equipmentId;
   }

   public void setStationId(final Integer stationId) {
      this.stationId = stationId;
   }

   public void setEquipmentName(final String equipmentName) {
      this.equipmentName = equipmentName;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setStartTime(final Long startTime) {
      this.startTime = startTime;
   }

   public void setNewTime(final Long newTime) {
      this.newTime = newTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DeviceCurrentTypeVos)) {
         return false;
      }

      DeviceCurrentTypeVos other = (DeviceCurrentTypeVos)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$equipmentId = this.getEquipmentId();
      Object other$equipmentId = other.getEquipmentId();
      if (this$equipmentId == null ? other$equipmentId == null : this$equipmentId.equals(other$equipmentId)) {
         Object this$stationId = this.getStationId();
         Object other$stationId = other.getStationId();
         if (this$stationId == null ? other$stationId == null : this$stationId.equals(other$stationId)) {
            Object this$type = this.getType();
            Object other$type = other.getType();
            if (this$type == null ? other$type == null : this$type.equals(other$type)) {
               Object this$startTime = this.getStartTime();
               Object other$startTime = other.getStartTime();
               if (this$startTime == null ? other$startTime == null : this$startTime.equals(other$startTime)) {
                  Object this$newTime = this.getNewTime();
                  Object other$newTime = other.getNewTime();
                  if (this$newTime == null ? other$newTime == null : this$newTime.equals(other$newTime)) {
                     Object this$equipmentName = this.getEquipmentName();
                     Object other$equipmentName = other.getEquipmentName();
                     return this$equipmentName == null ? other$equipmentName == null : this$equipmentName.equals(other$equipmentName);
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
      return other instanceof DeviceCurrentTypeVos;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $equipmentId = this.getEquipmentId();
      result = result * 59 + ($equipmentId == null ? 43 : $equipmentId.hashCode());
      Object $stationId = this.getStationId();
      result = result * 59 + ($stationId == null ? 43 : $stationId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $startTime = this.getStartTime();
      result = result * 59 + ($startTime == null ? 43 : $startTime.hashCode());
      Object $newTime = this.getNewTime();
      result = result * 59 + ($newTime == null ? 43 : $newTime.hashCode());
      Object $equipmentName = this.getEquipmentName();
      return result * 59 + ($equipmentName == null ? 43 : $equipmentName.hashCode());
   }

   @Override
   public String toString() {
      return "DeviceCurrentTypeVos(equipmentId="
         + this.getEquipmentId()
         + ", stationId="
         + this.getStationId()
         + ", equipmentName="
         + this.getEquipmentName()
         + ", type="
         + this.getType()
         + ", startTime="
         + this.getStartTime()
         + ", newTime="
         + this.getNewTime()
         + ")";
   }

   public DeviceCurrentTypeVos(
      final Integer equipmentId, final Integer stationId, final String equipmentName, final Integer type, final Long startTime, final Long newTime
   ) {
      this.equipmentId = equipmentId;
      this.stationId = stationId;
      this.equipmentName = equipmentName;
      this.type = type;
      this.startTime = startTime;
      this.newTime = newTime;
   }

   public DeviceCurrentTypeVos() {
   }

   public static class DeviceCurrentTypeVosBuilder {
      private Integer equipmentId;
      private Integer stationId;
      private String equipmentName;
      private Integer type;
      private Long startTime;
      private Long newTime;

      DeviceCurrentTypeVosBuilder() {
      }

      public DeviceCurrentTypeVos.DeviceCurrentTypeVosBuilder equipmentId(final Integer equipmentId) {
         this.equipmentId = equipmentId;
         return this;
      }

      public DeviceCurrentTypeVos.DeviceCurrentTypeVosBuilder stationId(final Integer stationId) {
         this.stationId = stationId;
         return this;
      }

      public DeviceCurrentTypeVos.DeviceCurrentTypeVosBuilder equipmentName(final String equipmentName) {
         this.equipmentName = equipmentName;
         return this;
      }

      public DeviceCurrentTypeVos.DeviceCurrentTypeVosBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public DeviceCurrentTypeVos.DeviceCurrentTypeVosBuilder startTime(final Long startTime) {
         this.startTime = startTime;
         return this;
      }

      public DeviceCurrentTypeVos.DeviceCurrentTypeVosBuilder newTime(final Long newTime) {
         this.newTime = newTime;
         return this;
      }

      public DeviceCurrentTypeVos build() {
         return new DeviceCurrentTypeVos(this.equipmentId, this.stationId, this.equipmentName, this.type, this.startTime, this.newTime);
      }

      @Override
      public String toString() {
         return "DeviceCurrentTypeVos.DeviceCurrentTypeVosBuilder(equipmentId="
            + this.equipmentId
            + ", stationId="
            + this.stationId
            + ", equipmentName="
            + this.equipmentName
            + ", type="
            + this.type
            + ", startTime="
            + this.startTime
            + ", newTime="
            + this.newTime
            + ")";
      }
   }
}
