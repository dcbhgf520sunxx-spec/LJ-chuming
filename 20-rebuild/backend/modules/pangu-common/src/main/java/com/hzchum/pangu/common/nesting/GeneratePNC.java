package com.hzchum.pangu.common.nesting;

import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.nesting.NC1.NC1Parser;
import com.hzchum.pangu.common.nesting.enums.NestingMode;
import com.hzchum.pangu.common.nesting.pojo.NestingAssemble;
import com.hzchum.pangu.common.nesting.pojo.ProfileNestingResult;
import com.hzchum.pangu.common.util.FileUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class GeneratePNC {
   public static void generate(ProfileNestingResult nestingResult, String outputDirectoryPath) throws IOException {
      int profileLength = nestingResult.nestingModeEnum.equals(NestingMode.LOSS_LESS.getType()) ? nestingResult.nestingLength : nestingResult.baseMetalLength;
      StringBuilder pncInfo = new StringBuilder();
      pncInfo.append(profileLength).append("\r\n");
      String specifications = nestingResult.specifications.replaceAll("-", "*");
      StringBuilder stringBuilder = new StringBuilder();
      if (nestingResult.crossSectionType.contains("-")) {
         String[] split = specifications.split("\\*");
         stringBuilder.append(split[0]).append("*").append(split[3]).append("*").append(split[1]).append("*").append(split[2]);
         specifications = new String(stringBuilder);
      }

      pncInfo.append(Arrays.stream(specifications.split("\\*")).map(s -> s + "\r\n").collect(Collectors.joining()));
      pncInfo.append("H\r\n");
      double partX = 0.0;
      double partL = 0.0;

      try {
         List<NestingAssemble> assembleList = nestingResult.assembleList;

         for (int i = 0; i < assembleList.size(); i++) {
            NestingAssemble assemble = assembleList.get(i);
            if (i == 0) {
               partX += nestingResult.kerfLength.intValue();
            } else {
               partX += nestingResult.kerfLength / 2;
            }

            partL = NC1Parser.getAssembleRealLength(assemble.nc1Path);
            pncInfo.append("PART X").append(partX).append(" L").append(partL);
            partX += partL + nestingResult.kerfLength / 2;
            List<String> lines = parse(assemble.artifactSerialNumber, assemble.nc1Path);
            pncInfo.append("\r\n").append(String.join("\r\n", lines)).append("\r\n");
         }
      } catch (Exception e) {
         e.printStackTrace();
      }

      String filepath = outputDirectoryPath + nestingResult.serialNumber + ".pnc";
      File file = new File(filepath);
      if (file.exists()) {
         Preconditions.checkArgument(file.delete(), "文件已存在，磁盘文件清理失败");
      }

      OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(file), "GB2312");
      out.write(pncInfo.toString());
      out.close();
      nestingResult.setFilepathPNC(filepath);
      System.out.println("\r\n#######################################");
      System.out.println("套料长度：" + nestingResult.nestingLength);
      System.out.println("母材长度：" + nestingResult.baseMetalLength);
      nestingResult.assembleList.forEach(a -> System.out.println(a.toString()));
      System.out.println("PNC文件：" + filepath);
      System.out.println("#######################################\r\n");
   }

   public static void generateByList(List<ProfileNestingResult> list, String outputDirectoryPath) {
      list.forEach(res -> {
         try {
            generate(res, outputDirectoryPath);
         } catch (IOException e) {
            e.printStackTrace();
         }
      });
   }

   public static List<String> parse(String artifactSerNumber, String filePath) throws Exception {
      String fileCharset = FileUtil.charset(filePath);
      List<String> lines = Files.readAllLines(Paths.get(filePath), Charset.forName(fileCharset));
      Pattern pattern = Pattern.compile("[\\w-]+(?=(\\.nc1))");
      Matcher matcher = pattern.matcher(lines.get(1));
      if (matcher.find()) {
         String assembleSerNumber = matcher.group();

         for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            if (lines.get(i).contains(assembleSerNumber)) {
               lines.set(i, line.replaceAll(assembleSerNumber, artifactSerNumber));
            }
         }

         return lines;
      } else {
         throw new Exception("nc1文件解析失败");
      }
   }
}
