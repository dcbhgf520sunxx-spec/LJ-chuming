package com.hzchum.scim.iot.core.api.pojo.dto.equipment.gasFindStatistics;

import java.util.List;

public class GasMeterStatisticsVo {
   private Double allPowerExpend;
   private List<DeviceGasMeterHours> deviceGasMeterHours;
   private Integer equipmentId;
   private String equipmentName;
   private Integer gasMeterType;
   private Integer prodLineId;
   private String prodLineName;
   private String yearAndMonthAndDay;

   public static GasMeterStatisticsVo.GasMeterStatisticsVoBuilder builder() {
      return new GasMeterStatisticsVo.GasMeterStatisticsVoBuilder();
   }

   public Double getAllPowerExpend() {
      return this.allPowerExpend;
   }

   public List<DeviceGasMeterHours> getDeviceGasMeterHours() {
      return this.deviceGasMeterHours;
   }

   public Integer getEquipmentId() {
      return this.equipmentId;
   }

   public String getEquipmentName() {
      return this.equipmentName;
   }

   public Integer getGasMeterType() {
      return this.gasMeterType;
   }

   public Integer getProdLineId() {
      return this.prodLineId;
   }

   public String getProdLineName() {
      return this.prodLineName;
   }

   public String getYearAndMonthAndDay() {
      return this.yearAndMonthAndDay;
   }

   public void setAllPowerExpend(final Double allPowerExpend) {
      this.allPowerExpend = allPowerExpend;
   }

   public void setDeviceGasMeterHours(final List<DeviceGasMeterHours> deviceGasMeterHours) {
      this.deviceGasMeterHours = deviceGasMeterHours;
   }

   public void setEquipmentId(final Integer equipmentId) {
      this.equipmentId = equipmentId;
   }

   public void setEquipmentName(final String equipmentName) {
      this.equipmentName = equipmentName;
   }

   public void setGasMeterType(final Integer gasMeterType) {
      this.gasMeterType = gasMeterType;
   }

   public void setProdLineId(final Integer prodLineId) {
      this.prodLineId = prodLineId;
   }

   public void setProdLineName(final String prodLineName) {
      this.prodLineName = prodLineName;
   }

   public void setYearAndMonthAndDay(final String yearAndMonthAndDay) {
      this.yearAndMonthAndDay = yearAndMonthAndDay;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof GasMeterStatisticsVo)) {
         return false;
      }

      GasMeterStatisticsVo other = (GasMeterStatisticsVo)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$allPowerExpend = this.getAllPowerExpend();
      Object other$allPowerExpend = other.getAllPowerExpend();
      if (this$allPowerExpend == null ? other$allPowerExpend == null : this$allPowerExpend.equals(other$allPowerExpend)) {
         Object this$equipmentId = this.getEquipmentId();
         Object other$equipmentId = other.getEquipmentId();
         if (this$equipmentId == null ? other$equipmentId == null : this$equipmentId.equals(other$equipmentId)) {
            Object this$gasMeterType = this.getGasMeterType();
            Object other$gasMeterType = other.getGasMeterType();
            if (this$gasMeterType == null ? other$gasMeterType == null : this$gasMeterType.equals(other$gasMeterType)) {
               Object this$prodLineId = this.getProdLineId();
               Object other$prodLineId = other.getProdLineId();
               if (this$prodLineId == null ? other$prodLineId == null : this$prodLineId.equals(other$prodLineId)) {
                  Object this$deviceGasMeterHours = this.getDeviceGasMeterHours();
                  Object other$deviceGasMeterHours = other.getDeviceGasMeterHours();
                  if (this$deviceGasMeterHours == null ? other$deviceGasMeterHours == null : this$deviceGasMeterHours.equals(other$deviceGasMeterHours)) {
                     Object this$equipmentName = this.getEquipmentName();
                     Object other$equipmentName = other.getEquipmentName();
                     if (this$equipmentName == null ? other$equipmentName == null : this$equipmentName.equals(other$equipmentName)) {
                        Object this$prodLineName = this.getProdLineName();
                        Object other$prodLineName = other.getProdLineName();
                        if (this$prodLineName == null ? other$prodLineName == null : this$prodLineName.equals(other$prodLineName)) {
                           Object this$yearAndMonthAndDay = this.getYearAndMonthAndDay();
                           Object other$yearAndMonthAndDay = other.getYearAndMonthAndDay();
                           return this$yearAndMonthAndDay == null ? other$yearAndMonthAndDay == null : this$yearAndMonthAndDay.equals(other$yearAndMonthAndDay);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof GasMeterStatisticsVo;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $allPowerExpend = this.getAllPowerExpend();
      result = result * 59 + ($allPowerExpend == null ? 43 : $allPowerExpend.hashCode());
      Object $equipmentId = this.getEquipmentId();
      result = result * 59 + ($equipmentId == null ? 43 : $equipmentId.hashCode());
      Object $gasMeterType = this.getGasMeterType();
      result = result * 59 + ($gasMeterType == null ? 43 : $gasMeterType.hashCode());
      Object $prodLineId = this.getProdLineId();
      result = result * 59 + ($prodLineId == null ? 43 : $prodLineId.hashCode());
      Object $deviceGasMeterHours = this.getDeviceGasMeterHours();
      result = result * 59 + ($deviceGasMeterHours == null ? 43 : $deviceGasMeterHours.hashCode());
      Object $equipmentName = this.getEquipmentName();
      result = result * 59 + ($equipmentName == null ? 43 : $equipmentName.hashCode());
      Object $prodLineName = this.getProdLineName();
      result = result * 59 + ($prodLineName == null ? 43 : $prodLineName.hashCode());
      Object $yearAndMonthAndDay = this.getYearAndMonthAndDay();
      return result * 59 + ($yearAndMonthAndDay == null ? 43 : $yearAndMonthAndDay.hashCode());
   }

   @Override
   public String toString() {
      return "GasMeterStatisticsVo(allPowerExpend="
         + this.getAllPowerExpend()
         + ", deviceGasMeterHours="
         + this.getDeviceGasMeterHours()
         + ", equipmentId="
         + this.getEquipmentId()
         + ", equipmentName="
         + this.getEquipmentName()
         + ", gasMeterType="
         + this.getGasMeterType()
         + ", prodLineId="
         + this.getProdLineId()
         + ", prodLineName="
         + this.getProdLineName()
         + ", yearAndMonthAndDay="
         + this.getYearAndMonthAndDay()
         + ")";
   }

   public GasMeterStatisticsVo(
      final Double allPowerExpend,
      final List<DeviceGasMeterHours> deviceGasMeterHours,
      final Integer equipmentId,
      final String equipmentName,
      final Integer gasMeterType,
      final Integer prodLineId,
      final String prodLineName,
      final String yearAndMonthAndDay
   ) {
      this.allPowerExpend = allPowerExpend;
      this.deviceGasMeterHours = deviceGasMeterHours;
      this.equipmentId = equipmentId;
      this.equipmentName = equipmentName;
      this.gasMeterType = gasMeterType;
      this.prodLineId = prodLineId;
      this.prodLineName = prodLineName;
      this.yearAndMonthAndDay = yearAndMonthAndDay;
   }

   public GasMeterStatisticsVo() {
   }

   public static class GasMeterStatisticsVoBuilder {
      private Double allPowerExpend;
      private List<DeviceGasMeterHours> deviceGasMeterHours;
      private Integer equipmentId;
      private String equipmentName;
      private Integer gasMeterType;
      private Integer prodLineId;
      private String prodLineName;
      private String yearAndMonthAndDay;

      GasMeterStatisticsVoBuilder() {
      }

      public GasMeterStatisticsVo.GasMeterStatisticsVoBuilder allPowerExpend(final Double allPowerExpend) {
         this.allPowerExpend = allPowerExpend;
         return this;
      }

      public GasMeterStatisticsVo.GasMeterStatisticsVoBuilder deviceGasMeterHours(final List<DeviceGasMeterHours> deviceGasMeterHours) {
         this.deviceGasMeterHours = deviceGasMeterHours;
         return this;
      }

      public GasMeterStatisticsVo.GasMeterStatisticsVoBuilder equipmentId(final Integer equipmentId) {
         this.equipmentId = equipmentId;
         return this;
      }

      public GasMeterStatisticsVo.GasMeterStatisticsVoBuilder equipmentName(final String equipmentName) {
         this.equipmentName = equipmentName;
         return this;
      }

      public GasMeterStatisticsVo.GasMeterStatisticsVoBuilder gasMeterType(final Integer gasMeterType) {
         this.gasMeterType = gasMeterType;
         return this;
      }

      public GasMeterStatisticsVo.GasMeterStatisticsVoBuilder prodLineId(final Integer prodLineId) {
         this.prodLineId = prodLineId;
         return this;
      }

      public GasMeterStatisticsVo.GasMeterStatisticsVoBuilder prodLineName(final String prodLineName) {
         this.prodLineName = prodLineName;
         return this;
      }

      public GasMeterStatisticsVo.GasMeterStatisticsVoBuilder yearAndMonthAndDay(final String yearAndMonthAndDay) {
         this.yearAndMonthAndDay = yearAndMonthAndDay;
         return this;
      }

      public GasMeterStatisticsVo build() {
         return new GasMeterStatisticsVo(
            this.allPowerExpend,
            this.deviceGasMeterHours,
            this.equipmentId,
            this.equipmentName,
            this.gasMeterType,
            this.prodLineId,
            this.prodLineName,
            this.yearAndMonthAndDay
         );
      }

      @Override
      public String toString() {
         return "GasMeterStatisticsVo.GasMeterStatisticsVoBuilder(allPowerExpend="
            + this.allPowerExpend
            + ", deviceGasMeterHours="
            + this.deviceGasMeterHours
            + ", equipmentId="
            + this.equipmentId
            + ", equipmentName="
            + this.equipmentName
            + ", gasMeterType="
            + this.gasMeterType
            + ", prodLineId="
            + this.prodLineId
            + ", prodLineName="
            + this.prodLineName
            + ", yearAndMonthAndDay="
            + this.yearAndMonthAndDay
            + ")";
      }
   }
}
