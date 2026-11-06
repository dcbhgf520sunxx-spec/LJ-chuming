package com.hzchum.scim.plan.core.api.pojo.dto.change;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

public class TechChangeArtifactDTO {
   @ApiModelProperty(name = "name", value = "名称")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   private String specification;
   @ApiModelProperty(name = "material", value = "材质")
   private String material;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   private BigDecimal length;
   @ApiModelProperty(name = "quantity", value = "数量")
   private Integer quantity;
   @ApiModelProperty(name = "netWeight", value = "单净重（kg）")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重（kg）")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "grossWeight", value = "单毛重（kg）")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "totalGrossWeight", value = "总毛重（kg）")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "surfaceArea", value = "面积（㎡）")
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "specPrefix", value = "规格前缀")
   private String specPrefix;
   @ApiModelProperty(name = "serialNumberPrefix", value = "编号前缀")
   private String serialNumberPrefix;
   @ApiModelProperty(name = "构件特征定义id", value = "构件特征定义id")
   private Long structureClassId;
   @ApiModelProperty(name = "boolAllPartSendDirectly", value = "是否全部零件都是直发件 true 是 false 否")
   private Boolean boolAllPartSendDirectly;
   @ApiModelProperty("扫码方式 1:一物一码  2:一码多物(批量) 枚举: CodingTypeEnum")
   private Integer codingType;
   @ApiModelProperty(name = "userId", value = "上传人id")
   private Long userId;
   @ApiModelProperty(name = "boolCoatingEnum", value = "是否涂装 true是 false否")
   private Boolean boolCoatingEnum;
   @ApiModelProperty(name = "machinePartList", value = "零件列表")
   private List<TechChangeMachinePartDTO> machinePartList;
   @ApiModelProperty(name = "boolSameNumber", value = "书否存在相同编号构件(已存在的构件数量为1)")
   private Boolean boolSameNumber;

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
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

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public String getSpecPrefix() {
      return this.specPrefix;
   }

   public String getSerialNumberPrefix() {
      return this.serialNumberPrefix;
   }

   public Long getStructureClassId() {
      return this.structureClassId;
   }

   public Boolean getBoolAllPartSendDirectly() {
      return this.boolAllPartSendDirectly;
   }

   public Integer getCodingType() {
      return this.codingType;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Boolean getBoolCoatingEnum() {
      return this.boolCoatingEnum;
   }

   public List<TechChangeMachinePartDTO> getMachinePartList() {
      return this.machinePartList;
   }

   public Boolean getBoolSameNumber() {
      return this.boolSameNumber;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
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

   public void setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
   }

   public void setSpecPrefix(final String specPrefix) {
      this.specPrefix = specPrefix;
   }

   public void setSerialNumberPrefix(final String serialNumberPrefix) {
      this.serialNumberPrefix = serialNumberPrefix;
   }

   public void setStructureClassId(final Long structureClassId) {
      this.structureClassId = structureClassId;
   }

   public void setBoolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
   }

   public void setCodingType(final Integer codingType) {
      this.codingType = codingType;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setBoolCoatingEnum(final Boolean boolCoatingEnum) {
      this.boolCoatingEnum = boolCoatingEnum;
   }

   public void setMachinePartList(final List<TechChangeMachinePartDTO> machinePartList) {
      this.machinePartList = machinePartList;
   }

   public void setBoolSameNumber(final Boolean boolSameNumber) {
      this.boolSameNumber = boolSameNumber;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechChangeArtifactDTO)) {
         return false;
      }

      TechChangeArtifactDTO other = (TechChangeArtifactDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$structureClassId = this.getStructureClassId();
         Object other$structureClassId = other.getStructureClassId();
         if (this$structureClassId == null ? other$structureClassId == null : this$structureClassId.equals(other$structureClassId)) {
            Object this$boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
            Object other$boolAllPartSendDirectly = other.getBoolAllPartSendDirectly();
            if (this$boolAllPartSendDirectly == null
               ? other$boolAllPartSendDirectly == null
               : this$boolAllPartSendDirectly.equals(other$boolAllPartSendDirectly)) {
               Object this$codingType = this.getCodingType();
               Object other$codingType = other.getCodingType();
               if (this$codingType == null ? other$codingType == null : this$codingType.equals(other$codingType)) {
                  Object this$userId = this.getUserId();
                  Object other$userId = other.getUserId();
                  if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                     Object this$boolCoatingEnum = this.getBoolCoatingEnum();
                     Object other$boolCoatingEnum = other.getBoolCoatingEnum();
                     if (this$boolCoatingEnum == null ? other$boolCoatingEnum == null : this$boolCoatingEnum.equals(other$boolCoatingEnum)) {
                        Object this$boolSameNumber = this.getBoolSameNumber();
                        Object other$boolSameNumber = other.getBoolSameNumber();
                        if (this$boolSameNumber == null ? other$boolSameNumber == null : this$boolSameNumber.equals(other$boolSameNumber)) {
                           Object this$name = this.getName();
                           Object other$name = other.getName();
                           if (this$name == null ? other$name == null : this$name.equals(other$name)) {
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
                                                      Object this$surfaceArea = this.getSurfaceArea();
                                                      Object other$surfaceArea = other.getSurfaceArea();
                                                      if (this$surfaceArea == null ? other$surfaceArea == null : this$surfaceArea.equals(other$surfaceArea)) {
                                                         Object this$specPrefix = this.getSpecPrefix();
                                                         Object other$specPrefix = other.getSpecPrefix();
                                                         if (this$specPrefix == null ? other$specPrefix == null : this$specPrefix.equals(other$specPrefix)) {
                                                            Object this$serialNumberPrefix = this.getSerialNumberPrefix();
                                                            Object other$serialNumberPrefix = other.getSerialNumberPrefix();
                                                            if (this$serialNumberPrefix == null
                                                               ? other$serialNumberPrefix == null
                                                               : this$serialNumberPrefix.equals(other$serialNumberPrefix)) {
                                                               Object this$machinePartList = this.getMachinePartList();
                                                               Object other$machinePartList = other.getMachinePartList();
                                                               return this$machinePartList == null
                                                                  ? other$machinePartList == null
                                                                  : this$machinePartList.equals(other$machinePartList);
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
      return other instanceof TechChangeArtifactDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $structureClassId = this.getStructureClassId();
      result = result * 59 + ($structureClassId == null ? 43 : $structureClassId.hashCode());
      Object $boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
      result = result * 59 + ($boolAllPartSendDirectly == null ? 43 : $boolAllPartSendDirectly.hashCode());
      Object $codingType = this.getCodingType();
      result = result * 59 + ($codingType == null ? 43 : $codingType.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $boolCoatingEnum = this.getBoolCoatingEnum();
      result = result * 59 + ($boolCoatingEnum == null ? 43 : $boolCoatingEnum.hashCode());
      Object $boolSameNumber = this.getBoolSameNumber();
      result = result * 59 + ($boolSameNumber == null ? 43 : $boolSameNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
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
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $specPrefix = this.getSpecPrefix();
      result = result * 59 + ($specPrefix == null ? 43 : $specPrefix.hashCode());
      Object $serialNumberPrefix = this.getSerialNumberPrefix();
      result = result * 59 + ($serialNumberPrefix == null ? 43 : $serialNumberPrefix.hashCode());
      Object $machinePartList = this.getMachinePartList();
      return result * 59 + ($machinePartList == null ? 43 : $machinePartList.hashCode());
   }

   @Override
   public String toString() {
      return "TechChangeArtifactDTO(name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", length="
         + this.getLength()
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
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", specPrefix="
         + this.getSpecPrefix()
         + ", serialNumberPrefix="
         + this.getSerialNumberPrefix()
         + ", structureClassId="
         + this.getStructureClassId()
         + ", boolAllPartSendDirectly="
         + this.getBoolAllPartSendDirectly()
         + ", codingType="
         + this.getCodingType()
         + ", userId="
         + this.getUserId()
         + ", boolCoatingEnum="
         + this.getBoolCoatingEnum()
         + ", machinePartList="
         + this.getMachinePartList()
         + ", boolSameNumber="
         + this.getBoolSameNumber()
         + ")";
   }
}
