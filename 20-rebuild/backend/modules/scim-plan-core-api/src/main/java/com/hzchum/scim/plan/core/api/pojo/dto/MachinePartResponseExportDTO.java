package com.hzchum.scim.plan.core.api.pojo.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("零件清单明细导出")
public class MachinePartResponseExportDTO {
   @ApiModelProperty(name = "id", value = "零件id")
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   @Excel(name = "编号", width = 20.0)
   private String serialNumber;
   @ApiModelProperty(name = "name", value = "名称")
   private String name;
   @ApiModelProperty(name = "monomerId", value = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "monomerName", value = "单体名称")
   @Excel(name = "单体名称", width = 20.0)
   private String monomerName;
   @ApiModelProperty(name = "areaName", value = "区域名称")
   @Excel(name = "区域名称", width = 20.0)
   private String areaName;
   @ApiModelProperty(name = "areaBatchName", value = "批次名称")
   @Excel(name = "批次名称", width = 20.0)
   private String areaBatchName;
   @ApiModelProperty(name = "areaId", value = "区域id")
   private Long areaId;
   @ApiModelProperty(name = "specification", value = "规格")
   @Excel(name = "规格", width = 20.0)
   private String specification;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   @Excel(name = "长度（mm）", width = 20.0)
   private BigDecimal length;
   @ApiModelProperty(name = "material", value = "材质")
   @Excel(name = "材质", width = 20.0)
   private String material;
   @ApiModelProperty(name = "quantity", value = "数量")
   @Excel(name = "数量", width = 20.0)
   private Integer quantity;
   @ApiModelProperty(name = "netWeight", value = "单净重（kg）")
   @Excel(name = "单净重（kg）", width = 20.0)
   private BigDecimal netWeight;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重（kg）")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "grossWeight", value = "单毛重（kg）")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "totalGrossWeight", value = "总毛重（kg）")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "surfaceArea", value = "单面积（mm²）")
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "drawingNumber", value = "图号")
   private String drawingNumber;
   @ApiModelProperty(name = "type", value = "类型 1剪板 2数控")
   private Integer type;
   @ApiModelProperty(name = "remark", value = "备注")
   private String remark;
   @ApiModelProperty(name = "producedQuantity", value = "总生产量")
   private Integer producedQuantity;
   @ApiModelProperty(name = "usedQuantity", value = "已使用量")
   private Integer usedQuantity;
   @ApiModelProperty(name = "boolSchedulingEnum", value = "是否排产 TRUE是 false 否")
   private Boolean boolSchedulingEnum;
   @ApiModelProperty(name = "boolProcess", value = "是否有工序 true是 false否")
   private Boolean boolProcess;
   @ApiModelProperty(name = "boolHaveHole", value = "是否有孔 true 有孔 false 无孔")
   private Boolean boolHaveHole;
   @ApiModelProperty(name = "holeNumber", value = "孔的数量")
   private Long holeNumber;
   @ApiModelProperty(name = "boolSendDirectly", value = "是否直发件 true 是 false 否")
   private Boolean boolSendDirectly;

   public static MachinePartResponseExportDTO.MachinePartResponseExportDTOBuilder builder() {
      return new MachinePartResponseExportDTO.MachinePartResponseExportDTOBuilder();
   }

   public MachinePartResponseExportDTO() {
   }

   public MachinePartResponseExportDTO(
      final Long id,
      final String serialNumber,
      final String name,
      final Long monomerId,
      final String monomerName,
      final String areaName,
      final String areaBatchName,
      final Long areaId,
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
      final Integer type,
      final String remark,
      final Integer producedQuantity,
      final Integer usedQuantity,
      final Boolean boolSchedulingEnum,
      final Boolean boolProcess,
      final Boolean boolHaveHole,
      final Long holeNumber,
      final Boolean boolSendDirectly
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.name = name;
      this.monomerId = monomerId;
      this.monomerName = monomerName;
      this.areaName = areaName;
      this.areaBatchName = areaBatchName;
      this.areaId = areaId;
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
      this.type = type;
      this.remark = remark;
      this.producedQuantity = producedQuantity;
      this.usedQuantity = usedQuantity;
      this.boolSchedulingEnum = boolSchedulingEnum;
      this.boolProcess = boolProcess;
      this.boolHaveHole = boolHaveHole;
      this.holeNumber = holeNumber;
      this.boolSendDirectly = boolSendDirectly;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getName() {
      return this.name;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public String getAreaBatchName() {
      return this.areaBatchName;
   }

   public Long getAreaId() {
      return this.areaId;
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

   public Integer getType() {
      return this.type;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getProducedQuantity() {
      return this.producedQuantity;
   }

   public Integer getUsedQuantity() {
      return this.usedQuantity;
   }

   public Boolean getBoolSchedulingEnum() {
      return this.boolSchedulingEnum;
   }

   public Boolean getBoolProcess() {
      return this.boolProcess;
   }

   public Boolean getBoolHaveHole() {
      return this.boolHaveHole;
   }

   public Long getHoleNumber() {
      return this.holeNumber;
   }

   public Boolean getBoolSendDirectly() {
      return this.boolSendDirectly;
   }

   public MachinePartResponseExportDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public MachinePartResponseExportDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public MachinePartResponseExportDTO setName(final String name) {
      this.name = name;
      return this;
   }

   public MachinePartResponseExportDTO setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public MachinePartResponseExportDTO setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
      return this;
   }

   public MachinePartResponseExportDTO setAreaName(final String areaName) {
      this.areaName = areaName;
      return this;
   }

   public MachinePartResponseExportDTO setAreaBatchName(final String areaBatchName) {
      this.areaBatchName = areaBatchName;
      return this;
   }

   public MachinePartResponseExportDTO setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public MachinePartResponseExportDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   public MachinePartResponseExportDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   public MachinePartResponseExportDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   public MachinePartResponseExportDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   public MachinePartResponseExportDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   public MachinePartResponseExportDTO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   public MachinePartResponseExportDTO setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   public MachinePartResponseExportDTO setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   public MachinePartResponseExportDTO setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
      return this;
   }

   public MachinePartResponseExportDTO setDrawingNumber(final String drawingNumber) {
      this.drawingNumber = drawingNumber;
      return this;
   }

   public MachinePartResponseExportDTO setType(final Integer type) {
      this.type = type;
      return this;
   }

   public MachinePartResponseExportDTO setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public MachinePartResponseExportDTO setProducedQuantity(final Integer producedQuantity) {
      this.producedQuantity = producedQuantity;
      return this;
   }

   public MachinePartResponseExportDTO setUsedQuantity(final Integer usedQuantity) {
      this.usedQuantity = usedQuantity;
      return this;
   }

   public MachinePartResponseExportDTO setBoolSchedulingEnum(final Boolean boolSchedulingEnum) {
      this.boolSchedulingEnum = boolSchedulingEnum;
      return this;
   }

   public MachinePartResponseExportDTO setBoolProcess(final Boolean boolProcess) {
      this.boolProcess = boolProcess;
      return this;
   }

   public MachinePartResponseExportDTO setBoolHaveHole(final Boolean boolHaveHole) {
      this.boolHaveHole = boolHaveHole;
      return this;
   }

   public MachinePartResponseExportDTO setHoleNumber(final Long holeNumber) {
      this.holeNumber = holeNumber;
      return this;
   }

   public MachinePartResponseExportDTO setBoolSendDirectly(final Boolean boolSendDirectly) {
      this.boolSendDirectly = boolSendDirectly;
      return this;
   }

   @Override
   public String toString() {
      return "MachinePartResponseExportDTO(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", name="
         + this.getName()
         + ", monomerId="
         + this.getMonomerId()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaName="
         + this.getAreaName()
         + ", areaBatchName="
         + this.getAreaBatchName()
         + ", areaId="
         + this.getAreaId()
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
         + ", type="
         + this.getType()
         + ", remark="
         + this.getRemark()
         + ", producedQuantity="
         + this.getProducedQuantity()
         + ", usedQuantity="
         + this.getUsedQuantity()
         + ", boolSchedulingEnum="
         + this.getBoolSchedulingEnum()
         + ", boolProcess="
         + this.getBoolProcess()
         + ", boolHaveHole="
         + this.getBoolHaveHole()
         + ", holeNumber="
         + this.getHoleNumber()
         + ", boolSendDirectly="
         + this.getBoolSendDirectly()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MachinePartResponseExportDTO)) {
         return false;
      }

      MachinePartResponseExportDTO other = (MachinePartResponseExportDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$areaId = this.getAreaId();
            Object other$areaId = other.getAreaId();
            if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                  Object this$type = this.getType();
                  Object other$type = other.getType();
                  if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                     Object this$producedQuantity = this.getProducedQuantity();
                     Object other$producedQuantity = other.getProducedQuantity();
                     if (this$producedQuantity == null ? other$producedQuantity == null : this$producedQuantity.equals(other$producedQuantity)) {
                        Object this$usedQuantity = this.getUsedQuantity();
                        Object other$usedQuantity = other.getUsedQuantity();
                        if (this$usedQuantity == null ? other$usedQuantity == null : this$usedQuantity.equals(other$usedQuantity)) {
                           Object this$boolSchedulingEnum = this.getBoolSchedulingEnum();
                           Object other$boolSchedulingEnum = other.getBoolSchedulingEnum();
                           if (this$boolSchedulingEnum == null ? other$boolSchedulingEnum == null : this$boolSchedulingEnum.equals(other$boolSchedulingEnum)) {
                              Object this$boolProcess = this.getBoolProcess();
                              Object other$boolProcess = other.getBoolProcess();
                              if (this$boolProcess == null ? other$boolProcess == null : this$boolProcess.equals(other$boolProcess)) {
                                 Object this$boolHaveHole = this.getBoolHaveHole();
                                 Object other$boolHaveHole = other.getBoolHaveHole();
                                 if (this$boolHaveHole == null ? other$boolHaveHole == null : this$boolHaveHole.equals(other$boolHaveHole)) {
                                    Object this$holeNumber = this.getHoleNumber();
                                    Object other$holeNumber = other.getHoleNumber();
                                    if (this$holeNumber == null ? other$holeNumber == null : this$holeNumber.equals(other$holeNumber)) {
                                       Object this$boolSendDirectly = this.getBoolSendDirectly();
                                       Object other$boolSendDirectly = other.getBoolSendDirectly();
                                       if (this$boolSendDirectly == null
                                          ? other$boolSendDirectly == null
                                          : this$boolSendDirectly.equals(other$boolSendDirectly)) {
                                          Object this$serialNumber = this.getSerialNumber();
                                          Object other$serialNumber = other.getSerialNumber();
                                          if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                             Object this$name = this.getName();
                                             Object other$name = other.getName();
                                             if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                Object this$monomerName = this.getMonomerName();
                                                Object other$monomerName = other.getMonomerName();
                                                if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
                                                   Object this$areaName = this.getAreaName();
                                                   Object other$areaName = other.getAreaName();
                                                   if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
                                                      Object this$areaBatchName = this.getAreaBatchName();
                                                      Object other$areaBatchName = other.getAreaBatchName();
                                                      if (this$areaBatchName == null
                                                         ? other$areaBatchName == null
                                                         : this$areaBatchName.equals(other$areaBatchName)) {
                                                         Object this$specification = this.getSpecification();
                                                         Object other$specification = other.getSpecification();
                                                         if (this$specification == null
                                                            ? other$specification == null
                                                            : this$specification.equals(other$specification)) {
                                                            Object this$length = this.getLength();
                                                            Object other$length = other.getLength();
                                                            if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                               Object this$material = this.getMaterial();
                                                               Object other$material = other.getMaterial();
                                                               if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                                  Object this$netWeight = this.getNetWeight();
                                                                  Object other$netWeight = other.getNetWeight();
                                                                  if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)
                                                                     )
                                                                   {
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
                                                                                 Object this$drawingNumber = this.getDrawingNumber();
                                                                                 Object other$drawingNumber = other.getDrawingNumber();
                                                                                 if (this$drawingNumber == null
                                                                                    ? other$drawingNumber == null
                                                                                    : this$drawingNumber.equals(other$drawingNumber)) {
                                                                                    Object this$remark = this.getRemark();
                                                                                    Object other$remark = other.getRemark();
                                                                                    return this$remark == null
                                                                                       ? other$remark == null
                                                                                       : this$remark.equals(other$remark);
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
      return other instanceof MachinePartResponseExportDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $producedQuantity = this.getProducedQuantity();
      result = result * 59 + ($producedQuantity == null ? 43 : $producedQuantity.hashCode());
      Object $usedQuantity = this.getUsedQuantity();
      result = result * 59 + ($usedQuantity == null ? 43 : $usedQuantity.hashCode());
      Object $boolSchedulingEnum = this.getBoolSchedulingEnum();
      result = result * 59 + ($boolSchedulingEnum == null ? 43 : $boolSchedulingEnum.hashCode());
      Object $boolProcess = this.getBoolProcess();
      result = result * 59 + ($boolProcess == null ? 43 : $boolProcess.hashCode());
      Object $boolHaveHole = this.getBoolHaveHole();
      result = result * 59 + ($boolHaveHole == null ? 43 : $boolHaveHole.hashCode());
      Object $holeNumber = this.getHoleNumber();
      result = result * 59 + ($holeNumber == null ? 43 : $holeNumber.hashCode());
      Object $boolSendDirectly = this.getBoolSendDirectly();
      result = result * 59 + ($boolSendDirectly == null ? 43 : $boolSendDirectly.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $areaBatchName = this.getAreaBatchName();
      result = result * 59 + ($areaBatchName == null ? 43 : $areaBatchName.hashCode());
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
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class MachinePartResponseExportDTOBuilder {
      private Long id;
      private String serialNumber;
      private String name;
      private Long monomerId;
      private String monomerName;
      private String areaName;
      private String areaBatchName;
      private Long areaId;
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
      private Integer type;
      private String remark;
      private Integer producedQuantity;
      private Integer usedQuantity;
      private Boolean boolSchedulingEnum;
      private Boolean boolProcess;
      private Boolean boolHaveHole;
      private Long holeNumber;
      private Boolean boolSendDirectly;

      MachinePartResponseExportDTOBuilder() {
      }

      public MachinePartResponseExportDTO.MachinePartResponseExportDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MachinePartResponseExportDTO.MachinePartResponseExportDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public MachinePartResponseExportDTO.MachinePartResponseExportDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public MachinePartResponseExportDTO.MachinePartResponseExportDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public MachinePartResponseExportDTO.MachinePartResponseExportDTOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      public MachinePartResponseExportDTO.MachinePartResponseExportDTOBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      public MachinePartResponseExportDTO.MachinePartResponseExportDTOBuilder areaBatchName(final String areaBatchName) {
         this.areaBatchName = areaBatchName;
         return this;
      }

      public MachinePartResponseExportDTO.MachinePartResponseExportDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public MachinePartResponseExportDTO.MachinePartResponseExportDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public MachinePartResponseExportDTO.MachinePartResponseExportDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public MachinePartResponseExportDTO.MachinePartResponseExportDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public MachinePartResponseExportDTO.MachinePartResponseExportDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public MachinePartResponseExportDTO.MachinePartResponseExportDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public MachinePartResponseExportDTO.MachinePartResponseExportDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      public MachinePartResponseExportDTO.MachinePartResponseExportDTOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      public MachinePartResponseExportDTO.MachinePartResponseExportDTOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      public MachinePartResponseExportDTO.MachinePartResponseExportDTOBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      public MachinePartResponseExportDTO.MachinePartResponseExportDTOBuilder drawingNumber(final String drawingNumber) {
         this.drawingNumber = drawingNumber;
         return this;
      }

      public MachinePartResponseExportDTO.MachinePartResponseExportDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public MachinePartResponseExportDTO.MachinePartResponseExportDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public MachinePartResponseExportDTO.MachinePartResponseExportDTOBuilder producedQuantity(final Integer producedQuantity) {
         this.producedQuantity = producedQuantity;
         return this;
      }

      public MachinePartResponseExportDTO.MachinePartResponseExportDTOBuilder usedQuantity(final Integer usedQuantity) {
         this.usedQuantity = usedQuantity;
         return this;
      }

      public MachinePartResponseExportDTO.MachinePartResponseExportDTOBuilder boolSchedulingEnum(final Boolean boolSchedulingEnum) {
         this.boolSchedulingEnum = boolSchedulingEnum;
         return this;
      }

      public MachinePartResponseExportDTO.MachinePartResponseExportDTOBuilder boolProcess(final Boolean boolProcess) {
         this.boolProcess = boolProcess;
         return this;
      }

      public MachinePartResponseExportDTO.MachinePartResponseExportDTOBuilder boolHaveHole(final Boolean boolHaveHole) {
         this.boolHaveHole = boolHaveHole;
         return this;
      }

      public MachinePartResponseExportDTO.MachinePartResponseExportDTOBuilder holeNumber(final Long holeNumber) {
         this.holeNumber = holeNumber;
         return this;
      }

      public MachinePartResponseExportDTO.MachinePartResponseExportDTOBuilder boolSendDirectly(final Boolean boolSendDirectly) {
         this.boolSendDirectly = boolSendDirectly;
         return this;
      }

      public MachinePartResponseExportDTO build() {
         return new MachinePartResponseExportDTO(
            this.id,
            this.serialNumber,
            this.name,
            this.monomerId,
            this.monomerName,
            this.areaName,
            this.areaBatchName,
            this.areaId,
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
            this.type,
            this.remark,
            this.producedQuantity,
            this.usedQuantity,
            this.boolSchedulingEnum,
            this.boolProcess,
            this.boolHaveHole,
            this.holeNumber,
            this.boolSendDirectly
         );
      }

      @Override
      public String toString() {
         return "MachinePartResponseExportDTO.MachinePartResponseExportDTOBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", name="
            + this.name
            + ", monomerId="
            + this.monomerId
            + ", monomerName="
            + this.monomerName
            + ", areaName="
            + this.areaName
            + ", areaBatchName="
            + this.areaBatchName
            + ", areaId="
            + this.areaId
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
            + ", type="
            + this.type
            + ", remark="
            + this.remark
            + ", producedQuantity="
            + this.producedQuantity
            + ", usedQuantity="
            + this.usedQuantity
            + ", boolSchedulingEnum="
            + this.boolSchedulingEnum
            + ", boolProcess="
            + this.boolProcess
            + ", boolHaveHole="
            + this.boolHaveHole
            + ", holeNumber="
            + this.holeNumber
            + ", boolSendDirectly="
            + this.boolSendDirectly
            + ")";
      }
   }
}
