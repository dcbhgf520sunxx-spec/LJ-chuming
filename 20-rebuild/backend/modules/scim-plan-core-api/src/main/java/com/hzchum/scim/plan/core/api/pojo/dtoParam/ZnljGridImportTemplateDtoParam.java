package com.hzchum.scim.plan.core.api.pojo.dtoParam;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import java.io.Serializable;
import java.math.BigDecimal;

@ExcelTarget("ZnljGridImportTemplateDtoParam")
public class ZnljGridImportTemplateDtoParam implements Serializable {
   @Excel(name = "序号")
   private Integer orderNo;
   @Excel(name = "结构类型")
   private String structureType;
   @Excel(name = "杆件编号")
   private String serialNumber;
   @Excel(name = "名称")
   private String name;
   @Excel(name = "规格")
   private String specification;
   @Excel(name = "材质")
   private String material;
   @Excel(name = "焊接长度")
   private BigDecimal length;
   @Excel(name = "数量")
   private Integer quantity;
   @Excel(name = "总重")
   private BigDecimal totalWeight;
   @Excel(name = "面积")
   private BigDecimal totalArea;
   @Excel(name = "备注")
   private String remark;
   @Excel(name = "下料长度")
   private BigDecimal cuttingLength;
   @Excel(name = "高强螺栓")
   private String highStrengthBolt;
   @Excel(name = "螺栓数量")
   private Integer boltQuantity;
   @Excel(name = "配件数量")
   private Integer matchingPartsQuantity;
   @Excel(name = "杆子总长")
   private BigDecimal totalPoleLength;
   @Excel(name = "杆子重量")
   private BigDecimal poleWeight;
   @Excel(name = "封板或锥头重量")
   private BigDecimal sealingOrPlateWeight;
   @Excel(name = "螺栓重量")
   private BigDecimal boltWeight;
   @Excel(name = "套筒重量")
   private BigDecimal sleeveWeight;
   @Excel(name = "销钉重量")
   private BigDecimal dowelPinWeight;
   private String specPrefix;
   private Long structureClassId;
   private Boolean boolCoatingEnum;

   public Integer getOrderNo() {
      return this.orderNo;
   }

   public String getStructureType() {
      return this.structureType;
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

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public String getRemark() {
      return this.remark;
   }

   public BigDecimal getCuttingLength() {
      return this.cuttingLength;
   }

   public String getHighStrengthBolt() {
      return this.highStrengthBolt;
   }

   public Integer getBoltQuantity() {
      return this.boltQuantity;
   }

   public Integer getMatchingPartsQuantity() {
      return this.matchingPartsQuantity;
   }

   public BigDecimal getTotalPoleLength() {
      return this.totalPoleLength;
   }

   public BigDecimal getPoleWeight() {
      return this.poleWeight;
   }

   public BigDecimal getSealingOrPlateWeight() {
      return this.sealingOrPlateWeight;
   }

   public BigDecimal getBoltWeight() {
      return this.boltWeight;
   }

   public BigDecimal getSleeveWeight() {
      return this.sleeveWeight;
   }

   public BigDecimal getDowelPinWeight() {
      return this.dowelPinWeight;
   }

   public String getSpecPrefix() {
      return this.specPrefix;
   }

   public Long getStructureClassId() {
      return this.structureClassId;
   }

   public Boolean getBoolCoatingEnum() {
      return this.boolCoatingEnum;
   }

   public void setOrderNo(final Integer orderNo) {
      this.orderNo = orderNo;
   }

   public void setStructureType(final String structureType) {
      this.structureType = structureType;
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

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
   }

   public void setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setCuttingLength(final BigDecimal cuttingLength) {
      this.cuttingLength = cuttingLength;
   }

   public void setHighStrengthBolt(final String highStrengthBolt) {
      this.highStrengthBolt = highStrengthBolt;
   }

   public void setBoltQuantity(final Integer boltQuantity) {
      this.boltQuantity = boltQuantity;
   }

   public void setMatchingPartsQuantity(final Integer matchingPartsQuantity) {
      this.matchingPartsQuantity = matchingPartsQuantity;
   }

   public void setTotalPoleLength(final BigDecimal totalPoleLength) {
      this.totalPoleLength = totalPoleLength;
   }

   public void setPoleWeight(final BigDecimal poleWeight) {
      this.poleWeight = poleWeight;
   }

   public void setSealingOrPlateWeight(final BigDecimal sealingOrPlateWeight) {
      this.sealingOrPlateWeight = sealingOrPlateWeight;
   }

   public void setBoltWeight(final BigDecimal boltWeight) {
      this.boltWeight = boltWeight;
   }

   public void setSleeveWeight(final BigDecimal sleeveWeight) {
      this.sleeveWeight = sleeveWeight;
   }

   public void setDowelPinWeight(final BigDecimal dowelPinWeight) {
      this.dowelPinWeight = dowelPinWeight;
   }

   public void setSpecPrefix(final String specPrefix) {
      this.specPrefix = specPrefix;
   }

   public void setStructureClassId(final Long structureClassId) {
      this.structureClassId = structureClassId;
   }

   public void setBoolCoatingEnum(final Boolean boolCoatingEnum) {
      this.boolCoatingEnum = boolCoatingEnum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ZnljGridImportTemplateDtoParam)) {
         return false;
      }

      ZnljGridImportTemplateDtoParam other = (ZnljGridImportTemplateDtoParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$orderNo = this.getOrderNo();
      Object other$orderNo = other.getOrderNo();
      if (this$orderNo == null ? other$orderNo == null : this$orderNo.equals(other$orderNo)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$boltQuantity = this.getBoltQuantity();
            Object other$boltQuantity = other.getBoltQuantity();
            if (this$boltQuantity == null ? other$boltQuantity == null : this$boltQuantity.equals(other$boltQuantity)) {
               Object this$matchingPartsQuantity = this.getMatchingPartsQuantity();
               Object other$matchingPartsQuantity = other.getMatchingPartsQuantity();
               if (this$matchingPartsQuantity == null ? other$matchingPartsQuantity == null : this$matchingPartsQuantity.equals(other$matchingPartsQuantity)) {
                  Object this$structureClassId = this.getStructureClassId();
                  Object other$structureClassId = other.getStructureClassId();
                  if (this$structureClassId == null ? other$structureClassId == null : this$structureClassId.equals(other$structureClassId)) {
                     Object this$boolCoatingEnum = this.getBoolCoatingEnum();
                     Object other$boolCoatingEnum = other.getBoolCoatingEnum();
                     if (this$boolCoatingEnum == null ? other$boolCoatingEnum == null : this$boolCoatingEnum.equals(other$boolCoatingEnum)) {
                        Object this$structureType = this.getStructureType();
                        Object other$structureType = other.getStructureType();
                        if (this$structureType == null ? other$structureType == null : this$structureType.equals(other$structureType)) {
                           Object this$serialNumber = this.getSerialNumber();
                           Object other$serialNumber = other.getSerialNumber();
                           if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                              Object this$name = this.getName();
                              Object other$name = other.getName();
                              if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                 Object this$specification = this.getSpecification();
                                 Object other$specification = other.getSpecification();
                                 if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                    Object this$material = this.getMaterial();
                                    Object other$material = other.getMaterial();
                                    if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                       Object this$length = this.getLength();
                                       Object other$length = other.getLength();
                                       if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                          Object this$totalWeight = this.getTotalWeight();
                                          Object other$totalWeight = other.getTotalWeight();
                                          if (this$totalWeight == null ? other$totalWeight == null : this$totalWeight.equals(other$totalWeight)) {
                                             Object this$totalArea = this.getTotalArea();
                                             Object other$totalArea = other.getTotalArea();
                                             if (this$totalArea == null ? other$totalArea == null : this$totalArea.equals(other$totalArea)) {
                                                Object this$remark = this.getRemark();
                                                Object other$remark = other.getRemark();
                                                if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                   Object this$cuttingLength = this.getCuttingLength();
                                                   Object other$cuttingLength = other.getCuttingLength();
                                                   if (this$cuttingLength == null
                                                      ? other$cuttingLength == null
                                                      : this$cuttingLength.equals(other$cuttingLength)) {
                                                      Object this$highStrengthBolt = this.getHighStrengthBolt();
                                                      Object other$highStrengthBolt = other.getHighStrengthBolt();
                                                      if (this$highStrengthBolt == null
                                                         ? other$highStrengthBolt == null
                                                         : this$highStrengthBolt.equals(other$highStrengthBolt)) {
                                                         Object this$totalPoleLength = this.getTotalPoleLength();
                                                         Object other$totalPoleLength = other.getTotalPoleLength();
                                                         if (this$totalPoleLength == null
                                                            ? other$totalPoleLength == null
                                                            : this$totalPoleLength.equals(other$totalPoleLength)) {
                                                            Object this$poleWeight = this.getPoleWeight();
                                                            Object other$poleWeight = other.getPoleWeight();
                                                            if (this$poleWeight == null ? other$poleWeight == null : this$poleWeight.equals(other$poleWeight)) {
                                                               Object this$sealingOrPlateWeight = this.getSealingOrPlateWeight();
                                                               Object other$sealingOrPlateWeight = other.getSealingOrPlateWeight();
                                                               if (this$sealingOrPlateWeight == null
                                                                  ? other$sealingOrPlateWeight == null
                                                                  : this$sealingOrPlateWeight.equals(other$sealingOrPlateWeight)) {
                                                                  Object this$boltWeight = this.getBoltWeight();
                                                                  Object other$boltWeight = other.getBoltWeight();
                                                                  if (this$boltWeight == null
                                                                     ? other$boltWeight == null
                                                                     : this$boltWeight.equals(other$boltWeight)) {
                                                                     Object this$sleeveWeight = this.getSleeveWeight();
                                                                     Object other$sleeveWeight = other.getSleeveWeight();
                                                                     if (this$sleeveWeight == null
                                                                        ? other$sleeveWeight == null
                                                                        : this$sleeveWeight.equals(other$sleeveWeight)) {
                                                                        Object this$dowelPinWeight = this.getDowelPinWeight();
                                                                        Object other$dowelPinWeight = other.getDowelPinWeight();
                                                                        if (this$dowelPinWeight == null
                                                                           ? other$dowelPinWeight == null
                                                                           : this$dowelPinWeight.equals(other$dowelPinWeight)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ZnljGridImportTemplateDtoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderNo = this.getOrderNo();
      result = result * 59 + ($orderNo == null ? 43 : $orderNo.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $boltQuantity = this.getBoltQuantity();
      result = result * 59 + ($boltQuantity == null ? 43 : $boltQuantity.hashCode());
      Object $matchingPartsQuantity = this.getMatchingPartsQuantity();
      result = result * 59 + ($matchingPartsQuantity == null ? 43 : $matchingPartsQuantity.hashCode());
      Object $structureClassId = this.getStructureClassId();
      result = result * 59 + ($structureClassId == null ? 43 : $structureClassId.hashCode());
      Object $boolCoatingEnum = this.getBoolCoatingEnum();
      result = result * 59 + ($boolCoatingEnum == null ? 43 : $boolCoatingEnum.hashCode());
      Object $structureType = this.getStructureType();
      result = result * 59 + ($structureType == null ? 43 : $structureType.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $cuttingLength = this.getCuttingLength();
      result = result * 59 + ($cuttingLength == null ? 43 : $cuttingLength.hashCode());
      Object $highStrengthBolt = this.getHighStrengthBolt();
      result = result * 59 + ($highStrengthBolt == null ? 43 : $highStrengthBolt.hashCode());
      Object $totalPoleLength = this.getTotalPoleLength();
      result = result * 59 + ($totalPoleLength == null ? 43 : $totalPoleLength.hashCode());
      Object $poleWeight = this.getPoleWeight();
      result = result * 59 + ($poleWeight == null ? 43 : $poleWeight.hashCode());
      Object $sealingOrPlateWeight = this.getSealingOrPlateWeight();
      result = result * 59 + ($sealingOrPlateWeight == null ? 43 : $sealingOrPlateWeight.hashCode());
      Object $boltWeight = this.getBoltWeight();
      result = result * 59 + ($boltWeight == null ? 43 : $boltWeight.hashCode());
      Object $sleeveWeight = this.getSleeveWeight();
      result = result * 59 + ($sleeveWeight == null ? 43 : $sleeveWeight.hashCode());
      Object $dowelPinWeight = this.getDowelPinWeight();
      result = result * 59 + ($dowelPinWeight == null ? 43 : $dowelPinWeight.hashCode());
      Object $specPrefix = this.getSpecPrefix();
      return result * 59 + ($specPrefix == null ? 43 : $specPrefix.hashCode());
   }

   @Override
   public String toString() {
      return "ZnljGridImportTemplateDtoParam(orderNo="
         + this.getOrderNo()
         + ", structureType="
         + this.getStructureType()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", name="
         + this.getName()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", length="
         + this.getLength()
         + ", quantity="
         + this.getQuantity()
         + ", totalWeight="
         + this.getTotalWeight()
         + ", totalArea="
         + this.getTotalArea()
         + ", remark="
         + this.getRemark()
         + ", cuttingLength="
         + this.getCuttingLength()
         + ", highStrengthBolt="
         + this.getHighStrengthBolt()
         + ", boltQuantity="
         + this.getBoltQuantity()
         + ", matchingPartsQuantity="
         + this.getMatchingPartsQuantity()
         + ", totalPoleLength="
         + this.getTotalPoleLength()
         + ", poleWeight="
         + this.getPoleWeight()
         + ", sealingOrPlateWeight="
         + this.getSealingOrPlateWeight()
         + ", boltWeight="
         + this.getBoltWeight()
         + ", sleeveWeight="
         + this.getSleeveWeight()
         + ", dowelPinWeight="
         + this.getDowelPinWeight()
         + ", specPrefix="
         + this.getSpecPrefix()
         + ", structureClassId="
         + this.getStructureClassId()
         + ", boolCoatingEnum="
         + this.getBoolCoatingEnum()
         + ")";
   }
}
