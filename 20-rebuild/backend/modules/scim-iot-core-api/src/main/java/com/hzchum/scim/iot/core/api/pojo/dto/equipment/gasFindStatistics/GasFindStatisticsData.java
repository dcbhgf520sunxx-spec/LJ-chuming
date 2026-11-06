package com.hzchum.scim.iot.core.api.pojo.dto.equipment.gasFindStatistics;

import java.util.List;

public class GasFindStatisticsData {
   private DeviceGasMeterVos deviceGasMeterVos;
   private List<GasMeterStatisticsVo> gasMeterStatisticsVo;

   public static GasFindStatisticsData.GasFindStatisticsDataBuilder builder() {
      return new GasFindStatisticsData.GasFindStatisticsDataBuilder();
   }

   public DeviceGasMeterVos getDeviceGasMeterVos() {
      return this.deviceGasMeterVos;
   }

   public List<GasMeterStatisticsVo> getGasMeterStatisticsVo() {
      return this.gasMeterStatisticsVo;
   }

   public void setDeviceGasMeterVos(final DeviceGasMeterVos deviceGasMeterVos) {
      this.deviceGasMeterVos = deviceGasMeterVos;
   }

   public void setGasMeterStatisticsVo(final List<GasMeterStatisticsVo> gasMeterStatisticsVo) {
      this.gasMeterStatisticsVo = gasMeterStatisticsVo;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof GasFindStatisticsData)) {
         return false;
      } else {
         GasFindStatisticsData other = (GasFindStatisticsData)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$deviceGasMeterVos = this.getDeviceGasMeterVos();
            Object other$deviceGasMeterVos = other.getDeviceGasMeterVos();
            if (this$deviceGasMeterVos == null ? other$deviceGasMeterVos == null : this$deviceGasMeterVos.equals(other$deviceGasMeterVos)) {
               Object this$gasMeterStatisticsVo = this.getGasMeterStatisticsVo();
               Object other$gasMeterStatisticsVo = other.getGasMeterStatisticsVo();
               return this$gasMeterStatisticsVo == null ? other$gasMeterStatisticsVo == null : this$gasMeterStatisticsVo.equals(other$gasMeterStatisticsVo);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof GasFindStatisticsData;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $deviceGasMeterVos = this.getDeviceGasMeterVos();
      result = result * 59 + ($deviceGasMeterVos == null ? 43 : $deviceGasMeterVos.hashCode());
      Object $gasMeterStatisticsVo = this.getGasMeterStatisticsVo();
      return result * 59 + ($gasMeterStatisticsVo == null ? 43 : $gasMeterStatisticsVo.hashCode());
   }

   @Override
   public String toString() {
      return "GasFindStatisticsData(deviceGasMeterVos=" + this.getDeviceGasMeterVos() + ", gasMeterStatisticsVo=" + this.getGasMeterStatisticsVo() + ")";
   }

   public GasFindStatisticsData(final DeviceGasMeterVos deviceGasMeterVos, final List<GasMeterStatisticsVo> gasMeterStatisticsVo) {
      this.deviceGasMeterVos = deviceGasMeterVos;
      this.gasMeterStatisticsVo = gasMeterStatisticsVo;
   }

   public GasFindStatisticsData() {
   }

   public static class GasFindStatisticsDataBuilder {
      private DeviceGasMeterVos deviceGasMeterVos;
      private List<GasMeterStatisticsVo> gasMeterStatisticsVo;

      GasFindStatisticsDataBuilder() {
      }

      public GasFindStatisticsData.GasFindStatisticsDataBuilder deviceGasMeterVos(final DeviceGasMeterVos deviceGasMeterVos) {
         this.deviceGasMeterVos = deviceGasMeterVos;
         return this;
      }

      public GasFindStatisticsData.GasFindStatisticsDataBuilder gasMeterStatisticsVo(final List<GasMeterStatisticsVo> gasMeterStatisticsVo) {
         this.gasMeterStatisticsVo = gasMeterStatisticsVo;
         return this;
      }

      public GasFindStatisticsData build() {
         return new GasFindStatisticsData(this.deviceGasMeterVos, this.gasMeterStatisticsVo);
      }

      @Override
      public String toString() {
         return "GasFindStatisticsData.GasFindStatisticsDataBuilder(deviceGasMeterVos="
            + this.deviceGasMeterVos
            + ", gasMeterStatisticsVo="
            + this.gasMeterStatisticsVo
            + ")";
      }
   }
}
