package com.hzchum.scim.plan.core.api.pojo.dtoParam;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;

@ExcelTarget("ZnljArtifactMachinePartImportTemplateDtoParam")
public class ZnljArtifactMachinePartImportTemplateDtoParam implements Serializable {
   @Excel(name = "序号")
   private Integer orderNo;
   @Excel(name = "结构类型")
   private String structureType;
   @Excel(name = "名称")
   private String name;
   @Excel(name = "构件编号")
   private String artifactNo;
   @Excel(name = "零件编号")
   private String serialNumber;
   @Excel(name = "规格")
   private String specification;
   @Excel(name = "厚度(mm)")
   private BigDecimal thickness;
   @Excel(name = "宽度(mm)")
   private BigDecimal width;
   @Excel(name = "长度(mm)")
   private BigDecimal length;
   @Excel(name = "材质")
   private String material;
   @Excel(name = "数量")
   private Integer quantity;
   @Excel(name = "识别码")
   private String recognitionCode;
   @Excel(name = "单净重(kg)")
   private BigDecimal netWeight;
   @Excel(name = "总净重(kg)")
   private BigDecimal totalNetWeight;
   @Excel(name = "单毛重(kg)")
   private BigDecimal grossWeight;
   @Excel(name = "总毛重(kg)")
   private BigDecimal totalGrossWeight;
   @Excel(name = "图纸单重(kg)")
   private BigDecimal drawingWeight;
   @Excel(name = "图纸总重(kg)")
   private BigDecimal totalDrawingWeight;
   @Excel(name = "面积(m²)")
   private BigDecimal surfaceArea;
   @Excel(name = "面积(m2)")
   private BigDecimal surfaceArea2;
   @Excel(name = "面积(㎡)")
   private BigDecimal surfaceArea3;
   @Excel(name = "上翼缘面积(㎡)")
   private BigDecimal topFlangeArea;
   @Excel(name = "上翼缘面积(m2)")
   private BigDecimal topFlangeArea2;
   @Excel(name = "上翼缘面积(m²)")
   private BigDecimal topFlangeArea3;
   @Excel(name = "备注")
   private String remark;
   @Excel(name = "内表面油漆汇总(m2)")
   private BigDecimal totalInnerPaintArea;
   @Excel(name = "外表面油漆汇总(m2)")
   private BigDecimal totalOuterPaintArea;
   @Excel(name = "涂装(Y/N)", orderNum = "17", replace = {"Y_true", "N_false"})
   private Boolean boolCoatingEnum;
   private String specPrefix;
   @ApiModelProperty(name = "steelPlateTypeEnum", value = "零件类型 1.零件板 2.翼腹板 4成品型材 ")
   private Integer steelPlateTypeEnum;

   public Integer getOrderNo() {
      return this.orderNo;
   }

   public String getStructureType() {
      return this.structureType;
   }

   public String getName() {
      return this.name;
   }

   public String getArtifactNo() {
      return this.artifactNo;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
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

   public String getMaterial() {
      return this.material;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public String getRecognitionCode() {
      return this.recognitionCode;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public BigDecimal getDrawingWeight() {
      return this.drawingWeight;
   }

   public BigDecimal getTotalDrawingWeight() {
      return this.totalDrawingWeight;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public BigDecimal getSurfaceArea2() {
      return this.surfaceArea2;
   }

   public BigDecimal getSurfaceArea3() {
      return this.surfaceArea3;
   }

   public BigDecimal getTopFlangeArea() {
      return this.topFlangeArea;
   }

   public BigDecimal getTopFlangeArea2() {
      return this.topFlangeArea2;
   }

   public BigDecimal getTopFlangeArea3() {
      return this.topFlangeArea3;
   }

   public String getRemark() {
      return this.remark;
   }

   public BigDecimal getTotalInnerPaintArea() {
      return this.totalInnerPaintArea;
   }

   public BigDecimal getTotalOuterPaintArea() {
      return this.totalOuterPaintArea;
   }

   public Boolean getBoolCoatingEnum() {
      return this.boolCoatingEnum;
   }

   public String getSpecPrefix() {
      return this.specPrefix;
   }

   public Integer getSteelPlateTypeEnum() {
      return this.steelPlateTypeEnum;
   }

   public void setOrderNo(final Integer orderNo) {
      this.orderNo = orderNo;
   }

   public void setStructureType(final String structureType) {
      this.structureType = structureType;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setArtifactNo(final String artifactNo) {
      this.artifactNo = artifactNo;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
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

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setRecognitionCode(final String recognitionCode) {
      this.recognitionCode = recognitionCode;
   }

   public void setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
   }

   public void setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
   }

   public void setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
   }

   public void setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
   }

   public void setDrawingWeight(final BigDecimal drawingWeight) {
      this.drawingWeight = drawingWeight;
   }

   public void setTotalDrawingWeight(final BigDecimal totalDrawingWeight) {
      this.totalDrawingWeight = totalDrawingWeight;
   }

   public void setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
   }

   public void setSurfaceArea2(final BigDecimal surfaceArea2) {
      this.surfaceArea2 = surfaceArea2;
   }

   public void setSurfaceArea3(final BigDecimal surfaceArea3) {
      this.surfaceArea3 = surfaceArea3;
   }

   public void setTopFlangeArea(final BigDecimal topFlangeArea) {
      this.topFlangeArea = topFlangeArea;
   }

   public void setTopFlangeArea2(final BigDecimal topFlangeArea2) {
      this.topFlangeArea2 = topFlangeArea2;
   }

   public void setTopFlangeArea3(final BigDecimal topFlangeArea3) {
      this.topFlangeArea3 = topFlangeArea3;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setTotalInnerPaintArea(final BigDecimal totalInnerPaintArea) {
      this.totalInnerPaintArea = totalInnerPaintArea;
   }

   public void setTotalOuterPaintArea(final BigDecimal totalOuterPaintArea) {
      this.totalOuterPaintArea = totalOuterPaintArea;
   }

   public void setBoolCoatingEnum(final Boolean boolCoatingEnum) {
      this.boolCoatingEnum = boolCoatingEnum;
   }

   public void setSpecPrefix(final String specPrefix) {
      this.specPrefix = specPrefix;
   }

   public void setSteelPlateTypeEnum(final Integer steelPlateTypeEnum) {
      this.steelPlateTypeEnum = steelPlateTypeEnum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ZnljArtifactMachinePartImportTemplateDtoParam)) {
         return false;
      }

      ZnljArtifactMachinePartImportTemplateDtoParam other = (ZnljArtifactMachinePartImportTemplateDtoParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$orderNo = this.getOrderNo();
      Object other$orderNo = other.getOrderNo();
      if (this$orderNo == null ? other$orderNo == null : this$orderNo.equals(other$orderNo)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$boolCoatingEnum = this.getBoolCoatingEnum();
            Object other$boolCoatingEnum = other.getBoolCoatingEnum();
            if (this$boolCoatingEnum == null ? other$boolCoatingEnum == null : this$boolCoatingEnum.equals(other$boolCoatingEnum)) {
               Object this$steelPlateTypeEnum = this.getSteelPlateTypeEnum();
               Object other$steelPlateTypeEnum = other.getSteelPlateTypeEnum();
               if (this$steelPlateTypeEnum == null ? other$steelPlateTypeEnum == null : this$steelPlateTypeEnum.equals(other$steelPlateTypeEnum)) {
                  Object this$structureType = this.getStructureType();
                  Object other$structureType = other.getStructureType();
                  if (this$structureType == null ? other$structureType == null : this$structureType.equals(other$structureType)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                        Object this$artifactNo = this.getArtifactNo();
                        Object other$artifactNo = other.getArtifactNo();
                        if (this$artifactNo == null ? other$artifactNo == null : this$artifactNo.equals(other$artifactNo)) {
                           Object this$serialNumber = this.getSerialNumber();
                           Object other$serialNumber = other.getSerialNumber();
                           if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                              Object this$specification = this.getSpecification();
                              Object other$specification = other.getSpecification();
                              if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                 Object this$thickness = this.getThickness();
                                 Object other$thickness = other.getThickness();
                                 if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                    Object this$width = this.getWidth();
                                    Object other$width = other.getWidth();
                                    if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                       Object this$length = this.getLength();
                                       Object other$length = other.getLength();
                                       if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                          Object this$material = this.getMaterial();
                                          Object other$material = other.getMaterial();
                                          if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                             Object this$recognitionCode = this.getRecognitionCode();
                                             Object other$recognitionCode = other.getRecognitionCode();
                                             if (this$recognitionCode == null
                                                ? other$recognitionCode == null
                                                : this$recognitionCode.equals(other$recognitionCode)) {
                                                Object this$netWeight = this.getNetWeight();
                                                Object other$netWeight = other.getNetWeight();
                                                if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                                   Object this$totalNetWeight = this.getTotalNetWeight();
                                                   Object other$totalNetWeight = other.getTotalNetWeight();
                                                   if (this$totalNetWeight == null
                                                      ? other$totalNetWeight == null
                                                      : this$totalNetWeight.equals(other$totalNetWeight)) {
                                                      Object this$grossWeight = this.getGrossWeight();
                                                      Object other$grossWeight = other.getGrossWeight();
                                                      if (this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight)) {
                                                         Object this$totalGrossWeight = this.getTotalGrossWeight();
                                                         Object other$totalGrossWeight = other.getTotalGrossWeight();
                                                         if (this$totalGrossWeight == null
                                                            ? other$totalGrossWeight == null
                                                            : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                                                            Object this$drawingWeight = this.getDrawingWeight();
                                                            Object other$drawingWeight = other.getDrawingWeight();
                                                            if (this$drawingWeight == null
                                                               ? other$drawingWeight == null
                                                               : this$drawingWeight.equals(other$drawingWeight)) {
                                                               Object this$totalDrawingWeight = this.getTotalDrawingWeight();
                                                               Object other$totalDrawingWeight = other.getTotalDrawingWeight();
                                                               if (this$totalDrawingWeight == null
                                                                  ? other$totalDrawingWeight == null
                                                                  : this$totalDrawingWeight.equals(other$totalDrawingWeight)) {
                                                                  Object this$surfaceArea = this.getSurfaceArea();
                                                                  Object other$surfaceArea = other.getSurfaceArea();
                                                                  if (this$surfaceArea == null
                                                                     ? other$surfaceArea == null
                                                                     : this$surfaceArea.equals(other$surfaceArea)) {
                                                                     Object this$surfaceArea2 = this.getSurfaceArea2();
                                                                     Object other$surfaceArea2 = other.getSurfaceArea2();
                                                                     if (this$surfaceArea2 == null
                                                                        ? other$surfaceArea2 == null
                                                                        : this$surfaceArea2.equals(other$surfaceArea2)) {
                                                                        Object this$surfaceArea3 = this.getSurfaceArea3();
                                                                        Object other$surfaceArea3 = other.getSurfaceArea3();
                                                                        if (this$surfaceArea3 == null
                                                                           ? other$surfaceArea3 == null
                                                                           : this$surfaceArea3.equals(other$surfaceArea3)) {
                                                                           Object this$topFlangeArea = this.getTopFlangeArea();
                                                                           Object other$topFlangeArea = other.getTopFlangeArea();
                                                                           if (this$topFlangeArea == null
                                                                              ? other$topFlangeArea == null
                                                                              : this$topFlangeArea.equals(other$topFlangeArea)) {
                                                                              Object this$topFlangeArea2 = this.getTopFlangeArea2();
                                                                              Object other$topFlangeArea2 = other.getTopFlangeArea2();
                                                                              if (this$topFlangeArea2 == null
                                                                                 ? other$topFlangeArea2 == null
                                                                                 : this$topFlangeArea2.equals(other$topFlangeArea2)) {
                                                                                 Object this$topFlangeArea3 = this.getTopFlangeArea3();
                                                                                 Object other$topFlangeArea3 = other.getTopFlangeArea3();
                                                                                 if (this$topFlangeArea3 == null
                                                                                    ? other$topFlangeArea3 == null
                                                                                    : this$topFlangeArea3.equals(other$topFlangeArea3)) {
                                                                                    Object this$remark = this.getRemark();
                                                                                    Object other$remark = other.getRemark();
                                                                                    if (this$remark == null
                                                                                       ? other$remark == null
                                                                                       : this$remark.equals(other$remark)) {
                                                                                       Object this$totalInnerPaintArea = this.getTotalInnerPaintArea();
                                                                                       Object other$totalInnerPaintArea = other.getTotalInnerPaintArea();
                                                                                       if (this$totalInnerPaintArea == null
                                                                                          ? other$totalInnerPaintArea == null
                                                                                          : this$totalInnerPaintArea.equals(other$totalInnerPaintArea)) {
                                                                                          Object this$totalOuterPaintArea = this.getTotalOuterPaintArea();
                                                                                          Object other$totalOuterPaintArea = other.getTotalOuterPaintArea();
                                                                                          if (this$totalOuterPaintArea == null
                                                                                             ? other$totalOuterPaintArea == null
                                                                                             : this$totalOuterPaintArea.equals(other$totalOuterPaintArea)) {
                                                                                             Object this$specPrefix = this.getSpecPrefix();
                                                                                             Object other$specPrefix = other.getSpecPrefix();
                                                                                             return this$specPrefix == null
                                                                                                ? other$specPrefix == null
                                                                                                : this$specPrefix.equals(other$specPrefix);
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
      return other instanceof ZnljArtifactMachinePartImportTemplateDtoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderNo = this.getOrderNo();
      result = result * 59 + ($orderNo == null ? 43 : $orderNo.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $boolCoatingEnum = this.getBoolCoatingEnum();
      result = result * 59 + ($boolCoatingEnum == null ? 43 : $boolCoatingEnum.hashCode());
      Object $steelPlateTypeEnum = this.getSteelPlateTypeEnum();
      result = result * 59 + ($steelPlateTypeEnum == null ? 43 : $steelPlateTypeEnum.hashCode());
      Object $structureType = this.getStructureType();
      result = result * 59 + ($structureType == null ? 43 : $structureType.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $artifactNo = this.getArtifactNo();
      result = result * 59 + ($artifactNo == null ? 43 : $artifactNo.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $recognitionCode = this.getRecognitionCode();
      result = result * 59 + ($recognitionCode == null ? 43 : $recognitionCode.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $drawingWeight = this.getDrawingWeight();
      result = result * 59 + ($drawingWeight == null ? 43 : $drawingWeight.hashCode());
      Object $totalDrawingWeight = this.getTotalDrawingWeight();
      result = result * 59 + ($totalDrawingWeight == null ? 43 : $totalDrawingWeight.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $surfaceArea2 = this.getSurfaceArea2();
      result = result * 59 + ($surfaceArea2 == null ? 43 : $surfaceArea2.hashCode());
      Object $surfaceArea3 = this.getSurfaceArea3();
      result = result * 59 + ($surfaceArea3 == null ? 43 : $surfaceArea3.hashCode());
      Object $topFlangeArea = this.getTopFlangeArea();
      result = result * 59 + ($topFlangeArea == null ? 43 : $topFlangeArea.hashCode());
      Object $topFlangeArea2 = this.getTopFlangeArea2();
      result = result * 59 + ($topFlangeArea2 == null ? 43 : $topFlangeArea2.hashCode());
      Object $topFlangeArea3 = this.getTopFlangeArea3();
      result = result * 59 + ($topFlangeArea3 == null ? 43 : $topFlangeArea3.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $totalInnerPaintArea = this.getTotalInnerPaintArea();
      result = result * 59 + ($totalInnerPaintArea == null ? 43 : $totalInnerPaintArea.hashCode());
      Object $totalOuterPaintArea = this.getTotalOuterPaintArea();
      result = result * 59 + ($totalOuterPaintArea == null ? 43 : $totalOuterPaintArea.hashCode());
      Object $specPrefix = this.getSpecPrefix();
      return result * 59 + ($specPrefix == null ? 43 : $specPrefix.hashCode());
   }

   @Override
   public String toString() {
      return "ZnljArtifactMachinePartImportTemplateDtoParam(orderNo="
         + this.getOrderNo()
         + ", structureType="
         + this.getStructureType()
         + ", name="
         + this.getName()
         + ", artifactNo="
         + this.getArtifactNo()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", thickness="
         + this.getThickness()
         + ", width="
         + this.getWidth()
         + ", length="
         + this.getLength()
         + ", material="
         + this.getMaterial()
         + ", quantity="
         + this.getQuantity()
         + ", recognitionCode="
         + this.getRecognitionCode()
         + ", netWeight="
         + this.getNetWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", drawingWeight="
         + this.getDrawingWeight()
         + ", totalDrawingWeight="
         + this.getTotalDrawingWeight()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", surfaceArea2="
         + this.getSurfaceArea2()
         + ", surfaceArea3="
         + this.getSurfaceArea3()
         + ", topFlangeArea="
         + this.getTopFlangeArea()
         + ", topFlangeArea2="
         + this.getTopFlangeArea2()
         + ", topFlangeArea3="
         + this.getTopFlangeArea3()
         + ", remark="
         + this.getRemark()
         + ", totalInnerPaintArea="
         + this.getTotalInnerPaintArea()
         + ", totalOuterPaintArea="
         + this.getTotalOuterPaintArea()
         + ", boolCoatingEnum="
         + this.getBoolCoatingEnum()
         + ", specPrefix="
         + this.getSpecPrefix()
         + ", steelPlateTypeEnum="
         + this.getSteelPlateTypeEnum()
         + ")";
   }
}
