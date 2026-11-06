package com.hzchum.scim.plan.core.api.pojo.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("零件列表")
public class TechPartRecordVO {
   @ApiModelProperty(name = "id", value = "零件id")
   private Long id;
   @ApiModelProperty(name = "comboId", value = "组合id")
   @JsonProperty("comboId")
   @JSONField(name = "comboId")
   private String comboId;
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
   @ApiModelProperty(name = "length", value = "长度（mm）")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "material", value = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "quantity", value = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "flankPlateType", value = "翼腹板定义")
   @JsonProperty("flankPlateType")
   @JSONField(name = "flankPlateType")
   private Integer flankPlateType;
   @ApiModelProperty(name = "unitId", value = "部件Id")
   @JsonProperty("unitId")
   @JSONField(name = "unitId")
   private Long unitId;
   @ApiModelProperty(name = "unitQuantity", value = "部件数量")
   @JsonProperty("unitQuantity")
   @JSONField(name = "unitQuantity")
   private Integer unitQuantity;
   @ApiModelProperty(name = "oldMachinePartId", value = "旧零件id")
   @JsonProperty("oldMachinePartId")
   @JSONField(name = "oldMachinePartId")
   private Long oldMachinePartId;

   public Long getId() {
      return this.id;
   }

   public String getComboId() {
      return this.comboId;
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

   public Integer getFlankPlateType() {
      return this.flankPlateType;
   }

   public Long getUnitId() {
      return this.unitId;
   }

   public Integer getUnitQuantity() {
      return this.unitQuantity;
   }

   public Long getOldMachinePartId() {
      return this.oldMachinePartId;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   @JsonProperty("comboId")
   public void setComboId(final String comboId) {
      this.comboId = comboId;
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

   @JsonProperty("length")
   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   @JsonProperty("material")
   public void setMaterial(final String material) {
      this.material = material;
   }

   @JsonProperty("quantity")
   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   @JsonProperty("flankPlateType")
   public void setFlankPlateType(final Integer flankPlateType) {
      this.flankPlateType = flankPlateType;
   }

   @JsonProperty("unitId")
   public void setUnitId(final Long unitId) {
      this.unitId = unitId;
   }

   @JsonProperty("unitQuantity")
   public void setUnitQuantity(final Integer unitQuantity) {
      this.unitQuantity = unitQuantity;
   }

   @JsonProperty("oldMachinePartId")
   public void setOldMachinePartId(final Long oldMachinePartId) {
      this.oldMachinePartId = oldMachinePartId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechPartRecordVO)) {
         return false;
      }

      TechPartRecordVO other = (TechPartRecordVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$flankPlateType = this.getFlankPlateType();
            Object other$flankPlateType = other.getFlankPlateType();
            if (this$flankPlateType == null ? other$flankPlateType == null : this$flankPlateType.equals(other$flankPlateType)) {
               Object this$unitId = this.getUnitId();
               Object other$unitId = other.getUnitId();
               if (this$unitId == null ? other$unitId == null : this$unitId.equals(other$unitId)) {
                  Object this$unitQuantity = this.getUnitQuantity();
                  Object other$unitQuantity = other.getUnitQuantity();
                  if (this$unitQuantity == null ? other$unitQuantity == null : this$unitQuantity.equals(other$unitQuantity)) {
                     Object this$oldMachinePartId = this.getOldMachinePartId();
                     Object other$oldMachinePartId = other.getOldMachinePartId();
                     if (this$oldMachinePartId == null ? other$oldMachinePartId == null : this$oldMachinePartId.equals(other$oldMachinePartId)) {
                        Object this$comboId = this.getComboId();
                        Object other$comboId = other.getComboId();
                        if (this$comboId == null ? other$comboId == null : this$comboId.equals(other$comboId)) {
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
                                       return this$material == null ? other$material == null : this$material.equals(other$material);
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
      return other instanceof TechPartRecordVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $flankPlateType = this.getFlankPlateType();
      result = result * 59 + ($flankPlateType == null ? 43 : $flankPlateType.hashCode());
      Object $unitId = this.getUnitId();
      result = result * 59 + ($unitId == null ? 43 : $unitId.hashCode());
      Object $unitQuantity = this.getUnitQuantity();
      result = result * 59 + ($unitQuantity == null ? 43 : $unitQuantity.hashCode());
      Object $oldMachinePartId = this.getOldMachinePartId();
      result = result * 59 + ($oldMachinePartId == null ? 43 : $oldMachinePartId.hashCode());
      Object $comboId = this.getComboId();
      result = result * 59 + ($comboId == null ? 43 : $comboId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $material = this.getMaterial();
      return result * 59 + ($material == null ? 43 : $material.hashCode());
   }

   @Override
   public String toString() {
      return "TechPartRecordVO(id="
         + this.getId()
         + ", comboId="
         + this.getComboId()
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
         + ", flankPlateType="
         + this.getFlankPlateType()
         + ", unitId="
         + this.getUnitId()
         + ", unitQuantity="
         + this.getUnitQuantity()
         + ", oldMachinePartId="
         + this.getOldMachinePartId()
         + ")";
   }
}
