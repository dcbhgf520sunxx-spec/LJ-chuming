package com.hzchum.scim.common.core.api.utils;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import com.google.common.base.Preconditions;
import com.hzchum.scim.common.core.api.pojo.common.MonthTimeRange;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import javax.annotation.PostConstruct;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DateTimeUtil {
   public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
   public static final String DATE_FORMAT = "yyyy/MM/dd";
   public static final String DATE_MONTH_FORMAT = "yyyy-MM";
   public static final String DATE_DAY_FORMAT = "yyyy-MM-dd";
   public static final String TIME_ZONE = "GMT+8:00";
   @Value("${wms.scheduled-cron}")
   private String scheduledCron;
   private static String corn;

   @PostConstruct
   public void initCorn() {
      corn = this.scheduledCron;
   }

   public static LocalDateTime dateToLocalDateTime(Date date) {
      ZoneId zone = ZoneId.systemDefault();
      return LocalDateTime.ofInstant(date.toInstant(), zone);
   }

   public static LocalDate dateToLocalDate(Date date) {
      return dateToLocalDateTime(date).toLocalDate();
   }

   public static Date localDateToDate(LocalDate localDate) {
      ZoneId zone = ZoneId.systemDefault();
      Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
      return Date.from(instant);
   }

   public static Date localDateTimeToDate(LocalDateTime localDateTime) {
      ZoneId zone = ZoneId.systemDefault();
      Instant instant = localDateTime.atZone(zone).toInstant();
      return Date.from(instant);
   }

   public static Integer calculateWeekOrder(Date startDate, Date endDate) {
      LocalDate startLocalDate = dateToLocalDate(startDate);
      startLocalDate = startLocalDate.plusDays(-startLocalDate.getDayOfWeek().getValue() + 1L);
      LocalDate endLocalDate = dateToLocalDate(endDate);
      return Period.between(startLocalDate, endLocalDate).getDays() / 7 + 1;
   }

   public static Integer calculateDayOrder(Date startDate, Date endDate) {
      if (startDate != null && endDate != null) {
         long start = startDate.getTime();
         long end = endDate.getTime();
         long day = (end - start) / 86400000L;
         return Integer.parseInt(String.valueOf(day));
      } else {
         return null;
      }
   }

   public static Integer calculateMonthOrder(Date startDate, Date endDate) {
      LocalDate startLocalDate = dateToLocalDate(startDate);
      LocalDate endLocalDate = dateToLocalDate(endDate);
      return endLocalDate.getMonth().getValue() - startLocalDate.getMonth().getValue() + 1;
   }

   public static List<String> getSundayListByYearMonth(Integer year, Integer month) {
      List<String> mondayList = new ArrayList<>(8);
      LocalDate localDate = LocalDate.of(year, month, 1);
      LocalDate firstSunday = localDate.plusDays(-localDate.getDayOfWeek().getValue());
      mondayList.add(firstSunday.toString());
      mondayList.add(firstSunday.plusWeeks(1L).toString());
      mondayList.add(firstSunday.plusWeeks(2L).toString());
      mondayList.add(firstSunday.plusWeeks(3L).toString());
      mondayList.add(firstSunday.plusWeeks(4L).toString());
      return mondayList;
   }

   public static String getStartDateAndEndDateStr(Long startDate, Long endDate) {
      if (startDate == null && endDate == null) {
         return "全部";
      }

      StringBuilder sb = new StringBuilder();
      if (startDate != null) {
         sb.append(dateToString(longToDate(startDate)));
      }

      sb.append("-");
      if (endDate != null) {
         sb.append(dateToString(longToDate(endDate)));
      }

      return sb.toString();
   }

   public static List<String> getLastDayOfMonthListByYear(Integer year) {
      List<String> lastDayOfMonthList = new ArrayList<>(12);
      LocalDate lastYearDec = LocalDate.of(year - 1, 12, 31);
      lastDayOfMonthList.add(lastYearDec.toString());

      for (int i = 1; i <= 11; i++) {
         lastDayOfMonthList.add(lastYearDec.plusMonths(i).toString());
      }

      return lastDayOfMonthList;
   }

   public static Date getEndDate(LocalDate startLocalDate, Integer dateType) {
      return localDateToDate(dateType == 1 ? startLocalDate.plusWeeks(1L) : startLocalDate.plusMonths(1L));
   }

   public static Integer getOrder(Date startDate, Date endDate, Integer dateType) {
      return dateType == 1 ? calculateWeekOrder(startDate, endDate) : calculateMonthOrder(startDate, endDate);
   }

   public static Boolean isBefore(Date startDate, Date endDate) {
      LocalDate startLocalDate = dateToLocalDate(startDate);
      LocalDate endLocalDate = dateToLocalDate(endDate);
      return startLocalDate.isBefore(endLocalDate);
   }

   public static Boolean isBeforeByTime(Date startDate, Date endDate) {
      return startDate.getTime() - endDate.getTime() < 0L;
   }

   public static Date longToDate(Long time) {
      return time == null ? null : new Date(time);
   }

   private DateTimeUtil() {
   }

   public static String localDateToString(LocalDate localDate, String pattern) {
      DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
      return localDate == null ? null : dateTimeFormatter.format(localDate);
   }

   public static String localDateToString(LocalDate localDate) {
      DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
      return localDate == null ? null : dateTimeFormatter.format(localDate);
   }

   public static String dateToString(Date date) {
      if (date == null) {
         return null;
      }

      LocalDate localDate = dateToLocalDate(date);
      DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
      return dateTimeFormatter.format(localDate);
   }

   public static String format(Date date, String pattern) {
      if (date != null) {
         Instant instant = date.toInstant();
         LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
         return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
      } else {
         return null;
      }
   }

   public static String getMonthStr(Date date) {
      LocalDate localDate = dateToLocalDate(date);
      DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM");
      return date == null ? null : dateTimeFormatter.format(localDate);
   }

   public static Long getTimeByYearStr(String year) {
      year = year + "-01-01";
      DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

      Long time;
      try {
         time = LocalDate.parse(year, dateTimeFormatter).atStartOfDay().toInstant(ZoneOffset.of("+8")).toEpochMilli();
      } catch (Exception e) {
         throw new IllegalArgumentException("日期格式错误");
      }

      return getMonthEndTime(time);
   }

   public static Long getTimeByMonthStr(String month) {
      month = month + "-01";
      DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

      Long time;
      try {
         time = LocalDate.parse(month, dateTimeFormatter).atStartOfDay().toInstant(ZoneOffset.of("+8")).toEpochMilli();
      } catch (Exception e) {
         throw new IllegalArgumentException("日期格式错误");
      }

      return getMonthEndTime(time);
   }

   public static String getDayStr(Date date) {
      if (date == null) {
         return null;
      }

      LocalDate localDate = dateToLocalDate(date);
      DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      return date == null ? null : dateTimeFormatter.format(localDate);
   }

   public static String timestampToString(Long time) {
      return time == null ? null : localDateToString(dateToLocalDate(longToDate(time)));
   }

   public static String getCurrentDate() {
      return localDateToString(LocalDate.now());
   }

   public static List<String> getMonthListByYear(Long dateTime) {
      List<String> monthList = new ArrayList<>();
      Date date = new Date(dateTime);
      Calendar c = Calendar.getInstance();
      c.setTime(date);
      c.set(5, 1);
      c.set(2, 1);

      for (int i = 0; i < 12; i++) {
         c.set(2, i);
         monthList.add(getYearAndMonth(c.getTimeInMillis()));
      }

      return monthList;
   }

   public static List<String> getDayListByMonth(Long dateTime) {
      List<String> dayList = new ArrayList<>();
      Date date = new Date(dateTime);
      Calendar c = Calendar.getInstance();
      c.setTime(date);
      int monthDay = c.getActualMaximum(5);

      for (int i = 0; i < monthDay; i++) {
         c.set(5, i + 1);
         dayList.add(getDayStr(c.getTime()));
      }

      return dayList;
   }

   public static Long getMonthEndTime(Long timeStamp) {
      Calendar calendar = Calendar.getInstance();
      calendar.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
      calendar.setTimeInMillis(timeStamp);
      calendar.add(1, 0);
      calendar.add(2, 0);
      calendar.set(5, calendar.getActualMaximum(5));
      calendar.set(11, 23);
      calendar.set(12, 59);
      calendar.set(13, 59);
      calendar.set(14, 999);
      return calendar.getTimeInMillis();
   }

   public static Date getStartTime(Date date) {
      Calendar todayStart = Calendar.getInstance();
      todayStart.setTime(date);
      todayStart.set(11, 0);
      todayStart.set(12, 0);
      todayStart.set(13, 0);
      todayStart.set(14, 0);
      return todayStart.getTime();
   }

   public static Date getEndTime(Date date) {
      Calendar todayEnd = Calendar.getInstance();
      todayEnd.setTime(date);
      todayEnd.set(11, 23);
      todayEnd.set(12, 59);
      todayEnd.set(13, 59);
      todayEnd.set(14, 999);
      return todayEnd.getTime();
   }

   public static String getYear(Long time) {
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(longToDate(time));
      return calendar.get(1) + "";
   }

   public static String getYearAndMonth(Long time) {
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(longToDate(time));
      return calendar.get(2) < 9 ? calendar.get(1) + "-" + "0" + (calendar.get(2) + 1) : calendar.get(1) + "-" + (calendar.get(2) + 1);
   }

   public static Long getBetweenDays(Date startDate, Date endDate) {
      return startDate != null && endDate != null ? (endDate.getTime() - startDate.getTime()) / 86400000L : null;
   }

   public static String dateToStringDd(Date date) {
      if (date == null) {
         return null;
      }

      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      return format.format(date);
   }

   public static Integer getBetweenDays(LocalDate startDate, LocalDate endDate) {
      if (startDate != null && endDate != null) {
         long days = endDate.toEpochDay() - startDate.toEpochDay();
         return (int)days + 1;
      } else {
         return null;
      }
   }

   public static MonthTimeRange getMonthTimeRange(String date) {
      MonthTimeRange monthTimeRange = null;
      String s = corn.split(" ")[3];
      LocalDateTime time = null;
      if (StrUtil.isNumeric(date)) {
         int i = Integer.parseInt(date);
         if (i > 0 && i < 13) {
            time = LocalDateTime.of(LocalDateTime.now().getYear(), i, 1, 1, 1, 1, 1);
         }
      } else {
         String[] split = date.split(date.charAt(4) + "");
         String year = split[0];
         String month = split[1];
         if (StrUtil.isNumeric(year) && StrUtil.isNumeric(month)) {
            time = LocalDateTime.of(Integer.parseInt(year), Integer.parseInt(month), 1, 1, 1, 1, 1);
         }
      }

      if (time != null) {
         monthTimeRange = new MonthTimeRange();
         if (s.equals("L")) {
            monthTimeRange.setStartTime(LocalDateTime.of(LocalDate.from(time.with(TemporalAdjusters.firstDayOfMonth())), LocalTime.MIN));
            monthTimeRange.setEndTime(LocalDateTime.of(LocalDate.from(time.with(TemporalAdjusters.lastDayOfMonth())), LocalTime.MAX));
         } else {
            monthTimeRange.setStartTime(
               LocalDateTime.of(LocalDate.from(time.with(TemporalAdjusters.firstDayOfMonth())), LocalTime.MIN).minusMonths(1L).plusDays(Integer.parseInt(s))
            );
            monthTimeRange.setEndTime(
               LocalDateTime.of(LocalDate.from(time.with(TemporalAdjusters.firstDayOfMonth())), LocalTime.MAX).plusDays(Integer.parseInt(s) - 1)
            );
         }
      }

      return monthTimeRange;
   }

   public static LocalDate getLocalDateFromString(String strDate) {
      LocalDate localDate = null;

      try {
         localDate = LocalDate.parse(strDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
      } catch (Exception e) {
         e.printStackTrace();
      }

      return localDate;
   }

   public static LocalDateTime getLocalDateTimeFromString(String strDateTime) {
      LocalDateTime localDateTime = null;

      try {
         localDateTime = LocalDateTime.parse(strDateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
      } catch (Exception e) {
         e.printStackTrace();
      }

      return localDateTime;
   }

   public static LocalDateTime timestampToLocalDateTime(@NonNull Object timestamp) {
      if (timestamp == null) {
         throw new NullPointerException("timestamp is marked non-null but is null");
      }

      String timestampStr = String.valueOf(timestamp);
      Preconditions.checkArgument(NumberUtil.isLong(timestampStr), "时间戳转LocalDateTime类型失败, 参数不正确");
      int length = timestampStr.length();
      Preconditions.checkArgument(ListUtil.toList(10, 13).contains(length), "时间戳转LocalDateTime类型失败, 参数不正确");
      long timestampLong = NumberUtil.parseLong(timestampStr);
      if (length == 10) {
         timestampLong *= 1000L;
      }

      return Instant.ofEpochMilli(timestampLong).atZone(ZoneId.of("Asia/Shanghai")).toLocalDateTime();
   }
}
