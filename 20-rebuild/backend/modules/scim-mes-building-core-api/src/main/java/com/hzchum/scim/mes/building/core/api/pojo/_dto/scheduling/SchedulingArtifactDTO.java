package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ArtifactDTO对象", description = "构件清单信息")
public class SchedulingArtifactDTO {
   @ApiModelProperty(name = "classificationName", notes = "构件分类")
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
   @ApiModelProperty(name = "totalGrossWeight", notes = "总毛重（kg）")
   @JsonProperty("totalGrossWeight")
   @JSONField(name = "totalGrossWeight")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "totalNetWeight", notes = "总毛重（kg）")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "artifactType", notes = "是否次构件  1 普通构件  2 次构件")
   @JsonProperty("artifactType")
   @JSONField(name = "artifactType")
   private BigDecimal artifactType;

   public static SchedulingArtifactDTO.SchedulingArtifactDTOBuilder builder() {
      return new SchedulingArtifactDTO.SchedulingArtifactDTOBuilder();
   }

   public SchedulingArtifactDTO() {
   }

   public SchedulingArtifactDTO(
      final String classificationName,
      final String material,
      final Integer quantity,
      final BigDecimal totalGrossWeight,
      final BigDecimal totalNetWeight,
      final BigDecimal artifactType
   ) {
      this.classificationName = classificationName;
      this.material = material;
      this.quantity = quantity;
      this.totalGrossWeight = totalGrossWeight;
      this.totalNetWeight = totalNetWeight;
      this.artifactType = artifactType;
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

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getArtifactType() {
      return this.artifactType;
   }

   @JsonProperty("classificationName")
   public SchedulingArtifactDTO setClassificationName(final String classificationName) {
      this.classificationName = classificationName;
      return this;
   }

   @JsonProperty("material")
   public SchedulingArtifactDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("quantity")
   public SchedulingArtifactDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("totalGrossWeight")
   public SchedulingArtifactDTO setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public SchedulingArtifactDTO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("artifactType")
   public SchedulingArtifactDTO setArtifactType(final BigDecimal artifactType) {
      this.artifactType = artifactType;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SchedulingArtifactDTO)) {
         return false;
      }

      SchedulingArtifactDTO other = (SchedulingArtifactDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$classificationName = this.getClassificationName();
         Object other$classificationName = other.getClassificationName();
         if (this$classificationName == null ? other$classificationName == null : this$classificationName.equals(other$classificationName)) {
            Object this$material = this.getMaterial();
            Object other$material = other.getMaterial();
            if (this$material == null ? other$material == null : this$material.equals(other$material)) {
               Object this$totalGrossWeight = this.getTotalGrossWeight();
               Object other$totalGrossWeight = other.getTotalGrossWeight();
               if (this$totalGrossWeight == null ? other$totalGrossWeight == null : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                  Object this$totalNetWeight = this.getTotalNetWeight();
                  Object other$totalNetWeight = other.getTotalNetWeight();
                  if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SchedulingArtifactDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $classificationName = this.getClassificationName();
      result = result * 59 + ($classificationName == null ? 43 : $classificationName.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $artifactType = this.getArtifactType();
      return result * 59 + ($artifactType == null ? 43 : $artifactType.hashCode());
   }

   @Override
   public String toString() {
      return "SchedulingArtifactDTO(classificationName="
         + this.getClassificationName()
         + ", material="
         + this.getMaterial()
         + ", quantity="
         + this.getQuantity()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", artifactType="
         + this.getArtifactType()
         + ")";
   }

   public static class SchedulingArtifactDTOBuilder {
      private String classificationName;
      private String material;
      private Integer quantity;
      private BigDecimal totalGrossWeight;
      private BigDecimal totalNetWeight;
      private BigDecimal artifactType;

      SchedulingArtifactDTOBuilder() {
      }

      @JsonProperty("classificationName")
      public SchedulingArtifactDTO.SchedulingArtifactDTOBuilder classificationName(final String classificationName) {
         this.classificationName = classificationName;
         return this;
      }

      @JsonProperty("material")
      public SchedulingArtifactDTO.SchedulingArtifactDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("quantity")
      public SchedulingArtifactDTO.SchedulingArtifactDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("totalGrossWeight")
      public SchedulingArtifactDTO.SchedulingArtifactDTOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public SchedulingArtifactDTO.SchedulingArtifactDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("artifactType")
      public SchedulingArtifactDTO.SchedulingArtifactDTOBuilder artifactType(final BigDecimal artifactType) {
         this.artifactType = artifactType;
         return this;
      }

      public SchedulingArtifactDTO build() {
         return new SchedulingArtifactDTO(this.classificationName, this.material, this.quantity, this.totalGrossWeight, this.totalNetWeight, this.artifactType);
      }

      @Override
      public String toString() {
         return "SchedulingArtifactDTO.SchedulingArtifactDTOBuilder(classificationName="
            + this.classificationName
            + ", material="
            + this.material
            + ", quantity="
            + this.quantity
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", artifactType="
            + this.artifactType
            + ")";
      }
   }
}
