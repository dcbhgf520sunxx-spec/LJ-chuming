package com.hzchum.scim.wms.core.utils;

import java.text.DecimalFormat;
import java.util.List;
import org.kabeja.dxf.DXFVertex;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Polygon;

class DiagramForImport {
   private DiagramForImportEnum type;
   private double area;
   private List<DXFVertex> vertexes;
   private Polygon polygon;
   private Coordinate[] coordinates;

   public DiagramForImport(DiagramForImportEnum type, List<DXFVertex> vertexes) throws Exception {
      this.type = type;
      this.vertexes = vertexes;
      this.polygon = this.getPolygon(this.vertexes);
      if (this.polygon != null) {
         this.area = this.polygon.getArea();
      } else {
         throw new Exception("错误的图形");
      }
   }

   private Polygon getPolygon(List<DXFVertex> vertexes) {
      Coordinate[] vertices = vertexes.stream().map(vertex -> new Coordinate(vertex.getX(), vertex.getY())).toArray(Coordinate[]::new);
      double[] curvatures = vertexes.stream().mapToDouble(DXFVertex::getBulge).toArray();
      return PolygonWithArcsUtil.createPolygonWithArcs(vertices, curvatures, 0.1);
   }

   public DiagramForImportEnum getType() {
      return this.type;
   }

   public double getArea() {
      return this.area;
   }

   public Polygon getPolygon() {
      return this.polygon;
   }

   @Override
   public String toString() {
      return "类型：" + this.type + "   面积：" + new DecimalFormat("#.####").format(this.area / 1000000.0) + "㎡   顶点数量：" + this.vertexes.size();
   }
}
