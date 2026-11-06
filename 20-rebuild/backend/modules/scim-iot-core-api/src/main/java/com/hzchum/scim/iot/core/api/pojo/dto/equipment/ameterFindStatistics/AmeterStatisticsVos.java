package com.hzchum.scim.iot.core.api.pojo.dto.equipment.ameterFindStatistics;

import java.util.List;

public class AmeterStatisticsVos {
   private String yearAndMonthAndDay;
   private String equipmentId;
   private String equipmentName;
   private String prodLineId;
   private String prodLineName;
   private List<DeviceAmmeterHourList> deviceAmmeterHourList;
   private double allPowerExpend;

   public static AmeterStatisticsVos.AmeterStatisticsVosBuilder builder() {
      return new AmeterStatisticsVos.AmeterStatisticsVosBuilder();
   }

   public String getYearAndMonthAndDay() {
      return this.yearAndMonthAndDay;
   }

   public String getEquipmentId() {
      return this.equipmentId;
   }

   public String getEquipmentName() {
      return this.equipmentName;
   }

   public String getProdLineId() {
      return this.prodLineId;
   }

   public String getProdLineName() {
      return this.prodLineName;
   }

   public List<DeviceAmmeterHourList> getDeviceAmmeterHourList() {
      return this.deviceAmmeterHourList;
   }

   public double getAllPowerExpend() {
      return this.allPowerExpend;
   }

   public void setYearAndMonthAndDay(final String yearAndMonthAndDay) {
      this.yearAndMonthAndDay = yearAndMonthAndDay;
   }

   public void setEquipmentId(final String equipmentId) {
      this.equipmentId = equipmentId;
   }

   public void setEquipmentName(final String equipmentName) {
      this.equipmentName = equipmentName;
   }

   public void setProdLineId(final String prodLineId) {
      this.prodLineId = prodLineId;
   }

   public void setProdLineName(final String prodLineName) {
      this.prodLineName = prodLineName;
   }

   public void setDeviceAmmeterHourList(final List<DeviceAmmeterHourList> deviceAmmeterHourList) {
      this.deviceAmmeterHourList = deviceAmmeterHourList;
   }

   public void setAllPowerExpend(final double allPowerExpend) {
      this.allPowerExpend = allPowerExpend;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AmeterStatisticsVos)) {
         return false;
      }

      AmeterStatisticsVos other = (AmeterStatisticsVos)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (Double.compare(this.getAllPowerExpend(), other.getAllPowerExpend()) != 0) {
         return false;
      }

      Object this$yearAndMonthAndDay = this.getYearAndMonthAndDay();
      Object other$yearAndMonthAndDay = other.getYearAndMonthAndDay();
      if (this$yearAndMonthAndDay == null ? other$yearAndMonthAndDay == null : this$yearAndMonthAndDay.equals(other$yearAndMonthAndDay)) {
         Object this$equipmentId = this.getEquipmentId();
         Object other$equipmentId = other.getEquipmentId();
         if (this$equipmentId == null ? other$equipmentId == null : this$equipmentId.equals(other$equipmentId)) {
            Object this$equipmentName = this.getEquipmentName();
            Object other$equipmentName = other.getEquipmentName();
            if (this$equipmentName == null ? other$equipmentName == null : this$equipmentName.equals(other$equipmentName)) {
               Object this$prodLineId = this.getProdLineId();
               Object other$prodLineId = other.getProdLineId();
               if (this$prodLineId == null ? other$prodLineId == null : this$prodLineId.equals(other$prodLineId)) {
                  Object this$prodLineName = this.getProdLineName();
                  Object other$prodLineName = other.getProdLineName();
                  if (this$prodLineName == null ? other$prodLineName == null : this$prodLineName.equals(other$prodLineName)) {
                     Object this$deviceAmmeterHourList = this.getDeviceAmmeterHourList();
                     Object other$deviceAmmeterHourList = other.getDeviceAmmeterHourList();
                     return this$deviceAmmeterHourList == null
                        ? other$deviceAmmeterHourList == null
                        : this$deviceAmmeterHourList.equals(other$deviceAmmeterHourList);
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
      return other instanceof AmeterStatisticsVos;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $allPowerExpend = Double.doubleToLongBits(this.getAllPowerExpend());
      result = result * 59 + (int)($allPowerExpend >>> 32 ^ $allPowerExpend);
      Object $yearAndMonthAndDay = this.getYearAndMonthAndDay();
      result = result * 59 + ($yearAndMonthAndDay == null ? 43 : $yearAndMonthAndDay.hashCode());
      Object $equipmentId = this.getEquipmentId();
      result = result * 59 + ($equipmentId == null ? 43 : $equipmentId.hashCode());
      Object $equipmentName = this.getEquipmentName();
      result = result * 59 + ($equipmentName == null ? 43 : $equipmentName.hashCode());
      Object $prodLineId = this.getProdLineId();
      result = result * 59 + ($prodLineId == null ? 43 : $prodLineId.hashCode());
      Object $prodLineName = this.getProdLineName();
      result = result * 59 + ($prodLineName == null ? 43 : $prodLineName.hashCode());
      Object $deviceAmmeterHourList = this.getDeviceAmmeterHourList();
      return result * 59 + ($deviceAmmeterHourList == null ? 43 : $deviceAmmeterHourList.hashCode());
   }

   @Override
   public String toString() {
      return "AmeterStatisticsVos(yearAndMonthAndDay="
         + this.getYearAndMonthAndDay()
         + ", equipmentId="
         + this.getEquipmentId()
         + ", equipmentName="
         + this.getEquipmentName()
         + ", prodLineId="
         + this.getProdLineId()
         + ", prodLineName="
         + this.getProdLineName()
         + ", deviceAmmeterHourList="
         + this.getDeviceAmmeterHourList()
         + ", allPowerExpend="
         + this.getAllPowerExpend()
         + ")";
   }

   public AmeterStatisticsVos(
      final String yearAndMonthAndDay,
      final String equipmentId,
      final String equipmentName,
      final String prodLineId,
      final String prodLineName,
      final List<DeviceAmmeterHourList> deviceAmmeterHourList,
      final double allPowerExpend
   ) {
      this.yearAndMonthAndDay = yearAndMonthAndDay;
      this.equipmentId = equipmentId;
      this.equipmentName = equipmentName;
      this.prodLineId = prodLineId;
      this.prodLineName = prodLineName;
      this.deviceAmmeterHourList = deviceAmmeterHourList;
      this.allPowerExpend = allPowerExpend;
   }

   public AmeterStatisticsVos() {
   }

   public static class AmeterStatisticsVosBuilder {
      private String yearAndMonthAndDay;
      private String equipmentId;
      private String equipmentName;
      private String prodLineId;
      private String prodLineName;
      private List<DeviceAmmeterHourList> deviceAmmeterHourList;
      private double allPowerExpend;

      AmeterStatisticsVosBuilder() {
      }

      public AmeterStatisticsVos.AmeterStatisticsVosBuilder yearAndMonthAndDay(final String yearAndMonthAndDay) {
         this.yearAndMonthAndDay = yearAndMonthAndDay;
         return this;
      }

      public AmeterStatisticsVos.AmeterStatisticsVosBuilder equipmentId(final String equipmentId) {
         this.equipmentId = equipmentId;
         return this;
      }

      public AmeterStatisticsVos.AmeterStatisticsVosBuilder equipmentName(final String equipmentName) {
         this.equipmentName = equipmentName;
         return this;
      }

      public AmeterStatisticsVos.AmeterStatisticsVosBuilder prodLineId(final String prodLineId) {
         this.prodLineId = prodLineId;
         return this;
      }

      public AmeterStatisticsVos.AmeterStatisticsVosBuilder prodLineName(final String prodLineName) {
         this.prodLineName = prodLineName;
         return this;
      }

      public AmeterStatisticsVos.AmeterStatisticsVosBuilder deviceAmmeterHourList(final List<DeviceAmmeterHourList> deviceAmmeterHourList) {
         this.deviceAmmeterHourList = deviceAmmeterHourList;
         return this;
      }

      public AmeterStatisticsVos.AmeterStatisticsVosBuilder allPowerExpend(final double allPowerExpend) {
         this.allPowerExpend = allPowerExpend;
         return this;
      }

      public AmeterStatisticsVos build() {
         return new AmeterStatisticsVos(
            this.yearAndMonthAndDay, this.equipmentId, this.equipmentName, this.prodLineId, this.prodLineName, this.deviceAmmeterHourList, this.allPowerExpend
         );
      }

      @Override
      public String toString() {
         return "AmeterStatisticsVos.AmeterStatisticsVosBuilder(yearAndMonthAndDay="
            + this.yearAndMonthAndDay
            + ", equipmentId="
            + this.equipmentId
            + ", equipmentName="
            + this.equipmentName
            + ", prodLineId="
            + this.prodLineId
            + ", prodLineName="
            + this.prodLineName
            + ", deviceAmmeterHourList="
            + this.deviceAmmeterHourList
            + ", allPowerExpend="
            + this.allPowerExpend
            + ")";
      }
   }
}
