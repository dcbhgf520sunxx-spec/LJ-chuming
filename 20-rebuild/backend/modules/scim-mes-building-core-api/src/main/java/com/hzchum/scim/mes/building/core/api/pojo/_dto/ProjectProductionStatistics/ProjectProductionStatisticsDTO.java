package com.hzchum.scim.mes.building.core.api.pojo._dto.ProjectProductionStatistics;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ProjectProductionStatisticsDTO", description = "获取项目生产统计汇总")
public class ProjectProductionStatisticsDTO {
   @ApiModelProperty(name = "totalNetWeight", notes = "构件总净重(吨)")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "totalGrossWeight", notes = "构件总毛重(吨)")
   @JsonProperty("totalGrossWeight")
   @JSONField(name = "totalGrossWeight")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "inProductionTotalNetWeight", notes = "构件在制品总净重(吨)")
   @JsonProperty("inProductionTotalNetWeight")
   @JSONField(name = "inProductionTotalNetWeight")
   private BigDecimal inProductionTotalNetWeight;
   @ApiModelProperty(name = "inProductionTotalGrossWeight", notes = "构件在制品总毛重(吨)")
   @JsonProperty("inProductionTotalGrossWeight")
   @JSONField(name = "inProductionTotalGrossWeight")
   private BigDecimal inProductionTotalGrossWeight;
   @ApiModelProperty(name = "partInProductionTotalNetWeight", notes = "零件在制品总净重(吨)")
   @JsonProperty("partInProductionTotalNetWeight")
   @JSONField(name = "partInProductionTotalNetWeight")
   private BigDecimal partInProductionTotalNetWeight;
   @ApiModelProperty(name = "partInProductionTotalGrossWeight", notes = "零件在制品总毛重(吨)")
   @JsonProperty("partInProductionTotalGrossWeight")
   @JSONField(name = "partInProductionTotalGrossWeight")
   private BigDecimal partInProductionTotalGrossWeight;
   @ApiModelProperty(name = "companyTotalNetWeight", notes = "构件制成品总净重(吨)")
   @JsonProperty("companyTotalNetWeight")
   @JSONField(name = "companyTotalNetWeight")
   private BigDecimal companyTotalNetWeight;
   @ApiModelProperty(name = "companyTotalGrossWeight", notes = "构件制成品总毛重(吨)")
   @JsonProperty("companyTotalGrossWeight")
   @JSONField(name = "companyTotalGrossWeight")
   private BigDecimal companyTotalGrossWeight;
   @ApiModelProperty(name = "finishingRate", notes = "构件完成率(百分百)")
   @JsonProperty("finishingRate")
   @JSONField(name = "finishingRate")
   private BigDecimal finishingRate;
   @ApiModelProperty(name = "projectGetMaterialsTotalWeight", notes = "项目总领料(吨)")
   @JsonProperty("projectGetMaterialsTotalWeight")
   @JSONField(name = "projectGetMaterialsTotalWeight")
   private BigDecimal projectGetMaterialsTotalWeight;

   public static ProjectProductionStatisticsDTO.ProjectProductionStatisticsDTOBuilder builder() {
      return new ProjectProductionStatisticsDTO.ProjectProductionStatisticsDTOBuilder();
   }

   public ProjectProductionStatisticsDTO() {
   }

   public ProjectProductionStatisticsDTO(
      final BigDecimal totalNetWeight,
      final BigDecimal totalGrossWeight,
      final BigDecimal inProductionTotalNetWeight,
      final BigDecimal inProductionTotalGrossWeight,
      final BigDecimal partInProductionTotalNetWeight,
      final BigDecimal partInProductionTotalGrossWeight,
      final BigDecimal companyTotalNetWeight,
      final BigDecimal companyTotalGrossWeight,
      final BigDecimal finishingRate,
      final BigDecimal projectGetMaterialsTotalWeight
   ) {
      this.totalNetWeight = totalNetWeight;
      this.totalGrossWeight = totalGrossWeight;
      this.inProductionTotalNetWeight = inProductionTotalNetWeight;
      this.inProductionTotalGrossWeight = inProductionTotalGrossWeight;
      this.partInProductionTotalNetWeight = partInProductionTotalNetWeight;
      this.partInProductionTotalGrossWeight = partInProductionTotalGrossWeight;
      this.companyTotalNetWeight = companyTotalNetWeight;
      this.companyTotalGrossWeight = companyTotalGrossWeight;
      this.finishingRate = finishingRate;
      this.projectGetMaterialsTotalWeight = projectGetMaterialsTotalWeight;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public BigDecimal getInProductionTotalNetWeight() {
      return this.inProductionTotalNetWeight;
   }

   public BigDecimal getInProductionTotalGrossWeight() {
      return this.inProductionTotalGrossWeight;
   }

   public BigDecimal getPartInProductionTotalNetWeight() {
      return this.partInProductionTotalNetWeight;
   }

   public BigDecimal getPartInProductionTotalGrossWeight() {
      return this.partInProductionTotalGrossWeight;
   }

   public BigDecimal getCompanyTotalNetWeight() {
      return this.companyTotalNetWeight;
   }

   public BigDecimal getCompanyTotalGrossWeight() {
      return this.companyTotalGrossWeight;
   }

   public BigDecimal getFinishingRate() {
      return this.finishingRate;
   }

   public BigDecimal getProjectGetMaterialsTotalWeight() {
      return this.projectGetMaterialsTotalWeight;
   }

   @JsonProperty("totalNetWeight")
   public ProjectProductionStatisticsDTO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("totalGrossWeight")
   public ProjectProductionStatisticsDTO setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   @JsonProperty("inProductionTotalNetWeight")
   public ProjectProductionStatisticsDTO setInProductionTotalNetWeight(final BigDecimal inProductionTotalNetWeight) {
      this.inProductionTotalNetWeight = inProductionTotalNetWeight;
      return this;
   }

   @JsonProperty("inProductionTotalGrossWeight")
   public ProjectProductionStatisticsDTO setInProductionTotalGrossWeight(final BigDecimal inProductionTotalGrossWeight) {
      this.inProductionTotalGrossWeight = inProductionTotalGrossWeight;
      return this;
   }

   @JsonProperty("partInProductionTotalNetWeight")
   public ProjectProductionStatisticsDTO setPartInProductionTotalNetWeight(final BigDecimal partInProductionTotalNetWeight) {
      this.partInProductionTotalNetWeight = partInProductionTotalNetWeight;
      return this;
   }

   @JsonProperty("partInProductionTotalGrossWeight")
   public ProjectProductionStatisticsDTO setPartInProductionTotalGrossWeight(final BigDecimal partInProductionTotalGrossWeight) {
      this.partInProductionTotalGrossWeight = partInProductionTotalGrossWeight;
      return this;
   }

   @JsonProperty("companyTotalNetWeight")
   public ProjectProductionStatisticsDTO setCompanyTotalNetWeight(final BigDecimal companyTotalNetWeight) {
      this.companyTotalNetWeight = companyTotalNetWeight;
      return this;
   }

   @JsonProperty("companyTotalGrossWeight")
   public ProjectProductionStatisticsDTO setCompanyTotalGrossWeight(final BigDecimal companyTotalGrossWeight) {
      this.companyTotalGrossWeight = companyTotalGrossWeight;
      return this;
   }

   @JsonProperty("finishingRate")
   public ProjectProductionStatisticsDTO setFinishingRate(final BigDecimal finishingRate) {
      this.finishingRate = finishingRate;
      return this;
   }

   @JsonProperty("projectGetMaterialsTotalWeight")
   public ProjectProductionStatisticsDTO setProjectGetMaterialsTotalWeight(final BigDecimal projectGetMaterialsTotalWeight) {
      this.projectGetMaterialsTotalWeight = projectGetMaterialsTotalWeight;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectProductionStatisticsDTO(totalNetWeight="
         + this.getTotalNetWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", inProductionTotalNetWeight="
         + this.getInProductionTotalNetWeight()
         + ", inProductionTotalGrossWeight="
         + this.getInProductionTotalGrossWeight()
         + ", partInProductionTotalNetWeight="
         + this.getPartInProductionTotalNetWeight()
         + ", partInProductionTotalGrossWeight="
         + this.getPartInProductionTotalGrossWeight()
         + ", companyTotalNetWeight="
         + this.getCompanyTotalNetWeight()
         + ", companyTotalGrossWeight="
         + this.getCompanyTotalGrossWeight()
         + ", finishingRate="
         + this.getFinishingRate()
         + ", projectGetMaterialsTotalWeight="
         + this.getProjectGetMaterialsTotalWeight()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectProductionStatisticsDTO)) {
         return false;
      }

      ProjectProductionStatisticsDTO other = (ProjectProductionStatisticsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$totalNetWeight = this.getTotalNetWeight();
      Object other$totalNetWeight = other.getTotalNetWeight();
      if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
         Object this$totalGrossWeight = this.getTotalGrossWeight();
         Object other$totalGrossWeight = other.getTotalGrossWeight();
         if (this$totalGrossWeight == null ? other$totalGrossWeight == null : this$totalGrossWeight.equals(other$totalGrossWeight)) {
            Object this$inProductionTotalNetWeight = this.getInProductionTotalNetWeight();
            Object other$inProductionTotalNetWeight = other.getInProductionTotalNetWeight();
            if (this$inProductionTotalNetWeight == null
               ? other$inProductionTotalNetWeight == null
               : this$inProductionTotalNetWeight.equals(other$inProductionTotalNetWeight)) {
               Object this$inProductionTotalGrossWeight = this.getInProductionTotalGrossWeight();
               Object other$inProductionTotalGrossWeight = other.getInProductionTotalGrossWeight();
               if (this$inProductionTotalGrossWeight == null
                  ? other$inProductionTotalGrossWeight == null
                  : this$inProductionTotalGrossWeight.equals(other$inProductionTotalGrossWeight)) {
                  Object this$partInProductionTotalNetWeight = this.getPartInProductionTotalNetWeight();
                  Object other$partInProductionTotalNetWeight = other.getPartInProductionTotalNetWeight();
                  if (this$partInProductionTotalNetWeight == null
                     ? other$partInProductionTotalNetWeight == null
                     : this$partInProductionTotalNetWeight.equals(other$partInProductionTotalNetWeight)) {
                     Object this$partInProductionTotalGrossWeight = this.getPartInProductionTotalGrossWeight();
                     Object other$partInProductionTotalGrossWeight = other.getPartInProductionTotalGrossWeight();
                     if (this$partInProductionTotalGrossWeight == null
                        ? other$partInProductionTotalGrossWeight == null
                        : this$partInProductionTotalGrossWeight.equals(other$partInProductionTotalGrossWeight)) {
                        Object this$companyTotalNetWeight = this.getCompanyTotalNetWeight();
                        Object other$companyTotalNetWeight = other.getCompanyTotalNetWeight();
                        if (this$companyTotalNetWeight == null
                           ? other$companyTotalNetWeight == null
                           : this$companyTotalNetWeight.equals(other$companyTotalNetWeight)) {
                           Object this$companyTotalGrossWeight = this.getCompanyTotalGrossWeight();
                           Object other$companyTotalGrossWeight = other.getCompanyTotalGrossWeight();
                           if (this$companyTotalGrossWeight == null
                              ? other$companyTotalGrossWeight == null
                              : this$companyTotalGrossWeight.equals(other$companyTotalGrossWeight)) {
                              Object this$finishingRate = this.getFinishingRate();
                              Object other$finishingRate = other.getFinishingRate();
                              if (this$finishingRate == null ? other$finishingRate == null : this$finishingRate.equals(other$finishingRate)) {
                                 Object this$projectGetMaterialsTotalWeight = this.getProjectGetMaterialsTotalWeight();
                                 Object other$projectGetMaterialsTotalWeight = other.getProjectGetMaterialsTotalWeight();
                                 return this$projectGetMaterialsTotalWeight == null
                                    ? other$projectGetMaterialsTotalWeight == null
                                    : this$projectGetMaterialsTotalWeight.equals(other$projectGetMaterialsTotalWeight);
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
      return other instanceof ProjectProductionStatisticsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $inProductionTotalNetWeight = this.getInProductionTotalNetWeight();
      result = result * 59 + ($inProductionTotalNetWeight == null ? 43 : $inProductionTotalNetWeight.hashCode());
      Object $inProductionTotalGrossWeight = this.getInProductionTotalGrossWeight();
      result = result * 59 + ($inProductionTotalGrossWeight == null ? 43 : $inProductionTotalGrossWeight.hashCode());
      Object $partInProductionTotalNetWeight = this.getPartInProductionTotalNetWeight();
      result = result * 59 + ($partInProductionTotalNetWeight == null ? 43 : $partInProductionTotalNetWeight.hashCode());
      Object $partInProductionTotalGrossWeight = this.getPartInProductionTotalGrossWeight();
      result = result * 59 + ($partInProductionTotalGrossWeight == null ? 43 : $partInProductionTotalGrossWeight.hashCode());
      Object $companyTotalNetWeight = this.getCompanyTotalNetWeight();
      result = result * 59 + ($companyTotalNetWeight == null ? 43 : $companyTotalNetWeight.hashCode());
      Object $companyTotalGrossWeight = this.getCompanyTotalGrossWeight();
      result = result * 59 + ($companyTotalGrossWeight == null ? 43 : $companyTotalGrossWeight.hashCode());
      Object $finishingRate = this.getFinishingRate();
      result = result * 59 + ($finishingRate == null ? 43 : $finishingRate.hashCode());
      Object $projectGetMaterialsTotalWeight = this.getProjectGetMaterialsTotalWeight();
      return result * 59 + ($projectGetMaterialsTotalWeight == null ? 43 : $projectGetMaterialsTotalWeight.hashCode());
   }

   public static class ProjectProductionStatisticsDTOBuilder {
      private BigDecimal totalNetWeight;
      private BigDecimal totalGrossWeight;
      private BigDecimal inProductionTotalNetWeight;
      private BigDecimal inProductionTotalGrossWeight;
      private BigDecimal partInProductionTotalNetWeight;
      private BigDecimal partInProductionTotalGrossWeight;
      private BigDecimal companyTotalNetWeight;
      private BigDecimal companyTotalGrossWeight;
      private BigDecimal finishingRate;
      private BigDecimal projectGetMaterialsTotalWeight;

      ProjectProductionStatisticsDTOBuilder() {
      }

      @JsonProperty("totalNetWeight")
      public ProjectProductionStatisticsDTO.ProjectProductionStatisticsDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("totalGrossWeight")
      public ProjectProductionStatisticsDTO.ProjectProductionStatisticsDTOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      @JsonProperty("inProductionTotalNetWeight")
      public ProjectProductionStatisticsDTO.ProjectProductionStatisticsDTOBuilder inProductionTotalNetWeight(final BigDecimal inProductionTotalNetWeight) {
         this.inProductionTotalNetWeight = inProductionTotalNetWeight;
         return this;
      }

      @JsonProperty("inProductionTotalGrossWeight")
      public ProjectProductionStatisticsDTO.ProjectProductionStatisticsDTOBuilder inProductionTotalGrossWeight(final BigDecimal inProductionTotalGrossWeight) {
         this.inProductionTotalGrossWeight = inProductionTotalGrossWeight;
         return this;
      }

      @JsonProperty("partInProductionTotalNetWeight")
      public ProjectProductionStatisticsDTO.ProjectProductionStatisticsDTOBuilder partInProductionTotalNetWeight(
         final BigDecimal partInProductionTotalNetWeight
      ) {
         this.partInProductionTotalNetWeight = partInProductionTotalNetWeight;
         return this;
      }

      @JsonProperty("partInProductionTotalGrossWeight")
      public ProjectProductionStatisticsDTO.ProjectProductionStatisticsDTOBuilder partInProductionTotalGrossWeight(
         final BigDecimal partInProductionTotalGrossWeight
      ) {
         this.partInProductionTotalGrossWeight = partInProductionTotalGrossWeight;
         return this;
      }

      @JsonProperty("companyTotalNetWeight")
      public ProjectProductionStatisticsDTO.ProjectProductionStatisticsDTOBuilder companyTotalNetWeight(final BigDecimal companyTotalNetWeight) {
         this.companyTotalNetWeight = companyTotalNetWeight;
         return this;
      }

      @JsonProperty("companyTotalGrossWeight")
      public ProjectProductionStatisticsDTO.ProjectProductionStatisticsDTOBuilder companyTotalGrossWeight(final BigDecimal companyTotalGrossWeight) {
         this.companyTotalGrossWeight = companyTotalGrossWeight;
         return this;
      }

      @JsonProperty("finishingRate")
      public ProjectProductionStatisticsDTO.ProjectProductionStatisticsDTOBuilder finishingRate(final BigDecimal finishingRate) {
         this.finishingRate = finishingRate;
         return this;
      }

      @JsonProperty("projectGetMaterialsTotalWeight")
      public ProjectProductionStatisticsDTO.ProjectProductionStatisticsDTOBuilder projectGetMaterialsTotalWeight(
         final BigDecimal projectGetMaterialsTotalWeight
      ) {
         this.projectGetMaterialsTotalWeight = projectGetMaterialsTotalWeight;
         return this;
      }

      public ProjectProductionStatisticsDTO build() {
         return new ProjectProductionStatisticsDTO(
            this.totalNetWeight,
            this.totalGrossWeight,
            this.inProductionTotalNetWeight,
            this.inProductionTotalGrossWeight,
            this.partInProductionTotalNetWeight,
            this.partInProductionTotalGrossWeight,
            this.companyTotalNetWeight,
            this.companyTotalGrossWeight,
            this.finishingRate,
            this.projectGetMaterialsTotalWeight
         );
      }

      @Override
      public String toString() {
         return "ProjectProductionStatisticsDTO.ProjectProductionStatisticsDTOBuilder(totalNetWeight="
            + this.totalNetWeight
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ", inProductionTotalNetWeight="
            + this.inProductionTotalNetWeight
            + ", inProductionTotalGrossWeight="
            + this.inProductionTotalGrossWeight
            + ", partInProductionTotalNetWeight="
            + this.partInProductionTotalNetWeight
            + ", partInProductionTotalGrossWeight="
            + this.partInProductionTotalGrossWeight
            + ", companyTotalNetWeight="
            + this.companyTotalNetWeight
            + ", companyTotalGrossWeight="
            + this.companyTotalGrossWeight
            + ", finishingRate="
            + this.finishingRate
            + ", projectGetMaterialsTotalWeight="
            + this.projectGetMaterialsTotalWeight
            + ")";
      }
   }
}
