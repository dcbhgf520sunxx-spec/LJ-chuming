package com.hzchum.scim.mes.building.core.api.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DayOfMonthUtil {
   private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
   private static Calendar calendar = Calendar.getInstance();

   public static Date getMinDateMonth(String month) {
      try {
         Date nowDate = sdf.parse(month);
         calendar = Calendar.getInstance();
         calendar.setTime(nowDate);
         calendar.set(5, calendar.getActualMinimum(5));
         return calendar.getTime();
      } catch (ParseException e) {
         e.printStackTrace();
         return null;
      }
   }

   public static Date getMaxDateMonth(String month) {
      try {
         Date nowDate = sdf.parse(month);
         calendar = Calendar.getInstance();
         calendar.setTime(nowDate);
         calendar.set(5, calendar.getActualMaximum(5));
         return calendar.getTime();
      } catch (ParseException e) {
         e.printStackTrace();
         return null;
      }
   }
}
