package com.hzchum.scim.plan.core.api.util;

import com.google.common.base.Preconditions;
import com.hzchum.scim.plan.core.api.pojo.dto.HoleRadiusDTO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.kabeja.batik.tools.SAXJPEGSerializer;
import org.kabeja.batik.tools.SAXPDFSerializer;
import org.kabeja.batik.tools.SAXPNGSerializer;
import org.kabeja.batik.tools.SAXTIFFSerializer;
import org.kabeja.dxf.DXFCircle;
import org.kabeja.dxf.DXFDocument;
import org.kabeja.dxf.DXFLayer;
import org.kabeja.dxf.DXFPolyline;
import org.kabeja.dxf.DXFVertex;
import org.kabeja.dxf.helpers.Point;
import org.kabeja.parser.Parser;
import org.kabeja.parser.ParserBuilder;
import org.kabeja.svg.SVGGenerator;
import org.kabeja.xml.SAXGenerator;
import org.kabeja.xml.SAXPrettyOutputter;
import org.kabeja.xml.SAXSerializer;

public class DxfUtils {
   public static void main(String[] args) {
      String s = "D:/dxf/1-L6-29.dxf";

      try {
         HoleRadiusDTO numberAndRadius = getNumberAndRadius(s);
         System.out.println("****************************");
         System.out.println("孔数:" + numberAndRadius.getHoleNumber());
         System.out.println("详情:" + numberAndRadius.getHoleRadiusMap());
         System.out.println("****************************");
         getPicture(s, 1, "D:/dxf/");
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public static HoleRadiusDTO getNumberAndRadius(String path) throws Exception {
      File f = new File(path);
      if (!f.isFile()) {
         Preconditions.checkArgument(false, f.getName() + "不是文件类型");
      }

      if (!verifyHeader(f)) {
         Preconditions.checkArgument(false, f.getName() + "不是dxf文件");
      }

      Parser dxfParser = ParserBuilder.createDefaultParser();
      FileInputStream fileInputStream = new FileInputStream(f);
      dxfParser.parse(fileInputStream, "UTF-8");
      DXFDocument doc = dxfParser.getDocument();
      Iterator<DXFLayer> it = doc.getDXFLayerIterator();
      int circleNumber = 0;
      int holeNumber = 0;
      Map<Double, Long> holeRadiusMap = new HashMap<>();
      boolean boolOnlyCircles = true;
      new HashMap();
      if (!it.hasNext()) {
         boolOnlyCircles = false;
      }

      while (it.hasNext()) {
         DXFLayer layer = it.next();
         List<DXFCircle> circleList = layer.getDXFEntities("CIRCLE");
         if (circleList != null) {
            circleNumber += circleList.size();
            Map<Double, Long> cn = circleList.stream().collect(Collectors.groupingBy(DXFCircle::getRadius, Collectors.counting()));
            cn.forEach((key, value) -> {
               Long var10000 = holeRadiusMap.merge(key, value, (v1x, v2x) -> v1x + v2x);
            });
         }

         List<DXFPolyline> polylineList = layer.getDXFEntities("POLYLINE");
         if (polylineList != null) {
            for (DXFPolyline polyline : polylineList) {
               if (polyline.getFlags() != 1) {
                  boolOnlyCircles = false;
               } else {
                  Iterator vertexIterator = polyline.getVertexIterator();
                  int counter = 0;
                  List<DXFVertex> vertexList = new ArrayList<>();

                  while (vertexIterator.hasNext() && counter++ < 2) {
                     DXFVertex vertex = (DXFVertex)vertexIterator.next();
                     vertexList.add(vertex);
                  }

                  if (counter == 2) {
                     DXFVertex v1 = vertexList.get(0);
                     DXFVertex v2 = vertexList.get(1);
                     if (v1 == null && v2 == null && v1.getBulge() != 1.0 && v2.getBulge() != 1.0) {
                        boolOnlyCircles = false;
                     } else {
                        Point v1Point = v1.getPoint();
                        Point v2Point = v2.getPoint();
                        v1Point.getX();
                        v2Point.getX();
                        double radius = 0.0;
                        BigDecimal bdRadius = null;
                        if (v1Point.getX() == v2Point.getX()) {
                           bdRadius = new BigDecimal(Math.abs((v1Point.getY() - v2Point.getY()) / 2.0));
                        }

                        if (v1Point.getY() == v2Point.getY()) {
                           bdRadius = new BigDecimal(Math.abs((v1Point.getX() - v2Point.getX()) / 2.0));
                        }

                        if (bdRadius == null) {
                           boolOnlyCircles = false;
                        } else {
                           radius = bdRadius.setScale(1, 4).doubleValue();
                           if (radius > 0.0) {
                              holeRadiusMap.put(radius, holeRadiusMap.containsKey(radius) ? holeRadiusMap.get(radius) + 1L : 1L);
                              circleNumber++;
                           }
                        }
                     }
                  } else {
                     boolOnlyCircles = false;
                  }
               }
            }
         }

         Iterator typeIterator = layer.getDXFEntityTypeIterator();

         while (boolOnlyCircles && typeIterator.hasNext()) {
            String keyName = (String)typeIterator.next();
            if (keyName != "CIRCLE" && keyName != "POLYLINE") {
               boolOnlyCircles = false;
            }
         }
      }

      holeNumber = circleNumber;
      if (circleNumber > 0 && boolOnlyCircles) {
         holeNumber--;
         Set<Double> radiusSet = holeRadiusMap.keySet();
         Double max = radiusSet.stream().max(Double::compare).get();
         Long maxValue = holeRadiusMap.get(max);
         if (maxValue != 1L) {
            throw new Exception("错误的图形，请检查后导入");
         }

         holeRadiusMap.remove(max);
      }

      Map<Double, Long> map = new HashMap<>();

      for (Double aDouble : holeRadiusMap.keySet()) {
         if (aDouble != 0.0) {
            map.put(aDouble, holeRadiusMap.get(aDouble));
         } else {
            holeNumber = (int)(holeNumber - holeRadiusMap.get(aDouble));
         }
      }

      fileInputStream.close();
      return HoleRadiusDTO.builder().holeNumber(holeNumber).holeRadiusMap(map).build();
   }

   public static HoleRadiusDTO getPicture(String filePath, Integer fileFormatType, String outDirectory) throws Exception {
      File file = new File(filePath);
      Preconditions.checkArgument(file.isFile(), file.getName() + "不是文件类型\n---------------------------------------");
      generatorImg(filePath, fileFormatType, outDirectory);
      return null;
   }

   public static void generatorImg(String filePath, Integer fileFormat, String outDirectory) throws Exception {
      Parser dxfParser = ParserBuilder.createDefaultParser();
      File file = new File(filePath);
      if (!checkDXF(file)) {
         System.out.println("filePath = " + filePath + ", fileFormat = " + fileFormat + ", outDirectory = " + outDirectory);
      } else {
         FileInputStream fileInputStream = new FileInputStream(file);
         dxfParser.parse(fileInputStream, "UTF-8");
         DXFDocument doc = dxfParser.getDocument();
         SAXGenerator generator = new SVGGenerator();
         Map<String, Object> outConfMap = new HashMap<>();
         SAXSerializer out;
         String fileSuffix;
         switch (fileFormat) {
            case 1:
               out = new SAXPrettyOutputter();
               fileSuffix = "svg";
               break;
            case 2:
               out = new SAXJPEGSerializer();
               fileSuffix = "jpg";
               break;
            case 4:
               out = new SAXPNGSerializer();
               fileSuffix = "png";
               break;
            case 8:
               out = new SAXPDFSerializer();
               fileSuffix = "pdf";
               break;
            case 16:
               out = new SAXTIFFSerializer();
               fileSuffix = "tiff";
               break;
            default:
               throw new Exception("请传入正确的文件格式");
         }

         outConfMap.put("margin", "10");
         outConfMap.put("stroke-width", 2.5);
         if (StringUtils.isBlank(outDirectory)) {
            outDirectory = filePath.split("\\.")[0];
         } else {
            outDirectory = outDirectory + "/" + file.getName().split("\\.")[0];
         }

         OutputStream outputStream = new FileOutputStream(outDirectory + "." + fileSuffix);
         out.setOutput(outputStream);
         generator.generate(doc, out, outConfMap);
         fileInputStream.close();
         outputStream.close();
      }
   }

   public static Boolean checkDXF(File file) throws FileNotFoundException {
      if (!file.isFile()) {
         System.out.println(file.getName() + "不是文件类型\n---------------------------------------");
         return false;
      } else if (!verifyHeader(file)) {
         System.out.println(file.getName() + "不是dxf文件\n---------------------------------------");
         return false;
      } else {
         return true;
      }
   }

   public static Boolean verifyHeader(File file) throws FileNotFoundException {
      return Boolean.TRUE;
   }

   public static String getFileHeaderHexByInputStream(InputStream inputStream) {
      byte[] b = new byte[28];

      try {
         inputStream.read(b, 0, 28);
      } catch (IOException e) {
         e.printStackTrace();
         return null;
      } finally {
         if (inputStream != null) {
            try {
               inputStream.close();
            } catch (IOException e) {
               e.printStackTrace();
            }
         }
      }

      return bytesToHexString(b);
   }

   private static final String bytesToHexString(byte[] b) {
      StringBuilder stringBuilder = new StringBuilder();
      if (b != null && b.length > 0) {
         for (int i = 0; i < b.length; i++) {
            int v = b[i] & 255;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
               stringBuilder.append(0);
            }

            stringBuilder.append(hv);
         }

         return stringBuilder.toString();
      } else {
         return null;
      }
   }

   enum ImgFormat {
      SVG,
      JPG,
      PNG,
      PDF,
      TIFF;
   }
}
