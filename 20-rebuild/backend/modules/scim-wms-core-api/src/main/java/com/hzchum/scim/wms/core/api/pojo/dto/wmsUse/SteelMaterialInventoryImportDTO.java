package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import cn.afterturn.easypoi.excel.annotation.Excel;
import java.math.BigDecimal;

public class SteelMaterialInventoryImportDTO {
   @Excel(name = "序号")
   private Integer order;
   @Excel(name = "物料编号")
   private String serialNumber;
   @Excel(name = "物料名称")
   private String classifyName;
   @Excel(name = "厚")
   private BigDecimal thickness;
   @Excel(name = "宽")
   private BigDecimal width;
   @Excel(name = "长")
   private BigDecimal length;
   @Excel(name = "数量（张）")
   private BigDecimal quantity;
   @Excel(name = "重量")
   private BigDecimal mete;
   @Excel(name = "品牌")
   private String brand;
   @Excel(name = "炉批号")
   private String heatNoAndBatchNo;
   @Excel(name = "库存位置")
   private String workshopName;
   @Excel(name = "所属项目")
   private String projectName;

   public static SteelMaterialInventoryImportDTO.SteelMaterialInventoryImportDTOBuilder builder() {
      return new SteelMaterialInventoryImportDTO.SteelMaterialInventoryImportDTOBuilder();
   }

   public Integer getOrder() {
      return this.order;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public void setOrder(final Integer order) {
      this.order = order;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
   }

   public void setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SteelMaterialInventoryImportDTO)) {
         return false;
      }

      SteelMaterialInventoryImportDTO other = (SteelMaterialInventoryImportDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$order = this.getOrder();
      Object other$order = other.getOrder();
      if (this$order == null ? other$order == null : this$order.equals(other$order)) {
         Object this$serialNumber = this.getSerialNumber();
         Object other$serialNumber = other.getSerialNumber();
         if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
            Object this$classifyName = this.getClassifyName();
            Object other$classifyName = other.getClassifyName();
            if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
               Object this$thickness = this.getThickness();
               Object other$thickness = other.getThickness();
               if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                  Object this$width = this.getWidth();
                  Object other$width = other.getWidth();
                  if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                     Object this$length = this.getLength();
                     Object other$length = other.getLength();
                     if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                        Object this$quantity = this.getQuantity();
                        Object other$quantity = other.getQuantity();
                        if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                           Object this$mete = this.getMete();
                           Object other$mete = other.getMete();
                           if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                              Object this$brand = this.getBrand();
                              Object other$brand = other.getBrand();
                              if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                 Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                 Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                 if (this$heatNoAndBatchNo == null ? other$heatNoAndBatchNo == null : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                                    Object this$workshopName = this.getWorkshopName();
                                    Object other$workshopName = other.getWorkshopName();
                                    if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
                                       Object this$projectName = this.getProjectName();
                                       Object other$projectName = other.getProjectName();
                                       return this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SteelMaterialInventoryImportDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $order = this.getOrder();
      result = result * 59 + ($order == null ? 43 : $order.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $projectName = this.getProjectName();
      return result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
   }

   @Override
   public String toString() {
      return "SteelMaterialInventoryImportDTO(order="
         + this.getOrder()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", classifyName="
         + this.getClassifyName()
         + ", thickness="
         + this.getThickness()
         + ", width="
         + this.getWidth()
         + ", length="
         + this.getLength()
         + ", quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", brand="
         + this.getBrand()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", workshopName="
         + this.getWorkshopName()
         + ", projectName="
         + this.getProjectName()
         + ")";
   }

   public SteelMaterialInventoryImportDTO(
      final Integer order,
      final String serialNumber,
      final String classifyName,
      final BigDecimal thickness,
      final BigDecimal width,
      final BigDecimal length,
      final BigDecimal quantity,
      final BigDecimal mete,
      final String brand,
      final String heatNoAndBatchNo,
      final String workshopName,
      final String projectName
   ) {
      this.order = order;
      this.serialNumber = serialNumber;
      this.classifyName = classifyName;
      this.thickness = thickness;
      this.width = width;
      this.length = length;
      this.quantity = quantity;
      this.mete = mete;
      this.brand = brand;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.workshopName = workshopName;
      this.projectName = projectName;
   }

   public SteelMaterialInventoryImportDTO() {
   }

   public static class SteelMaterialInventoryImportDTOBuilder {
      private Integer order;
      private String serialNumber;
      private String classifyName;
      private BigDecimal thickness;
      private BigDecimal width;
      private BigDecimal length;
      private BigDecimal quantity;
      private BigDecimal mete;
      private String brand;
      private String heatNoAndBatchNo;
      private String workshopName;
      private String projectName;

      SteelMaterialInventoryImportDTOBuilder() {
      }

      public SteelMaterialInventoryImportDTO.SteelMaterialInventoryImportDTOBuilder order(final Integer order) {
         this.order = order;
         return this;
      }

      public SteelMaterialInventoryImportDTO.SteelMaterialInventoryImportDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public SteelMaterialInventoryImportDTO.SteelMaterialInventoryImportDTOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public SteelMaterialInventoryImportDTO.SteelMaterialInventoryImportDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public SteelMaterialInventoryImportDTO.SteelMaterialInventoryImportDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public SteelMaterialInventoryImportDTO.SteelMaterialInventoryImportDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public SteelMaterialInventoryImportDTO.SteelMaterialInventoryImportDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public SteelMaterialInventoryImportDTO.SteelMaterialInventoryImportDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public SteelMaterialInventoryImportDTO.SteelMaterialInventoryImportDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public SteelMaterialInventoryImportDTO.SteelMaterialInventoryImportDTOBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      public SteelMaterialInventoryImportDTO.SteelMaterialInventoryImportDTOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      public SteelMaterialInventoryImportDTO.SteelMaterialInventoryImportDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public SteelMaterialInventoryImportDTO build() {
         return new SteelMaterialInventoryImportDTO(
            this.order,
            this.serialNumber,
            this.classifyName,
            this.thickness,
            this.width,
            this.length,
            this.quantity,
            this.mete,
            this.brand,
            this.heatNoAndBatchNo,
            this.workshopName,
            this.projectName
         );
      }

      @Override
      public String toString() {
         return "SteelMaterialInventoryImportDTO.SteelMaterialInventoryImportDTOBuilder(order="
            + this.order
            + ", serialNumber="
            + this.serialNumber
            + ", classifyName="
            + this.classifyName
            + ", thickness="
            + this.thickness
            + ", width="
            + this.width
            + ", length="
            + this.length
            + ", quantity="
            + this.quantity
            + ", mete="
            + this.mete
            + ", brand="
            + this.brand
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", workshopName="
            + this.workshopName
            + ", projectName="
            + this.projectName
            + ")";
      }
   }
}
