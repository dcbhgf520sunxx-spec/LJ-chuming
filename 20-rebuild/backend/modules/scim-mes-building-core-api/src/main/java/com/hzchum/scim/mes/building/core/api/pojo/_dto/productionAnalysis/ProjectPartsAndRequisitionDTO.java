package com.hzchum.scim.mes.building.core.api.pojo._dto.productionAnalysis;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ProjectPartsAndRequisitionDTO", description = "领料分析零件清单列表")
public class ProjectPartsAndRequisitionDTO {
   @ApiModelProperty(name = "productClassificationEnum", value = "零件分类 4.成品型材 8.钢板")
   private Integer productClassificationEnum;
   @ApiModelProperty(name = "steelSpec", value = "规格(厚度)")
   private String steelSpec;
   @ApiModelProperty(name = "material", value = "材质")
   private String material;
   @ApiModelProperty(name = "totalNetWeight", value = "清单总净重(kg)")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "totalGrossWeight", value = "清单总毛重(kg)")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "receiveWeight", value = "领料量(kg)")
   private BigDecimal receiveWeight;
   @ApiModelProperty(name = "receiveWeight", value = "理论量(kg)")
   private BigDecimal actualTheoryWeight;
   @ApiModelProperty(name = "wastageRate", notes = "损耗率（%）")
   private BigDecimal wastageRate;

   public static ProjectPartsAndRequisitionDTO.ProjectPartsAndRequisitionDTOBuilder builder() {
      return new ProjectPartsAndRequisitionDTO.ProjectPartsAndRequisitionDTOBuilder();
   }

   public ProjectPartsAndRequisitionDTO() {
   }

   public ProjectPartsAndRequisitionDTO(
      final Integer productClassificationEnum,
      final String steelSpec,
      final String material,
      final BigDecimal totalNetWeight,
      final BigDecimal totalGrossWeight,
      final BigDecimal receiveWeight,
      final BigDecimal actualTheoryWeight,
      final BigDecimal wastageRate
   ) {
      this.productClassificationEnum = productClassificationEnum;
      this.steelSpec = steelSpec;
      this.material = material;
      this.totalNetWeight = totalNetWeight;
      this.totalGrossWeight = totalGrossWeight;
      this.receiveWeight = receiveWeight;
      this.actualTheoryWeight = actualTheoryWeight;
      this.wastageRate = wastageRate;
   }

   public Integer getProductClassificationEnum() {
      return this.productClassificationEnum;
   }

   public String getSteelSpec() {
      return this.steelSpec;
   }

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public BigDecimal getReceiveWeight() {
      return this.receiveWeight;
   }

   public BigDecimal getActualTheoryWeight() {
      return this.actualTheoryWeight;
   }

   public BigDecimal getWastageRate() {
      return this.wastageRate;
   }

   public void setProductClassificationEnum(final Integer productClassificationEnum) {
      this.productClassificationEnum = productClassificationEnum;
   }

   public void setSteelSpec(final String steelSpec) {
      this.steelSpec = steelSpec;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
   }

   public void setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
   }

   public void setReceiveWeight(final BigDecimal receiveWeight) {
      this.receiveWeight = receiveWeight;
   }

   public void setActualTheoryWeight(final BigDecimal actualTheoryWeight) {
      this.actualTheoryWeight = actualTheoryWeight;
   }

   public void setWastageRate(final BigDecimal wastageRate) {
      this.wastageRate = wastageRate;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectPartsAndRequisitionDTO)) {
         return false;
      }

      ProjectPartsAndRequisitionDTO other = (ProjectPartsAndRequisitionDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productClassificationEnum = this.getProductClassificationEnum();
      Object other$productClassificationEnum = other.getProductClassificationEnum();
      if (this$productClassificationEnum == null
         ? other$productClassificationEnum == null
         : this$productClassificationEnum.equals(other$productClassificationEnum)) {
         Object this$steelSpec = this.getSteelSpec();
         Object other$steelSpec = other.getSteelSpec();
         if (this$steelSpec == null ? other$steelSpec == null : this$steelSpec.equals(other$steelSpec)) {
            Object this$material = this.getMaterial();
            Object other$material = other.getMaterial();
            if (this$material == null ? other$material == null : this$material.equals(other$material)) {
               Object this$totalNetWeight = this.getTotalNetWeight();
               Object other$totalNetWeight = other.getTotalNetWeight();
               if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
                  Object this$totalGrossWeight = this.getTotalGrossWeight();
                  Object other$totalGrossWeight = other.getTotalGrossWeight();
                  if (this$totalGrossWeight == null ? other$totalGrossWeight == null : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                     Object this$receiveWeight = this.getReceiveWeight();
                     Object other$receiveWeight = other.getReceiveWeight();
                     if (this$receiveWeight == null ? other$receiveWeight == null : this$receiveWeight.equals(other$receiveWeight)) {
                        Object this$actualTheoryWeight = this.getActualTheoryWeight();
                        Object other$actualTheoryWeight = other.getActualTheoryWeight();
                        if (this$actualTheoryWeight == null ? other$actualTheoryWeight == null : this$actualTheoryWeight.equals(other$actualTheoryWeight)) {
                           Object this$wastageRate = this.getWastageRate();
                           Object other$wastageRate = other.getWastageRate();
                           return this$wastageRate == null ? other$wastageRate == null : this$wastageRate.equals(other$wastageRate);
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
      return other instanceof ProjectPartsAndRequisitionDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productClassificationEnum = this.getProductClassificationEnum();
      result = result * 59 + ($productClassificationEnum == null ? 43 : $productClassificationEnum.hashCode());
      Object $steelSpec = this.getSteelSpec();
      result = result * 59 + ($steelSpec == null ? 43 : $steelSpec.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $receiveWeight = this.getReceiveWeight();
      result = result * 59 + ($receiveWeight == null ? 43 : $receiveWeight.hashCode());
      Object $actualTheoryWeight = this.getActualTheoryWeight();
      result = result * 59 + ($actualTheoryWeight == null ? 43 : $actualTheoryWeight.hashCode());
      Object $wastageRate = this.getWastageRate();
      return result * 59 + ($wastageRate == null ? 43 : $wastageRate.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectPartsAndRequisitionDTO(productClassificationEnum="
         + this.getProductClassificationEnum()
         + ", steelSpec="
         + this.getSteelSpec()
         + ", material="
         + this.getMaterial()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", receiveWeight="
         + this.getReceiveWeight()
         + ", actualTheoryWeight="
         + this.getActualTheoryWeight()
         + ", wastageRate="
         + this.getWastageRate()
         + ")";
   }

   public static class ProjectPartsAndRequisitionDTOBuilder {
      private Integer productClassificationEnum;
      private String steelSpec;
      private String material;
      private BigDecimal totalNetWeight;
      private BigDecimal totalGrossWeight;
      private BigDecimal receiveWeight;
      private BigDecimal actualTheoryWeight;
      private BigDecimal wastageRate;

      ProjectPartsAndRequisitionDTOBuilder() {
      }

      public ProjectPartsAndRequisitionDTO.ProjectPartsAndRequisitionDTOBuilder productClassificationEnum(final Integer productClassificationEnum) {
         this.productClassificationEnum = productClassificationEnum;
         return this;
      }

      public ProjectPartsAndRequisitionDTO.ProjectPartsAndRequisitionDTOBuilder steelSpec(final String steelSpec) {
         this.steelSpec = steelSpec;
         return this;
      }

      public ProjectPartsAndRequisitionDTO.ProjectPartsAndRequisitionDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public ProjectPartsAndRequisitionDTO.ProjectPartsAndRequisitionDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      public ProjectPartsAndRequisitionDTO.ProjectPartsAndRequisitionDTOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      public ProjectPartsAndRequisitionDTO.ProjectPartsAndRequisitionDTOBuilder receiveWeight(final BigDecimal receiveWeight) {
         this.receiveWeight = receiveWeight;
         return this;
      }

      public ProjectPartsAndRequisitionDTO.ProjectPartsAndRequisitionDTOBuilder actualTheoryWeight(final BigDecimal actualTheoryWeight) {
         this.actualTheoryWeight = actualTheoryWeight;
         return this;
      }

      public ProjectPartsAndRequisitionDTO.ProjectPartsAndRequisitionDTOBuilder wastageRate(final BigDecimal wastageRate) {
         this.wastageRate = wastageRate;
         return this;
      }

      public ProjectPartsAndRequisitionDTO build() {
         return new ProjectPartsAndRequisitionDTO(
            this.productClassificationEnum,
            this.steelSpec,
            this.material,
            this.totalNetWeight,
            this.totalGrossWeight,
            this.receiveWeight,
            this.actualTheoryWeight,
            this.wastageRate
         );
      }

      @Override
      public String toString() {
         return "ProjectPartsAndRequisitionDTO.ProjectPartsAndRequisitionDTOBuilder(productClassificationEnum="
            + this.productClassificationEnum
            + ", steelSpec="
            + this.steelSpec
            + ", material="
            + this.material
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ", receiveWeight="
            + this.receiveWeight
            + ", actualTheoryWeight="
            + this.actualTheoryWeight
            + ", wastageRate="
            + this.wastageRate
            + ")";
      }
   }
}
