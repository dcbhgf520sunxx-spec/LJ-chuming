package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import cn.afterturn.easypoi.excel.annotation.Excel;
import java.math.BigDecimal;

public class ConvertImportDTO {
   @Excel(name = "序号")
   private Integer orderNo;
   @Excel(name = "转换单号")
   private String receiptSerialNumber;
   @Excel(name = "出库单号")
   private String outSerialNumber;
   @Excel(name = "物料编号")
   private String serialNumber;
   @Excel(name = "物料名称")
   private String classifyName;
   @Excel(name = "规格")
   private String specification;
   @Excel(name = "厚(mm)*宽(mm)")
   private String widthAndThickness;
   @Excel(name = "转换总重(kg)")
   private BigDecimal mete;
   @Excel(name = "品牌")
   private String brand;
   @Excel(name = "颜色")
   private String color;
   @Excel(name = "卷号")
   private String heatNoAndBatchNo;
   @Excel(name = "所属项目")
   private String project;
   @Excel(name = "仓库位置")
   private String warehouse;
   @Excel(name = "审核状态")
   private String status;
   private Long warehouseId;
   private Long projectId;

   public static ConvertImportDTO.ConvertImportDTOBuilder builder() {
      return new ConvertImportDTO.ConvertImportDTOBuilder();
   }

   public Integer getOrderNo() {
      return this.orderNo;
   }

   public String getReceiptSerialNumber() {
      return this.receiptSerialNumber;
   }

   public String getOutSerialNumber() {
      return this.outSerialNumber;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getWidthAndThickness() {
      return this.widthAndThickness;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getColor() {
      return this.color;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public String getProject() {
      return this.project;
   }

   public String getWarehouse() {
      return this.warehouse;
   }

   public String getStatus() {
      return this.status;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public void setOrderNo(final Integer orderNo) {
      this.orderNo = orderNo;
   }

   public void setReceiptSerialNumber(final String receiptSerialNumber) {
      this.receiptSerialNumber = receiptSerialNumber;
   }

   public void setOutSerialNumber(final String outSerialNumber) {
      this.outSerialNumber = outSerialNumber;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setWidthAndThickness(final String widthAndThickness) {
      this.widthAndThickness = widthAndThickness;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
   }

   public void setProject(final String project) {
      this.project = project;
   }

   public void setWarehouse(final String warehouse) {
      this.warehouse = warehouse;
   }

   public void setStatus(final String status) {
      this.status = status;
   }

   public void setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ConvertImportDTO)) {
         return false;
      }

      ConvertImportDTO other = (ConvertImportDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$orderNo = this.getOrderNo();
      Object other$orderNo = other.getOrderNo();
      if (this$orderNo == null ? other$orderNo == null : this$orderNo.equals(other$orderNo)) {
         Object this$warehouseId = this.getWarehouseId();
         Object other$warehouseId = other.getWarehouseId();
         if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$receiptSerialNumber = this.getReceiptSerialNumber();
               Object other$receiptSerialNumber = other.getReceiptSerialNumber();
               if (this$receiptSerialNumber == null ? other$receiptSerialNumber == null : this$receiptSerialNumber.equals(other$receiptSerialNumber)) {
                  Object this$outSerialNumber = this.getOutSerialNumber();
                  Object other$outSerialNumber = other.getOutSerialNumber();
                  if (this$outSerialNumber == null ? other$outSerialNumber == null : this$outSerialNumber.equals(other$outSerialNumber)) {
                     Object this$serialNumber = this.getSerialNumber();
                     Object other$serialNumber = other.getSerialNumber();
                     if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                        Object this$classifyName = this.getClassifyName();
                        Object other$classifyName = other.getClassifyName();
                        if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
                           Object this$specification = this.getSpecification();
                           Object other$specification = other.getSpecification();
                           if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                              Object this$widthAndThickness = this.getWidthAndThickness();
                              Object other$widthAndThickness = other.getWidthAndThickness();
                              if (this$widthAndThickness == null ? other$widthAndThickness == null : this$widthAndThickness.equals(other$widthAndThickness)) {
                                 Object this$mete = this.getMete();
                                 Object other$mete = other.getMete();
                                 if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                    Object this$brand = this.getBrand();
                                    Object other$brand = other.getBrand();
                                    if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                       Object this$color = this.getColor();
                                       Object other$color = other.getColor();
                                       if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                          Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                          Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                          if (this$heatNoAndBatchNo == null
                                             ? other$heatNoAndBatchNo == null
                                             : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                                             Object this$project = this.getProject();
                                             Object other$project = other.getProject();
                                             if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                                Object this$warehouse = this.getWarehouse();
                                                Object other$warehouse = other.getWarehouse();
                                                if (this$warehouse == null ? other$warehouse == null : this$warehouse.equals(other$warehouse)) {
                                                   Object this$status = this.getStatus();
                                                   Object other$status = other.getStatus();
                                                   return this$status == null ? other$status == null : this$status.equals(other$status);
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
      return other instanceof ConvertImportDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderNo = this.getOrderNo();
      result = result * 59 + ($orderNo == null ? 43 : $orderNo.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $receiptSerialNumber = this.getReceiptSerialNumber();
      result = result * 59 + ($receiptSerialNumber == null ? 43 : $receiptSerialNumber.hashCode());
      Object $outSerialNumber = this.getOutSerialNumber();
      result = result * 59 + ($outSerialNumber == null ? 43 : $outSerialNumber.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $widthAndThickness = this.getWidthAndThickness();
      result = result * 59 + ($widthAndThickness == null ? 43 : $widthAndThickness.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $warehouse = this.getWarehouse();
      result = result * 59 + ($warehouse == null ? 43 : $warehouse.hashCode());
      Object $status = this.getStatus();
      return result * 59 + ($status == null ? 43 : $status.hashCode());
   }

   @Override
   public String toString() {
      return "ConvertImportDTO(orderNo="
         + this.getOrderNo()
         + ", receiptSerialNumber="
         + this.getReceiptSerialNumber()
         + ", outSerialNumber="
         + this.getOutSerialNumber()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", classifyName="
         + this.getClassifyName()
         + ", specification="
         + this.getSpecification()
         + ", widthAndThickness="
         + this.getWidthAndThickness()
         + ", mete="
         + this.getMete()
         + ", brand="
         + this.getBrand()
         + ", color="
         + this.getColor()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", project="
         + this.getProject()
         + ", warehouse="
         + this.getWarehouse()
         + ", status="
         + this.getStatus()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", projectId="
         + this.getProjectId()
         + ")";
   }

   public ConvertImportDTO(
      final Integer orderNo,
      final String receiptSerialNumber,
      final String outSerialNumber,
      final String serialNumber,
      final String classifyName,
      final String specification,
      final String widthAndThickness,
      final BigDecimal mete,
      final String brand,
      final String color,
      final String heatNoAndBatchNo,
      final String project,
      final String warehouse,
      final String status,
      final Long warehouseId,
      final Long projectId
   ) {
      this.orderNo = orderNo;
      this.receiptSerialNumber = receiptSerialNumber;
      this.outSerialNumber = outSerialNumber;
      this.serialNumber = serialNumber;
      this.classifyName = classifyName;
      this.specification = specification;
      this.widthAndThickness = widthAndThickness;
      this.mete = mete;
      this.brand = brand;
      this.color = color;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.project = project;
      this.warehouse = warehouse;
      this.status = status;
      this.warehouseId = warehouseId;
      this.projectId = projectId;
   }

   public ConvertImportDTO() {
   }

   public static class ConvertImportDTOBuilder {
      private Integer orderNo;
      private String receiptSerialNumber;
      private String outSerialNumber;
      private String serialNumber;
      private String classifyName;
      private String specification;
      private String widthAndThickness;
      private BigDecimal mete;
      private String brand;
      private String color;
      private String heatNoAndBatchNo;
      private String project;
      private String warehouse;
      private String status;
      private Long warehouseId;
      private Long projectId;

      ConvertImportDTOBuilder() {
      }

      public ConvertImportDTO.ConvertImportDTOBuilder orderNo(final Integer orderNo) {
         this.orderNo = orderNo;
         return this;
      }

      public ConvertImportDTO.ConvertImportDTOBuilder receiptSerialNumber(final String receiptSerialNumber) {
         this.receiptSerialNumber = receiptSerialNumber;
         return this;
      }

      public ConvertImportDTO.ConvertImportDTOBuilder outSerialNumber(final String outSerialNumber) {
         this.outSerialNumber = outSerialNumber;
         return this;
      }

      public ConvertImportDTO.ConvertImportDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ConvertImportDTO.ConvertImportDTOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public ConvertImportDTO.ConvertImportDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public ConvertImportDTO.ConvertImportDTOBuilder widthAndThickness(final String widthAndThickness) {
         this.widthAndThickness = widthAndThickness;
         return this;
      }

      public ConvertImportDTO.ConvertImportDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public ConvertImportDTO.ConvertImportDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public ConvertImportDTO.ConvertImportDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public ConvertImportDTO.ConvertImportDTOBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      public ConvertImportDTO.ConvertImportDTOBuilder project(final String project) {
         this.project = project;
         return this;
      }

      public ConvertImportDTO.ConvertImportDTOBuilder warehouse(final String warehouse) {
         this.warehouse = warehouse;
         return this;
      }

      public ConvertImportDTO.ConvertImportDTOBuilder status(final String status) {
         this.status = status;
         return this;
      }

      public ConvertImportDTO.ConvertImportDTOBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      public ConvertImportDTO.ConvertImportDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ConvertImportDTO build() {
         return new ConvertImportDTO(
            this.orderNo,
            this.receiptSerialNumber,
            this.outSerialNumber,
            this.serialNumber,
            this.classifyName,
            this.specification,
            this.widthAndThickness,
            this.mete,
            this.brand,
            this.color,
            this.heatNoAndBatchNo,
            this.project,
            this.warehouse,
            this.status,
            this.warehouseId,
            this.projectId
         );
      }

      @Override
      public String toString() {
         return "ConvertImportDTO.ConvertImportDTOBuilder(orderNo="
            + this.orderNo
            + ", receiptSerialNumber="
            + this.receiptSerialNumber
            + ", outSerialNumber="
            + this.outSerialNumber
            + ", serialNumber="
            + this.serialNumber
            + ", classifyName="
            + this.classifyName
            + ", specification="
            + this.specification
            + ", widthAndThickness="
            + this.widthAndThickness
            + ", mete="
            + this.mete
            + ", brand="
            + this.brand
            + ", color="
            + this.color
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", project="
            + this.project
            + ", warehouse="
            + this.warehouse
            + ", status="
            + this.status
            + ", warehouseId="
            + this.warehouseId
            + ", projectId="
            + this.projectId
            + ")";
      }
   }
}
