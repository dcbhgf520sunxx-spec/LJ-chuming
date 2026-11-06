package com.hzchum.scim.iot.core.api.pojo.dto.equipment.ameterFindStatistics;

import java.util.List;

public class AmeterFindStatisticsData {
   private List<AmeterStatisticsVos> ameterStatisticsVos;
   private DeviceAmeterVoPageSimple deviceAmeterVoPageSimple;

   public static AmeterFindStatisticsData.AmeterFindStatisticsDataBuilder builder() {
      return new AmeterFindStatisticsData.AmeterFindStatisticsDataBuilder();
   }

   public List<AmeterStatisticsVos> getAmeterStatisticsVos() {
      return this.ameterStatisticsVos;
   }

   public DeviceAmeterVoPageSimple getDeviceAmeterVoPageSimple() {
      return this.deviceAmeterVoPageSimple;
   }

   public void setAmeterStatisticsVos(final List<AmeterStatisticsVos> ameterStatisticsVos) {
      this.ameterStatisticsVos = ameterStatisticsVos;
   }

   public void setDeviceAmeterVoPageSimple(final DeviceAmeterVoPageSimple deviceAmeterVoPageSimple) {
      this.deviceAmeterVoPageSimple = deviceAmeterVoPageSimple;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof AmeterFindStatisticsData)) {
         return false;
      } else {
         AmeterFindStatisticsData other = (AmeterFindStatisticsData)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$ameterStatisticsVos = this.getAmeterStatisticsVos();
            Object other$ameterStatisticsVos = other.getAmeterStatisticsVos();
            if (this$ameterStatisticsVos == null ? other$ameterStatisticsVos == null : this$ameterStatisticsVos.equals(other$ameterStatisticsVos)) {
               Object this$deviceAmeterVoPageSimple = this.getDeviceAmeterVoPageSimple();
               Object other$deviceAmeterVoPageSimple = other.getDeviceAmeterVoPageSimple();
               return this$deviceAmeterVoPageSimple == null
                  ? other$deviceAmeterVoPageSimple == null
                  : this$deviceAmeterVoPageSimple.equals(other$deviceAmeterVoPageSimple);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AmeterFindStatisticsData;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $ameterStatisticsVos = this.getAmeterStatisticsVos();
      result = result * 59 + ($ameterStatisticsVos == null ? 43 : $ameterStatisticsVos.hashCode());
      Object $deviceAmeterVoPageSimple = this.getDeviceAmeterVoPageSimple();
      return result * 59 + ($deviceAmeterVoPageSimple == null ? 43 : $deviceAmeterVoPageSimple.hashCode());
   }

   @Override
   public String toString() {
      return "AmeterFindStatisticsData(ameterStatisticsVos="
         + this.getAmeterStatisticsVos()
         + ", deviceAmeterVoPageSimple="
         + this.getDeviceAmeterVoPageSimple()
         + ")";
   }

   public AmeterFindStatisticsData(final List<AmeterStatisticsVos> ameterStatisticsVos, final DeviceAmeterVoPageSimple deviceAmeterVoPageSimple) {
      this.ameterStatisticsVos = ameterStatisticsVos;
      this.deviceAmeterVoPageSimple = deviceAmeterVoPageSimple;
   }

   public AmeterFindStatisticsData() {
   }

   public static class AmeterFindStatisticsDataBuilder {
      private List<AmeterStatisticsVos> ameterStatisticsVos;
      private DeviceAmeterVoPageSimple deviceAmeterVoPageSimple;

      AmeterFindStatisticsDataBuilder() {
      }

      public AmeterFindStatisticsData.AmeterFindStatisticsDataBuilder ameterStatisticsVos(final List<AmeterStatisticsVos> ameterStatisticsVos) {
         this.ameterStatisticsVos = ameterStatisticsVos;
         return this;
      }

      public AmeterFindStatisticsData.AmeterFindStatisticsDataBuilder deviceAmeterVoPageSimple(final DeviceAmeterVoPageSimple deviceAmeterVoPageSimple) {
         this.deviceAmeterVoPageSimple = deviceAmeterVoPageSimple;
         return this;
      }

      public AmeterFindStatisticsData build() {
         return new AmeterFindStatisticsData(this.ameterStatisticsVos, this.deviceAmeterVoPageSimple);
      }

      @Override
      public String toString() {
         return "AmeterFindStatisticsData.AmeterFindStatisticsDataBuilder(ameterStatisticsVos="
            + this.ameterStatisticsVos
            + ", deviceAmeterVoPageSimple="
            + this.deviceAmeterVoPageSimple
            + ")";
      }
   }
}
