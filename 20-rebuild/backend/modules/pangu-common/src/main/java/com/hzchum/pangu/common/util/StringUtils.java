package com.hzchum.pangu.common.util;

import cn.hutool.core.util.StrUtil;
import com.google.common.base.CaseFormat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class StringUtils {
   public static final String REG_POINT = "\\.";
   public static final String SYMBOL_COMMA = ",";

   private StringUtils() {
   }

   public static List<Long> parseJoinedStr(String idJoinedStr) {
      String[] idArray = idJoinedStr.split(",");
      return Arrays.stream(idArray).map(Long::valueOf).collect(Collectors.toList());
   }

   public static List<String> parseStringToList(String str) {
      str = str.replace("[", "");
      str = str.replace("]", "");
      String[] idArray = str.split(",");
      return Stream.of(idArray).collect(Collectors.toList());
   }

   public static List<Long> parseJoinIdStrToLong(String idJoinedStr) {
      idJoinedStr = idJoinedStr.replace("(", "");
      idJoinedStr = idJoinedStr.replace(")", "");
      String[] idArray = idJoinedStr.split(",");
      return Arrays.stream(idArray).map(Long::valueOf).collect(Collectors.toList());
   }

   public static List<Integer> parseJoinIdStrToInteger(String idJoinedStr) {
      idJoinedStr = idJoinedStr.replace("(", "");
      idJoinedStr = idJoinedStr.replace(")", "");
      String[] idArray = idJoinedStr.split(",");
      return Arrays.stream(idArray).map(Integer::valueOf).collect(Collectors.toList());
   }

   public static List<Long> parseListStrToLongList(String idJoinedStr) {
      idJoinedStr = idJoinedStr.replace("[", "");
      idJoinedStr = idJoinedStr.replace("]", "");
      String[] idArray = idJoinedStr.split(",");
      return Arrays.stream(idArray).map(Long::valueOf).collect(Collectors.toList());
   }

   public static String timeToString(Long time) {
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      return format.format(time);
   }

   public static String camelToUnderline(String str) {
      return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, str);
   }

   public static String underlineToCamel(String str) {
      return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, str);
   }

   public static String analyzeSortConditions(List<String> sortList) {
      if (CollectionUtils.isEmpty(sortList)) {
         return null;
      }

      StringBuilder response = new StringBuilder();

      for (String sort : sortList) {
         String[] split = sort.split("\\.");
         response.append(camelToUnderline(split[0])).append(" ").append(split[1]).append(",");
      }

      String result = response.toString();
      return result.substring(0, result.length() - 1);
   }

   public static String analyzeSortConditions(List<String> sortList, Class<?> c) {
      if (CollectionUtils.isEmpty(sortList)) {
         return null;
      }

      List<String> fs = new ArrayList<>();
      ListClassFields(c, fs, null);
      StringBuilder orderString = new StringBuilder(256);
      sortList.forEach(sort -> {
         int lastPoint = sort.lastIndexOf(".");
         String fieldName = sort.substring(0, lastPoint);
         String orderMethod = sort.substring(lastPoint + 1);
         if (fs.contains(fieldName)) {
            orderString.append("`").append(camelToUnderline(fieldName)).append("`").append(" ").append(orderMethod).append(",");
         }
      });
      return orderString.substring(0, orderString.length() - 1);
   }

   private static void ListClassFields(Class<?> c, @NotNull List<String> fs, String pName) {
      Field[] fields = null;

      while (c != null) {
         fields = (Field[])ArrayUtils.addAll(fields, c.getDeclaredFields());
         c = c.getSuperclass();
      }

      List<Field> fl = Arrays.stream(fields).collect(Collectors.toList());
      String finalPName = StrUtil.isNotBlank(pName) ? pName + "." : "";
      fl.forEach(f -> {
         String tempName = finalPName + f.getName();
         Class<?> fc = f.getType();
         if (fc.getClassLoader() == null) {
            fs.add(tempName);
         } else {
            ListClassFields(fc, fs, tempName);
         }
      });
   }

   public static String replace(String s) {
      if (null != s && s.indexOf(".") > 0) {
         s = s.replaceAll("0+?$", "");
         s = s.replaceAll("[.]$", "");
      }

      return s;
   }

   public static String list2String(List<String> strings, String split) {
      StringBuilder response = new StringBuilder();

      for (String s : strings) {
         response.append(s).append(split);
      }

      String result = response.toString();
      return result.substring(0, result.length() - 1);
   }

   public static String generateSupplierCode(LocalDate localDate, Integer count) {
      count = count + 1;
      StringBuilder stringBuilder = new StringBuilder("HD-");
      stringBuilder.append(localDate.getYear()).append(localDate.getMonthValue()).append(localDate.getDayOfMonth()).append("-");
      stringBuilder.append(NumberUtil.getDigitsNumber(count, 2));
      return stringBuilder.toString();
   }

   public static int getLastLetterIndex(String str) {
      for (int i = str.length() - 1; i >= 0; i--) {
         if (i == str.length() - 1 && !Character.isDigit(str.charAt(i))) {
            return -1;
         }

         if (!Character.isDigit(str.charAt(i))) {
            return i + 1;
         }
      }

      return 0;
   }

   public static String stringStartTrim(String str, String trim) {
      if (!org.apache.commons.lang3.StringUtils.isBlank(str) && !org.apache.commons.lang3.StringUtils.isBlank(trim)) {
         String regPattern = "[" + trim + "]*+";
         Pattern pattern = Pattern.compile(regPattern);
         Matcher matcher = pattern.matcher(str);
         if (matcher.lookingAt()) {
            int end = matcher.end();
            str = str.substring(end);
         }

         return str;
      } else {
         return null;
      }
   }

   public static String getSerialNumberSpecPrefix(String name, Boolean index) {
      StringBuilder stringBuilder = new StringBuilder(name);
      stringBuilder.reverse();
      int startIndex = 0;

      for (int i = 0; i < stringBuilder.length(); i++) {
         if (stringBuilder.charAt(i) >= 'A' && stringBuilder.charAt(i) <= 'Z') {
            startIndex = i;
            break;
         }
      }

      stringBuilder.reverse();
      return new StringBuilder(name).substring(0, stringBuilder.length() - startIndex);
   }

   public static List<String> delimitedString(String str) {
      if (org.apache.commons.lang3.StringUtils.isBlank(str)) {
         return null;
      }

      char[] chars = str.toCharArray();
      int startNumberIndex = -1;

      for (int i = 0; i < chars.length; i++) {
         if (Character.isDigit(chars[i])) {
            startNumberIndex = i;
            break;
         }
      }

      List<String> list = new ArrayList<>();
      if (startNumberIndex != -1) {
         String end = str.substring(startNumberIndex);
         String start = str.substring(0, startNumberIndex);
         list.add(end);
         list.add(start);
         return list;
      } else {
         return null;
      }
   }

   public static String transformLowercaseSuffix(String name) {
      String[] split = org.apache.commons.lang3.StringUtils.split(name, ".");
      split[split.length - 1] = split[split.length - 1].toLowerCase();
      return org.apache.commons.lang3.StringUtils.join(split, ".");
   }

   public static Object removeTrimSpaces(Object object, Boolean flag) {
      Class<?> clazz = object.getClass();
      Field[] fields = clazz.getDeclaredFields();
      Object o = null;

      for (Field field : fields) {
         if (field.getGenericType().toString().equals("class java.lang.String")) {
            try {
               String itemName = titleCase(field.getName());
               Method getMethod = clazz.getMethod("get" + itemName);
               Method setMethod = clazz.getMethod("set" + itemName, String.class);
               String val = (String)getMethod.invoke(object);
               if (org.apache.commons.lang3.StringUtils.isNotBlank(val)) {
                  o = setMethod.invoke(object, org.apache.commons.lang3.StringUtils.trim(val));
               }
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      }

      return object;
   }

   private static String titleCase(String s) {
      char[] c = s.toCharArray();
      if (c[0] >= 'a' && c[0] <= 'z') {
         c[0] = (char)(c[0] - ' ');
      }

      return new String(c);
   }

   public static Boolean boolContainEnglishLetter(String str) {
      char[] chars = str.toCharArray();

      for (char c : chars) {
         boolean flag = c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
         if (flag) {
            return true;
         }
      }

      return false;
   }
}
