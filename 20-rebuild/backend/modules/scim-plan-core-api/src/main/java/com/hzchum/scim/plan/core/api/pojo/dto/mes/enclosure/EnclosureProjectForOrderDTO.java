package com.hzchum.scim.plan.core.api.pojo.dto.mes.enclosure;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(Include.NON_NULL)
@ApiModel(value = "EnclosureProjectForOrderDTO", description = "围护工单项目统计返回类")
public class EnclosureProjectForOrderDTO {
   @ApiModelProperty(name = "project", value = "项目信息")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectInfo project;

   public static EnclosureProjectForOrderDTO.EnclosureProjectForOrderDTOBuilder builder() {
      return new EnclosureProjectForOrderDTO.EnclosureProjectForOrderDTOBuilder();
   }

   public EnclosureProjectForOrderDTO() {
   }

   public EnclosureProjectForOrderDTO(final ProjectInfo project) {
      this.project = project;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   @JsonProperty("project")
   public EnclosureProjectForOrderDTO setProject(final ProjectInfo project) {
      this.project = project;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosureProjectForOrderDTO)) {
         return false;
      }

      EnclosureProjectForOrderDTO other = (EnclosureProjectForOrderDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$project = this.getProject();
      Object other$project = other.getProject();
      return this$project == null ? other$project == null : this$project.equals(other$project);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof EnclosureProjectForOrderDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $project = this.getProject();
      return result * 59 + ($project == null ? 43 : $project.hashCode());
   }

   @Override
   public String toString() {
      return "EnclosureProjectForOrderDTO(project=" + this.getProject() + ")";
   }

   public static class EnclosureProjectForOrderDTOBuilder {
      private ProjectInfo project;

      EnclosureProjectForOrderDTOBuilder() {
      }

      @JsonProperty("project")
      public EnclosureProjectForOrderDTO.EnclosureProjectForOrderDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public EnclosureProjectForOrderDTO build() {
         return new EnclosureProjectForOrderDTO(this.project);
      }

      @Override
      public String toString() {
         return "EnclosureProjectForOrderDTO.EnclosureProjectForOrderDTOBuilder(project=" + this.project + ")";
      }
   }
}
