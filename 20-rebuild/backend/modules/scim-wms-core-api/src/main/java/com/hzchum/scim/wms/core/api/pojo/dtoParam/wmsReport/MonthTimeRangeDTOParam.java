package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport;

import java.time.LocalDateTime;
import java.util.List;

public class MonthTimeRangeDTOParam {
   private List<LocalDateTime> dateTimeList;
   private String name;
   private LocalDateTime startTime;
   private LocalDateTime endTime;

   public static MonthTimeRangeDTOParam.MonthTimeRangeDTOParamBuilder builder() {
      return new MonthTimeRangeDTOParam.MonthTimeRangeDTOParamBuilder();
   }

   public List<LocalDateTime> getDateTimeList() {
      return this.dateTimeList;
   }

   public String getName() {
      return this.name;
   }

   public LocalDateTime getStartTime() {
      return this.startTime;
   }

   public LocalDateTime getEndTime() {
      return this.endTime;
   }

   public void setDateTimeList(final List<LocalDateTime> dateTimeList) {
      this.dateTimeList = dateTimeList;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setStartTime(final LocalDateTime startTime) {
      this.startTime = startTime;
   }

   public void setEndTime(final LocalDateTime endTime) {
      this.endTime = endTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MonthTimeRangeDTOParam)) {
         return false;
      }

      MonthTimeRangeDTOParam other = (MonthTimeRangeDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$dateTimeList = this.getDateTimeList();
      Object other$dateTimeList = other.getDateTimeList();
      if (this$dateTimeList == null ? other$dateTimeList == null : this$dateTimeList.equals(other$dateTimeList)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$startTime = this.getStartTime();
            Object other$startTime = other.getStartTime();
            if (this$startTime == null ? other$startTime == null : this$startTime.equals(other$startTime)) {
               Object this$endTime = this.getEndTime();
               Object other$endTime = other.getEndTime();
               return this$endTime == null ? other$endTime == null : this$endTime.equals(other$endTime);
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
      return other instanceof MonthTimeRangeDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $dateTimeList = this.getDateTimeList();
      result = result * 59 + ($dateTimeList == null ? 43 : $dateTimeList.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $startTime = this.getStartTime();
      result = result * 59 + ($startTime == null ? 43 : $startTime.hashCode());
      Object $endTime = this.getEndTime();
      return result * 59 + ($endTime == null ? 43 : $endTime.hashCode());
   }

   @Override
   public String toString() {
      return "MonthTimeRangeDTOParam(dateTimeList="
         + this.getDateTimeList()
         + ", name="
         + this.getName()
         + ", startTime="
         + this.getStartTime()
         + ", endTime="
         + this.getEndTime()
         + ")";
   }

   public MonthTimeRangeDTOParam(final List<LocalDateTime> dateTimeList, final String name, final LocalDateTime startTime, final LocalDateTime endTime) {
      this.dateTimeList = dateTimeList;
      this.name = name;
      this.startTime = startTime;
      this.endTime = endTime;
   }

   public MonthTimeRangeDTOParam() {
   }

   public static class MonthTimeRangeDTOParamBuilder {
      private List<LocalDateTime> dateTimeList;
      private String name;
      private LocalDateTime startTime;
      private LocalDateTime endTime;

      MonthTimeRangeDTOParamBuilder() {
      }

      public MonthTimeRangeDTOParam.MonthTimeRangeDTOParamBuilder dateTimeList(final List<LocalDateTime> dateTimeList) {
         this.dateTimeList = dateTimeList;
         return this;
      }

      public MonthTimeRangeDTOParam.MonthTimeRangeDTOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public MonthTimeRangeDTOParam.MonthTimeRangeDTOParamBuilder startTime(final LocalDateTime startTime) {
         this.startTime = startTime;
         return this;
      }

      public MonthTimeRangeDTOParam.MonthTimeRangeDTOParamBuilder endTime(final LocalDateTime endTime) {
         this.endTime = endTime;
         return this;
      }

      public MonthTimeRangeDTOParam build() {
         return new MonthTimeRangeDTOParam(this.dateTimeList, this.name, this.startTime, this.endTime);
      }

      @Override
      public String toString() {
         return "MonthTimeRangeDTOParam.MonthTimeRangeDTOParamBuilder(dateTimeList="
            + this.dateTimeList
            + ", name="
            + this.name
            + ", startTime="
            + this.startTime
            + ", endTime="
            + this.endTime
            + ")";
      }
   }
}
