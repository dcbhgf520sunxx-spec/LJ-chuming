package com.hzchum.scim.plan.core.api.pojo.dto.check;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import java.math.BigDecimal;

@ExcelTarget("InventoryExportTemplateDTO")
@ApiModel("清单操作记录-导出DTO")
public class InventoryExportTemplateDTO implements Serializable {
   @Excel(name = "序号", width = 5.0)
   private Integer orderNo;
   @Excel(name = "结构类型", width = 10.0)
   private String structureType;
   @Excel(name = "名称", width = 15.0)
   private String name;
   @Excel(name = "构件编号", width = 18.0)
   private String artifactNo;
   @Excel(name = "单元编号", width = 18.0)
   @ExcelIgnore
   private String elementSn;
   @Excel(name = "零件编号", width = 13.0)
   private String serialNumber;
   @Excel(name = "规格", width = 18.0)
   private String specification;
   @Excel(name = "长度(mm)")
   private BigDecimal length;
   @Excel(name = "材质")
   private String material;
   @Excel(name = "数量")
   private Integer quantity;
   @Excel(name = "单净重(kg)", width = 12.0)
   private BigDecimal netWeight;
   @Excel(name = "总净重(kg)", width = 13.0)
   private BigDecimal totalNetWeight;
   @Excel(name = "单毛重(kg)", width = 12.0)
   private BigDecimal grossWeight;
   @Excel(name = "总毛重(kg)", width = 13.0)
   private BigDecimal totalGrossWeight;
   @Excel(name = "图纸单重(kg)", width = 15.0)
   private BigDecimal drawingWeight;
   @Excel(name = "图纸总重(kg)", width = 15.0)
   private BigDecimal totalDrawingWeight;
   @Excel(name = "单面积(m²)")
   private BigDecimal singleArea;
   @Excel(name = "面积(m²)")
   private BigDecimal surfaceArea;
   @Excel(name = "总面积(m²)")
   private BigDecimal totalSurfaceArea;
   @Excel(name = "上翼缘面积(m²)", width = 18.0)
   private BigDecimal topFlangeArea;
   @Excel(name = "内表面油漆汇总(m2)", width = 14.0)
   private BigDecimal innerPaintArea;
   @Excel(name = "外表面油漆汇总(m2)", width = 14.0)
   private BigDecimal outerPaintArea;
   @Excel(name = "备注", width = 20.0)
   private String remark;
   @Excel(name = "抛丸(Y/N)", replace = {"Y_true", "N_false", "_null"})
   private Boolean boolBlastingEnum;
   @Excel(name = "涂装(Y/N)", replace = {"Y_true", "N_false", "_null"})
   private Boolean boolCoatingEnum;
   @Excel(name = "喷印编码", width = 20.0)
   private String printedCode;

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

   public String getElementSn() {
      return this.elementSn;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
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

   public BigDecimal getSingleArea() {
      return this.singleArea;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public BigDecimal getTotalSurfaceArea() {
      return this.totalSurfaceArea;
   }

   public BigDecimal getTopFlangeArea() {
      return this.topFlangeArea;
   }

   public BigDecimal getInnerPaintArea() {
      return this.innerPaintArea;
   }

   public BigDecimal getOuterPaintArea() {
      return this.outerPaintArea;
   }

   public String getRemark() {
      return this.remark;
   }

   public Boolean getBoolBlastingEnum() {
      return this.boolBlastingEnum;
   }

   public Boolean getBoolCoatingEnum() {
      return this.boolCoatingEnum;
   }

   public String getPrintedCode() {
      return this.printedCode;
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

   public void setElementSn(final String elementSn) {
      this.elementSn = elementSn;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
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

   public void setSingleArea(final BigDecimal singleArea) {
      this.singleArea = singleArea;
   }

   public void setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
   }

   public void setTotalSurfaceArea(final BigDecimal totalSurfaceArea) {
      this.totalSurfaceArea = totalSurfaceArea;
   }

   public void setTopFlangeArea(final BigDecimal topFlangeArea) {
      this.topFlangeArea = topFlangeArea;
   }

   public void setInnerPaintArea(final BigDecimal innerPaintArea) {
      this.innerPaintArea = innerPaintArea;
   }

   public void setOuterPaintArea(final BigDecimal outerPaintArea) {
      this.outerPaintArea = outerPaintArea;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setBoolBlastingEnum(final Boolean boolBlastingEnum) {
      this.boolBlastingEnum = boolBlastingEnum;
   }

   public void setBoolCoatingEnum(final Boolean boolCoatingEnum) {
      this.boolCoatingEnum = boolCoatingEnum;
   }

   public void setPrintedCode(final String printedCode) {
      this.printedCode = printedCode;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InventoryExportTemplateDTO)) {
         return false;
      }

      InventoryExportTemplateDTO other = (InventoryExportTemplateDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$orderNo = this.getOrderNo();
      Object other$orderNo = other.getOrderNo();
      if (this$orderNo == null ? other$orderNo == null : this$orderNo.equals(other$orderNo)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$boolBlastingEnum = this.getBoolBlastingEnum();
            Object other$boolBlastingEnum = other.getBoolBlastingEnum();
            if (this$boolBlastingEnum == null ? other$boolBlastingEnum == null : this$boolBlastingEnum.equals(other$boolBlastingEnum)) {
               Object this$boolCoatingEnum = this.getBoolCoatingEnum();
               Object other$boolCoatingEnum = other.getBoolCoatingEnum();
               if (this$boolCoatingEnum == null ? other$boolCoatingEnum == null : this$boolCoatingEnum.equals(other$boolCoatingEnum)) {
                  Object this$structureType = this.getStructureType();
                  Object other$structureType = other.getStructureType();
                  if (this$structureType == null ? other$structureType == null : this$structureType.equals(other$structureType)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                        Object this$artifactNo = this.getArtifactNo();
                        Object other$artifactNo = other.getArtifactNo();
                        if (this$artifactNo == null ? other$artifactNo == null : this$artifactNo.equals(other$artifactNo)) {
                           Object this$elementSn = this.getElementSn();
                           Object other$elementSn = other.getElementSn();
                           if (this$elementSn == null ? other$elementSn == null : this$elementSn.equals(other$elementSn)) {
                              Object this$serialNumber = this.getSerialNumber();
                              Object other$serialNumber = other.getSerialNumber();
                              if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                 Object this$specification = this.getSpecification();
                                 Object other$specification = other.getSpecification();
                                 if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                    Object this$length = this.getLength();
                                    Object other$length = other.getLength();
                                    if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                       Object this$material = this.getMaterial();
                                       Object other$material = other.getMaterial();
                                       if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                          Object this$netWeight = this.getNetWeight();
                                          Object other$netWeight = other.getNetWeight();
                                          if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                             Object this$totalNetWeight = this.getTotalNetWeight();
                                             Object other$totalNetWeight = other.getTotalNetWeight();
                                             if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
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
                                                            Object this$singleArea = this.getSingleArea();
                                                            Object other$singleArea = other.getSingleArea();
                                                            if (this$singleArea == null ? other$singleArea == null : this$singleArea.equals(other$singleArea)) {
                                                               Object this$surfaceArea = this.getSurfaceArea();
                                                               Object other$surfaceArea = other.getSurfaceArea();
                                                               if (this$surfaceArea == null
                                                                  ? other$surfaceArea == null
                                                                  : this$surfaceArea.equals(other$surfaceArea)) {
                                                                  Object this$totalSurfaceArea = this.getTotalSurfaceArea();
                                                                  Object other$totalSurfaceArea = other.getTotalSurfaceArea();
                                                                  if (this$totalSurfaceArea == null
                                                                     ? other$totalSurfaceArea == null
                                                                     : this$totalSurfaceArea.equals(other$totalSurfaceArea)) {
                                                                     Object this$topFlangeArea = this.getTopFlangeArea();
                                                                     Object other$topFlangeArea = other.getTopFlangeArea();
                                                                     if (this$topFlangeArea == null
                                                                        ? other$topFlangeArea == null
                                                                        : this$topFlangeArea.equals(other$topFlangeArea)) {
                                                                        Object this$innerPaintArea = this.getInnerPaintArea();
                                                                        Object other$innerPaintArea = other.getInnerPaintArea();
                                                                        if (this$innerPaintArea == null
                                                                           ? other$innerPaintArea == null
                                                                           : this$innerPaintArea.equals(other$innerPaintArea)) {
                                                                           Object this$outerPaintArea = this.getOuterPaintArea();
                                                                           Object other$outerPaintArea = other.getOuterPaintArea();
                                                                           if (this$outerPaintArea == null
                                                                              ? other$outerPaintArea == null
                                                                              : this$outerPaintArea.equals(other$outerPaintArea)) {
                                                                              Object this$remark = this.getRemark();
                                                                              Object other$remark = other.getRemark();
                                                                              if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)
                                                                                 )
                                                                               {
                                                                                 Object this$printedCode = this.getPrintedCode();
                                                                                 Object other$printedCode = other.getPrintedCode();
                                                                                 return this$printedCode == null
                                                                                    ? other$printedCode == null
                                                                                    : this$printedCode.equals(other$printedCode);
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
      return other instanceof InventoryExportTemplateDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderNo = this.getOrderNo();
      result = result * 59 + ($orderNo == null ? 43 : $orderNo.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $boolBlastingEnum = this.getBoolBlastingEnum();
      result = result * 59 + ($boolBlastingEnum == null ? 43 : $boolBlastingEnum.hashCode());
      Object $boolCoatingEnum = this.getBoolCoatingEnum();
      result = result * 59 + ($boolCoatingEnum == null ? 43 : $boolCoatingEnum.hashCode());
      Object $structureType = this.getStructureType();
      result = result * 59 + ($structureType == null ? 43 : $structureType.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $artifactNo = this.getArtifactNo();
      result = result * 59 + ($artifactNo == null ? 43 : $artifactNo.hashCode());
      Object $elementSn = this.getElementSn();
      result = result * 59 + ($elementSn == null ? 43 : $elementSn.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
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
      Object $singleArea = this.getSingleArea();
      result = result * 59 + ($singleArea == null ? 43 : $singleArea.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $totalSurfaceArea = this.getTotalSurfaceArea();
      result = result * 59 + ($totalSurfaceArea == null ? 43 : $totalSurfaceArea.hashCode());
      Object $topFlangeArea = this.getTopFlangeArea();
      result = result * 59 + ($topFlangeArea == null ? 43 : $topFlangeArea.hashCode());
      Object $innerPaintArea = this.getInnerPaintArea();
      result = result * 59 + ($innerPaintArea == null ? 43 : $innerPaintArea.hashCode());
      Object $outerPaintArea = this.getOuterPaintArea();
      result = result * 59 + ($outerPaintArea == null ? 43 : $outerPaintArea.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $printedCode = this.getPrintedCode();
      return result * 59 + ($printedCode == null ? 43 : $printedCode.hashCode());
   }

   @Override
   public String toString() {
      return "InventoryExportTemplateDTO(orderNo="
         + this.getOrderNo()
         + ", structureType="
         + this.getStructureType()
         + ", name="
         + this.getName()
         + ", artifactNo="
         + this.getArtifactNo()
         + ", elementSn="
         + this.getElementSn()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", material="
         + this.getMaterial()
         + ", quantity="
         + this.getQuantity()
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
         + ", singleArea="
         + this.getSingleArea()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", totalSurfaceArea="
         + this.getTotalSurfaceArea()
         + ", topFlangeArea="
         + this.getTopFlangeArea()
         + ", innerPaintArea="
         + this.getInnerPaintArea()
         + ", outerPaintArea="
         + this.getOuterPaintArea()
         + ", remark="
         + this.getRemark()
         + ", boolBlastingEnum="
         + this.getBoolBlastingEnum()
         + ", boolCoatingEnum="
         + this.getBoolCoatingEnum()
         + ", printedCode="
         + this.getPrintedCode()
         + ")";
   }
}
