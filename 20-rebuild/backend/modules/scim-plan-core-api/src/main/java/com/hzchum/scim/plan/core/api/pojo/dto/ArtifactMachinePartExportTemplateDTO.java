package com.hzchum.scim.plan.core.api.pojo.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import java.io.Serializable;
import java.math.BigDecimal;

@ExcelTarget("ArtifactMachinePartExportTemplateDTO")
public class ArtifactMachinePartExportTemplateDTO implements Serializable {
   @Excel(name = "序号", width = 5.0)
   private Integer orderNo;
   @Excel(name = "结构类型", width = 10.0)
   private String structureType;
   @Excel(name = "名称", width = 15.0)
   private String name;
   @Excel(name = "构件编号", width = 18.0)
   private String artifactNo;
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
   @Excel(name = "面积(m²)")
   private BigDecimal surfaceArea;
   @Excel(name = "上翼缘面积(m²)", width = 18.0)
   private BigDecimal topFlangeArea;
   @Excel(name = "备注", width = 20.0)
   private String remark;
   @Excel(name = "抛丸(Y/N)", replace = {"Y_true", "N_false", "_null"})
   private Boolean boolBlastingEnum;
   @Excel(name = "总面积(m²)")
   private BigDecimal totalSurfaceArea;

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

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public BigDecimal getTopFlangeArea() {
      return this.topFlangeArea;
   }

   public String getRemark() {
      return this.remark;
   }

   public Boolean getBoolBlastingEnum() {
      return this.boolBlastingEnum;
   }

   public BigDecimal getTotalSurfaceArea() {
      return this.totalSurfaceArea;
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

   public void setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
   }

   public void setTopFlangeArea(final BigDecimal topFlangeArea) {
      this.topFlangeArea = topFlangeArea;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setBoolBlastingEnum(final Boolean boolBlastingEnum) {
      this.boolBlastingEnum = boolBlastingEnum;
   }

   public void setTotalSurfaceArea(final BigDecimal totalSurfaceArea) {
      this.totalSurfaceArea = totalSurfaceArea;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactMachinePartExportTemplateDTO)) {
         return false;
      }

      ArtifactMachinePartExportTemplateDTO other = (ArtifactMachinePartExportTemplateDTO)o;
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
                                                if (this$drawingWeight == null ? other$drawingWeight == null : this$drawingWeight.equals(other$drawingWeight)) {
                                                   Object this$totalDrawingWeight = this.getTotalDrawingWeight();
                                                   Object other$totalDrawingWeight = other.getTotalDrawingWeight();
                                                   if (this$totalDrawingWeight == null
                                                      ? other$totalDrawingWeight == null
                                                      : this$totalDrawingWeight.equals(other$totalDrawingWeight)) {
                                                      Object this$surfaceArea = this.getSurfaceArea();
                                                      Object other$surfaceArea = other.getSurfaceArea();
                                                      if (this$surfaceArea == null ? other$surfaceArea == null : this$surfaceArea.equals(other$surfaceArea)) {
                                                         Object this$topFlangeArea = this.getTopFlangeArea();
                                                         Object other$topFlangeArea = other.getTopFlangeArea();
                                                         if (this$topFlangeArea == null
                                                            ? other$topFlangeArea == null
                                                            : this$topFlangeArea.equals(other$topFlangeArea)) {
                                                            Object this$remark = this.getRemark();
                                                            Object other$remark = other.getRemark();
                                                            if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                               Object this$totalSurfaceArea = this.getTotalSurfaceArea();
                                                               Object other$totalSurfaceArea = other.getTotalSurfaceArea();
                                                               return this$totalSurfaceArea == null
                                                                  ? other$totalSurfaceArea == null
                                                                  : this$totalSurfaceArea.equals(other$totalSurfaceArea);
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
      return other instanceof ArtifactMachinePartExportTemplateDTO;
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
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $topFlangeArea = this.getTopFlangeArea();
      result = result * 59 + ($topFlangeArea == null ? 43 : $topFlangeArea.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $totalSurfaceArea = this.getTotalSurfaceArea();
      return result * 59 + ($totalSurfaceArea == null ? 43 : $totalSurfaceArea.hashCode());
   }

   @Override
   public String toString() {
      return "ArtifactMachinePartExportTemplateDTO(orderNo="
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
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", topFlangeArea="
         + this.getTopFlangeArea()
         + ", remark="
         + this.getRemark()
         + ", boolBlastingEnum="
         + this.getBoolBlastingEnum()
         + ", totalSurfaceArea="
         + this.getTotalSurfaceArea()
         + ")";
   }
}
