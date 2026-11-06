package com.hzchum.scim.project.core.api.pojo.dtoParam.save;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@ApiModel("项目管理签证原因 ")
public class ProjectVisaReasonDTOParam {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   @NotBlank(message = "签证原因不能为空")
   @Size(max = 255, message = "字数超出范围")
   private String name;

   public static ProjectVisaReasonDTOParam.ProjectVisaReasonDTOParamBuilder builder() {
      return new ProjectVisaReasonDTOParam.ProjectVisaReasonDTOParamBuilder();
   }

   public ProjectVisaReasonDTOParam() {
   }

   public ProjectVisaReasonDTOParam(final Long id, final String name) {
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
      } else if (!(o instanceof ProjectVisaReasonDTOParam)) {
         return false;
      } else {
         ProjectVisaReasonDTOParam other = (ProjectVisaReasonDTOParam)o;
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
      return other instanceof ProjectVisaReasonDTOParam;
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
      return "ProjectVisaReasonDTOParam(id=" + this.getId() + ", name=" + this.getName() + ")";
   }

   public static class ProjectVisaReasonDTOParamBuilder {
      private Long id;
      private String name;

      ProjectVisaReasonDTOParamBuilder() {
      }

      public ProjectVisaReasonDTOParam.ProjectVisaReasonDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectVisaReasonDTOParam.ProjectVisaReasonDTOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ProjectVisaReasonDTOParam build() {
         return new ProjectVisaReasonDTOParam(this.id, this.name);
      }

      @Override
      public String toString() {
         return "ProjectVisaReasonDTOParam.ProjectVisaReasonDTOParamBuilder(id=" + this.id + ", name=" + this.name + ")";
      }
   }
}
