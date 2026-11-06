package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ConvertDTOParam {
   private String receiptSerialNumber;
   private Long outboundId;
   private String outSerialNumber;
   private String brand;
   private String specification;
   private String serialNumber;
   private BigDecimal width;
   private BigDecimal thickness;
   private String color;
   private String heatNoAndBatchNo;
   private Long warehouseId;
   private Long projectId;
   private Integer status;
   LocalDate startDate;
   LocalDate endDate;
   private Integer projectWarehouseType;
   private Boolean boolAll;
   private Boolean boolPartyA;

   public static ConvertDTOParam.ConvertDTOParamBuilder builder() {
      return new ConvertDTOParam.ConvertDTOParamBuilder();
   }

   public String getReceiptSerialNumber() {
      return this.receiptSerialNumber;
   }

   public Long getOutboundId() {
      return this.outboundId;
   }

   public String getOutSerialNumber() {
      return this.outSerialNumber;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public String getColor() {
      return this.color;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getStatus() {
      return this.status;
   }

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public Integer getProjectWarehouseType() {
      return this.projectWarehouseType;
   }

   public Boolean getBoolAll() {
      return this.boolAll;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public void setReceiptSerialNumber(final String receiptSerialNumber) {
      this.receiptSerialNumber = receiptSerialNumber;
   }

   public void setOutboundId(final Long outboundId) {
      this.outboundId = outboundId;
   }

   public void setOutSerialNumber(final String outSerialNumber) {
      this.outSerialNumber = outSerialNumber;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
   }

   public void setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
   }

   public void setProjectWarehouseType(final Integer projectWarehouseType) {
      this.projectWarehouseType = projectWarehouseType;
   }

   public void setBoolAll(final Boolean boolAll) {
      this.boolAll = boolAll;
   }

   public void setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ConvertDTOParam)) {
         return false;
      }

      ConvertDTOParam other = (ConvertDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$outboundId = this.getOutboundId();
      Object other$outboundId = other.getOutboundId();
      if (this$outboundId == null ? other$outboundId == null : this$outboundId.equals(other$outboundId)) {
         Object this$warehouseId = this.getWarehouseId();
         Object other$warehouseId = other.getWarehouseId();
         if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$status = this.getStatus();
               Object other$status = other.getStatus();
               if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                  Object this$projectWarehouseType = this.getProjectWarehouseType();
                  Object other$projectWarehouseType = other.getProjectWarehouseType();
                  if (this$projectWarehouseType == null ? other$projectWarehouseType == null : this$projectWarehouseType.equals(other$projectWarehouseType)) {
                     Object this$boolAll = this.getBoolAll();
                     Object other$boolAll = other.getBoolAll();
                     if (this$boolAll == null ? other$boolAll == null : this$boolAll.equals(other$boolAll)) {
                        Object this$boolPartyA = this.getBoolPartyA();
                        Object other$boolPartyA = other.getBoolPartyA();
                        if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
                           Object this$receiptSerialNumber = this.getReceiptSerialNumber();
                           Object other$receiptSerialNumber = other.getReceiptSerialNumber();
                           if (this$receiptSerialNumber == null
                              ? other$receiptSerialNumber == null
                              : this$receiptSerialNumber.equals(other$receiptSerialNumber)) {
                              Object this$outSerialNumber = this.getOutSerialNumber();
                              Object other$outSerialNumber = other.getOutSerialNumber();
                              if (this$outSerialNumber == null ? other$outSerialNumber == null : this$outSerialNumber.equals(other$outSerialNumber)) {
                                 Object this$brand = this.getBrand();
                                 Object other$brand = other.getBrand();
                                 if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                    Object this$specification = this.getSpecification();
                                    Object other$specification = other.getSpecification();
                                    if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                       Object this$serialNumber = this.getSerialNumber();
                                       Object other$serialNumber = other.getSerialNumber();
                                       if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                          Object this$width = this.getWidth();
                                          Object other$width = other.getWidth();
                                          if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                             Object this$thickness = this.getThickness();
                                             Object other$thickness = other.getThickness();
                                             if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                                Object this$color = this.getColor();
                                                Object other$color = other.getColor();
                                                if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                   Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                                   Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                                   if (this$heatNoAndBatchNo == null
                                                      ? other$heatNoAndBatchNo == null
                                                      : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                                                      Object this$startDate = this.getStartDate();
                                                      Object other$startDate = other.getStartDate();
                                                      if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                                                         Object this$endDate = this.getEndDate();
                                                         Object other$endDate = other.getEndDate();
                                                         return this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ConvertDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $outboundId = this.getOutboundId();
      result = result * 59 + ($outboundId == null ? 43 : $outboundId.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $projectWarehouseType = this.getProjectWarehouseType();
      result = result * 59 + ($projectWarehouseType == null ? 43 : $projectWarehouseType.hashCode());
      Object $boolAll = this.getBoolAll();
      result = result * 59 + ($boolAll == null ? 43 : $boolAll.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $receiptSerialNumber = this.getReceiptSerialNumber();
      result = result * 59 + ($receiptSerialNumber == null ? 43 : $receiptSerialNumber.hashCode());
      Object $outSerialNumber = this.getOutSerialNumber();
      result = result * 59 + ($outSerialNumber == null ? 43 : $outSerialNumber.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      return result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
   }

   @Override
   public String toString() {
      return "ConvertDTOParam(receiptSerialNumber="
         + this.getReceiptSerialNumber()
         + ", outboundId="
         + this.getOutboundId()
         + ", outSerialNumber="
         + this.getOutSerialNumber()
         + ", brand="
         + this.getBrand()
         + ", specification="
         + this.getSpecification()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", width="
         + this.getWidth()
         + ", thickness="
         + this.getThickness()
         + ", color="
         + this.getColor()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", projectId="
         + this.getProjectId()
         + ", status="
         + this.getStatus()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", projectWarehouseType="
         + this.getProjectWarehouseType()
         + ", boolAll="
         + this.getBoolAll()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ")";
   }

   public ConvertDTOParam(
      final String receiptSerialNumber,
      final Long outboundId,
      final String outSerialNumber,
      final String brand,
      final String specification,
      final String serialNumber,
      final BigDecimal width,
      final BigDecimal thickness,
      final String color,
      final String heatNoAndBatchNo,
      final Long warehouseId,
      final Long projectId,
      final Integer status,
      final LocalDate startDate,
      final LocalDate endDate,
      final Integer projectWarehouseType,
      final Boolean boolAll,
      final Boolean boolPartyA
   ) {
      this.receiptSerialNumber = receiptSerialNumber;
      this.outboundId = outboundId;
      this.outSerialNumber = outSerialNumber;
      this.brand = brand;
      this.specification = specification;
      this.serialNumber = serialNumber;
      this.width = width;
      this.thickness = thickness;
      this.color = color;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.warehouseId = warehouseId;
      this.projectId = projectId;
      this.status = status;
      this.startDate = startDate;
      this.endDate = endDate;
      this.projectWarehouseType = projectWarehouseType;
      this.boolAll = boolAll;
      this.boolPartyA = boolPartyA;
   }

   public ConvertDTOParam() {
   }

   public static class ConvertDTOParamBuilder {
      private String receiptSerialNumber;
      private Long outboundId;
      private String outSerialNumber;
      private String brand;
      private String specification;
      private String serialNumber;
      private BigDecimal width;
      private BigDecimal thickness;
      private String color;
      private String heatNoAndBatchNo;
      private Long warehouseId;
      private Long projectId;
      private Integer status;
      private LocalDate startDate;
      private LocalDate endDate;
      private Integer projectWarehouseType;
      private Boolean boolAll;
      private Boolean boolPartyA;

      ConvertDTOParamBuilder() {
      }

      public ConvertDTOParam.ConvertDTOParamBuilder receiptSerialNumber(final String receiptSerialNumber) {
         this.receiptSerialNumber = receiptSerialNumber;
         return this;
      }

      public ConvertDTOParam.ConvertDTOParamBuilder outboundId(final Long outboundId) {
         this.outboundId = outboundId;
         return this;
      }

      public ConvertDTOParam.ConvertDTOParamBuilder outSerialNumber(final String outSerialNumber) {
         this.outSerialNumber = outSerialNumber;
         return this;
      }

      public ConvertDTOParam.ConvertDTOParamBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public ConvertDTOParam.ConvertDTOParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public ConvertDTOParam.ConvertDTOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ConvertDTOParam.ConvertDTOParamBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public ConvertDTOParam.ConvertDTOParamBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public ConvertDTOParam.ConvertDTOParamBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public ConvertDTOParam.ConvertDTOParamBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      public ConvertDTOParam.ConvertDTOParamBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      public ConvertDTOParam.ConvertDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ConvertDTOParam.ConvertDTOParamBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public ConvertDTOParam.ConvertDTOParamBuilder startDate(final LocalDate startDate) {
         this.startDate = startDate;
         return this;
      }

      public ConvertDTOParam.ConvertDTOParamBuilder endDate(final LocalDate endDate) {
         this.endDate = endDate;
         return this;
      }

      public ConvertDTOParam.ConvertDTOParamBuilder projectWarehouseType(final Integer projectWarehouseType) {
         this.projectWarehouseType = projectWarehouseType;
         return this;
      }

      public ConvertDTOParam.ConvertDTOParamBuilder boolAll(final Boolean boolAll) {
         this.boolAll = boolAll;
         return this;
      }

      public ConvertDTOParam.ConvertDTOParamBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      public ConvertDTOParam build() {
         return new ConvertDTOParam(
            this.receiptSerialNumber,
            this.outboundId,
            this.outSerialNumber,
            this.brand,
            this.specification,
            this.serialNumber,
            this.width,
            this.thickness,
            this.color,
            this.heatNoAndBatchNo,
            this.warehouseId,
            this.projectId,
            this.status,
            this.startDate,
            this.endDate,
            this.projectWarehouseType,
            this.boolAll,
            this.boolPartyA
         );
      }

      @Override
      public String toString() {
         return "ConvertDTOParam.ConvertDTOParamBuilder(receiptSerialNumber="
            + this.receiptSerialNumber
            + ", outboundId="
            + this.outboundId
            + ", outSerialNumber="
            + this.outSerialNumber
            + ", brand="
            + this.brand
            + ", specification="
            + this.specification
            + ", serialNumber="
            + this.serialNumber
            + ", width="
            + this.width
            + ", thickness="
            + this.thickness
            + ", color="
            + this.color
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", warehouseId="
            + this.warehouseId
            + ", projectId="
            + this.projectId
            + ", status="
            + this.status
            + ", startDate="
            + this.startDate
            + ", endDate="
            + this.endDate
            + ", projectWarehouseType="
            + this.projectWarehouseType
            + ", boolAll="
            + this.boolAll
            + ", boolPartyA="
            + this.boolPartyA
            + ")";
      }
   }
}
