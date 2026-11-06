package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("组立清单-零件(腹板翼缘)返回类")
public class AssembleMachinePartDTO {
   @ApiModelProperty(name = "id", value = "零件id")
   private Long id;
   @ApiModelProperty(name = "configName", value = "部件配置名称")
   private String configName;
   @ApiModelProperty(name = "structureType", value = "结构类型")
   private String structureType;
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
   @ApiModelProperty(name = "netWeight", value = "净重（kg）")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重（kg）")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "quantity", value = "数量")
   private Integer quantity;
   @ApiModelProperty(name = "usedQuantity", value = "已使用数量")
   private Integer usedQuantity;
   @ApiModelProperty(name = "producedQuantity", value = "已生产数量")
   private Integer producedQuantity;
   @ApiModelProperty(name = "drawingNumber", value = "图号")
   private String drawingNumber;

   public Long getId() {
      return this.id;
   }

   public String getConfigName() {
      return this.configName;
   }

   public String getStructureType() {
      return this.structureType;
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

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getUsedQuantity() {
      return this.usedQuantity;
   }

   public Integer getProducedQuantity() {
      return this.producedQuantity;
   }

   public String getDrawingNumber() {
      return this.drawingNumber;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setConfigName(final String configName) {
      this.configName = configName;
   }

   public void setStructureType(final String structureType) {
      this.structureType = structureType;
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

   public void setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
   }

   public void setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setUsedQuantity(final Integer usedQuantity) {
      this.usedQuantity = usedQuantity;
   }

   public void setProducedQuantity(final Integer producedQuantity) {
      this.producedQuantity = producedQuantity;
   }

   public void setDrawingNumber(final String drawingNumber) {
      this.drawingNumber = drawingNumber;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AssembleMachinePartDTO)) {
         return false;
      }

      AssembleMachinePartDTO other = (AssembleMachinePartDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$usedQuantity = this.getUsedQuantity();
            Object other$usedQuantity = other.getUsedQuantity();
            if (this$usedQuantity == null ? other$usedQuantity == null : this$usedQuantity.equals(other$usedQuantity)) {
               Object this$producedQuantity = this.getProducedQuantity();
               Object other$producedQuantity = other.getProducedQuantity();
               if (this$producedQuantity == null ? other$producedQuantity == null : this$producedQuantity.equals(other$producedQuantity)) {
                  Object this$configName = this.getConfigName();
                  Object other$configName = other.getConfigName();
                  if (this$configName == null ? other$configName == null : this$configName.equals(other$configName)) {
                     Object this$structureType = this.getStructureType();
                     Object other$structureType = other.getStructureType();
                     if (this$structureType == null ? other$structureType == null : this$structureType.equals(other$structureType)) {
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
                                             Object this$drawingNumber = this.getDrawingNumber();
                                             Object other$drawingNumber = other.getDrawingNumber();
                                             return this$drawingNumber == null ? other$drawingNumber == null : this$drawingNumber.equals(other$drawingNumber);
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
      return other instanceof AssembleMachinePartDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $usedQuantity = this.getUsedQuantity();
      result = result * 59 + ($usedQuantity == null ? 43 : $usedQuantity.hashCode());
      Object $producedQuantity = this.getProducedQuantity();
      result = result * 59 + ($producedQuantity == null ? 43 : $producedQuantity.hashCode());
      Object $configName = this.getConfigName();
      result = result * 59 + ($configName == null ? 43 : $configName.hashCode());
      Object $structureType = this.getStructureType();
      result = result * 59 + ($structureType == null ? 43 : $structureType.hashCode());
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
      Object $drawingNumber = this.getDrawingNumber();
      return result * 59 + ($drawingNumber == null ? 43 : $drawingNumber.hashCode());
   }

   @Override
   public String toString() {
      return "AssembleMachinePartDTO(id="
         + this.getId()
         + ", configName="
         + this.getConfigName()
         + ", structureType="
         + this.getStructureType()
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
         + ", netWeight="
         + this.getNetWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", quantity="
         + this.getQuantity()
         + ", usedQuantity="
         + this.getUsedQuantity()
         + ", producedQuantity="
         + this.getProducedQuantity()
         + ", drawingNumber="
         + this.getDrawingNumber()
         + ")";
   }
}
