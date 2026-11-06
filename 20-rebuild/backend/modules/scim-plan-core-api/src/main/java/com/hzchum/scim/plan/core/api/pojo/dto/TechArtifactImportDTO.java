package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Map;

@ApiModel(value = "TechArtifact对象", description = "构件 ")
public class TechArtifactImportDTO {
   @ApiModelProperty(name = "orderNo", value = "序号")
   private Integer orderNo;
   @ApiModelProperty(name = "name", value = "名称")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   private String specification;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   private BigDecimal length;
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
   @ApiModelProperty(name = "surfaceArea", value = "面积（mm²）")
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "drawingNumber", value = "图号")
   private String drawingNumber;
   @ApiModelProperty(name = "remark", value = "备注")
   private String remark;
   @ApiModelProperty(name = "smartLineMarkWord", value = "智能生产线标记词")
   private String smartLineMarkWord;
   @ApiModelProperty(name = "是否涂装(Y/N)", value = "是否涂装 true是 false否")
   private Boolean boolCoatingEnum;
   @ApiModelProperty(name = "specPrefix", value = "规格前缀")
   private String specPrefix;
   @ApiModelProperty(name = "serialNumberPrefix", value = "编号前缀")
   private String serialNumberPrefix;
   @ApiModelProperty(name = "boolPurlineClass", value = "是否檩条")
   private Boolean boolPurlineClass;
   @ApiModelProperty(name = "boolSinglePartEnum", value = "是否单零件类型构件 true是 false否")
   private Boolean boolSinglePartEnum;
   @ApiModelProperty(name = "drawingWeight", value = "图纸单重")
   private BigDecimal drawingWeight;
   @ApiModelProperty(name = "drawingWeight", value = "图纸总重")
   private BigDecimal totalDrawingWeight;
   @ApiModelProperty(name = "machinePartImportMap", value = "零件列表")
   private Map<String, TechMachinePartImportDTO> machinePartImportMap;

   public static TechArtifactImportDTO.TechArtifactImportDTOBuilder builder() {
      return new TechArtifactImportDTO.TechArtifactImportDTOBuilder();
   }

   public TechArtifactImportDTO() {
   }

   public TechArtifactImportDTO(
      final Integer orderNo,
      final String name,
      final String serialNumber,
      final String specification,
      final BigDecimal length,
      final String material,
      final Integer quantity,
      final BigDecimal netWeight,
      final BigDecimal totalNetWeight,
      final BigDecimal grossWeight,
      final BigDecimal totalGrossWeight,
      final BigDecimal surfaceArea,
      final String drawingNumber,
      final String remark,
      final String smartLineMarkWord,
      final Boolean boolCoatingEnum,
      final String specPrefix,
      final String serialNumberPrefix,
      final Boolean boolPurlineClass,
      final Boolean boolSinglePartEnum,
      final BigDecimal drawingWeight,
      final BigDecimal totalDrawingWeight,
      final Map<String, TechMachinePartImportDTO> machinePartImportMap
   ) {
      this.orderNo = orderNo;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.length = length;
      this.material = material;
      this.quantity = quantity;
      this.netWeight = netWeight;
      this.totalNetWeight = totalNetWeight;
      this.grossWeight = grossWeight;
      this.totalGrossWeight = totalGrossWeight;
      this.surfaceArea = surfaceArea;
      this.drawingNumber = drawingNumber;
      this.remark = remark;
      this.smartLineMarkWord = smartLineMarkWord;
      this.boolCoatingEnum = boolCoatingEnum;
      this.specPrefix = specPrefix;
      this.serialNumberPrefix = serialNumberPrefix;
      this.boolPurlineClass = boolPurlineClass;
      this.boolSinglePartEnum = boolSinglePartEnum;
      this.drawingWeight = drawingWeight;
      this.totalDrawingWeight = totalDrawingWeight;
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

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public String getDrawingNumber() {
      return this.drawingNumber;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getSmartLineMarkWord() {
      return this.smartLineMarkWord;
   }

   public Boolean getBoolCoatingEnum() {
      return this.boolCoatingEnum;
   }

   public String getSpecPrefix() {
      return this.specPrefix;
   }

   public String getSerialNumberPrefix() {
      return this.serialNumberPrefix;
   }

   public Boolean getBoolPurlineClass() {
      return this.boolPurlineClass;
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

   public Map<String, TechMachinePartImportDTO> getMachinePartImportMap() {
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

   public void setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
   }

   public void setDrawingNumber(final String drawingNumber) {
      this.drawingNumber = drawingNumber;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setSmartLineMarkWord(final String smartLineMarkWord) {
      this.smartLineMarkWord = smartLineMarkWord;
   }

   public void setBoolCoatingEnum(final Boolean boolCoatingEnum) {
      this.boolCoatingEnum = boolCoatingEnum;
   }

   public void setSpecPrefix(final String specPrefix) {
      this.specPrefix = specPrefix;
   }

   public void setSerialNumberPrefix(final String serialNumberPrefix) {
      this.serialNumberPrefix = serialNumberPrefix;
   }

   public void setBoolPurlineClass(final Boolean boolPurlineClass) {
      this.boolPurlineClass = boolPurlineClass;
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

   public void setMachinePartImportMap(final Map<String, TechMachinePartImportDTO> machinePartImportMap) {
      this.machinePartImportMap = machinePartImportMap;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechArtifactImportDTO)) {
         return false;
      }

      TechArtifactImportDTO other = (TechArtifactImportDTO)o;
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
               Object this$boolPurlineClass = this.getBoolPurlineClass();
               Object other$boolPurlineClass = other.getBoolPurlineClass();
               if (this$boolPurlineClass == null ? other$boolPurlineClass == null : this$boolPurlineClass.equals(other$boolPurlineClass)) {
                  Object this$boolSinglePartEnum = this.getBoolSinglePartEnum();
                  Object other$boolSinglePartEnum = other.getBoolSinglePartEnum();
                  if (this$boolSinglePartEnum == null ? other$boolSinglePartEnum == null : this$boolSinglePartEnum.equals(other$boolSinglePartEnum)) {
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
                                                Object this$surfaceArea = this.getSurfaceArea();
                                                Object other$surfaceArea = other.getSurfaceArea();
                                                if (this$surfaceArea == null ? other$surfaceArea == null : this$surfaceArea.equals(other$surfaceArea)) {
                                                   Object this$drawingNumber = this.getDrawingNumber();
                                                   Object other$drawingNumber = other.getDrawingNumber();
                                                   if (this$drawingNumber == null
                                                      ? other$drawingNumber == null
                                                      : this$drawingNumber.equals(other$drawingNumber)) {
                                                      Object this$remark = this.getRemark();
                                                      Object other$remark = other.getRemark();
                                                      if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                         Object this$smartLineMarkWord = this.getSmartLineMarkWord();
                                                         Object other$smartLineMarkWord = other.getSmartLineMarkWord();
                                                         if (this$smartLineMarkWord == null
                                                            ? other$smartLineMarkWord == null
                                                            : this$smartLineMarkWord.equals(other$smartLineMarkWord)) {
                                                            Object this$specPrefix = this.getSpecPrefix();
                                                            Object other$specPrefix = other.getSpecPrefix();
                                                            if (this$specPrefix == null ? other$specPrefix == null : this$specPrefix.equals(other$specPrefix)) {
                                                               Object this$serialNumberPrefix = this.getSerialNumberPrefix();
                                                               Object other$serialNumberPrefix = other.getSerialNumberPrefix();
                                                               if (this$serialNumberPrefix == null
                                                                  ? other$serialNumberPrefix == null
                                                                  : this$serialNumberPrefix.equals(other$serialNumberPrefix)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TechArtifactImportDTO;
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
      Object $boolPurlineClass = this.getBoolPurlineClass();
      result = result * 59 + ($boolPurlineClass == null ? 43 : $boolPurlineClass.hashCode());
      Object $boolSinglePartEnum = this.getBoolSinglePartEnum();
      result = result * 59 + ($boolSinglePartEnum == null ? 43 : $boolSinglePartEnum.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
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
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $drawingNumber = this.getDrawingNumber();
      result = result * 59 + ($drawingNumber == null ? 43 : $drawingNumber.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $smartLineMarkWord = this.getSmartLineMarkWord();
      result = result * 59 + ($smartLineMarkWord == null ? 43 : $smartLineMarkWord.hashCode());
      Object $specPrefix = this.getSpecPrefix();
      result = result * 59 + ($specPrefix == null ? 43 : $specPrefix.hashCode());
      Object $serialNumberPrefix = this.getSerialNumberPrefix();
      result = result * 59 + ($serialNumberPrefix == null ? 43 : $serialNumberPrefix.hashCode());
      Object $drawingWeight = this.getDrawingWeight();
      result = result * 59 + ($drawingWeight == null ? 43 : $drawingWeight.hashCode());
      Object $totalDrawingWeight = this.getTotalDrawingWeight();
      result = result * 59 + ($totalDrawingWeight == null ? 43 : $totalDrawingWeight.hashCode());
      Object $machinePartImportMap = this.getMachinePartImportMap();
      return result * 59 + ($machinePartImportMap == null ? 43 : $machinePartImportMap.hashCode());
   }

   @Override
   public String toString() {
      return "TechArtifactImportDTO(orderNo="
         + this.getOrderNo()
         + ", name="
         + this.getName()
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
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", drawingNumber="
         + this.getDrawingNumber()
         + ", remark="
         + this.getRemark()
         + ", smartLineMarkWord="
         + this.getSmartLineMarkWord()
         + ", boolCoatingEnum="
         + this.getBoolCoatingEnum()
         + ", specPrefix="
         + this.getSpecPrefix()
         + ", serialNumberPrefix="
         + this.getSerialNumberPrefix()
         + ", boolPurlineClass="
         + this.getBoolPurlineClass()
         + ", boolSinglePartEnum="
         + this.getBoolSinglePartEnum()
         + ", drawingWeight="
         + this.getDrawingWeight()
         + ", totalDrawingWeight="
         + this.getTotalDrawingWeight()
         + ", machinePartImportMap="
         + this.getMachinePartImportMap()
         + ")";
   }

   public static class TechArtifactImportDTOBuilder {
      private Integer orderNo;
      private String name;
      private String serialNumber;
      private String specification;
      private BigDecimal length;
      private String material;
      private Integer quantity;
      private BigDecimal netWeight;
      private BigDecimal totalNetWeight;
      private BigDecimal grossWeight;
      private BigDecimal totalGrossWeight;
      private BigDecimal surfaceArea;
      private String drawingNumber;
      private String remark;
      private String smartLineMarkWord;
      private Boolean boolCoatingEnum;
      private String specPrefix;
      private String serialNumberPrefix;
      private Boolean boolPurlineClass;
      private Boolean boolSinglePartEnum;
      private BigDecimal drawingWeight;
      private BigDecimal totalDrawingWeight;
      private Map<String, TechMachinePartImportDTO> machinePartImportMap;

      TechArtifactImportDTOBuilder() {
      }

      public TechArtifactImportDTO.TechArtifactImportDTOBuilder orderNo(final Integer orderNo) {
         this.orderNo = orderNo;
         return this;
      }

      public TechArtifactImportDTO.TechArtifactImportDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public TechArtifactImportDTO.TechArtifactImportDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public TechArtifactImportDTO.TechArtifactImportDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public TechArtifactImportDTO.TechArtifactImportDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public TechArtifactImportDTO.TechArtifactImportDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public TechArtifactImportDTO.TechArtifactImportDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public TechArtifactImportDTO.TechArtifactImportDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public TechArtifactImportDTO.TechArtifactImportDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      public TechArtifactImportDTO.TechArtifactImportDTOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      public TechArtifactImportDTO.TechArtifactImportDTOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      public TechArtifactImportDTO.TechArtifactImportDTOBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      public TechArtifactImportDTO.TechArtifactImportDTOBuilder drawingNumber(final String drawingNumber) {
         this.drawingNumber = drawingNumber;
         return this;
      }

      public TechArtifactImportDTO.TechArtifactImportDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public TechArtifactImportDTO.TechArtifactImportDTOBuilder smartLineMarkWord(final String smartLineMarkWord) {
         this.smartLineMarkWord = smartLineMarkWord;
         return this;
      }

      public TechArtifactImportDTO.TechArtifactImportDTOBuilder boolCoatingEnum(final Boolean boolCoatingEnum) {
         this.boolCoatingEnum = boolCoatingEnum;
         return this;
      }

      public TechArtifactImportDTO.TechArtifactImportDTOBuilder specPrefix(final String specPrefix) {
         this.specPrefix = specPrefix;
         return this;
      }

      public TechArtifactImportDTO.TechArtifactImportDTOBuilder serialNumberPrefix(final String serialNumberPrefix) {
         this.serialNumberPrefix = serialNumberPrefix;
         return this;
      }

      public TechArtifactImportDTO.TechArtifactImportDTOBuilder boolPurlineClass(final Boolean boolPurlineClass) {
         this.boolPurlineClass = boolPurlineClass;
         return this;
      }

      public TechArtifactImportDTO.TechArtifactImportDTOBuilder boolSinglePartEnum(final Boolean boolSinglePartEnum) {
         this.boolSinglePartEnum = boolSinglePartEnum;
         return this;
      }

      public TechArtifactImportDTO.TechArtifactImportDTOBuilder drawingWeight(final BigDecimal drawingWeight) {
         this.drawingWeight = drawingWeight;
         return this;
      }

      public TechArtifactImportDTO.TechArtifactImportDTOBuilder totalDrawingWeight(final BigDecimal totalDrawingWeight) {
         this.totalDrawingWeight = totalDrawingWeight;
         return this;
      }

      public TechArtifactImportDTO.TechArtifactImportDTOBuilder machinePartImportMap(final Map<String, TechMachinePartImportDTO> machinePartImportMap) {
         this.machinePartImportMap = machinePartImportMap;
         return this;
      }

      public TechArtifactImportDTO build() {
         return new TechArtifactImportDTO(
            this.orderNo,
            this.name,
            this.serialNumber,
            this.specification,
            this.length,
            this.material,
            this.quantity,
            this.netWeight,
            this.totalNetWeight,
            this.grossWeight,
            this.totalGrossWeight,
            this.surfaceArea,
            this.drawingNumber,
            this.remark,
            this.smartLineMarkWord,
            this.boolCoatingEnum,
            this.specPrefix,
            this.serialNumberPrefix,
            this.boolPurlineClass,
            this.boolSinglePartEnum,
            this.drawingWeight,
            this.totalDrawingWeight,
            this.machinePartImportMap
         );
      }

      @Override
      public String toString() {
         return "TechArtifactImportDTO.TechArtifactImportDTOBuilder(orderNo="
            + this.orderNo
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", length="
            + this.length
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
            + ", surfaceArea="
            + this.surfaceArea
            + ", drawingNumber="
            + this.drawingNumber
            + ", remark="
            + this.remark
            + ", smartLineMarkWord="
            + this.smartLineMarkWord
            + ", boolCoatingEnum="
            + this.boolCoatingEnum
            + ", specPrefix="
            + this.specPrefix
            + ", serialNumberPrefix="
            + this.serialNumberPrefix
            + ", boolPurlineClass="
            + this.boolPurlineClass
            + ", boolSinglePartEnum="
            + this.boolSinglePartEnum
            + ", drawingWeight="
            + this.drawingWeight
            + ", totalDrawingWeight="
            + this.totalDrawingWeight
            + ", machinePartImportMap="
            + this.machinePartImportMap
            + ")";
      }
   }
}
