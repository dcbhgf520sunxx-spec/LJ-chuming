package com.hzchum.scim.mes.building.core.biz.impl.utils;

import java.util.List;
import org.kabeja.dxf.DXFVertex;
import org.kabeja.dxf.helpers.Point;

class Diagram {
   private DiagramEnum type;
   private double area;
   private List<DXFVertex> vertexes;

   public Diagram(DiagramEnum type, List<DXFVertex> vertexes) {
      this.type = type;
      this.vertexes = vertexes;
      switch (type) {
         case RECTANGLE:
         case POLYGON:
            this.area = calculatePolygonArea(vertexes);
            break;
         case CIRCLE:
            this.area = calculateCurveArea(vertexes);
      }
   }

   public DiagramEnum getType() {
      return this.type;
   }

   public double getArea() {
      return this.area;
   }

   @Override
   public String toString() {
      return "类型：" + this.type + "   面积：" + this.area + "   顶点数量：" + this.vertexes.size();
   }

   public static double calculatePolygonArea(List<DXFVertex> vertexes) {
      int n = vertexes.size();
      double area = 0.0;

      for (int i = 0; i < n - 1; i++) {
         DXFVertex v1 = vertexes.get(i);
         DXFVertex v2 = vertexes.get(i + 1);
         area += v1.getX() * v2.getY() - v1.getY() * v2.getX();
      }

      DXFVertex v1 = vertexes.get(0);
      DXFVertex vn = vertexes.get(n - 1);
      area += vn.getX() * v1.getY() - vn.getY() * v1.getX();
      return Math.abs(area) / 2.0;
   }

   public static double calculateCurveArea(List<DXFVertex> vertexes) {
      DXFVertex v1 = vertexes.get(0);
      DXFVertex v2 = vertexes.get(1);
      double d = distance(v1.getPoint(), v2.getPoint());
      double arcArea1 = calculateArcArea(d, v1.getBulge());
      double arcArea2 = calculateArcArea(d, v1.getBulge());
      return arcArea1 + arcArea2;
   }

   public static double distance(Point p1, Point p2) {
      return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2.0) + Math.pow(p2.getY() - p1.getY(), 2.0));
   }

   public static double calculateArcArea(double distance, double curvature) {
      if (curvature == 0.0) {
         return 0.0;
      }

      double radius = distance / (2.0 * curvature);
      double theta = 2.0 * Math.asin(distance / (2.0 * radius));
      return 0.5 * radius * radius * theta;
   }
}
