package com.hzchum.scim.operational.analysis.core.api.pojo._dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ProjectProductionDTO", description = "项目生产信息")
public class ProjectProductionDTO {
   @ApiModelProperty(name = "project", value = "项目信息", notes = "项目信息")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "production", value = "产量", notes = "产量")
   @JsonProperty("production")
   @JSONField(name = "production")
   private BigDecimal production;
   @ApiModelProperty(name = "amountOfUsage", value = "使用量", notes = "使用量")
   @JsonProperty("amountOfUsage")
   @JSONField(name = "amountOfUsage")
   private BigDecimal amountOfUsage;
   @ApiModelProperty(name = "difference", value = "差异", notes = "差异")
   @JsonProperty("difference")
   @JSONField(name = "difference")
   private BigDecimal difference;
   @ApiModelProperty(name = "differenceRatio", value = "差异率", notes = "差异率")
   @JsonProperty("differenceRatio")
   @JSONField(name = "differenceRatio")
   private BigDecimal differenceRatio;

   public static ProjectProductionDTO.ProjectProductionDTOBuilder builder() {
      return new ProjectProductionDTO.ProjectProductionDTOBuilder();
   }

   public ProjectProductionDTO(
      final ProjectDetailDO project, final BigDecimal production, final BigDecimal amountOfUsage, final BigDecimal difference, final BigDecimal differenceRatio
   ) {
      this.project = project;
      this.production = production;
      this.amountOfUsage = amountOfUsage;
      this.difference = difference;
      this.differenceRatio = differenceRatio;
   }

   public ProjectProductionDTO() {
   }

   public ProjectDetailDO getProject() {
      return this.project;
   }

   public BigDecimal getProduction() {
      return this.production;
   }

   public BigDecimal getAmountOfUsage() {
      return this.amountOfUsage;
   }

   public BigDecimal getDifference() {
      return this.difference;
   }

   public BigDecimal getDifferenceRatio() {
      return this.differenceRatio;
   }

   @JsonProperty("project")
   public ProjectProductionDTO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("production")
   public ProjectProductionDTO setProduction(final BigDecimal production) {
      this.production = production;
      return this;
   }

   @JsonProperty("amountOfUsage")
   public ProjectProductionDTO setAmountOfUsage(final BigDecimal amountOfUsage) {
      this.amountOfUsage = amountOfUsage;
      return this;
   }

   @JsonProperty("difference")
   public ProjectProductionDTO setDifference(final BigDecimal difference) {
      this.difference = difference;
      return this;
   }

   @JsonProperty("differenceRatio")
   public ProjectProductionDTO setDifferenceRatio(final BigDecimal differenceRatio) {
      this.differenceRatio = differenceRatio;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectProductionDTO(project="
         + this.getProject()
         + ", production="
         + this.getProduction()
         + ", amountOfUsage="
         + this.getAmountOfUsage()
         + ", difference="
         + this.getDifference()
         + ", differenceRatio="
         + this.getDifferenceRatio()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectProductionDTO)) {
         return false;
      }

      ProjectProductionDTO other = (ProjectProductionDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$project = this.getProject();
      Object other$project = other.getProject();
      if (this$project == null ? other$project == null : this$project.equals(other$project)) {
         Object this$production = this.getProduction();
         Object other$production = other.getProduction();
         if (this$production == null ? other$production == null : this$production.equals(other$production)) {
            Object this$amountOfUsage = this.getAmountOfUsage();
            Object other$amountOfUsage = other.getAmountOfUsage();
            if (this$amountOfUsage == null ? other$amountOfUsage == null : this$amountOfUsage.equals(other$amountOfUsage)) {
               Object this$difference = this.getDifference();
               Object other$difference = other.getDifference();
               if (this$difference == null ? other$difference == null : this$difference.equals(other$difference)) {
                  Object this$differenceRatio = this.getDifferenceRatio();
                  Object other$differenceRatio = other.getDifferenceRatio();
                  return this$differenceRatio == null ? other$differenceRatio == null : this$differenceRatio.equals(other$differenceRatio);
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
      return other instanceof ProjectProductionDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $production = this.getProduction();
      result = result * 59 + ($production == null ? 43 : $production.hashCode());
      Object $amountOfUsage = this.getAmountOfUsage();
      result = result * 59 + ($amountOfUsage == null ? 43 : $amountOfUsage.hashCode());
      Object $difference = this.getDifference();
      result = result * 59 + ($difference == null ? 43 : $difference.hashCode());
      Object $differenceRatio = this.getDifferenceRatio();
      return result * 59 + ($differenceRatio == null ? 43 : $differenceRatio.hashCode());
   }

   public static class ProjectProductionDTOBuilder {
      private ProjectDetailDO project;
      private BigDecimal production;
      private BigDecimal amountOfUsage;
      private BigDecimal difference;
      private BigDecimal differenceRatio;

      ProjectProductionDTOBuilder() {
      }

      @JsonProperty("project")
      public ProjectProductionDTO.ProjectProductionDTOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("production")
      public ProjectProductionDTO.ProjectProductionDTOBuilder production(final BigDecimal production) {
         this.production = production;
         return this;
      }

      @JsonProperty("amountOfUsage")
      public ProjectProductionDTO.ProjectProductionDTOBuilder amountOfUsage(final BigDecimal amountOfUsage) {
         this.amountOfUsage = amountOfUsage;
         return this;
      }

      @JsonProperty("difference")
      public ProjectProductionDTO.ProjectProductionDTOBuilder difference(final BigDecimal difference) {
         this.difference = difference;
         return this;
      }

      @JsonProperty("differenceRatio")
      public ProjectProductionDTO.ProjectProductionDTOBuilder differenceRatio(final BigDecimal differenceRatio) {
         this.differenceRatio = differenceRatio;
         return this;
      }

      public ProjectProductionDTO build() {
         return new ProjectProductionDTO(this.project, this.production, this.amountOfUsage, this.difference, this.differenceRatio);
      }

      @Override
      public String toString() {
         return "ProjectProductionDTO.ProjectProductionDTOBuilder(project="
            + this.project
            + ", production="
            + this.production
            + ", amountOfUsage="
            + this.amountOfUsage
            + ", difference="
            + this.difference
            + ", differenceRatio="
            + this.differenceRatio
            + ")";
      }
   }
}
