package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import io.swagger.annotations.ApiModelProperty;

public class OffLineSchedulingFileDTO {
   @ApiModelProperty(notes = "编号")
   private String serialNumber;
   @ApiModelProperty("材质")
   private String material;
   @ApiModelProperty(name = "thickness", value = "厚度")
   private String thickness;
   @ApiModelProperty(name = "quantity", value = "数量")
   private Integer quantity;
   @ApiModelProperty(name = "equipmentNo", value = "设备号")
   private String equipmentNo;
   @ApiModelProperty(name = "path", value = "路径")
   private String path;

   public static OffLineSchedulingFileDTO.OffLineSchedulingFileDTOBuilder builder() {
      return new OffLineSchedulingFileDTO.OffLineSchedulingFileDTOBuilder();
   }

   public OffLineSchedulingFileDTO(
      final String serialNumber, final String material, final String thickness, final Integer quantity, final String equipmentNo, final String path
   ) {
      this.serialNumber = serialNumber;
      this.material = material;
      this.thickness = thickness;
      this.quantity = quantity;
      this.equipmentNo = equipmentNo;
      this.path = path;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getThickness() {
      return this.thickness;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public String getEquipmentNo() {
      return this.equipmentNo;
   }

   public String getPath() {
      return this.path;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setThickness(final String thickness) {
      this.thickness = thickness;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setEquipmentNo(final String equipmentNo) {
      this.equipmentNo = equipmentNo;
   }

   public void setPath(final String path) {
      this.path = path;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OffLineSchedulingFileDTO)) {
         return false;
      }

      OffLineSchedulingFileDTO other = (OffLineSchedulingFileDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$serialNumber = this.getSerialNumber();
         Object other$serialNumber = other.getSerialNumber();
         if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
            Object this$material = this.getMaterial();
            Object other$material = other.getMaterial();
            if (this$material == null ? other$material == null : this$material.equals(other$material)) {
               Object this$thickness = this.getThickness();
               Object other$thickness = other.getThickness();
               if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                  Object this$equipmentNo = this.getEquipmentNo();
                  Object other$equipmentNo = other.getEquipmentNo();
                  if (this$equipmentNo == null ? other$equipmentNo == null : this$equipmentNo.equals(other$equipmentNo)) {
                     Object this$path = this.getPath();
                     Object other$path = other.getPath();
                     return this$path == null ? other$path == null : this$path.equals(other$path);
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
      return other instanceof OffLineSchedulingFileDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $equipmentNo = this.getEquipmentNo();
      result = result * 59 + ($equipmentNo == null ? 43 : $equipmentNo.hashCode());
      Object $path = this.getPath();
      return result * 59 + ($path == null ? 43 : $path.hashCode());
   }

   @Override
   public String toString() {
      return "OffLineSchedulingFileDTO(serialNumber="
         + this.getSerialNumber()
         + ", material="
         + this.getMaterial()
         + ", thickness="
         + this.getThickness()
         + ", quantity="
         + this.getQuantity()
         + ", equipmentNo="
         + this.getEquipmentNo()
         + ", path="
         + this.getPath()
         + ")";
   }

   public OffLineSchedulingFileDTO() {
   }

   public static class OffLineSchedulingFileDTOBuilder {
      private String serialNumber;
      private String material;
      private String thickness;
      private Integer quantity;
      private String equipmentNo;
      private String path;

      OffLineSchedulingFileDTOBuilder() {
      }

      public OffLineSchedulingFileDTO.OffLineSchedulingFileDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public OffLineSchedulingFileDTO.OffLineSchedulingFileDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public OffLineSchedulingFileDTO.OffLineSchedulingFileDTOBuilder thickness(final String thickness) {
         this.thickness = thickness;
         return this;
      }

      public OffLineSchedulingFileDTO.OffLineSchedulingFileDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public OffLineSchedulingFileDTO.OffLineSchedulingFileDTOBuilder equipmentNo(final String equipmentNo) {
         this.equipmentNo = equipmentNo;
         return this;
      }

      public OffLineSchedulingFileDTO.OffLineSchedulingFileDTOBuilder path(final String path) {
         this.path = path;
         return this;
      }

      public OffLineSchedulingFileDTO build() {
         return new OffLineSchedulingFileDTO(this.serialNumber, this.material, this.thickness, this.quantity, this.equipmentNo, this.path);
      }

      @Override
      public String toString() {
         return "OffLineSchedulingFileDTO.OffLineSchedulingFileDTOBuilder(serialNumber="
            + this.serialNumber
            + ", material="
            + this.material
            + ", thickness="
            + this.thickness
            + ", quantity="
            + this.quantity
            + ", equipmentNo="
            + this.equipmentNo
            + ", path="
            + this.path
            + ")";
      }
   }
}
