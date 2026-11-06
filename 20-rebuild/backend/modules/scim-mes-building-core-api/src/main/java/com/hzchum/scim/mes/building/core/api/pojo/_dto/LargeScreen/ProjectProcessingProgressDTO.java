package com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "项目加工进度")
public class ProjectProcessingProgressDTO {
   @ApiModelProperty(name = "projectId", value = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "projectName", value = "项目名称")
   @JsonProperty("projectName")
   @JSONField(name = "projectName")
   private String projectName;
   @ApiModelProperty(name = "totalWeight", value = "总重")
   @JsonProperty("totalWeight")
   @JSONField(name = "totalWeight")
   private BigDecimal totalWeight;
   @ApiModelProperty(name = "blankingRate", value = "下料")
   @JsonProperty("blankingRate")
   @JSONField(name = "blankingRate")
   private BigDecimal blankingRate;
   @ApiModelProperty(name = "assembleRate", value = "组立")
   @JsonProperty("assembleRate")
   @JSONField(name = "assembleRate")
   private BigDecimal assembleRate;
   @ApiModelProperty(name = "buriedArcRate", value = "门焊")
   @JsonProperty("buriedArcRate")
   @JSONField(name = "buriedArcRate")
   private BigDecimal buriedArcRate;
   @ApiModelProperty(name = "assemblyRate", value = "装配")
   @JsonProperty("assemblyRate")
   @JSONField(name = "assemblyRate")
   private BigDecimal assemblyRate;
   @ApiModelProperty(name = "solderingRate", value = "焊接")
   @JsonProperty("solderingRate")
   @JSONField(name = "solderingRate")
   private BigDecimal solderingRate;
   @ApiModelProperty(name = "grindingRate", value = "清磨")
   @JsonProperty("grindingRate")
   @JSONField(name = "grindingRate")
   private BigDecimal grindingRate;
   @ApiModelProperty(name = "liveryRate", value = "涂装")
   @JsonProperty("liveryRate")
   @JSONField(name = "liveryRate")
   private BigDecimal liveryRate;
   @ApiModelProperty(name = "manufactureRate", value = "制造")
   @JsonProperty("manufactureRate")
   @JSONField(name = "manufactureRate")
   private BigDecimal manufactureRate;

   public static ProjectProcessingProgressDTO.ProjectProcessingProgressDTOBuilder builder() {
      return new ProjectProcessingProgressDTO.ProjectProcessingProgressDTOBuilder();
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   public BigDecimal getBlankingRate() {
      return this.blankingRate;
   }

   public BigDecimal getAssembleRate() {
      return this.assembleRate;
   }

   public BigDecimal getBuriedArcRate() {
      return this.buriedArcRate;
   }

   public BigDecimal getAssemblyRate() {
      return this.assemblyRate;
   }

   public BigDecimal getSolderingRate() {
      return this.solderingRate;
   }

   public BigDecimal getGrindingRate() {
      return this.grindingRate;
   }

   public BigDecimal getLiveryRate() {
      return this.liveryRate;
   }

   public BigDecimal getManufactureRate() {
      return this.manufactureRate;
   }

   @JsonProperty("projectId")
   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   @JsonProperty("projectName")
   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   @JsonProperty("totalWeight")
   public void setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
   }

   @JsonProperty("blankingRate")
   public void setBlankingRate(final BigDecimal blankingRate) {
      this.blankingRate = blankingRate;
   }

   @JsonProperty("assembleRate")
   public void setAssembleRate(final BigDecimal assembleRate) {
      this.assembleRate = assembleRate;
   }

   @JsonProperty("buriedArcRate")
   public void setBuriedArcRate(final BigDecimal buriedArcRate) {
      this.buriedArcRate = buriedArcRate;
   }

   @JsonProperty("assemblyRate")
   public void setAssemblyRate(final BigDecimal assemblyRate) {
      this.assemblyRate = assemblyRate;
   }

   @JsonProperty("solderingRate")
   public void setSolderingRate(final BigDecimal solderingRate) {
      this.solderingRate = solderingRate;
   }

   @JsonProperty("grindingRate")
   public void setGrindingRate(final BigDecimal grindingRate) {
      this.grindingRate = grindingRate;
   }

   @JsonProperty("liveryRate")
   public void setLiveryRate(final BigDecimal liveryRate) {
      this.liveryRate = liveryRate;
   }

   @JsonProperty("manufactureRate")
   public void setManufactureRate(final BigDecimal manufactureRate) {
      this.manufactureRate = manufactureRate;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectProcessingProgressDTO)) {
         return false;
      }

      ProjectProcessingProgressDTO other = (ProjectProcessingProgressDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$projectName = this.getProjectName();
         Object other$projectName = other.getProjectName();
         if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
            Object this$totalWeight = this.getTotalWeight();
            Object other$totalWeight = other.getTotalWeight();
            if (this$totalWeight == null ? other$totalWeight == null : this$totalWeight.equals(other$totalWeight)) {
               Object this$blankingRate = this.getBlankingRate();
               Object other$blankingRate = other.getBlankingRate();
               if (this$blankingRate == null ? other$blankingRate == null : this$blankingRate.equals(other$blankingRate)) {
                  Object this$assembleRate = this.getAssembleRate();
                  Object other$assembleRate = other.getAssembleRate();
                  if (this$assembleRate == null ? other$assembleRate == null : this$assembleRate.equals(other$assembleRate)) {
                     Object this$buriedArcRate = this.getBuriedArcRate();
                     Object other$buriedArcRate = other.getBuriedArcRate();
                     if (this$buriedArcRate == null ? other$buriedArcRate == null : this$buriedArcRate.equals(other$buriedArcRate)) {
                        Object this$assemblyRate = this.getAssemblyRate();
                        Object other$assemblyRate = other.getAssemblyRate();
                        if (this$assemblyRate == null ? other$assemblyRate == null : this$assemblyRate.equals(other$assemblyRate)) {
                           Object this$solderingRate = this.getSolderingRate();
                           Object other$solderingRate = other.getSolderingRate();
                           if (this$solderingRate == null ? other$solderingRate == null : this$solderingRate.equals(other$solderingRate)) {
                              Object this$grindingRate = this.getGrindingRate();
                              Object other$grindingRate = other.getGrindingRate();
                              if (this$grindingRate == null ? other$grindingRate == null : this$grindingRate.equals(other$grindingRate)) {
                                 Object this$liveryRate = this.getLiveryRate();
                                 Object other$liveryRate = other.getLiveryRate();
                                 if (this$liveryRate == null ? other$liveryRate == null : this$liveryRate.equals(other$liveryRate)) {
                                    Object this$manufactureRate = this.getManufactureRate();
                                    Object other$manufactureRate = other.getManufactureRate();
                                    return this$manufactureRate == null ? other$manufactureRate == null : this$manufactureRate.equals(other$manufactureRate);
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
      return other instanceof ProjectProcessingProgressDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
      Object $blankingRate = this.getBlankingRate();
      result = result * 59 + ($blankingRate == null ? 43 : $blankingRate.hashCode());
      Object $assembleRate = this.getAssembleRate();
      result = result * 59 + ($assembleRate == null ? 43 : $assembleRate.hashCode());
      Object $buriedArcRate = this.getBuriedArcRate();
      result = result * 59 + ($buriedArcRate == null ? 43 : $buriedArcRate.hashCode());
      Object $assemblyRate = this.getAssemblyRate();
      result = result * 59 + ($assemblyRate == null ? 43 : $assemblyRate.hashCode());
      Object $solderingRate = this.getSolderingRate();
      result = result * 59 + ($solderingRate == null ? 43 : $solderingRate.hashCode());
      Object $grindingRate = this.getGrindingRate();
      result = result * 59 + ($grindingRate == null ? 43 : $grindingRate.hashCode());
      Object $liveryRate = this.getLiveryRate();
      result = result * 59 + ($liveryRate == null ? 43 : $liveryRate.hashCode());
      Object $manufactureRate = this.getManufactureRate();
      return result * 59 + ($manufactureRate == null ? 43 : $manufactureRate.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectProcessingProgressDTO(super="
         + super.toString()
         + ", projectId="
         + this.getProjectId()
         + ", projectName="
         + this.getProjectName()
         + ", totalWeight="
         + this.getTotalWeight()
         + ", blankingRate="
         + this.getBlankingRate()
         + ", assembleRate="
         + this.getAssembleRate()
         + ", buriedArcRate="
         + this.getBuriedArcRate()
         + ", assemblyRate="
         + this.getAssemblyRate()
         + ", solderingRate="
         + this.getSolderingRate()
         + ", grindingRate="
         + this.getGrindingRate()
         + ", liveryRate="
         + this.getLiveryRate()
         + ", manufactureRate="
         + this.getManufactureRate()
         + ")";
   }

   public ProjectProcessingProgressDTO(
      final Long projectId,
      final String projectName,
      final BigDecimal totalWeight,
      final BigDecimal blankingRate,
      final BigDecimal assembleRate,
      final BigDecimal buriedArcRate,
      final BigDecimal assemblyRate,
      final BigDecimal solderingRate,
      final BigDecimal grindingRate,
      final BigDecimal liveryRate,
      final BigDecimal manufactureRate
   ) {
      this.projectId = projectId;
      this.projectName = projectName;
      this.totalWeight = totalWeight;
      this.blankingRate = blankingRate;
      this.assembleRate = assembleRate;
      this.buriedArcRate = buriedArcRate;
      this.assemblyRate = assemblyRate;
      this.solderingRate = solderingRate;
      this.grindingRate = grindingRate;
      this.liveryRate = liveryRate;
      this.manufactureRate = manufactureRate;
   }

   public ProjectProcessingProgressDTO() {
   }

   public static class ProjectProcessingProgressDTOBuilder {
      private Long projectId;
      private String projectName;
      private BigDecimal totalWeight;
      private BigDecimal blankingRate;
      private BigDecimal assembleRate;
      private BigDecimal buriedArcRate;
      private BigDecimal assemblyRate;
      private BigDecimal solderingRate;
      private BigDecimal grindingRate;
      private BigDecimal liveryRate;
      private BigDecimal manufactureRate;

      ProjectProcessingProgressDTOBuilder() {
      }

      @JsonProperty("projectId")
      public ProjectProcessingProgressDTO.ProjectProcessingProgressDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("projectName")
      public ProjectProcessingProgressDTO.ProjectProcessingProgressDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      @JsonProperty("totalWeight")
      public ProjectProcessingProgressDTO.ProjectProcessingProgressDTOBuilder totalWeight(final BigDecimal totalWeight) {
         this.totalWeight = totalWeight;
         return this;
      }

      @JsonProperty("blankingRate")
      public ProjectProcessingProgressDTO.ProjectProcessingProgressDTOBuilder blankingRate(final BigDecimal blankingRate) {
         this.blankingRate = blankingRate;
         return this;
      }

      @JsonProperty("assembleRate")
      public ProjectProcessingProgressDTO.ProjectProcessingProgressDTOBuilder assembleRate(final BigDecimal assembleRate) {
         this.assembleRate = assembleRate;
         return this;
      }

      @JsonProperty("buriedArcRate")
      public ProjectProcessingProgressDTO.ProjectProcessingProgressDTOBuilder buriedArcRate(final BigDecimal buriedArcRate) {
         this.buriedArcRate = buriedArcRate;
         return this;
      }

      @JsonProperty("assemblyRate")
      public ProjectProcessingProgressDTO.ProjectProcessingProgressDTOBuilder assemblyRate(final BigDecimal assemblyRate) {
         this.assemblyRate = assemblyRate;
         return this;
      }

      @JsonProperty("solderingRate")
      public ProjectProcessingProgressDTO.ProjectProcessingProgressDTOBuilder solderingRate(final BigDecimal solderingRate) {
         this.solderingRate = solderingRate;
         return this;
      }

      @JsonProperty("grindingRate")
      public ProjectProcessingProgressDTO.ProjectProcessingProgressDTOBuilder grindingRate(final BigDecimal grindingRate) {
         this.grindingRate = grindingRate;
         return this;
      }

      @JsonProperty("liveryRate")
      public ProjectProcessingProgressDTO.ProjectProcessingProgressDTOBuilder liveryRate(final BigDecimal liveryRate) {
         this.liveryRate = liveryRate;
         return this;
      }

      @JsonProperty("manufactureRate")
      public ProjectProcessingProgressDTO.ProjectProcessingProgressDTOBuilder manufactureRate(final BigDecimal manufactureRate) {
         this.manufactureRate = manufactureRate;
         return this;
      }

      public ProjectProcessingProgressDTO build() {
         return new ProjectProcessingProgressDTO(
            this.projectId,
            this.projectName,
            this.totalWeight,
            this.blankingRate,
            this.assembleRate,
            this.buriedArcRate,
            this.assemblyRate,
            this.solderingRate,
            this.grindingRate,
            this.liveryRate,
            this.manufactureRate
         );
      }

      @Override
      public String toString() {
         return "ProjectProcessingProgressDTO.ProjectProcessingProgressDTOBuilder(projectId="
            + this.projectId
            + ", projectName="
            + this.projectName
            + ", totalWeight="
            + this.totalWeight
            + ", blankingRate="
            + this.blankingRate
            + ", assembleRate="
            + this.assembleRate
            + ", buriedArcRate="
            + this.buriedArcRate
            + ", assemblyRate="
            + this.assemblyRate
            + ", solderingRate="
            + this.solderingRate
            + ", grindingRate="
            + this.grindingRate
            + ", liveryRate="
            + this.liveryRate
            + ", manufactureRate="
            + this.manufactureRate
            + ")";
      }
   }
}
