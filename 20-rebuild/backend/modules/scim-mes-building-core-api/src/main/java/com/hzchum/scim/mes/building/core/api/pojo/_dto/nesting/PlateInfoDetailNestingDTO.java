package com.hzchum.scim.mes.building.core.api.pojo._dto.nesting;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "套料报报告单第一部分", description = "套料报报告单第一部分")
public class PlateInfoDetailNestingDTO {
   private String guid;
   private String plate_name;
   private double thickness;
   private int plate_type;
   private double width;
   private double height;
   private String sync_id;

   public static PlateInfoDetailNestingDTO.PlateInfoDetailNestingDTOBuilder builder() {
      return new PlateInfoDetailNestingDTO.PlateInfoDetailNestingDTOBuilder();
   }

   public PlateInfoDetailNestingDTO(
      final String guid, final String plate_name, final double thickness, final int plate_type, final double width, final double height, final String sync_id
   ) {
      this.guid = guid;
      this.plate_name = plate_name;
      this.thickness = thickness;
      this.plate_type = plate_type;
      this.width = width;
      this.height = height;
      this.sync_id = sync_id;
   }

   public PlateInfoDetailNestingDTO() {
   }

   public String getGuid() {
      return this.guid;
   }

   public String getPlate_name() {
      return this.plate_name;
   }

   public double getThickness() {
      return this.thickness;
   }

   public int getPlate_type() {
      return this.plate_type;
   }

   public double getWidth() {
      return this.width;
   }

   public double getHeight() {
      return this.height;
   }

   public String getSync_id() {
      return this.sync_id;
   }

   public PlateInfoDetailNestingDTO setGuid(final String guid) {
      this.guid = guid;
      return this;
   }

   public PlateInfoDetailNestingDTO setPlate_name(final String plate_name) {
      this.plate_name = plate_name;
      return this;
   }

   public PlateInfoDetailNestingDTO setThickness(final double thickness) {
      this.thickness = thickness;
      return this;
   }

   public PlateInfoDetailNestingDTO setPlate_type(final int plate_type) {
      this.plate_type = plate_type;
      return this;
   }

   public PlateInfoDetailNestingDTO setWidth(final double width) {
      this.width = width;
      return this;
   }

   public PlateInfoDetailNestingDTO setHeight(final double height) {
      this.height = height;
      return this;
   }

   public PlateInfoDetailNestingDTO setSync_id(final String sync_id) {
      this.sync_id = sync_id;
      return this;
   }

   @Override
   public String toString() {
      return "PlateInfoDetailNestingDTO(guid="
         + this.getGuid()
         + ", plate_name="
         + this.getPlate_name()
         + ", thickness="
         + this.getThickness()
         + ", plate_type="
         + this.getPlate_type()
         + ", width="
         + this.getWidth()
         + ", height="
         + this.getHeight()
         + ", sync_id="
         + this.getSync_id()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlateInfoDetailNestingDTO)) {
         return false;
      }

      PlateInfoDetailNestingDTO other = (PlateInfoDetailNestingDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (Double.compare(this.getThickness(), other.getThickness()) != 0) {
         return false;
      }

      if (this.getPlate_type() != other.getPlate_type()) {
         return false;
      }

      if (Double.compare(this.getWidth(), other.getWidth()) != 0) {
         return false;
      }

      if (Double.compare(this.getHeight(), other.getHeight()) != 0) {
         return false;
      }

      Object this$guid = this.getGuid();
      Object other$guid = other.getGuid();
      if (this$guid == null ? other$guid == null : this$guid.equals(other$guid)) {
         Object this$plate_name = this.getPlate_name();
         Object other$plate_name = other.getPlate_name();
         if (this$plate_name == null ? other$plate_name == null : this$plate_name.equals(other$plate_name)) {
            Object this$sync_id = this.getSync_id();
            Object other$sync_id = other.getSync_id();
            return this$sync_id == null ? other$sync_id == null : this$sync_id.equals(other$sync_id);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PlateInfoDetailNestingDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $thickness = Double.doubleToLongBits(this.getThickness());
      result = result * 59 + (int)($thickness >>> 32 ^ $thickness);
      result = result * 59 + this.getPlate_type();
      long $width = Double.doubleToLongBits(this.getWidth());
      result = result * 59 + (int)($width >>> 32 ^ $width);
      long $height = Double.doubleToLongBits(this.getHeight());
      result = result * 59 + (int)($height >>> 32 ^ $height);
      Object $guid = this.getGuid();
      result = result * 59 + ($guid == null ? 43 : $guid.hashCode());
      Object $plate_name = this.getPlate_name();
      result = result * 59 + ($plate_name == null ? 43 : $plate_name.hashCode());
      Object $sync_id = this.getSync_id();
      return result * 59 + ($sync_id == null ? 43 : $sync_id.hashCode());
   }

   public static class PlateInfoDetailNestingDTOBuilder {
      private String guid;
      private String plate_name;
      private double thickness;
      private int plate_type;
      private double width;
      private double height;
      private String sync_id;

      PlateInfoDetailNestingDTOBuilder() {
      }

      public PlateInfoDetailNestingDTO.PlateInfoDetailNestingDTOBuilder guid(final String guid) {
         this.guid = guid;
         return this;
      }

      public PlateInfoDetailNestingDTO.PlateInfoDetailNestingDTOBuilder plate_name(final String plate_name) {
         this.plate_name = plate_name;
         return this;
      }

      public PlateInfoDetailNestingDTO.PlateInfoDetailNestingDTOBuilder thickness(final double thickness) {
         this.thickness = thickness;
         return this;
      }

      public PlateInfoDetailNestingDTO.PlateInfoDetailNestingDTOBuilder plate_type(final int plate_type) {
         this.plate_type = plate_type;
         return this;
      }

      public PlateInfoDetailNestingDTO.PlateInfoDetailNestingDTOBuilder width(final double width) {
         this.width = width;
         return this;
      }

      public PlateInfoDetailNestingDTO.PlateInfoDetailNestingDTOBuilder height(final double height) {
         this.height = height;
         return this;
      }

      public PlateInfoDetailNestingDTO.PlateInfoDetailNestingDTOBuilder sync_id(final String sync_id) {
         this.sync_id = sync_id;
         return this;
      }

      public PlateInfoDetailNestingDTO build() {
         return new PlateInfoDetailNestingDTO(this.guid, this.plate_name, this.thickness, this.plate_type, this.width, this.height, this.sync_id);
      }

      @Override
      public String toString() {
         return "PlateInfoDetailNestingDTO.PlateInfoDetailNestingDTOBuilder(guid="
            + this.guid
            + ", plate_name="
            + this.plate_name
            + ", thickness="
            + this.thickness
            + ", plate_type="
            + this.plate_type
            + ", width="
            + this.width
            + ", height="
            + this.height
            + ", sync_id="
            + this.sync_id
            + ")";
      }
   }
}
