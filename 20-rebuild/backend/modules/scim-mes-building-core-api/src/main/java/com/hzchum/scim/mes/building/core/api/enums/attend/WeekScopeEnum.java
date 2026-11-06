package com.hzchum.scim.mes.building.core.api.enums.attend;

import java.time.DayOfWeek;
import java.time.LocalDate;

public enum WeekScopeEnum {
   MONDAY(1, "周一"),
   TUESDAY(2, "周二"),
   WEDNESDAY(4, "周三"),
   THURSDAY(8, "周四"),
   FRIDAY(16, "周五"),
   SATURDAY(32, "周六"),
   SUNDAY(64, "周日");

   private Integer type;
   private String name;

   public static Integer getToDayType(LocalDate date) {
      DayOfWeek dayOfWeek = date.getDayOfWeek();
      Integer weekDay = null;
      switch (dayOfWeek) {
         case MONDAY:
            weekDay = MONDAY.type;
            break;
         case TUESDAY:
            weekDay = TUESDAY.type;
            break;
         case WEDNESDAY:
            weekDay = WEDNESDAY.type;
            break;
         case THURSDAY:
            weekDay = THURSDAY.type;
            break;
         case FRIDAY:
            weekDay = FRIDAY.type;
            break;
         case SATURDAY:
            weekDay = SATURDAY.type;
            break;
         case SUNDAY:
            weekDay = SUNDAY.type;
      }

      return weekDay;
   }

   WeekScopeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
