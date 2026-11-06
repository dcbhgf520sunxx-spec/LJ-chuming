package com.hzchum.pangu.common.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class NumberUtil {
   private NumberUtil() {
   }

   public static String getDigitsNumber(Integer number, Integer digits) {
      if (number == null) {
         return "";
      }

      NumberFormat formatter = NumberFormat.getNumberInstance();
      formatter.setMinimumIntegerDigits(digits);
      formatter.setGroupingUsed(false);
      return formatter.format(number);
   }

   public static String convertToPercentage(BigDecimal number) {
      if (number == null) {
         return "";
      }

      NumberFormat percent = NumberFormat.getPercentInstance();
      percent.setMaximumFractionDigits(2);
      return percent.format(number.doubleValue());
   }

   public static Boolean rangeInDefined(BigDecimal minCurrent, BigDecimal maxCurrent, BigDecimal min, BigDecimal max) {
      return minCurrent.compareTo(max) > 0 || maxCurrent.compareTo(min) < 0;
   }

   public static List<String> findKeysWithMaxValue(Map<String, BigDecimal> map) {
      if (map != null && !map.isEmpty()) {
         BigDecimal maxValue = null;
         List<String> keysWithMaxValue = new ArrayList<>();

         for (Entry<String, BigDecimal> entry : map.entrySet()) {
            if (maxValue == null || entry.getValue().compareTo(maxValue) > 0) {
               maxValue = entry.getValue();
               keysWithMaxValue.clear();
               keysWithMaxValue.add(entry.getKey());
            } else if (entry.getValue().equals(maxValue)) {
               keysWithMaxValue.add(entry.getKey());
            }
         }

         return keysWithMaxValue;
      } else {
         return new ArrayList<>();
      }
   }
}
