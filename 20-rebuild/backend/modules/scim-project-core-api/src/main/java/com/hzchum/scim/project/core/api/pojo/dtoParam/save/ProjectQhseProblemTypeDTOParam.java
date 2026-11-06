package com.hzchum.scim.project.core.api.pojo.dtoParam.save;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Table;

@ApiModel("质安问题类型新增类")
@Table(appliesTo = "project_qhse_problem_type", comment = "质安问题类型表 ")
public class ProjectQhseProblemTypeDTOParam {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "name", value = "类型名称", notes = "类型名称")
   @NotBlank(message = "质安问题类型名称不能为空")
   @Size(max = 100, message = "名称长度过长!")
   private String name;

   public static ProjectQhseProblemTypeDTOParam.ProjectQhseProblemTypeDTOParamBuilder builder() {
      return new ProjectQhseProblemTypeDTOParam.ProjectQhseProblemTypeDTOParamBuilder();
   }

   public ProjectQhseProblemTypeDTOParam() {
   }

   public ProjectQhseProblemTypeDTOParam(final Long id, final String name) {
      this.id = id;
      this.name = name;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProjectQhseProblemTypeDTOParam)) {
         return false;
      } else {
         ProjectQhseProblemTypeDTOParam other = (ProjectQhseProblemTypeDTOParam)o;
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
      return other instanceof ProjectQhseProblemTypeDTOParam;
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
      return "ProjectQhseProblemTypeDTOParam(id=" + this.getId() + ", name=" + this.getName() + ")";
   }

   public static class ProjectQhseProblemTypeDTOParamBuilder {
      private Long id;
      private String name;

      ProjectQhseProblemTypeDTOParamBuilder() {
      }

      public ProjectQhseProblemTypeDTOParam.ProjectQhseProblemTypeDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectQhseProblemTypeDTOParam.ProjectQhseProblemTypeDTOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ProjectQhseProblemTypeDTOParam build() {
         return new ProjectQhseProblemTypeDTOParam(this.id, this.name);
      }

      @Override
      public String toString() {
         return "ProjectQhseProblemTypeDTOParam.ProjectQhseProblemTypeDTOParamBuilder(id=" + this.id + ", name=" + this.name + ")";
      }
   }
}
