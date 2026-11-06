package com.hzchum.scim.mes.building.core.api.pojo._dto.nesting;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "套料报告单第二部分", description = "套料报告单第二部分")
public class PlateInfoNestingDTO {
   private int amount;
   private String area;
   private String extmax_x;
   private String extmax_y;
   private String gap;
   private String name;
   private String material;
   private String thickness;
   private double density;
   private String utilization;
   private String utilization_slab;
   private String utilization_nestedrec;
   private String utilization_nestedrec_slab;

   public static PlateInfoNestingDTO.PlateInfoNestingDTOBuilder builder() {
      return new PlateInfoNestingDTO.PlateInfoNestingDTOBuilder();
   }

   public PlateInfoNestingDTO(
      final int amount,
      final String area,
      final String extmax_x,
      final String extmax_y,
      final String gap,
      final String name,
      final String material,
      final String thickness,
      final double density,
      final String utilization,
      final String utilization_slab,
      final String utilization_nestedrec,
      final String utilization_nestedrec_slab
   ) {
      this.amount = amount;
      this.area = area;
      this.extmax_x = extmax_x;
      this.extmax_y = extmax_y;
      this.gap = gap;
      this.name = name;
      this.material = material;
      this.thickness = thickness;
      this.density = density;
      this.utilization = utilization;
      this.utilization_slab = utilization_slab;
      this.utilization_nestedrec = utilization_nestedrec;
      this.utilization_nestedrec_slab = utilization_nestedrec_slab;
   }

   public PlateInfoNestingDTO() {
   }

   public int getAmount() {
      return this.amount;
   }

   public String getArea() {
      return this.area;
   }

   public String getExtmax_x() {
      return this.extmax_x;
   }

   public String getExtmax_y() {
      return this.extmax_y;
   }

   public String getGap() {
      return this.gap;
   }

   public String getName() {
      return this.name;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getThickness() {
      return this.thickness;
   }

   public double getDensity() {
      return this.density;
   }

   public String getUtilization() {
      return this.utilization;
   }

   public String getUtilization_slab() {
      return this.utilization_slab;
   }

   public String getUtilization_nestedrec() {
      return this.utilization_nestedrec;
   }

   public String getUtilization_nestedrec_slab() {
      return this.utilization_nestedrec_slab;
   }

   public PlateInfoNestingDTO setAmount(final int amount) {
      this.amount = amount;
      return this;
   }

   public PlateInfoNestingDTO setArea(final String area) {
      this.area = area;
      return this;
   }

   public PlateInfoNestingDTO setExtmax_x(final String extmax_x) {
      this.extmax_x = extmax_x;
      return this;
   }

   public PlateInfoNestingDTO setExtmax_y(final String extmax_y) {
      this.extmax_y = extmax_y;
      return this;
   }

   public PlateInfoNestingDTO setGap(final String gap) {
      this.gap = gap;
      return this;
   }

   public PlateInfoNestingDTO setName(final String name) {
      this.name = name;
      return this;
   }

   public PlateInfoNestingDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   public PlateInfoNestingDTO setThickness(final String thickness) {
      this.thickness = thickness;
      return this;
   }

   public PlateInfoNestingDTO setDensity(final double density) {
      this.density = density;
      return this;
   }

   public PlateInfoNestingDTO setUtilization(final String utilization) {
      this.utilization = utilization;
      return this;
   }

   public PlateInfoNestingDTO setUtilization_slab(final String utilization_slab) {
      this.utilization_slab = utilization_slab;
      return this;
   }

   public PlateInfoNestingDTO setUtilization_nestedrec(final String utilization_nestedrec) {
      this.utilization_nestedrec = utilization_nestedrec;
      return this;
   }

   public PlateInfoNestingDTO setUtilization_nestedrec_slab(final String utilization_nestedrec_slab) {
      this.utilization_nestedrec_slab = utilization_nestedrec_slab;
      return this;
   }

   @Override
   public String toString() {
      return "PlateInfoNestingDTO(amount="
         + this.getAmount()
         + ", area="
         + this.getArea()
         + ", extmax_x="
         + this.getExtmax_x()
         + ", extmax_y="
         + this.getExtmax_y()
         + ", gap="
         + this.getGap()
         + ", name="
         + this.getName()
         + ", material="
         + this.getMaterial()
         + ", thickness="
         + this.getThickness()
         + ", density="
         + this.getDensity()
         + ", utilization="
         + this.getUtilization()
         + ", utilization_slab="
         + this.getUtilization_slab()
         + ", utilization_nestedrec="
         + this.getUtilization_nestedrec()
         + ", utilization_nestedrec_slab="
         + this.getUtilization_nestedrec_slab()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlateInfoNestingDTO)) {
         return false;
      }

      PlateInfoNestingDTO other = (PlateInfoNestingDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.getAmount() != other.getAmount()) {
         return false;
      }

      if (Double.compare(this.getDensity(), other.getDensity()) != 0) {
         return false;
      }

      Object this$area = this.getArea();
      Object other$area = other.getArea();
      if (this$area == null ? other$area == null : this$area.equals(other$area)) {
         Object this$extmax_x = this.getExtmax_x();
         Object other$extmax_x = other.getExtmax_x();
         if (this$extmax_x == null ? other$extmax_x == null : this$extmax_x.equals(other$extmax_x)) {
            Object this$extmax_y = this.getExtmax_y();
            Object other$extmax_y = other.getExtmax_y();
            if (this$extmax_y == null ? other$extmax_y == null : this$extmax_y.equals(other$extmax_y)) {
               Object this$gap = this.getGap();
               Object other$gap = other.getGap();
               if (this$gap == null ? other$gap == null : this$gap.equals(other$gap)) {
                  Object this$name = this.getName();
                  Object other$name = other.getName();
                  if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                     Object this$material = this.getMaterial();
                     Object other$material = other.getMaterial();
                     if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                        Object this$thickness = this.getThickness();
                        Object other$thickness = other.getThickness();
                        if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                           Object this$utilization = this.getUtilization();
                           Object other$utilization = other.getUtilization();
                           if (this$utilization == null ? other$utilization == null : this$utilization.equals(other$utilization)) {
                              Object this$utilization_slab = this.getUtilization_slab();
                              Object other$utilization_slab = other.getUtilization_slab();
                              if (this$utilization_slab == null ? other$utilization_slab == null : this$utilization_slab.equals(other$utilization_slab)) {
                                 Object this$utilization_nestedrec = this.getUtilization_nestedrec();
                                 Object other$utilization_nestedrec = other.getUtilization_nestedrec();
                                 if (this$utilization_nestedrec == null
                                    ? other$utilization_nestedrec == null
                                    : this$utilization_nestedrec.equals(other$utilization_nestedrec)) {
                                    Object this$utilization_nestedrec_slab = this.getUtilization_nestedrec_slab();
                                    Object other$utilization_nestedrec_slab = other.getUtilization_nestedrec_slab();
                                    return this$utilization_nestedrec_slab == null
                                       ? other$utilization_nestedrec_slab == null
                                       : this$utilization_nestedrec_slab.equals(other$utilization_nestedrec_slab);
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PlateInfoNestingDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getAmount();
      long $density = Double.doubleToLongBits(this.getDensity());
      result = result * 59 + (int)($density >>> 32 ^ $density);
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $extmax_x = this.getExtmax_x();
      result = result * 59 + ($extmax_x == null ? 43 : $extmax_x.hashCode());
      Object $extmax_y = this.getExtmax_y();
      result = result * 59 + ($extmax_y == null ? 43 : $extmax_y.hashCode());
      Object $gap = this.getGap();
      result = result * 59 + ($gap == null ? 43 : $gap.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $utilization = this.getUtilization();
      result = result * 59 + ($utilization == null ? 43 : $utilization.hashCode());
      Object $utilization_slab = this.getUtilization_slab();
      result = result * 59 + ($utilization_slab == null ? 43 : $utilization_slab.hashCode());
      Object $utilization_nestedrec = this.getUtilization_nestedrec();
      result = result * 59 + ($utilization_nestedrec == null ? 43 : $utilization_nestedrec.hashCode());
      Object $utilization_nestedrec_slab = this.getUtilization_nestedrec_slab();
      return result * 59 + ($utilization_nestedrec_slab == null ? 43 : $utilization_nestedrec_slab.hashCode());
   }

   public static class PlateInfoNestingDTOBuilder {
      private int amount;
      private String area;
      private String extmax_x;
      private String extmax_y;
      private String gap;
      private String name;
      private String material;
      private String thickness;
      private double density;
      private String utilization;
      private String utilization_slab;
      private String utilization_nestedrec;
      private String utilization_nestedrec_slab;

      PlateInfoNestingDTOBuilder() {
      }

      public PlateInfoNestingDTO.PlateInfoNestingDTOBuilder amount(final int amount) {
         this.amount = amount;
         return this;
      }

      public PlateInfoNestingDTO.PlateInfoNestingDTOBuilder area(final String area) {
         this.area = area;
         return this;
      }

      public PlateInfoNestingDTO.PlateInfoNestingDTOBuilder extmax_x(final String extmax_x) {
         this.extmax_x = extmax_x;
         return this;
      }

      public PlateInfoNestingDTO.PlateInfoNestingDTOBuilder extmax_y(final String extmax_y) {
         this.extmax_y = extmax_y;
         return this;
      }

      public PlateInfoNestingDTO.PlateInfoNestingDTOBuilder gap(final String gap) {
         this.gap = gap;
         return this;
      }

      public PlateInfoNestingDTO.PlateInfoNestingDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public PlateInfoNestingDTO.PlateInfoNestingDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public PlateInfoNestingDTO.PlateInfoNestingDTOBuilder thickness(final String thickness) {
         this.thickness = thickness;
         return this;
      }

      public PlateInfoNestingDTO.PlateInfoNestingDTOBuilder density(final double density) {
         this.density = density;
         return this;
      }

      public PlateInfoNestingDTO.PlateInfoNestingDTOBuilder utilization(final String utilization) {
         this.utilization = utilization;
         return this;
      }

      public PlateInfoNestingDTO.PlateInfoNestingDTOBuilder utilization_slab(final String utilization_slab) {
         this.utilization_slab = utilization_slab;
         return this;
      }

      public PlateInfoNestingDTO.PlateInfoNestingDTOBuilder utilization_nestedrec(final String utilization_nestedrec) {
         this.utilization_nestedrec = utilization_nestedrec;
         return this;
      }

      public PlateInfoNestingDTO.PlateInfoNestingDTOBuilder utilization_nestedrec_slab(final String utilization_nestedrec_slab) {
         this.utilization_nestedrec_slab = utilization_nestedrec_slab;
         return this;
      }

      public PlateInfoNestingDTO build() {
         return new PlateInfoNestingDTO(
            this.amount,
            this.area,
            this.extmax_x,
            this.extmax_y,
            this.gap,
            this.name,
            this.material,
            this.thickness,
            this.density,
            this.utilization,
            this.utilization_slab,
            this.utilization_nestedrec,
            this.utilization_nestedrec_slab
         );
      }

      @Override
      public String toString() {
         return "PlateInfoNestingDTO.PlateInfoNestingDTOBuilder(amount="
            + this.amount
            + ", area="
            + this.area
            + ", extmax_x="
            + this.extmax_x
            + ", extmax_y="
            + this.extmax_y
            + ", gap="
            + this.gap
            + ", name="
            + this.name
            + ", material="
            + this.material
            + ", thickness="
            + this.thickness
            + ", density="
            + this.density
            + ", utilization="
            + this.utilization
            + ", utilization_slab="
            + this.utilization_slab
            + ", utilization_nestedrec="
            + this.utilization_nestedrec
            + ", utilization_nestedrec_slab="
            + this.utilization_nestedrec_slab
            + ")";
      }
   }
}
