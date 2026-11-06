package com.hzchum.scim.project.core.api.pojo.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Table;

@ApiModel(value = "ProjectQhseProblemType对象", description = "质安问题类型表 ")
@Table(appliesTo = "project_qhse_problem_type", comment = "质安问题类型表 ")
public class ProjectQhseProblemTypeDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", value = "类型名称", notes = "类型名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;

   public static ProjectQhseProblemTypeDTO.ProjectQhseProblemTypeDTOBuilder builder() {
      return new ProjectQhseProblemTypeDTO.ProjectQhseProblemTypeDTOBuilder();
   }

   public ProjectQhseProblemTypeDTO() {
   }

   public ProjectQhseProblemTypeDTO(final Long id, final String name) {
      this.id = id;
      this.name = name;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   @JsonProperty("id")
   public void setId(final Long id) {
      this.id = id;
   }

   @JsonProperty("name")
   public void setName(final String name) {
      this.name = name;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProjectQhseProblemTypeDTO)) {
         return false;
      } else {
         ProjectQhseProblemTypeDTO other = (ProjectQhseProblemTypeDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               return this$name == null ? other$name == null : this$name.equals(other$name);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectQhseProblemTypeDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectQhseProblemTypeDTO(id=" + this.getId() + ", name=" + this.getName() + ")";
   }

   public static class ProjectQhseProblemTypeDTOBuilder {
      private Long id;
      private String name;

      ProjectQhseProblemTypeDTOBuilder() {
      }

      @JsonProperty("id")
      public ProjectQhseProblemTypeDTO.ProjectQhseProblemTypeDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public ProjectQhseProblemTypeDTO.ProjectQhseProblemTypeDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ProjectQhseProblemTypeDTO build() {
         return new ProjectQhseProblemTypeDTO(this.id, this.name);
      }

      @Override
      public String toString() {
         return "ProjectQhseProblemTypeDTO.ProjectQhseProblemTypeDTOBuilder(id=" + this.id + ", name=" + this.name + ")";
      }
   }
}
