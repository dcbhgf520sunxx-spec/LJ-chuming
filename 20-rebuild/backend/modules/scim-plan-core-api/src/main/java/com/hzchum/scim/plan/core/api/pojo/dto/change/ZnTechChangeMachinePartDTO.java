package com.hzchum.scim.plan.core.api.pojo.dto.change;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

public class ZnTechChangeMachinePartDTO {
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
   @ApiModelProperty(name = "topFlangeArea", value = "上翼缘(单)面积(mm)²）")
   private BigDecimal topFlangeArea;
   @ApiModelProperty(name = "specPrefix", value = "规格前缀")
   private String specPrefix;
   @ApiModelProperty(name = "boolAllPartSendDirectly", value = "是否全部零件都是直发件 true 是 false 否")
   private Boolean boolAllPartSendDirectly;
   @ApiModelProperty(name = "boolSendDirectly", value = "是否直发件 true 是 false 否")
   private Boolean boolSendDirectly;
   @ApiModelProperty(name = "boolSchedulingEnum", value = "是否排产 TRUE是 false 否")
   private Boolean boolSchedulingEnum;
   @ApiModelProperty(name = "boolSectionSteel", value = "是否成品型材 [false 否, true 是]")
   private Boolean boolSectionSteel;
   @ApiModelProperty(name = "boolSinglePartEnum", value = "是否单零件类型构件 true是 false否")
   private Boolean boolSinglePartEnum;
   @ApiModelProperty(name = "steelId", value = "零部件种类Id")
   private Long steelId;
   @ApiModelProperty(name = "relationType", value = "关联类型")
   private Integer relationType;
   @ApiModelProperty(name = "machinePartImportList", value = "翼腹板")
   private List<ZnTechChangeMachinePartDTO> machinePartImportList;

   public static ZnTechChangeMachinePartDTO.ZnTechChangeMachinePartDTOBuilder builder() {
      return new ZnTechChangeMachinePartDTO.ZnTechChangeMachinePartDTOBuilder();
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

   public BigDecimal getTopFlangeArea() {
      return this.topFlangeArea;
   }

   public String getSpecPrefix() {
      return this.specPrefix;
   }

   public Boolean getBoolAllPartSendDirectly() {
      return this.boolAllPartSendDirectly;
   }

   public Boolean getBoolSendDirectly() {
      return this.boolSendDirectly;
   }

   public Boolean getBoolSchedulingEnum() {
      return this.boolSchedulingEnum;
   }

   public Boolean getBoolSectionSteel() {
      return this.boolSectionSteel;
   }

   public Boolean getBoolSinglePartEnum() {
      return this.boolSinglePartEnum;
   }

   public Long getSteelId() {
      return this.steelId;
   }

   public Integer getRelationType() {
      return this.relationType;
   }

   public List<ZnTechChangeMachinePartDTO> getMachinePartImportList() {
      return this.machinePartImportList;
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

   public void setTopFlangeArea(final BigDecimal topFlangeArea) {
      this.topFlangeArea = topFlangeArea;
   }

   public void setSpecPrefix(final String specPrefix) {
      this.specPrefix = specPrefix;
   }

   public void setBoolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
   }

   public void setBoolSendDirectly(final Boolean boolSendDirectly) {
      this.boolSendDirectly = boolSendDirectly;
   }

   public void setBoolSchedulingEnum(final Boolean boolSchedulingEnum) {
      this.boolSchedulingEnum = boolSchedulingEnum;
   }

   public void setBoolSectionSteel(final Boolean boolSectionSteel) {
      this.boolSectionSteel = boolSectionSteel;
   }

   public void setBoolSinglePartEnum(final Boolean boolSinglePartEnum) {
      this.boolSinglePartEnum = boolSinglePartEnum;
   }

   public void setSteelId(final Long steelId) {
      this.steelId = steelId;
   }

   public void setRelationType(final Integer relationType) {
      this.relationType = relationType;
   }

   public void setMachinePartImportList(final List<ZnTechChangeMachinePartDTO> machinePartImportList) {
      this.machinePartImportList = machinePartImportList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ZnTechChangeMachinePartDTO)) {
         return false;
      }

      ZnTechChangeMachinePartDTO other = (ZnTechChangeMachinePartDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$orderNo = this.getOrderNo();
      Object other$orderNo = other.getOrderNo();
      if (this$orderNo == null ? other$orderNo == null : this$orderNo.equals(other$orderNo)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
            Object other$boolAllPartSendDirectly = other.getBoolAllPartSendDirectly();
            if (this$boolAllPartSendDirectly == null
               ? other$boolAllPartSendDirectly == null
               : this$boolAllPartSendDirectly.equals(other$boolAllPartSendDirectly)) {
               Object this$boolSendDirectly = this.getBoolSendDirectly();
               Object other$boolSendDirectly = other.getBoolSendDirectly();
               if (this$boolSendDirectly == null ? other$boolSendDirectly == null : this$boolSendDirectly.equals(other$boolSendDirectly)) {
                  Object this$boolSchedulingEnum = this.getBoolSchedulingEnum();
                  Object other$boolSchedulingEnum = other.getBoolSchedulingEnum();
                  if (this$boolSchedulingEnum == null ? other$boolSchedulingEnum == null : this$boolSchedulingEnum.equals(other$boolSchedulingEnum)) {
                     Object this$boolSectionSteel = this.getBoolSectionSteel();
                     Object other$boolSectionSteel = other.getBoolSectionSteel();
                     if (this$boolSectionSteel == null ? other$boolSectionSteel == null : this$boolSectionSteel.equals(other$boolSectionSteel)) {
                        Object this$boolSinglePartEnum = this.getBoolSinglePartEnum();
                        Object other$boolSinglePartEnum = other.getBoolSinglePartEnum();
                        if (this$boolSinglePartEnum == null ? other$boolSinglePartEnum == null : this$boolSinglePartEnum.equals(other$boolSinglePartEnum)) {
                           Object this$steelId = this.getSteelId();
                           Object other$steelId = other.getSteelId();
                           if (this$steelId == null ? other$steelId == null : this$steelId.equals(other$steelId)) {
                              Object this$relationType = this.getRelationType();
                              Object other$relationType = other.getRelationType();
                              if (this$relationType == null ? other$relationType == null : this$relationType.equals(other$relationType)) {
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
                                                         if (this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight)) {
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
                                                                  Object this$topFlangeArea = this.getTopFlangeArea();
                                                                  Object other$topFlangeArea = other.getTopFlangeArea();
                                                                  if (this$topFlangeArea == null
                                                                     ? other$topFlangeArea == null
                                                                     : this$topFlangeArea.equals(other$topFlangeArea)) {
                                                                     Object this$specPrefix = this.getSpecPrefix();
                                                                     Object other$specPrefix = other.getSpecPrefix();
                                                                     if (this$specPrefix == null
                                                                        ? other$specPrefix == null
                                                                        : this$specPrefix.equals(other$specPrefix)) {
                                                                        Object this$machinePartImportList = this.getMachinePartImportList();
                                                                        Object other$machinePartImportList = other.getMachinePartImportList();
                                                                        return this$machinePartImportList == null
                                                                           ? other$machinePartImportList == null
                                                                           : this$machinePartImportList.equals(other$machinePartImportList);
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
      return other instanceof ZnTechChangeMachinePartDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderNo = this.getOrderNo();
      result = result * 59 + ($orderNo == null ? 43 : $orderNo.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
      result = result * 59 + ($boolAllPartSendDirectly == null ? 43 : $boolAllPartSendDirectly.hashCode());
      Object $boolSendDirectly = this.getBoolSendDirectly();
      result = result * 59 + ($boolSendDirectly == null ? 43 : $boolSendDirectly.hashCode());
      Object $boolSchedulingEnum = this.getBoolSchedulingEnum();
      result = result * 59 + ($boolSchedulingEnum == null ? 43 : $boolSchedulingEnum.hashCode());
      Object $boolSectionSteel = this.getBoolSectionSteel();
      result = result * 59 + ($boolSectionSteel == null ? 43 : $boolSectionSteel.hashCode());
      Object $boolSinglePartEnum = this.getBoolSinglePartEnum();
      result = result * 59 + ($boolSinglePartEnum == null ? 43 : $boolSinglePartEnum.hashCode());
      Object $steelId = this.getSteelId();
      result = result * 59 + ($steelId == null ? 43 : $steelId.hashCode());
      Object $relationType = this.getRelationType();
      result = result * 59 + ($relationType == null ? 43 : $relationType.hashCode());
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
      Object $topFlangeArea = this.getTopFlangeArea();
      result = result * 59 + ($topFlangeArea == null ? 43 : $topFlangeArea.hashCode());
      Object $specPrefix = this.getSpecPrefix();
      result = result * 59 + ($specPrefix == null ? 43 : $specPrefix.hashCode());
      Object $machinePartImportList = this.getMachinePartImportList();
      return result * 59 + ($machinePartImportList == null ? 43 : $machinePartImportList.hashCode());
   }

   @Override
   public String toString() {
      return "ZnTechChangeMachinePartDTO(orderNo="
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
         + ", topFlangeArea="
         + this.getTopFlangeArea()
         + ", specPrefix="
         + this.getSpecPrefix()
         + ", boolAllPartSendDirectly="
         + this.getBoolAllPartSendDirectly()
         + ", boolSendDirectly="
         + this.getBoolSendDirectly()
         + ", boolSchedulingEnum="
         + this.getBoolSchedulingEnum()
         + ", boolSectionSteel="
         + this.getBoolSectionSteel()
         + ", boolSinglePartEnum="
         + this.getBoolSinglePartEnum()
         + ", steelId="
         + this.getSteelId()
         + ", relationType="
         + this.getRelationType()
         + ", machinePartImportList="
         + this.getMachinePartImportList()
         + ")";
   }

   public ZnTechChangeMachinePartDTO() {
   }

   public ZnTechChangeMachinePartDTO(
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
      final BigDecimal topFlangeArea,
      final String specPrefix,
      final Boolean boolAllPartSendDirectly,
      final Boolean boolSendDirectly,
      final Boolean boolSchedulingEnum,
      final Boolean boolSectionSteel,
      final Boolean boolSinglePartEnum,
      final Long steelId,
      final Integer relationType,
      final List<ZnTechChangeMachinePartDTO> machinePartImportList
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
      this.topFlangeArea = topFlangeArea;
      this.specPrefix = specPrefix;
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
      this.boolSendDirectly = boolSendDirectly;
      this.boolSchedulingEnum = boolSchedulingEnum;
      this.boolSectionSteel = boolSectionSteel;
      this.boolSinglePartEnum = boolSinglePartEnum;
      this.steelId = steelId;
      this.relationType = relationType;
      this.machinePartImportList = machinePartImportList;
   }

   public static class ZnTechChangeMachinePartDTOBuilder {
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
      private BigDecimal topFlangeArea;
      private String specPrefix;
      private Boolean boolAllPartSendDirectly;
      private Boolean boolSendDirectly;
      private Boolean boolSchedulingEnum;
      private Boolean boolSectionSteel;
      private Boolean boolSinglePartEnum;
      private Long steelId;
      private Integer relationType;
      private List<ZnTechChangeMachinePartDTO> machinePartImportList;

      ZnTechChangeMachinePartDTOBuilder() {
      }

      public ZnTechChangeMachinePartDTO.ZnTechChangeMachinePartDTOBuilder orderNo(final Integer orderNo) {
         this.orderNo = orderNo;
         return this;
      }

      public ZnTechChangeMachinePartDTO.ZnTechChangeMachinePartDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ZnTechChangeMachinePartDTO.ZnTechChangeMachinePartDTOBuilder structureType(final String structureType) {
         this.structureType = structureType;
         return this;
      }

      public ZnTechChangeMachinePartDTO.ZnTechChangeMachinePartDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ZnTechChangeMachinePartDTO.ZnTechChangeMachinePartDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public ZnTechChangeMachinePartDTO.ZnTechChangeMachinePartDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public ZnTechChangeMachinePartDTO.ZnTechChangeMachinePartDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public ZnTechChangeMachinePartDTO.ZnTechChangeMachinePartDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public ZnTechChangeMachinePartDTO.ZnTechChangeMachinePartDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public ZnTechChangeMachinePartDTO.ZnTechChangeMachinePartDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      public ZnTechChangeMachinePartDTO.ZnTechChangeMachinePartDTOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      public ZnTechChangeMachinePartDTO.ZnTechChangeMachinePartDTOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      public ZnTechChangeMachinePartDTO.ZnTechChangeMachinePartDTOBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      public ZnTechChangeMachinePartDTO.ZnTechChangeMachinePartDTOBuilder topFlangeArea(final BigDecimal topFlangeArea) {
         this.topFlangeArea = topFlangeArea;
         return this;
      }

      public ZnTechChangeMachinePartDTO.ZnTechChangeMachinePartDTOBuilder specPrefix(final String specPrefix) {
         this.specPrefix = specPrefix;
         return this;
      }

      public ZnTechChangeMachinePartDTO.ZnTechChangeMachinePartDTOBuilder boolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
         this.boolAllPartSendDirectly = boolAllPartSendDirectly;
         return this;
      }

      public ZnTechChangeMachinePartDTO.ZnTechChangeMachinePartDTOBuilder boolSendDirectly(final Boolean boolSendDirectly) {
         this.boolSendDirectly = boolSendDirectly;
         return this;
      }

      public ZnTechChangeMachinePartDTO.ZnTechChangeMachinePartDTOBuilder boolSchedulingEnum(final Boolean boolSchedulingEnum) {
         this.boolSchedulingEnum = boolSchedulingEnum;
         return this;
      }

      public ZnTechChangeMachinePartDTO.ZnTechChangeMachinePartDTOBuilder boolSectionSteel(final Boolean boolSectionSteel) {
         this.boolSectionSteel = boolSectionSteel;
         return this;
      }

      public ZnTechChangeMachinePartDTO.ZnTechChangeMachinePartDTOBuilder boolSinglePartEnum(final Boolean boolSinglePartEnum) {
         this.boolSinglePartEnum = boolSinglePartEnum;
         return this;
      }

      public ZnTechChangeMachinePartDTO.ZnTechChangeMachinePartDTOBuilder steelId(final Long steelId) {
         this.steelId = steelId;
         return this;
      }

      public ZnTechChangeMachinePartDTO.ZnTechChangeMachinePartDTOBuilder relationType(final Integer relationType) {
         this.relationType = relationType;
         return this;
      }

      public ZnTechChangeMachinePartDTO.ZnTechChangeMachinePartDTOBuilder machinePartImportList(final List<ZnTechChangeMachinePartDTO> machinePartImportList) {
         this.machinePartImportList = machinePartImportList;
         return this;
      }

      public ZnTechChangeMachinePartDTO build() {
         return new ZnTechChangeMachinePartDTO(
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
            this.topFlangeArea,
            this.specPrefix,
            this.boolAllPartSendDirectly,
            this.boolSendDirectly,
            this.boolSchedulingEnum,
            this.boolSectionSteel,
            this.boolSinglePartEnum,
            this.steelId,
            this.relationType,
            this.machinePartImportList
         );
      }

      @Override
      public String toString() {
         return "ZnTechChangeMachinePartDTO.ZnTechChangeMachinePartDTOBuilder(orderNo="
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
            + ", topFlangeArea="
            + this.topFlangeArea
            + ", specPrefix="
            + this.specPrefix
            + ", boolAllPartSendDirectly="
            + this.boolAllPartSendDirectly
            + ", boolSendDirectly="
            + this.boolSendDirectly
            + ", boolSchedulingEnum="
            + this.boolSchedulingEnum
            + ", boolSectionSteel="
            + this.boolSectionSteel
            + ", boolSinglePartEnum="
            + this.boolSinglePartEnum
            + ", steelId="
            + this.steelId
            + ", relationType="
            + this.relationType
            + ", machinePartImportList="
            + this.machinePartImportList
            + ")";
      }
   }
}
