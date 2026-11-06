package com.hzchum.scim.mes.building.core.api.pojo._dto.nesting;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "MachinePartNestingPdfDTO", description = "车间班组对象")
public class AbnormalInfoListDTO {
   private String area;
   private String height;
   private String name;
   private String thumbnail;
   private String width;
   private int plate_shape;

   public static AbnormalInfoListDTO.AbnormalInfoListDTOBuilder builder() {
      return new AbnormalInfoListDTO.AbnormalInfoListDTOBuilder();
   }

   public AbnormalInfoListDTO(final String area, final String height, final String name, final String thumbnail, final String width, final int plate_shape) {
      this.area = area;
      this.height = height;
      this.name = name;
      this.thumbnail = thumbnail;
      this.width = width;
      this.plate_shape = plate_shape;
   }

   public AbnormalInfoListDTO() {
   }

   public String getArea() {
      return this.area;
   }

   public String getHeight() {
      return this.height;
   }

   public String getName() {
      return this.name;
   }

   public String getThumbnail() {
      return this.thumbnail;
   }

   public String getWidth() {
      return this.width;
   }

   public int getPlate_shape() {
      return this.plate_shape;
   }

   public AbnormalInfoListDTO setArea(final String area) {
      this.area = area;
      return this;
   }

   public AbnormalInfoListDTO setHeight(final String height) {
      this.height = height;
      return this;
   }

   public AbnormalInfoListDTO setName(final String name) {
      this.name = name;
      return this;
   }

   public AbnormalInfoListDTO setThumbnail(final String thumbnail) {
      this.thumbnail = thumbnail;
      return this;
   }

   public AbnormalInfoListDTO setWidth(final String width) {
      this.width = width;
      return this;
   }

   public AbnormalInfoListDTO setPlate_shape(final int plate_shape) {
      this.plate_shape = plate_shape;
      return this;
   }

   @Override
   public String toString() {
      return "AbnormalInfoListDTO(area="
         + this.getArea()
         + ", height="
         + this.getHeight()
         + ", name="
         + this.getName()
         + ", thumbnail="
         + this.getThumbnail()
         + ", width="
         + this.getWidth()
         + ", plate_shape="
         + this.getPlate_shape()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AbnormalInfoListDTO)) {
         return false;
      }

      AbnormalInfoListDTO other = (AbnormalInfoListDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.getPlate_shape() != other.getPlate_shape()) {
         return false;
      }

      Object this$area = this.getArea();
      Object other$area = other.getArea();
      if (this$area == null ? other$area == null : this$area.equals(other$area)) {
         Object this$height = this.getHeight();
         Object other$height = other.getHeight();
         if (this$height == null ? other$height == null : this$height.equals(other$height)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$thumbnail = this.getThumbnail();
               Object other$thumbnail = other.getThumbnail();
               if (this$thumbnail == null ? other$thumbnail == null : this$thumbnail.equals(other$thumbnail)) {
                  Object this$width = this.getWidth();
                  Object other$width = other.getWidth();
                  return this$width == null ? other$width == null : this$width.equals(other$width);
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
      return other instanceof AbnormalInfoListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getPlate_shape();
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $height = this.getHeight();
      result = result * 59 + ($height == null ? 43 : $height.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $thumbnail = this.getThumbnail();
      result = result * 59 + ($thumbnail == null ? 43 : $thumbnail.hashCode());
      Object $width = this.getWidth();
      return result * 59 + ($width == null ? 43 : $width.hashCode());
   }

   public static class AbnormalInfoListDTOBuilder {
      private String area;
      private String height;
      private String name;
      private String thumbnail;
      private String width;
      private int plate_shape;

      AbnormalInfoListDTOBuilder() {
      }

      public AbnormalInfoListDTO.AbnormalInfoListDTOBuilder area(final String area) {
         this.area = area;
         return this;
      }

      public AbnormalInfoListDTO.AbnormalInfoListDTOBuilder height(final String height) {
         this.height = height;
         return this;
      }

      public AbnormalInfoListDTO.AbnormalInfoListDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public AbnormalInfoListDTO.AbnormalInfoListDTOBuilder thumbnail(final String thumbnail) {
         this.thumbnail = thumbnail;
         return this;
      }

      public AbnormalInfoListDTO.AbnormalInfoListDTOBuilder width(final String width) {
         this.width = width;
         return this;
      }

      public AbnormalInfoListDTO.AbnormalInfoListDTOBuilder plate_shape(final int plate_shape) {
         this.plate_shape = plate_shape;
         return this;
      }

      public AbnormalInfoListDTO build() {
         return new AbnormalInfoListDTO(this.area, this.height, this.name, this.thumbnail, this.width, this.plate_shape);
      }

      @Override
      public String toString() {
         return "AbnormalInfoListDTO.AbnormalInfoListDTOBuilder(area="
            + this.area
            + ", height="
            + this.height
            + ", name="
            + this.name
            + ", thumbnail="
            + this.thumbnail
            + ", width="
            + this.width
            + ", plate_shape="
            + this.plate_shape
            + ")";
      }
   }
}
