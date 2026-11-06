package com.hzchum.scim.contract.core.api.utils;

import java.util.ArrayList;
import java.util.List;

public class VersionGenerator {
   private static final int MAX_VERSION = 702;

   private String convertToVersionString(int num) {
      if (num <= 0) {
         return "";
      }

      if (num <= 26) {
         return String.valueOf((char)(65 + num - 1));
      }

      num -= 26;
      int firstCharIndex = (num - 1) / 26;
      int secondCharIndex = (num - 1) % 26;
      char firstChar = (char)(65 + firstCharIndex);
      char secondChar = (char)(65 + secondCharIndex);
      return "" + firstChar + secondChar;
   }

   public static List<String> generateAllVersions() {
      List<String> versions = new ArrayList<>();

      for (int i = 0; i < 26; i++) {
         versions.add(String.valueOf((char)(65 + i)));
      }

      for (int i = 0; i < 26; i++) {
         char firstChar = (char)(65 + i);

         for (int j = 0; j < 26; j++) {
            char secondChar = (char)(65 + j);
            versions.add("" + firstChar + secondChar);
         }
      }

      return versions;
   }

   public static String getVersionByNumber(int num) {
      if (num <= 0 || num > 702) {
         throw new IllegalArgumentException("版本号必须在1-702之间");
      }

      if (num <= 26) {
         return String.valueOf((char)(65 + num - 1));
      }

      num -= 26;
      int firstCharIndex = (num - 1) / 26;
      int secondCharIndex = (num - 1) % 26;
      char firstChar = (char)(65 + firstCharIndex);
      char secondChar = (char)(65 + secondCharIndex);
      return "" + firstChar + secondChar;
   }

   public static int getNumberByVersion(String version) {
      if (version != null && !version.isEmpty()) {
         version = version.toUpperCase();
         if (version.length() == 1) {
            char c = version.charAt(0);
            if (c >= 'A' && c <= 'Z') {
               return c - 65 + 1;
            } else {
               throw new IllegalArgumentException("无效的版本号格式");
            }
         } else if (version.length() == 2) {
            char firstChar = version.charAt(0);
            char secondChar = version.charAt(1);
            if (firstChar >= 'A' && firstChar <= 'Z' && secondChar >= 'A' && secondChar <= 'Z') {
               int firstNum = firstChar - 'A' + 1;
               int secondNum = secondChar - 'A' + 1;
               return 26 + (firstNum - 1) * 26 + secondNum;
            } else {
               throw new IllegalArgumentException("无效的版本号格式");
            }
         } else {
            throw new IllegalArgumentException("版本号长度必须为1或2个字符");
         }
      } else {
         throw new IllegalArgumentException("版本号不能为空");
      }
   }

   public static void main(String[] args) {
      System.out.println("=== 测试生成器 ===");
      int a = getNumberByVersion("A");
      String versionByNumber = getVersionByNumber(a + 1);
      System.err.println(a);
      System.err.println(versionByNumber);
      System.out.println("\n=== 所有版本示例 ===");
      List<String> allVersions = generateAllVersions();
      System.out.println("总版本数: " + allVersions.size());
      System.out.println("第一个版本: " + allVersions.get(0));
      System.out.println("第26个版本: " + allVersions.get(25));
      System.out.println("第27个版本: " + allVersions.get(26));
      System.out.println("第52个版本: " + allVersions.get(51));
      System.out.println("最后一个版本: " + allVersions.get(allVersions.size() - 1));
      System.out.println("\n=== 转换测试 ===");
      System.out.println("版本号A对应的数字: " + getNumberByVersion("A"));
      System.out.println("版本号Z对应的数字: " + getNumberByVersion("Z"));
      System.out.println("版本号AA对应的数字: " + getNumberByVersion("AA"));
      System.out.println("版本号AZ对应的数字: " + getNumberByVersion("AZ"));
      System.out.println("版本号BA对应的数字: " + getNumberByVersion("BA"));
      System.out.println("版本号ZZ对应的数字: " + getNumberByVersion("ZZ"));
      System.out.println("\n数字1对应的版本: " + getVersionByNumber(1));
      System.out.println("数字26对应的版本: " + getVersionByNumber(26));
      System.out.println("数字27对应的版本: " + getVersionByNumber(27));
      System.out.println("数字52对应的版本: " + getVersionByNumber(52));
      System.out.println("数字53对应的版本: " + getVersionByNumber(53));
      System.out.println("数字702对应的版本: " + getVersionByNumber(702));
   }
}
