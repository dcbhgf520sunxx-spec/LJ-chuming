package com.hzchum.scim.plan.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Map;

@ApiModel(value = "ZnljBridgeElementImportDtoParam对象", description = "桥梁单元件")
public class ZnljBridgeElementImportDtoParam {
   @ApiModelProperty(name = "orderNo", value = "序号")
   private Integer orderNo;
   @ApiModelProperty(name = "name", value = "零件名称")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   private String specification;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   private BigDecimal length;
   @ApiModelProperty(name = "thickness", value = "厚度(mm)")
   private BigDecimal thickness;
   @ApiModelProperty(name = "width", value = "宽度(mm)")
   private BigDecimal width;
   @ApiModelProperty(name = "material", value = "材质")
   private String material;
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
   @ApiModelProperty(name = "remark", value = "备注")
   private String remark;
   @ApiModelProperty(name = "specPrefix", value = "规格前缀")
   private String specPrefix;
   @ApiModelProperty(name = "steelId", value = "零件(部件)定义ID")
   private Long steelId;
   @ApiModelProperty(name = "boolSchedulingEnum", value = "是否排产 TRUE是 false 否")
   private Boolean boolSchedulingEnum;
   @ApiModelProperty(name = "boolSectionSteel", value = "是否成品型材 [false 否, true 是]")
   private Boolean boolSectionSteel;
   @ApiModelProperty("桥顶面油漆(单)面积(mm2)")
   private BigDecimal topPaintArea;
   @ApiModelProperty("内表面油漆(单)面积(mm2)")
   private BigDecimal innerPaintArea;
   @ApiModelProperty("外表面油漆(单)面积(mm2)")
   private BigDecimal outerPaintArea;
   @ApiModelProperty("U肋油漆(单)面积(mm2)")
   private BigDecimal uRibPaintArea;
   @ApiModelProperty("桥顶面油漆总面积(mm2)")
   private BigDecimal totalTopPaintArea;
   @ApiModelProperty("内表面油漆总面积(mm2)")
   private BigDecimal totalInnerPaintArea;
   @ApiModelProperty("外表面油漆总面积(mm2)")
   private BigDecimal totalOuterPaintArea;
   @ApiModelProperty("U肋油漆总面积(mm2)")
   private BigDecimal totalURibPaintArea;
   @ApiModelProperty(name = "machinePartImportMap", value = "零件列表")
   private Map<String, ZnljBridgeMachinePartImportDtoParam> machinePartImportMap;

   public static ZnljBridgeElementImportDtoParam.ZnljBridgeElementImportDtoParamBuilder builder() {
      return new ZnljBridgeElementImportDtoParam.ZnljBridgeElementImportDtoParamBuilder();
   }

   public ZnljBridgeElementImportDtoParam() {
   }

   public ZnljBridgeElementImportDtoParam(
      final Integer orderNo,
      final String name,
      final String serialNumber,
      final String specification,
      final BigDecimal length,
      final BigDecimal thickness,
      final BigDecimal width,
      final String material,
      final Integer quantity,
      final BigDecimal netWeight,
      final BigDecimal totalNetWeight,
      final BigDecimal grossWeight,
      final BigDecimal totalGrossWeight,
      final String remark,
      final String specPrefix,
      final Long steelId,
      final Boolean boolSchedulingEnum,
      final Boolean boolSectionSteel,
      final BigDecimal topPaintArea,
      final BigDecimal innerPaintArea,
      final BigDecimal outerPaintArea,
      final BigDecimal uRibPaintArea,
      final BigDecimal totalTopPaintArea,
      final BigDecimal totalInnerPaintArea,
      final BigDecimal totalOuterPaintArea,
      final BigDecimal totalURibPaintArea,
      final Map<String, ZnljBridgeMachinePartImportDtoParam> machinePartImportMap
   ) {
      this.orderNo = orderNo;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.length = length;
      this.thickness = thickness;
      this.width = width;
      this.material = material;
      this.quantity = quantity;
      this.netWeight = netWeight;
      this.totalNetWeight = totalNetWeight;
      this.grossWeight = grossWeight;
      this.totalGrossWeight = totalGrossWeight;
      this.remark = remark;
      this.specPrefix = specPrefix;
      this.steelId = steelId;
      this.boolSchedulingEnum = boolSchedulingEnum;
      this.boolSectionSteel = boolSectionSteel;
      this.topPaintArea = topPaintArea;
      this.innerPaintArea = innerPaintArea;
      this.outerPaintArea = outerPaintArea;
      this.uRibPaintArea = uRibPaintArea;
      this.totalTopPaintArea = totalTopPaintArea;
      this.totalInnerPaintArea = totalInnerPaintArea;
      this.totalOuterPaintArea = totalOuterPaintArea;
      this.totalURibPaintArea = totalURibPaintArea;
      this.machinePartImportMap = machinePartImportMap;
   }

   public Integer getOrderNo() {
      return this.orderNo;
   }

   public String getName() {
      return this.name;
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

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BigDecimal getWidth() {
      return this.width;
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

   public String getRemark() {
      return this.remark;
   }

   public String getSpecPrefix() {
      return this.specPrefix;
   }

   public Long getSteelId() {
      return this.steelId;
   }

   public Boolean getBoolSchedulingEnum() {
      return this.boolSchedulingEnum;
   }

   public Boolean getBoolSectionSteel() {
      return this.boolSectionSteel;
   }

   public BigDecimal getTopPaintArea() {
      return this.topPaintArea;
   }

   public BigDecimal getInnerPaintArea() {
      return this.innerPaintArea;
   }

   public BigDecimal getOuterPaintArea() {
      return this.outerPaintArea;
   }

   public BigDecimal getURibPaintArea() {
      return this.uRibPaintArea;
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

   public Map<String, ZnljBridgeMachinePartImportDtoParam> getMachinePartImportMap() {
      return this.machinePartImportMap;
   }

   public void setOrderNo(final Integer orderNo) {
      this.orderNo = orderNo;
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

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setWidth(final BigDecimal width) {
      this.width = width;
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

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setSpecPrefix(final String specPrefix) {
      this.specPrefix = specPrefix;
   }

   public void setSteelId(final Long steelId) {
      this.steelId = steelId;
   }

   public void setBoolSchedulingEnum(final Boolean boolSchedulingEnum) {
      this.boolSchedulingEnum = boolSchedulingEnum;
   }

   public void setBoolSectionSteel(final Boolean boolSectionSteel) {
      this.boolSectionSteel = boolSectionSteel;
   }

   public void setTopPaintArea(final BigDecimal topPaintArea) {
      this.topPaintArea = topPaintArea;
   }

   public void setInnerPaintArea(final BigDecimal innerPaintArea) {
      this.innerPaintArea = innerPaintArea;
   }

   public void setOuterPaintArea(final BigDecimal outerPaintArea) {
      this.outerPaintArea = outerPaintArea;
   }

   public void setURibPaintArea(final BigDecimal uRibPaintArea) {
      this.uRibPaintArea = uRibPaintArea;
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

   public void setMachinePartImportMap(final Map<String, ZnljBridgeMachinePartImportDtoParam> machinePartImportMap) {
      this.machinePartImportMap = machinePartImportMap;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ZnljBridgeElementImportDtoParam)) {
         return false;
      }

      ZnljBridgeElementImportDtoParam other = (ZnljBridgeElementImportDtoParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$orderNo = this.getOrderNo();
      Object other$orderNo = other.getOrderNo();
      if (this$orderNo == null ? other$orderNo == null : this$orderNo.equals(other$orderNo)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$steelId = this.getSteelId();
            Object other$steelId = other.getSteelId();
            if (this$steelId == null ? other$steelId == null : this$steelId.equals(other$steelId)) {
               Object this$boolSchedulingEnum = this.getBoolSchedulingEnum();
               Object other$boolSchedulingEnum = other.getBoolSchedulingEnum();
               if (this$boolSchedulingEnum == null ? other$boolSchedulingEnum == null : this$boolSchedulingEnum.equals(other$boolSchedulingEnum)) {
                  Object this$boolSectionSteel = this.getBoolSectionSteel();
                  Object other$boolSectionSteel = other.getBoolSectionSteel();
                  if (this$boolSectionSteel == null ? other$boolSectionSteel == null : this$boolSectionSteel.equals(other$boolSectionSteel)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                        Object this$serialNumber = this.getSerialNumber();
                        Object other$serialNumber = other.getSerialNumber();
                        if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                           Object this$specification = this.getSpecification();
                           Object other$specification = other.getSpecification();
                           if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                              Object this$length = this.getLength();
                              Object other$length = other.getLength();
                              if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                 Object this$thickness = this.getThickness();
                                 Object other$thickness = other.getThickness();
                                 if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                    Object this$width = this.getWidth();
                                    Object other$width = other.getWidth();
                                    if (this$width == null ? other$width == null : this$width.equals(other$width)) {
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
                                                      Object this$remark = this.getRemark();
                                                      Object other$remark = other.getRemark();
                                                      if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                         Object this$specPrefix = this.getSpecPrefix();
                                                         Object other$specPrefix = other.getSpecPrefix();
                                                         if (this$specPrefix == null ? other$specPrefix == null : this$specPrefix.equals(other$specPrefix)) {
                                                            Object this$topPaintArea = this.getTopPaintArea();
                                                            Object other$topPaintArea = other.getTopPaintArea();
                                                            if (this$topPaintArea == null
                                                               ? other$topPaintArea == null
                                                               : this$topPaintArea.equals(other$topPaintArea)) {
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
                                                                     Object this$uRibPaintArea = this.getURibPaintArea();
                                                                     Object other$uRibPaintArea = other.getURibPaintArea();
                                                                     if (this$uRibPaintArea == null
                                                                        ? other$uRibPaintArea == null
                                                                        : this$uRibPaintArea.equals(other$uRibPaintArea)) {
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
                                                                                    Object this$machinePartImportMap = this.getMachinePartImportMap();
                                                                                    Object other$machinePartImportMap = other.getMachinePartImportMap();
                                                                                    return this$machinePartImportMap == null
                                                                                       ? other$machinePartImportMap == null
                                                                                       : this$machinePartImportMap.equals(other$machinePartImportMap);
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
      return other instanceof ZnljBridgeElementImportDtoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderNo = this.getOrderNo();
      result = result * 59 + ($orderNo == null ? 43 : $orderNo.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $steelId = this.getSteelId();
      result = result * 59 + ($steelId == null ? 43 : $steelId.hashCode());
      Object $boolSchedulingEnum = this.getBoolSchedulingEnum();
      result = result * 59 + ($boolSchedulingEnum == null ? 43 : $boolSchedulingEnum.hashCode());
      Object $boolSectionSteel = this.getBoolSectionSteel();
      result = result * 59 + ($boolSectionSteel == null ? 43 : $boolSectionSteel.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
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
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $specPrefix = this.getSpecPrefix();
      result = result * 59 + ($specPrefix == null ? 43 : $specPrefix.hashCode());
      Object $topPaintArea = this.getTopPaintArea();
      result = result * 59 + ($topPaintArea == null ? 43 : $topPaintArea.hashCode());
      Object $innerPaintArea = this.getInnerPaintArea();
      result = result * 59 + ($innerPaintArea == null ? 43 : $innerPaintArea.hashCode());
      Object $outerPaintArea = this.getOuterPaintArea();
      result = result * 59 + ($outerPaintArea == null ? 43 : $outerPaintArea.hashCode());
      Object $uRibPaintArea = this.getURibPaintArea();
      result = result * 59 + ($uRibPaintArea == null ? 43 : $uRibPaintArea.hashCode());
      Object $totalTopPaintArea = this.getTotalTopPaintArea();
      result = result * 59 + ($totalTopPaintArea == null ? 43 : $totalTopPaintArea.hashCode());
      Object $totalInnerPaintArea = this.getTotalInnerPaintArea();
      result = result * 59 + ($totalInnerPaintArea == null ? 43 : $totalInnerPaintArea.hashCode());
      Object $totalOuterPaintArea = this.getTotalOuterPaintArea();
      result = result * 59 + ($totalOuterPaintArea == null ? 43 : $totalOuterPaintArea.hashCode());
      Object $totalURibPaintArea = this.getTotalURibPaintArea();
      result = result * 59 + ($totalURibPaintArea == null ? 43 : $totalURibPaintArea.hashCode());
      Object $machinePartImportMap = this.getMachinePartImportMap();
      return result * 59 + ($machinePartImportMap == null ? 43 : $machinePartImportMap.hashCode());
   }

   @Override
   public String toString() {
      return "ZnljBridgeElementImportDtoParam(orderNo="
         + this.getOrderNo()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", thickness="
         + this.getThickness()
         + ", width="
         + this.getWidth()
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
         + ", remark="
         + this.getRemark()
         + ", specPrefix="
         + this.getSpecPrefix()
         + ", steelId="
         + this.getSteelId()
         + ", boolSchedulingEnum="
         + this.getBoolSchedulingEnum()
         + ", boolSectionSteel="
         + this.getBoolSectionSteel()
         + ", topPaintArea="
         + this.getTopPaintArea()
         + ", innerPaintArea="
         + this.getInnerPaintArea()
         + ", outerPaintArea="
         + this.getOuterPaintArea()
         + ", uRibPaintArea="
         + this.getURibPaintArea()
         + ", totalTopPaintArea="
         + this.getTotalTopPaintArea()
         + ", totalInnerPaintArea="
         + this.getTotalInnerPaintArea()
         + ", totalOuterPaintArea="
         + this.getTotalOuterPaintArea()
         + ", totalURibPaintArea="
         + this.getTotalURibPaintArea()
         + ", machinePartImportMap="
         + this.getMachinePartImportMap()
         + ")";
   }

   public static class ZnljBridgeElementImportDtoParamBuilder {
      private Integer orderNo;
      private String name;
      private String serialNumber;
      private String specification;
      private BigDecimal length;
      private BigDecimal thickness;
      private BigDecimal width;
      private String material;
      private Integer quantity;
      private BigDecimal netWeight;
      private BigDecimal totalNetWeight;
      private BigDecimal grossWeight;
      private BigDecimal totalGrossWeight;
      private String remark;
      private String specPrefix;
      private Long steelId;
      private Boolean boolSchedulingEnum;
      private Boolean boolSectionSteel;
      private BigDecimal topPaintArea;
      private BigDecimal innerPaintArea;
      private BigDecimal outerPaintArea;
      private BigDecimal uRibPaintArea;
      private BigDecimal totalTopPaintArea;
      private BigDecimal totalInnerPaintArea;
      private BigDecimal totalOuterPaintArea;
      private BigDecimal totalURibPaintArea;
      private Map<String, ZnljBridgeMachinePartImportDtoParam> machinePartImportMap;

      ZnljBridgeElementImportDtoParamBuilder() {
      }

      public ZnljBridgeElementImportDtoParam.ZnljBridgeElementImportDtoParamBuilder orderNo(final Integer orderNo) {
         this.orderNo = orderNo;
         return this;
      }

      public ZnljBridgeElementImportDtoParam.ZnljBridgeElementImportDtoParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ZnljBridgeElementImportDtoParam.ZnljBridgeElementImportDtoParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ZnljBridgeElementImportDtoParam.ZnljBridgeElementImportDtoParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public ZnljBridgeElementImportDtoParam.ZnljBridgeElementImportDtoParamBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public ZnljBridgeElementImportDtoParam.ZnljBridgeElementImportDtoParamBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public ZnljBridgeElementImportDtoParam.ZnljBridgeElementImportDtoParamBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public ZnljBridgeElementImportDtoParam.ZnljBridgeElementImportDtoParamBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public ZnljBridgeElementImportDtoParam.ZnljBridgeElementImportDtoParamBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public ZnljBridgeElementImportDtoParam.ZnljBridgeElementImportDtoParamBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public ZnljBridgeElementImportDtoParam.ZnljBridgeElementImportDtoParamBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      public ZnljBridgeElementImportDtoParam.ZnljBridgeElementImportDtoParamBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      public ZnljBridgeElementImportDtoParam.ZnljBridgeElementImportDtoParamBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      public ZnljBridgeElementImportDtoParam.ZnljBridgeElementImportDtoParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ZnljBridgeElementImportDtoParam.ZnljBridgeElementImportDtoParamBuilder specPrefix(final String specPrefix) {
         this.specPrefix = specPrefix;
         return this;
      }

      public ZnljBridgeElementImportDtoParam.ZnljBridgeElementImportDtoParamBuilder steelId(final Long steelId) {
         this.steelId = steelId;
         return this;
      }

      public ZnljBridgeElementImportDtoParam.ZnljBridgeElementImportDtoParamBuilder boolSchedulingEnum(final Boolean boolSchedulingEnum) {
         this.boolSchedulingEnum = boolSchedulingEnum;
         return this;
      }

      public ZnljBridgeElementImportDtoParam.ZnljBridgeElementImportDtoParamBuilder boolSectionSteel(final Boolean boolSectionSteel) {
         this.boolSectionSteel = boolSectionSteel;
         return this;
      }

      public ZnljBridgeElementImportDtoParam.ZnljBridgeElementImportDtoParamBuilder topPaintArea(final BigDecimal topPaintArea) {
         this.topPaintArea = topPaintArea;
         return this;
      }

      public ZnljBridgeElementImportDtoParam.ZnljBridgeElementImportDtoParamBuilder innerPaintArea(final BigDecimal innerPaintArea) {
         this.innerPaintArea = innerPaintArea;
         return this;
      }

      public ZnljBridgeElementImportDtoParam.ZnljBridgeElementImportDtoParamBuilder outerPaintArea(final BigDecimal outerPaintArea) {
         this.outerPaintArea = outerPaintArea;
         return this;
      }

      public ZnljBridgeElementImportDtoParam.ZnljBridgeElementImportDtoParamBuilder uRibPaintArea(final BigDecimal uRibPaintArea) {
         this.uRibPaintArea = uRibPaintArea;
         return this;
      }

      public ZnljBridgeElementImportDtoParam.ZnljBridgeElementImportDtoParamBuilder totalTopPaintArea(final BigDecimal totalTopPaintArea) {
         this.totalTopPaintArea = totalTopPaintArea;
         return this;
      }

      public ZnljBridgeElementImportDtoParam.ZnljBridgeElementImportDtoParamBuilder totalInnerPaintArea(final BigDecimal totalInnerPaintArea) {
         this.totalInnerPaintArea = totalInnerPaintArea;
         return this;
      }

      public ZnljBridgeElementImportDtoParam.ZnljBridgeElementImportDtoParamBuilder totalOuterPaintArea(final BigDecimal totalOuterPaintArea) {
         this.totalOuterPaintArea = totalOuterPaintArea;
         return this;
      }

      public ZnljBridgeElementImportDtoParam.ZnljBridgeElementImportDtoParamBuilder totalURibPaintArea(final BigDecimal totalURibPaintArea) {
         this.totalURibPaintArea = totalURibPaintArea;
         return this;
      }

      public ZnljBridgeElementImportDtoParam.ZnljBridgeElementImportDtoParamBuilder machinePartImportMap(
         final Map<String, ZnljBridgeMachinePartImportDtoParam> machinePartImportMap
      ) {
         this.machinePartImportMap = machinePartImportMap;
         return this;
      }

      public ZnljBridgeElementImportDtoParam build() {
         return new ZnljBridgeElementImportDtoParam(
            this.orderNo,
            this.name,
            this.serialNumber,
            this.specification,
            this.length,
            this.thickness,
            this.width,
            this.material,
            this.quantity,
            this.netWeight,
            this.totalNetWeight,
            this.grossWeight,
            this.totalGrossWeight,
            this.remark,
            this.specPrefix,
            this.steelId,
            this.boolSchedulingEnum,
            this.boolSectionSteel,
            this.topPaintArea,
            this.innerPaintArea,
            this.outerPaintArea,
            this.uRibPaintArea,
            this.totalTopPaintArea,
            this.totalInnerPaintArea,
            this.totalOuterPaintArea,
            this.totalURibPaintArea,
            this.machinePartImportMap
         );
      }

      @Override
      public String toString() {
         return "ZnljBridgeElementImportDtoParam.ZnljBridgeElementImportDtoParamBuilder(orderNo="
            + this.orderNo
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", length="
            + this.length
            + ", thickness="
            + this.thickness
            + ", width="
            + this.width
            + ", material="
            + this.material
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
            + ", remark="
            + this.remark
            + ", specPrefix="
            + this.specPrefix
            + ", steelId="
            + this.steelId
            + ", boolSchedulingEnum="
            + this.boolSchedulingEnum
            + ", boolSectionSteel="
            + this.boolSectionSteel
            + ", topPaintArea="
            + this.topPaintArea
            + ", innerPaintArea="
            + this.innerPaintArea
            + ", outerPaintArea="
            + this.outerPaintArea
            + ", uRibPaintArea="
            + this.uRibPaintArea
            + ", totalTopPaintArea="
            + this.totalTopPaintArea
            + ", totalInnerPaintArea="
            + this.totalInnerPaintArea
            + ", totalOuterPaintArea="
            + this.totalOuterPaintArea
            + ", totalURibPaintArea="
            + this.totalURibPaintArea
            + ", machinePartImportMap="
            + this.machinePartImportMap
            + ")";
      }
   }
}
