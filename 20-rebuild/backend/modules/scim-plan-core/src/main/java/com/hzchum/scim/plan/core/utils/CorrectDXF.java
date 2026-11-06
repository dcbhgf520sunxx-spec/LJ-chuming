package com.hzchum.scim.plan.core.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.kabeja.dxf.DXFBlock;
import org.kabeja.dxf.DXFCircle;
import org.kabeja.dxf.DXFDocument;
import org.kabeja.dxf.DXFEntity;
import org.kabeja.dxf.DXFInsert;
import org.kabeja.dxf.DXFLayer;
import org.kabeja.dxf.DXFPolyline;
import org.kabeja.dxf.DXFVertex;
import org.kabeja.dxf.helpers.Point;
import org.kabeja.parser.ParseException;
import org.kabeja.parser.Parser;
import org.kabeja.parser.ParserBuilder;
import org.locationtech.jts.geom.Polygon;

public class CorrectDXF {
   public static void main(String[] args) {
      String path = "E:\\泡菜\\Documents\\模型文件\\DXF\\柬埔寨2#厂房-模型";
      File[] fs = readFiles(path);
      if (fs != null) {
         for (File f : fs) {
            try {
               resolverDXFForImport(f);
            } catch (Exception e) {
               System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
               System.out.println(f.getName());
               System.out.println("报错：" + e.getMessage());
               System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            }
         }
      }
   }

   public static void resolverDXFForImport(File file) throws Exception {
      if (!file.isFile()) {
         throw new Exception(file.getName() + "不是文件类型");
      }

      List<DiagramForImport> diagramList = new ArrayList<>();
      DXFDocument doc = getDXFDoc(file);
      Iterator it = doc.getDXFLayerIterator();
      if (!it.hasNext()) {
         throw new Exception(file.getName() + "DXF中没有图层（即不存在图形）");
      }

      while (it.hasNext()) {
         DXFLayer layer = (DXFLayer)it.next();
         boolean boolInsert = layer.hasDXFEntities("INSERT");
         DXFLayer newDXFLayer;
         if (boolInsert) {
            newDXFLayer = getNewLayerByInsert(doc, layer);
         } else {
            newDXFLayer = layer;
         }

         List<DiagramForImport> circleList = getDiagramByCircleEntity(newDXFLayer);
         if (circleList != null) {
            diagramList.addAll(circleList);
         }

         List<DiagramForImport> polygonList = getDiagramByPolyline(newDXFLayer, null, "POLYLINE");
         if (polygonList != null) {
            diagramList.addAll(polygonList);
         }

         List<DiagramForImport> polygonList2 = getDiagramByPolyline(newDXFLayer, null, "LWPOLYLINE");
         if (polygonList2 != null) {
            diagramList.addAll(polygonList2);
         }
      }

      JudgeDiagramCorrectForPart(file.getName(), diagramList);
   }

   public static DXFLayer getNewLayerByInsert(DXFDocument doc, DXFLayer layer) {
      List<DXFInsert> insertList = layer.getDXFEntities("INSERT");
      DXFLayer newLayer = new DXFLayer();
      insertList.forEach(dxfInsert -> {
         DXFBlock dxfBlock = doc.getDXFBlock(dxfInsert.getBlockID());
         Iterator dxfEntitiesIterator = dxfBlock.getDXFEntitiesIterator();

         while (dxfEntitiesIterator.hasNext()) {
            DXFEntity entity = (DXFEntity)dxfEntitiesIterator.next();
            newLayer.addDXFEntity(entity);
         }
      });
      Iterator dxfEntityTypeIterator = layer.getDXFEntityTypeIterator();

      while (dxfEntityTypeIterator.hasNext()) {
         String entityName = (String)dxfEntityTypeIterator.next();
         if (!"INSERT".equals(entityName)) {
            List<DXFEntity> dxfEntities = layer.getDXFEntities(entityName);
            dxfEntities.forEach(entity -> newLayer.addDXFEntity(entity));
         }
      }

      return newLayer;
   }

   public static void JudgeDiagramCorrectForPart(String fileName, List<DiagramForImport> diagramList) throws Exception {
      if (diagramList.isEmpty()) {
         throw new Exception(fileName + "图形数量为0");
      }

      if (diagramList.size() == 2) {
         Polygon d1 = diagramList.get(0).getPolygon();
         Polygon d2 = diagramList.get(1).getPolygon();
         if (!d1.contains(d2) && !d1.within(d2)) {
            throw new Exception(fileName + "零件图形错误，存在2个图形，但它们不为包含关系");
         }
      }

      if (diagramList.size() > 2) {
         double maxArea = diagramList.stream().mapToDouble(DiagramForImport::getArea).max().getAsDouble();
         List<DiagramForImport> maxDiagramList = diagramList.stream().filter(d -> d.getArea() == maxArea).collect(Collectors.toList());
         if (maxDiagramList.size() != 1) {
            throw new Exception(fileName + "零件图形错误，面积最大的图形不存在或存在多个");
         }

         DiagramForImport maxDiagram = maxDiagramList.get(0);
         List<DiagramForImport> otherDiagramList = diagramList.stream().filter(d -> d.getArea() != maxArea).collect(Collectors.toList());
         boolean allContains = otherDiagramList.stream().anyMatch(d -> maxDiagram.getPolygon().contains(d.getPolygon()));
         if (!allContains) {
            throw new Exception(fileName + "零件图形错误");
         }

         for (int i = 0; i < otherDiagramList.size() - 1; i++) {
            Polygon pi = otherDiagramList.get(i).getPolygon();

            for (int j = i + 1; j < otherDiagramList.size(); j++) {
               Polygon pj = otherDiagramList.get(j).getPolygon();
               if (pi.covers(pj) || pi.coveredBy(pj) || pi.overlaps(pj)) {
                  throw new Exception(fileName + "零件图形错误, 零件孔存在交叉（重叠、包含等）情况");
               }
            }
         }
      }

      System.out.println(fileName);
      System.out.println("孔：" + (diagramList.size() - 1));
      diagramList.forEach(d -> System.out.println(d.toString()));
   }

   public static DXFDocument getDXFDoc(File file) throws IOException, ParseException {
      Parser dxfParser = ParserBuilder.createDefaultParser();
      dxfParser.parse(Files.newInputStream(file.toPath()), "UTF-8");
      return dxfParser.getDocument();
   }

   public static List<DiagramForImport> getDiagramByCircleEntity(DXFLayer layer) {
      List<DXFCircle> circleList = layer.getDXFEntities("CIRCLE");
      return circleList == null ? null : circleList.stream().filter(c -> c.getRadius() > 0.0).map(c -> {
         List<DXFVertex> vs = new ArrayList<>();
         double x = c.getCenterPoint().getX();
         double y = c.getCenterPoint().getY();
         double z = c.getCenterPoint().getZ();
         DXFVertex v1 = new DXFVertex(new Point(x - c.getRadius(), y, z));
         DXFVertex v2 = new DXFVertex(new Point(x + c.getRadius(), y, z));
         vs.add(v1);
         vs.add(v2);
         vs.forEach(v -> v.setBulge(1.0));

         try {
            return new DiagramForImport(DiagramForImportEnum.CIRCLE, vs);
         } catch (Exception e) {
            throw new RuntimeException(e);
         }
      }).collect(Collectors.toList());
   }

   public static <T extends DXFPolyline> List<DiagramForImport> getDiagramByPolyline(DXFLayer layer, Double tolerance, String EntityName) throws Exception {
      List<T> polylineList = layer.getDXFEntities(EntityName);
      if (polylineList != null && !polylineList.isEmpty()) {
         List<DiagramForImport> ds = new ArrayList<>();

         for (T polyline : polylineList) {
            if (polyline.getFlags() != 1) {
               throw new Exception("存在未闭合的图形");
            }

            Iterator vertexIterator = polyline.getVertexIterator();
            List<DXFVertex> vertexList = new ArrayList<>();

            while (vertexIterator.hasNext()) {
               DXFVertex vertex = (DXFVertex)vertexIterator.next();
               vertexList.add(vertex);
            }

            DiagramForImport currentDS = null;
            switch (vertexList.size()) {
               case 1:
                  return null;
               case 2:
                  currentDS = getCurveDiagramByVertex(vertexList);
                  break;
               default:
                  currentDS = getPolygonByVertex(vertexList);
            }

            if (currentDS != null) {
               ds.add(currentDS);
            }
         }

         return ds;
      } else {
         return null;
      }
   }

   public static DiagramForImport getCurveDiagramByVertex(List<DXFVertex> vertexList) throws Exception {
      if (vertexList.size() != 2) {
         return null;
      }

      DXFVertex v1 = vertexList.get(0);
      DXFVertex v2 = vertexList.get(1);
      return v1 != null
            && v1.getPoint() != null
            && v2 != null
            && v2.getPoint() != null
            && (v1.getBulge() != 0.0 || v2.getBulge() != 0.0)
            && (v1.getX() != v2.getX() || v1.getY() != v2.getY())
         ? new DiagramForImport(DiagramForImportEnum.CIRCLE, vertexList)
         : null;
   }

   public static DiagramForImport getPolygonByVertex(List<DXFVertex> vertexList) throws Exception {
      return new DiagramForImport(DiagramForImportEnum.POLYGON, vertexList);
   }

   public static File[] readFiles(String path) {
      File file = new File(path);
      if (file.isDirectory()) {
         return file.listFiles();
      } else {
         return file.isFile() ? new File[]{file} : null;
      }
   }

   public static Boolean verifyDXFHeader(File file) throws IOException {
      String magicNumberCode = getFileHeaderHexByInputStream(Files.newInputStream(file.toPath()));
      String dxfHeader = "300D0A53454354494F4E0D0A";
      return StringUtils.isNotBlank(magicNumberCode)
         && (magicNumberCode.toUpperCase().startsWith("300D0A53454354494F4E0D0A") || magicNumberCode.toUpperCase().startsWith("300D0A53454354494F4E0D0A", 4));
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
         for (byte value : b) {
            int v = value & 255;
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
}
