package com.hzchum.scim.plan.core.api.pojo.dto.change;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

public class ZnTechChangeArtifactDTO {
   @ApiModelProperty(name = "orderNo", value = "序号")
   private Integer orderNo;
   @ApiModelProperty(name = "name", value = "名称")
   private String name;
   @ApiModelProperty(name = "structureType", value = "结构类型")
   private String structureType;
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
   @ApiModelProperty(name = "boolPurlineClass", value = "是否檩条")
   private Boolean boolPurlineClass;
   @ApiModelProperty(name = "boolBlastingEnum", value = "是否抛丸")
   private Boolean boolBlastingEnum;
   @ApiModelProperty(name = "topFlangeArea", value = "上翼缘(单)面积（mm²）")
   private BigDecimal topFlangeArea;
   @ApiModelProperty(name = "boolAllPartSendDirectly", value = "是否全部零件都是直发件 true 是 false 否")
   private Boolean boolAllPartSendDirectly;
   @ApiModelProperty("扫码方式 1:一物一码  2:一码多物(批量) 枚举: CodingTypeEnum")
   private Integer codingType;
   @ApiModelProperty(name = "userId", value = "上传人id")
   private Long userId;
   @ApiModelProperty(name = "boolCoatingEnum", value = "是否涂装 true是 false否")
   private Boolean boolCoatingEnum;
   @ApiModelProperty(name = "boolSinglePartEnum", value = "是否单零件类型构件 true是 false否")
   private Boolean boolSinglePartEnum;
   @ApiModelProperty(name = "drawingWeight", value = "图纸单重")
   private BigDecimal drawingWeight;
   @ApiModelProperty(name = "drawingWeight", value = "图纸总重")
   private BigDecimal totalDrawingWeight;
   @ApiModelProperty(name = "machinePartImportMap", value = "零部件列表")
   private List<ZnTechChangeMachinePartDTO> machinePartDTOList;

   public static ZnTechChangeArtifactDTO.ZnTechChangeArtifactDTOBuilder builder() {
      return new ZnTechChangeArtifactDTO.ZnTechChangeArtifactDTOBuilder();
   }

   public Integer getOrderNo() {
      return this.orderNo;
   }

   public String getName() {
      return this.name;
   }

   public String getStructureType() {
      return this.structureType;
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

   public Boolean getBoolPurlineClass() {
      return this.boolPurlineClass;
   }

   public Boolean getBoolBlastingEnum() {
      return this.boolBlastingEnum;
   }

   public BigDecimal getTopFlangeArea() {
      return this.topFlangeArea;
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

   public Boolean getBoolSinglePartEnum() {
      return this.boolSinglePartEnum;
   }

   public BigDecimal getDrawingWeight() {
      return this.drawingWeight;
   }

   public BigDecimal getTotalDrawingWeight() {
      return this.totalDrawingWeight;
   }

   public List<ZnTechChangeMachinePartDTO> getMachinePartDTOList() {
      return this.machinePartDTOList;
   }

   public void setOrderNo(final Integer orderNo) {
      this.orderNo = orderNo;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setStructureType(final String structureType) {
      this.structureType = structureType;
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

   public void setBoolPurlineClass(final Boolean boolPurlineClass) {
      this.boolPurlineClass = boolPurlineClass;
   }

   public void setBoolBlastingEnum(final Boolean boolBlastingEnum) {
      this.boolBlastingEnum = boolBlastingEnum;
   }

   public void setTopFlangeArea(final BigDecimal topFlangeArea) {
      this.topFlangeArea = topFlangeArea;
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

   public void setBoolSinglePartEnum(final Boolean boolSinglePartEnum) {
      this.boolSinglePartEnum = boolSinglePartEnum;
   }

   public void setDrawingWeight(final BigDecimal drawingWeight) {
      this.drawingWeight = drawingWeight;
   }

   public void setTotalDrawingWeight(final BigDecimal totalDrawingWeight) {
      this.totalDrawingWeight = totalDrawingWeight;
   }

   public void setMachinePartDTOList(final List<ZnTechChangeMachinePartDTO> machinePartDTOList) {
      this.machinePartDTOList = machinePartDTOList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ZnTechChangeArtifactDTO)) {
         return false;
      }

      ZnTechChangeArtifactDTO other = (ZnTechChangeArtifactDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$orderNo = this.getOrderNo();
      Object other$orderNo = other.getOrderNo();
      if (this$orderNo == null ? other$orderNo == null : this$orderNo.equals(other$orderNo)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$structureClassId = this.getStructureClassId();
            Object other$structureClassId = other.getStructureClassId();
            if (this$structureClassId == null ? other$structureClassId == null : this$structureClassId.equals(other$structureClassId)) {
               Object this$boolPurlineClass = this.getBoolPurlineClass();
               Object other$boolPurlineClass = other.getBoolPurlineClass();
               if (this$boolPurlineClass == null ? other$boolPurlineClass == null : this$boolPurlineClass.equals(other$boolPurlineClass)) {
                  Object this$boolBlastingEnum = this.getBoolBlastingEnum();
                  Object other$boolBlastingEnum = other.getBoolBlastingEnum();
                  if (this$boolBlastingEnum == null ? other$boolBlastingEnum == null : this$boolBlastingEnum.equals(other$boolBlastingEnum)) {
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
                                 Object this$boolSinglePartEnum = this.getBoolSinglePartEnum();
                                 Object other$boolSinglePartEnum = other.getBoolSinglePartEnum();
                                 if (this$boolSinglePartEnum == null
                                    ? other$boolSinglePartEnum == null
                                    : this$boolSinglePartEnum.equals(other$boolSinglePartEnum)) {
                                    Object this$name = this.getName();
                                    Object other$name = other.getName();
                                    if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                       Object this$structureType = this.getStructureType();
                                       Object other$structureType = other.getStructureType();
                                       if (this$structureType == null ? other$structureType == null : this$structureType.equals(other$structureType)) {
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
                                                         if (this$totalNetWeight == null
                                                            ? other$totalNetWeight == null
                                                            : this$totalNetWeight.equals(other$totalNetWeight)) {
                                                            Object this$grossWeight = this.getGrossWeight();
                                                            Object other$grossWeight = other.getGrossWeight();
                                                            if (this$grossWeight == null
                                                               ? other$grossWeight == null
                                                               : this$grossWeight.equals(other$grossWeight)) {
                                                               Object this$totalGrossWeight = this.getTotalGrossWeight();
                                                               Object other$totalGrossWeight = other.getTotalGrossWeight();
                                                               if (this$totalGrossWeight == null
                                                                  ? other$totalGrossWeight == null
                                                                  : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                                                                  Object this$surfaceArea = this.getSurfaceArea();
                                                                  Object other$surfaceArea = other.getSurfaceArea();
                                                                  if (this$surfaceArea == null
                                                                     ? other$surfaceArea == null
                                                                     : this$surfaceArea.equals(other$surfaceArea)) {
                                                                     Object this$specPrefix = this.getSpecPrefix();
                                                                     Object other$specPrefix = other.getSpecPrefix();
                                                                     if (this$specPrefix == null
                                                                        ? other$specPrefix == null
                                                                        : this$specPrefix.equals(other$specPrefix)) {
                                                                        Object this$serialNumberPrefix = this.getSerialNumberPrefix();
                                                                        Object other$serialNumberPrefix = other.getSerialNumberPrefix();
                                                                        if (this$serialNumberPrefix == null
                                                                           ? other$serialNumberPrefix == null
                                                                           : this$serialNumberPrefix.equals(other$serialNumberPrefix)) {
                                                                           Object this$topFlangeArea = this.getTopFlangeArea();
                                                                           Object other$topFlangeArea = other.getTopFlangeArea();
                                                                           if (this$topFlangeArea == null
                                                                              ? other$topFlangeArea == null
                                                                              : this$topFlangeArea.equals(other$topFlangeArea)) {
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
                                                                                    Object this$machinePartDTOList = this.getMachinePartDTOList();
                                                                                    Object other$machinePartDTOList = other.getMachinePartDTOList();
                                                                                    return this$machinePartDTOList == null
                                                                                       ? other$machinePartDTOList == null
                                                                                       : this$machinePartDTOList.equals(other$machinePartDTOList);
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
      return other instanceof ZnTechChangeArtifactDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderNo = this.getOrderNo();
      result = result * 59 + ($orderNo == null ? 43 : $orderNo.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $structureClassId = this.getStructureClassId();
      result = result * 59 + ($structureClassId == null ? 43 : $structureClassId.hashCode());
      Object $boolPurlineClass = this.getBoolPurlineClass();
      result = result * 59 + ($boolPurlineClass == null ? 43 : $boolPurlineClass.hashCode());
      Object $boolBlastingEnum = this.getBoolBlastingEnum();
      result = result * 59 + ($boolBlastingEnum == null ? 43 : $boolBlastingEnum.hashCode());
      Object $boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
      result = result * 59 + ($boolAllPartSendDirectly == null ? 43 : $boolAllPartSendDirectly.hashCode());
      Object $codingType = this.getCodingType();
      result = result * 59 + ($codingType == null ? 43 : $codingType.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $boolCoatingEnum = this.getBoolCoatingEnum();
      result = result * 59 + ($boolCoatingEnum == null ? 43 : $boolCoatingEnum.hashCode());
      Object $boolSinglePartEnum = this.getBoolSinglePartEnum();
      result = result * 59 + ($boolSinglePartEnum == null ? 43 : $boolSinglePartEnum.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $structureType = this.getStructureType();
      result = result * 59 + ($structureType == null ? 43 : $structureType.hashCode());
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
      Object $topFlangeArea = this.getTopFlangeArea();
      result = result * 59 + ($topFlangeArea == null ? 43 : $topFlangeArea.hashCode());
      Object $drawingWeight = this.getDrawingWeight();
      result = result * 59 + ($drawingWeight == null ? 43 : $drawingWeight.hashCode());
      Object $totalDrawingWeight = this.getTotalDrawingWeight();
      result = result * 59 + ($totalDrawingWeight == null ? 43 : $totalDrawingWeight.hashCode());
      Object $machinePartDTOList = this.getMachinePartDTOList();
      return result * 59 + ($machinePartDTOList == null ? 43 : $machinePartDTOList.hashCode());
   }

   @Override
   public String toString() {
      return "ZnTechChangeArtifactDTO(orderNo="
         + this.getOrderNo()
         + ", name="
         + this.getName()
         + ", structureType="
         + this.getStructureType()
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
         + ", boolPurlineClass="
         + this.getBoolPurlineClass()
         + ", boolBlastingEnum="
         + this.getBoolBlastingEnum()
         + ", topFlangeArea="
         + this.getTopFlangeArea()
         + ", boolAllPartSendDirectly="
         + this.getBoolAllPartSendDirectly()
         + ", codingType="
         + this.getCodingType()
         + ", userId="
         + this.getUserId()
         + ", boolCoatingEnum="
         + this.getBoolCoatingEnum()
         + ", boolSinglePartEnum="
         + this.getBoolSinglePartEnum()
         + ", drawingWeight="
         + this.getDrawingWeight()
         + ", totalDrawingWeight="
         + this.getTotalDrawingWeight()
         + ", machinePartDTOList="
         + this.getMachinePartDTOList()
         + ")";
   }

   public ZnTechChangeArtifactDTO() {
   }

   public ZnTechChangeArtifactDTO(
      final Integer orderNo,
      final String name,
      final String structureType,
      final String serialNumber,
      final String specification,
      final String material,
      final BigDecimal length,
      final Integer quantity,
      final BigDecimal netWeight,
      final BigDecimal totalNetWeight,
      final BigDecimal grossWeight,
      final BigDecimal totalGrossWeight,
      final BigDecimal surfaceArea,
      final String specPrefix,
      final String serialNumberPrefix,
      final Long structureClassId,
      final Boolean boolPurlineClass,
      final Boolean boolBlastingEnum,
      final BigDecimal topFlangeArea,
      final Boolean boolAllPartSendDirectly,
      final Integer codingType,
      final Long userId,
      final Boolean boolCoatingEnum,
      final Boolean boolSinglePartEnum,
      final BigDecimal drawingWeight,
      final BigDecimal totalDrawingWeight,
      final List<ZnTechChangeMachinePartDTO> machinePartDTOList
   ) {
      this.orderNo = orderNo;
      this.name = name;
      this.structureType = structureType;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.material = material;
      this.length = length;
      this.quantity = quantity;
      this.netWeight = netWeight;
      this.totalNetWeight = totalNetWeight;
      this.grossWeight = grossWeight;
      this.totalGrossWeight = totalGrossWeight;
      this.surfaceArea = surfaceArea;
      this.specPrefix = specPrefix;
      this.serialNumberPrefix = serialNumberPrefix;
      this.structureClassId = structureClassId;
      this.boolPurlineClass = boolPurlineClass;
      this.boolBlastingEnum = boolBlastingEnum;
      this.topFlangeArea = topFlangeArea;
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
      this.codingType = codingType;
      this.userId = userId;
      this.boolCoatingEnum = boolCoatingEnum;
      this.boolSinglePartEnum = boolSinglePartEnum;
      this.drawingWeight = drawingWeight;
      this.totalDrawingWeight = totalDrawingWeight;
      this.machinePartDTOList = machinePartDTOList;
   }

   public static class ZnTechChangeArtifactDTOBuilder {
      private Integer orderNo;
      private String name;
      private String structureType;
      private String serialNumber;
      private String specification;
      private String material;
      private BigDecimal length;
      private Integer quantity;
      private BigDecimal netWeight;
      private BigDecimal totalNetWeight;
      private BigDecimal grossWeight;
      private BigDecimal totalGrossWeight;
      private BigDecimal surfaceArea;
      private String specPrefix;
      private String serialNumberPrefix;
      private Long structureClassId;
      private Boolean boolPurlineClass;
      private Boolean boolBlastingEnum;
      private BigDecimal topFlangeArea;
      private Boolean boolAllPartSendDirectly;
      private Integer codingType;
      private Long userId;
      private Boolean boolCoatingEnum;
      private Boolean boolSinglePartEnum;
      private BigDecimal drawingWeight;
      private BigDecimal totalDrawingWeight;
      private List<ZnTechChangeMachinePartDTO> machinePartDTOList;

      ZnTechChangeArtifactDTOBuilder() {
      }

      public ZnTechChangeArtifactDTO.ZnTechChangeArtifactDTOBuilder orderNo(final Integer orderNo) {
         this.orderNo = orderNo;
         return this;
      }

      public ZnTechChangeArtifactDTO.ZnTechChangeArtifactDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ZnTechChangeArtifactDTO.ZnTechChangeArtifactDTOBuilder structureType(final String structureType) {
         this.structureType = structureType;
         return this;
      }

      public ZnTechChangeArtifactDTO.ZnTechChangeArtifactDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ZnTechChangeArtifactDTO.ZnTechChangeArtifactDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public ZnTechChangeArtifactDTO.ZnTechChangeArtifactDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public ZnTechChangeArtifactDTO.ZnTechChangeArtifactDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public ZnTechChangeArtifactDTO.ZnTechChangeArtifactDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public ZnTechChangeArtifactDTO.ZnTechChangeArtifactDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public ZnTechChangeArtifactDTO.ZnTechChangeArtifactDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      public ZnTechChangeArtifactDTO.ZnTechChangeArtifactDTOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      public ZnTechChangeArtifactDTO.ZnTechChangeArtifactDTOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      public ZnTechChangeArtifactDTO.ZnTechChangeArtifactDTOBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      public ZnTechChangeArtifactDTO.ZnTechChangeArtifactDTOBuilder specPrefix(final String specPrefix) {
         this.specPrefix = specPrefix;
         return this;
      }

      public ZnTechChangeArtifactDTO.ZnTechChangeArtifactDTOBuilder serialNumberPrefix(final String serialNumberPrefix) {
         this.serialNumberPrefix = serialNumberPrefix;
         return this;
      }

      public ZnTechChangeArtifactDTO.ZnTechChangeArtifactDTOBuilder structureClassId(final Long structureClassId) {
         this.structureClassId = structureClassId;
         return this;
      }

      public ZnTechChangeArtifactDTO.ZnTechChangeArtifactDTOBuilder boolPurlineClass(final Boolean boolPurlineClass) {
         this.boolPurlineClass = boolPurlineClass;
         return this;
      }

      public ZnTechChangeArtifactDTO.ZnTechChangeArtifactDTOBuilder boolBlastingEnum(final Boolean boolBlastingEnum) {
         this.boolBlastingEnum = boolBlastingEnum;
         return this;
      }

      public ZnTechChangeArtifactDTO.ZnTechChangeArtifactDTOBuilder topFlangeArea(final BigDecimal topFlangeArea) {
         this.topFlangeArea = topFlangeArea;
         return this;
      }

      public ZnTechChangeArtifactDTO.ZnTechChangeArtifactDTOBuilder boolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
         this.boolAllPartSendDirectly = boolAllPartSendDirectly;
         return this;
      }

      public ZnTechChangeArtifactDTO.ZnTechChangeArtifactDTOBuilder codingType(final Integer codingType) {
         this.codingType = codingType;
         return this;
      }

      public ZnTechChangeArtifactDTO.ZnTechChangeArtifactDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ZnTechChangeArtifactDTO.ZnTechChangeArtifactDTOBuilder boolCoatingEnum(final Boolean boolCoatingEnum) {
         this.boolCoatingEnum = boolCoatingEnum;
         return this;
      }

      public ZnTechChangeArtifactDTO.ZnTechChangeArtifactDTOBuilder boolSinglePartEnum(final Boolean boolSinglePartEnum) {
         this.boolSinglePartEnum = boolSinglePartEnum;
         return this;
      }

      public ZnTechChangeArtifactDTO.ZnTechChangeArtifactDTOBuilder drawingWeight(final BigDecimal drawingWeight) {
         this.drawingWeight = drawingWeight;
         return this;
      }

      public ZnTechChangeArtifactDTO.ZnTechChangeArtifactDTOBuilder totalDrawingWeight(final BigDecimal totalDrawingWeight) {
         this.totalDrawingWeight = totalDrawingWeight;
         return this;
      }

      public ZnTechChangeArtifactDTO.ZnTechChangeArtifactDTOBuilder machinePartDTOList(final List<ZnTechChangeMachinePartDTO> machinePartDTOList) {
         this.machinePartDTOList = machinePartDTOList;
         return this;
      }

      public ZnTechChangeArtifactDTO build() {
         return new ZnTechChangeArtifactDTO(
            this.orderNo,
            this.name,
            this.structureType,
            this.serialNumber,
            this.specification,
            this.material,
            this.length,
            this.quantity,
            this.netWeight,
            this.totalNetWeight,
            this.grossWeight,
            this.totalGrossWeight,
            this.surfaceArea,
            this.specPrefix,
            this.serialNumberPrefix,
            this.structureClassId,
            this.boolPurlineClass,
            this.boolBlastingEnum,
            this.topFlangeArea,
            this.boolAllPartSendDirectly,
            this.codingType,
            this.userId,
            this.boolCoatingEnum,
            this.boolSinglePartEnum,
            this.drawingWeight,
            this.totalDrawingWeight,
            this.machinePartDTOList
         );
      }

      @Override
      public String toString() {
         return "ZnTechChangeArtifactDTO.ZnTechChangeArtifactDTOBuilder(orderNo="
            + this.orderNo
            + ", name="
            + this.name
            + ", structureType="
            + this.structureType
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", length="
            + this.length
            + ", quantity="
            + this.quantity
            + ", netWeight="
            + this.netWeight
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", grossWeight="
            + this.grossWeight
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ", surfaceArea="
            + this.surfaceArea
            + ", specPrefix="
            + this.specPrefix
            + ", serialNumberPrefix="
            + this.serialNumberPrefix
            + ", structureClassId="
            + this.structureClassId
            + ", boolPurlineClass="
            + this.boolPurlineClass
            + ", boolBlastingEnum="
            + this.boolBlastingEnum
            + ", topFlangeArea="
            + this.topFlangeArea
            + ", boolAllPartSendDirectly="
            + this.boolAllPartSendDirectly
            + ", codingType="
            + this.codingType
            + ", userId="
            + this.userId
            + ", boolCoatingEnum="
            + this.boolCoatingEnum
            + ", boolSinglePartEnum="
            + this.boolSinglePartEnum
            + ", drawingWeight="
            + this.drawingWeight
            + ", totalDrawingWeight="
            + this.totalDrawingWeight
            + ", machinePartDTOList="
            + this.machinePartDTOList
            + ")";
      }
   }
}
