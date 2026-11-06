package com.hzchum.scim.mes.building.core.api.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GeneratePlateDXF {
   static final String FIGURE_TYPE = "0";
   static final String FIGURE_NAME = "2";
   static final String LAYER_NAME = "8";
   static final String LINE_TYPE_NAME = "6";
   static final String COLOR_NUMBER = "62";
   static final String POINT_X = "10";
   static final String POINT_Y = "20";
   static final String POINT_Z = "30";
   static final String FOLLOWED_FIGURE_TYPE = "66";
   static final String LAYER_NAME_VAL = "DHH-LAYER";

   public static void generate(Plate plate, String outputDirectoryPath) throws IOException {
      List<String> content = new ArrayList<>();
      content.add("0");
      content.add("SECTION");
      content.add("2");
      content.add("ENTITIES");
      content.add("0");
      content.add("POLYLINE");
      content.add("8");
      content.add("DHH-LAYER");
      content.add("6");
      content.add("CONTINUOUS");
      content.add("62");
      content.add("7");
      content.add("66");
      content.add("1");
      content.add("10");
      content.add("0");
      content.add("20");
      content.add("0");
      content.add("30");
      content.add("0");
      content.add("70");
      content.add("1");
      String height = String.format("%.3f", plate.getLength());
      String width = String.format("%.3f", plate.getWidth());
      List<String[]> pointList = new ArrayList<>();
      pointList.add(new String[]{"0.000", "0.000", "0.000"});
      pointList.add(new String[]{width, "0.000", "0.000"});
      pointList.add(new String[]{width, height, "0.000"});
      pointList.add(new String[]{"0.000", height, "0.000"});
      pointList.forEach(point -> {
         content.add("0");
         content.add("VERTEX");
         content.add("8");
         content.add("DHH-LAYER");
         content.add("10");
         content.add(point[0]);
         content.add("20");
         content.add(point[1]);
         content.add("30");
         content.add(point[2]);
         content.add("42");
         content.add("0");
      });
      content.add("0");
      content.add("SEQEND");
      content.add("0");
      content.add("ENDSEC");
      content.add("0");
      content.add("EOF");
      String outPath = outputDirectoryPath + plate.name + ".dxf";
      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outPath));
      bufferedWriter.write(String.join("\r\n", content));
      bufferedWriter.close();
   }

   public static void main(String[] args) throws IOException {
      Plate plate = new Plate(1L, "HL1-6-YB", 200.0, 100.0);
      generate(plate, "D:\\泡菜");
   }
}
