package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("组立匹配的构件列表类")
public class AssembleArtifactDTO {
   @ApiModelProperty(name = "id", value = "构件id")
   private Long id;
   @ApiModelProperty(name = "name", value = "名称")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   private String specification;
   @ApiModelProperty(name = "specPrefix", value = "规格前缀")
   private String specPrefix;
   @ApiModelProperty(name = "serialNumberPrefix", value = "编号前缀")
   private String serialNumberPrefix;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   private BigDecimal length;
   @ApiModelProperty(name = "material", value = "材质")
   private String material;
   @ApiModelProperty(name = "quantity", value = "构件数量")
   private Integer quantity;
   @ApiModelProperty(name = "assembleQuantity", value = "所需组立数量")
   private Integer assembleQuantity;
   @ApiModelProperty(name = "netWeight", value = "单净重")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "producedQuantity", value = "已生产量")
   private Integer producedQuantity;
   @ApiModelProperty(name = "drawingNumber", value = "图号")
   private String drawingNumber;
   @ApiModelProperty(name = "existStatus", value = "在零构件清单中是否已导入 1已导入 0未导入")
   private Integer existStatus = 1;
   @ApiModelProperty(name = "abnormal", value = "是否异常 1异常 0正常")
   private Integer abnormal = 0;

   public static AssembleArtifactDTO.AssembleArtifactDTOBuilder builder() {
      return new AssembleArtifactDTO.AssembleArtifactDTOBuilder();
   }

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

   public String getSpecPrefix() {
      return this.specPrefix;
   }

   public String getSerialNumberPrefix() {
      return this.serialNumberPrefix;
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

   public Integer getAssembleQuantity() {
      return this.assembleQuantity;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public Integer getProducedQuantity() {
      return this.producedQuantity;
   }

   public String getDrawingNumber() {
      return this.drawingNumber;
   }

   public Integer getExistStatus() {
      return this.existStatus;
   }

   public Integer getAbnormal() {
      return this.abnormal;
   }

   public void setId(final Long id) {
      this.id = id;
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

   public void setSpecPrefix(final String specPrefix) {
      this.specPrefix = specPrefix;
   }

   public void setSerialNumberPrefix(final String serialNumberPrefix) {
      this.serialNumberPrefix = serialNumberPrefix;
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

   public void setAssembleQuantity(final Integer assembleQuantity) {
      this.assembleQuantity = assembleQuantity;
   }

   public void setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
   }

   public void setProducedQuantity(final Integer producedQuantity) {
      this.producedQuantity = producedQuantity;
   }

   public void setDrawingNumber(final String drawingNumber) {
      this.drawingNumber = drawingNumber;
   }

   public void setExistStatus(final Integer existStatus) {
      this.existStatus = existStatus;
   }

   public void setAbnormal(final Integer abnormal) {
      this.abnormal = abnormal;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AssembleArtifactDTO)) {
         return false;
      }

      AssembleArtifactDTO other = (AssembleArtifactDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$assembleQuantity = this.getAssembleQuantity();
            Object other$assembleQuantity = other.getAssembleQuantity();
            if (this$assembleQuantity == null ? other$assembleQuantity == null : this$assembleQuantity.equals(other$assembleQuantity)) {
               Object this$producedQuantity = this.getProducedQuantity();
               Object other$producedQuantity = other.getProducedQuantity();
               if (this$producedQuantity == null ? other$producedQuantity == null : this$producedQuantity.equals(other$producedQuantity)) {
                  Object this$existStatus = this.getExistStatus();
                  Object other$existStatus = other.getExistStatus();
                  if (this$existStatus == null ? other$existStatus == null : this$existStatus.equals(other$existStatus)) {
                     Object this$abnormal = this.getAbnormal();
                     Object other$abnormal = other.getAbnormal();
                     if (this$abnormal == null ? other$abnormal == null : this$abnormal.equals(other$abnormal)) {
                        Object this$name = this.getName();
                        Object other$name = other.getName();
                        if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                           Object this$serialNumber = this.getSerialNumber();
                           Object other$serialNumber = other.getSerialNumber();
                           if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                              Object this$specification = this.getSpecification();
                              Object other$specification = other.getSpecification();
                              if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                 Object this$specPrefix = this.getSpecPrefix();
                                 Object other$specPrefix = other.getSpecPrefix();
                                 if (this$specPrefix == null ? other$specPrefix == null : this$specPrefix.equals(other$specPrefix)) {
                                    Object this$serialNumberPrefix = this.getSerialNumberPrefix();
                                    Object other$serialNumberPrefix = other.getSerialNumberPrefix();
                                    if (this$serialNumberPrefix == null
                                       ? other$serialNumberPrefix == null
                                       : this$serialNumberPrefix.equals(other$serialNumberPrefix)) {
                                       Object this$length = this.getLength();
                                       Object other$length = other.getLength();
                                       if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                          Object this$material = this.getMaterial();
                                          Object other$material = other.getMaterial();
                                          if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                             Object this$netWeight = this.getNetWeight();
                                             Object other$netWeight = other.getNetWeight();
                                             if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                                Object this$drawingNumber = this.getDrawingNumber();
                                                Object other$drawingNumber = other.getDrawingNumber();
                                                return this$drawingNumber == null
                                                   ? other$drawingNumber == null
                                                   : this$drawingNumber.equals(other$drawingNumber);
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
      return other instanceof AssembleArtifactDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $assembleQuantity = this.getAssembleQuantity();
      result = result * 59 + ($assembleQuantity == null ? 43 : $assembleQuantity.hashCode());
      Object $producedQuantity = this.getProducedQuantity();
      result = result * 59 + ($producedQuantity == null ? 43 : $producedQuantity.hashCode());
      Object $existStatus = this.getExistStatus();
      result = result * 59 + ($existStatus == null ? 43 : $existStatus.hashCode());
      Object $abnormal = this.getAbnormal();
      result = result * 59 + ($abnormal == null ? 43 : $abnormal.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $specPrefix = this.getSpecPrefix();
      result = result * 59 + ($specPrefix == null ? 43 : $specPrefix.hashCode());
      Object $serialNumberPrefix = this.getSerialNumberPrefix();
      result = result * 59 + ($serialNumberPrefix == null ? 43 : $serialNumberPrefix.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $drawingNumber = this.getDrawingNumber();
      return result * 59 + ($drawingNumber == null ? 43 : $drawingNumber.hashCode());
   }

   @Override
   public String toString() {
      return "AssembleArtifactDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", specPrefix="
         + this.getSpecPrefix()
         + ", serialNumberPrefix="
         + this.getSerialNumberPrefix()
         + ", length="
         + this.getLength()
         + ", material="
         + this.getMaterial()
         + ", quantity="
         + this.getQuantity()
         + ", assembleQuantity="
         + this.getAssembleQuantity()
         + ", netWeight="
         + this.getNetWeight()
         + ", producedQuantity="
         + this.getProducedQuantity()
         + ", drawingNumber="
         + this.getDrawingNumber()
         + ", existStatus="
         + this.getExistStatus()
         + ", abnormal="
         + this.getAbnormal()
         + ")";
   }

   public AssembleArtifactDTO(
      final Long id,
      final String name,
      final String serialNumber,
      final String specification,
      final String specPrefix,
      final String serialNumberPrefix,
      final BigDecimal length,
      final String material,
      final Integer quantity,
      final Integer assembleQuantity,
      final BigDecimal netWeight,
      final Integer producedQuantity,
      final String drawingNumber,
      final Integer existStatus,
      final Integer abnormal
   ) {
      this.id = id;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.specPrefix = specPrefix;
      this.serialNumberPrefix = serialNumberPrefix;
      this.length = length;
      this.material = material;
      this.quantity = quantity;
      this.assembleQuantity = assembleQuantity;
      this.netWeight = netWeight;
      this.producedQuantity = producedQuantity;
      this.drawingNumber = drawingNumber;
      this.existStatus = existStatus;
      this.abnormal = abnormal;
   }

   public AssembleArtifactDTO() {
   }

   public static class AssembleArtifactDTOBuilder {
      private Long id;
      private String name;
      private String serialNumber;
      private String specification;
      private String specPrefix;
      private String serialNumberPrefix;
      private BigDecimal length;
      private String material;
      private Integer quantity;
      private Integer assembleQuantity;
      private BigDecimal netWeight;
      private Integer producedQuantity;
      private String drawingNumber;
      private Integer existStatus;
      private Integer abnormal;

      AssembleArtifactDTOBuilder() {
      }

      public AssembleArtifactDTO.AssembleArtifactDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public AssembleArtifactDTO.AssembleArtifactDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public AssembleArtifactDTO.AssembleArtifactDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public AssembleArtifactDTO.AssembleArtifactDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public AssembleArtifactDTO.AssembleArtifactDTOBuilder specPrefix(final String specPrefix) {
         this.specPrefix = specPrefix;
         return this;
      }

      public AssembleArtifactDTO.AssembleArtifactDTOBuilder serialNumberPrefix(final String serialNumberPrefix) {
         this.serialNumberPrefix = serialNumberPrefix;
         return this;
      }

      public AssembleArtifactDTO.AssembleArtifactDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public AssembleArtifactDTO.AssembleArtifactDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public AssembleArtifactDTO.AssembleArtifactDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public AssembleArtifactDTO.AssembleArtifactDTOBuilder assembleQuantity(final Integer assembleQuantity) {
         this.assembleQuantity = assembleQuantity;
         return this;
      }

      public AssembleArtifactDTO.AssembleArtifactDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public AssembleArtifactDTO.AssembleArtifactDTOBuilder producedQuantity(final Integer producedQuantity) {
         this.producedQuantity = producedQuantity;
         return this;
      }

      public AssembleArtifactDTO.AssembleArtifactDTOBuilder drawingNumber(final String drawingNumber) {
         this.drawingNumber = drawingNumber;
         return this;
      }

      public AssembleArtifactDTO.AssembleArtifactDTOBuilder existStatus(final Integer existStatus) {
         this.existStatus = existStatus;
         return this;
      }

      public AssembleArtifactDTO.AssembleArtifactDTOBuilder abnormal(final Integer abnormal) {
         this.abnormal = abnormal;
         return this;
      }

      public AssembleArtifactDTO build() {
         return new AssembleArtifactDTO(
            this.id,
            this.name,
            this.serialNumber,
            this.specification,
            this.specPrefix,
            this.serialNumberPrefix,
            this.length,
            this.material,
            this.quantity,
            this.assembleQuantity,
            this.netWeight,
            this.producedQuantity,
            this.drawingNumber,
            this.existStatus,
            this.abnormal
         );
      }

      @Override
      public String toString() {
         return "AssembleArtifactDTO.AssembleArtifactDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", specPrefix="
            + this.specPrefix
            + ", serialNumberPrefix="
            + this.serialNumberPrefix
            + ", length="
            + this.length
            + ", material="
            + this.material
            + ", quantity="
            + this.quantity
            + ", assembleQuantity="
            + this.assembleQuantity
            + ", netWeight="
            + this.netWeight
            + ", producedQuantity="
            + this.producedQuantity
            + ", drawingNumber="
            + this.drawingNumber
            + ", existStatus="
            + this.existStatus
            + ", abnormal="
            + this.abnormal
            + ")";
      }
   }
}
