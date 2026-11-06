package com.hzchum.pangu.common.util;

import java.util.Random;

public class RandomUtil extends cn.hutool.core.util.RandomUtil {
   private static final String S_STR = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
   private static final String S_ALL = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

   public static String random6Num() {
      return randomNumbers(6);
   }

   public static String random(int length) {
      return randomString("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789", length);
   }

   public static String randomString(int length) {
      return randomString("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz", length);
   }

   public static String randomStringFixedRule(String presetParameter) {
      Random random = new Random();
      long timestamp = random.nextLong() % 10000000000L;
      int initially = 1000 + random.nextInt(9000);
      int i = 1;
      StringBuilder capitalLetter = new StringBuilder();

      while (i < 5) {
         char rand = (char)(Math.random() * 26.0 + 65.0);
         capitalLetter.append(rand);
         i++;
      }

      return initially + presetParameter + timestamp + capitalLetter.toString();
   }
}
