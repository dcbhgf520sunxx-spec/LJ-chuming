package com.hzchum.scim.mes.building.core.api.pojo._do.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ProjectProductionDO", description = "项目生产信息")
public class ProjectProductionDO {
   @ApiModelProperty(name = "project", value = "项目信息", notes = "项目信息")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "production", value = "产量", notes = "产量")
   @JsonProperty("production")
   @JSONField(name = "production")
   private BigDecimal production;

   public static ProjectProductionDO.ProjectProductionDOBuilder builder() {
      return new ProjectProductionDO.ProjectProductionDOBuilder();
   }

   public ProjectProductionDO(final ProjectDetailDO project, final BigDecimal production) {
      this.project = project;
      this.production = production;
   }

   public ProjectProductionDO() {
   }

   public ProjectDetailDO getProject() {
      return this.project;
   }

   public BigDecimal getProduction() {
      return this.production;
   }

   @JsonProperty("project")
   public ProjectProductionDO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("production")
   public ProjectProductionDO setProduction(final BigDecimal production) {
      this.production = production;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectProductionDO(project=" + this.getProject() + ", production=" + this.getProduction() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProjectProductionDO)) {
         return false;
      } else {
         ProjectProductionDO other = (ProjectProductionDO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$project = this.getProject();
            Object other$project = other.getProject();
            if (this$project == null ? other$project == null : this$project.equals(other$project)) {
               Object this$production = this.getProduction();
               Object other$production = other.getProduction();
               return this$production == null ? other$production == null : this$production.equals(other$production);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectProductionDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $production = this.getProduction();
      return result * 59 + ($production == null ? 43 : $production.hashCode());
   }

   public static class ProjectProductionDOBuilder {
      private ProjectDetailDO project;
      private BigDecimal production;

      ProjectProductionDOBuilder() {
      }

      @JsonProperty("project")
      public ProjectProductionDO.ProjectProductionDOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("production")
      public ProjectProductionDO.ProjectProductionDOBuilder production(final BigDecimal production) {
         this.production = production;
         return this;
      }

      public ProjectProductionDO build() {
         return new ProjectProductionDO(this.project, this.production);
      }

      @Override
      public String toString() {
         return "ProjectProductionDO.ProjectProductionDOBuilder(project=" + this.project + ", production=" + this.production + ")";
      }
   }
}
