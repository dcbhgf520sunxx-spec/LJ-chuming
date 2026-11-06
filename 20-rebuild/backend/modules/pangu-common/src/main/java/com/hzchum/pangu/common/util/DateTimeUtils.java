package com.hzchum.pangu.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class DateTimeUtils {
   public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
   public static final String DATE_FORMAT = "yyyy/MM/dd";
   public static final String DATE_MONTH_FORMAT = "yyyy-MM";
   public static final String DATE_DAY_FORMAT = "yyyy-MM-dd";
   public static final String TIME_ZONE = "GMT+8:00";
   public static final String YY_MM_DD_FORMAT = "yyMMdd";
   public static final String YRAR_FORMAT = "yy";

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

   public static String getCurrentDateOfYYMMDD() {
      return localDateToString(LocalDate.now(), "yyMMdd");
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

   private DateTimeUtils() {
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

   public static String getCurrentYearOfYY() {
      return localDateToString(LocalDate.now(), "yy");
   }

   public static Long getExpirationTime() {
      Long expirationTime = null;

      try {
         String year = new SimpleDateFormat("yyyy").format(new Date());
         Long currentTime = System.currentTimeMillis();
         Long endYearTime = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").parse(year + "-12-31-23-59-59").getTime();
         expirationTime = (endYearTime - currentTime) / 1000L;
      } catch (ParseException e) {
         e.printStackTrace();
      }

      return expirationTime;
   }

   public static Long getTimeDifference() {
      Calendar calendar = Calendar.getInstance();
      calendar.add(6, 1);
      calendar.set(11, 0);
      calendar.set(13, 0);
      calendar.set(12, 0);
      calendar.set(14, 0);
      return calendar.getTimeInMillis() - System.currentTimeMillis();
   }

   public static Date monthFirstDay() {
      try {
         SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
         Calendar c = Calendar.getInstance();
         c.add(2, 0);
         c.set(5, 1);
         String monthFirst = format.format(c.getTime());
         return format.parse(monthFirst);
      } catch (Throwable $ex) {
         throw DateTimeUtils.<RuntimeException>rethrow($ex);
      }
   }

   public static Date monthLastDay() {
      try {
         SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
         Calendar cale = Calendar.getInstance();
         cale = Calendar.getInstance();
         cale.add(2, 1);
         cale.set(5, 0);
         String lastDay = format.format(cale.getTime());
         return format.parse(lastDay);
      } catch (Throwable $ex) {
         throw DateTimeUtils.<RuntimeException>rethrow($ex);
      }
   }

   // Preserve the original Lombok-generated unchecked rethrow without changing public signatures.
   @SuppressWarnings("unchecked")
   private static <E extends Throwable> RuntimeException rethrow(Throwable error) throws E {
      throw (E)error;
   }

   public static List<LocalDateTime> getFirstAndLastDayAsMonth(LocalDateTime newDateTime) {
      List<LocalDateTime> dateTimeList = new ArrayList<>();
      LocalDateTime date = LocalDateTime.now();
      LocalDateTime firstDay = newDateTime.with(TemporalAdjusters.firstDayOfMonth());
      LocalDateTime lastDay = newDateTime.with(TemporalAdjusters.lastDayOfMonth());
      int monthValue = firstDay.getMonthValue();
      int year = firstDay.getYear();
      int monthNow = date.getMonthValue();
      int yearNow = date.getYear();
      if (yearNow == year && monthNow == monthValue) {
         lastDay = date.plusDays(-1L);
      }

      dateTimeList.add(firstDay);
      dateTimeList.add(lastDay);
      return dateTimeList;
   }

   public static List<String> getTimePeriodFromMouthTime(Long startTime, Long endTime) {
      LocalDate start = Instant.ofEpochMilli(startTime).atZone(ZoneOffset.ofHours(8)).toLocalDate();
      LocalDate end = Instant.ofEpochMilli(endTime).atZone(ZoneOffset.ofHours(8)).toLocalDate();
      List<String> result = new ArrayList<>();
      YearMonth from = YearMonth.from(start);
      YearMonth to = YearMonth.from(end);

      for (long i = 0L; i <= ChronoUnit.MONTHS.between(from, to); i++) {
         result.add(String.valueOf(from.plusMonths(i).getMonthValue()));
      }

      return result;
   }
}
