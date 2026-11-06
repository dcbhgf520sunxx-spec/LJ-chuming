package com.hzchum.scim.mes.building.core.api.pojo._dto.nesting;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "零件排产明细", description = "零件排产明细")
public class PlateDTO {
   private String guid;
   private String plate_name;
   private Double width;
   private Double height;

   public static PlateDTO.PlateDTOBuilder builder() {
      return new PlateDTO.PlateDTOBuilder();
   }

   public PlateDTO(final String guid, final String plate_name, final Double width, final Double height) {
      this.guid = guid;
      this.plate_name = plate_name;
      this.width = width;
      this.height = height;
   }

   public PlateDTO() {
   }

   public String getGuid() {
      return this.guid;
   }

   public String getPlate_name() {
      return this.plate_name;
   }

   public Double getWidth() {
      return this.width;
   }

   public Double getHeight() {
      return this.height;
   }

   public PlateDTO setGuid(final String guid) {
      this.guid = guid;
      return this;
   }

   public PlateDTO setPlate_name(final String plate_name) {
      this.plate_name = plate_name;
      return this;
   }

   public PlateDTO setWidth(final Double width) {
      this.width = width;
      return this;
   }

   public PlateDTO setHeight(final Double height) {
      this.height = height;
      return this;
   }

   @Override
   public String toString() {
      return "PlateDTO(guid=" + this.getGuid() + ", plate_name=" + this.getPlate_name() + ", width=" + this.getWidth() + ", height=" + this.getHeight() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlateDTO)) {
         return false;
      }

      PlateDTO other = (PlateDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$width = this.getWidth();
      Object other$width = other.getWidth();
      if (this$width == null ? other$width == null : this$width.equals(other$width)) {
         Object this$height = this.getHeight();
         Object other$height = other.getHeight();
         if (this$height == null ? other$height == null : this$height.equals(other$height)) {
            Object this$guid = this.getGuid();
            Object other$guid = other.getGuid();
            if (this$guid == null ? other$guid == null : this$guid.equals(other$guid)) {
               Object this$plate_name = this.getPlate_name();
               Object other$plate_name = other.getPlate_name();
               return this$plate_name == null ? other$plate_name == null : this$plate_name.equals(other$plate_name);
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
      return other instanceof PlateDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $height = this.getHeight();
      result = result * 59 + ($height == null ? 43 : $height.hashCode());
      Object $guid = this.getGuid();
      result = result * 59 + ($guid == null ? 43 : $guid.hashCode());
      Object $plate_name = this.getPlate_name();
      return result * 59 + ($plate_name == null ? 43 : $plate_name.hashCode());
   }

   public static class PlateDTOBuilder {
      private String guid;
      private String plate_name;
      private Double width;
      private Double height;

      PlateDTOBuilder() {
      }

      public PlateDTO.PlateDTOBuilder guid(final String guid) {
         this.guid = guid;
         return this;
      }

      public PlateDTO.PlateDTOBuilder plate_name(final String plate_name) {
         this.plate_name = plate_name;
         return this;
      }

      public PlateDTO.PlateDTOBuilder width(final Double width) {
         this.width = width;
         return this;
      }

      public PlateDTO.PlateDTOBuilder height(final Double height) {
         this.height = height;
         return this;
      }

      public PlateDTO build() {
         return new PlateDTO(this.guid, this.plate_name, this.width, this.height);
      }

      @Override
      public String toString() {
         return "PlateDTO.PlateDTOBuilder(guid=" + this.guid + ", plate_name=" + this.plate_name + ", width=" + this.width + ", height=" + this.height + ")";
      }
   }
}
