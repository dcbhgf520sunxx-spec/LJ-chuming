package com.hzchum.scim.plan.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("零件清单类")
public class MachinePartResponseDTO {
   @ApiModelProperty(name = "id", value = "零件id")
   private Long id;
   @ApiModelProperty(name = "monomer", value = "单体")
   private NameInfo monomer;
   @ApiModelProperty(name = "area", value = "区域")
   private NameInfo area;
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

   public Long getId() {
      return this.id;
   }

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public NameInfo getArea() {
      return this.area;
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

   public void setId(final Long id) {
      this.id = id;
   }

   public void setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
   }

   public void setArea(final NameInfo area) {
      this.area = area;
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

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setProducedQuantity(final Integer producedQuantity) {
      this.producedQuantity = producedQuantity;
   }

   public void setUsedQuantity(final Integer usedQuantity) {
      this.usedQuantity = usedQuantity;
   }

   public void setBoolSchedulingEnum(final Boolean boolSchedulingEnum) {
      this.boolSchedulingEnum = boolSchedulingEnum;
   }

   public void setBoolProcess(final Boolean boolProcess) {
      this.boolProcess = boolProcess;
   }

   public void setBoolHaveHole(final Boolean boolHaveHole) {
      this.boolHaveHole = boolHaveHole;
   }

   public void setHoleNumber(final Long holeNumber) {
      this.holeNumber = holeNumber;
   }

   public void setBoolSendDirectly(final Boolean boolSendDirectly) {
      this.boolSendDirectly = boolSendDirectly;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MachinePartResponseDTO)) {
         return false;
      }

      MachinePartResponseDTO other = (MachinePartResponseDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
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
                                 if (this$boolSendDirectly == null ? other$boolSendDirectly == null : this$boolSendDirectly.equals(other$boolSendDirectly)) {
                                    Object this$monomer = this.getMonomer();
                                    Object other$monomer = other.getMonomer();
                                    if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                                       Object this$area = this.getArea();
                                       Object other$area = other.getArea();
                                       if (this$area == null ? other$area == null : this$area.equals(other$area)) {
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
                                                                           return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof MachinePartResponseDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
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
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
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
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "MachinePartResponseDTO(id="
         + this.getId()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
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
}
