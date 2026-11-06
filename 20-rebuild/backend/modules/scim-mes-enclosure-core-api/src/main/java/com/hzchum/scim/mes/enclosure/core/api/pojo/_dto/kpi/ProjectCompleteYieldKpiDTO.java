package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.kpi;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.ProjectDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ProjectCompleteYieldKpiDTO", description = "每月产量kpi")
public class ProjectCompleteYieldKpiDTO {
   @ApiModelProperty(name = "project", notes = "项目信息", value = "项目信息")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "totalNetWeight", notes = "清单量", value = "清单量")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "yield", notes = "产量", value = "产量")
   @JsonProperty("yield")
   @JSONField(name = "yield")
   private BigDecimal yield;
   @ApiModelProperty(name = "despatchAmount", notes = "发运量", value = "发运量")
   @JsonProperty("despatchAmount")
   @JSONField(name = "despatchAmount")
   private BigDecimal despatchAmount;

   public static ProjectCompleteYieldKpiDTO.ProjectCompleteYieldKpiDTOBuilder builder() {
      return new ProjectCompleteYieldKpiDTO.ProjectCompleteYieldKpiDTOBuilder();
   }

   public ProjectCompleteYieldKpiDTO(final ProjectDetailDO project, final BigDecimal totalNetWeight, final BigDecimal yield, final BigDecimal despatchAmount) {
      this.project = project;
      this.totalNetWeight = totalNetWeight;
      this.yield = yield;
      this.despatchAmount = despatchAmount;
   }

   public ProjectCompleteYieldKpiDTO() {
   }

   public ProjectDetailDO getProject() {
      return this.project;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getYield() {
      return this.yield;
   }

   public BigDecimal getDespatchAmount() {
      return this.despatchAmount;
   }

   @JsonProperty("project")
   public ProjectCompleteYieldKpiDTO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public ProjectCompleteYieldKpiDTO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("yield")
   public ProjectCompleteYieldKpiDTO setYield(final BigDecimal yield) {
      this.yield = yield;
      return this;
   }

   @JsonProperty("despatchAmount")
   public ProjectCompleteYieldKpiDTO setDespatchAmount(final BigDecimal despatchAmount) {
      this.despatchAmount = despatchAmount;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectCompleteYieldKpiDTO(project="
         + this.getProject()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", yield="
         + this.getYield()
         + ", despatchAmount="
         + this.getDespatchAmount()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectCompleteYieldKpiDTO)) {
         return false;
      }

      ProjectCompleteYieldKpiDTO other = (ProjectCompleteYieldKpiDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$project = this.getProject();
      Object other$project = other.getProject();
      if (this$project == null ? other$project == null : this$project.equals(other$project)) {
         Object this$totalNetWeight = this.getTotalNetWeight();
         Object other$totalNetWeight = other.getTotalNetWeight();
         if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
            Object this$yield = this.getYield();
            Object other$yield = other.getYield();
            if (this$yield == null ? other$yield == null : this$yield.equals(other$yield)) {
               Object this$despatchAmount = this.getDespatchAmount();
               Object other$despatchAmount = other.getDespatchAmount();
               return this$despatchAmount == null ? other$despatchAmount == null : this$despatchAmount.equals(other$despatchAmount);
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
      return other instanceof ProjectCompleteYieldKpiDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $yield = this.getYield();
      result = result * 59 + ($yield == null ? 43 : $yield.hashCode());
      Object $despatchAmount = this.getDespatchAmount();
      return result * 59 + ($despatchAmount == null ? 43 : $despatchAmount.hashCode());
   }

   public static class ProjectCompleteYieldKpiDTOBuilder {
      private ProjectDetailDO project;
      private BigDecimal totalNetWeight;
      private BigDecimal yield;
      private BigDecimal despatchAmount;

      ProjectCompleteYieldKpiDTOBuilder() {
      }

      @JsonProperty("project")
      public ProjectCompleteYieldKpiDTO.ProjectCompleteYieldKpiDTOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public ProjectCompleteYieldKpiDTO.ProjectCompleteYieldKpiDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("yield")
      public ProjectCompleteYieldKpiDTO.ProjectCompleteYieldKpiDTOBuilder yield(final BigDecimal yield) {
         this.yield = yield;
         return this;
      }

      @JsonProperty("despatchAmount")
      public ProjectCompleteYieldKpiDTO.ProjectCompleteYieldKpiDTOBuilder despatchAmount(final BigDecimal despatchAmount) {
         this.despatchAmount = despatchAmount;
         return this;
      }

      public ProjectCompleteYieldKpiDTO build() {
         return new ProjectCompleteYieldKpiDTO(this.project, this.totalNetWeight, this.yield, this.despatchAmount);
      }

      @Override
      public String toString() {
         return "ProjectCompleteYieldKpiDTO.ProjectCompleteYieldKpiDTOBuilder(project="
            + this.project
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", yield="
            + this.yield
            + ", despatchAmount="
            + this.despatchAmount
            + ")";
      }
   }
}
