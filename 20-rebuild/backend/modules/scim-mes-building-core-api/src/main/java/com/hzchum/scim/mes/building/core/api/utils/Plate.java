package com.hzchum.scim.mes.building.core.api.utils;

public class Plate {
   public Long id;
   public String name;
   public double width;
   public double length;

   public static Plate.PlateBuilder builder() {
      return new Plate.PlateBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public double getWidth() {
      return this.width;
   }

   public double getLength() {
      return this.length;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setWidth(final double width) {
      this.width = width;
   }

   public void setLength(final double length) {
      this.length = length;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof Plate)) {
         return false;
      } else {
         Plate other = (Plate)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (Double.compare(this.getWidth(), other.getWidth()) != 0) {
            return false;
         } else if (Double.compare(this.getLength(), other.getLength()) != 0) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               return this$name == null ? other$name == null : this$name.equals(other$name);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof Plate;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $width = Double.doubleToLongBits(this.getWidth());
      result = result * 59 + (int)($width >>> 32 ^ $width);
      long $length = Double.doubleToLongBits(this.getLength());
      result = result * 59 + (int)($length >>> 32 ^ $length);
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "Plate(id=" + this.getId() + ", name=" + this.getName() + ", width=" + this.getWidth() + ", length=" + this.getLength() + ")";
   }

   public Plate(final Long id, final String name, final double width, final double length) {
      this.id = id;
      this.name = name;
      this.width = width;
      this.length = length;
   }

   public Plate() {
   }

   public static class PlateBuilder {
      private Long id;
      private String name;
      private double width;
      private double length;

      PlateBuilder() {
      }

      public Plate.PlateBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public Plate.PlateBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public Plate.PlateBuilder width(final double width) {
         this.width = width;
         return this;
      }

      public Plate.PlateBuilder length(final double length) {
         this.length = length;
         return this;
      }

      public Plate build() {
         return new Plate(this.id, this.name, this.width, this.length);
      }

      @Override
      public String toString() {
         return "Plate.PlateBuilder(id=" + this.id + ", name=" + this.name + ", width=" + this.width + ", length=" + this.length + ")";
      }
   }
}
