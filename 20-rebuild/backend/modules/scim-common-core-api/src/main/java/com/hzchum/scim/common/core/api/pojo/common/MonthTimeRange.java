package com.hzchum.scim.common.core.api.pojo.common;

import java.time.LocalDateTime;

public class MonthTimeRange {
   private LocalDateTime startTime;
   private LocalDateTime endTime;
   private String name;
   private Long wmsClosingTimeId;

   public static MonthTimeRange.MonthTimeRangeBuilder builder() {
      return new MonthTimeRange.MonthTimeRangeBuilder();
   }

   public LocalDateTime getStartTime() {
      return this.startTime;
   }

   public LocalDateTime getEndTime() {
      return this.endTime;
   }

   public String getName() {
      return this.name;
   }

   public Long getWmsClosingTimeId() {
      return this.wmsClosingTimeId;
   }

   public void setStartTime(final LocalDateTime startTime) {
      this.startTime = startTime;
   }

   public void setEndTime(final LocalDateTime endTime) {
      this.endTime = endTime;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setWmsClosingTimeId(final Long wmsClosingTimeId) {
      this.wmsClosingTimeId = wmsClosingTimeId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MonthTimeRange)) {
         return false;
      }

      MonthTimeRange other = (MonthTimeRange)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$wmsClosingTimeId = this.getWmsClosingTimeId();
      Object other$wmsClosingTimeId = other.getWmsClosingTimeId();
      if (this$wmsClosingTimeId == null ? other$wmsClosingTimeId == null : this$wmsClosingTimeId.equals(other$wmsClosingTimeId)) {
         Object this$startTime = this.getStartTime();
         Object other$startTime = other.getStartTime();
         if (this$startTime == null ? other$startTime == null : this$startTime.equals(other$startTime)) {
            Object this$endTime = this.getEndTime();
            Object other$endTime = other.getEndTime();
            if (this$endTime == null ? other$endTime == null : this$endTime.equals(other$endTime)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               return this$name == null ? other$name == null : this$name.equals(other$name);
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
      return other instanceof MonthTimeRange;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $wmsClosingTimeId = this.getWmsClosingTimeId();
      result = result * 59 + ($wmsClosingTimeId == null ? 43 : $wmsClosingTimeId.hashCode());
      Object $startTime = this.getStartTime();
      result = result * 59 + ($startTime == null ? 43 : $startTime.hashCode());
      Object $endTime = this.getEndTime();
      result = result * 59 + ($endTime == null ? 43 : $endTime.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "MonthTimeRange(startTime="
         + this.getStartTime()
         + ", endTime="
         + this.getEndTime()
         + ", name="
         + this.getName()
         + ", wmsClosingTimeId="
         + this.getWmsClosingTimeId()
         + ")";
   }

   public MonthTimeRange(final LocalDateTime startTime, final LocalDateTime endTime, final String name, final Long wmsClosingTimeId) {
      this.startTime = startTime;
      this.endTime = endTime;
      this.name = name;
      this.wmsClosingTimeId = wmsClosingTimeId;
   }

   public MonthTimeRange() {
   }

   public static class MonthTimeRangeBuilder {
      private LocalDateTime startTime;
      private LocalDateTime endTime;
      private String name;
      private Long wmsClosingTimeId;

      MonthTimeRangeBuilder() {
      }

      public MonthTimeRange.MonthTimeRangeBuilder startTime(final LocalDateTime startTime) {
         this.startTime = startTime;
         return this;
      }

      public MonthTimeRange.MonthTimeRangeBuilder endTime(final LocalDateTime endTime) {
         this.endTime = endTime;
         return this;
      }

      public MonthTimeRange.MonthTimeRangeBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public MonthTimeRange.MonthTimeRangeBuilder wmsClosingTimeId(final Long wmsClosingTimeId) {
         this.wmsClosingTimeId = wmsClosingTimeId;
         return this;
      }

      public MonthTimeRange build() {
         return new MonthTimeRange(this.startTime, this.endTime, this.name, this.wmsClosingTimeId);
      }

      @Override
      public String toString() {
         return "MonthTimeRange.MonthTimeRangeBuilder(startTime="
            + this.startTime
            + ", endTime="
            + this.endTime
            + ", name="
            + this.name
            + ", wmsClosingTimeId="
            + this.wmsClosingTimeId
            + ")";
      }
   }
}
