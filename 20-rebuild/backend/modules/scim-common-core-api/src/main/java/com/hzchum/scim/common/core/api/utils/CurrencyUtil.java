package com.hzchum.scim.common.core.api.utils;

import java.math.BigDecimal;

public final class CurrencyUtil {
   private static final String H0 = "零";
   private static final String H1 = "壹";
   private static final String H2 = "贰";
   private static final String H3 = "叁";
   private static final String H4 = "肆";
   private static final String H5 = "伍";
   private static final String H6 = "陆";
   private static final String H7 = "柒";
   private static final String H8 = "捌";
   private static final String H9 = "玖";
   private static final String HUNDREDMILLION = "亿";
   private static final String TENTHOUSAND = "万";
   private static final String THOUSAND = "仟";
   private static final String HUNDRED = "佰";
   private static final String TEN = "拾";
   private static final String YUAN = "元";
   private static final String JIAO = "角";
   private static final String FEN = "分";
   private static final String ZHENG = "整";

   public static String convert(double money) {
      return convert(new BigDecimal(String.valueOf(money)));
   }

   public static String convert(String money) {
      return convert(new BigDecimal(money));
   }

   public static String convert(BigDecimal money) {
      String ret = "";
      long big = money.longValue();
      ret = ret + makeBig(big);
      int change = money.movePointRight(2).subtract(new BigDecimal(big).multiply(new BigDecimal("100"))).intValue();
      if (change == 0) {
         if (big == 0L) {
            ret = ret + "零元";
         }

         ret = ret + "整";
      } else {
         if (change < 10 && big != 0L) {
            ret = ret + "零";
         }

         ret = ret + makeChange(change);
      }

      return ret;
   }

   private static String makeBig(long money) {
      if (money == 0L) {
         return "";
      }

      String ret = "";
      int part1 = (int)(money % 10000L);
      int part2 = (int)(money % 100000000L - part1) / 10000;
      long part3 = money / 100000000L;
      String res1 = null;
      if (part3 > 0L) {
         String res2 = makeBig(part3);
         res2 = res2.substring(0, res2.length() - 1) + "亿";
         ret = ret + res2;
         if (part2 != 0 && part2 < 1000) {
            if (!ret.equals("")) {
               ret = ret + "零";
            }
         } else if (part2 >= 1000 && part3 % 10L == 0L && !ret.equals("")) {
            ret = ret + "零";
         }
      }

      if (part2 != 0) {
         res1 = format(part2);
         ret = ret + res1 + "万";
      }

      if (part1 == 0) {
         return ret + "元";
      }

      if (part1 < 1000) {
         if (!ret.equals("")) {
            ret = ret + "零";
         }
      } else if (part1 >= 1000 && part2 % 10 == 0 && !ret.equals("")) {
         ret = ret + "零";
      }

      String res2 = format(part1);
      ret = ret + res2;
      return ret + "元";
   }

   private static String makeChange(int money) {
      String ret = "";
      int jiao = money / 10;
      int fen = money - jiao * 10;
      if (jiao != 0) {
         ret = ret + num2Char(jiao) + "角";
      }

      if (fen != 0) {
         ret = ret + num2Char(fen) + "分";
      }

      return ret;
   }

   private static String format(int Num4) {
      String ret = "";
      int bit4 = Num4 / 1000;
      Num4 -= bit4 * 1000;
      int bit3 = Num4 / 100;
      Num4 -= bit3 * 100;
      int bit2 = Num4 / 10;
      Num4 -= bit2 * 10;
      if (bit4 != 0) {
         ret = num2Char(bit4) + "仟";
      }

      if (bit3 != 0) {
         ret = ret + num2Char(bit3) + "佰";
      }

      if (bit2 != 0) {
         if (bit3 == 0 && !ret.equals("")) {
            ret = ret + "零";
         }

         ret = ret + num2Char(bit2) + "拾";
      } else if (Num4 != 0 && !ret.equals("")) {
         ret = ret + "零";
      }

      if (Num4 != 0) {
         ret = ret + num2Char(Num4);
      }

      return ret;
   }

   private static String num2Char(int i) {
      switch (i) {
         case 0:
            return "零";
         case 1:
            return "壹";
         case 2:
            return "贰";
         case 3:
            return "叁";
         case 4:
            return "肆";
         case 5:
            return "伍";
         case 6:
            return "陆";
         case 7:
            return "柒";
         case 8:
            return "捌";
         case 9:
            return "玖";
         default:
            return "";
      }
   }

   public static void main(String[] args) {
      double money1 = 1.9875643434311E11;
      double money2 = 1.9875643434312E11;
      double money3 = 3.2;
      System.out.println(money1 + money2);
      System.out.println("------" + convert(money1 + money2));
      System.out.println("------" + convert("500000"));
      System.out.println("------" + convert("324534236346"));
      System.out.println("------" + convert("7000000000000"));
   }
}
