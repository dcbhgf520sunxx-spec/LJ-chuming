package com.hzchum.scim.iot.core.api.pojo.dto.equipment.deviceTypeRead;

import java.util.List;

public class DeviceTypeReadVos {
   private String workshopName;
   private String prodLineName;
   private List<DeviceCurrentTypeVos> deviceCurrentTypeVos;

   public static DeviceTypeReadVos.DeviceTypeReadVosBuilder builder() {
      return new DeviceTypeReadVos.DeviceTypeReadVosBuilder();
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public String getProdLineName() {
      return this.prodLineName;
   }

   public List<DeviceCurrentTypeVos> getDeviceCurrentTypeVos() {
      return this.deviceCurrentTypeVos;
   }

   public void setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
   }

   public void setProdLineName(final String prodLineName) {
      this.prodLineName = prodLineName;
   }

   public void setDeviceCurrentTypeVos(final List<DeviceCurrentTypeVos> deviceCurrentTypeVos) {
      this.deviceCurrentTypeVos = deviceCurrentTypeVos;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DeviceTypeReadVos)) {
         return false;
      }

      DeviceTypeReadVos other = (DeviceTypeReadVos)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$workshopName = this.getWorkshopName();
      Object other$workshopName = other.getWorkshopName();
      if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
         Object this$prodLineName = this.getProdLineName();
         Object other$prodLineName = other.getProdLineName();
         if (this$prodLineName == null ? other$prodLineName == null : this$prodLineName.equals(other$prodLineName)) {
            Object this$deviceCurrentTypeVos = this.getDeviceCurrentTypeVos();
            Object other$deviceCurrentTypeVos = other.getDeviceCurrentTypeVos();
            return this$deviceCurrentTypeVos == null ? other$deviceCurrentTypeVos == null : this$deviceCurrentTypeVos.equals(other$deviceCurrentTypeVos);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof DeviceTypeReadVos;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $prodLineName = this.getProdLineName();
      result = result * 59 + ($prodLineName == null ? 43 : $prodLineName.hashCode());
      Object $deviceCurrentTypeVos = this.getDeviceCurrentTypeVos();
      return result * 59 + ($deviceCurrentTypeVos == null ? 43 : $deviceCurrentTypeVos.hashCode());
   }

   @Override
   public String toString() {
      return "DeviceTypeReadVos(workshopName="
         + this.getWorkshopName()
         + ", prodLineName="
         + this.getProdLineName()
         + ", deviceCurrentTypeVos="
         + this.getDeviceCurrentTypeVos()
         + ")";
   }

   public DeviceTypeReadVos(final String workshopName, final String prodLineName, final List<DeviceCurrentTypeVos> deviceCurrentTypeVos) {
      this.workshopName = workshopName;
      this.prodLineName = prodLineName;
      this.deviceCurrentTypeVos = deviceCurrentTypeVos;
   }

   public DeviceTypeReadVos() {
   }

   public static class DeviceTypeReadVosBuilder {
      private String workshopName;
      private String prodLineName;
      private List<DeviceCurrentTypeVos> deviceCurrentTypeVos;

      DeviceTypeReadVosBuilder() {
      }

      public DeviceTypeReadVos.DeviceTypeReadVosBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      public DeviceTypeReadVos.DeviceTypeReadVosBuilder prodLineName(final String prodLineName) {
         this.prodLineName = prodLineName;
         return this;
      }

      public DeviceTypeReadVos.DeviceTypeReadVosBuilder deviceCurrentTypeVos(final List<DeviceCurrentTypeVos> deviceCurrentTypeVos) {
         this.deviceCurrentTypeVos = deviceCurrentTypeVos;
         return this;
      }

      public DeviceTypeReadVos build() {
         return new DeviceTypeReadVos(this.workshopName, this.prodLineName, this.deviceCurrentTypeVos);
      }

      @Override
      public String toString() {
         return "DeviceTypeReadVos.DeviceTypeReadVosBuilder(workshopName="
            + this.workshopName
            + ", prodLineName="
            + this.prodLineName
            + ", deviceCurrentTypeVos="
            + this.deviceCurrentTypeVos
            + ")";
      }
   }
}
