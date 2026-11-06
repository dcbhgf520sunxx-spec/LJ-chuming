package com.hzchum.scim.iot.core.api.pojo.dto.equipment.gasFindStatistics;

public class DeviceGasMeterHours {
   private Integer day;
   private Integer hour;
   private Integer mid;
   private Integer month;
   private String now;
   private Integer powerExpend;
   private Integer year;

   public static DeviceGasMeterHours.DeviceGasMeterHoursBuilder builder() {
      return new DeviceGasMeterHours.DeviceGasMeterHoursBuilder();
   }

   public Integer getDay() {
      return this.day;
   }

   public Integer getHour() {
      return this.hour;
   }

   public Integer getMid() {
      return this.mid;
   }

   public Integer getMonth() {
      return this.month;
   }

   public String getNow() {
      return this.now;
   }

   public Integer getPowerExpend() {
      return this.powerExpend;
   }

   public Integer getYear() {
      return this.year;
   }

   public void setDay(final Integer day) {
      this.day = day;
   }

   public void setHour(final Integer hour) {
      this.hour = hour;
   }

   public void setMid(final Integer mid) {
      this.mid = mid;
   }

   public void setMonth(final Integer month) {
      this.month = month;
   }

   public void setNow(final String now) {
      this.now = now;
   }

   public void setPowerExpend(final Integer powerExpend) {
      this.powerExpend = powerExpend;
   }

   public void setYear(final Integer year) {
      this.year = year;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DeviceGasMeterHours)) {
         return false;
      }

      DeviceGasMeterHours other = (DeviceGasMeterHours)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$day = this.getDay();
      Object other$day = other.getDay();
      if (this$day == null ? other$day == null : this$day.equals(other$day)) {
         Object this$hour = this.getHour();
         Object other$hour = other.getHour();
         if (this$hour == null ? other$hour == null : this$hour.equals(other$hour)) {
            Object this$mid = this.getMid();
            Object other$mid = other.getMid();
            if (this$mid == null ? other$mid == null : this$mid.equals(other$mid)) {
               Object this$month = this.getMonth();
               Object other$month = other.getMonth();
               if (this$month == null ? other$month == null : this$month.equals(other$month)) {
                  Object this$powerExpend = this.getPowerExpend();
                  Object other$powerExpend = other.getPowerExpend();
                  if (this$powerExpend == null ? other$powerExpend == null : this$powerExpend.equals(other$powerExpend)) {
                     Object this$year = this.getYear();
                     Object other$year = other.getYear();
                     if (this$year == null ? other$year == null : this$year.equals(other$year)) {
                        Object this$now = this.getNow();
                        Object other$now = other.getNow();
                        return this$now == null ? other$now == null : this$now.equals(other$now);
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
      return other instanceof DeviceGasMeterHours;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $day = this.getDay();
      result = result * 59 + ($day == null ? 43 : $day.hashCode());
      Object $hour = this.getHour();
      result = result * 59 + ($hour == null ? 43 : $hour.hashCode());
      Object $mid = this.getMid();
      result = result * 59 + ($mid == null ? 43 : $mid.hashCode());
      Object $month = this.getMonth();
      result = result * 59 + ($month == null ? 43 : $month.hashCode());
      Object $powerExpend = this.getPowerExpend();
      result = result * 59 + ($powerExpend == null ? 43 : $powerExpend.hashCode());
      Object $year = this.getYear();
      result = result * 59 + ($year == null ? 43 : $year.hashCode());
      Object $now = this.getNow();
      return result * 59 + ($now == null ? 43 : $now.hashCode());
   }

   @Override
   public String toString() {
      return "DeviceGasMeterHours(day="
         + this.getDay()
         + ", hour="
         + this.getHour()
         + ", mid="
         + this.getMid()
         + ", month="
         + this.getMonth()
         + ", now="
         + this.getNow()
         + ", powerExpend="
         + this.getPowerExpend()
         + ", year="
         + this.getYear()
         + ")";
   }

   public DeviceGasMeterHours(
      final Integer day, final Integer hour, final Integer mid, final Integer month, final String now, final Integer powerExpend, final Integer year
   ) {
      this.day = day;
      this.hour = hour;
      this.mid = mid;
      this.month = month;
      this.now = now;
      this.powerExpend = powerExpend;
      this.year = year;
   }

   public DeviceGasMeterHours() {
   }

   public static class DeviceGasMeterHoursBuilder {
      private Integer day;
      private Integer hour;
      private Integer mid;
      private Integer month;
      private String now;
      private Integer powerExpend;
      private Integer year;

      DeviceGasMeterHoursBuilder() {
      }

      public DeviceGasMeterHours.DeviceGasMeterHoursBuilder day(final Integer day) {
         this.day = day;
         return this;
      }

      public DeviceGasMeterHours.DeviceGasMeterHoursBuilder hour(final Integer hour) {
         this.hour = hour;
         return this;
      }

      public DeviceGasMeterHours.DeviceGasMeterHoursBuilder mid(final Integer mid) {
         this.mid = mid;
         return this;
      }

      public DeviceGasMeterHours.DeviceGasMeterHoursBuilder month(final Integer month) {
         this.month = month;
         return this;
      }

      public DeviceGasMeterHours.DeviceGasMeterHoursBuilder now(final String now) {
         this.now = now;
         return this;
      }

      public DeviceGasMeterHours.DeviceGasMeterHoursBuilder powerExpend(final Integer powerExpend) {
         this.powerExpend = powerExpend;
         return this;
      }

      public DeviceGasMeterHours.DeviceGasMeterHoursBuilder year(final Integer year) {
         this.year = year;
         return this;
      }

      public DeviceGasMeterHours build() {
         return new DeviceGasMeterHours(this.day, this.hour, this.mid, this.month, this.now, this.powerExpend, this.year);
      }

      @Override
      public String toString() {
         return "DeviceGasMeterHours.DeviceGasMeterHoursBuilder(day="
            + this.day
            + ", hour="
            + this.hour
            + ", mid="
            + this.mid
            + ", month="
            + this.month
            + ", now="
            + this.now
            + ", powerExpend="
            + this.powerExpend
            + ", year="
            + this.year
            + ")";
      }
   }
}
