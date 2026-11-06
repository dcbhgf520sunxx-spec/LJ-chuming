package com.hzchum.scim.mes.building.core.api.utils;

import java.util.Comparator;
import java.util.function.Function;

public class SerialNumberComparatorUtils<T> implements Comparator<T> {
   private final Function<T, String> serialNumberExtractor;

   public SerialNumberComparatorUtils(Function<T, String> serialNumberExtractor) {
      this.serialNumberExtractor = serialNumberExtractor;
   }

   @Override
   public int compare(T t1, T t2) {
      if (t1 == null && t2 == null) {
         return 0;
      }

      if (t1 == null) {
         return -1;
      }

      if (t2 == null) {
         return 1;
      }

      String sn1 = this.serialNumberExtractor.apply(t1);
      String sn2 = this.serialNumberExtractor.apply(t2);
      if (sn1 == null && sn2 == null) {
         return 0;
      }

      if (sn1 == null || sn1.isEmpty()) {
         return -1;
      }

      if (sn2 == null || sn2.isEmpty()) {
         return 1;
      }

      if (sn1.equals(sn2)) {
         return 0;
      }

      String[] parts1 = this.splitByLastDash(sn1);
      String[] parts2 = this.splitByLastDash(sn2);
      int prefixCompare = parts1[0].compareTo(parts2[0]);
      if (prefixCompare != 0) {
         return prefixCompare;
      }

      String suffix1 = parts1[1];
      String suffix2 = parts2[1];
      Integer num1 = this.extractNumber(suffix1);
      Integer num2 = this.extractNumber(suffix2);
      if (num1 != null && num2 != null) {
         int numCompare = Integer.compare(num1, num2);
         if (numCompare != 0) {
            return numCompare;
         }
      }

      return suffix1.compareTo(suffix2);
   }

   private String[] splitByLastDash(String str) {
      int lastDashIndex = str.lastIndexOf("-");
      return lastDashIndex == -1 ? new String[]{"", str} : new String[]{str.substring(0, lastDashIndex), str.substring(lastDashIndex + 1)};
   }

   private Integer extractNumber(String str) {
      try {
         StringBuilder numStr = new StringBuilder();

         for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
               break;
            }

            numStr.append(c);
         }

         return numStr.length() > 0 ? Integer.parseInt(numStr.toString()) : null;
      } catch (NumberFormatException e) {
         return null;
      }
   }

   public static <T> SerialNumberComparatorUtils<T> create(Function<T, String> serialNumberExtractor) {
      return new SerialNumberComparatorUtils<>(serialNumberExtractor);
   }
}
