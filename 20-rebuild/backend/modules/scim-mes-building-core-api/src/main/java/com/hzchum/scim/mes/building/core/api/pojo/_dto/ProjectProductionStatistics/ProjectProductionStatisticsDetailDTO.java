package com.hzchum.scim.mes.building.core.api.pojo._dto.ProjectProductionStatistics;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "ProjectProductionStatisticsDTO", description = "项目生产统计详情")
public class ProjectProductionStatisticsDetailDTO {
   @ApiModelProperty(name = "totalNetWeight", notes = "构件总净重(吨)")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "totalGrossWeight", notes = "构件总毛重(吨)")
   @JsonProperty("totalGrossWeight")
   @JSONField(name = "totalGrossWeight")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "totalSchedulingNetWeight", notes = "构件排产总净重(吨)")
   @JsonProperty("totalSchedulingNetWeight")
   @JSONField(name = "totalSchedulingNetWeight")
   private BigDecimal totalSchedulingNetWeight;
   @ApiModelProperty(name = "totalSchedulingGrossWeight", notes = "构件排产总毛重(吨)")
   @JsonProperty("totalSchedulingGrossWeight")
   @JSONField(name = "totalSchedulingGrossWeight")
   private BigDecimal totalSchedulingGrossWeight;
   @ApiModelProperty(name = "projectGetMaterialsTotalWeight", notes = "项目总领料(吨)")
   @JsonProperty("projectGetMaterialsTotalWeight")
   @JSONField(name = "projectGetMaterialsTotalWeight")
   private BigDecimal projectGetMaterialsTotalWeight;
   @ApiModelProperty(name = "productionStatisticsProcessDTOS", notes = "任务工序详情")
   @JsonProperty("productionStatisticsProcessDTOS")
   @JSONField(name = "productionStatisticsProcessDTOS")
   private List<ProjectProductionStatisticsProcessDTO> productionStatisticsProcessDTOS;

   public static ProjectProductionStatisticsDetailDTO.ProjectProductionStatisticsDetailDTOBuilder builder() {
      return new ProjectProductionStatisticsDetailDTO.ProjectProductionStatisticsDetailDTOBuilder();
   }

   public ProjectProductionStatisticsDetailDTO() {
   }

   public ProjectProductionStatisticsDetailDTO(
      final BigDecimal totalNetWeight,
      final BigDecimal totalGrossWeight,
      final BigDecimal totalSchedulingNetWeight,
      final BigDecimal totalSchedulingGrossWeight,
      final BigDecimal projectGetMaterialsTotalWeight,
      final List<ProjectProductionStatisticsProcessDTO> productionStatisticsProcessDTOS
   ) {
      this.totalNetWeight = totalNetWeight;
      this.totalGrossWeight = totalGrossWeight;
      this.totalSchedulingNetWeight = totalSchedulingNetWeight;
      this.totalSchedulingGrossWeight = totalSchedulingGrossWeight;
      this.projectGetMaterialsTotalWeight = projectGetMaterialsTotalWeight;
      this.productionStatisticsProcessDTOS = productionStatisticsProcessDTOS;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public BigDecimal getTotalSchedulingNetWeight() {
      return this.totalSchedulingNetWeight;
   }

   public BigDecimal getTotalSchedulingGrossWeight() {
      return this.totalSchedulingGrossWeight;
   }

   public BigDecimal getProjectGetMaterialsTotalWeight() {
      return this.projectGetMaterialsTotalWeight;
   }

   public List<ProjectProductionStatisticsProcessDTO> getProductionStatisticsProcessDTOS() {
      return this.productionStatisticsProcessDTOS;
   }

   @JsonProperty("totalNetWeight")
   public ProjectProductionStatisticsDetailDTO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("totalGrossWeight")
   public ProjectProductionStatisticsDetailDTO setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   @JsonProperty("totalSchedulingNetWeight")
   public ProjectProductionStatisticsDetailDTO setTotalSchedulingNetWeight(final BigDecimal totalSchedulingNetWeight) {
      this.totalSchedulingNetWeight = totalSchedulingNetWeight;
      return this;
   }

   @JsonProperty("totalSchedulingGrossWeight")
   public ProjectProductionStatisticsDetailDTO setTotalSchedulingGrossWeight(final BigDecimal totalSchedulingGrossWeight) {
      this.totalSchedulingGrossWeight = totalSchedulingGrossWeight;
      return this;
   }

   @JsonProperty("projectGetMaterialsTotalWeight")
   public ProjectProductionStatisticsDetailDTO setProjectGetMaterialsTotalWeight(final BigDecimal projectGetMaterialsTotalWeight) {
      this.projectGetMaterialsTotalWeight = projectGetMaterialsTotalWeight;
      return this;
   }

   @JsonProperty("productionStatisticsProcessDTOS")
   public ProjectProductionStatisticsDetailDTO setProductionStatisticsProcessDTOS(
      final List<ProjectProductionStatisticsProcessDTO> productionStatisticsProcessDTOS
   ) {
      this.productionStatisticsProcessDTOS = productionStatisticsProcessDTOS;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectProductionStatisticsDetailDTO(totalNetWeight="
         + this.getTotalNetWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", totalSchedulingNetWeight="
         + this.getTotalSchedulingNetWeight()
         + ", totalSchedulingGrossWeight="
         + this.getTotalSchedulingGrossWeight()
         + ", projectGetMaterialsTotalWeight="
         + this.getProjectGetMaterialsTotalWeight()
         + ", productionStatisticsProcessDTOS="
         + this.getProductionStatisticsProcessDTOS()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectProductionStatisticsDetailDTO)) {
         return false;
      }

      ProjectProductionStatisticsDetailDTO other = (ProjectProductionStatisticsDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$totalNetWeight = this.getTotalNetWeight();
      Object other$totalNetWeight = other.getTotalNetWeight();
      if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
         Object this$totalGrossWeight = this.getTotalGrossWeight();
         Object other$totalGrossWeight = other.getTotalGrossWeight();
         if (this$totalGrossWeight == null ? other$totalGrossWeight == null : this$totalGrossWeight.equals(other$totalGrossWeight)) {
            Object this$totalSchedulingNetWeight = this.getTotalSchedulingNetWeight();
            Object other$totalSchedulingNetWeight = other.getTotalSchedulingNetWeight();
            if (this$totalSchedulingNetWeight == null
               ? other$totalSchedulingNetWeight == null
               : this$totalSchedulingNetWeight.equals(other$totalSchedulingNetWeight)) {
               Object this$totalSchedulingGrossWeight = this.getTotalSchedulingGrossWeight();
               Object other$totalSchedulingGrossWeight = other.getTotalSchedulingGrossWeight();
               if (this$totalSchedulingGrossWeight == null
                  ? other$totalSchedulingGrossWeight == null
                  : this$totalSchedulingGrossWeight.equals(other$totalSchedulingGrossWeight)) {
                  Object this$projectGetMaterialsTotalWeight = this.getProjectGetMaterialsTotalWeight();
                  Object other$projectGetMaterialsTotalWeight = other.getProjectGetMaterialsTotalWeight();
                  if (this$projectGetMaterialsTotalWeight == null
                     ? other$projectGetMaterialsTotalWeight == null
                     : this$projectGetMaterialsTotalWeight.equals(other$projectGetMaterialsTotalWeight)) {
                     Object this$productionStatisticsProcessDTOS = this.getProductionStatisticsProcessDTOS();
                     Object other$productionStatisticsProcessDTOS = other.getProductionStatisticsProcessDTOS();
                     return this$productionStatisticsProcessDTOS == null
                        ? other$productionStatisticsProcessDTOS == null
                        : this$productionStatisticsProcessDTOS.equals(other$productionStatisticsProcessDTOS);
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
      return other instanceof ProjectProductionStatisticsDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $totalSchedulingNetWeight = this.getTotalSchedulingNetWeight();
      result = result * 59 + ($totalSchedulingNetWeight == null ? 43 : $totalSchedulingNetWeight.hashCode());
      Object $totalSchedulingGrossWeight = this.getTotalSchedulingGrossWeight();
      result = result * 59 + ($totalSchedulingGrossWeight == null ? 43 : $totalSchedulingGrossWeight.hashCode());
      Object $projectGetMaterialsTotalWeight = this.getProjectGetMaterialsTotalWeight();
      result = result * 59 + ($projectGetMaterialsTotalWeight == null ? 43 : $projectGetMaterialsTotalWeight.hashCode());
      Object $productionStatisticsProcessDTOS = this.getProductionStatisticsProcessDTOS();
      return result * 59 + ($productionStatisticsProcessDTOS == null ? 43 : $productionStatisticsProcessDTOS.hashCode());
   }

   public static class ProjectProductionStatisticsDetailDTOBuilder {
      private BigDecimal totalNetWeight;
      private BigDecimal totalGrossWeight;
      private BigDecimal totalSchedulingNetWeight;
      private BigDecimal totalSchedulingGrossWeight;
      private BigDecimal projectGetMaterialsTotalWeight;
      private List<ProjectProductionStatisticsProcessDTO> productionStatisticsProcessDTOS;

      ProjectProductionStatisticsDetailDTOBuilder() {
      }

      @JsonProperty("totalNetWeight")
      public ProjectProductionStatisticsDetailDTO.ProjectProductionStatisticsDetailDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("totalGrossWeight")
      public ProjectProductionStatisticsDetailDTO.ProjectProductionStatisticsDetailDTOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      @JsonProperty("totalSchedulingNetWeight")
      public ProjectProductionStatisticsDetailDTO.ProjectProductionStatisticsDetailDTOBuilder totalSchedulingNetWeight(
         final BigDecimal totalSchedulingNetWeight
      ) {
         this.totalSchedulingNetWeight = totalSchedulingNetWeight;
         return this;
      }

      @JsonProperty("totalSchedulingGrossWeight")
      public ProjectProductionStatisticsDetailDTO.ProjectProductionStatisticsDetailDTOBuilder totalSchedulingGrossWeight(
         final BigDecimal totalSchedulingGrossWeight
      ) {
         this.totalSchedulingGrossWeight = totalSchedulingGrossWeight;
         return this;
      }

      @JsonProperty("projectGetMaterialsTotalWeight")
      public ProjectProductionStatisticsDetailDTO.ProjectProductionStatisticsDetailDTOBuilder projectGetMaterialsTotalWeight(
         final BigDecimal projectGetMaterialsTotalWeight
      ) {
         this.projectGetMaterialsTotalWeight = projectGetMaterialsTotalWeight;
         return this;
      }

      @JsonProperty("productionStatisticsProcessDTOS")
      public ProjectProductionStatisticsDetailDTO.ProjectProductionStatisticsDetailDTOBuilder productionStatisticsProcessDTOS(
         final List<ProjectProductionStatisticsProcessDTO> productionStatisticsProcessDTOS
      ) {
         this.productionStatisticsProcessDTOS = productionStatisticsProcessDTOS;
         return this;
      }

      public ProjectProductionStatisticsDetailDTO build() {
         return new ProjectProductionStatisticsDetailDTO(
            this.totalNetWeight,
            this.totalGrossWeight,
            this.totalSchedulingNetWeight,
            this.totalSchedulingGrossWeight,
            this.projectGetMaterialsTotalWeight,
            this.productionStatisticsProcessDTOS
         );
      }

      @Override
      public String toString() {
         return "ProjectProductionStatisticsDetailDTO.ProjectProductionStatisticsDetailDTOBuilder(totalNetWeight="
            + this.totalNetWeight
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ", totalSchedulingNetWeight="
            + this.totalSchedulingNetWeight
            + ", totalSchedulingGrossWeight="
            + this.totalSchedulingGrossWeight
            + ", projectGetMaterialsTotalWeight="
            + this.projectGetMaterialsTotalWeight
            + ", productionStatisticsProcessDTOS="
            + this.productionStatisticsProcessDTOS
            + ")";
      }
   }
}
