package com.hzchum.scim.mes.building.core.biz.impl.utils;

import org.kabeja.dxf.helpers.Point;

class IsRectangle {
   public static double distance(Point p1, Point p2) {
      return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2.0) + Math.pow(p2.getY() - p1.getY(), 2.0));
   }

   public static double slope(Point p1, Point p2) {
      return p2.getX() - p1.getX() == 0.0 ? Double.MAX_VALUE : (p2.getY() - p1.getY()) / (p2.getX() - p1.getX());
   }

   public static boolean isAlmostEqual(double a, double b, double tolerance) {
      return Math.abs(a - b) <= tolerance;
   }

   private static boolean isWithinTolerance(String name, Point p1, Point p2, double tolerance, boolean compareX) {
      boolean isWithin = true;
      double diff = 0.0;
      if (compareX) {
         diff = Math.abs(p1.getX() - p2.getX());
      } else {
         diff = Math.abs(p1.getY() - p2.getY());
      }

      return diff <= tolerance;
   }

   public static boolean arePointsWithinDynamicTolerance(Point a, Point b, Point c, Point d, double tolerance) {
      boolean startPointCompareX = Math.abs(a.getX() - b.getX()) < Math.abs(a.getY() - b.getY());
      return isWithinTolerance("AB", a, b, tolerance, startPointCompareX)
         && isWithinTolerance("BC", b, c, tolerance, !startPointCompareX)
         && isWithinTolerance("CD", c, d, tolerance, startPointCompareX)
         && isWithinTolerance("DA", d, a, tolerance, !startPointCompareX);
   }

   public static boolean isRectangle(Point a, Point b, Point c, Point d) {
      double ab = distance(a, b);
      double bc = distance(b, c);
      double cd = distance(c, d);
      double da = distance(d, a);
      double ac = distance(a, c);
      double bd = distance(b, d);
      double slopeAB = slope(a, b);
      double slopeBC = slope(b, c);
      double slopeCD = slope(c, d);
      double slopeDA = slope(d, a);
      return ab == cd
         && bc == da
         && ac == bd
         && (slopeAB * slopeBC == -1.0 || slopeAB == Double.MAX_VALUE && slopeBC == 0.0 || slopeAB == 0.0 && slopeBC == Double.MAX_VALUE)
         && (slopeBC * slopeCD == -1.0 || slopeBC == Double.MAX_VALUE && slopeCD == 0.0 || slopeBC == 0.0 && slopeCD == Double.MAX_VALUE)
         && (slopeCD * slopeDA == -1.0 || slopeCD == Double.MAX_VALUE && slopeDA == 0.0 || slopeCD == 0.0 && slopeDA == Double.MAX_VALUE)
         && (slopeDA * slopeAB == -1.0 || slopeDA == Double.MAX_VALUE && slopeAB == 0.0 || slopeDA == 0.0 && slopeAB == Double.MAX_VALUE);
   }

   public static boolean isRectangle(Point a, Point b, Point c, Point d, double tolerance) {
      double ab = distance(a, b);
      double bc = distance(b, c);
      double cd = distance(c, d);
      double da = distance(d, a);
      return isAlmostEqual(ab, cd, tolerance) && isAlmostEqual(bc, da, tolerance) && arePointsWithinDynamicTolerance(a, b, c, d, tolerance);
   }
}
