package com.hzchum.pangu.common.nesting.NC1;

import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.FileUtil;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

public class NC1Parser {
   public static void main(String[] args) throws IOException {
      double assembleRealLength = getAssembleRealLength("C:\\project\\17-15GL-76.nc1");
      System.out.println(assembleRealLength);
   }

   public static void parse(String assembleSerial, String filePath, String outputDirectoryPath) throws IOException {
      String fileCharset = FileUtil.charset(filePath);
      List<String> lines = Files.readAllLines(Paths.get(filePath), Charset.forName(fileCharset));
      Pattern pattern = Pattern.compile("[\\w-]+(?=(\\.nc1))");
      Matcher matcher = pattern.matcher(lines.get(1));
      if (matcher.find()) {
         String artifactSN = matcher.group();

         for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            if (lines.get(i).contains(artifactSN)) {
               lines.set(i, line.replaceAll(artifactSN, assembleSerial));
            }
         }

         if (StringUtils.isBlank(outputDirectoryPath)) {
            outputDirectoryPath = filePath.substring(0, filePath.lastIndexOf("/"));
         }

         String outPath = outputDirectoryPath + "/" + assembleSerial + ".nc1";
         BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outPath));
         bufferedWriter.write(String.join("\r\n", lines));
         bufferedWriter.close();
      } else {
         try {
            throw new Exception("未获取到正确的构件编号信息");
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
   }

   public static double getAssembleRealLength(String filePath) throws IOException {
      String fileCharset = FileUtil.charset(filePath);
      List<String> lines = Files.readAllLines(Paths.get(filePath), Charset.forName(fileCharset));
      List<String> AK = new ArrayList<>();
      boolean needRecord = false;

      for (String line : lines) {
         if (needRecord && StringUtils.isNotBlank(line) && !line.matches("^[a-zA-Z]+$")) {
            AK.add(parseConsecutiveSpaces(line));
         } else {
            needRecord = false;
         }

         if ("AK".equals(line)) {
            needRecord = true;
         }
      }

      return AK.stream().mapToDouble(row -> {
         String[] sArr = row.split("\\s");

         for (String s : sArr) {
            if (s.matches("\\d.*")) {
               return Double.parseDouble(s.replaceAll("[^\\d|.]", ""));
            }
         }

         return 0.0;
      }).max().orElse(0.0);
   }

   private static List<String> delimitedString(String str) {
      if (StringUtils.isBlank(str)) {
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

   public static void verificationNC1(String filePath, String specification, String serialNumber) throws IOException {
      String fileCharset = FileUtil.charset(filePath);
      List<String> lines = Files.readAllLines(Paths.get(filePath), Charset.forName(fileCharset));
      Pattern pattern = Pattern.compile("[\\w-]+(?=(\\.nc1))");
      Matcher matcher = pattern.matcher(lines.get(1));
      if (matcher.find()) {
         Preconditions.checkArgument(serialNumber.equals(matcher.group()), serialNumber + ".nc1的编号与文件名不一致!!!");
      }

      if (StringUtils.isNotBlank(specification)) {
         Preconditions.checkArgument(
            Objects.requireNonNull(delimitedString(specification)).get(0).equals(Objects.requireNonNull(delimitedString(lines.get(8).trim())).get(0)),
            serialNumber + ".nc1的规格与部件清单不一致!!!"
         );
      }

      Preconditions.checkArgument(!"so".equals(lines.get(9).trim()), serialNumber + ".nc1的第10行不能为so!!!");
      boolean akV = false;
      boolean akU = false;
      boolean akO = false;
      List<String> akVList = new ArrayList<>();
      List<String> akUList = new ArrayList<>();
      List<String> akOList = new ArrayList<>();

      for (int i = 0; i < lines.size(); i++) {
         if (akV && StringUtils.isNotBlank(lines.get(i)) && !lines.get(i).matches("^[a-zA-Z]+$")) {
            akVList.add(parseConsecutiveSpaces(lines.get(i)));
         } else {
            akV = false;
         }

         if (i < lines.size() - 1 && "AK".equals(lines.get(i).trim()) && "v".equals(parseConsecutiveSpaces(lines.get(i + 1)).toString().split("\\s")[0])) {
            akV = true;
         }

         if (akO && StringUtils.isNotBlank(lines.get(i)) && !lines.get(i).matches("^[a-zA-Z]+$")) {
            akOList.add(parseConsecutiveSpaces(lines.get(i)));
         } else {
            akO = false;
         }

         if (i < lines.size() - 1 && "AK".equals(lines.get(i).trim()) && "o".equals(parseConsecutiveSpaces(lines.get(i + 1)).toString().split("\\s")[0])) {
            akO = true;
         }

         if (akU && StringUtils.isNotBlank(lines.get(i)) && !lines.get(i).matches("^[a-zA-Z]+$")) {
            akUList.add(parseConsecutiveSpaces(lines.get(i)));
         } else {
            akU = false;
         }

         if (i < lines.size() - 1 && "AK".equals(lines.get(i).trim()) && "u".equals(parseConsecutiveSpaces(lines.get(i + 1)).toString().split("\\s")[0])) {
            akU = true;
         }
      }

      akVList.forEach(e -> {
         String[] split = e.split("\\s");

         for (int ix = split.length - 1; ix >= 0; ix--) {
            if (ix >= split.length - 4) {
               Preconditions.checkArgument("0.00".equals(split[ix]), serialNumber + ".nc1的AK_v的末尾四列必须都是0.00");
            }
         }
      });
      verificationDouble(akOList, serialNumber);
      verificationDouble(akUList, serialNumber);
      int u = 0;
      int o = 0;

      for (int i = 0; i < lines.size(); i++) {
         if (i < lines.size() - 1 && "AK".equals(lines.get(i).trim()) && "u".equals(parseConsecutiveSpaces(lines.get(i + 1).trim()).split("\\s")[0])) {
            u++;
         }

         if (i < lines.size() - 1 && "AK".equals(lines.get(i).trim()) && "o".equals(parseConsecutiveSpaces(lines.get(i + 1).trim()).split("\\s")[0])) {
            o++;
         }
      }

      Preconditions.checkArgument(u == 1 && o == 1, serialNumber + ".nc1的AK_u和AK_o有且仅能出现一次");
   }

   public static void verificationDouble(List<String> akList, String serialNumber) {
      double v = akList.stream().mapToDouble(row -> {
         String[] sArr = row.split("\\s");

         for (String sx : sArr) {
            if (sx.matches("\\d.*")) {
               return Double.parseDouble(sx.replaceAll("[^\\d|.]", ""));
            }
         }

         return 0.0;
      }).max().orElse(0.0);
      Preconditions.checkArgument(v > 0.0, serialNumber + ".nc1的AK_o或AK_v的数值不能都等于0");
      int i = 0;

      for (String s : akList) {
         String[] split = s.split("\\s");

         for (String s1 : split) {
            if (s.matches("\\d.*")) {
               double v1 = Double.parseDouble(s1.replaceAll("[^\\d|.]", ""));
               if (v1 == v) {
                  i++;
                  break;
               }
            }
         }
      }

      Preconditions.checkArgument(i >= 2, serialNumber + ".nc1的AK_o或AK_v的最大数值必须相同");
   }

   public static String parseConsecutiveSpaces(String str) {
      StringTokenizer pas = new StringTokenizer(str, " ");
      StringBuilder newStr = new StringBuilder();

      while (pas.hasMoreTokens()) {
         String s = pas.nextToken();
         newStr.append(s);
         newStr.append(" ");
      }

      return newStr.toString();
   }
}
