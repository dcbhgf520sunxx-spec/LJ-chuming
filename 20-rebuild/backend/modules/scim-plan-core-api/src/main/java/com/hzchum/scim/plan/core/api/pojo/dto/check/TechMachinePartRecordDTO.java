package com.hzchum.scim.plan.core.api.pojo.dto.check;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("零件导入记录DTO")
public class TechMachinePartRecordDTO {
   @ApiModelProperty(name = "id", value = "零件审核表Id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", value = "零件名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "newSpecification", value = "新规格")
   @JsonProperty("newSpecification")
   @JSONField(name = "newSpecification")
   private String newSpecification;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "width", value = "宽度（mm）")
   @JsonProperty("width")
   @JSONField(name = "width")
   private String width;
   @ApiModelProperty(name = "material", value = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "quantity", value = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "unitQuantity", value = "数量")
   @JsonProperty("unitQuantity")
   @JSONField(name = "unitQuantity")
   private Integer unitQuantity;
   @ApiModelProperty(name = "specPrefix", value = "规格前缀")
   @JsonProperty("specPrefix")
   @JSONField(name = "specPrefix")
   private String specPrefix;
   @ApiModelProperty(name = "comboId", value = "组合Id")
   @JsonProperty("comboId")
   @JSONField(name = "comboId")
   private String comboId;
   @ApiModelProperty(name = "unitId", value = "部件Id")
   @JsonProperty("unitId")
   @JSONField(name = "unitId")
   private Long unitId;
   @ApiModelProperty(name = "assembleConfigId", value = "装配配置Id")
   @JsonProperty("assembleConfigId")
   @JSONField(name = "assembleConfigId")
   private Long assembleConfigId;
   @ApiModelProperty(name = "flankPlateType", value = "翼腹板定义")
   @JsonProperty("flankPlateType")
   @JSONField(name = "flankPlateType")
   private Integer flankPlateType;
   @ApiModelProperty(name = "oldMachinePartId", value = "旧零件id")
   @JsonProperty("oldMachinePartId")
   @JSONField(name = "oldMachinePartId")
   private Long oldMachinePartId;
   @ApiModelProperty(name = "booInventory", value = "是否清单导入 true是 false否")
   @JsonProperty("booInventory")
   @JSONField(name = "booInventory")
   private Boolean booInventory;
   @ApiModelProperty(name = "thick", value = "厚")
   @JsonProperty("thick")
   @JSONField(name = "thick")
   private String thick;
   @ApiModelProperty(name = "remark", value = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   private String remark;

   public Long getId() {
      return this.id;
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

   public String getNewSpecification() {
      return this.newSpecification;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public String getWidth() {
      return this.width;
   }

   public String getMaterial() {
      return this.material;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getUnitQuantity() {
      return this.unitQuantity;
   }

   public String getSpecPrefix() {
      return this.specPrefix;
   }

   public String getComboId() {
      return this.comboId;
   }

   public Long getUnitId() {
      return this.unitId;
   }

   public Long getAssembleConfigId() {
      return this.assembleConfigId;
   }

   public Integer getFlankPlateType() {
      return this.flankPlateType;
   }

   public Long getOldMachinePartId() {
      return this.oldMachinePartId;
   }

   public Boolean getBooInventory() {
      return this.booInventory;
   }

   public String getThick() {
      return this.thick;
   }

   public String getRemark() {
      return this.remark;
   }

   @JsonProperty("id")
   public void setId(final Long id) {
      this.id = id;
   }

   @JsonProperty("name")
   public void setName(final String name) {
      this.name = name;
   }

   @JsonProperty("serialNumber")
   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   @JsonProperty("specification")
   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   @JsonProperty("newSpecification")
   public void setNewSpecification(final String newSpecification) {
      this.newSpecification = newSpecification;
   }

   @JsonProperty("length")
   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   @JsonProperty("width")
   public void setWidth(final String width) {
      this.width = width;
   }

   @JsonProperty("material")
   public void setMaterial(final String material) {
      this.material = material;
   }

   @JsonProperty("quantity")
   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   @JsonProperty("unitQuantity")
   public void setUnitQuantity(final Integer unitQuantity) {
      this.unitQuantity = unitQuantity;
   }

   @JsonProperty("specPrefix")
   public void setSpecPrefix(final String specPrefix) {
      this.specPrefix = specPrefix;
   }

   @JsonProperty("comboId")
   public void setComboId(final String comboId) {
      this.comboId = comboId;
   }

   @JsonProperty("unitId")
   public void setUnitId(final Long unitId) {
      this.unitId = unitId;
   }

   @JsonProperty("assembleConfigId")
   public void setAssembleConfigId(final Long assembleConfigId) {
      this.assembleConfigId = assembleConfigId;
   }

   @JsonProperty("flankPlateType")
   public void setFlankPlateType(final Integer flankPlateType) {
      this.flankPlateType = flankPlateType;
   }

   @JsonProperty("oldMachinePartId")
   public void setOldMachinePartId(final Long oldMachinePartId) {
      this.oldMachinePartId = oldMachinePartId;
   }

   @JsonProperty("booInventory")
   public void setBooInventory(final Boolean booInventory) {
      this.booInventory = booInventory;
   }

   @JsonProperty("thick")
   public void setThick(final String thick) {
      this.thick = thick;
   }

   @JsonProperty("remark")
   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechMachinePartRecordDTO)) {
         return false;
      }

      TechMachinePartRecordDTO other = (TechMachinePartRecordDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$unitQuantity = this.getUnitQuantity();
            Object other$unitQuantity = other.getUnitQuantity();
            if (this$unitQuantity == null ? other$unitQuantity == null : this$unitQuantity.equals(other$unitQuantity)) {
               Object this$unitId = this.getUnitId();
               Object other$unitId = other.getUnitId();
               if (this$unitId == null ? other$unitId == null : this$unitId.equals(other$unitId)) {
                  Object this$assembleConfigId = this.getAssembleConfigId();
                  Object other$assembleConfigId = other.getAssembleConfigId();
                  if (this$assembleConfigId == null ? other$assembleConfigId == null : this$assembleConfigId.equals(other$assembleConfigId)) {
                     Object this$flankPlateType = this.getFlankPlateType();
                     Object other$flankPlateType = other.getFlankPlateType();
                     if (this$flankPlateType == null ? other$flankPlateType == null : this$flankPlateType.equals(other$flankPlateType)) {
                        Object this$oldMachinePartId = this.getOldMachinePartId();
                        Object other$oldMachinePartId = other.getOldMachinePartId();
                        if (this$oldMachinePartId == null ? other$oldMachinePartId == null : this$oldMachinePartId.equals(other$oldMachinePartId)) {
                           Object this$booInventory = this.getBooInventory();
                           Object other$booInventory = other.getBooInventory();
                           if (this$booInventory == null ? other$booInventory == null : this$booInventory.equals(other$booInventory)) {
                              Object this$name = this.getName();
                              Object other$name = other.getName();
                              if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                 Object this$serialNumber = this.getSerialNumber();
                                 Object other$serialNumber = other.getSerialNumber();
                                 if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                    Object this$specification = this.getSpecification();
                                    Object other$specification = other.getSpecification();
                                    if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                       Object this$newSpecification = this.getNewSpecification();
                                       Object other$newSpecification = other.getNewSpecification();
                                       if (this$newSpecification == null
                                          ? other$newSpecification == null
                                          : this$newSpecification.equals(other$newSpecification)) {
                                          Object this$length = this.getLength();
                                          Object other$length = other.getLength();
                                          if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                             Object this$width = this.getWidth();
                                             Object other$width = other.getWidth();
                                             if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                Object this$material = this.getMaterial();
                                                Object other$material = other.getMaterial();
                                                if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                   Object this$specPrefix = this.getSpecPrefix();
                                                   Object other$specPrefix = other.getSpecPrefix();
                                                   if (this$specPrefix == null ? other$specPrefix == null : this$specPrefix.equals(other$specPrefix)) {
                                                      Object this$comboId = this.getComboId();
                                                      Object other$comboId = other.getComboId();
                                                      if (this$comboId == null ? other$comboId == null : this$comboId.equals(other$comboId)) {
                                                         Object this$thick = this.getThick();
                                                         Object other$thick = other.getThick();
                                                         if (this$thick == null ? other$thick == null : this$thick.equals(other$thick)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TechMachinePartRecordDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $unitQuantity = this.getUnitQuantity();
      result = result * 59 + ($unitQuantity == null ? 43 : $unitQuantity.hashCode());
      Object $unitId = this.getUnitId();
      result = result * 59 + ($unitId == null ? 43 : $unitId.hashCode());
      Object $assembleConfigId = this.getAssembleConfigId();
      result = result * 59 + ($assembleConfigId == null ? 43 : $assembleConfigId.hashCode());
      Object $flankPlateType = this.getFlankPlateType();
      result = result * 59 + ($flankPlateType == null ? 43 : $flankPlateType.hashCode());
      Object $oldMachinePartId = this.getOldMachinePartId();
      result = result * 59 + ($oldMachinePartId == null ? 43 : $oldMachinePartId.hashCode());
      Object $booInventory = this.getBooInventory();
      result = result * 59 + ($booInventory == null ? 43 : $booInventory.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $newSpecification = this.getNewSpecification();
      result = result * 59 + ($newSpecification == null ? 43 : $newSpecification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $specPrefix = this.getSpecPrefix();
      result = result * 59 + ($specPrefix == null ? 43 : $specPrefix.hashCode());
      Object $comboId = this.getComboId();
      result = result * 59 + ($comboId == null ? 43 : $comboId.hashCode());
      Object $thick = this.getThick();
      result = result * 59 + ($thick == null ? 43 : $thick.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "TechMachinePartRecordDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", newSpecification="
         + this.getNewSpecification()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", material="
         + this.getMaterial()
         + ", quantity="
         + this.getQuantity()
         + ", unitQuantity="
         + this.getUnitQuantity()
         + ", specPrefix="
         + this.getSpecPrefix()
         + ", comboId="
         + this.getComboId()
         + ", unitId="
         + this.getUnitId()
         + ", assembleConfigId="
         + this.getAssembleConfigId()
         + ", flankPlateType="
         + this.getFlankPlateType()
         + ", oldMachinePartId="
         + this.getOldMachinePartId()
         + ", booInventory="
         + this.getBooInventory()
         + ", thick="
         + this.getThick()
         + ", remark="
         + this.getRemark()
         + ")";
   }
}
