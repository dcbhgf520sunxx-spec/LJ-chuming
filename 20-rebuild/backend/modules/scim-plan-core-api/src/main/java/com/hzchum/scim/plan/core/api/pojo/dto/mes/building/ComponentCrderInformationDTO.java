package com.hzchum.scim.plan.core.api.pojo.dto.mes.building;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "ComponentCrderInformationDTO", description = "零构件订单信息 ")
public class ComponentCrderInformationDTO {
   @ApiModelProperty(name = "classificationId", notes = "分类id")
   @JsonProperty("classificationId")
   @JSONField(name = "classificationId")
   private Long classificationId;
   @ApiModelProperty(name = "classificationName", notes = "分类")
   @JsonProperty("classificationName")
   @JSONField(name = "classificationName")
   private String classificationName;
   @ApiModelProperty(name = "material", notes = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "totalNetWeight", notes = "总净重（kg）")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "specifications", notes = "规格集合 钢板为厚度 型材为规格")
   @JsonProperty("specifications")
   @JSONField(name = "specifications")
   private List<String> specifications;
   @ApiModelProperty(name = "artifactType", notes = "构件特有  是否次构件  1 普通构件  2 次构件")
   @JsonProperty("artifactType")
   @JSONField(name = "artifactType")
   private BigDecimal artifactType;

   public static ComponentCrderInformationDTO.ComponentCrderInformationDTOBuilder builder() {
      return new ComponentCrderInformationDTO.ComponentCrderInformationDTOBuilder();
   }

   public ComponentCrderInformationDTO() {
   }

   public ComponentCrderInformationDTO(
      final Long classificationId,
      final String classificationName,
      final String material,
      final Integer quantity,
      final BigDecimal totalNetWeight,
      final List<String> specifications,
      final BigDecimal artifactType
   ) {
      this.classificationId = classificationId;
      this.classificationName = classificationName;
      this.material = material;
      this.quantity = quantity;
      this.totalNetWeight = totalNetWeight;
      this.specifications = specifications;
      this.artifactType = artifactType;
   }

   public Long getClassificationId() {
      return this.classificationId;
   }

   public String getClassificationName() {
      return this.classificationName;
   }

   public String getMaterial() {
      return this.material;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public List<String> getSpecifications() {
      return this.specifications;
   }

   public BigDecimal getArtifactType() {
      return this.artifactType;
   }

   @JsonProperty("classificationId")
   public ComponentCrderInformationDTO setClassificationId(final Long classificationId) {
      this.classificationId = classificationId;
      return this;
   }

   @JsonProperty("classificationName")
   public ComponentCrderInformationDTO setClassificationName(final String classificationName) {
      this.classificationName = classificationName;
      return this;
   }

   @JsonProperty("material")
   public ComponentCrderInformationDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("quantity")
   public ComponentCrderInformationDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public ComponentCrderInformationDTO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("specifications")
   public ComponentCrderInformationDTO setSpecifications(final List<String> specifications) {
      this.specifications = specifications;
      return this;
   }

   @JsonProperty("artifactType")
   public ComponentCrderInformationDTO setArtifactType(final BigDecimal artifactType) {
      this.artifactType = artifactType;
      return this;
   }

   @Override
   public String toString() {
      return "ComponentCrderInformationDTO(classificationId="
         + this.getClassificationId()
         + ", classificationName="
         + this.getClassificationName()
         + ", material="
         + this.getMaterial()
         + ", quantity="
         + this.getQuantity()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", specifications="
         + this.getSpecifications()
         + ", artifactType="
         + this.getArtifactType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ComponentCrderInformationDTO)) {
         return false;
      }

      ComponentCrderInformationDTO other = (ComponentCrderInformationDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$classificationId = this.getClassificationId();
      Object other$classificationId = other.getClassificationId();
      if (this$classificationId == null ? other$classificationId == null : this$classificationId.equals(other$classificationId)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$classificationName = this.getClassificationName();
            Object other$classificationName = other.getClassificationName();
            if (this$classificationName == null ? other$classificationName == null : this$classificationName.equals(other$classificationName)) {
               Object this$material = this.getMaterial();
               Object other$material = other.getMaterial();
               if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                  Object this$totalNetWeight = this.getTotalNetWeight();
                  Object other$totalNetWeight = other.getTotalNetWeight();
                  if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
                     Object this$specifications = this.getSpecifications();
                     Object other$specifications = other.getSpecifications();
                     if (this$specifications == null ? other$specifications == null : this$specifications.equals(other$specifications)) {
                        Object this$artifactType = this.getArtifactType();
                        Object other$artifactType = other.getArtifactType();
                        return this$artifactType == null ? other$artifactType == null : this$artifactType.equals(other$artifactType);
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
      return other instanceof ComponentCrderInformationDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $classificationId = this.getClassificationId();
      result = result * 59 + ($classificationId == null ? 43 : $classificationId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $classificationName = this.getClassificationName();
      result = result * 59 + ($classificationName == null ? 43 : $classificationName.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $specifications = this.getSpecifications();
      result = result * 59 + ($specifications == null ? 43 : $specifications.hashCode());
      Object $artifactType = this.getArtifactType();
      return result * 59 + ($artifactType == null ? 43 : $artifactType.hashCode());
   }

   public static class ComponentCrderInformationDTOBuilder {
      private Long classificationId;
      private String classificationName;
      private String material;
      private Integer quantity;
      private BigDecimal totalNetWeight;
      private List<String> specifications;
      private BigDecimal artifactType;

      ComponentCrderInformationDTOBuilder() {
      }

      @JsonProperty("classificationId")
      public ComponentCrderInformationDTO.ComponentCrderInformationDTOBuilder classificationId(final Long classificationId) {
         this.classificationId = classificationId;
         return this;
      }

      @JsonProperty("classificationName")
      public ComponentCrderInformationDTO.ComponentCrderInformationDTOBuilder classificationName(final String classificationName) {
         this.classificationName = classificationName;
         return this;
      }

      @JsonProperty("material")
      public ComponentCrderInformationDTO.ComponentCrderInformationDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("quantity")
      public ComponentCrderInformationDTO.ComponentCrderInformationDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public ComponentCrderInformationDTO.ComponentCrderInformationDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("specifications")
      public ComponentCrderInformationDTO.ComponentCrderInformationDTOBuilder specifications(final List<String> specifications) {
         this.specifications = specifications;
         return this;
      }

      @JsonProperty("artifactType")
      public ComponentCrderInformationDTO.ComponentCrderInformationDTOBuilder artifactType(final BigDecimal artifactType) {
         this.artifactType = artifactType;
         return this;
      }

      public ComponentCrderInformationDTO build() {
         return new ComponentCrderInformationDTO(
            this.classificationId, this.classificationName, this.material, this.quantity, this.totalNetWeight, this.specifications, this.artifactType
         );
      }

      @Override
      public String toString() {
         return "ComponentCrderInformationDTO.ComponentCrderInformationDTOBuilder(classificationId="
            + this.classificationId
            + ", classificationName="
            + this.classificationName
            + ", material="
            + this.material
            + ", quantity="
            + this.quantity
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", specifications="
            + this.specifications
            + ", artifactType="
            + this.artifactType
            + ")";
      }
   }
}
