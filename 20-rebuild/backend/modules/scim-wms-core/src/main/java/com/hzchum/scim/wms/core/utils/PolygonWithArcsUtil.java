package com.hzchum.scim.wms.core.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Polygon;
import org.locationtech.jts.math.Vector2D;

public class PolygonWithArcsUtil {
   public static Polygon createPolygonWithArcs(Coordinate[] coordinates, double[] curvatures, double minSpacing) {
      List<Coordinate> polygonPoints = new ArrayList<>();
      GeometryFactory geometryFactory = new GeometryFactory();

      for (int i = 0; i < coordinates.length; i++) {
         Coordinate start = coordinates[i];
         Coordinate end = coordinates[(i + 1) % coordinates.length];
         double curvature = curvatures[i];
         Coordinate[] coordinateList = generateArcOrLinePoints(start, end, curvature, minSpacing);
         polygonPoints.addAll(Arrays.asList(coordinateList));
      }

      polygonPoints.add(polygonPoints.get(0));
      return geometryFactory.createPolygon(polygonPoints.toArray(new Coordinate[0]));
   }

   private static Coordinate[] generateArcOrLinePoints(Coordinate start, Coordinate end, double curvature, double minSpacing) {
      if (curvature == 0.0) {
         return new Coordinate[]{start, end};
      }

      double height = start.distance(end) / 2.0 * curvature;
      return height == 0.0 ? new Coordinate[0] : generateArcPoints(start, end, height, minSpacing);
   }

   public static Coordinate[] generateArcPoints(Coordinate start, Coordinate end, double height, double minSpacing) {
      double L = start.distance(end);
      Coordinate midPoint = new Coordinate((start.x + end.x) / 2.0, (start.y + end.y) / 2.0);
      double R = L * L / (8.0 * Math.abs(height)) + Math.abs(height) / 2.0;
      int directionFactor = height > 0.0 ? 1 : -1;
      Vector2D direction = new Vector2D(start, end).rotateByQuarterCircle(directionFactor);
      direction = direction.normalize();
      double d = Math.sqrt(R * R - L / 2.0 * (L / 2.0));
      Coordinate center = new Coordinate(midPoint.x + d * direction.getX(), midPoint.y + d * direction.getY());
      double startAngle = Math.atan2(start.y - center.y, start.x - center.x);
      double endAngle = Math.atan2(end.y - center.y, end.x - center.x);
      if (height < 0.0 && startAngle < endAngle) {
         startAngle += Math.PI * 2;
      } else if (height > 0.0 && endAngle < startAngle) {
         endAngle += Math.PI * 2;
      }

      double arcAngle = endAngle - startAngle;
      double arcLength = Math.abs(R * arcAngle);
      int numPoints = Math.max((int)Math.ceil(arcLength / minSpacing), 2);
      double deltaAngle = arcAngle / (numPoints - 1);
      Coordinate[] points = new Coordinate[numPoints];

      for (int i = 0; i < numPoints; i++) {
         double angle = startAngle + i * deltaAngle;
         double x = center.x + R * Math.cos(angle);
         double y = center.y + R * Math.sin(angle);
         points[i] = new Coordinate(x, y);
      }

      return points;
   }

   public static void main(String[] args) {
      Coordinate[] vertices = new Coordinate[]{new Coordinate(0.0, 0.0), new Coordinate(0.0, 4.0)};
      double[] curvatures = new double[]{-1.0, -1.0};
      Polygon polygon = createPolygonWithArcs(vertices, curvatures, 0.1);
      System.out.println("Polygon with Arcs: " + polygon);
      System.out.println("Polygon with Arcs: " + polygon.getArea());
   }
}
