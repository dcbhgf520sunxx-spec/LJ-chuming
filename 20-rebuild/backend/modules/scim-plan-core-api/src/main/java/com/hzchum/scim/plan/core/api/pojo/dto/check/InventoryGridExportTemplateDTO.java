package com.hzchum.scim.plan.core.api.pojo.dto.check;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import java.math.BigDecimal;

@ExcelTarget("InventoryGridExportTemplateDTO")
@ApiModel("清单操作记录-导出DTO")
public class InventoryGridExportTemplateDTO implements Serializable {
   @Excel(name = "序号", width = 5.0)
   private Integer orderNo;
   @Excel(name = "结构类型", width = 10.0)
   private String structureType;
   @Excel(name = "杆件编号", width = 18.0)
   private String artifactNo;
   @Excel(name = "规格", width = 18.0)
   private String specification;
   @Excel(name = "材质", width = 10.0)
   private String material;
   @Excel(name = "焊接长度", width = 15.0)
   private BigDecimal length;
   @Excel(name = "下料长度", width = 15.0)
   private BigDecimal cuttingLength;
   @Excel(name = "数量", width = 12.0)
   private Integer quantity;
   @Excel(name = "高强螺栓", width = 12.0)
   private String highStrengthBolt;
   @Excel(name = "备注", width = 15.0)
   private String remark;
   @Excel(name = "螺栓数量", width = 12.0)
   private Integer boltQuantity;
   @Excel(name = "配件数量", width = 12.0)
   private Integer matchingPartsQuantity;
   @Excel(name = "杆子总长", width = 12.0)
   private BigDecimal totalPoleLength;
   @Excel(name = "杆子重量", width = 12.0)
   private BigDecimal poleWeight;
   @Excel(name = "封板或锥头重量", width = 12.0)
   private BigDecimal sealingOrPlateWeight;
   @Excel(name = "螺栓重量", width = 12.0)
   private BigDecimal boltWeight;
   @Excel(name = "套筒重量", width = 12.0)
   private BigDecimal sleeveWeight;
   @Excel(name = "销钉重量", width = 12.0)
   private BigDecimal dowelPinWeight;
   @Excel(name = "总重", width = 13.0)
   private BigDecimal totalNetWeight;
   @Excel(name = "单面积")
   private BigDecimal surfaceArea;

   public Integer getOrderNo() {
      return this.orderNo;
   }

   public String getStructureType() {
      return this.structureType;
   }

   public String getArtifactNo() {
      return this.artifactNo;
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

   public BigDecimal getCuttingLength() {
      return this.cuttingLength;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public String getHighStrengthBolt() {
      return this.highStrengthBolt;
   }

   public String getRemark() {
      return this.remark;
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

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public void setOrderNo(final Integer orderNo) {
      this.orderNo = orderNo;
   }

   public void setStructureType(final String structureType) {
      this.structureType = structureType;
   }

   public void setArtifactNo(final String artifactNo) {
      this.artifactNo = artifactNo;
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

   public void setCuttingLength(final BigDecimal cuttingLength) {
      this.cuttingLength = cuttingLength;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setHighStrengthBolt(final String highStrengthBolt) {
      this.highStrengthBolt = highStrengthBolt;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
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

   public void setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
   }

   public void setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InventoryGridExportTemplateDTO)) {
         return false;
      }

      InventoryGridExportTemplateDTO other = (InventoryGridExportTemplateDTO)o;
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
                  Object this$structureType = this.getStructureType();
                  Object other$structureType = other.getStructureType();
                  if (this$structureType == null ? other$structureType == null : this$structureType.equals(other$structureType)) {
                     Object this$artifactNo = this.getArtifactNo();
                     Object other$artifactNo = other.getArtifactNo();
                     if (this$artifactNo == null ? other$artifactNo == null : this$artifactNo.equals(other$artifactNo)) {
                        Object this$specification = this.getSpecification();
                        Object other$specification = other.getSpecification();
                        if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                           Object this$material = this.getMaterial();
                           Object other$material = other.getMaterial();
                           if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                              Object this$length = this.getLength();
                              Object other$length = other.getLength();
                              if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                 Object this$cuttingLength = this.getCuttingLength();
                                 Object other$cuttingLength = other.getCuttingLength();
                                 if (this$cuttingLength == null ? other$cuttingLength == null : this$cuttingLength.equals(other$cuttingLength)) {
                                    Object this$highStrengthBolt = this.getHighStrengthBolt();
                                    Object other$highStrengthBolt = other.getHighStrengthBolt();
                                    if (this$highStrengthBolt == null ? other$highStrengthBolt == null : this$highStrengthBolt.equals(other$highStrengthBolt)) {
                                       Object this$remark = this.getRemark();
                                       Object other$remark = other.getRemark();
                                       if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                          Object this$totalPoleLength = this.getTotalPoleLength();
                                          Object other$totalPoleLength = other.getTotalPoleLength();
                                          if (this$totalPoleLength == null ? other$totalPoleLength == null : this$totalPoleLength.equals(other$totalPoleLength)
                                             )
                                           {
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
                                                   if (this$boltWeight == null ? other$boltWeight == null : this$boltWeight.equals(other$boltWeight)) {
                                                      Object this$sleeveWeight = this.getSleeveWeight();
                                                      Object other$sleeveWeight = other.getSleeveWeight();
                                                      if (this$sleeveWeight == null ? other$sleeveWeight == null : this$sleeveWeight.equals(other$sleeveWeight)
                                                         )
                                                       {
                                                         Object this$dowelPinWeight = this.getDowelPinWeight();
                                                         Object other$dowelPinWeight = other.getDowelPinWeight();
                                                         if (this$dowelPinWeight == null
                                                            ? other$dowelPinWeight == null
                                                            : this$dowelPinWeight.equals(other$dowelPinWeight)) {
                                                            Object this$totalNetWeight = this.getTotalNetWeight();
                                                            Object other$totalNetWeight = other.getTotalNetWeight();
                                                            if (this$totalNetWeight == null
                                                               ? other$totalNetWeight == null
                                                               : this$totalNetWeight.equals(other$totalNetWeight)) {
                                                               Object this$surfaceArea = this.getSurfaceArea();
                                                               Object other$surfaceArea = other.getSurfaceArea();
                                                               return this$surfaceArea == null
                                                                  ? other$surfaceArea == null
                                                                  : this$surfaceArea.equals(other$surfaceArea);
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
      return other instanceof InventoryGridExportTemplateDTO;
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
      Object $structureType = this.getStructureType();
      result = result * 59 + ($structureType == null ? 43 : $structureType.hashCode());
      Object $artifactNo = this.getArtifactNo();
      result = result * 59 + ($artifactNo == null ? 43 : $artifactNo.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $cuttingLength = this.getCuttingLength();
      result = result * 59 + ($cuttingLength == null ? 43 : $cuttingLength.hashCode());
      Object $highStrengthBolt = this.getHighStrengthBolt();
      result = result * 59 + ($highStrengthBolt == null ? 43 : $highStrengthBolt.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
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
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      return result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
   }

   @Override
   public String toString() {
      return "InventoryGridExportTemplateDTO(orderNo="
         + this.getOrderNo()
         + ", structureType="
         + this.getStructureType()
         + ", artifactNo="
         + this.getArtifactNo()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", length="
         + this.getLength()
         + ", cuttingLength="
         + this.getCuttingLength()
         + ", quantity="
         + this.getQuantity()
         + ", highStrengthBolt="
         + this.getHighStrengthBolt()
         + ", remark="
         + this.getRemark()
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
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ")";
   }
}
