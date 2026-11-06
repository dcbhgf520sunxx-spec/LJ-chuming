package com.hzchum.pangu.common.util;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class DateTimeUtil {
   public static final String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
   public static final String DATE_PATTERN = "yyyy-MM-dd";
   public static final String DATE_ZH_PATTERN = "yyyy年MM月dd日";
   public static final String MONTH_PATTERN = "yyyy-MM";
   public static final String TIME_PATTERN = "HH:mm:ss";
   public static final String UNSIGNED_DATETIME_PATTERN = "yyyyMMddHHmmss";
   public static final String UNSIGNED_DATE_PATTERN = "yyyyMMdd";
   public static final Integer SPRING = 1;
   public static final Integer SUMMER = 2;
   public static final Integer AUTUMN = 3;
   public static final Integer WINTER = 4;
   public static final String SUNDAY = "星期日";
   public static final String MONDAY = "星期一";
   public static final String TUESDAY = "星期二";
   public static final String WEDNESDAY = "星期三";
   public static final String THURSDAY = "星期四";
   public static final String FRIDAY = "星期五";
   public static final String SATURDAY = "星期六";
   private static final String YEAR = "year";
   private static final String MONTH = "month";
   private static final String WEEK = "week";
   private static final String DAY = "day";
   private static final String HOUR = "hour";
   private static final String MINUTE = "minute";
   private static final String SECOND = "second";

   public static String getLocalDateTimeStr() {
      return format(LocalDateTime.now(), "yyyy-MM-dd HH:mm:ss");
   }

   public static String getLocalDateStr() {
      return format(LocalDate.now(), "yyyy-MM-dd");
   }

   public static String getLocalDateStr(LocalDate localDate) {
      return format(localDate, "yyyy-MM-dd");
   }

   public static String getLocalDateStr(LocalDateTime dateTime) {
      return format(dateTime, "yyyy-MM-dd");
   }

   public static String getLocalDateZhStr(LocalDate dateTime) {
      return format(dateTime, "yyyy年MM月dd日");
   }

   public static String getLocalMonthStr() {
      return format(LocalDate.now(), "yyyy-MM");
   }

   public static String getLocalMonthStr(LocalDateTime dateTime) {
      return format(dateTime, "yyyy-MM");
   }

   public static String getLocalMonthStr(LocalDate dateTime) {
      return format(dateTime, "yyyy-MM");
   }

   public static String getLocalTimeStr() {
      return format(LocalTime.now(), "HH:mm:ss");
   }

   public static String getDayOfWeekStr() {
      return format(LocalDate.now(), "E");
   }

   public static String getDayOfWeekStr(LocalDate localDate) {
      String[] weekOfDays = new String[]{"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};
      int dayOfWeek = localDate.getDayOfWeek().getValue() - 1;
      return weekOfDays[dayOfWeek];
   }

   public static String format(TemporalAccessor temporal, String pattern) {
      DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
      return dateTimeFormatter.format(temporal);
   }

   public static LocalDateTime parseLocalDateTime(String localDateTimeStr, String pattern) {
      DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
      return LocalDateTime.parse(localDateTimeStr, dateTimeFormatter);
   }

   public static LocalDate parseLocalDate(String localDateStr, String pattern) {
      DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
      return LocalDate.parse(localDateStr, dateTimeFormatter);
   }

   public static LocalDateTime parseLocalDateTime(Long timestamp) {
      return timestamp == null ? null : Instant.ofEpochMilli(timestamp).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
   }

   public static LocalDate parseLocalDate(Long timestamp) {
      return timestamp == null ? null : Instant.ofEpochMilli(timestamp).atZone(ZoneOffset.ofHours(8)).toLocalDate();
   }

   public static LocalDateTime plus(LocalDateTime localDateTime, int num, ChronoUnit chronoUnit) {
      return localDateTime.plus(num, chronoUnit);
   }

   public static LocalDateTime minus(LocalDateTime localDateTime, int num, ChronoUnit chronoUnit) {
      return localDateTime.minus(num, chronoUnit);
   }

   public static long getChronoUnitBetween(LocalDateTime start, LocalDateTime end, ChronoUnit chronoUnit) {
      return Math.abs(start.until(end, chronoUnit));
   }

   public static long getChronoUnitBetween(LocalDate start, LocalDate end, ChronoUnit chronoUnit) {
      return Math.abs(start.until(end, chronoUnit));
   }

   public static String getFirstDayOfYearStr() {
      return getFirstDayOfYearStr(LocalDateTime.now());
   }

   public static String getLastDayOfYearStr() {
      return getLastDayOfYearStr(LocalDateTime.now());
   }

   public static String getFirstDayOfYearStr(LocalDateTime localDateTime) {
      return getFirstDayOfYearStr(localDateTime, "yyyy-MM-dd HH:mm:ss");
   }

   public static String getLastDayOfYearStr(LocalDateTime localDateTime) {
      return getLastDayOfYearStr(localDateTime, "yyyy-MM-dd HH:mm:ss");
   }

   public static String getFirstDayOfYearStr(LocalDateTime localDateTime, String pattern) {
      return format(localDateTime.withDayOfYear(1).withHour(0).withMinute(0).withSecond(0), pattern);
   }

   public static String getLastMonthStr() {
      return getLastMonthStr(LocalDateTime.now(), "yyyy-MM");
   }

   public static String getLastMonthStr(LocalDateTime localDateTime, String pattern) {
      return format(localDateTime.plusMonths(-1L), pattern);
   }

   public static String getLastDayOfYearStr(LocalDateTime localDateTime, String pattern) {
      return format(localDateTime.with(TemporalAdjusters.lastDayOfYear()).withHour(23).withMinute(59).withSecond(59), pattern);
   }

   public static String getFirstDayOfMonthStr() {
      return getFirstDayOfMonthStr(LocalDateTime.now());
   }

   public static String getLastDayOfMonthStr() {
      return getLastDayOfMonthStr(LocalDateTime.now());
   }

   public static String getFirstDayOfMonthStr(LocalDateTime localDateTime) {
      return getFirstDayOfMonthStr(localDateTime, "yyyy-MM-dd HH:mm:ss");
   }

   public static String getLastDayOfMonthStr(LocalDateTime localDateTime) {
      return getLastDayOfMonthStr(localDateTime, "yyyy-MM-dd HH:mm:ss");
   }

   public static String getFirstDayOfMonthStr(LocalDateTime localDateTime, String pattern) {
      return format(localDateTime.withDayOfMonth(1).withHour(0).withMinute(0).withSecond(0), pattern);
   }

   public static String getLastDayOfMonthStr(LocalDateTime localDateTime, String pattern) {
      return format(localDateTime.with(TemporalAdjusters.lastDayOfMonth()).withHour(23).withMinute(59).withSecond(59), pattern);
   }

   public static String getFirstDayOfWeekStr() {
      return getFirstDayOfWeekStr(LocalDateTime.now());
   }

   public static String getLastDayOfWeekStr() {
      return getLastDayOfWeekStr(LocalDateTime.now());
   }

   public static String getFirstDayOfWeekStr(LocalDateTime localDateTime) {
      return getFirstDayOfWeekStr(localDateTime, "yyyy-MM-dd HH:mm:ss");
   }

   public static String getLastDayOfWeekStr(LocalDateTime localDateTime) {
      return getLastDayOfWeekStr(localDateTime, "yyyy-MM-dd HH:mm:ss");
   }

   public static String getFirstDayOfWeekStr(LocalDateTime localDateTime, String pattern) {
      return format(localDateTime.with(DayOfWeek.MONDAY).withHour(0).withMinute(0).withSecond(0), pattern);
   }

   public static String getLastDayOfWeekStr(LocalDateTime localDateTime, String pattern) {
      return format(localDateTime.with(DayOfWeek.SUNDAY).withHour(23).withMinute(59).withSecond(59), pattern);
   }

   public static String getStartTimeOfDayStr() {
      return getStartTimeOfDayStr(LocalDateTime.now());
   }

   public static String getEndTimeOfDayStr() {
      return getEndTimeOfDayStr(LocalDateTime.now());
   }

   public static String getStartTimeOfDayStr(LocalDateTime localDateTime) {
      return getStartTimeOfDayStr(localDateTime, "yyyy-MM-dd HH:mm:ss");
   }

   public static String getEndTimeOfDayStr(LocalDateTime localDateTime) {
      return getEndTimeOfDayStr(localDateTime, "yyyy-MM-dd HH:mm:ss");
   }

   public static String getStartTimeOfDayStr(LocalDateTime localDateTime, String pattern) {
      return format(localDateTime.withHour(0).withMinute(0).withSecond(0), pattern);
   }

   public static String getEndTimeOfDayStr(LocalDateTime localDateTime, String pattern) {
      return format(localDateTime.withHour(23).withMinute(59).withSecond(59), pattern);
   }

   public static List<String> listDateStrs(String startDate, String endDate, String period) {
      List<String> result = new ArrayList<>();
      DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      LocalDate end = LocalDate.parse(endDate, dateTimeFormatter);
      LocalDate start = LocalDate.parse(startDate, dateTimeFormatter);
      LocalDate tmp = start;
      switch (period) {
         case "day":
            while (start.isBefore(end) || start.isEqual(end)) {
               result.add(start.toString());
               start = start.plusDays(1L);
            }
            break;
         case "week":
            while (tmp.isBefore(end) || tmp.isEqual(end)) {
               if (tmp.plusDays(6L).isAfter(end)) {
                  result.add(tmp.toString() + "," + end);
               } else {
                  result.add(tmp.toString() + "," + tmp.plusDays(6L));
               }

               tmp = tmp.plusDays(7L);
            }
            break;
         case "month":
            while (tmp.isBefore(end) || tmp.isEqual(end)) {
               LocalDate lastDayOfMonth = tmp.with(TemporalAdjusters.lastDayOfMonth());
               if (lastDayOfMonth.isAfter(end)) {
                  result.add(tmp.toString() + "," + end);
               } else {
                  result.add(tmp.toString() + "," + lastDayOfMonth);
               }

               tmp = lastDayOfMonth.plusDays(1L);
            }
            break;
         case "year":
            while (tmp.isBefore(end) || tmp.isEqual(end)) {
               LocalDate lastDayOfYear = tmp.with(TemporalAdjusters.lastDayOfYear());
               if (lastDayOfYear.isAfter(end)) {
                  result.add(tmp.toString() + "," + end);
               } else {
                  result.add(tmp.toString() + "," + lastDayOfYear);
               }

               tmp = lastDayOfYear.plusDays(1L);
            }
      }

      return result;
   }

   public static List<LocalDate> allMonthsOfYear(LocalDate now) {
      List<LocalDate> allMonths = new ArrayList<>();

      for (int i = 0; i < 12; i++) {
         LocalDate date = now.withMonth(i + 1).withDayOfMonth(1);
         allMonths.add(date);
      }

      return allMonths;
   }

   public static long getBetweenDay(LocalDate startDate, LocalDate endDate) {
      return ChronoUnit.DAYS.between(startDate, endDate);
   }

   public static long getBetweenMonth(LocalDate startDate, LocalDate endDate) {
      return ChronoUnit.MONTHS.between(startDate, endDate);
   }

   public static List<String> getDays(Integer days) {
      Calendar c = Calendar.getInstance();
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      List<String> lsDate = new ArrayList<>();

      for (int i = 0; i < days; i++) {
         c.setTime(new Date());
         c.add(5, -i);
         Date d = c.getTime();
         lsDate.add(sdf.format(d));
         Collections.sort(lsDate);
      }

      return lsDate;
   }

   public static List<String> getMonths(Integer months) {
      Calendar c = Calendar.getInstance();
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
      List<String> lsDate = new ArrayList<>();

      for (int i = 0; i < months; i++) {
         c.setTime(new Date());
         c.add(2, -i);
         Date d = c.getTime();
         lsDate.add(sdf.format(d));
         Collections.sort(lsDate);
      }

      return lsDate;
   }

   public static List<String> getYears(Integer years) {
      Calendar c = Calendar.getInstance();
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
      List<String> lsDate = new ArrayList<>();

      for (int i = 0; i < years; i++) {
         c.setTime(new Date());
         c.add(1, -i);
         Date d = c.getTime();
         lsDate.add(sdf.format(d));
         Collections.sort(lsDate);
      }

      return lsDate;
   }

   public static void main(String[] args) {
      System.out.println(getBetweenMonth(LocalDate.now(), LocalDate.now()));
      System.out.println(getBetweenDay(LocalDate.now(), LocalDate.now()));
      System.out.println(getLocalDateTimeStr());
      System.out.println(getLocalDateStr());
      System.out.println(getLocalTimeStr());
      System.out.println(getDayOfWeekStr());
      System.out.println(getDayOfWeekStr(LocalDate.now()));
      System.out.println("========");
      System.out.println(format(LocalDate.now(), "yyyyMMdd"));
      System.out.println("========");
      System.out.println(parseLocalDateTime("2020-12-13 11:14:12", "yyyy-MM-dd HH:mm:ss"));
      System.out.println(parseLocalDate("2020-12-13", "yyyy-MM-dd"));
      System.out.println("========");
      System.out.println(plus(LocalDateTime.now(), 3, ChronoUnit.HOURS));
      System.out.println(minus(LocalDateTime.now(), 4, ChronoUnit.DAYS));
      System.out.println("========");
      System.out.println(getChronoUnitBetween(LocalDateTime.now(), parseLocalDateTime("2020-12-12 12:03:12", "yyyy-MM-dd HH:mm:ss"), ChronoUnit.MINUTES));
      System.out.println(getChronoUnitBetween(LocalDate.now(), parseLocalDate("2021-12-12", "yyyy-MM-dd"), ChronoUnit.WEEKS));
      System.out.println("========");
      System.out.println(getFirstDayOfYearStr());
      System.out.println(getFirstDayOfYearStr(parseLocalDateTime("2021-12-12 12:03:12", "yyyy-MM-dd HH:mm:ss")));
      System.out.println(getFirstDayOfYearStr(parseLocalDateTime("2021-12-12 12:03:12", "yyyy-MM-dd HH:mm:ss"), "yyyyMMddHHmmss"));
      System.out.println(getLastDayOfYearStr());
      System.out.println(getLastDayOfYearStr(parseLocalDateTime("2021-12-12 12:03:12", "yyyy-MM-dd HH:mm:ss")));
      System.out.println(getLastDayOfYearStr(parseLocalDateTime("2021-12-12 12:03:12", "yyyy-MM-dd HH:mm:ss"), "yyyyMMddHHmmss"));
      System.out.println("========");
      System.out.println(getFirstDayOfMonthStr());
      System.out.println(getFirstDayOfMonthStr(parseLocalDateTime("2021-12-12 12:03:12", "yyyy-MM-dd HH:mm:ss")));
      System.out.println(getFirstDayOfMonthStr(parseLocalDateTime("2021-12-12 12:03:12", "yyyy-MM-dd HH:mm:ss"), "yyyyMMddHHmmss"));
      System.out.println(getLastDayOfMonthStr());
      System.out.println(getLastDayOfMonthStr(parseLocalDateTime("2021-12-12 12:03:12", "yyyy-MM-dd HH:mm:ss")));
      System.out.println(getLastDayOfMonthStr(parseLocalDateTime("2021-12-12 12:03:12", "yyyy-MM-dd HH:mm:ss"), "yyyyMMddHHmmss"));
      System.out.println("========");
      System.out.println(getFirstDayOfWeekStr());
      System.out.println(getFirstDayOfWeekStr(parseLocalDateTime("2021-12-12 12:03:12", "yyyy-MM-dd HH:mm:ss")));
      System.out.println(getFirstDayOfWeekStr(parseLocalDateTime("2021-12-12 12:03:12", "yyyy-MM-dd HH:mm:ss"), "yyyyMMddHHmmss"));
      System.out.println(getLastDayOfWeekStr());
      System.out.println(getLastDayOfWeekStr(parseLocalDateTime("2021-12-12 12:03:12", "yyyy-MM-dd HH:mm:ss")));
      System.out.println(getLastDayOfWeekStr(parseLocalDateTime("2021-12-12 12:03:12", "yyyy-MM-dd HH:mm:ss"), "yyyyMMddHHmmss"));
      System.out.println("========");
      System.out.println(getStartTimeOfDayStr());
      System.out.println(getStartTimeOfDayStr(parseLocalDateTime("2021-12-12 12:03:12", "yyyy-MM-dd HH:mm:ss")));
      System.out.println(getStartTimeOfDayStr(parseLocalDateTime("2021-12-12 12:03:12", "yyyy-MM-dd HH:mm:ss"), "yyyyMMddHHmmss"));
      System.out.println(getEndTimeOfDayStr());
      System.out.println(getEndTimeOfDayStr(parseLocalDateTime("2021-12-12 12:03:12", "yyyy-MM-dd HH:mm:ss")));
      System.out.println(getEndTimeOfDayStr(parseLocalDateTime("2021-12-12 12:03:12", "yyyy-MM-dd HH:mm:ss"), "yyyyMMddHHmmss"));
      System.out.println("========");

      for (String dateStr : listDateStrs("2019-01-30", "2020-12-13", "year")) {
         System.out.println(dateStr);
      }

      System.out.println("========");

      for (String dateStr : listDateStrs("2019-01-30", "2020-12-13", "month")) {
         System.out.println(dateStr);
      }

      System.out.println("========");

      for (String dateStr : listDateStrs("2020-12-01", "2020-12-13", "day")) {
         System.out.println(dateStr);
      }
   }
}
