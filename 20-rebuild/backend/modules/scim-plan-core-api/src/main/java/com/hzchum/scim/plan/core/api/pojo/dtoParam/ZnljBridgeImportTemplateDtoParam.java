package com.hzchum.scim.plan.core.api.pojo.dtoParam;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import java.io.Serializable;
import java.math.BigDecimal;

@ExcelTarget("ZnljBridgeMachinePartImportTemplateDtoParam")
public class ZnljBridgeImportTemplateDtoParam implements Serializable {
   @Excel(name = "序号")
   private Integer orderNo;
   @Excel(name = "构件编号")
   private String artifactNo;
   @Excel(name = "单元件编号")
   private String elementNo;
   @Excel(name = "零件编号")
   private String serialNumber;
   @Excel(name = "名称")
   private String name;
   @Excel(name = "规格")
   private String specification;
   @Excel(name = "厚度(mm)")
   private BigDecimal thickness;
   @Excel(name = "宽度(mm)")
   private BigDecimal width;
   @Excel(name = "长度(mm)")
   private BigDecimal length;
   @Excel(name = "数量")
   private Integer quantity;
   @Excel(name = "材质")
   private String material;
   @Excel(name = "结构类型")
   private String structureType;
   @Excel(name = "单净重(kg)")
   private BigDecimal netWeight;
   @Excel(name = "总净重(kg)")
   private BigDecimal totalNetWeight;
   @Excel(name = "单毛重(kg)")
   private BigDecimal grossWeight;
   @Excel(name = "总毛重(kg)")
   private BigDecimal totalGrossWeight;
   @Excel(name = "桥顶面油漆汇总(m2)")
   private BigDecimal totalTopPaintArea;
   @Excel(name = "内表面油漆汇总(m2)")
   private BigDecimal totalInnerPaintArea;
   @Excel(name = "外表面油漆汇总(m2)")
   private BigDecimal totalOuterPaintArea;
   @Excel(name = "U肋油漆汇总(m2)")
   private BigDecimal totalURibPaintArea;
   @Excel(name = "备注")
   private String remark;
   @Excel(name = "涂装(Y/N)", orderNum = "17", replace = {"Y_true", "N_false"})
   private Boolean boolCoatingEnum;
   private String specPrefix;

   public Integer getOrderNo() {
      return this.orderNo;
   }

   public String getArtifactNo() {
      return this.artifactNo;
   }

   public String getElementNo() {
      return this.elementNo;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getName() {
      return this.name;
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

   public Integer getQuantity() {
      return this.quantity;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getStructureType() {
      return this.structureType;
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

   public BigDecimal getTotalTopPaintArea() {
      return this.totalTopPaintArea;
   }

   public BigDecimal getTotalInnerPaintArea() {
      return this.totalInnerPaintArea;
   }

   public BigDecimal getTotalOuterPaintArea() {
      return this.totalOuterPaintArea;
   }

   public BigDecimal getTotalURibPaintArea() {
      return this.totalURibPaintArea;
   }

   public String getRemark() {
      return this.remark;
   }

   public Boolean getBoolCoatingEnum() {
      return this.boolCoatingEnum;
   }

   public String getSpecPrefix() {
      return this.specPrefix;
   }

   public void setOrderNo(final Integer orderNo) {
      this.orderNo = orderNo;
   }

   public void setArtifactNo(final String artifactNo) {
      this.artifactNo = artifactNo;
   }

   public void setElementNo(final String elementNo) {
      this.elementNo = elementNo;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setName(final String name) {
      this.name = name;
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

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setStructureType(final String structureType) {
      this.structureType = structureType;
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

   public void setTotalTopPaintArea(final BigDecimal totalTopPaintArea) {
      this.totalTopPaintArea = totalTopPaintArea;
   }

   public void setTotalInnerPaintArea(final BigDecimal totalInnerPaintArea) {
      this.totalInnerPaintArea = totalInnerPaintArea;
   }

   public void setTotalOuterPaintArea(final BigDecimal totalOuterPaintArea) {
      this.totalOuterPaintArea = totalOuterPaintArea;
   }

   public void setTotalURibPaintArea(final BigDecimal totalURibPaintArea) {
      this.totalURibPaintArea = totalURibPaintArea;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setBoolCoatingEnum(final Boolean boolCoatingEnum) {
      this.boolCoatingEnum = boolCoatingEnum;
   }

   public void setSpecPrefix(final String specPrefix) {
      this.specPrefix = specPrefix;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ZnljBridgeImportTemplateDtoParam)) {
         return false;
      }

      ZnljBridgeImportTemplateDtoParam other = (ZnljBridgeImportTemplateDtoParam)o;
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
               Object this$artifactNo = this.getArtifactNo();
               Object other$artifactNo = other.getArtifactNo();
               if (this$artifactNo == null ? other$artifactNo == null : this$artifactNo.equals(other$artifactNo)) {
                  Object this$elementNo = this.getElementNo();
                  Object other$elementNo = other.getElementNo();
                  if (this$elementNo == null ? other$elementNo == null : this$elementNo.equals(other$elementNo)) {
                     Object this$serialNumber = this.getSerialNumber();
                     Object other$serialNumber = other.getSerialNumber();
                     if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                        Object this$name = this.getName();
                        Object other$name = other.getName();
                        if (this$name == null ? other$name == null : this$name.equals(other$name)) {
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
                                          Object this$structureType = this.getStructureType();
                                          Object other$structureType = other.getStructureType();
                                          if (this$structureType == null ? other$structureType == null : this$structureType.equals(other$structureType)) {
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
                                                         Object this$totalTopPaintArea = this.getTotalTopPaintArea();
                                                         Object other$totalTopPaintArea = other.getTotalTopPaintArea();
                                                         if (this$totalTopPaintArea == null
                                                            ? other$totalTopPaintArea == null
                                                            : this$totalTopPaintArea.equals(other$totalTopPaintArea)) {
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
                                                                  Object this$totalURibPaintArea = this.getTotalURibPaintArea();
                                                                  Object other$totalURibPaintArea = other.getTotalURibPaintArea();
                                                                  if (this$totalURibPaintArea == null
                                                                     ? other$totalURibPaintArea == null
                                                                     : this$totalURibPaintArea.equals(other$totalURibPaintArea)) {
                                                                     Object this$remark = this.getRemark();
                                                                     Object other$remark = other.getRemark();
                                                                     if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ZnljBridgeImportTemplateDtoParam;
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
      Object $artifactNo = this.getArtifactNo();
      result = result * 59 + ($artifactNo == null ? 43 : $artifactNo.hashCode());
      Object $elementNo = this.getElementNo();
      result = result * 59 + ($elementNo == null ? 43 : $elementNo.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
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
      Object $structureType = this.getStructureType();
      result = result * 59 + ($structureType == null ? 43 : $structureType.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $totalTopPaintArea = this.getTotalTopPaintArea();
      result = result * 59 + ($totalTopPaintArea == null ? 43 : $totalTopPaintArea.hashCode());
      Object $totalInnerPaintArea = this.getTotalInnerPaintArea();
      result = result * 59 + ($totalInnerPaintArea == null ? 43 : $totalInnerPaintArea.hashCode());
      Object $totalOuterPaintArea = this.getTotalOuterPaintArea();
      result = result * 59 + ($totalOuterPaintArea == null ? 43 : $totalOuterPaintArea.hashCode());
      Object $totalURibPaintArea = this.getTotalURibPaintArea();
      result = result * 59 + ($totalURibPaintArea == null ? 43 : $totalURibPaintArea.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $specPrefix = this.getSpecPrefix();
      return result * 59 + ($specPrefix == null ? 43 : $specPrefix.hashCode());
   }

   @Override
   public String toString() {
      return "ZnljBridgeImportTemplateDtoParam(orderNo="
         + this.getOrderNo()
         + ", artifactNo="
         + this.getArtifactNo()
         + ", elementNo="
         + this.getElementNo()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", name="
         + this.getName()
         + ", specification="
         + this.getSpecification()
         + ", thickness="
         + this.getThickness()
         + ", width="
         + this.getWidth()
         + ", length="
         + this.getLength()
         + ", quantity="
         + this.getQuantity()
         + ", material="
         + this.getMaterial()
         + ", structureType="
         + this.getStructureType()
         + ", netWeight="
         + this.getNetWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", totalTopPaintArea="
         + this.getTotalTopPaintArea()
         + ", totalInnerPaintArea="
         + this.getTotalInnerPaintArea()
         + ", totalOuterPaintArea="
         + this.getTotalOuterPaintArea()
         + ", totalURibPaintArea="
         + this.getTotalURibPaintArea()
         + ", remark="
         + this.getRemark()
         + ", boolCoatingEnum="
         + this.getBoolCoatingEnum()
         + ", specPrefix="
         + this.getSpecPrefix()
         + ")";
   }
}
