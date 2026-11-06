package com.hzchum.scim.plan.core.api.util;

import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.plan.core.api.pojo.dto.MistakeExportDTO;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class TechUtils {
   public static String getMachinePartThick(String spec) {
      StringUtils.replace(spec, "-", "*");
      StringUtils.replace(spec, "x", "*");
      StringUtils.replace(spec, "X", "*");
      String[] splitArr = StringUtils.split(spec, "*");
      String s = splitArr[0];
      if (Character.isLetter(s.charAt(0)) && Character.isDigit(s.charAt(s.length() - 1))) {
         char[] charArray = splitArr[0].toCharArray();
         int numberStartIndex = 0;

         for (int i = 0; i < charArray.length; i++) {
            if (Character.isDigit(charArray[i])) {
               numberStartIndex = i;
               break;
            }
         }

         return s.substring(numberStartIndex);
      } else {
         return null;
      }
   }

   public static String getSpecPrefix(String spec) {
      if (StringUtils.isBlank(spec)) {
         return null;
      }

      if (Character.isDigit(spec.charAt(0))) {
         return spec;
      }

      StringUtils.replace(spec, "-", "*");
      String[] splitArr = StringUtils.split(spec, "*");
      char[] charArray = splitArr[0].toCharArray();
      int startNumberIndex = -1;

      for (int i = 0; i < charArray.length; i++) {
         char c = charArray[i];
         boolean matches = String.valueOf(c).matches("[一-龥 ]");
         boolean boolDiameter = String.valueOf(c).equals("Φ") || String.valueOf(c).equals("⏀") || String.valueOf(c).equals("φ");
         if ((c < 'A' || c > 'Z') && !matches && !boolDiameter) {
            startNumberIndex = i;
            break;
         }
      }

      return StringUtils.substring(spec, 0, startNumberIndex);
   }

   public static String getMachinePartFront(String serialNumber) {
      serialNumber = StringUtils.deleteWhitespace(serialNumber);
      int lastIndexOf = StringUtils.lastIndexOf(serialNumber, "-");
      return StringUtils.substring(serialNumber, 0, lastIndexOf);
   }

   public static String[] getSpecList(String spec) {
      spec = StringUtils.replace(spec, "--", "*");
      spec = StringUtils.replace(spec, "-", "*");
      String[] specArr = StringUtils.split(spec, "*");
      char[] chars = specArr[0].toCharArray();
      int startIndex = -1;

      for (int i = 0; i < chars.length; i++) {
         if (chars[i] >= '0' && chars[i] <= '9') {
            startIndex = i;
            break;
         }
      }

      specArr[0] = specArr[0].substring(startIndex).replaceAll("[a-zA-Z]", "");
      return specArr;
   }

   public static List<String> getExtractNumbers(String spec) {
      List<String> result = new ArrayList<>();
      Pattern pattern = Pattern.compile("\\((\\d+(?:-\\d+)*)\\)");
      Matcher matcher = pattern.matcher(spec);
      if (matcher.find()) {
         String group = matcher.group(1);
         String[] parts = group.split("-");
         int max = Integer.MIN_VALUE;

         for (String part : parts) {
            int num = Integer.parseInt(part);
            if (num > max) {
               max = num;
            }
         }

         result.add(String.valueOf(max));
         spec = spec.replaceFirst("\\(\\d+(?:-\\d+)*\\)", "");
      }

      pattern = Pattern.compile("\\*(\\d+)");
      matcher = pattern.matcher(spec);

      while (matcher.find()) {
         result.add(matcher.group(1));
      }

      return result;
   }

   public static String getSerialNumberPrefix(String serialNumber) {
      Preconditions.checkArgument(StringUtils.isNotBlank(serialNumber), "编号不能为空!");
      String[] splitArr = StringUtils.split(serialNumber, "-");
      List<String> splitList = Arrays.stream(splitArr).filter(s -> !NumberUtils.isDigits(s)).collect(Collectors.toList());
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(splitList), "编号不能全为数字!");
      List<String> snSplitList = new ArrayList<>();
      splitList.forEach(s -> {
         for (char c : s.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
               snSplitList.add(s);
               break;
            }
         }
      });
      String lastStr = snSplitList.get(snSplitList.size() - 1);
      char[] charArray = lastStr.toCharArray();
      int startIndex = -1;
      int endIndex = -1;

      for (int i = charArray.length - 1; i >= 0; i--) {
         boolean flag = charArray[i] <= 'Z' && charArray[i] >= 'A';
         if (flag) {
            startIndex = i;
            if (endIndex == -1) {
               endIndex = i;
            }
         } else if (endIndex != -1) {
            break;
         }
      }

      return lastStr.substring(startIndex, endIndex + 1);
   }

   public static void exportMistakeList(List<MistakeExportDTO> mistakeExportDTOList, HttpServletResponse response) {
      if (CollectionUtils.isNotEmpty(mistakeExportDTOList)) {
         String title = "构件清单导入出错表";
         String sheetName = "构件清单导入出错表";
         String fileName = "构件清单导入出错表.xls";

         try {
            response.setHeader("result", "code=50000;message=" + URLEncoder.encode("数据导入失败,具体信息请查看错误表格!", "UTF-8"));
            response.setHeader("Access-Control-Expose-Headers", "result");
         } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
         }

         PoiUtils.exportExcel(mistakeExportDTOList, title, sheetName, MistakeExportDTO.class, fileName, response);
      } else {
         try {
            response.setHeader("result", "code=20000;message=" + URLEncoder.encode("导入成功", "UTF-8"));
            response.setHeader("Access-Control-Expose-Headers", "result");
         } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
         }
      }
   }

   public static void exportMistakeListV3(List<MistakeExportDTO> mistakeExportDTOList, HttpServletResponse response) {
      if (CollectionUtils.isNotEmpty(mistakeExportDTOList)) {
         String title = "构件清单导入出错表";
         String sheetName = "构件清单导入出错表";
         String fileName = "构件清单导入出错表.xls";

         try {
            response.setHeader("result", "code=50000;message=" + URLEncoder.encode("数据导入失败,具体信息请查看错误表格!", "UTF-8"));
            response.setHeader("Access-Control-Expose-Headers", "result");
         } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
         }

         PoiUtils.exportExcel(mistakeExportDTOList, title, sheetName, MistakeExportDTO.class, fileName, ExcelType.XSSF, response);
         throw new BusinessException("导入失败,具体信息请查看错误表格!");
      } else {
         try {
            response.setHeader("result", "code=20000;message=" + URLEncoder.encode("导入成功", "UTF-8"));
            response.setHeader("Access-Control-Expose-Headers", "result");
         } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
         }
      }
   }

   public static void exportMistakeListV2(List<MistakeExportDTO> mistakeExportDTOList, HttpServletResponse response) {
      if (CollectionUtils.isNotEmpty(mistakeExportDTOList)) {
         String title = "出错表";
         String sheetName = "出错表";
         String fileName = "出错表.xls";

         try {
            response.setHeader("result", "code=50000;message=" + URLEncoder.encode("数据导入失败,具体信息请查看错误表格!", "UTF-8"));
            response.setHeader("Access-Control-Expose-Headers", "result");
         } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
         }

         PoiUtils.exportExcel(mistakeExportDTOList, title, sheetName, MistakeExportDTO.class, fileName, response);
      } else {
         try {
            response.setHeader("result", "code=20000;message=" + URLEncoder.encode("导入成功", "UTF-8"));
            response.setHeader("Access-Control-Expose-Headers", "result");
         } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
         }
      }
   }

   public static Boolean checkSpecification(String specification) {
      return Boolean.TRUE;
   }

   public static MistakeExportDTO buildMistakeByOrderNoDTO(Integer orderNo, String message) {
      MistakeExportDTO mistake = new MistakeExportDTO();
      mistake.setOrderNo(orderNo);
      mistake.setErrorMessage(message);
      return mistake;
   }

   public static MistakeExportDTO buildMistakeDTO(String message) {
      MistakeExportDTO mistake = new MistakeExportDTO();
      mistake.setOrderNo(null);
      mistake.setErrorMessage(message);
      return mistake;
   }

   public static int compareSerialNumbers(String serial1, String serial2) {
      String[] parts1 = serial1.split("-");
      String[] parts2 = serial2.split("-");
      int minLength = Math.min(parts1.length, parts2.length);

      for (int i = 0; i < minLength; i++) {
         int result = comparePart(parts1[i], parts2[i]);
         if (result != 0) {
            return result;
         }
      }

      return Integer.compare(parts1.length, parts2.length);
   }

   public static int comparePart(String part1, String part2) {
      boolean isNumeric1 = isNumeric(part1);
      boolean isNumeric2 = isNumeric(part2);
      if (isNumeric1 && isNumeric2) {
         return Long.compare(Long.parseLong(part1), Long.parseLong(part2));
      } else if (isNumeric1) {
         return 1;
      } else {
         return isNumeric2 ? -1 : part1.compareToIgnoreCase(part2);
      }
   }

   public static boolean isNumeric(String str) {
      if (str.isEmpty()) {
         return false;
      }

      for (char c : str.toCharArray()) {
         if (!Character.isDigit(c)) {
            return false;
         }
      }

      return true;
   }
}
