package com.hzchum.scim.iot.core.api.pojo.dto.equipment.deviceTypeRead;

import java.util.List;

public class deviceTypeReadData {
   private int powerOff;
   private int operation;
   private int debug;
   private int leisure;
   private int alarm;
   private List<DeviceTypeReadVos> deviceTypeReadVos;

   public static deviceTypeReadData.deviceTypeReadDataBuilder builder() {
      return new deviceTypeReadData.deviceTypeReadDataBuilder();
   }

   public int getPowerOff() {
      return this.powerOff;
   }

   public int getOperation() {
      return this.operation;
   }

   public int getDebug() {
      return this.debug;
   }

   public int getLeisure() {
      return this.leisure;
   }

   public int getAlarm() {
      return this.alarm;
   }

   public List<DeviceTypeReadVos> getDeviceTypeReadVos() {
      return this.deviceTypeReadVos;
   }

   public void setPowerOff(final int powerOff) {
      this.powerOff = powerOff;
   }

   public void setOperation(final int operation) {
      this.operation = operation;
   }

   public void setDebug(final int debug) {
      this.debug = debug;
   }

   public void setLeisure(final int leisure) {
      this.leisure = leisure;
   }

   public void setAlarm(final int alarm) {
      this.alarm = alarm;
   }

   public void setDeviceTypeReadVos(final List<DeviceTypeReadVos> deviceTypeReadVos) {
      this.deviceTypeReadVos = deviceTypeReadVos;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof deviceTypeReadData)) {
         return false;
      }

      deviceTypeReadData other = (deviceTypeReadData)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.getPowerOff() != other.getPowerOff()) {
         return false;
      }

      if (this.getOperation() != other.getOperation()) {
         return false;
      }

      if (this.getDebug() != other.getDebug()) {
         return false;
      }

      if (this.getLeisure() != other.getLeisure()) {
         return false;
      }

      if (this.getAlarm() != other.getAlarm()) {
         return false;
      }

      Object this$deviceTypeReadVos = this.getDeviceTypeReadVos();
      Object other$deviceTypeReadVos = other.getDeviceTypeReadVos();
      return this$deviceTypeReadVos == null ? other$deviceTypeReadVos == null : this$deviceTypeReadVos.equals(other$deviceTypeReadVos);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof deviceTypeReadData;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getPowerOff();
      result = result * 59 + this.getOperation();
      result = result * 59 + this.getDebug();
      result = result * 59 + this.getLeisure();
      result = result * 59 + this.getAlarm();
      Object $deviceTypeReadVos = this.getDeviceTypeReadVos();
      return result * 59 + ($deviceTypeReadVos == null ? 43 : $deviceTypeReadVos.hashCode());
   }

   @Override
   public String toString() {
      return "deviceTypeReadData(powerOff="
         + this.getPowerOff()
         + ", operation="
         + this.getOperation()
         + ", debug="
         + this.getDebug()
         + ", leisure="
         + this.getLeisure()
         + ", alarm="
         + this.getAlarm()
         + ", deviceTypeReadVos="
         + this.getDeviceTypeReadVos()
         + ")";
   }

   public deviceTypeReadData(
      final int powerOff, final int operation, final int debug, final int leisure, final int alarm, final List<DeviceTypeReadVos> deviceTypeReadVos
   ) {
      this.powerOff = powerOff;
      this.operation = operation;
      this.debug = debug;
      this.leisure = leisure;
      this.alarm = alarm;
      this.deviceTypeReadVos = deviceTypeReadVos;
   }

   public deviceTypeReadData() {
   }

   public static class deviceTypeReadDataBuilder {
      private int powerOff;
      private int operation;
      private int debug;
      private int leisure;
      private int alarm;
      private List<DeviceTypeReadVos> deviceTypeReadVos;

      deviceTypeReadDataBuilder() {
      }

      public deviceTypeReadData.deviceTypeReadDataBuilder powerOff(final int powerOff) {
         this.powerOff = powerOff;
         return this;
      }

      public deviceTypeReadData.deviceTypeReadDataBuilder operation(final int operation) {
         this.operation = operation;
         return this;
      }

      public deviceTypeReadData.deviceTypeReadDataBuilder debug(final int debug) {
         this.debug = debug;
         return this;
      }

      public deviceTypeReadData.deviceTypeReadDataBuilder leisure(final int leisure) {
         this.leisure = leisure;
         return this;
      }

      public deviceTypeReadData.deviceTypeReadDataBuilder alarm(final int alarm) {
         this.alarm = alarm;
         return this;
      }

      public deviceTypeReadData.deviceTypeReadDataBuilder deviceTypeReadVos(final List<DeviceTypeReadVos> deviceTypeReadVos) {
         this.deviceTypeReadVos = deviceTypeReadVos;
         return this;
      }

      public deviceTypeReadData build() {
         return new deviceTypeReadData(this.powerOff, this.operation, this.debug, this.leisure, this.alarm, this.deviceTypeReadVos);
      }

      @Override
      public String toString() {
         return "deviceTypeReadData.deviceTypeReadDataBuilder(powerOff="
            + this.powerOff
            + ", operation="
            + this.operation
            + ", debug="
            + this.debug
            + ", leisure="
            + this.leisure
            + ", alarm="
            + this.alarm
            + ", deviceTypeReadVos="
            + this.deviceTypeReadVos
            + ")";
      }
   }
}
