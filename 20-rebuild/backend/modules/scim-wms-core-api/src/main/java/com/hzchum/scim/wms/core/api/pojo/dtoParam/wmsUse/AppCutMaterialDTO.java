package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.math.BigDecimal;

public class AppCutMaterialDTO {
   private String specification;
   private BigDecimal thickness;
   private BigDecimal length;
   private BigDecimal width;
   private BigDecimal quantity;
   private String workshopName;
   private String warehouseName;

   public static AppCutMaterialDTO.AppCutMaterialDTOBuilder builder() {
      return new AppCutMaterialDTO.AppCutMaterialDTOBuilder();
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public String getWarehouseName() {
      return this.warehouseName;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
   }

   public void setWarehouseName(final String warehouseName) {
      this.warehouseName = warehouseName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AppCutMaterialDTO)) {
         return false;
      }

      AppCutMaterialDTO other = (AppCutMaterialDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$specification = this.getSpecification();
      Object other$specification = other.getSpecification();
      if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
         Object this$thickness = this.getThickness();
         Object other$thickness = other.getThickness();
         if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
            Object this$length = this.getLength();
            Object other$length = other.getLength();
            if (this$length == null ? other$length == null : this$length.equals(other$length)) {
               Object this$width = this.getWidth();
               Object other$width = other.getWidth();
               if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$workshopName = this.getWorkshopName();
                     Object other$workshopName = other.getWorkshopName();
                     if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
                        Object this$warehouseName = this.getWarehouseName();
                        Object other$warehouseName = other.getWarehouseName();
                        return this$warehouseName == null ? other$warehouseName == null : this$warehouseName.equals(other$warehouseName);
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
      return other instanceof AppCutMaterialDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $warehouseName = this.getWarehouseName();
      return result * 59 + ($warehouseName == null ? 43 : $warehouseName.hashCode());
   }

   @Override
   public String toString() {
      return "AppCutMaterialDTO(specification="
         + this.getSpecification()
         + ", thickness="
         + this.getThickness()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", quantity="
         + this.getQuantity()
         + ", workshopName="
         + this.getWorkshopName()
         + ", warehouseName="
         + this.getWarehouseName()
         + ")";
   }

   public AppCutMaterialDTO(
      final String specification,
      final BigDecimal thickness,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal quantity,
      final String workshopName,
      final String warehouseName
   ) {
      this.specification = specification;
      this.thickness = thickness;
      this.length = length;
      this.width = width;
      this.quantity = quantity;
      this.workshopName = workshopName;
      this.warehouseName = warehouseName;
   }

   public AppCutMaterialDTO() {
   }

   public static class AppCutMaterialDTOBuilder {
      private String specification;
      private BigDecimal thickness;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal quantity;
      private String workshopName;
      private String warehouseName;

      AppCutMaterialDTOBuilder() {
      }

      public AppCutMaterialDTO.AppCutMaterialDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public AppCutMaterialDTO.AppCutMaterialDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public AppCutMaterialDTO.AppCutMaterialDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public AppCutMaterialDTO.AppCutMaterialDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public AppCutMaterialDTO.AppCutMaterialDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public AppCutMaterialDTO.AppCutMaterialDTOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      public AppCutMaterialDTO.AppCutMaterialDTOBuilder warehouseName(final String warehouseName) {
         this.warehouseName = warehouseName;
         return this;
      }

      public AppCutMaterialDTO build() {
         return new AppCutMaterialDTO(this.specification, this.thickness, this.length, this.width, this.quantity, this.workshopName, this.warehouseName);
      }

      @Override
      public String toString() {
         return "AppCutMaterialDTO.AppCutMaterialDTOBuilder(specification="
            + this.specification
            + ", thickness="
            + this.thickness
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", quantity="
            + this.quantity
            + ", workshopName="
            + this.workshopName
            + ", warehouseName="
            + this.warehouseName
            + ")";
      }
   }
}
