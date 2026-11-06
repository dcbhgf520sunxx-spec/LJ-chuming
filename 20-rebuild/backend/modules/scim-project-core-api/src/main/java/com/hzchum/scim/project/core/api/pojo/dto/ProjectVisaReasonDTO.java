package com.hzchum.scim.project.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ProjectVisaReason对象DTO", description = "项目管理签证原因表 ")
public class ProjectVisaReasonDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   private String name;

   public static ProjectVisaReasonDTO.ProjectVisaReasonDTOBuilder builder() {
      return new ProjectVisaReasonDTO.ProjectVisaReasonDTOBuilder();
   }

   public ProjectVisaReasonDTO() {
   }

   public ProjectVisaReasonDTO(final Long id, final String name) {
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
      } else if (!(o instanceof ProjectVisaReasonDTO)) {
         return false;
      } else {
         ProjectVisaReasonDTO other = (ProjectVisaReasonDTO)o;
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
      return other instanceof ProjectVisaReasonDTO;
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
      return "ProjectVisaReasonDTO(id=" + this.getId() + ", name=" + this.getName() + ")";
   }

   public static class ProjectVisaReasonDTOBuilder {
      private Long id;
      private String name;

      ProjectVisaReasonDTOBuilder() {
      }

      public ProjectVisaReasonDTO.ProjectVisaReasonDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectVisaReasonDTO.ProjectVisaReasonDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ProjectVisaReasonDTO build() {
         return new ProjectVisaReasonDTO(this.id, this.name);
      }

      @Override
      public String toString() {
         return "ProjectVisaReasonDTO.ProjectVisaReasonDTOBuilder(id=" + this.id + ", name=" + this.name + ")";
      }
   }
}
