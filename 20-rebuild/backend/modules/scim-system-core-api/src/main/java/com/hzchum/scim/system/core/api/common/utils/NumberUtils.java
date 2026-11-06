package com.hzchum.scim.system.core.api.common.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class NumberUtils {
   private static char[] fraction = new char[]{'角', '分', '厘', '毫'};
   private static char[] digit = new char[]{'零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖'};
   private static char[][] unit = new char[][]{{' ', '拾', '佰', '仟'}, {' ', '万', '亿', '兆'}};

   private NumberUtils() {
   }

   public static Float scaleFloat(Float number, int scale) {
      if (number == null) {
         return null;
      }

      BigDecimal bigDecimal = BigDecimal.valueOf(number.floatValue());
      return bigDecimal.setScale(scale, RoundingMode.HALF_UP).floatValue();
   }

   public static Double scaleDouble(Double number, int scale) {
      if (number == null) {
         return null;
      }

      BigDecimal bigDecimal = BigDecimal.valueOf(number);
      return bigDecimal.setScale(scale, RoundingMode.HALF_UP).doubleValue();
   }

   public static Double scale5Double(Double number) {
      return scaleDouble(number, 5);
   }

   public static Double scale2Double(Double number) {
      return scaleDouble(number, 2);
   }

   public static Double scale8Double(Double number) {
      return scaleDouble(number, 8);
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

   public static Double add(Double number, Double number1) {
      if (number == null && number1 == null) {
         return null;
      } else if (number == null && number1 != null) {
         return number1;
      } else {
         return number != null && number1 == null ? number : number + number1;
      }
   }

   public static Double divide(Double divisor, Double dividend) {
      if (dividend == null || dividend.equals(0)) {
         return 0.0;
      } else {
         return divisor != null && !dividend.equals(0) ? divisor / dividend : 0.0;
      }
   }

   public static Double subtract(Double number, Double minus) {
      if (number == null && minus == null) {
         return null;
      } else if (number == null) {
         return -minus;
      } else {
         return minus == null ? number : number - minus;
      }
   }

   public static Double multiply(Double multiplier, Double multiplicand) {
      return multiplier != null && multiplicand != null ? multiplier * multiplicand : null;
   }

   public static Boolean compareDifference(Double v1, Double v2, Double deviation) {
      return v1 >= v2 ? v1 - v2 < deviation : v2 - v1 < deviation;
   }

   public static String format2Str(BigDecimal number) {
      if (null == number) {
         return "-";
      }

      DecimalFormat decimalFormat = new DecimalFormat("###################.###########");
      return decimalFormat.format(number);
   }

   public static boolean isZero(Double number) {
      return BigDecimal.valueOf(number).compareTo(BigDecimal.ZERO) == 0;
   }

   public static String convert(Integer number) {
      String[] num = new String[]{"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
      String[] unit = new String[]{"", "十", "百", "千", "万", "十", "百", "千", "亿", "十", "百", "千", "万亿"};
      String result = String.valueOf(number);
      char[] ch = result.toCharArray();
      String str = "";
      int length = ch.length;

      for (int i = 0; i < length; i++) {
         int c = ch[i] - '0';
         if (c != 0) {
            str = str + num[c] + unit[length - i - 1];
         } else {
            str = str + num[c];
         }
      }

      return str;
   }
}
