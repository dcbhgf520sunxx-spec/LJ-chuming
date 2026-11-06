package com.hzchum.scim.plan.core.api.pojo.dto.check;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel("部件导入记录DTO")
public class TechAssembleRecordDTO {
   @ApiModelProperty(name = "id", value = "部件审核表Id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", value = "部件名称")
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
   @ApiModelProperty(name = "assembleConfigId", value = "部件配置表id")
   @JsonProperty("assembleConfigId")
   @JSONField(name = "assembleConfigId")
   private Long assembleConfigId;
   @ApiModelProperty(name = "specPrefix", value = "规格前缀")
   @JsonProperty("specPrefix")
   @JSONField(name = "specPrefix")
   private String specPrefix;
   @ApiModelProperty(name = "booInventory", value = "是否清单导入 true是 false否")
   @JsonProperty("booInventory")
   @JSONField(name = "booInventory")
   private Boolean booInventory;
   @ApiModelProperty(name = "remark", value = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   private String remark;
   @ApiModelProperty(name = "techAssembleRecordDTO", value = "零件列表")
   @JsonProperty("techAssembleRecordDTO")
   @JSONField(name = "techAssembleRecordDTO")
   private List<TechMachinePartRecordDTO> techAssembleRecordDTO;

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

   public BigDecimal getLength() {
      return this.length;
   }

   public String getMaterial() {
      return this.material;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Long getAssembleConfigId() {
      return this.assembleConfigId;
   }

   public String getSpecPrefix() {
      return this.specPrefix;
   }

   public Boolean getBooInventory() {
      return this.booInventory;
   }

   public String getRemark() {
      return this.remark;
   }

   public List<TechMachinePartRecordDTO> getTechAssembleRecordDTO() {
      return this.techAssembleRecordDTO;
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

   @JsonProperty("assembleConfigId")
   public void setAssembleConfigId(final Long assembleConfigId) {
      this.assembleConfigId = assembleConfigId;
   }

   @JsonProperty("specPrefix")
   public void setSpecPrefix(final String specPrefix) {
      this.specPrefix = specPrefix;
   }

   @JsonProperty("booInventory")
   public void setBooInventory(final Boolean booInventory) {
      this.booInventory = booInventory;
   }

   @JsonProperty("remark")
   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @JsonProperty("techAssembleRecordDTO")
   public void setTechAssembleRecordDTO(final List<TechMachinePartRecordDTO> techAssembleRecordDTO) {
      this.techAssembleRecordDTO = techAssembleRecordDTO;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechAssembleRecordDTO)) {
         return false;
      }

      TechAssembleRecordDTO other = (TechAssembleRecordDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$assembleConfigId = this.getAssembleConfigId();
            Object other$assembleConfigId = other.getAssembleConfigId();
            if (this$assembleConfigId == null ? other$assembleConfigId == null : this$assembleConfigId.equals(other$assembleConfigId)) {
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
                           Object this$length = this.getLength();
                           Object other$length = other.getLength();
                           if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                              Object this$material = this.getMaterial();
                              Object other$material = other.getMaterial();
                              if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                 Object this$specPrefix = this.getSpecPrefix();
                                 Object other$specPrefix = other.getSpecPrefix();
                                 if (this$specPrefix == null ? other$specPrefix == null : this$specPrefix.equals(other$specPrefix)) {
                                    Object this$remark = this.getRemark();
                                    Object other$remark = other.getRemark();
                                    if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                       Object this$techAssembleRecordDTO = this.getTechAssembleRecordDTO();
                                       Object other$techAssembleRecordDTO = other.getTechAssembleRecordDTO();
                                       return this$techAssembleRecordDTO == null
                                          ? other$techAssembleRecordDTO == null
                                          : this$techAssembleRecordDTO.equals(other$techAssembleRecordDTO);
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
      return other instanceof TechAssembleRecordDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $assembleConfigId = this.getAssembleConfigId();
      result = result * 59 + ($assembleConfigId == null ? 43 : $assembleConfigId.hashCode());
      Object $booInventory = this.getBooInventory();
      result = result * 59 + ($booInventory == null ? 43 : $booInventory.hashCode());
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
      Object $specPrefix = this.getSpecPrefix();
      result = result * 59 + ($specPrefix == null ? 43 : $specPrefix.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $techAssembleRecordDTO = this.getTechAssembleRecordDTO();
      return result * 59 + ($techAssembleRecordDTO == null ? 43 : $techAssembleRecordDTO.hashCode());
   }

   @Override
   public String toString() {
      return "TechAssembleRecordDTO(id="
         + this.getId()
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
         + ", assembleConfigId="
         + this.getAssembleConfigId()
         + ", specPrefix="
         + this.getSpecPrefix()
         + ", booInventory="
         + this.getBooInventory()
         + ", remark="
         + this.getRemark()
         + ", techAssembleRecordDTO="
         + this.getTechAssembleRecordDTO()
         + ")";
   }
}
