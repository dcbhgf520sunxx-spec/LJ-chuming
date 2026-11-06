package com.hzchum.scim.iot.core.api.pojo.dto.equipment.ameterFindStatistics;

public class DeviceAmmeterHourList {
   private int mid;
   private int year;
   private int month;
   private int day;
   private int hour;
   private double powerExpend;
   private long now;

   public static DeviceAmmeterHourList.DeviceAmmeterHourListBuilder builder() {
      return new DeviceAmmeterHourList.DeviceAmmeterHourListBuilder();
   }

   public int getMid() {
      return this.mid;
   }

   public int getYear() {
      return this.year;
   }

   public int getMonth() {
      return this.month;
   }

   public int getDay() {
      return this.day;
   }

   public int getHour() {
      return this.hour;
   }

   public double getPowerExpend() {
      return this.powerExpend;
   }

   public long getNow() {
      return this.now;
   }

   public void setMid(final int mid) {
      this.mid = mid;
   }

   public void setYear(final int year) {
      this.year = year;
   }

   public void setMonth(final int month) {
      this.month = month;
   }

   public void setDay(final int day) {
      this.day = day;
   }

   public void setHour(final int hour) {
      this.hour = hour;
   }

   public void setPowerExpend(final double powerExpend) {
      this.powerExpend = powerExpend;
   }

   public void setNow(final long now) {
      this.now = now;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof DeviceAmmeterHourList)) {
         return false;
      } else {
         DeviceAmmeterHourList other = (DeviceAmmeterHourList)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (this.getMid() != other.getMid()) {
            return false;
         } else if (this.getYear() != other.getYear()) {
            return false;
         } else if (this.getMonth() != other.getMonth()) {
            return false;
         } else if (this.getDay() != other.getDay()) {
            return false;
         } else if (this.getHour() != other.getHour()) {
            return false;
         } else {
            return Double.compare(this.getPowerExpend(), other.getPowerExpend()) != 0 ? false : this.getNow() == other.getNow();
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof DeviceAmmeterHourList;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getMid();
      result = result * 59 + this.getYear();
      result = result * 59 + this.getMonth();
      result = result * 59 + this.getDay();
      result = result * 59 + this.getHour();
      long $powerExpend = Double.doubleToLongBits(this.getPowerExpend());
      result = result * 59 + (int)($powerExpend >>> 32 ^ $powerExpend);
      long $now = this.getNow();
      return result * 59 + (int)($now >>> 32 ^ $now);
   }

   @Override
   public String toString() {
      return "DeviceAmmeterHourList(mid="
         + this.getMid()
         + ", year="
         + this.getYear()
         + ", month="
         + this.getMonth()
         + ", day="
         + this.getDay()
         + ", hour="
         + this.getHour()
         + ", powerExpend="
         + this.getPowerExpend()
         + ", now="
         + this.getNow()
         + ")";
   }

   public DeviceAmmeterHourList(final int mid, final int year, final int month, final int day, final int hour, final double powerExpend, final long now) {
      this.mid = mid;
      this.year = year;
      this.month = month;
      this.day = day;
      this.hour = hour;
      this.powerExpend = powerExpend;
      this.now = now;
   }

   public DeviceAmmeterHourList() {
   }

   public static class DeviceAmmeterHourListBuilder {
      private int mid;
      private int year;
      private int month;
      private int day;
      private int hour;
      private double powerExpend;
      private long now;

      DeviceAmmeterHourListBuilder() {
      }

      public DeviceAmmeterHourList.DeviceAmmeterHourListBuilder mid(final int mid) {
         this.mid = mid;
         return this;
      }

      public DeviceAmmeterHourList.DeviceAmmeterHourListBuilder year(final int year) {
         this.year = year;
         return this;
      }

      public DeviceAmmeterHourList.DeviceAmmeterHourListBuilder month(final int month) {
         this.month = month;
         return this;
      }

      public DeviceAmmeterHourList.DeviceAmmeterHourListBuilder day(final int day) {
         this.day = day;
         return this;
      }

      public DeviceAmmeterHourList.DeviceAmmeterHourListBuilder hour(final int hour) {
         this.hour = hour;
         return this;
      }

      public DeviceAmmeterHourList.DeviceAmmeterHourListBuilder powerExpend(final double powerExpend) {
         this.powerExpend = powerExpend;
         return this;
      }

      public DeviceAmmeterHourList.DeviceAmmeterHourListBuilder now(final long now) {
         this.now = now;
         return this;
      }

      public DeviceAmmeterHourList build() {
         return new DeviceAmmeterHourList(this.mid, this.year, this.month, this.day, this.hour, this.powerExpend, this.now);
      }

      @Override
      public String toString() {
         return "DeviceAmmeterHourList.DeviceAmmeterHourListBuilder(mid="
            + this.mid
            + ", year="
            + this.year
            + ", month="
            + this.month
            + ", day="
            + this.day
            + ", hour="
            + this.hour
            + ", powerExpend="
            + this.powerExpend
            + ", now="
            + this.now
            + ")";
      }
   }
}
