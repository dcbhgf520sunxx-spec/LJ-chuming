package com.hzchum.scim.plan.core.api.pojo.dtoParam;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;

@ExcelTarget("ArtifactMachinePartImportTemplateDtoParam")
public class ArtifactMachinePartImportTemplateDtoParam implements Serializable {
   @Excel(name = "序号", width = 5.0, orderNum = "1")
   private Integer orderNo;
   @Excel(name = "名称", width = 15.0, orderNum = "2")
   private String name;
   @Excel(name = "构件编号", width = 18.0, orderNum = "3")
   private String artifactNo;
   @Excel(name = "单元编号", width = 18.0, orderNum = "4")
   private String elementSn;
   @Excel(name = "零件编号", width = 13.0, orderNum = "4")
   private String serialNumber;
   @Excel(name = "数量", orderNum = "8")
   private Integer quantity;
   @Excel(name = "规格", width = 18.0, orderNum = "5")
   private String specification;
   @Excel(name = "材质", orderNum = "7")
   private String material;
   @Excel(name = "长度(mm)", orderNum = "6")
   private BigDecimal length;
   @Excel(name = "单净重(kg)", width = 12.0, orderNum = "9")
   private BigDecimal netWeight;
   @Excel(name = "总净重(kg)", width = 13.0, orderNum = "10")
   private BigDecimal totalNetWeight;
   @Excel(name = "单毛重(kg)", width = 12.0, orderNum = "11")
   private BigDecimal grossWeight;
   @Excel(name = "总毛重(kg)", width = 13.0, orderNum = "12")
   private BigDecimal totalGrossWeight;
   @Excel(name = "图纸单重(kg)", width = 12.0, orderNum = "13")
   private BigDecimal drawingWeight;
   @Excel(name = "图纸总重(kg)", width = 13.0, orderNum = "14")
   private BigDecimal totalDrawingWeight;
   @Excel(name = "面积(m²)", orderNum = "15")
   private BigDecimal surfaceArea;
   @Excel(name = "面积(m2)", orderNum = "15")
   private BigDecimal surfaceArea2;
   @Excel(name = "面积(㎡)", orderNum = "15")
   private BigDecimal surfaceArea3;
   @Excel(name = "图号", orderNum = "16")
   private String drawingNumber;
   @Excel(name = "备注", width = 20.0, orderNum = "17")
   private String remark;
   @Excel(name = "涂装(Y/N)", orderNum = "18", replace = {"Y_true", "N_false"})
   private Boolean boolCoatingEnum;
   @Excel(name = "喷印编码", orderNum = "18")
   private String printedCode;
   @ApiModelProperty(name = "specPrefix", value = "规格前缀", notes = "规格前缀")
   private String specPrefix;

   public Integer getOrderNo() {
      return this.orderNo;
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

   public Integer getQuantity() {
      return this.quantity;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getLength() {
      return this.length;
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

   public String getDrawingNumber() {
      return this.drawingNumber;
   }

   public String getRemark() {
      return this.remark;
   }

   public Boolean getBoolCoatingEnum() {
      return this.boolCoatingEnum;
   }

   public String getPrintedCode() {
      return this.printedCode;
   }

   public String getSpecPrefix() {
      return this.specPrefix;
   }

   public void setOrderNo(final Integer orderNo) {
      this.orderNo = orderNo;
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

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
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

   public void setDrawingNumber(final String drawingNumber) {
      this.drawingNumber = drawingNumber;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setBoolCoatingEnum(final Boolean boolCoatingEnum) {
      this.boolCoatingEnum = boolCoatingEnum;
   }

   public void setPrintedCode(final String printedCode) {
      this.printedCode = printedCode;
   }

   public void setSpecPrefix(final String specPrefix) {
      this.specPrefix = specPrefix;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactMachinePartImportTemplateDtoParam)) {
         return false;
      }

      ArtifactMachinePartImportTemplateDtoParam other = (ArtifactMachinePartImportTemplateDtoParam)o;
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
                              Object this$material = this.getMaterial();
                              Object other$material = other.getMaterial();
                              if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                 Object this$length = this.getLength();
                                 Object other$length = other.getLength();
                                 if (this$length == null ? other$length == null : this$length.equals(other$length)) {
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
                                                               Object this$drawingNumber = this.getDrawingNumber();
                                                               Object other$drawingNumber = other.getDrawingNumber();
                                                               if (this$drawingNumber == null
                                                                  ? other$drawingNumber == null
                                                                  : this$drawingNumber.equals(other$drawingNumber)) {
                                                                  Object this$remark = this.getRemark();
                                                                  Object other$remark = other.getRemark();
                                                                  if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                                     Object this$printedCode = this.getPrintedCode();
                                                                     Object other$printedCode = other.getPrintedCode();
                                                                     if (this$printedCode == null
                                                                        ? other$printedCode == null
                                                                        : this$printedCode.equals(other$printedCode)) {
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
      return other instanceof ArtifactMachinePartImportTemplateDtoParam;
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
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
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
      Object $drawingNumber = this.getDrawingNumber();
      result = result * 59 + ($drawingNumber == null ? 43 : $drawingNumber.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $printedCode = this.getPrintedCode();
      result = result * 59 + ($printedCode == null ? 43 : $printedCode.hashCode());
      Object $specPrefix = this.getSpecPrefix();
      return result * 59 + ($specPrefix == null ? 43 : $specPrefix.hashCode());
   }

   @Override
   public String toString() {
      return "ArtifactMachinePartImportTemplateDtoParam(orderNo="
         + this.getOrderNo()
         + ", name="
         + this.getName()
         + ", artifactNo="
         + this.getArtifactNo()
         + ", elementSn="
         + this.getElementSn()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", quantity="
         + this.getQuantity()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", length="
         + this.getLength()
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
         + ", drawingNumber="
         + this.getDrawingNumber()
         + ", remark="
         + this.getRemark()
         + ", boolCoatingEnum="
         + this.getBoolCoatingEnum()
         + ", printedCode="
         + this.getPrintedCode()
         + ", specPrefix="
         + this.getSpecPrefix()
         + ")";
   }
}
