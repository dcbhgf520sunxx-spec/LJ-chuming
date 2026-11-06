package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class SubscribeAuxiliaryWarehouseDTO {
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "materialInventoryId", notes = "库存Id")
   private Long materialInventoryId;
   @ApiModelProperty(name = "outboundDetailId", notes = "出库详情Id")
   private Long outboundDetailId;
   @ApiModelProperty(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   private String name;
   @ApiModelProperty(name = "quantity", notes = "入库数量")
   private BigDecimal quantity;
   @ApiModelProperty(name = "basicClass", value = "物料基础类型", notes = "物料基础类型")
   private Integer basicClass;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   private String specification;
   @ApiModelProperty(name = "measureUnit", value = "计量单位", notes = "计量单位")
   private String measureUnit;
   @ApiModelProperty(name = "mete", value = "核算量", notes = "核算量")
   private BigDecimal mete;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位", notes = "核算单位")
   private String accountingUnit;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @ApiModelProperty(name = "classifyId", value = "科目ID", notes = "科目ID")
   private Long classifyId;
   @ApiModelProperty(name = "classifyName", value = "科目名称", notes = "科目名称")
   private String classifyName;
   @ApiModelProperty(name = "model", value = "型号")
   private String model;
   @ApiModelProperty(name = "width", value = "宽度", notes = "宽度")
   private BigDecimal width;
   @ApiModelProperty(name = "thickness", value = "厚度", notes = "厚度")
   private BigDecimal thickness;
   @ApiModelProperty(name = "theoryThickness", value = "理论厚度", notes = "理论厚度")
   private BigDecimal theoryThickness;
   @ApiModelProperty(name = "brand", value = "品牌", notes = "品牌")
   private String brand;
   @ApiModelProperty(name = "heatNoAndBatchNo", value = "炉批号", notes = "炉批号")
   private String heatNoAndBatchNo;
   @ApiModelProperty(name = "color", value = "颜色", notes = "颜色")
   private String color;
   @ApiModelProperty(name = "accountingPrecision", value = "核算精度", notes = "核算精度")
   private Integer accountingPrecision;

   public static SubscribeAuxiliaryWarehouseDTO.SubscribeAuxiliaryWarehouseDTOBuilder builder() {
      return new SubscribeAuxiliaryWarehouseDTO.SubscribeAuxiliaryWarehouseDTOBuilder();
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMaterialInventoryId() {
      return this.materialInventoryId;
   }

   public Long getOutboundDetailId() {
      return this.outboundDetailId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getName() {
      return this.name;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public String getModel() {
      return this.model;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BigDecimal getTheoryThickness() {
      return this.theoryThickness;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public String getColor() {
      return this.color;
   }

   public Integer getAccountingPrecision() {
      return this.accountingPrecision;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMaterialInventoryId(final Long materialInventoryId) {
      this.materialInventoryId = materialInventoryId;
   }

   public void setOutboundDetailId(final Long outboundDetailId) {
      this.outboundDetailId = outboundDetailId;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   public void setModel(final String model) {
      this.model = model;
   }

   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setTheoryThickness(final BigDecimal theoryThickness) {
      this.theoryThickness = theoryThickness;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setAccountingPrecision(final Integer accountingPrecision) {
      this.accountingPrecision = accountingPrecision;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SubscribeAuxiliaryWarehouseDTO)) {
         return false;
      }

      SubscribeAuxiliaryWarehouseDTO other = (SubscribeAuxiliaryWarehouseDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$materialInventoryId = this.getMaterialInventoryId();
         Object other$materialInventoryId = other.getMaterialInventoryId();
         if (this$materialInventoryId == null ? other$materialInventoryId == null : this$materialInventoryId.equals(other$materialInventoryId)) {
            Object this$outboundDetailId = this.getOutboundDetailId();
            Object other$outboundDetailId = other.getOutboundDetailId();
            if (this$outboundDetailId == null ? other$outboundDetailId == null : this$outboundDetailId.equals(other$outboundDetailId)) {
               Object this$basicClass = this.getBasicClass();
               Object other$basicClass = other.getBasicClass();
               if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                  Object this$classifyId = this.getClassifyId();
                  Object other$classifyId = other.getClassifyId();
                  if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
                     Object this$accountingPrecision = this.getAccountingPrecision();
                     Object other$accountingPrecision = other.getAccountingPrecision();
                     if (this$accountingPrecision == null ? other$accountingPrecision == null : this$accountingPrecision.equals(other$accountingPrecision)) {
                        Object this$serialNumber = this.getSerialNumber();
                        Object other$serialNumber = other.getSerialNumber();
                        if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                           Object this$name = this.getName();
                           Object other$name = other.getName();
                           if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                              Object this$quantity = this.getQuantity();
                              Object other$quantity = other.getQuantity();
                              if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                 Object this$specification = this.getSpecification();
                                 Object other$specification = other.getSpecification();
                                 if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                    Object this$measureUnit = this.getMeasureUnit();
                                    Object other$measureUnit = other.getMeasureUnit();
                                    if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
                                       Object this$mete = this.getMete();
                                       Object other$mete = other.getMete();
                                       if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                          Object this$accountingUnit = this.getAccountingUnit();
                                          Object other$accountingUnit = other.getAccountingUnit();
                                          if (this$accountingUnit == null ? other$accountingUnit == null : this$accountingUnit.equals(other$accountingUnit)) {
                                             Object this$remark = this.getRemark();
                                             Object other$remark = other.getRemark();
                                             if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                Object this$classifyName = this.getClassifyName();
                                                Object other$classifyName = other.getClassifyName();
                                                if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
                                                   Object this$model = this.getModel();
                                                   Object other$model = other.getModel();
                                                   if (this$model == null ? other$model == null : this$model.equals(other$model)) {
                                                      Object this$width = this.getWidth();
                                                      Object other$width = other.getWidth();
                                                      if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                         Object this$thickness = this.getThickness();
                                                         Object other$thickness = other.getThickness();
                                                         if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                                            Object this$theoryThickness = this.getTheoryThickness();
                                                            Object other$theoryThickness = other.getTheoryThickness();
                                                            if (this$theoryThickness == null
                                                               ? other$theoryThickness == null
                                                               : this$theoryThickness.equals(other$theoryThickness)) {
                                                               Object this$brand = this.getBrand();
                                                               Object other$brand = other.getBrand();
                                                               if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                                                  Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                                                  Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                                                  if (this$heatNoAndBatchNo == null
                                                                     ? other$heatNoAndBatchNo == null
                                                                     : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                                                                     Object this$color = this.getColor();
                                                                     Object other$color = other.getColor();
                                                                     return this$color == null ? other$color == null : this$color.equals(other$color);
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
      return other instanceof SubscribeAuxiliaryWarehouseDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $materialInventoryId = this.getMaterialInventoryId();
      result = result * 59 + ($materialInventoryId == null ? 43 : $materialInventoryId.hashCode());
      Object $outboundDetailId = this.getOutboundDetailId();
      result = result * 59 + ($outboundDetailId == null ? 43 : $outboundDetailId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $accountingPrecision = this.getAccountingPrecision();
      result = result * 59 + ($accountingPrecision == null ? 43 : $accountingPrecision.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $model = this.getModel();
      result = result * 59 + ($model == null ? 43 : $model.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $theoryThickness = this.getTheoryThickness();
      result = result * 59 + ($theoryThickness == null ? 43 : $theoryThickness.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $color = this.getColor();
      return result * 59 + ($color == null ? 43 : $color.hashCode());
   }

   @Override
   public String toString() {
      return "SubscribeAuxiliaryWarehouseDTO(projectId="
         + this.getProjectId()
         + ", materialInventoryId="
         + this.getMaterialInventoryId()
         + ", outboundDetailId="
         + this.getOutboundDetailId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", name="
         + this.getName()
         + ", quantity="
         + this.getQuantity()
         + ", basicClass="
         + this.getBasicClass()
         + ", specification="
         + this.getSpecification()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", mete="
         + this.getMete()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", remark="
         + this.getRemark()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", model="
         + this.getModel()
         + ", width="
         + this.getWidth()
         + ", thickness="
         + this.getThickness()
         + ", theoryThickness="
         + this.getTheoryThickness()
         + ", brand="
         + this.getBrand()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", color="
         + this.getColor()
         + ", accountingPrecision="
         + this.getAccountingPrecision()
         + ")";
   }

   public SubscribeAuxiliaryWarehouseDTO(
      final Long projectId,
      final Long materialInventoryId,
      final Long outboundDetailId,
      final String serialNumber,
      final String name,
      final BigDecimal quantity,
      final Integer basicClass,
      final String specification,
      final String measureUnit,
      final BigDecimal mete,
      final String accountingUnit,
      final String remark,
      final Long classifyId,
      final String classifyName,
      final String model,
      final BigDecimal width,
      final BigDecimal thickness,
      final BigDecimal theoryThickness,
      final String brand,
      final String heatNoAndBatchNo,
      final String color,
      final Integer accountingPrecision
   ) {
      this.projectId = projectId;
      this.materialInventoryId = materialInventoryId;
      this.outboundDetailId = outboundDetailId;
      this.serialNumber = serialNumber;
      this.name = name;
      this.quantity = quantity;
      this.basicClass = basicClass;
      this.specification = specification;
      this.measureUnit = measureUnit;
      this.mete = mete;
      this.accountingUnit = accountingUnit;
      this.remark = remark;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.model = model;
      this.width = width;
      this.thickness = thickness;
      this.theoryThickness = theoryThickness;
      this.brand = brand;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.color = color;
      this.accountingPrecision = accountingPrecision;
   }

   public SubscribeAuxiliaryWarehouseDTO() {
   }

   public static class SubscribeAuxiliaryWarehouseDTOBuilder {
      private Long projectId;
      private Long materialInventoryId;
      private Long outboundDetailId;
      private String serialNumber;
      private String name;
      private BigDecimal quantity;
      private Integer basicClass;
      private String specification;
      private String measureUnit;
      private BigDecimal mete;
      private String accountingUnit;
      private String remark;
      private Long classifyId;
      private String classifyName;
      private String model;
      private BigDecimal width;
      private BigDecimal thickness;
      private BigDecimal theoryThickness;
      private String brand;
      private String heatNoAndBatchNo;
      private String color;
      private Integer accountingPrecision;

      SubscribeAuxiliaryWarehouseDTOBuilder() {
      }

      public SubscribeAuxiliaryWarehouseDTO.SubscribeAuxiliaryWarehouseDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public SubscribeAuxiliaryWarehouseDTO.SubscribeAuxiliaryWarehouseDTOBuilder materialInventoryId(final Long materialInventoryId) {
         this.materialInventoryId = materialInventoryId;
         return this;
      }

      public SubscribeAuxiliaryWarehouseDTO.SubscribeAuxiliaryWarehouseDTOBuilder outboundDetailId(final Long outboundDetailId) {
         this.outboundDetailId = outboundDetailId;
         return this;
      }

      public SubscribeAuxiliaryWarehouseDTO.SubscribeAuxiliaryWarehouseDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public SubscribeAuxiliaryWarehouseDTO.SubscribeAuxiliaryWarehouseDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SubscribeAuxiliaryWarehouseDTO.SubscribeAuxiliaryWarehouseDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public SubscribeAuxiliaryWarehouseDTO.SubscribeAuxiliaryWarehouseDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public SubscribeAuxiliaryWarehouseDTO.SubscribeAuxiliaryWarehouseDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public SubscribeAuxiliaryWarehouseDTO.SubscribeAuxiliaryWarehouseDTOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public SubscribeAuxiliaryWarehouseDTO.SubscribeAuxiliaryWarehouseDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public SubscribeAuxiliaryWarehouseDTO.SubscribeAuxiliaryWarehouseDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public SubscribeAuxiliaryWarehouseDTO.SubscribeAuxiliaryWarehouseDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public SubscribeAuxiliaryWarehouseDTO.SubscribeAuxiliaryWarehouseDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public SubscribeAuxiliaryWarehouseDTO.SubscribeAuxiliaryWarehouseDTOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public SubscribeAuxiliaryWarehouseDTO.SubscribeAuxiliaryWarehouseDTOBuilder model(final String model) {
         this.model = model;
         return this;
      }

      public SubscribeAuxiliaryWarehouseDTO.SubscribeAuxiliaryWarehouseDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public SubscribeAuxiliaryWarehouseDTO.SubscribeAuxiliaryWarehouseDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public SubscribeAuxiliaryWarehouseDTO.SubscribeAuxiliaryWarehouseDTOBuilder theoryThickness(final BigDecimal theoryThickness) {
         this.theoryThickness = theoryThickness;
         return this;
      }

      public SubscribeAuxiliaryWarehouseDTO.SubscribeAuxiliaryWarehouseDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public SubscribeAuxiliaryWarehouseDTO.SubscribeAuxiliaryWarehouseDTOBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      public SubscribeAuxiliaryWarehouseDTO.SubscribeAuxiliaryWarehouseDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public SubscribeAuxiliaryWarehouseDTO.SubscribeAuxiliaryWarehouseDTOBuilder accountingPrecision(final Integer accountingPrecision) {
         this.accountingPrecision = accountingPrecision;
         return this;
      }

      public SubscribeAuxiliaryWarehouseDTO build() {
         return new SubscribeAuxiliaryWarehouseDTO(
            this.projectId,
            this.materialInventoryId,
            this.outboundDetailId,
            this.serialNumber,
            this.name,
            this.quantity,
            this.basicClass,
            this.specification,
            this.measureUnit,
            this.mete,
            this.accountingUnit,
            this.remark,
            this.classifyId,
            this.classifyName,
            this.model,
            this.width,
            this.thickness,
            this.theoryThickness,
            this.brand,
            this.heatNoAndBatchNo,
            this.color,
            this.accountingPrecision
         );
      }

      @Override
      public String toString() {
         return "SubscribeAuxiliaryWarehouseDTO.SubscribeAuxiliaryWarehouseDTOBuilder(projectId="
            + this.projectId
            + ", materialInventoryId="
            + this.materialInventoryId
            + ", outboundDetailId="
            + this.outboundDetailId
            + ", serialNumber="
            + this.serialNumber
            + ", name="
            + this.name
            + ", quantity="
            + this.quantity
            + ", basicClass="
            + this.basicClass
            + ", specification="
            + this.specification
            + ", measureUnit="
            + this.measureUnit
            + ", mete="
            + this.mete
            + ", accountingUnit="
            + this.accountingUnit
            + ", remark="
            + this.remark
            + ", classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
            + ", model="
            + this.model
            + ", width="
            + this.width
            + ", thickness="
            + this.thickness
            + ", theoryThickness="
            + this.theoryThickness
            + ", brand="
            + this.brand
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", color="
            + this.color
            + ", accountingPrecision="
            + this.accountingPrecision
            + ")";
      }
   }
}
